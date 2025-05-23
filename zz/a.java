package zz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.weishi.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends com.tencent.biz.pubaccount.weishi.baseui.b {
    private LottieAnimationView C;
    private WSFollowFeedHolder D;

    /* compiled from: P */
    /* renamed from: zz.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class ViewOnClickListenerC11726a implements View.OnClickListener {
        ViewOnClickListenerC11726a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.C.setClickable(false);
        }
    }

    public a(Context context, WSFollowFeedHolder wSFollowFeedHolder) {
        super(context);
        this.D = wSFollowFeedHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        x();
        WSPlayerManager P = this.D.P();
        if (P == null || !P.C0()) {
            return;
        }
        this.D.e0(P);
    }

    private void y() {
        this.C.addAnimatorListener(new b());
        this.C.playAnimation();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.f168564fx4;
    }

    public void x() {
        if (this.D.G0()) {
            y();
            this.D.B0();
            x.j("WSFollowTabMuteGuideController", "[WSFollowTabMuteGuideController.java][playAnimationForMuteGuide] doPlay!");
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) p(R.id.xuu);
        this.C = lottieAnimationView;
        lottieAnimationView.setAnimation("wsfollow/muteguide/muteguide.json");
        this.C.setImageAssetsFolder("wsfollow/muteguide/images");
        this.C.setOnClickListener(new ViewOnClickListenerC11726a());
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
    }
}
