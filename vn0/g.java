package vn0;

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
/* loaded from: classes6.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f441952a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f441953b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f441954c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f441955d;

    g(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView) {
        this.f441952a = constraintLayout;
        this.f441953b = imageView;
        this.f441954c = constraintLayout2;
        this.f441955d = textView;
    }

    @NonNull
    public static g e(@NonNull View view) {
        int i3 = R.id.icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jfb);
            if (textView != null) {
                return new g(constraintLayout, imageView, constraintLayout, textView);
            }
            i3 = R.id.jfb;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static g g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eep, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f441952a;
    }
}
