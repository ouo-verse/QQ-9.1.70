package vp1;

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
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ShadowFrameLayout f443008a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f443009b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f443010c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f443011d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443012e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ShadowFrameLayout f443013f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f443014g;

    f(@NonNull ShadowFrameLayout shadowFrameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout, @NonNull ShadowFrameLayout shadowFrameLayout2, @NonNull TextView textView) {
        this.f443008a = shadowFrameLayout;
        this.f443009b = imageView;
        this.f443010c = imageView2;
        this.f443011d = imageView3;
        this.f443012e = linearLayout;
        this.f443013f = shadowFrameLayout2;
        this.f443014g = textView;
    }

    @NonNull
    public static f e(@NonNull View view) {
        int i3 = R.id.xzn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.xzn);
        if (imageView != null) {
            i3 = R.id.f165903y03;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165903y03);
            if (imageView2 != null) {
                i3 = R.id.f165918y20;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165918y20);
                if (imageView3 != null) {
                    i3 = R.id.iex;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.iex);
                    if (linearLayout != null) {
                        ShadowFrameLayout shadowFrameLayout = (ShadowFrameLayout) view;
                        i3 = R.id.f1060667p;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f1060667p);
                        if (textView != null) {
                            return new f(shadowFrameLayout, imageView, imageView2, imageView3, linearLayout, shadowFrameLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static f g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.efo, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ShadowFrameLayout getRoot() {
        return this.f443008a;
    }
}
