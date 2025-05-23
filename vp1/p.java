package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class p implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f443072a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f443073b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f443074c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUIPageTabBar f443075d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443076e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ViewPager f443077f;

    p(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull QUIPageTabBar qUIPageTabBar, @NonNull LinearLayout linearLayout2, @NonNull ViewPager viewPager) {
        this.f443072a = linearLayout;
        this.f443073b = imageView;
        this.f443074c = view;
        this.f443075d = qUIPageTabBar;
        this.f443076e = linearLayout2;
        this.f443077f = viewPager;
    }

    @NonNull
    public static p e(@NonNull View view) {
        int i3 = R.id.a4a;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.a4a);
        if (imageView != null) {
            i3 = R.id.bmt;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.bmt);
            if (findChildViewById != null) {
                i3 = R.id.f220702q;
                QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) ViewBindings.findChildViewById(view, R.id.f220702q);
                if (qUIPageTabBar != null) {
                    i3 = R.id.title_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.title_container);
                    if (linearLayout != null) {
                        i3 = R.id.kwk;
                        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.kwk);
                        if (viewPager != null) {
                            return new p((LinearLayout) view, imageView, findChildViewById, qUIPageTabBar, linearLayout, viewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static p g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168040eh2, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f443072a;
    }
}
