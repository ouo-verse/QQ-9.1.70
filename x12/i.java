package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f446937a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f446938b;

    i(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView) {
        this.f446937a = frameLayout;
        this.f446938b = imageView;
    }

    @NonNull
    public static i e(@NonNull View view) {
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165569wp4);
        if (imageView != null) {
            return new i((FrameLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f165569wp4)));
    }

    @NonNull
    public static i g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static i h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eqp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f446937a;
    }
}
