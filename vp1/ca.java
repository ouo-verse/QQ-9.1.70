package vp1;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileRefreshHeader;
import com.tencent.mobileqq.guild.widget.GuildSmartRefreshLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ca implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442663a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f442664b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildProfileRefreshHeader f442665c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildSmartRefreshLayout f442666d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ScanningLightView f442667e;

    ca(@NonNull FrameLayout frameLayout, @NonNull RecyclerView recyclerView, @NonNull GuildProfileRefreshHeader guildProfileRefreshHeader, @NonNull GuildSmartRefreshLayout guildSmartRefreshLayout, @NonNull ScanningLightView scanningLightView) {
        this.f442663a = frameLayout;
        this.f442664b = recyclerView;
        this.f442665c = guildProfileRefreshHeader;
        this.f442666d = guildSmartRefreshLayout;
        this.f442667e = scanningLightView;
    }

    @NonNull
    public static ca e(@NonNull View view) {
        int i3 = R.id.i4m;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.i4m);
        if (recyclerView != null) {
            i3 = R.id.f72303qh;
            GuildProfileRefreshHeader guildProfileRefreshHeader = (GuildProfileRefreshHeader) ViewBindings.findChildViewById(view, R.id.f72303qh);
            if (guildProfileRefreshHeader != null) {
                i3 = R.id.f72333qk;
                GuildSmartRefreshLayout guildSmartRefreshLayout = (GuildSmartRefreshLayout) ViewBindings.findChildViewById(view, R.id.f72333qk);
                if (guildSmartRefreshLayout != null) {
                    i3 = R.id.f79684_f;
                    ScanningLightView scanningLightView = (ScanningLightView) ViewBindings.findChildViewById(view, R.id.f79684_f);
                    if (scanningLightView != null) {
                        return new ca((FrameLayout) view, recyclerView, guildProfileRefreshHeader, guildSmartRefreshLayout, scanningLightView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getMContainer() {
        return this.f442663a;
    }
}
