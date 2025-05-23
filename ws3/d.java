package ws3;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d {
    public static final c a(Object[] objArr) {
        Iterator it = ArrayIteratorKt.iterator(objArr);
        c cVar = new c(null, null, 3, null);
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "fileId")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                cVar.f446228a = (String) next2;
            } else if (Intrinsics.areEqual(next, "compressId")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                cVar.f446229b = (String) next3;
            }
        }
        return cVar;
    }
}
