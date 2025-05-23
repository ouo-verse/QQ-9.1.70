package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f441919a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f441920b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f441921c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f441922d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f441923e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f441924f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f441925g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f441926h;

    c(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7) {
        this.f441919a = constraintLayout;
        this.f441920b = imageView;
        this.f441921c = imageView2;
        this.f441922d = imageView3;
        this.f441923e = imageView4;
        this.f441924f = imageView5;
        this.f441925g = imageView6;
        this.f441926h = imageView7;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.usd;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.usd);
        if (imageView != null) {
            i3 = R.id.use;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.use);
            if (imageView2 != null) {
                i3 = R.id.usf;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.usf);
                if (imageView3 != null) {
                    i3 = R.id.usg;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.usg);
                    if (imageView4 != null) {
                        i3 = R.id.ush;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.ush);
                        if (imageView5 != null) {
                            i3 = R.id.usi;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.usi);
                            if (imageView6 != null) {
                                i3 = R.id.usj;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.usj);
                                if (imageView7 != null) {
                                    return new c((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7);
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
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eed, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f441919a;
    }
}
