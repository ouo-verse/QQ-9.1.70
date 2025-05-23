package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dk implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442924a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442925b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442926c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442927d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f442928e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442929f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442930g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442931h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f442932i;

    dk(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2, @NonNull TextView textView3, @NonNull ImageView imageView2) {
        this.f442924a = frameLayout;
        this.f442925b = imageView;
        this.f442926c = textView;
        this.f442927d = textView2;
        this.f442928e = view;
        this.f442929f = linearLayout;
        this.f442930g = frameLayout2;
        this.f442931h = textView3;
        this.f442932i = imageView2;
    }

    @NonNull
    public static dk e(@NonNull View view) {
        int i3 = R.id.f165621x01;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165621x01);
        if (imageView != null) {
            i3 = R.id.f165622x02;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165622x02);
            if (textView != null) {
                i3 = R.id.x0_;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.x0_);
                if (textView2 != null) {
                    i3 = R.id.x0c;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.x0c);
                    if (findChildViewById != null) {
                        i3 = R.id.x0d;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.x0d);
                        if (linearLayout != null) {
                            i3 = R.id.x0e;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.x0e);
                            if (frameLayout != null) {
                                i3 = R.id.x0f;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.x0f);
                                if (textView3 != null) {
                                    i3 = R.id.x0g;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.x0g);
                                    if (imageView2 != null) {
                                        return new dk((FrameLayout) view, imageView, textView, textView2, findChildViewById, linearLayout, frameLayout, textView3, imageView2);
                                    }
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
    public static dk g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static dk h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f7y, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442924a;
    }
}
