package ws3;

import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class u {
    public static final Object[] a(r rVar) {
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("scene");
        m3.add(Integer.valueOf(rVar.f446388a));
        m3.add("name");
        m3.add(rVar.f446389b);
        m3.add("uploaders");
        m3.add(Integer.valueOf(rVar.f446390c.size()));
        for (es esVar : rVar.f446390c) {
            ArrayList m16 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("uin");
            m16.add(esVar.f446361a);
            m16.add("nickname");
            m16.add(esVar.f446362b);
            m16.add("uid");
            m16.add(esVar.f446363c);
            m16.add("sendEntrance");
            m16.add(esVar.f446364d);
            Object[] array = m16.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            m3.add(Integer.valueOf(array.length));
            CollectionsKt__MutableCollectionsKt.addAll(m3, array);
        }
        m3.add(QCircleDaTongConstant.ElementParamValue.PERMISSION);
        ed edVar = rVar.f446391d;
        ArrayList m17 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("code");
        m17.add(s.a(edVar.f446323a));
        Object[] array2 = m17.toArray(new Object[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        m3.add(Integer.valueOf(array2.length));
        CollectionsKt__MutableCollectionsKt.addAll(m3, array2);
        m3.add(QQWinkConstants.COVER_PATH);
        m3.add(rVar.f446392e);
        m3.add("coverOriginalInfos");
        m3.add(Integer.valueOf(rVar.f446393f.size()));
        for (q qVar : rVar.f446393f) {
            ArrayList m18 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("path");
            m18.add(qVar.f446386a);
            m18.add("thumbnailPath");
            m18.add(qVar.f446387b);
            Object[] array3 = m18.toArray(new Object[0]);
            Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            m3.add(Integer.valueOf(array3.length));
            CollectionsKt__MutableCollectionsKt.addAll(m3, array3);
        }
        m3.add("paths");
        m3.add(Integer.valueOf(rVar.f446394g.size()));
        m3.addAll(rVar.f446394g);
        m3.add("excludePaths");
        m3.add(Integer.valueOf(rVar.f446395h.size()));
        m3.addAll(rVar.f446395h);
        m3.add("expireLeftTime");
        m3.add(t.a(rVar.f446396i));
        m3.add("isNeedDelExif");
        m3.add(0);
        Object[] array4 = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array4;
    }
}
