package ws3;

import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class cq {
    public static final Object[] a(cn cnVar) {
        String a16;
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("seq");
        m3.add(Integer.valueOf(cnVar.f446281a));
        m3.add("fileSetId");
        m3.add(cnVar.f446282b);
        m3.add("svrFileIds");
        m3.add(Integer.valueOf(cnVar.f446283c.size()));
        m3.addAll(cnVar.f446283c);
        m3.add("sceneType");
        m3.add(Integer.valueOf(cnVar.f446284d));
        m3.add("sinceTimestamp");
        a16 = cp.a(0L, 10);
        m3.add(a16);
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
