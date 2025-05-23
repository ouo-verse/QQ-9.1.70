package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildMainFrameLayout;
import com.tencent.mobileqq.guild.mainframe.view.GuildRoundRectLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ax implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final GuildMainFrameLayout f442331a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442332b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildRoundRectLayout f442333c;

    ax(@NonNull GuildMainFrameLayout guildMainFrameLayout, @NonNull FrameLayout frameLayout, @NonNull GuildRoundRectLayout guildRoundRectLayout) {
        this.f442331a = guildMainFrameLayout;
        this.f442332b = frameLayout;
        this.f442333c = guildRoundRectLayout;
    }

    @NonNull
    public static ax e(@NonNull View view) {
        int i3 = R.id.tub;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.tub);
        if (frameLayout != null) {
            i3 = R.id.uvi;
            GuildRoundRectLayout guildRoundRectLayout = (GuildRoundRectLayout) ViewBindings.findChildViewById(view, R.id.uvi);
            if (guildRoundRectLayout != null) {
                return new ax((GuildMainFrameLayout) view, frameLayout, guildRoundRectLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ax g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ese, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public GuildMainFrameLayout getRoot() {
        return this.f442331a;
    }
}
