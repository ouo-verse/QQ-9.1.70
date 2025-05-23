package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class aa implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442136a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442137b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442138c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442139d;

    aa(@NonNull View view, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull LottieAnimationView lottieAnimationView) {
        this.f442136a = view;
        this.f442137b = textView;
        this.f442138c = relativeLayout;
        this.f442139d = lottieAnimationView;
    }

    @NonNull
    public static aa e(@NonNull View view) {
        int i3 = R.id.ato;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ato);
        if (textView != null) {
            i3 = R.id.b8q;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.b8q);
            if (relativeLayout != null) {
                i3 = R.id.f1200878l;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.f1200878l);
                if (lottieAnimationView != null) {
                    return new aa(view, textView, relativeLayout, lottieAnimationView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aa f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.eip, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442136a;
    }
}
