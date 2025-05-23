package sw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQViewPager;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f434896a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QQViewPager f434897b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f434898c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TabLayout f434899d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final j f434900e;

    d(@NonNull ConstraintLayout constraintLayout, @NonNull QQViewPager qQViewPager, @NonNull FrameLayout frameLayout, @NonNull TabLayout tabLayout, @NonNull j jVar) {
        this.f434896a = constraintLayout;
        this.f434897b = qQViewPager;
        this.f434898c = frameLayout;
        this.f434899d = tabLayout;
        this.f434900e = jVar;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.f164772au1;
        QQViewPager qQViewPager = (QQViewPager) ViewBindings.findChildViewById(view, R.id.f164772au1);
        if (qQViewPager != null) {
            i3 = R.id.ixw;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.ixw);
            if (frameLayout != null) {
                i3 = R.id.ixv;
                TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.ixv);
                if (tabLayout != null) {
                    i3 = R.id.jo9;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.jo9);
                    if (findChildViewById != null) {
                        return new d((ConstraintLayout) view, qQViewPager, frameLayout, tabLayout, j.e(findChildViewById));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static d h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168230fe1, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f434896a;
    }
}
