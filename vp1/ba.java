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
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMaskView;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ba implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f442381a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442382b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMaskView f442383c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442384d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442385e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442386f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442387g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442388h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442389i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f442390j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442391k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442392l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442393m;

    ba(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull ImageView imageView, @NonNull GuildHomeActiveChannelMaskView guildHomeActiveChannelMaskView, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView2, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView3, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView4, @NonNull LottieAnimationView lottieAnimationView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.f442381a = radiusFrameLayout;
        this.f442382b = imageView;
        this.f442383c = guildHomeActiveChannelMaskView;
        this.f442384d = guildHomeActiveChannelMicAvatarView;
        this.f442385e = guildHomeActiveChannelMicAvatarView2;
        this.f442386f = guildHomeActiveChannelMicAvatarView3;
        this.f442387g = guildHomeActiveChannelMicAvatarView4;
        this.f442388h = lottieAnimationView;
        this.f442389i = linearLayout;
        this.f442390j = imageView2;
        this.f442391k = textView;
        this.f442392l = linearLayout2;
        this.f442393m = textView2;
    }

    @NonNull
    public static ba e(@NonNull View view) {
        int i3 = R.id.sa6;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.sa6);
        if (imageView != null) {
            i3 = R.id.sa8;
            GuildHomeActiveChannelMaskView guildHomeActiveChannelMaskView = (GuildHomeActiveChannelMaskView) ViewBindings.findChildViewById(view, R.id.sa8);
            if (guildHomeActiveChannelMaskView != null) {
                i3 = R.id.sa_;
                GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView = (GuildHomeActiveChannelMicAvatarView) ViewBindings.findChildViewById(view, R.id.sa_);
                if (guildHomeActiveChannelMicAvatarView != null) {
                    i3 = R.id.saa;
                    GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView2 = (GuildHomeActiveChannelMicAvatarView) ViewBindings.findChildViewById(view, R.id.saa);
                    if (guildHomeActiveChannelMicAvatarView2 != null) {
                        i3 = R.id.sab;
                        GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView3 = (GuildHomeActiveChannelMicAvatarView) ViewBindings.findChildViewById(view, R.id.sab);
                        if (guildHomeActiveChannelMicAvatarView3 != null) {
                            i3 = R.id.sac;
                            GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView4 = (GuildHomeActiveChannelMicAvatarView) ViewBindings.findChildViewById(view, R.id.sac);
                            if (guildHomeActiveChannelMicAvatarView4 != null) {
                                i3 = R.id.xaf;
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.xaf);
                                if (lottieAnimationView != null) {
                                    i3 = R.id.xag;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xag);
                                    if (linearLayout != null) {
                                        i3 = R.id.xah;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.xah);
                                        if (imageView2 != null) {
                                            i3 = R.id.xai;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.xai);
                                            if (textView != null) {
                                                i3 = R.id.xaj;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xaj);
                                                if (linearLayout2 != null) {
                                                    i3 = R.id.ykm;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ykm);
                                                    if (textView2 != null) {
                                                        return new ba((RadiusFrameLayout) view, imageView, guildHomeActiveChannelMaskView, guildHomeActiveChannelMicAvatarView, guildHomeActiveChannelMicAvatarView2, guildHomeActiveChannelMicAvatarView3, guildHomeActiveChannelMicAvatarView4, lottieAnimationView, linearLayout, imageView2, textView, linearLayout2, textView2);
                                                    }
                                                }
                                            }
                                        }
                                    }
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
    public static ba g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ete, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f442381a;
    }
}
