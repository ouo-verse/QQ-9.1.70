package ws3;

import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class cl {
    public static final Object[] a(cj cjVar) {
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("seq");
        m3.add(Integer.valueOf(cjVar.f446269a));
        m3.add("listType");
        m3.add(Integer.valueOf(cjVar.f446270b));
        m3.add("paginationInfo");
        m3.add(cjVar.f446271c);
        m3.add("limit");
        m3.add(ck.a(cjVar.f446272d));
        m3.add("isUseCache");
        m3.add(Integer.valueOf(cjVar.f446273e ? 1 : 0));
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
