package ws3;

import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class du {
    public static final Object[] a(ds dsVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("seq");
        arrayList.add(Integer.valueOf(dsVar.f446288a));
        arrayList.add("fileSetId");
        arrayList.add(dsVar.f446289b);
        arrayList.add("type");
        arrayList.add(Integer.valueOf(dsVar.f446290c));
        arrayList.add("clusteringId");
        arrayList.add(dsVar.f446291d);
        arrayList.add(VasWebReport.WEB_CORE_DATA_FLAGS);
        arrayList.add(Integer.valueOf(dsVar.f446292e));
        arrayList.add("paginationInfo");
        arrayList.add(dsVar.f446293f);
        arrayList.add("count");
        arrayList.add(dt.a(dsVar.f446294g));
        arrayList.add("sceneType");
        arrayList.add(Integer.valueOf(dsVar.f446295h));
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
