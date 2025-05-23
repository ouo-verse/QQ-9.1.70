package rn;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e {

    /* renamed from: l, reason: collision with root package name */
    private static final int f431698l = ar.e(100.0f);

    /* renamed from: a, reason: collision with root package name */
    private AnimatorSet f431699a;

    /* renamed from: b, reason: collision with root package name */
    private AnimatorSet f431700b;

    /* renamed from: c, reason: collision with root package name */
    private ValueAnimator f431701c;

    /* renamed from: d, reason: collision with root package name */
    private View f431702d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f431703e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f431704f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f431705g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f431706h;

    /* renamed from: i, reason: collision with root package name */
    private int f431707i;

    /* renamed from: j, reason: collision with root package name */
    private f f431708j;

    /* renamed from: k, reason: collision with root package name */
    private c f431709k;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface c {
        void a();

        void b();

        void c();

        void d(long j3);
    }

    private int g() {
        f fVar = this.f431708j;
        if (fVar == null) {
            QLog.e("QZMTitleBarEntranceAnimHelper", 1, "copy view helper is null");
            return 0;
        }
        return fVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        View view = this.f431702d;
        if (view != null && (view.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.f431702d.setLayoutParams(layoutParams);
        }
    }

    public void f() {
        k(this.f431699a);
        k(this.f431700b);
        l(this.f431701c);
    }

    public boolean h() {
        return this.f431704f;
    }

    public void i() {
        if (this.f431705g || this.f431706h || this.f431702d == null || !g.d()) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f431702d, "translationX", f431698l, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f431702d, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        he0.b.l(ofFloat, R.anim.f154985us);
        he0.b.l(ofFloat2, R.anim.f154985us);
        if (this.f431700b == null) {
            this.f431700b = new AnimatorSet();
        }
        this.f431700b.playTogether(ofFloat, ofFloat2);
        this.f431700b.setDuration(200L);
        this.f431700b.addListener(new b());
        this.f431700b.start();
    }

    public void j() {
        if (this.f431704f || this.f431706h || this.f431702d == null || !g.d()) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f431702d, "translationX", 0.0f, g() - f431698l);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f431702d, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        he0.b.l(ofFloat, R.anim.f154985us);
        he0.b.l(ofFloat2, R.anim.f154985us);
        if (this.f431699a == null) {
            this.f431699a = new AnimatorSet();
        }
        this.f431699a.playTogether(ofFloat, ofFloat2);
        this.f431699a.addListener(new a());
        this.f431699a.start();
    }

    public void n(f fVar) {
        this.f431708j = fVar;
    }

    public void o(View view) {
        this.f431702d = view;
        this.f431703e = (TextView) view.findViewById(R.id.f67953eq);
        this.f431707i = ar.e(84.0f);
    }

    public void p(c cVar) {
        this.f431709k = cVar;
    }

    public void k(AnimatorSet animatorSet) {
        if (animatorSet == null) {
            return;
        }
        animatorSet.removeAllListeners();
        animatorSet.cancel();
    }

    public void l(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        valueAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            e.this.f431706h = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.f431706h = false;
            if (e.this.f431709k != null) {
                e.this.f431709k.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.f431706h = true;
            e.this.f431704f = true;
            e.this.f431705g = false;
            if (e.this.f431709k != null) {
                e.this.f431709k.d(50L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            e.this.f431706h = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.f431706h = false;
            e.this.m();
            if (e.this.f431709k != null) {
                e.this.f431709k.c();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.f431706h = true;
            e.this.f431705g = true;
            e.this.f431704f = false;
            if (e.this.f431709k != null) {
                e.this.f431709k.b();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
