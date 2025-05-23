package ws3;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b {
    public static final a a(Object[] objArr) {
        Iterator it = ArrayIteratorKt.iterator(objArr);
        a aVar = new a();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "firstClusteringList")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) next2).intValue();
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < intValue; i3++) {
                    Object next3 = it.next();
                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next3).intValue();
                    Object[] objArr2 = new Object[intValue2];
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        objArr2[i16] = it.next();
                    }
                    Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                    bz bzVar = new bz(0, null, null, 7, null);
                    while (it5.hasNext()) {
                        Object next4 = it5.next();
                        if (Intrinsics.areEqual(next4, "type")) {
                            Object next5 = it5.next();
                            Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.ClusteringTypeKt.ClusteringType }");
                            bzVar.f446226a = ((Integer) next5).intValue();
                        } else if (Intrinsics.areEqual(next4, "name")) {
                            Object next6 = it5.next();
                            Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                            bzVar.f446227b = (String) next6;
                        } else if (Intrinsics.areEqual(next4, PhotoCategorySummaryInfo.AVATAR_URL)) {
                            Object next7 = it5.next();
                            Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                            int intValue3 = ((Integer) next7).intValue();
                            ArrayList arrayList2 = new ArrayList(intValue3);
                            for (int i17 = 0; i17 < intValue3; i17++) {
                                Object next8 = it5.next();
                                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                                arrayList2.add((String) next8);
                            }
                        }
                    }
                    arrayList.add(bzVar);
                }
                aVar.f446146a = arrayList;
            } else if (Intrinsics.areEqual(next, "shouldPull")) {
                Object next9 = it.next();
                Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.Int");
                aVar.f446147b = ((Integer) next9).intValue() == 1;
            }
        }
        return aVar;
    }
}
