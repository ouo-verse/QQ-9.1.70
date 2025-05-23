package vn0;

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
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class aa implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f441899a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f441900b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f441901c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f441902d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f441903e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441904f;

    aa(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull LinearLayout linearLayout) {
        this.f441899a = constraintLayout;
        this.f441900b = imageView;
        this.f441901c = textView;
        this.f441902d = constraintLayout2;
        this.f441903e = textView2;
        this.f441904f = linearLayout;
    }

    @NonNull
    public static aa e(@NonNull View view) {
        int i3 = R.id.vs9;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.vs9);
        if (imageView != null) {
            i3 = R.id.vs_;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vs_);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i3 = R.id.vsh;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.vsh);
                if (textView2 != null) {
                    i3 = R.id.vsi;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vsi);
                    if (linearLayout != null) {
                        return new aa(constraintLayout, imageView, textView, constraintLayout, textView2, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aa g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f2f, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f441899a;
    }
}
