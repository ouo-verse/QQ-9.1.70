package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bd implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442420a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442421b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442422c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442423d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442424e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final GuildHomeActiveChannelMicAvatarView f442425f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442426g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442427h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f442428i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f442429j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442430k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f442431l;

    bd(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView2, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView3, @NonNull GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView4, @NonNull LottieAnimationView lottieAnimationView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.f442420a = constraintLayout;
        this.f442421b = imageView;
        this.f442422c = guildHomeActiveChannelMicAvatarView;
        this.f442423d = guildHomeActiveChannelMicAvatarView2;
        this.f442424e = guildHomeActiveChannelMicAvatarView3;
        this.f442425f = guildHomeActiveChannelMicAvatarView4;
        this.f442426g = lottieAnimationView;
        this.f442427h = linearLayout;
        this.f442428i = imageView2;
        this.f442429j = textView;
        this.f442430k = linearLayout2;
        this.f442431l = textView2;
    }

    @NonNull
    public static bd e(@NonNull View view) {
        int i3 = R.id.sa6;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.sa6);
        if (imageView != null) {
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
                                                    return new bd((ConstraintLayout) view, imageView, guildHomeActiveChannelMicAvatarView, guildHomeActiveChannelMicAvatarView2, guildHomeActiveChannelMicAvatarView3, guildHomeActiveChannelMicAvatarView4, lottieAnimationView, linearLayout, imageView2, textView, linearLayout2, textView2);
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
    public static bd g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eth, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMContainer() {
        return this.f442420a;
    }
}
