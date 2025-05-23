package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.main.channellist.view.RefreshHeader;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bu implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442591a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f442592b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FragmentContainerView f442593c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RefreshHeader f442594d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final SmartRefreshLayout f442595e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ViewStub f442596f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ViewStub f442597g;

    bu(@NonNull View view, @NonNull RecyclerView recyclerView, @NonNull FragmentContainerView fragmentContainerView, @NonNull RefreshHeader refreshHeader, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2) {
        this.f442591a = view;
        this.f442592b = recyclerView;
        this.f442593c = fragmentContainerView;
        this.f442594d = refreshHeader;
        this.f442595e = smartRefreshLayout;
        this.f442596f = viewStub;
        this.f442597g = viewStub2;
    }

    @NonNull
    public static bu e(@NonNull View view) {
        int i3 = R.id.ts5;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.ts5);
        if (recyclerView != null) {
            i3 = R.id.uis;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, R.id.uis);
            if (fragmentContainerView != null) {
                i3 = R.id.f72303qh;
                RefreshHeader refreshHeader = (RefreshHeader) ViewBindings.findChildViewById(view, R.id.f72303qh);
                if (refreshHeader != null) {
                    i3 = R.id.f72333qk;
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, R.id.f72333qk);
                    if (smartRefreshLayout != null) {
                        i3 = R.id.f89314zf;
                        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.f89314zf);
                        if (viewStub != null) {
                            i3 = R.id.f89384zm;
                            ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.f89384zm);
                            if (viewStub2 != null) {
                                return new bu(view, recyclerView, fragmentContainerView, refreshHeader, smartRefreshLayout, viewStub, viewStub2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bu f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.exi, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: getRoot */
    public View getMRv() {
        return this.f442591a;
    }
}
