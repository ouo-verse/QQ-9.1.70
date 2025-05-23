package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class s implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442022a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442023b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442024c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442025d;

    s(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinearLayout linearLayout2) {
        this.f442022a = linearLayout;
        this.f442023b = imageView;
        this.f442024c = textView;
        this.f442025d = linearLayout2;
    }

    @NonNull
    public static s e(@NonNull View view) {
        int i3 = R.id.vs9;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.vs9);
        if (imageView != null) {
            i3 = R.id.vsc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vsc);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new s(linearLayout, imageView, textView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static s g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static s h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ekb, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442022a;
    }
}
