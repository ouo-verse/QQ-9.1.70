package rx.exceptions;

import java.util.HashSet;
import java.util.List;
import rx.Observer;
import rx.SingleSubscriber;
import rx.annotations.Experimental;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Exceptions {
    private static final int MAX_DEPTH = 25;

    Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    public static void addCause(Throwable th5, Throwable th6) {
        HashSet hashSet = new HashSet();
        int i3 = 0;
        while (th5.getCause() != null) {
            int i16 = i3 + 1;
            if (i3 >= 25) {
                return;
            }
            th5 = th5.getCause();
            if (!hashSet.contains(th5.getCause())) {
                hashSet.add(th5.getCause());
                i3 = i16;
            }
        }
        try {
            th5.initCause(th6);
        } catch (Throwable unused) {
        }
    }

    public static Throwable getFinalCause(Throwable th5) {
        int i3 = 0;
        while (th5.getCause() != null) {
            int i16 = i3 + 1;
            if (i3 >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th5 = th5.getCause();
            i3 = i16;
        }
        return th5;
    }

    public static RuntimeException propagate(Throwable th5) {
        if (!(th5 instanceof RuntimeException)) {
            if (th5 instanceof Error) {
                throw ((Error) th5);
            }
            throw new RuntimeException(th5);
        }
        throw ((RuntimeException) th5);
    }

    public static void throwIfAny(List<? extends Throwable> list) {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                Throwable th5 = list.get(0);
                if (!(th5 instanceof RuntimeException)) {
                    if (th5 instanceof Error) {
                        throw ((Error) th5);
                    }
                    throw new RuntimeException(th5);
                }
                throw ((RuntimeException) th5);
            }
            throw new CompositeException(list);
        }
    }

    public static void throwIfFatal(Throwable th5) {
        if (!(th5 instanceof OnErrorNotImplementedException)) {
            if (!(th5 instanceof OnErrorFailedException)) {
                if (!(th5 instanceof OnCompletedFailedException)) {
                    if (!(th5 instanceof StackOverflowError)) {
                        if (!(th5 instanceof VirtualMachineError)) {
                            if (!(th5 instanceof ThreadDeath)) {
                                if (!(th5 instanceof LinkageError)) {
                                    return;
                                } else {
                                    throw ((LinkageError) th5);
                                }
                            }
                            throw ((ThreadDeath) th5);
                        }
                        throw ((VirtualMachineError) th5);
                    }
                    throw ((StackOverflowError) th5);
                }
                throw ((OnCompletedFailedException) th5);
            }
            throw ((OnErrorFailedException) th5);
        }
        throw ((OnErrorNotImplementedException) th5);
    }

    @Experimental
    public static void throwOrReport(Throwable th5, Observer<?> observer, Object obj) {
        throwIfFatal(th5);
        observer.onError(OnErrorThrowable.addValueAsLastCause(th5, obj));
    }

    @Experimental
    public static void throwOrReport(Throwable th5, Observer<?> observer) {
        throwIfFatal(th5);
        observer.onError(th5);
    }

    @Experimental
    public static void throwOrReport(Throwable th5, SingleSubscriber<?> singleSubscriber) {
        throwIfFatal(th5);
        singleSubscriber.onError(th5);
    }
}
