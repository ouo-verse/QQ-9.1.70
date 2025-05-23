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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class br implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f442562a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442563b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442564c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442565d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442566e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442567f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442568g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442569h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f442570i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f442571j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f442572k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442573l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442574m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final ImageView f442575n;

    br(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull View view, @NonNull ImageView imageView2, @NonNull View view2, @NonNull FrameLayout frameLayout, @NonNull RoundImageView roundImageView, @NonNull ImageView imageView3) {
        this.f442562a = radiusFrameLayout;
        this.f442563b = constraintLayout;
        this.f442564c = linearLayout;
        this.f442565d = textView;
        this.f442566e = linearLayout2;
        this.f442567f = textView2;
        this.f442568g = imageView;
        this.f442569h = textView3;
        this.f442570i = view;
        this.f442571j = imageView2;
        this.f442572k = view2;
        this.f442573l = frameLayout;
        this.f442574m = roundImageView;
        this.f442575n = imageView3;
    }

    @NonNull
    public static br e(@NonNull View view) {
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
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.tsf);
                            if (imageView != null) {
                                i3 = R.id.tsg;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tsg);
                                if (textView3 != null) {
                                    i3 = R.id.u_v;
                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.u_v);
                                    if (findChildViewById != null) {
                                        i3 = R.id.f164921bb4;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f164921bb4);
                                        if (imageView2 != null) {
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
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.z1x);
                                                        if (imageView3 != null) {
                                                            return new br((RadiusFrameLayout) view, constraintLayout, linearLayout, textView, linearLayout2, textView2, imageView, textView3, findChildViewById, imageView2, findChildViewById2, frameLayout, roundImageView, imageView3);
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
    public static br g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.euk, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f442562a;
    }
}
