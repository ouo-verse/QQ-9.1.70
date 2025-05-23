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
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tx.x2j.GuildTopcardChatItemBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class du implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442994a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f442995b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442996c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442997d;

    du(@NonNull LinearLayout linearLayout, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.f442994a = linearLayout;
        this.f442995b = guildUserAvatarView;
        this.f442996c = linearLayout2;
        this.f442997d = textView;
    }

    @NonNull
    public static du e(@NonNull View view) {
        int i3 = R.id.f100145rp;
        GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.f100145rp);
        if (guildUserAvatarView != null) {
            i3 = R.id.f100155rq;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f100155rq);
            if (linearLayout != null) {
                i3 = R.id.f100165rr;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f100165rr);
                if (textView != null) {
                    return new du((LinearLayout) view, guildUserAvatarView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static du g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildTopcardChatItemBinding guildTopcardChatItemBinding = new GuildTopcardChatItemBinding();
        guildTopcardChatItemBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildTopcardChatItemBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f_4, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442994a;
    }
}
