package ws3;

import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class z {
    public static final Object[] a(y yVar) {
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("isIncludeCompressInnerFiles");
        Boolean bool = yVar.f446405a;
        if (bool != null) {
            Intrinsics.checkNotNull(bool);
            m3.add(Integer.valueOf(bool.booleanValue() ? 1 : 0));
        } else {
            m3.add(new byte[0]);
        }
        m3.add("compressFolderOptionParamsFolderId");
        String str = yVar.f446406b;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            m3.add(str);
        } else {
            m3.add(new byte[0]);
        }
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
