package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.view.VoicingLinearLayout;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bq implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f442551a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final VoicingLinearLayout f442552b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442553c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442554d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442555e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442556f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442557g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442558h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f442559i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442560j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f442561k;

    bq(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull VoicingLinearLayout voicingLinearLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView3, @NonNull RoundImageView roundImageView, @NonNull ImageView imageView2) {
        this.f442551a = radiusFrameLayout;
        this.f442552b = voicingLinearLayout;
        this.f442553c = linearLayout;
        this.f442554d = textView;
        this.f442555e = imageView;
        this.f442556f = linearLayout2;
        this.f442557g = textView2;
        this.f442558h = lottieAnimationView;
        this.f442559i = textView3;
        this.f442560j = roundImageView;
        this.f442561k = imageView2;
    }

    @NonNull
    public static bq e(@NonNull View view) {
        int i3 = R.id.t1l;
        VoicingLinearLayout voicingLinearLayout = (VoicingLinearLayout) ViewBindings.findChildViewById(view, R.id.t1l);
        if (voicingLinearLayout != null) {
            i3 = R.id.t_u;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.t_u);
            if (linearLayout != null) {
                i3 = R.id.adg;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.adg);
                if (textView != null) {
                    i3 = R.id.ton;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ton);
                    if (imageView != null) {
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
                                        i3 = R.id.wic;
                                        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wic);
                                        if (roundImageView != null) {
                                            i3 = R.id.z1x;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.z1x);
                                            if (imageView2 != null) {
                                                return new bq((RadiusFrameLayout) view, voicingLinearLayout, linearLayout, textView, imageView, linearLayout2, textView2, lottieAnimationView, textView3, roundImageView, imageView2);
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
    public static bq g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.euj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f442551a;
    }
}
