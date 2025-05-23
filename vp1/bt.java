package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bt implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f442586a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442587b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f442588c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442589d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442590e;

    bt(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f442586a = relativeLayout;
        this.f442587b = textView;
        this.f442588c = guildUserAvatarView;
        this.f442589d = textView2;
        this.f442590e = textView3;
    }

    @NonNull
    public static bt e(@NonNull View view) {
        int i3 = R.id.wjb;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wjb);
        if (textView != null) {
            i3 = R.id.wjc;
            GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.wjc);
            if (guildUserAvatarView != null) {
                i3 = R.id.wje;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.wje);
                if (textView2 != null) {
                    i3 = R.id.wjf;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.wjf);
                    if (textView3 != null) {
                        return new bt((RelativeLayout) view, textView, guildUserAvatarView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bt g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eux, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f442586a;
    }
}
