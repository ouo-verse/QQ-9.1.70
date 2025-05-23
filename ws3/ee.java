package ws3;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ee {
    public static final ed a(Object[] objArr) {
        Iterator it = ArrayIteratorKt.iterator(objArr);
        ed edVar = new ed();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), "code")) {
                Object next = it.next();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                edVar.f446323a = vs3.a.a((String) next);
            }
        }
        return edVar;
    }
}
