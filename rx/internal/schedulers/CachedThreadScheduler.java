package rx.internal.schedulers;

import androidx.lifecycle.c;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CachedThreadScheduler extends Scheduler implements SchedulerLifecycle {
    private static final long KEEP_ALIVE_TIME = 60;
    private static final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    static final CachedWorkerPool NONE;
    static final ThreadWorker SHUTDOWN_THREADWORKER;
    final AtomicReference<CachedWorkerPool> pool = new AtomicReference<>(NONE);
    final ThreadFactory threadFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CachedWorkerPool {
        private final CompositeSubscription allWorkers;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        CachedWorkerPool(final ThreadFactory threadFactory, long j3, TimeUnit timeUnit) {
            long j16;
            ScheduledExecutorService scheduledExecutorService;
            ScheduledFuture<?> scheduledFuture;
            this.threadFactory = threadFactory;
            if (timeUnit != null) {
                j16 = timeUnit.toNanos(j3);
            } else {
                j16 = 0;
            }
            long j17 = j16;
            this.keepAliveTime = j17;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new CompositeSubscription();
            if (timeUnit != null) {
                scheduledExecutorService = ProxyExecutors.newScheduledThreadPool(1, new ThreadFactory() { // from class: rx.internal.schedulers.CachedThreadScheduler.CachedWorkerPool.1
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread newThread = threadFactory.newThread(runnable);
                        newThread.setName(newThread.getName() + " (Evictor)");
                        return newThread;
                    }
                });
                NewThreadWorker.tryEnableCancelPolicy(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: rx.internal.schedulers.CachedThreadScheduler.CachedWorkerPool.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CachedWorkerPool.this.evictExpiredWorkers();
                    }
                }, j17, j17, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = scheduledFuture;
        }

        void evictExpiredWorkers() {
            if (!this.expiringWorkerQueue.isEmpty()) {
                long now = now();
                Iterator<ThreadWorker> it = this.expiringWorkerQueue.iterator();
                while (it.hasNext()) {
                    ThreadWorker next = it.next();
                    if (next.getExpirationTime() <= now) {
                        if (this.expiringWorkerQueue.remove(next)) {
                            this.allWorkers.remove(next);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        ThreadWorker get() {
            if (this.allWorkers.isUnsubscribed()) {
                return CachedThreadScheduler.SHUTDOWN_THREADWORKER;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                ThreadWorker poll = this.expiringWorkerQueue.poll();
                if (poll != null) {
                    return poll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.threadFactory);
            this.allWorkers.add(threadWorker);
            return threadWorker;
        }

        long now() {
            return System.nanoTime();
        }

        void release(ThreadWorker threadWorker) {
            threadWorker.setExpirationTime(now() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(threadWorker);
        }

        void shutdown() {
            try {
                Future<?> future = this.evictorTask;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.evictorService;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.allWorkers.unsubscribe();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class EventLoopWorker extends Scheduler.Worker {
        private final CompositeSubscription innerSubscription = new CompositeSubscription();
        final AtomicBoolean once = new AtomicBoolean();
        private final CachedWorkerPool pool;
        private final ThreadWorker threadWorker;

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.threadWorker = cachedWorkerPool.get();
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            return schedule(action0, 0L, null);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.pool.release(this.threadWorker);
            }
            this.innerSubscription.unsubscribe();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(final Action0 action0, long j3, TimeUnit timeUnit) {
            if (this.innerSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            ScheduledAction scheduleActual = this.threadWorker.scheduleActual(new Action0() { // from class: rx.internal.schedulers.CachedThreadScheduler.EventLoopWorker.1
                @Override // rx.functions.Action0
                public void call() {
                    if (EventLoopWorker.this.isUnsubscribed()) {
                        return;
                    }
                    action0.call();
                }
            }, j3, timeUnit);
            this.innerSubscription.add(scheduleActual);
            scheduleActual.addParent(this.innerSubscription);
            return scheduleActual;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ThreadWorker extends NewThreadWorker {
        private long expirationTime;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            this.expirationTime = 0L;
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public void setExpirationTime(long j3) {
            this.expirationTime = j3;
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(RxThreadFactory.NONE);
        SHUTDOWN_THREADWORKER = threadWorker;
        threadWorker.unsubscribe();
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(null, 0L, null);
        NONE = cachedWorkerPool;
        cachedWorkerPool.shutdown();
    }

    public CachedThreadScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        start();
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get());
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        CachedWorkerPool cachedWorkerPool2;
        do {
            cachedWorkerPool = this.pool.get();
            cachedWorkerPool2 = NONE;
            if (cachedWorkerPool == cachedWorkerPool2) {
                return;
            }
        } while (!c.a(this.pool, cachedWorkerPool, cachedWorkerPool2));
        cachedWorkerPool.shutdown();
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(this.threadFactory, 60L, KEEP_ALIVE_UNIT);
        if (!c.a(this.pool, NONE, cachedWorkerPool)) {
            cachedWorkerPool.shutdown();
        }
    }
}
