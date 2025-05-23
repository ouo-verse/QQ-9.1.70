package rx.internal.util;

import androidx.lifecycle.c;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum ExceptionsUtils {
    ;

    private static final Throwable TERMINATED = new Throwable("Terminated");

    public static boolean addThrowable(AtomicReference<Throwable> atomicReference, Throwable th5) {
        Throwable th6;
        Throwable compositeException;
        do {
            th6 = atomicReference.get();
            if (th6 == TERMINATED) {
                return false;
            }
            if (th6 == null) {
                compositeException = th5;
            } else if (th6 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th6).getExceptions());
                arrayList.add(th5);
                compositeException = new CompositeException(arrayList);
            } else {
                compositeException = new CompositeException(th6, th5);
            }
        } while (!c.a(atomicReference, th6, compositeException));
        return true;
    }

    public static boolean isTerminated(AtomicReference<Throwable> atomicReference) {
        return isTerminated(atomicReference.get());
    }

    public static Throwable terminate(AtomicReference<Throwable> atomicReference) {
        Throwable th5 = atomicReference.get();
        Throwable th6 = TERMINATED;
        if (th5 != th6) {
            return atomicReference.getAndSet(th6);
        }
        return th5;
    }

    public static boolean isTerminated(Throwable th5) {
        return th5 == TERMINATED;
    }
}
