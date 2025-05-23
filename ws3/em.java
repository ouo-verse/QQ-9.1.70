package ws3;

import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class em {
    public static final Object[] a(ei eiVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("parentId");
        arrayList.add(eiVar.f446335a);
        arrayList.add("reqDepth");
        arrayList.add(ej.a(eiVar.f446336b));
        arrayList.add("reqIndexPath");
        arrayList.add(eiVar.f446337c);
        arrayList.add("count");
        arrayList.add(ek.a(eiVar.f446338d));
        arrayList.add("paginationInfo");
        arrayList.add(eiVar.f446339e);
        arrayList.add("filterCondition");
        bx bxVar = eiVar.f446340f;
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("fileCategory");
        m3.add(el.a(bxVar.f446224a));
        m3.add(VasWebReport.WEB_CORE_DATA_FLAGS);
        m3.add(Integer.valueOf(bxVar.f446225b));
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array);
        arrayList.add("sortConditions");
        arrayList.add(Integer.valueOf(eiVar.f446341g.size()));
        for (ep epVar : eiVar.f446341g) {
            ArrayList m16 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("sortField");
            m16.add(Integer.valueOf(epVar.f446355a));
            m16.add("sortOrder");
            m16.add(Integer.valueOf(epVar.f446356b));
            Object[] array2 = m16.toArray(new Object[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            arrayList.add(Integer.valueOf(array2.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, array2);
        }
        arrayList.add("isNeedPhysicalInfoReady");
        arrayList.add(Integer.valueOf(eiVar.f446342h ? 1 : 0));
        Object[] array3 = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array3;
    }
}
