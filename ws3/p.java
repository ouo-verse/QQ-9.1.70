package ws3;

import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class p {
    public static final Object[] a(l lVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("parentId");
        arrayList.add(lVar.f446381a);
        arrayList.add("reqDepth");
        arrayList.add(m.a(lVar.f446382b));
        arrayList.add("count");
        arrayList.add(n.a(lVar.f446383c));
        arrayList.add("paginationInfo");
        arrayList.add(lVar.f446384d);
        arrayList.add(VasWebReport.WEB_CORE_DATA_FLAGS);
        arrayList.add(Integer.valueOf(lVar.f446385e));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
