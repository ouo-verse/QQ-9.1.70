package rx.internal.producers;

import rx.Producer;

/* loaded from: classes29.dex */
public final class ProducerArbiter implements Producer {
    static final Producer NULL_PRODUCER = new Producer() { // from class: rx.internal.producers.ProducerArbiter.1
        @Override // rx.Producer
        public void request(long j3) {
        }
    };
    Producer currentProducer;
    boolean emitting;
    long missedProduced;
    Producer missedProducer;
    long missedRequested;
    long requested;

    public void emitLoop() {
        while (true) {
            synchronized (this) {
                long j3 = this.missedRequested;
                long j16 = this.missedProduced;
                Producer producer = this.missedProducer;
                if (j3 == 0 && j16 == 0 && producer == null) {
                    this.emitting = false;
                    return;
                }
                this.missedRequested = 0L;
                this.missedProduced = 0L;
                this.missedProducer = null;
                long j17 = this.requested;
                if (j17 != Long.MAX_VALUE) {
                    long j18 = j17 + j3;
                    if (j18 >= 0 && j18 != Long.MAX_VALUE) {
                        j17 = j18 - j16;
                        if (j17 >= 0) {
                            this.requested = j17;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    } else {
                        this.requested = Long.MAX_VALUE;
                        j17 = Long.MAX_VALUE;
                    }
                }
                if (producer != null) {
                    if (producer == NULL_PRODUCER) {
                        this.currentProducer = null;
                    } else {
                        this.currentProducer = producer;
                        producer.request(j17);
                    }
                } else {
                    Producer producer2 = this.currentProducer;
                    if (producer2 != null && j3 != 0) {
                        producer2.request(j3);
                    }
                }
            }
        }
    }

    public void produced(long j3) {
        if (j3 > 0) {
            synchronized (this) {
                if (this.emitting) {
                    this.missedProduced += j3;
                    return;
                }
                this.emitting = true;
                try {
                    long j16 = this.requested;
                    if (j16 != Long.MAX_VALUE) {
                        long j17 = j16 - j3;
                        if (j17 >= 0) {
                            this.requested = j17;
                        } else {
                            throw new IllegalStateException("more items arrived than were requested");
                        }
                    }
                    emitLoop();
                    return;
                } catch (Throwable th5) {
                    synchronized (this) {
                        this.emitting = false;
                        throw th5;
                    }
                }
            }
        }
        throw new IllegalArgumentException("n > 0 required");
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
                try {
                    long j16 = this.requested + j3;
                    if (j16 < 0) {
                        j16 = Long.MAX_VALUE;
                    }
                    this.requested = j16;
                    Producer producer = this.currentProducer;
                    if (producer != null) {
                        producer.request(j3);
                    }
                    emitLoop();
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
            try {
                this.currentProducer = producer;
                if (producer != null) {
                    producer.request(this.requested);
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
}
