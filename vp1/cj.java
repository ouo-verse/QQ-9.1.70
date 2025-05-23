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
public final class cj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442713a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442714b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442715c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442716d;

    cj(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.f442713a = constraintLayout;
        this.f442714b = imageView;
        this.f442715c = imageView2;
        this.f442716d = textView;
    }

    @NonNull
    public static cj e(@NonNull View view) {
        int i3 = R.id.f165909du3;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165909du3);
        if (imageView != null) {
            i3 = R.id.y8a;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.y8a);
            if (imageView2 != null) {
                i3 = R.id.f107006_9;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f107006_9);
                if (textView != null) {
                    return new cj((ConstraintLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static cj g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f1_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442713a;
    }
}
