package ts2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.TroopNotificationTabBar;
import com.tx.x2j.QbGroupHistoryNotificationLayoutBinding;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f437327a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUISecNavBar f437328b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437329c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f437330d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TroopNotificationTabBar f437331e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f437332f;

    a(@NonNull LinearLayout linearLayout, @NonNull QUISecNavBar qUISecNavBar, @NonNull LinearLayout linearLayout2, @NonNull FrameLayout frameLayout, @NonNull TroopNotificationTabBar troopNotificationTabBar, @NonNull ViewPager2 viewPager2) {
        this.f437327a = linearLayout;
        this.f437328b = qUISecNavBar;
        this.f437329c = linearLayout2;
        this.f437330d = frameLayout;
        this.f437331e = troopNotificationTabBar;
        this.f437332f = viewPager2;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.idz;
        QUISecNavBar qUISecNavBar = (QUISecNavBar) ViewBindings.findChildViewById(view, R.id.idz);
        if (qUISecNavBar != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i3 = R.id.f103115zq;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f103115zq);
            if (frameLayout != null) {
                i3 = R.id.f10329608;
                TroopNotificationTabBar troopNotificationTabBar = (TroopNotificationTabBar) ViewBindings.findChildViewById(view, R.id.f10329608);
                if (troopNotificationTabBar != null) {
                    i3 = R.id.f1034260k;
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.f1034260k);
                    if (viewPager2 != null) {
                        return new a(linearLayout, qUISecNavBar, linearLayout, frameLayout, troopNotificationTabBar, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        QbGroupHistoryNotificationLayoutBinding qbGroupHistoryNotificationLayoutBinding = new QbGroupHistoryNotificationLayoutBinding();
        qbGroupHistoryNotificationLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = qbGroupHistoryNotificationLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.fv_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getMRv() {
        return this.f437327a;
    }
}
