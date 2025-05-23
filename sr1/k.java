package sr1;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildMainFrameLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class k extends b {

    /* renamed from: e, reason: collision with root package name */
    private VelocityTracker f434337e;

    /* renamed from: f, reason: collision with root package name */
    private float f434338f;

    /* renamed from: g, reason: collision with root package name */
    private float f434339g;

    /* renamed from: h, reason: collision with root package name */
    private float f434340h;

    public k(h hVar) {
        super(hVar);
        this.f434338f = Float.MAX_VALUE;
        this.f434339g = Float.MAX_VALUE;
        this.f434340h = Float.MAX_VALUE;
        this.f434337e = VelocityTracker.obtain();
    }

    private int f(float f16, float f17) {
        if (f16 > f17) {
            return 2;
        }
        if (f16 == f17) {
            return 0;
        }
        return 1;
    }

    private int g(float f16) {
        if (f16 > 0.0f) {
            return 1;
        }
        return 2;
    }

    private float i(float f16) {
        float translationX = a().getTranslationX();
        j i3 = b().i();
        boolean t16 = i3.t();
        float p16 = i3.p();
        float n3 = i3.n();
        float m3 = i3.m();
        if (!t16) {
            if (f16 > 0.0f) {
                return m3;
            }
            return n3;
        }
        if (translationX > n3) {
            if (f16 > 0.0f) {
                return m3;
            }
            return n3;
        }
        if (f16 > 0.0f) {
            return n3;
        }
        return p16;
    }

    private float j(MotionEvent motionEvent) {
        float h16;
        int f16;
        QLog.d("Guild.MF.Gesture.TouchEventHelper", 2, "continueAnim");
        this.f434337e.computeCurrentVelocity(1000);
        float xVelocity = this.f434337e.getXVelocity();
        this.f434337e.clear();
        float translationX = a().getTranslationX();
        i h17 = b().h();
        if (n(motionEvent, xVelocity)) {
            f16 = g(xVelocity);
            h16 = i(xVelocity);
            QLog.i("Guild.MF.Gesture.TouchEventHelper", 1, "continueAnim VelocityX " + f16 + " " + translationX + " " + h16 + " " + xVelocity);
        } else {
            h16 = h();
            f16 = f(translationX, h16);
            QLog.i("Guild.MF.Gesture.TouchEventHelper", 1, "continueAnim Pos " + f16 + " " + translationX + " " + h16);
        }
        h17.n(2).q(f16);
        b().a().l(h16);
        return h16;
    }

    private boolean k(MotionEvent motionEvent) {
        this.f434337e.clear();
        this.f434339g = motionEvent.getRawX();
        this.f434338f = motionEvent.getRawX();
        this.f434340h = a().getTranslationX();
        if (b().a().r()) {
            QLog.i("Guild.MF.Gesture.TouchEventHelper", 1, "handleActionDown cancelAnim");
            b().a().k();
            m(motionEvent);
        }
        QLog.d("Guild.MF.Gesture.TouchEventHelper", 2, "handleActionDown mStartPosX = " + this.f434338f + " mStartTranslationX = " + this.f434340h);
        return true;
    }

    private boolean l(MotionEvent motionEvent) {
        int i3;
        float rawX = motionEvent.getRawX();
        float translationX = a().getTranslationX();
        float f16 = (rawX - this.f434339g) + translationX;
        i h16 = b().h();
        if (h16.g() == 0) {
            if (rawX > this.f434339g) {
                i3 = -GuildMainFrameLayout.I;
            } else {
                i3 = GuildMainFrameLayout.I;
            }
            f16 += i3;
        }
        j i16 = b().i();
        float m3 = i16.m();
        float o16 = i16.o();
        if (f16 > m3) {
            f16 = m3;
        } else if (f16 < o16) {
            f16 = o16;
        }
        this.f434339g = rawX;
        if (translationX == f16) {
            return true;
        }
        i16.v(f16);
        int f17 = f(translationX, f16);
        int g16 = i16.g();
        if (h16.g() == 0) {
            h16.n(1).q(f17).r(g16).s(1).m(i16.h(translationX)).o(translationX).k();
        } else {
            h16.n(2).q(f17).r(g16).o(translationX).k();
        }
        return true;
    }

    private boolean m(MotionEvent motionEvent) {
        QLog.d("Guild.MF.Gesture.TouchEventHelper", 2, "handleActionUpOrCancel");
        i h16 = b().h();
        j i3 = b().i();
        if (p()) {
            QLog.i("Guild.MF.Gesture.TouchEventHelper", 1, "handleActionUpOrCancel continueAnim " + a().getTranslationX());
            q(i3.h(j(motionEvent)));
        } else {
            if (o(h16.g())) {
                float translationX = a().getTranslationX();
                QLog.i("Guild.MF.Gesture.TouchEventHelper", 1, "handleActionUpOrCancel notify EndMove " + translationX);
                int f16 = i3.f();
                h16.n(3).r(i3.g()).p(f16).o(translationX).k();
                q(f16);
            }
            h16.n(0);
        }
        return true;
    }

    private boolean n(MotionEvent motionEvent, float f16) {
        boolean z16;
        boolean z17;
        if (Math.abs(f16) > ViewConfiguration.get(a().getContext()).getScaledMinimumFlingVelocity()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Math.abs(motionEvent.getRawX() - this.f434338f) > b().i().q() / 10.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && z17) {
            return true;
        }
        return false;
    }

    private boolean o(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    private boolean p() {
        j i3 = b().i();
        float o16 = i3.o();
        float n3 = i3.n();
        float m3 = i3.m();
        float translationX = a().getTranslationX();
        if (translationX != o16 && translationX != m3 && translationX != n3) {
            return true;
        }
        return false;
    }

    private void q(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Gesture.TouchEventHelper", 1, "notifyShowTypeChanged foldStatus=" + i3);
        }
        com.tencent.mobileqq.guild.mainframe.i g16 = b().g();
        if (g16 != null) {
            g16.N().b(g.r(i3));
        }
    }

    public float h() {
        float translationX = a().getTranslationX();
        j i3 = b().i();
        boolean t16 = i3.t();
        float p16 = i3.p();
        float n3 = i3.n();
        float m3 = i3.m();
        if (!t16) {
            if (translationX - n3 > (m3 - n3) / 2.0f) {
                return m3;
            }
            return n3;
        }
        if (translationX > n3) {
            if (translationX - n3 > (m3 - n3) / 2.0f) {
                return m3;
            }
            return n3;
        }
        if (translationX - n3 > (p16 - n3) / 2.0f) {
            return n3;
        }
        return p16;
    }

    public boolean r(MotionEvent motionEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Gesture.TouchEventHelper", 2, "onTouchEvent + event = " + motionEvent.getAction());
        }
        this.f434337e.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    return l(motionEvent);
                }
            }
            return m(motionEvent);
        }
        return k(motionEvent);
    }
}
