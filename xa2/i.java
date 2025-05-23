package xa2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.base.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f447606a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f447607b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f447608c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f447609d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f447610e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RoundRectImageView f447611f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f447612g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f447613h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f447614i;

    i(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull RoundRectImageView roundRectImageView, @NonNull TextView textView, @NonNull ImageView imageView5, @NonNull ConstraintLayout constraintLayout2) {
        this.f447606a = constraintLayout;
        this.f447607b = imageView;
        this.f447608c = imageView2;
        this.f447609d = imageView3;
        this.f447610e = imageView4;
        this.f447611f = roundRectImageView;
        this.f447612g = textView;
        this.f447613h = imageView5;
        this.f447614i = constraintLayout2;
    }

    @NonNull
    public static i e(@NonNull View view) {
        int i3 = R.id.f164472yw;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164472yw);
        if (imageView != null) {
            i3 = R.id.f164690ti1;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f164690ti1);
            if (imageView2 != null) {
                i3 = R.id.yx5;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.yx5);
                if (imageView3 != null) {
                    i3 = R.id.zxe;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.zxe);
                    if (imageView4 != null) {
                        i3 = R.id.f88264wl;
                        RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.f88264wl);
                        if (roundRectImageView != null) {
                            i3 = R.id.j2b;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.j2b);
                            if (textView != null) {
                                i3 = R.id.f95535f9;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f95535f9);
                                if (imageView5 != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                    return new i(constraintLayout, imageView, imageView2, imageView3, imageView4, roundRectImageView, textView, imageView5, constraintLayout);
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
        return this.f447606a;
    }
}
