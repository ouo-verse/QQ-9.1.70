package ws3;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class eh {
    public static final eg a(Object[] objArr) {
        Iterator it = ArrayIteratorKt.iterator(objArr);
        eg egVar = new eg();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "id")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                egVar.f446332a = (String) next2;
            } else if (Intrinsics.areEqual(next, CoverDBCacheData.URLS)) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) next3).intValue();
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < intValue; i3++) {
                    Object next4 = it.next();
                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next4).intValue();
                    Object[] objArr2 = new Object[intValue2];
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        objArr2[i16] = it.next();
                    }
                    Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                    eq eqVar = new eq(0, "");
                    while (it5.hasNext()) {
                        Object next5 = it5.next();
                        if (Intrinsics.areEqual(next5, "spec")) {
                            Object next6 = it5.next();
                            Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.SpecificationKt.Specification }");
                            eqVar.f446357a = ((Integer) next6).intValue();
                        } else if (Intrinsics.areEqual(next5, "url")) {
                            Object next7 = it5.next();
                            Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.String");
                            eqVar.f446358b = (String) next7;
                        }
                    }
                    arrayList.add(eqVar);
                }
                egVar.f446333b = arrayList;
            } else if (Intrinsics.areEqual(next, "localCachePath")) {
                Object next8 = it.next();
                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                egVar.f446334c = (String) next8;
            }
        }
        return egVar;
    }
}
