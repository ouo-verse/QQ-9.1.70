package r71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f430910a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f430911b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f430912c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f430913d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f430914e;

    a(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout2) {
        this.f430910a = frameLayout;
        this.f430911b = imageView;
        this.f430912c = linearLayout;
        this.f430913d = imageView2;
        this.f430914e = frameLayout2;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close);
        if (imageView != null) {
            i3 = R.id.content;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.content);
            if (linearLayout != null) {
                i3 = R.id.yrp;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.yrp);
                if (imageView2 != null) {
                    i3 = R.id.jsv;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.jsv);
                    if (frameLayout != null) {
                        return new a((FrameLayout) view, imageView, linearLayout, imageView2, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e_f, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f430910a;
    }
}
