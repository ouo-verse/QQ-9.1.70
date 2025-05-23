package un;

import android.content.Context;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import ho.i;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends a {

    /* renamed from: b, reason: collision with root package name */
    private final ShuoshuoContent f439251b;

    public e(ShuoshuoContent shuoshuoContent) {
        super(shuoshuoContent.getClientKey());
        this.f439251b = shuoshuoContent;
    }

    public static void e(Context context) {
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.w0(bool);
        qZonePublishMoodInitBean.C0("shuoshuoList");
        qZonePublishMoodInitBean.O0(21);
        Boolean bool2 = Boolean.TRUE;
        qZonePublishMoodInitBean.s0(bool2);
        qZonePublishMoodInitBean.G0(bool2);
        qZonePublishMoodInitBean.v0(bool);
        i.w().c(context, qZonePublishMoodInitBean);
    }

    @Override // un.a
    public int b() {
        return 311;
    }

    @Override // un.a
    public void c(Context context) {
        e(context);
    }

    public ShuoshuoContent d() {
        return this.f439251b;
    }
}
