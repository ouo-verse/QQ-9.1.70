package wr2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.AIOInputSendBtn;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u001e\u0010\u0014\u001a\u00020\u000e2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020(8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\t\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b#\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010B\u001a\u00020<8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b7\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010I\u001a\u00020C8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b1\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010M\u00a8\u0006Q"}, d2 = {"Lwr2/a;", "", "Landroid/view/View;", "d", "Landroid/widget/TextView;", "c", "", "dpValue", "", "e", "", "needInputBarMask", "", "wording", "", "t", "b", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/view/AnimEndCallback;", "animEndCallback", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "j", "()Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/widget/RelativeLayout;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/widget/AppShortcutBarScrollView;", "Lcom/tencent/mobileqq/widget/AppShortcutBarScrollView;", "f", "()Lcom/tencent/mobileqq/widget/AppShortcutBarScrollView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/widget/AppShortcutBarScrollView;)V", "barScrollView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "l", "()Landroid/widget/LinearLayout;", ReportConstant.COSTREPORT_PREFIX, "(Landroid/widget/LinearLayout;)V", "voiceItemContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", h.F, "()Landroid/widget/ImageView;", "o", "(Landroid/widget/ImageView;)V", "closeImageView", "Landroid/view/View;", "g", "()Landroid/view/View;", DomainData.DOMAIN_NAME, "(Landroid/view/View;)V", "bottomMarginView", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "i", "()Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "p", "(Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;)V", "editText", "Lcom/tencent/mobileqq/aio/input/AIOInputSendBtn;", "Lcom/tencent/mobileqq/aio/input/AIOInputSendBtn;", "k", "()Lcom/tencent/mobileqq/aio/input/AIOInputSendBtn;", "r", "(Lcom/tencent/mobileqq/aio/input/AIOInputSendBtn;)V", "sendBtn", "Luu3/a;", "Luu3/a;", "inputBar", "Landroid/widget/TextView;", "inputBarMaskView", "<init>", "(Landroid/content/Context;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout rootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public AppShortcutBarScrollView barScrollView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public LinearLayout voiceItemContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ImageView closeImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public View bottomMarginView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public AIOEditText editText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public AIOInputSendBtn sendBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private uu3.a inputBar;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private TextView inputBarMaskView;

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        d();
    }

    private final TextView c() {
        TextView textView = new TextView(this.context);
        textView.setFocusable(true);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(0, TypedValue.applyDimension(2, 16.0f, textView.getContext().getResources().getDisplayMetrics()));
        textView.setGravity(17);
        textView.setFocusableInTouchMode(true);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.rightToRight = R.id.f17263;
        layoutParams.bottomToBottom = R.id.f17263;
        layoutParams.topToTop = R.id.f17263;
        layoutParams.leftToLeft = R.id.f17263;
        layoutParams.validate();
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundResource(R.drawable.f13489);
        textView.setTextColor(textView.getContext().getColorStateList(R.color.qui_common_text_primary));
        uu3.a aVar = this.inputBar;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBar");
            aVar = null;
        }
        aVar.getRoot().addView(textView);
        return textView;
    }

    private final View d() {
        int[] intArray;
        q(new RelativeLayout(this.context));
        j().setFocusable(true);
        s(new LinearLayout(this.context));
        l().setLayoutParams(new ViewGroup.LayoutParams(-1, e(30.0f)));
        l().setPadding(e(16.0f), 0, e(8.0f), 0);
        l().setOrientation(0);
        m(new AppShortcutBarScrollView(this.context));
        f().setId(R.id.f17274);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(0, R.id.f17241);
        f().setLayoutParams(layoutParams);
        f().setPadding(0, e(12.0f), 0, e(5.0f));
        f().setHorizontalScrollBarEnabled(false);
        f().setHorizontalFadingEdgeEnabled(false);
        f().addView(l());
        f().setInnerView(l());
        f().setMove(true);
        f().setAlpha(0.0f);
        j().addView(f());
        View linearLayout = new LinearLayout(this.context);
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        intArray = ArraysKt___ArraysKt.toIntArray(new Integer[]{Integer.valueOf(GuildUIUtils.f235378a.E(this.context.getColor(R.color.qui_common_bg_nav_bottom_aio), 0.0f)), Integer.valueOf(this.context.getColor(R.color.qui_common_bg_nav_bottom_aio))});
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, intArray);
        gradientDrawable.setShape(0);
        linearLayout.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(e(16.0f), e(30.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(0, R.id.f17241);
        layoutParams2.setMargins(0, e(12.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams2);
        j().addView(linearLayout);
        o(new ImageView(this.context));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(e(16.0f), e(16.0f));
        h().setId(R.id.f17241);
        h().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.qui_close));
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.setMargins(e(7.0f), e(19.0f), e(18.0f), e(7.0f));
        h().setLayoutParams(layoutParams3);
        h().setContentDescription(this.context.getString(R.string.f131092));
        j().addView(h());
        uu3.a g16 = uu3.a.g(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.inputBar = g16;
        uu3.a aVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBar");
            g16 = null;
        }
        g16.getRoot().setId(R.id.f17252);
        uu3.a aVar2 = this.inputBar;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBar");
            aVar2 = null;
        }
        aVar2.f440053b.setBackground(ContextCompat.getDrawable(this.context, R.drawable.f13489));
        uu3.a aVar3 = this.inputBar;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBar");
            aVar3 = null;
        }
        aVar3.f440053b.setId(R.id.f17263);
        uu3.a aVar4 = this.inputBar;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBar");
            aVar4 = null;
        }
        aVar4.getRoot().setBackground(null);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(3, R.id.f17274);
        uu3.a aVar5 = this.inputBar;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBar");
            aVar5 = null;
        }
        aVar5.getRoot().setLayoutParams(layoutParams4);
        uu3.a aVar6 = this.inputBar;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBar");
            aVar6 = null;
        }
        AIOEditText aIOEditText = aVar6.f440053b;
        Intrinsics.checkNotNullExpressionValue(aIOEditText, "inputBar.input");
        p(aIOEditText);
        i().setHint(this.context.getString(R.string.f131114));
        i().setTextColor(this.context.getColor(R.color.qui_common_text_primary));
        i().setHintTextColor(this.context.getColor(R.color.qui_common_text_secondary));
        i().setEditableFactory(((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getInputQQTextBuilder());
        uu3.a aVar7 = this.inputBar;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBar");
            aVar7 = null;
        }
        AIOInputSendBtn aIOInputSendBtn = aVar7.f440055d;
        Intrinsics.checkNotNullExpressionValue(aIOInputSendBtn, "inputBar.sendBtn");
        r(aIOInputSendBtn);
        k().setEnabled(false);
        RelativeLayout j3 = j();
        uu3.a aVar8 = this.inputBar;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBar");
        } else {
            aVar = aVar8;
        }
        j3.addView(aVar.getRoot());
        n(new View(this.context));
        g().setBackground(ContextCompat.getDrawable(this.context, R.drawable.qui_common_bg_bottom_standard_bg));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, e(34.0f));
        layoutParams5.addRule(3, R.id.f17252);
        g().setLayoutParams(layoutParams5);
        g().setVisibility(8);
        j().addView(g());
        return j();
    }

    private final int e(float dpValue) {
        return ViewUtils.dip2px(dpValue);
    }

    public final void a(Function0<Unit> animEndCallback) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(f(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
        animatorSet.setDuration(240L);
        animatorSet.addListener(new b(animEndCallback));
        animatorSet.start();
    }

    public final void b() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(f(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
        animatorSet.setDuration(240L);
        animatorSet.addListener(new c());
        animatorSet.start();
    }

    public final AppShortcutBarScrollView f() {
        AppShortcutBarScrollView appShortcutBarScrollView = this.barScrollView;
        if (appShortcutBarScrollView != null) {
            return appShortcutBarScrollView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("barScrollView");
        return null;
    }

    public final View g() {
        View view = this.bottomMarginView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bottomMarginView");
        return null;
    }

    public final ImageView h() {
        ImageView imageView = this.closeImageView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeImageView");
        return null;
    }

    public final AIOEditText i() {
        AIOEditText aIOEditText = this.editText;
        if (aIOEditText != null) {
            return aIOEditText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("editText");
        return null;
    }

    public final RelativeLayout j() {
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        return null;
    }

    public final AIOInputSendBtn k() {
        AIOInputSendBtn aIOInputSendBtn = this.sendBtn;
        if (aIOInputSendBtn != null) {
            return aIOInputSendBtn;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
        return null;
    }

    public final LinearLayout l() {
        LinearLayout linearLayout = this.voiceItemContainer;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("voiceItemContainer");
        return null;
    }

    public final void m(AppShortcutBarScrollView appShortcutBarScrollView) {
        Intrinsics.checkNotNullParameter(appShortcutBarScrollView, "<set-?>");
        this.barScrollView = appShortcutBarScrollView;
    }

    public final void n(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.bottomMarginView = view;
    }

    public final void o(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.closeImageView = imageView;
    }

    public final void p(AIOEditText aIOEditText) {
        Intrinsics.checkNotNullParameter(aIOEditText, "<set-?>");
        this.editText = aIOEditText;
    }

    public final void q(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.rootView = relativeLayout;
    }

    public final void r(AIOInputSendBtn aIOInputSendBtn) {
        Intrinsics.checkNotNullParameter(aIOInputSendBtn, "<set-?>");
        this.sendBtn = aIOInputSendBtn;
    }

    public final void s(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.voiceItemContainer = linearLayout;
    }

    public final void t(boolean needInputBarMask, String wording) {
        String string;
        Intrinsics.checkNotNullParameter(wording, "wording");
        i().setEnabled(!needInputBarMask);
        i().setFocusable(!needInputBarMask);
        i().setFocusableInTouchMode(!needInputBarMask);
        AIOEditText i3 = i();
        if (needInputBarMask) {
            string = "";
        } else {
            string = this.context.getString(R.string.f131114);
        }
        i3.setHint(string);
        if (needInputBarMask) {
            if (this.inputBarMaskView == null) {
                this.inputBarMaskView = c();
            }
            TextView textView = this.inputBarMaskView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.inputBarMaskView;
            if (textView2 == null) {
                return;
            }
            textView2.setText(wording);
            return;
        }
        TextView textView3 = this.inputBarMaskView;
        if (textView3 == null) {
            return;
        }
        textView3.setVisibility(8);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"wr2/a$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f446132d;

        b(Function0<Unit> function0) {
            this.f446132d = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Function0<Unit> function0 = this.f446132d;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"wr2/a$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            a.this.f().setAlpha(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            a.this.f().setAlpha(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
