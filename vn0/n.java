package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.title.GuildImmersiveTitleBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildAIOTitleBar;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class n implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f441980a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f441981b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildAIOTitleBar f441982c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildImmersiveTitleBar f441983d;

    n(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull GuildAIOTitleBar guildAIOTitleBar, @NonNull GuildImmersiveTitleBar guildImmersiveTitleBar) {
        this.f441980a = constraintLayout;
        this.f441981b = constraintLayout2;
        this.f441982c = guildAIOTitleBar;
        this.f441983d = guildImmersiveTitleBar;
    }

    @NonNull
    public static n e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i3 = R.id.x2f;
        GuildAIOTitleBar guildAIOTitleBar = (GuildAIOTitleBar) ViewBindings.findChildViewById(view, R.id.x2f);
        if (guildAIOTitleBar != null) {
            i3 = R.id.xl7;
            GuildImmersiveTitleBar guildImmersiveTitleBar = (GuildImmersiveTitleBar) ViewBindings.findChildViewById(view, R.id.xl7);
            if (guildImmersiveTitleBar != null) {
                return new n(constraintLayout, constraintLayout, guildAIOTitleBar, guildImmersiveTitleBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static n g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ef9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f441980a;
    }
}
