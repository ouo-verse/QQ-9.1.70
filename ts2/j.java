package ts2;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f437412a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f437413b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f437414c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUISecNavBar f437415d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QUIPageTabBar f437416e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f437417f;

    j(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull QUISecNavBar qUISecNavBar, @NonNull QUIPageTabBar qUIPageTabBar, @NonNull ViewPager2 viewPager2) {
        this.f437412a = constraintLayout;
        this.f437413b = imageView;
        this.f437414c = constraintLayout2;
        this.f437415d = qUISecNavBar;
        this.f437416e = qUIPageTabBar;
        this.f437417f = viewPager2;
    }

    @NonNull
    public static j e(@NonNull View view) {
        int i3 = R.id.var;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.var);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i3 = R.id.jo9;
            QUISecNavBar qUISecNavBar = (QUISecNavBar) ViewBindings.findChildViewById(view, R.id.jo9);
            if (qUISecNavBar != null) {
                i3 = R.id.f1038261n;
                QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) ViewBindings.findChildViewById(view, R.id.f1038261n);
                if (qUIPageTabBar != null) {
                    i3 = R.id.kwk;
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.kwk);
                    if (viewPager2 != null) {
                        return new j(constraintLayout, imageView, constraintLayout, qUISecNavBar, qUIPageTabBar, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMRv() {
        return this.f437412a;
    }
}
