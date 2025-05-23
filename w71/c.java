package w71;

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

/* compiled from: P */
/* loaded from: classes10.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f444775a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f444776b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f444777c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f444778d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444779e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444780f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f444781g;

    c(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull TextView textView2) {
        this.f444775a = constraintLayout;
        this.f444776b = imageView;
        this.f444777c = textView;
        this.f444778d = linearLayout;
        this.f444779e = frameLayout;
        this.f444780f = frameLayout2;
        this.f444781g = textView2;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.f164128ka;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164128ka);
        if (imageView != null) {
            i3 = R.id.tht;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tht);
            if (textView != null) {
                i3 = R.id.dqy;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.dqy);
                if (linearLayout != null) {
                    i3 = R.id.f1198477y;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f1198477y);
                    if (frameLayout != null) {
                        i3 = R.id.f122227dd;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f122227dd);
                        if (frameLayout2 != null) {
                            i3 = R.id.f125007kw;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f125007kw);
                            if (textView2 != null) {
                                return new c((ConstraintLayout) view, imageView, textView, linearLayout, frameLayout, frameLayout2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static c g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static c h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dv_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f444775a;
    }
}
