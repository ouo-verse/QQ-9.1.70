package sc;

import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f433644c;

    /* renamed from: a, reason: collision with root package name */
    private RFWLayoutLoaderStrategy f433645a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f433646b = !QCircleDeviceInfoUtils.isLowDevice();

    a() {
    }

    public static a a() {
        if (f433644c == null) {
            synchronized (a.class) {
                if (f433644c == null) {
                    f433644c = new a();
                }
            }
        }
        return f433644c;
    }

    public RFWLayoutLoaderStrategy b() {
        if (this.f433645a == null) {
            this.f433645a = new b();
        }
        return this.f433645a;
    }
}
