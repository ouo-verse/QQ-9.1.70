package vp1;

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

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ce implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442684a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442685b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442686c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442687d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442688e;

    ce(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView) {
        this.f442684a = constraintLayout;
        this.f442685b = imageView;
        this.f442686c = imageView2;
        this.f442687d = constraintLayout2;
        this.f442688e = textView;
    }

    @NonNull
    public static ce e(@NonNull View view) {
        int i3 = R.id.y1e;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.y1e);
        if (imageView != null) {
            i3 = R.id.dvu;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.dvu);
            if (imageView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i3 = R.id.tv_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name);
                if (textView != null) {
                    return new ce(constraintLayout, imageView, imageView2, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ce g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168140f12, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442684a;
    }
}
