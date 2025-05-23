package ts2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.troop.shortcut.ui.DisableParentInterceptFrameLayout;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final DisableParentInterceptFrameLayout f437384a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f437385b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f437386c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f437387d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f437388e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f437389f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final DisableParentInterceptFrameLayout f437390g;

    f(@NonNull DisableParentInterceptFrameLayout disableParentInterceptFrameLayout, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull DisableParentInterceptFrameLayout disableParentInterceptFrameLayout2) {
        this.f437384a = disableParentInterceptFrameLayout;
        this.f437385b = frameLayout;
        this.f437386c = imageView;
        this.f437387d = constraintLayout;
        this.f437388e = view;
        this.f437389f = recyclerView;
        this.f437390g = disableParentInterceptFrameLayout2;
    }

    @NonNull
    public static f e(@NonNull View view) {
        int i3 = R.id.ucw;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.ucw);
        if (frameLayout != null) {
            i3 = R.id.xea;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.xea);
            if (imageView != null) {
                i3 = R.id.ywh;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.ywh);
                if (constraintLayout != null) {
                    i3 = R.id.f74733x2;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.f74733x2);
                    if (findChildViewById != null) {
                        i3 = R.id.f84714n0;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f84714n0);
                        if (recyclerView != null) {
                            DisableParentInterceptFrameLayout disableParentInterceptFrameLayout = (DisableParentInterceptFrameLayout) view;
                            return new f(disableParentInterceptFrameLayout, frameLayout, imageView, constraintLayout, findChildViewById, recyclerView, disableParentInterceptFrameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static f g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static f h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f169157i10, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public DisableParentInterceptFrameLayout getRoot() {
        return this.f437384a;
    }
}
