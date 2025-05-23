package sw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f434889a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f434890b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f434891c;

    b(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefreshLayout) {
        this.f434889a = constraintLayout;
        this.f434890b = recyclerView;
        this.f434891c = swipeRefreshLayout;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.f165399cy0;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f165399cy0);
        if (recyclerView != null) {
            i3 = R.id.vun;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, R.id.vun);
            if (swipeRefreshLayout != null) {
                return new b((ConstraintLayout) view, recyclerView, swipeRefreshLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eda, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f434889a;
    }
}
