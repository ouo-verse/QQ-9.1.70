package rx.internal.producers;

import java.util.ArrayList;
import java.util.List;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;

/* loaded from: classes29.dex */
public final class ProducerObserverArbiter<T> implements Producer, Observer<T> {
    static final Producer NULL_PRODUCER = new Producer() { // from class: rx.internal.producers.ProducerObserverArbiter.1
        @Override // rx.Producer
        public void request(long j3) {
        }
    };
    final Subscriber<? super T> child;
    Producer currentProducer;
    boolean emitting;
    volatile boolean hasError;
    Producer missedProducer;
    long missedRequested;
    Object missedTerminal;
    List<T> queue;
    long requested;

    public ProducerObserverArbiter(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0009, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void emitLoop() {
        long j3;
        Producer producer;
        Object obj;
        List<T> list;
        boolean z16;
        boolean z17;
        long j16;
        Subscriber<? super T> subscriber = this.child;
        Producer producer2 = null;
        long j17 = 0;
        while (true) {
            synchronized (this) {
                j3 = this.missedRequested;
                producer = this.missedProducer;
                obj = this.missedTerminal;
                list = this.queue;
                z16 = true;
                if (j3 == 0 && producer == null && list == null && obj == null) {
                    this.emitting = false;
                    z17 = true;
                } else {
                    this.missedRequested = 0L;
                    this.missedProducer = null;
                    this.queue = null;
                    this.missedTerminal = null;
                    z17 = false;
                }
            }
            if (z17) {
                if (j17 != 0 && producer2 != null) {
                    producer2.request(j17);
                    return;
                }
                return;
            }
            if (list != null && !list.isEmpty()) {
                z16 = false;
            }
            if (obj != null) {
                if (obj != Boolean.TRUE) {
                    subscriber.onError((Throwable) obj);
                    return;
                } else if (z16) {
                    subscriber.onCompleted();
                    return;
                }
            }
            if (list != null) {
                for (T t16 : list) {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    if (this.hasError) {
                        break;
                    }
                    try {
                        subscriber.onNext(t16);
                    } catch (Throwable th5) {
                        Exceptions.throwOrReport(th5, subscriber, t16);
                        return;
                    }
                }
                j16 = list.size() + 0;
            } else {
                j16 = 0;
            }
            long j18 = this.requested;
            if (j18 != Long.MAX_VALUE) {
                if (j3 != 0) {
                    j18 += j3;
                    if (j18 < 0) {
                        j18 = Long.MAX_VALUE;
                    }
                }
                if (j16 != 0 && j18 != Long.MAX_VALUE) {
                    j18 -= j16;
                    if (j18 < 0) {
                        throw new IllegalStateException("More produced than requested");
                    }
                }
                this.requested = j18;
            }
            if (producer != null) {
                if (producer == NULL_PRODUCER) {
                    this.currentProducer = null;
                } else {
                    this.currentProducer = producer;
                    if (j18 != 0) {
                        j17 = BackpressureUtils.addCap(j17, j18);
                        producer2 = producer;
                    }
                }
            } else {
                producer = this.currentProducer;
                if (producer != null && j3 != 0) {
                    j17 = BackpressureUtils.addCap(j17, j3);
                    producer2 = producer;
                }
            }
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = Boolean.TRUE;
            } else {
                this.emitting = true;
                this.child.onCompleted();
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        boolean z16;
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = th5;
                z16 = false;
            } else {
                this.emitting = true;
                z16 = true;
            }
        }
        if (z16) {
            this.child.onError(th5);
        } else {
            this.hasError = true;
        }
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        synchronized (this) {
            if (this.emitting) {
                List list = this.queue;
                if (list == null) {
                    list = new ArrayList(4);
                    this.queue = list;
                }
                list.add(t16);
                return;
            }
            this.emitting = true;
            try {
                this.child.onNext(t16);
                long j3 = this.requested;
                if (j3 != Long.MAX_VALUE) {
                    this.requested = j3 - 1;
                }
                emitLoop();
            } catch (Throwable th5) {
                synchronized (this) {
                    this.emitting = false;
                    throw th5;
                }
            }
        }
    }

    @Override // rx.Producer
    public void request(long j3) {
        if (j3 >= 0) {
            if (j3 == 0) {
                return;
            }
            synchronized (this) {
                if (this.emitting) {
                    this.missedRequested += j3;
                    return;
                }
                this.emitting = true;
                Producer producer = this.currentProducer;
                try {
                    long j16 = this.requested + j3;
                    if (j16 < 0) {
                        j16 = Long.MAX_VALUE;
                    }
                    this.requested = j16;
                    emitLoop();
                    if (producer != null) {
                        producer.request(j3);
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    synchronized (this) {
                        this.emitting = false;
                        throw th5;
                    }
                }
            }
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public void setProducer(Producer producer) {
        synchronized (this) {
            if (this.emitting) {
                if (producer == null) {
                    producer = NULL_PRODUCER;
                }
                this.missedProducer = producer;
                return;
            }
            this.emitting = true;
            this.currentProducer = producer;
            long j3 = this.requested;
            try {
                emitLoop();
                if (producer != null && j3 != 0) {
                    producer.request(j3);
                }
            } catch (Throwable th5) {
                synchronized (this) {
                    this.emitting = false;
                    throw th5;
                }
            }
        }
    }
}
