package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ci implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442708a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442709b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442710c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442711d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442712e;

    ci(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2) {
        this.f442708a = frameLayout;
        this.f442709b = imageView;
        this.f442710c = textView;
        this.f442711d = imageView2;
        this.f442712e = textView2;
    }

    @NonNull
    public static ci e(@NonNull View view) {
        int i3 = R.id.uy8;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.uy8);
        if (imageView != null) {
            i3 = R.id.uya;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.uya);
            if (textView != null) {
                i3 = R.id.f165909du3;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165909du3);
                if (imageView2 != null) {
                    i3 = R.id.f107006_9;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f107006_9);
                    if (textView2 != null) {
                        return new ci((FrameLayout) view, imageView, textView, imageView2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ci g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f18, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442708a;
    }
}
