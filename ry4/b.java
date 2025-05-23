package ry4;

import android.content.Context;
import android.content.Intent;
import com.tencent.component.utils.LogUtil;
import com.tme.karaoke.lib_earback.e;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b implements e {

    /* renamed from: a, reason: collision with root package name */
    private c f432962a;

    /* renamed from: b, reason: collision with root package name */
    private int f432963b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f432964c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f432965d = 8;

    /* renamed from: e, reason: collision with root package name */
    private float f432966e = (8 * 1.0f) / 15.0f;

    public b() {
        try {
            Context a16 = com.tme.karaoke.lib_earback.base.b.a();
            c b16 = c.b(a16);
            this.f432962a = b16;
            if (b16.f()) {
                String packageName = a16.getPackageName();
                Intent intent = new Intent("com.vivo.audio.karaoke_settings_off");
                intent.putExtra("state", 0);
                intent.putExtra("pkgname", packageName);
                LogUtil.i("VivoFeedback", "VivoKaraokeHelper -> close system feedback:" + packageName);
                a16.sendBroadcast(intent);
            }
        } catch (Exception e16) {
            LogUtil.w("VivoFeedback", e16.getMessage());
            this.f432962a = null;
            LogUtil.i("VivoFeedback", "VivoFeedback: initVivoFeedBack error");
        }
    }

    public boolean a() {
        c cVar = this.f432962a;
        boolean z16 = false;
        if (cVar == null) {
            LogUtil.i("VivoFeedback", "vivo feedback not work");
            return false;
        }
        if (cVar.d() == 1) {
            z16 = true;
        }
        LogUtil.i("VivoFeedback", "isFeedback: " + z16);
        return z16;
    }

    @Override // com.tme.karaoke.lib_earback.e
    public boolean turnFeedback(boolean z16) {
        LogUtil.i("VivoFeedback", "turnFeedback: " + z16);
        if (this.f432962a == null) {
            LogUtil.i("VivoFeedback", "vivo feedback not work");
            return false;
        }
        if (z16) {
            LogUtil.i("VivoFeedback", "turnFeedback -> openKTVDevice");
            this.f432962a.g();
            LogUtil.i("VivoFeedback", "turnFeedback -> setCustomMode:" + this.f432963b + ", pre mode:" + this.f432962a.e());
            if (this.f432964c) {
                this.f432962a.h(this.f432963b);
                this.f432964c = false;
            }
            LogUtil.i("VivoFeedback", "turnFeedback -> setPlayFeedbackParam:1");
            this.f432962a.n(1);
            this.f432962a.m(this.f432965d);
            this.f432962a.p(0);
        } else {
            LogUtil.i("VivoFeedback", "turnFeedback -> setPlayFeedbackParam:0");
            this.f432962a.n(0);
            LogUtil.i("VivoFeedback", "turnFeedback -> closeKTVDevice");
            this.f432962a.a();
        }
        return a();
    }
}
