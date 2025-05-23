package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.contentshare.widget.BounceScrollView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dp implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final BounceScrollView f442962a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442963b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442964c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442965d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442966e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442967f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442968g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f442969h;

    dp(@NonNull BounceScrollView bounceScrollView, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout4, @NonNull ImageView imageView2) {
        this.f442962a = bounceScrollView;
        this.f442963b = constraintLayout;
        this.f442964c = frameLayout;
        this.f442965d = frameLayout2;
        this.f442966e = frameLayout3;
        this.f442967f = imageView;
        this.f442968g = frameLayout4;
        this.f442969h = imageView2;
    }

    @NonNull
    public static dp e(@NonNull View view) {
        int i3 = R.id.t68;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.t68);
        if (constraintLayout != null) {
            i3 = R.id.laf;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.laf);
            if (frameLayout != null) {
                i3 = R.id.b9s;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.b9s);
                if (frameLayout2 != null) {
                    i3 = R.id.lkl;
                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.lkl);
                    if (frameLayout3 != null) {
                        i3 = R.id.zwf;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.zwf);
                        if (imageView != null) {
                            i3 = R.id.f79534_1;
                            FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f79534_1);
                            if (frameLayout4 != null) {
                                i3 = R.id.f100075ri;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f100075ri);
                                if (imageView2 != null) {
                                    return new dp((BounceScrollView) view, constraintLayout, frameLayout, frameLayout2, frameLayout3, imageView, frameLayout4, imageView2);
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
    public static dp g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f8p, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public BounceScrollView getRoot() {
        return this.f442962a;
    }
}
