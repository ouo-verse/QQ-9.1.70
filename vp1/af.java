package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.create.widget.GuildCreateOperationIconView;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.proavatar.QQProAvatarView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class af implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442182a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildCreateOperationIconView f442183b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f442184c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QQProAvatarView f442185d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442186e;

    af(@NonNull LinearLayout linearLayout, @NonNull GuildCreateOperationIconView guildCreateOperationIconView, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull QQProAvatarView qQProAvatarView, @NonNull TextView textView) {
        this.f442182a = linearLayout;
        this.f442183b = guildCreateOperationIconView;
        this.f442184c = guildUserAvatarView;
        this.f442185d = qQProAvatarView;
        this.f442186e = textView;
    }

    @NonNull
    public static af e(@NonNull View view) {
        int i3 = R.id.xwg;
        GuildCreateOperationIconView guildCreateOperationIconView = (GuildCreateOperationIconView) ViewBindings.findChildViewById(view, R.id.xwg);
        if (guildCreateOperationIconView != null) {
            i3 = R.id.f165881xy4;
            GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.f165881xy4);
            if (guildUserAvatarView != null) {
                i3 = R.id.xy5;
                QQProAvatarView qQProAvatarView = (QQProAvatarView) ViewBindings.findChildViewById(view, R.id.xy5);
                if (qQProAvatarView != null) {
                    i3 = R.id.xy6;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.xy6);
                    if (textView != null) {
                        return new af((LinearLayout) view, guildCreateOperationIconView, guildUserAvatarView, qQProAvatarView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static af g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ek6, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getMRv() {
        return this.f442182a;
    }
}
