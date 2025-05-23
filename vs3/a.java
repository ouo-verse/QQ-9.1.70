package vs3;

import kotlin.UInt;
import kotlin.ULong;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.UStringsKt;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a {
    public static final int a(String str) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "-", false, 2, null);
        if (startsWith$default) {
            return UInt.m570constructorimpl(Integer.parseInt(str));
        }
        return UStringsKt.toUInt(str);
    }

    public static final long b(String str) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "-", false, 2, null);
        if (startsWith$default) {
            return ULong.m648constructorimpl(Long.parseLong(str));
        }
        return UStringsKt.toULong(str);
    }
}
