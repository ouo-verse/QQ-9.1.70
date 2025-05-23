package rx.internal.schedulers;

import androidx.lifecycle.c;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GenericScheduledExecutorService implements SchedulerLifecycle {
    public static final GenericScheduledExecutorService INSTANCE;
    private static final ScheduledExecutorService[] NONE = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService SHUTDOWN;
    private static int roundRobin;
    private final AtomicReference<ScheduledExecutorService[]> executor = new AtomicReference<>(NONE);

    static {
        ScheduledExecutorService newScheduledThreadPool = ProxyExecutors.newScheduledThreadPool(0);
        SHUTDOWN = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        INSTANCE = new GenericScheduledExecutorService();
    }

    GenericScheduledExecutorService() {
        start();
    }

    public static ScheduledExecutorService getInstance() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = INSTANCE.executor.get();
        if (scheduledExecutorServiceArr == NONE) {
            return SHUTDOWN;
        }
        int i3 = roundRobin + 1;
        if (i3 >= scheduledExecutorServiceArr.length) {
            i3 = 0;
        }
        roundRobin = i3;
        return scheduledExecutorServiceArr[i3];
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            scheduledExecutorServiceArr = this.executor.get();
            scheduledExecutorServiceArr2 = NONE;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!c.a(this.executor, scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            NewThreadWorker.deregisterExecutor(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors > 8) {
            availableProcessors = 8;
        }
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[availableProcessors];
        int i3 = 0;
        for (int i16 = 0; i16 < availableProcessors; i16++) {
            scheduledExecutorServiceArr[i16] = GenericScheduledExecutorServiceFactory.create();
        }
        if (c.a(this.executor, NONE, scheduledExecutorServiceArr)) {
            while (i3 < availableProcessors) {
                ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i3];
                if (!NewThreadWorker.tryEnableCancelPolicy(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    NewThreadWorker.registerExecutor((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i3++;
            }
            return;
        }
        while (i3 < availableProcessors) {
            scheduledExecutorServiceArr[i3].shutdownNow();
            i3++;
        }
    }
}
