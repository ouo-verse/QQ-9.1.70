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
public final class bs implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f442576a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final VoicingLinearLayout f442577b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442578c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442579d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442580e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442581f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442582g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442583h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f442584i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442585j;

    bs(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull VoicingLinearLayout voicingLinearLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull RoundImageView roundImageView) {
        this.f442576a = radiusFrameLayout;
        this.f442577b = voicingLinearLayout;
        this.f442578c = linearLayout;
        this.f442579d = textView;
        this.f442580e = linearLayout2;
        this.f442581f = textView2;
        this.f442582g = lottieAnimationView;
        this.f442583h = textView3;
        this.f442584i = imageView;
        this.f442585j = roundImageView;
    }

    @NonNull
    public static bs e(@NonNull View view) {
        int i3 = R.id.t1l;
        VoicingLinearLayout voicingLinearLayout = (VoicingLinearLayout) ViewBindings.findChildViewById(view, R.id.t1l);
        if (voicingLinearLayout != null) {
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
                                    i3 = R.id.bbd;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.bbd);
                                    if (imageView != null) {
                                        i3 = R.id.wic;
                                        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wic);
                                        if (roundImageView != null) {
                                            return new bs((RadiusFrameLayout) view, voicingLinearLayout, linearLayout, textView, linearLayout2, textView2, lottieAnimationView, textView3, imageView, roundImageView);
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
    public static bs g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eul, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f442576a;
    }
}
