package xa2;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.view.StrokeTextView;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f447597a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f447598b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f447599c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f447600d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f447601e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final StrokeTextView f447602f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f447603g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f447604h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f447605i;

    h(@NonNull ConstraintLayout constraintLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull StrokeTextView strokeTextView, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ConstraintLayout constraintLayout3) {
        this.f447597a = constraintLayout;
        this.f447598b = lottieAnimationView;
        this.f447599c = imageView;
        this.f447600d = imageView2;
        this.f447601e = constraintLayout2;
        this.f447602f = strokeTextView;
        this.f447603g = imageView3;
        this.f447604h = imageView4;
        this.f447605i = constraintLayout3;
    }

    @NonNull
    public static h e(@NonNull View view) {
        int i3 = R.id.f164333s8;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.f164333s8);
        if (lottieAnimationView != null) {
            i3 = R.id.a2o;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.a2o);
            if (imageView != null) {
                i3 = R.id.f164546a31;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f164546a31);
                if (imageView2 != null) {
                    i3 = R.id.a39;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.a39);
                    if (constraintLayout != null) {
                        i3 = R.id.f97;
                        StrokeTextView strokeTextView = (StrokeTextView) ViewBindings.findChildViewById(view, R.id.f97);
                        if (strokeTextView != null) {
                            i3 = R.id.zxe;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.zxe);
                            if (imageView3 != null) {
                                i3 = R.id.f82904i5;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f82904i5);
                                if (imageView4 != null) {
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                    return new h(constraintLayout2, lottieAnimationView, imageView, imageView2, constraintLayout, strokeTextView, imageView3, imageView4, constraintLayout2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f447597a;
    }
}
