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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bm implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442505a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442506b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442507c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442508d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442509e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442510f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f442511g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442512h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f442513i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f442514j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442515k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442516l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final ImageView f442517m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442518n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f442519o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442520p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final TextView f442521q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442522r;

    bm(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull View view, @NonNull RoundImageView roundImageView, @NonNull TextView textView, @NonNull View view2, @NonNull FrameLayout frameLayout2, @NonNull LottieAnimationView lottieAnimationView, @NonNull ImageView imageView6, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout3) {
        this.f442505a = frameLayout;
        this.f442506b = imageView;
        this.f442507c = imageView2;
        this.f442508d = imageView3;
        this.f442509e = imageView4;
        this.f442510f = imageView5;
        this.f442511g = view;
        this.f442512h = roundImageView;
        this.f442513i = textView;
        this.f442514j = view2;
        this.f442515k = frameLayout2;
        this.f442516l = lottieAnimationView;
        this.f442517m = imageView6;
        this.f442518n = linearLayout;
        this.f442519o = textView2;
        this.f442520p = linearLayout2;
        this.f442521q = textView3;
        this.f442522r = linearLayout3;
    }

    @NonNull
    public static bm e(@NonNull View view) {
        int i3 = R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_back);
        if (imageView != null) {
            i3 = R.id.tfe;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.tfe);
            if (imageView2 != null) {
                i3 = R.id.tfo;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.tfo);
                if (imageView3 != null) {
                    i3 = R.id.aju;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.aju);
                    if (imageView4 != null) {
                        i3 = R.id.ak9;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.ak9);
                        if (imageView5 != null) {
                            i3 = R.id.uih;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.uih);
                            if (findChildViewById != null) {
                                i3 = R.id.vzu;
                                RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.vzu);
                                if (roundImageView != null) {
                                    i3 = R.id.w0j;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.w0j);
                                    if (textView != null) {
                                        i3 = R.id.woa;
                                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.woa);
                                        if (findChildViewById2 != null) {
                                            i3 = R.id.wob;
                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wob);
                                            if (frameLayout != null) {
                                                i3 = R.id.woc;
                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.woc);
                                                if (lottieAnimationView != null) {
                                                    i3 = R.id.wod;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.wod);
                                                    if (imageView6 != null) {
                                                        i3 = R.id.wpn;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wpn);
                                                        if (linearLayout != null) {
                                                            i3 = R.id.wqy;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.wqy);
                                                            if (textView2 != null) {
                                                                i3 = R.id.wrx;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wrx);
                                                                if (linearLayout2 != null) {
                                                                    i3 = R.id.f165583ws3;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f165583ws3);
                                                                    if (textView3 != null) {
                                                                        i3 = R.id.title_container;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.title_container);
                                                                        if (linearLayout3 != null) {
                                                                            return new bm((FrameLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, findChildViewById, roundImageView, textView, findChildViewById2, frameLayout, lottieAnimationView, imageView6, linearLayout, textView2, linearLayout2, textView3, linearLayout3);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bm g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eua, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442505a;
    }
}
