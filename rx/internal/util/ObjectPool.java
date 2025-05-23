package rx.internal.util;

import androidx.lifecycle.c;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.GenericScheduledExecutorService;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.util.unsafe.MpmcArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;

/* loaded from: classes29.dex */
public abstract class ObjectPool<T> implements SchedulerLifecycle {
    final int maxSize;
    final int minSize;
    private final AtomicReference<Future<?>> periodicTask;
    Queue<T> pool;
    private final long validationInterval;

    public ObjectPool() {
        this(0, 0, 67L);
    }

    private void initialize(int i3) {
        if (UnsafeAccess.isUnsafeAvailable()) {
            this.pool = new MpmcArrayQueue(Math.max(this.maxSize, 1024));
        } else {
            this.pool = new ConcurrentLinkedQueue();
        }
        for (int i16 = 0; i16 < i3; i16++) {
            this.pool.add(createObject());
        }
    }

    public T borrowObject() {
        T poll = this.pool.poll();
        if (poll == null) {
            return createObject();
        }
        return poll;
    }

    protected abstract T createObject();

    public void returnObject(T t16) {
        if (t16 == null) {
            return;
        }
        this.pool.offer(t16);
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        Future<?> andSet = this.periodicTask.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(false);
        }
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        while (this.periodicTask.get() == null) {
            ScheduledExecutorService genericScheduledExecutorService = GenericScheduledExecutorService.getInstance();
            try {
                Runnable runnable = new Runnable() { // from class: rx.internal.util.ObjectPool.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int size = ObjectPool.this.pool.size();
                        ObjectPool objectPool = ObjectPool.this;
                        int i3 = 0;
                        if (size < objectPool.minSize) {
                            int i16 = objectPool.maxSize - size;
                            while (i3 < i16) {
                                ObjectPool objectPool2 = ObjectPool.this;
                                objectPool2.pool.add(objectPool2.createObject());
                                i3++;
                            }
                            return;
                        }
                        int i17 = objectPool.maxSize;
                        if (size > i17) {
                            int i18 = size - i17;
                            while (i3 < i18) {
                                ObjectPool.this.pool.poll();
                                i3++;
                            }
                        }
                    }
                };
                long j3 = this.validationInterval;
                ScheduledFuture<?> scheduleAtFixedRate = genericScheduledExecutorService.scheduleAtFixedRate(runnable, j3, j3, TimeUnit.SECONDS);
                if (!c.a(this.periodicTask, null, scheduleAtFixedRate)) {
                    scheduleAtFixedRate.cancel(false);
                } else {
                    return;
                }
            } catch (RejectedExecutionException e16) {
                RxJavaHooks.onError(e16);
                return;
            }
        }
    }

    ObjectPool(int i3, int i16, long j3) {
        this.minSize = i3;
        this.maxSize = i16;
        this.validationInterval = j3;
        this.periodicTask = new AtomicReference<>();
        initialize(i3);
        start();
    }
}
