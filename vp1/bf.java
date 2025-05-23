package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bf implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442442a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442443b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f442444c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f442445d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442446e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442447f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442448g;

    bf(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull View view2, @NonNull LottieAnimationView lottieAnimationView, @NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.f442442a = constraintLayout;
        this.f442443b = imageView;
        this.f442444c = view;
        this.f442445d = view2;
        this.f442446e = lottieAnimationView;
        this.f442447f = linearLayout;
        this.f442448g = textView;
    }

    @NonNull
    public static bf e(@NonNull View view) {
        int i3 = R.id.sa6;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.sa6);
        if (imageView != null) {
            i3 = R.id.u_v;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.u_v);
            if (findChildViewById != null) {
                i3 = R.id.ua9;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.ua9);
                if (findChildViewById2 != null) {
                    i3 = R.id.xaf;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.xaf);
                    if (lottieAnimationView != null) {
                        i3 = R.id.xag;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xag);
                        if (linearLayout != null) {
                            i3 = R.id.ykm;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ykm);
                            if (textView != null) {
                                return new bf((ConstraintLayout) view, imageView, findChildViewById, findChildViewById2, lottieAnimationView, linearLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bf g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.etk, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442442a;
    }
}
