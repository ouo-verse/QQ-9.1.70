package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileRefreshFooter;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bx implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442625a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f442626b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f442627c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildProfileRefreshFooter f442628d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final SmartRefreshLayout f442629e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final OverScrollRecyclerViewWithHeaderFooter f442630f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442631g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final QUISearchBar f442632h;

    bx(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull GuildProfileRefreshFooter guildProfileRefreshFooter, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter, @NonNull FrameLayout frameLayout, @NonNull QUISearchBar qUISearchBar) {
        this.f442625a = linearLayout;
        this.f442626b = view;
        this.f442627c = recyclerView;
        this.f442628d = guildProfileRefreshFooter;
        this.f442629e = smartRefreshLayout;
        this.f442630f = overScrollRecyclerViewWithHeaderFooter;
        this.f442631g = frameLayout;
        this.f442632h = qUISearchBar;
    }

    @NonNull
    public static bx e(@NonNull View view) {
        int i3 = R.id.xl7;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.xl7);
        if (findChildViewById != null) {
            i3 = R.id.eoq;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.eoq);
            if (recyclerView != null) {
                i3 = R.id.f72283qf;
                GuildProfileRefreshFooter guildProfileRefreshFooter = (GuildProfileRefreshFooter) ViewBindings.findChildViewById(view, R.id.f72283qf);
                if (guildProfileRefreshFooter != null) {
                    i3 = R.id.f72333qk;
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, R.id.f72333qk);
                    if (smartRefreshLayout != null) {
                        i3 = R.id.f81054d5;
                        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) ViewBindings.findChildViewById(view, R.id.f81054d5);
                        if (overScrollRecyclerViewWithHeaderFooter != null) {
                            i3 = R.id.f81064d6;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f81064d6);
                            if (frameLayout != null) {
                                i3 = R.id.f81284dr;
                                QUISearchBar qUISearchBar = (QUISearchBar) ViewBindings.findChildViewById(view, R.id.f81284dr);
                                if (qUISearchBar != null) {
                                    return new bx((LinearLayout) view, findChildViewById, recyclerView, guildProfileRefreshFooter, smartRefreshLayout, overScrollRecyclerViewWithHeaderFooter, frameLayout, qUISearchBar);
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
    public static bx g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ezq, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442625a;
    }
}
