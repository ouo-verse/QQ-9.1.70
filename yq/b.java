package yq;

import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkOnlineUserManager;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.light.listener.OnWatermarkDataListener;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lyq/b;", "", "Lorg/light/listener/OnWatermarkDataListener;", "b", "Lorg/light/listener/OnWatermarkDataListener;", "c", "()Lorg/light/listener/OnWatermarkDataListener;", "WATERMARK_DATA_LISTENER", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f450786a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final OnWatermarkDataListener WATERMARK_DATA_LISTENER = new OnWatermarkDataListener() { // from class: yq.a
        @Override // org.light.listener.OnWatermarkDataListener
        public final String getData(String str) {
            String b16;
            b16 = b.b(str);
            return b16;
        }
    };

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(String str) {
        boolean equals;
        ms.a.a("LSMiddleCameraUnit", "watermark\u56de\u8c03: getData:" + str);
        equals = StringsKt__StringsJVMKt.equals(str, "watermark.qq.online", true);
        if (!equals) {
            return null;
        }
        ms.a.a("LSMiddleCameraUnit", "watermark\u56de\u8c03: getData,\u83b7\u53d6\u5728\u7ebf\u4eba\u6570:" + WatermarkOnlineUserManager.f().g());
        return String.valueOf(WatermarkOnlineUserManager.f().g());
    }

    public final OnWatermarkDataListener c() {
        return WATERMARK_DATA_LISTENER;
    }
}
