package sr1;

import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j extends b {

    /* renamed from: e, reason: collision with root package name */
    private boolean f434336e;

    public j(h hVar) {
        super(hVar);
        this.f434336e = false;
        s();
    }

    public int f() {
        return h(a().getTranslationX());
    }

    public int g() {
        return i(a().getTranslationX());
    }

    public int h(float f16) {
        j i3 = b().i();
        float n3 = i3.n();
        float m3 = i3.m();
        if (f16 < n3) {
            return 2;
        }
        if (f16 < m3) {
            return 1;
        }
        return 3;
    }

    public int i(float f16) {
        float o16 = o();
        float m3 = m();
        if (f16 == o16) {
            return 0;
        }
        if (f16 == m3) {
            return 1000;
        }
        return (int) (((f16 - o16) * 1000.0f) / (m3 - o16));
    }

    public boolean j() {
        if (a().getTranslationX() == p()) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (a().getTranslationX() == m()) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (a().getTranslationX() == n()) {
            return true;
        }
        return false;
    }

    public float m() {
        return bi.d() - ViewUtils.dpToPx(0.0f);
    }

    public float n() {
        if (this.f434336e) {
            return 0.0f;
        }
        return o();
    }

    public float o() {
        if (this.f434336e) {
            return p();
        }
        return 0.0f;
    }

    public float p() {
        return (bi.d() * (-1)) + ViewUtils.dpToPx(0.0f);
    }

    public float q() {
        return bi.d();
    }

    public float r(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return 0.0f;
                }
                return m();
            }
            return n();
        }
        return p();
    }

    public void s() {
        a().setTranslationX(m());
    }

    public boolean t() {
        return this.f434336e;
    }

    public void u(boolean z16) {
        QLog.i("Guild.MF.Gesture.PosCalcComponent", 1, "setEnableEndPage isEnable = " + z16);
        this.f434336e = z16;
    }

    public void v(float f16) {
        a().setTranslationX(f16);
        b().j().i(f16);
    }
}
