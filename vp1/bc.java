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
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bc implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f442407a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RadiusFrameLayout f442408b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442409c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442410d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442411e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442412f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442413g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442414h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442415i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f442416j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442417k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442418l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442419m;

    bc(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull RadiusFrameLayout radiusFrameLayout2, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView2, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView3, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView4, @NonNull ImageView imageView, @NonNull LottieAnimationView lottieAnimationView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.f442407a = radiusFrameLayout;
        this.f442408b = radiusFrameLayout2;
        this.f442409c = guildHomeActiveChannelMicAvatarView;
        this.f442410d = guildHomeActiveChannelMicAvatarView2;
        this.f442411e = guildHomeActiveChannelMicAvatarView3;
        this.f442412f = guildHomeActiveChannelMicAvatarView4;
        this.f442413g = imageView;
        this.f442414h = lottieAnimationView;
        this.f442415i = linearLayout;
        this.f442416j = imageView2;
        this.f442417k = textView;
        this.f442418l = linearLayout2;
        this.f442419m = textView2;
    }

    @NonNull
    public static bc e(@NonNull View view) {
        RadiusFrameLayout radiusFrameLayout = (RadiusFrameLayout) view;
        int i3 = R.id.sa_;
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
                        i3 = R.id.ton;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ton);
                        if (imageView != null) {
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
                                                    return new bc(radiusFrameLayout, radiusFrameLayout, guildHomeActiveChannelMicAvatarView, guildHomeActiveChannelMicAvatarView2, guildHomeActiveChannelMicAvatarView3, guildHomeActiveChannelMicAvatarView4, imageView, lottieAnimationView, linearLayout, imageView2, textView, linearLayout2, textView2);
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
    public static bc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.etg, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f442407a;
    }
}
