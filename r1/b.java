package r1;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@CanIgnoreReturnValue
@GwtCompatible
/* loaded from: classes2.dex */
final class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(@NullableDecl String str, int i3) {
        if (i3 > 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " (" + i3 + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z16) {
        if (z16) {
        } else {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
