package ws3;

import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class eb {
    public static final Object[] a(dx dxVar) {
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("seq");
        m3.add(Integer.valueOf(dxVar.f446305a));
        m3.add("fileSetId");
        m3.add(dxVar.f446306b);
        m3.add("type");
        m3.add(Integer.valueOf(dxVar.f446307c));
        m3.add("count");
        m3.add(dy.a(dxVar.f446308d));
        m3.add("faceAvatarResize");
        aa aaVar = dxVar.f446309e;
        ArrayList m16 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("width");
        m16.add(dz.a(aaVar.f446148a));
        m16.add("height");
        m16.add(ea.a(aaVar.f446149b));
        Object[] array = m16.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        m3.add(Integer.valueOf(array.length));
        CollectionsKt__MutableCollectionsKt.addAll(m3, array);
        m3.add("sceneType");
        m3.add(Integer.valueOf(dxVar.f446310f));
        Object[] array2 = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array2;
    }
}
