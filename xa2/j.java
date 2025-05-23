package xa2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.base.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f447615a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f447616b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f447617c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f447618d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f447619e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RoundRectImageView f447620f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f447621g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f447622h;

    j(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull RoundRectImageView roundRectImageView, @NonNull ImageView imageView4, @NonNull TextView textView) {
        this.f447615a = constraintLayout;
        this.f447616b = constraintLayout2;
        this.f447617c = imageView;
        this.f447618d = imageView2;
        this.f447619e = imageView3;
        this.f447620f = roundRectImageView;
        this.f447621g = imageView4;
        this.f447622h = textView;
    }

    @NonNull
    public static j e(@NonNull View view) {
        int i3 = R.id.f164690ti1;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.f164690ti1);
        if (constraintLayout != null) {
            i3 = R.id.yx5;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.yx5);
            if (imageView != null) {
                i3 = R.id.zxa;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.zxa);
                if (imageView2 != null) {
                    i3 = R.id.f82904i5;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f82904i5);
                    if (imageView3 != null) {
                        i3 = R.id.f88264wl;
                        RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.f88264wl);
                        if (roundRectImageView != null) {
                            i3 = R.id.f88274wm;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f88274wm);
                            if (imageView4 != null) {
                                i3 = R.id.j2b;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.j2b);
                                if (textView != null) {
                                    return new j((ConstraintLayout) view, constraintLayout, imageView, imageView2, imageView3, roundRectImageView, imageView4, textView);
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
    public static j g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fnt, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f447615a;
    }
}
