package ws3;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bq {
    public static final bp a(Object[] objArr) {
        Iterator it = ArrayIteratorKt.iterator(objArr);
        bp bpVar = new bp();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "parentId")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
            } else if (Intrinsics.areEqual(next, "depth")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                vs3.a.a((String) next3);
            } else if (Intrinsics.areEqual(next, "fileList")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) next4).intValue();
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < intValue; i3++) {
                    Object next5 = it.next();
                    Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next5).intValue();
                    Object[] objArr2 = new Object[intValue2];
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        objArr2[i16] = it.next();
                    }
                    arrayList.add(bo.b(objArr2));
                }
                bpVar.f446183a = arrayList;
            } else if (Intrinsics.areEqual(next, "paginationInfo")) {
                Object next6 = it.next();
                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.ByteArray");
                bpVar.f446184b = (byte[]) next6;
            } else if (Intrinsics.areEqual(next, "isEnd")) {
                Object next7 = it.next();
                Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                bpVar.f446185c = ((Integer) next7).intValue() == 1;
            } else if (Intrinsics.areEqual(next, QAdRewardDefine$VideoParams.ISCACHE)) {
                Object next8 = it.next();
                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int");
                bpVar.f446186d = ((Integer) next8).intValue() == 1;
            }
        }
        return bpVar;
    }
}
