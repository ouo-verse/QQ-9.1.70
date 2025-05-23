package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bp implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f442537a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442538b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442539c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442540d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442541e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442542f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442543g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442544h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f442545i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f442546j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f442547k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442548l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442549m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final ImageView f442550n;

    bp(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView3, @NonNull View view, @NonNull ImageView imageView, @NonNull View view2, @NonNull FrameLayout frameLayout, @NonNull RoundImageView roundImageView, @NonNull ImageView imageView2) {
        this.f442537a = radiusFrameLayout;
        this.f442538b = constraintLayout;
        this.f442539c = linearLayout;
        this.f442540d = textView;
        this.f442541e = linearLayout2;
        this.f442542f = textView2;
        this.f442543g = lottieAnimationView;
        this.f442544h = textView3;
        this.f442545i = view;
        this.f442546j = imageView;
        this.f442547k = view2;
        this.f442548l = frameLayout;
        this.f442549m = roundImageView;
        this.f442550n = imageView2;
    }

    @NonNull
    public static bp e(@NonNull View view) {
        int i3 = R.id.a7v;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.a7v);
        if (constraintLayout != null) {
            i3 = R.id.t_u;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.t_u);
            if (linearLayout != null) {
                i3 = R.id.adg;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.adg);
                if (textView != null) {
                    i3 = R.id.f164767ts0;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f164767ts0);
                    if (linearLayout2 != null) {
                        i3 = R.id.ato;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ato);
                        if (textView2 != null) {
                            i3 = R.id.tsf;
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.tsf);
                            if (lottieAnimationView != null) {
                                i3 = R.id.tsg;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tsg);
                                if (textView3 != null) {
                                    i3 = R.id.u_v;
                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.u_v);
                                    if (findChildViewById != null) {
                                        i3 = R.id.f164921bb4;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164921bb4);
                                        if (imageView != null) {
                                            i3 = R.id.ua9;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.ua9);
                                            if (findChildViewById2 != null) {
                                                i3 = R.id.v5q;
                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.v5q);
                                                if (frameLayout != null) {
                                                    i3 = R.id.wic;
                                                    RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wic);
                                                    if (roundImageView != null) {
                                                        i3 = R.id.z1x;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.z1x);
                                                        if (imageView2 != null) {
                                                            return new bp((RadiusFrameLayout) view, constraintLayout, linearLayout, textView, linearLayout2, textView2, lottieAnimationView, textView3, findChildViewById, imageView, findChildViewById2, frameLayout, roundImageView, imageView2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bp g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eug, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f442537a;
    }
}
