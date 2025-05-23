package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tx.x2j.GuildSettingMemberItemLayoutBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dn implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442954a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442955b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f442956c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442957d;

    dn(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull TextView textView) {
        this.f442954a = linearLayout;
        this.f442955b = imageView;
        this.f442956c = guildUserAvatarView;
        this.f442957d = textView;
    }

    @NonNull
    public static dn e(@NonNull View view) {
        int i3 = R.id.xwg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.xwg);
        if (imageView != null) {
            i3 = R.id.f165880xy3;
            GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.f165880xy3);
            if (guildUserAvatarView != null) {
                i3 = R.id.xy6;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.xy6);
                if (textView != null) {
                    return new dn((LinearLayout) view, imageView, guildUserAvatarView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static dn g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildSettingMemberItemLayoutBinding guildSettingMemberItemLayoutBinding = new GuildSettingMemberItemLayoutBinding();
        guildSettingMemberItemLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildSettingMemberItemLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f8h, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442954a;
    }
}
