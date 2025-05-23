package ts2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.troop.teamup.home.view.TeamUpFreshHeader;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f437418a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f437419b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TeamUpFreshHeader f437420c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final SmartRefreshLayout f437421d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RecyclerView f437422e;

    k(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TeamUpFreshHeader teamUpFreshHeader, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull RecyclerView recyclerView) {
        this.f437418a = constraintLayout;
        this.f437419b = imageView;
        this.f437420c = teamUpFreshHeader;
        this.f437421d = smartRefreshLayout;
        this.f437422e = recyclerView;
    }

    @NonNull
    public static k e(@NonNull View view) {
        int i3 = R.id.ysu;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ysu);
        if (imageView != null) {
            i3 = R.id.f72303qh;
            TeamUpFreshHeader teamUpFreshHeader = (TeamUpFreshHeader) ViewBindings.findChildViewById(view, R.id.f72303qh);
            if (teamUpFreshHeader != null) {
                i3 = R.id.f72333qk;
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, R.id.f72333qk);
                if (smartRefreshLayout != null) {
                    i3 = R.id.f93765ag;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f93765ag);
                    if (recyclerView != null) {
                        return new k((ConstraintLayout) view, imageView, teamUpFreshHeader, smartRefreshLayout, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static k g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static k h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.i1d, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMRv() {
        return this.f437418a;
    }
}
