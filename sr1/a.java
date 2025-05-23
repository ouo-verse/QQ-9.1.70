package sr1;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends sr1.b {

    /* renamed from: e, reason: collision with root package name */
    private View f434298e;

    /* renamed from: f, reason: collision with root package name */
    private ObjectAnimator f434299f;

    /* renamed from: g, reason: collision with root package name */
    private ObjectAnimator f434300g;

    /* renamed from: h, reason: collision with root package name */
    private DecelerateInterpolator f434301h;

    /* renamed from: i, reason: collision with root package name */
    private PathInterpolator f434302i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int g16 = a.this.b().i().g();
            i h16 = a.this.b().h();
            float translationX = a.this.a().getTranslationX();
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByAnim onAnimationUpdate " + g16 + " " + translationX + " " + h16.g());
            if (h16.g() != 2 && h16.g() != 1) {
                h16.n(1);
            } else {
                h16.n(2);
            }
            h16.o(translationX);
            h16.r(g16).k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int g16 = a.this.b().i().g();
            float translationX = a.this.a().getTranslationX();
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "continueMoveAnim onAnimationUpdate " + g16 + " " + translationX);
            a.this.b().h().r(g16).o(translationX).k();
        }
    }

    public a(h hVar) {
        super(hVar);
        this.f434301h = new DecelerateInterpolator();
        this.f434302i = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        this.f434298e = a();
    }

    private int j(float f16, float f17) {
        if (f16 == f17) {
            return 0;
        }
        if (f16 > f17) {
            return 2;
        }
        return 1;
    }

    private com.tencent.mobileqq.widget.f m() {
        return new c();
    }

    private ValueAnimator.AnimatorUpdateListener n() {
        return new d();
    }

    private float q(int i3) {
        return b().i().r(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public void k() {
        ObjectAnimator objectAnimator = this.f434299f;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f434299f.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f434300g;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.f434300g.cancel();
        }
    }

    public void l(float f16) {
        boolean z16;
        long j3;
        TimeInterpolator timeInterpolator;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Gesture.AnimComponent", 2, "continueMoveAnim targetTranslationX = " + f16);
        }
        if (r()) {
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "continueMoveAnim cancelAnim");
            k();
        }
        float translationX = this.f434298e.getTranslationX();
        com.tencent.mobileqq.widget.f m3 = m();
        ValueAnimator.AnimatorUpdateListener n3 = n();
        int h16 = b().i().h(f16);
        if (h16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            j3 = 200;
        } else {
            j3 = 250;
        }
        QLog.i("Guild.MF.Gesture.AnimComponent", 1, "continueMoveAnim " + translationX + f16 + " " + h16);
        this.f434300g = ObjectAnimator.ofFloat(this.f434298e, "translationX", translationX, f16);
        this.f434300g.setDuration((long) (((float) j3) * Math.abs((f16 - translationX) / b().i().q())));
        this.f434300g.addUpdateListener(n3);
        this.f434300g.addListener(m3);
        ObjectAnimator objectAnimator = this.f434300g;
        if (z16) {
            timeInterpolator = this.f434301h;
        } else {
            timeInterpolator = this.f434302i;
        }
        objectAnimator.setInterpolator(timeInterpolator);
        this.f434300g.start();
    }

    public com.tencent.mobileqq.widget.f o(int i3, float f16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Gesture.AnimComponent", 2, "createD8SafeAnimatorListener moveDirection = " + i3);
        }
        return new C11250a(f16, i3);
    }

    public ValueAnimator.AnimatorUpdateListener p() {
        return new b();
    }

    public boolean r() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.f434299f;
        if ((objectAnimator2 != null && objectAnimator2.isRunning()) || ((objectAnimator = this.f434300g) != null && objectAnimator.isRunning())) {
            return true;
        }
        return false;
    }

    public void t(int i3) {
        boolean z16;
        int i16;
        TimeInterpolator timeInterpolator;
        QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByAnim showType = " + i3);
        if (r()) {
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByAnim cancelAnim");
            k();
        }
        float translationX = this.f434298e.getTranslationX();
        float q16 = q(i3);
        int j3 = j(translationX, q16);
        i h16 = b().h();
        j i17 = b().i();
        if (translationX == q16) {
            int g16 = i17.g();
            int h17 = i17.h(translationX);
            if (s(h16.g())) {
                QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByAnim notify EndMove " + translationX + " " + q16 + " " + h17 + " " + g16);
                i17.v(q16);
                h16.n(3).r(g16).q(j3).p(h17).o(translationX).k();
            } else {
                QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByAnim notify BeginMove " + translationX + " " + q16 + " " + h17 + " " + g16);
                h16.n(1).s(3).r(g16).q(j3).m(h17).o(translationX).k();
                i17.v(q16);
                QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByAnim notify EndMove " + translationX + " " + q16 + " " + h17 + " " + g16);
                h16.n(3).p(h17).o(translationX).k();
            }
            h16.n(0);
            return;
        }
        com.tencent.mobileqq.widget.f o16 = o(j3, q16);
        ValueAnimator.AnimatorUpdateListener p16 = p();
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = 200;
        } else {
            i16 = 250;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f434298e, "translationX", translationX, q16);
        this.f434299f = ofFloat;
        ofFloat.setDuration(i16 * Math.abs((translationX - q16) / i17.q()));
        this.f434299f.addListener(o16);
        this.f434299f.addUpdateListener(p16);
        ObjectAnimator objectAnimator = this.f434299f;
        if (z16) {
            timeInterpolator = this.f434301h;
        } else {
            timeInterpolator = this.f434302i;
        }
        objectAnimator.setInterpolator(timeInterpolator);
        this.f434299f.start();
    }

    public void u(int i3) {
        QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByPos showType = " + i3);
        if (r()) {
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByPos cancelAnim");
            k();
        }
        float translationX = this.f434298e.getTranslationX();
        float q16 = q(i3);
        j i16 = b().i();
        int h16 = i16.h(translationX);
        int j3 = j(translationX, q16);
        i h17 = b().h();
        int g16 = h17.g();
        int g17 = i16.g();
        if (!s(g16)) {
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByPos notify BeginMove " + translationX + " " + q16 + " " + h16 + " " + g17);
            h17.n(1).s(2).m(h16).q(j3).r(g17).o(translationX).k();
        }
        i16.v(q16);
        int g18 = i16.g();
        int h18 = i16.h(q16);
        QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByPos notify EndMove " + q16 + " " + h18 + " " + g18);
        h17.n(3).r(g18).p(h18).o(translationX).k();
        h17.n(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: sr1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C11250a extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f434303d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f434304e;

        C11250a(float f16, int i3) {
            this.f434303d = f16;
            this.f434304e = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByAnim onAnimationCancel  " + a.this.a().getTranslationX());
            a.this.f434299f.removeAllListeners();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i h16 = a.this.b().h();
            j i3 = a.this.b().i();
            float translationX = a.this.a().getTranslationX();
            int h17 = i3.h(translationX);
            int i16 = i3.i(translationX);
            a.this.b().j().i(translationX);
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByAnim onAnimationEnd notify EndMove " + translationX + " " + this.f434303d + " " + h17 + " " + i16);
            h16.p(h17).n(3).r(i16).o(translationX).k();
            h16.n(0);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.b().j().h(a.this.f434298e.getTranslationX(), this.f434303d);
            int g16 = a.this.b().h().g();
            j i3 = a.this.b().i();
            float translationX = a.this.a().getTranslationX();
            int h16 = i3.h(translationX);
            int i16 = i3.i(translationX);
            if (!a.this.s(g16)) {
                QLog.i("Guild.MF.Gesture.AnimComponent", 1, "showByAnim onAnimationStart notify beginMove " + translationX + " " + this.f434303d + " " + h16 + " " + i16);
                a.this.b().h().n(1).s(3).q(this.f434304e).r(i16).m(h16).o(translationX).k();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c extends com.tencent.mobileqq.widget.f {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            a.this.f434300g.removeAllListeners();
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "continueMoveAnim onAnimationCancel " + a.this.a().getTranslationX());
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j i3 = a.this.b().i();
            i h16 = a.this.b().h();
            float translationX = a.this.a().getTranslationX();
            int g16 = i3.g();
            int f16 = i3.f();
            a.this.b().j().i(translationX);
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "continueMoveAnim onAnimationEnd " + g16 + " " + f16 + "  translationX: " + translationX);
            h16.p(f16).n(3).r(g16).o(translationX).k();
            h16.n(0);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            int g16 = a.this.b().i().g();
            float translationX = a.this.a().getTranslationX();
            QLog.i("Guild.MF.Gesture.AnimComponent", 1, "continueMoveAnim onAnimationStart curMoveProgress " + g16 + " " + translationX);
            a.this.b().h().r(g16).o(translationX).k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
