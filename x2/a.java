package x2;

import com.hihonor.mcs.fitness.health.internal.exception.IllegalDataException;
import com.hihonor.mcs.fitness.health.internal.exception.IllegalOperationException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    public static void a(int i3, int i16) throws IllegalOperationException {
        if ((t2.a.a(i3) & i16) != 0) {
        } else {
            throw new IllegalOperationException(100006, "ILLEGAL_OPERATION");
        }
    }

    public static void b(int i3, String str) throws IllegalOperationException {
        if (v2.a.d().c(str, i3)) {
        } else {
            throw new IllegalOperationException(100012, "SERVER_VERSION_TOO_LOW");
        }
    }

    public static <T> void c(T t16) throws IllegalDataException {
        if (t16 != null) {
        } else {
            throw new IllegalDataException(100005, "DATA_IS_NULL_OR_EMPTY");
        }
    }
}
