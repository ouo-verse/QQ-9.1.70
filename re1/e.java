package re1;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.TouchCaptureRecyclerView;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Collections;
import java.util.Map;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u001a\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0002R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010!R\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u0018R\u001c\u0010(\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010'R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lre1/e;", "", "", DomainData.DOMAIN_NAME, "show", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", tl.h.F, "", "state", "o", "forceNoShow", "forceCheckContentOverFlow", "f", "Landroid/view/View;", "a", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "b", "jumpToBottomButton", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "jumpToBottomButtonBg", "Lcom/airbnb/lottie/LottieAnimationView;", "d", "Lcom/airbnb/lottie/LottieAnimationView;", "jumpToBottomFinishButtonIv", "e", "jumpToBottomFinishButton", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "jumpToBottomButtonFl", "g", "jumpToBottomButtonShadow", "Lcom/tencent/mobileqq/guild/aisearch/TouchCaptureRecyclerView;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/guild/aisearch/TouchCaptureRecyclerView;", "chatRvList", "i", "I", "answerDataState", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View jumpToBottomButton;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView jumpToBottomButtonBg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LottieAnimationView jumpToBottomFinishButtonIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View jumpToBottomFinishButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout jumpToBottomButtonFl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView jumpToBottomButtonShadow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TouchCaptureRecyclerView chatRvList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int answerDataState;

    public e(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.rootView = rootView;
        View findViewById = rootView.findViewById(R.id.f165982yb2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.jump_to_bottom_btn)");
        this.jumpToBottomButton = findViewById;
        View findViewById2 = rootView.findViewById(R.id.f165549wl4);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById2;
        lottieAnimationView.setAnimation("discovery/guild_ai_logo_thinking.json");
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.playAnimation();
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Lo\u2026    playAnimation()\n    }");
        this.jumpToBottomButtonBg = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.wl6);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById3;
        lottieAnimationView2.setAnimation("discovery/guild_ai_btn_finish.json");
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Lo\u2026i_btn_finish.json\")\n    }");
        this.jumpToBottomFinishButtonIv = lottieAnimationView2;
        View findViewById4 = rootView.findViewById(R.id.wl5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.guild_jump_btn_finish)");
        this.jumpToBottomFinishButton = findViewById4;
        View findViewById5 = rootView.findViewById(R.id.yat);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.jump_btn_fl)");
        this.jumpToBottomButtonFl = (FrameLayout) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.yau);
        ImageView imageView = (ImageView) findViewById6;
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setRequestWidth(imageView.getWidth());
        apngOptions.setRequestHeight(imageView.getHeight());
        imageView.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("JumpBtnController", "http://downv6.qq.com/innovate/guild/guild_jump_bth_shadow.png", apngOptions));
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById<Im\u2026eDrawable(drawable)\n    }");
        this.jumpToBottomButtonShadow = imageView;
        this.chatRvList = (TouchCaptureRecyclerView) rootView.findViewById(R.id.sfu);
        this.answerDataState = 1;
        GuildVectorDrawableCompat create = GuildVectorDrawableCompat.create(rootView.getContext().getResources(), R.drawable.guild_vector_icon_arrow_down, null);
        if (create != null) {
            create.setTintList(rootView.getContext().getResources().getColorStateList(R.color.qui_common_icon_primary));
        }
        if (create != null) {
            create.setOverrideStrokeWidth(1.7f);
        }
        ((ImageView) rootView.findViewById(R.id.f164476z2)).setImageDrawable(create);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: re1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.e(e.this, view);
            }
        });
        Map emptyMap = Collections.emptyMap();
        Intrinsics.checkNotNullExpressionValue(emptyMap, "emptyMap()");
        bt.c(findViewById, "em_sgrp_return_bottom", emptyMap, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.chatRvList.b0();
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void g(e eVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        eVar.f(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final LottieAnimationView lottieAnimationView = this$0.jumpToBottomFinishButtonIv;
        lottieAnimationView.playAnimation();
        lottieAnimationView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: re1.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.j(LottieAnimationView.this, this$0, valueAnimator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final LottieAnimationView this_apply, final e this$0, ValueAnimator valueAnimator) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (valueAnimator.getAnimatedFraction() == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this_apply.postDelayed(new Runnable() { // from class: re1.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.k(e.this, this_apply);
                }
            }, 700L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(e this$0, LottieAnimationView this_apply) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        te1.c.c(this$0.jumpToBottomFinishButton, 0L, 1, null);
        te1.c.f(this$0.jumpToBottomButtonFl, 0L, 1, null);
        this_apply.cancelAnimation();
        this_apply.setProgress(0.0f);
    }

    private final boolean m() {
        int i3 = this.answerDataState;
        if (i3 != 2 && i3 != 4) {
            return false;
        }
        return true;
    }

    private final boolean n() {
        if (this.chatRvList.U() > 0) {
            TouchCaptureRecyclerView touchCaptureRecyclerView = this.chatRvList;
            if (touchCaptureRecyclerView.canScrollVertically(touchCaptureRecyclerView.U())) {
                return true;
            }
        }
        return false;
    }

    private final void p(boolean show) {
        if (show) {
            this.jumpToBottomButton.setVisibility(0);
            this.jumpToBottomButtonFl.setVisibility(0);
        } else {
            this.jumpToBottomButton.setVisibility(4);
        }
    }

    public final void f(boolean forceNoShow, boolean forceCheckContentOverFlow) {
        boolean z16;
        if (forceNoShow) {
            this.jumpToBottomButton.setVisibility(4);
            return;
        }
        if (this.jumpToBottomButton.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || forceCheckContentOverFlow || !m()) {
            if (n()) {
                p(true);
            } else {
                p(false);
            }
        }
    }

    public final void h() {
        boolean z16;
        if (this.jumpToBottomButtonBg.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.jumpToBottomFinishButton.setVisibility(0);
            te1.c.b(this.jumpToBottomButtonBg, 200L);
            te1.c.b(this.jumpToBottomButtonFl, 200L);
            Function0.b(200, new Runnable() { // from class: re1.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.i(e.this);
                }
            });
            return;
        }
        this.jumpToBottomButtonFl.setVisibility(0);
    }

    public final void l() {
        boolean z16;
        if (n()) {
            if (this.jumpToBottomButtonBg.getVisibility() == 8) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.jumpToBottomButtonBg.setVisibility(0);
                p(true);
            }
        }
    }

    public final void o(int state) {
        this.answerDataState = state;
    }
}
