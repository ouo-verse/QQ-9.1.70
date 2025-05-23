package rx.internal.schedulers;

import androidx.lifecycle.c;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.util.PlatformDependent;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.internal.util.SuppressAnimalSniffer;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NewThreadWorker extends Scheduler.Worker {
    private static final String PURGE_FORCE_KEY = "rx.scheduler.jdk6.purge-force";
    private static final String PURGE_THREAD_PREFIX = "RxSchedulerPurge-";
    private static final boolean SHOULD_TRY_ENABLE_CANCEL_POLICY;
    private static volatile Object cachedSetRemoveOnCancelPolicyMethod;
    private final ScheduledExecutorService executor;
    volatile boolean isUnsubscribed;
    private static final Object SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED = new Object();
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> EXECUTORS = new ConcurrentHashMap<>();
    private static final AtomicReference<ScheduledExecutorService> PURGE = new AtomicReference<>();
    private static final String FREQUENCY_KEY = "rx.scheduler.jdk6.purge-frequency-millis";
    public static final int PURGE_FREQUENCY = Integer.getInteger(FREQUENCY_KEY, 1000).intValue();

    static {
        boolean z16;
        boolean z17 = Boolean.getBoolean(PURGE_FORCE_KEY);
        int androidApiVersion = PlatformDependent.getAndroidApiVersion();
        if (!z17 && (androidApiVersion == 0 || androidApiVersion >= 21)) {
            z16 = true;
        } else {
            z16 = false;
        }
        SHOULD_TRY_ENABLE_CANCEL_POLICY = z16;
    }

    public NewThreadWorker(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = ProxyExecutors.newScheduledThreadPool(1, threadFactory);
        if (!tryEnableCancelPolicy(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            registerExecutor((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.executor = newScheduledThreadPool;
    }

    public static void deregisterExecutor(ScheduledExecutorService scheduledExecutorService) {
        EXECUTORS.remove(scheduledExecutorService);
    }

    static Method findSetRemoveOnCancelPolicyMethod(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    @SuppressAnimalSniffer
    static void purgeExecutors() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = EXECUTORS.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th5) {
            Exceptions.throwIfFatal(th5);
            RxJavaHooks.onError(th5);
        }
    }

    public static void registerExecutor(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = PURGE;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = ProxyExecutors.newScheduledThreadPool(1, new RxThreadFactory(PURGE_THREAD_PREFIX));
            if (c.a(atomicReference, null, newScheduledThreadPool)) {
                Runnable runnable = new Runnable() { // from class: rx.internal.schedulers.NewThreadWorker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NewThreadWorker.purgeExecutors();
                    }
                };
                int i3 = PURGE_FREQUENCY;
                newScheduledThreadPool.scheduleAtFixedRate(runnable, i3, i3, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        EXECUTORS.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean tryEnableCancelPolicy(ScheduledExecutorService scheduledExecutorService) {
        Method findSetRemoveOnCancelPolicyMethod;
        if (SHOULD_TRY_ENABLE_CANCEL_POLICY) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = cachedSetRemoveOnCancelPolicyMethod;
                Object obj2 = SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    findSetRemoveOnCancelPolicyMethod = findSetRemoveOnCancelPolicyMethod(scheduledExecutorService);
                    if (findSetRemoveOnCancelPolicyMethod != null) {
                        obj2 = findSetRemoveOnCancelPolicyMethod;
                    }
                    cachedSetRemoveOnCancelPolicyMethod = obj2;
                } else {
                    findSetRemoveOnCancelPolicyMethod = (Method) obj;
                }
            } else {
                findSetRemoveOnCancelPolicyMethod = findSetRemoveOnCancelPolicyMethod(scheduledExecutorService);
            }
            if (findSetRemoveOnCancelPolicyMethod != null) {
                try {
                    findSetRemoveOnCancelPolicyMethod.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e16) {
                    RxJavaHooks.onError(e16);
                } catch (IllegalArgumentException e17) {
                    RxJavaHooks.onError(e17);
                } catch (InvocationTargetException e18) {
                    RxJavaHooks.onError(e18);
                }
            }
        }
        return false;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.isUnsubscribed;
    }

    @Override // rx.Scheduler.Worker
    public Subscription schedule(Action0 action0) {
        return schedule(action0, 0L, null);
    }

    public ScheduledAction scheduleActual(Action0 action0, long j3, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0));
        if (j3 <= 0) {
            schedule = this.executor.submit(scheduledAction);
        } else {
            schedule = this.executor.schedule(scheduledAction, j3, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.isUnsubscribed = true;
        this.executor.shutdownNow();
        deregisterExecutor(this.executor);
    }

    @Override // rx.Scheduler.Worker
    public Subscription schedule(Action0 action0, long j3, TimeUnit timeUnit) {
        if (this.isUnsubscribed) {
            return Subscriptions.unsubscribed();
        }
        return scheduleActual(action0, j3, timeUnit);
    }

    public ScheduledAction scheduleActual(Action0 action0, long j3, TimeUnit timeUnit, CompositeSubscription compositeSubscription) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0), compositeSubscription);
        compositeSubscription.add(scheduledAction);
        if (j3 <= 0) {
            schedule = this.executor.submit(scheduledAction);
        } else {
            schedule = this.executor.schedule(scheduledAction, j3, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    public ScheduledAction scheduleActual(Action0 action0, long j3, TimeUnit timeUnit, SubscriptionList subscriptionList) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0), subscriptionList);
        subscriptionList.add(scheduledAction);
        if (j3 <= 0) {
            schedule = this.executor.submit(scheduledAction);
        } else {
            schedule = this.executor.schedule(scheduledAction, j3, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }
}
