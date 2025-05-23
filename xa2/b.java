package xa2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f447569a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final CircleBoarderImageView f447570b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f447571c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f447572d;

    b(@NonNull ConstraintLayout constraintLayout, @NonNull CircleBoarderImageView circleBoarderImageView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2) {
        this.f447569a = constraintLayout;
        this.f447570b = circleBoarderImageView;
        this.f447571c = imageView;
        this.f447572d = constraintLayout2;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.a2o;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) ViewBindings.findChildViewById(view, R.id.a2o);
        if (circleBoarderImageView != null) {
            i3 = R.id.f164546a31;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164546a31);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new b(constraintLayout, circleBoarderImageView, imageView, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fmu, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f447569a;
    }
}
