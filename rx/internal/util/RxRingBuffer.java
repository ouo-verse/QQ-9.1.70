package rx.internal.util;

import java.util.Queue;
import rx.Observer;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.unsafe.SpmcArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RxRingBuffer implements Subscription {
    private static final NotificationLite<Object> ON = NotificationLite.instance();
    public static final int SIZE;
    public static final ObjectPool<Queue<Object>> SPMC_POOL;
    public static final ObjectPool<Queue<Object>> SPSC_POOL;
    static int defaultSize;
    private final ObjectPool<Queue<Object>> pool;
    private Queue<Object> queue;
    private final int size;
    public volatile Object terminalState;

    static {
        defaultSize = 128;
        if (PlatformDependent.isAndroid()) {
            defaultSize = 16;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                defaultSize = Integer.parseInt(property);
            } catch (NumberFormatException e16) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e16.getMessage());
            }
        }
        SIZE = defaultSize;
        SPSC_POOL = new ObjectPool<Queue<Object>>() { // from class: rx.internal.util.RxRingBuffer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // rx.internal.util.ObjectPool
            public Queue<Object> createObject() {
                return new SpscArrayQueue(RxRingBuffer.SIZE);
            }
        };
        SPMC_POOL = new ObjectPool<Queue<Object>>() { // from class: rx.internal.util.RxRingBuffer.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // rx.internal.util.ObjectPool
            public Queue<Object> createObject() {
                return new SpmcArrayQueue(RxRingBuffer.SIZE);
            }
        };
    }

    RxRingBuffer(Queue<Object> queue, int i3) {
        this.queue = queue;
        this.pool = null;
        this.size = i3;
    }

    public static RxRingBuffer getSpmcInstance() {
        if (UnsafeAccess.isUnsafeAvailable()) {
            return new RxRingBuffer(SPMC_POOL, SIZE);
        }
        return new RxRingBuffer();
    }

    public static RxRingBuffer getSpscInstance() {
        if (UnsafeAccess.isUnsafeAvailable()) {
            return new RxRingBuffer(SPSC_POOL, SIZE);
        }
        return new RxRingBuffer();
    }

    public boolean accept(Object obj, Observer observer) {
        return ON.accept(observer, obj);
    }

    public Throwable asError(Object obj) {
        return ON.getError(obj);
    }

    public int available() {
        return this.size - count();
    }

    public int capacity() {
        return this.size;
    }

    public int count() {
        Queue<Object> queue = this.queue;
        if (queue == null) {
            return 0;
        }
        return queue.size();
    }

    public Object getValue(Object obj) {
        return ON.getValue(obj);
    }

    public boolean isCompleted(Object obj) {
        return ON.isCompleted(obj);
    }

    public boolean isEmpty() {
        Queue<Object> queue = this.queue;
        if (queue == null) {
            return true;
        }
        return queue.isEmpty();
    }

    public boolean isError(Object obj) {
        return ON.isError(obj);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        if (this.queue == null) {
            return true;
        }
        return false;
    }

    public void onCompleted() {
        if (this.terminalState == null) {
            this.terminalState = ON.completed();
        }
    }

    public void onError(Throwable th5) {
        if (this.terminalState == null) {
            this.terminalState = ON.error(th5);
        }
    }

    public void onNext(Object obj) throws MissingBackpressureException {
        boolean z16;
        boolean z17;
        synchronized (this) {
            Queue<Object> queue = this.queue;
            z16 = true;
            z17 = false;
            if (queue != null) {
                z16 = false;
                z17 = !queue.offer(ON.next(obj));
            }
        }
        if (!z16) {
            if (!z17) {
                return;
            } else {
                throw new MissingBackpressureException();
            }
        }
        throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
    }

    public Object peek() {
        synchronized (this) {
            Queue<Object> queue = this.queue;
            if (queue == null) {
                return null;
            }
            Object peek = queue.peek();
            Object obj = this.terminalState;
            if (peek == null && obj != null && queue.peek() == null) {
                peek = obj;
            }
            return peek;
        }
    }

    public Object poll() {
        synchronized (this) {
            Queue<Object> queue = this.queue;
            if (queue == null) {
                return null;
            }
            Object poll = queue.poll();
            Object obj = this.terminalState;
            if (poll == null && obj != null && queue.peek() == null) {
                this.terminalState = null;
                poll = obj;
            }
            return poll;
        }
    }

    public synchronized void release() {
        Queue<Object> queue = this.queue;
        ObjectPool<Queue<Object>> objectPool = this.pool;
        if (objectPool != null && queue != null) {
            queue.clear();
            this.queue = null;
            objectPool.returnObject(queue);
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        release();
    }

    RxRingBuffer(ObjectPool<Queue<Object>> objectPool, int i3) {
        this.pool = objectPool;
        this.queue = objectPool.borrowObject();
        this.size = i3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    RxRingBuffer() {
        this(new SynchronizedQueue(r1), r1);
        int i3 = SIZE;
    }
}
