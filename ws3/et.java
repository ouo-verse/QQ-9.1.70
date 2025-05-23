package ws3;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class et {
    public static final es a(Object[] objArr) {
        Iterator it = ArrayIteratorKt.iterator(objArr);
        es esVar = new es(null, null, null, null, 15, null);
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "uin")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                esVar.f446361a = (String) next2;
            } else if (Intrinsics.areEqual(next, "nickname")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                esVar.f446362b = (String) next3;
            } else if (Intrinsics.areEqual(next, "uid")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                esVar.f446363c = (String) next4;
            } else if (Intrinsics.areEqual(next, "sendEntrance")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                esVar.f446364d = (String) next5;
            }
        }
        return esVar;
    }
}
