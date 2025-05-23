package ws3;

import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h {
    public static final Object[] a(e eVar) {
        String a16;
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("seq");
        m3.add(Integer.valueOf(eVar.f446311a));
        m3.add("isDownload");
        m3.add(Integer.valueOf(eVar.f446312b ? 1 : 0));
        m3.add("totalDownloadSize");
        a16 = g.a(eVar.f446313c, 10);
        m3.add(a16);
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
