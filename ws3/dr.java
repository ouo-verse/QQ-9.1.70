package ws3;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final /* synthetic */ class dr {
    public static Object a(Iterator it, String str) {
        it.next();
        Object next = it.next();
        Intrinsics.checkNotNull(next, str);
        return next;
    }
}
