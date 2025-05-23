package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.main.topchannel.widget.ChannelStatusView;
import com.tencent.mobileqq.guild.widget.shadow.GuildShadowLayout;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cz implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final GuildShadowLayout f442833a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442834b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442835c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442836d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ChannelStatusView f442837e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442838f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442839g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f442840h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442841i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442842j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442843k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f442844l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442845m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final QUIButton f442846n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f442847o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f442848p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final TextView f442849q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final GuildShadowLayout f442850r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final TextView f442851s;

    cz(@NonNull GuildShadowLayout guildShadowLayout, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ChannelStatusView channelStatusView, @NonNull LinearLayout linearLayout2, @NonNull RoundImageView roundImageView, @NonNull View view, @NonNull RoundImageView roundImageView2, @NonNull FrameLayout frameLayout, @NonNull RoundImageView roundImageView3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull QUIButton qUIButton, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull GuildShadowLayout guildShadowLayout2, @NonNull TextView textView6) {
        this.f442833a = guildShadowLayout;
        this.f442834b = relativeLayout;
        this.f442835c = linearLayout;
        this.f442836d = imageView;
        this.f442837e = channelStatusView;
        this.f442838f = linearLayout2;
        this.f442839g = roundImageView;
        this.f442840h = view;
        this.f442841i = roundImageView2;
        this.f442842j = frameLayout;
        this.f442843k = roundImageView3;
        this.f442844l = textView;
        this.f442845m = textView2;
        this.f442846n = qUIButton;
        this.f442847o = textView3;
        this.f442848p = textView4;
        this.f442849q = textView5;
        this.f442850r = guildShadowLayout2;
        this.f442851s = textView6;
    }

    @NonNull
    public static cz e(@NonNull View view) {
        int i3 = R.id.b8q;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.b8q);
        if (relativeLayout != null) {
            i3 = R.id.vvm;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vvm);
            if (linearLayout != null) {
                i3 = R.id.vvo;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.vvo);
                if (imageView != null) {
                    i3 = R.id.wv6;
                    ChannelStatusView channelStatusView = (ChannelStatusView) ViewBindings.findChildViewById(view, R.id.wv6);
                    if (channelStatusView != null) {
                        i3 = R.id.wv7;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wv7);
                        if (linearLayout2 != null) {
                            i3 = R.id.wv9;
                            RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wv9);
                            if (roundImageView != null) {
                                i3 = R.id.wv_;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.wv_);
                                if (findChildViewById != null) {
                                    i3 = R.id.wva;
                                    RoundImageView roundImageView2 = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wva);
                                    if (roundImageView2 != null) {
                                        i3 = R.id.wvb;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wvb);
                                        if (frameLayout != null) {
                                            i3 = R.id.wvc;
                                            RoundImageView roundImageView3 = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wvc);
                                            if (roundImageView3 != null) {
                                                i3 = R.id.wvd;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wvd);
                                                if (textView != null) {
                                                    i3 = R.id.wve;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.wve);
                                                    if (textView2 != null) {
                                                        i3 = R.id.wvm;
                                                        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.wvm);
                                                        if (qUIButton != null) {
                                                            i3 = R.id.wvn;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.wvn);
                                                            if (textView3 != null) {
                                                                i3 = R.id.wvo;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.wvo);
                                                                if (textView4 != null) {
                                                                    i3 = R.id.wvp;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.wvp);
                                                                    if (textView5 != null) {
                                                                        GuildShadowLayout guildShadowLayout = (GuildShadowLayout) view;
                                                                        i3 = R.id.jb7;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.jb7);
                                                                        if (textView6 != null) {
                                                                            return new cz(guildShadowLayout, relativeLayout, linearLayout, imageView, channelStatusView, linearLayout2, roundImageView, findChildViewById, roundImageView2, frameLayout, roundImageView3, textView, textView2, qUIButton, textView3, textView4, textView5, guildShadowLayout, textView6);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static cz g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168157f41, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public GuildShadowLayout getRoot() {
        return this.f442833a;
    }
}
