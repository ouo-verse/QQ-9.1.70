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
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.widget.GuildMediaNetStatusView;
import com.tencent.mobileqq.guild.media.widget.GuildMediaVoiceMicView;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;
import com.tx.x2j.GuildAudioMediaItemViewBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class n implements ViewBinding {

    @NonNull
    public final GuildMediaNetStatusView A;

    @NonNull
    public final LinearLayout B;

    @NonNull
    public final View C;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f443040a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f443041b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f443042c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443043d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final GuildMediaNetStatusView f443044e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f443045f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f443046g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443047h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f443048i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final GuildWavAvatarImageView f443049j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final GuildMediaVoiceMicView f443050k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f443051l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f443052m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final ImageView f443053n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final FrameLayout f443054o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f443055p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final ImageView f443056q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final TextView f443057r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final TextView f443058s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443059t;

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    public final ImageView f443060u;

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    public final FrameLayout f443061v;

    /* renamed from: w, reason: collision with root package name */
    @NonNull
    public final ImageView f443062w;

    /* renamed from: x, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443063x;

    /* renamed from: y, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443064y;

    /* renamed from: z, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443065z;

    n(@NonNull RelativeLayout relativeLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull GuildMediaNetStatusView guildMediaNetStatusView, @NonNull View view, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull GuildWavAvatarImageView guildWavAvatarImageView, @NonNull GuildMediaVoiceMicView guildMediaVoiceMicView, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout2, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView4, @NonNull FrameLayout frameLayout3, @NonNull ImageView imageView5, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull GuildMediaNetStatusView guildMediaNetStatusView2, @NonNull LinearLayout linearLayout7, @NonNull View view2) {
        this.f443040a = relativeLayout;
        this.f443041b = lottieAnimationView;
        this.f443042c = frameLayout;
        this.f443043d = linearLayout;
        this.f443044e = guildMediaNetStatusView;
        this.f443045f = view;
        this.f443046g = textView;
        this.f443047h = linearLayout2;
        this.f443048i = textView2;
        this.f443049j = guildWavAvatarImageView;
        this.f443050k = guildMediaVoiceMicView;
        this.f443051l = imageView;
        this.f443052m = textView3;
        this.f443053n = imageView2;
        this.f443054o = frameLayout2;
        this.f443055p = relativeLayout2;
        this.f443056q = imageView3;
        this.f443057r = textView4;
        this.f443058s = textView5;
        this.f443059t = linearLayout3;
        this.f443060u = imageView4;
        this.f443061v = frameLayout3;
        this.f443062w = imageView5;
        this.f443063x = linearLayout4;
        this.f443064y = linearLayout5;
        this.f443065z = linearLayout6;
        this.A = guildMediaNetStatusView2;
        this.B = linearLayout7;
        this.C = view2;
    }

    @NonNull
    public static n e(@NonNull View view) {
        int i3 = R.id.f164511sx4;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.f164511sx4);
        if (lottieAnimationView != null) {
            i3 = R.id.l_j;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.l_j);
            if (frameLayout != null) {
                i3 = R.id.tq8;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.tq8);
                if (linearLayout != null) {
                    i3 = R.id.vjz;
                    GuildMediaNetStatusView guildMediaNetStatusView = (GuildMediaNetStatusView) ViewBindings.findChildViewById(view, R.id.vjz);
                    if (guildMediaNetStatusView != null) {
                        i3 = R.id.f165364vp0;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f165364vp0);
                        if (findChildViewById != null) {
                            i3 = R.id.vwy;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vwy);
                            if (textView != null) {
                                i3 = R.id.f165430vz0;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165430vz0);
                                if (linearLayout2 != null) {
                                    i3 = R.id.f165431vz1;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f165431vz1);
                                    if (textView2 != null) {
                                        i3 = R.id.f165434vz4;
                                        GuildWavAvatarImageView guildWavAvatarImageView = (GuildWavAvatarImageView) ViewBindings.findChildViewById(view, R.id.f165434vz4);
                                        if (guildWavAvatarImageView != null) {
                                            i3 = R.id.vz5;
                                            GuildMediaVoiceMicView guildMediaVoiceMicView = (GuildMediaVoiceMicView) ViewBindings.findChildViewById(view, R.id.vz5);
                                            if (guildMediaVoiceMicView != null) {
                                                i3 = R.id.vz6;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.vz6);
                                                if (imageView != null) {
                                                    i3 = R.id.vz7;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.vz7);
                                                    if (textView3 != null) {
                                                        i3 = R.id.vz8;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.vz8);
                                                        if (imageView2 != null) {
                                                            i3 = R.id.vz_;
                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.vz_);
                                                            if (frameLayout2 != null) {
                                                                RelativeLayout relativeLayout = (RelativeLayout) view;
                                                                i3 = R.id.vzd;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.vzd);
                                                                if (imageView3 != null) {
                                                                    i3 = R.id.vze;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.vze);
                                                                    if (textView4 != null) {
                                                                        i3 = R.id.vzf;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.vzf);
                                                                        if (textView5 != null) {
                                                                            i3 = R.id.vzg;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vzg);
                                                                            if (linearLayout3 != null) {
                                                                                i3 = R.id.wqm;
                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.wqm);
                                                                                if (imageView4 != null) {
                                                                                    i3 = R.id.wqn;
                                                                                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wqn);
                                                                                    if (frameLayout3 != null) {
                                                                                        i3 = R.id.x4f;
                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.x4f);
                                                                                        if (imageView5 != null) {
                                                                                            i3 = R.id.d_8;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.d_8);
                                                                                            if (linearLayout4 != null) {
                                                                                                i3 = R.id.xe6;
                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xe6);
                                                                                                if (linearLayout5 != null) {
                                                                                                    i3 = R.id.xxp;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xxp);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i3 = R.id.zph;
                                                                                                        GuildMediaNetStatusView guildMediaNetStatusView2 = (GuildMediaNetStatusView) ViewBindings.findChildViewById(view, R.id.zph);
                                                                                                        if (guildMediaNetStatusView2 != null) {
                                                                                                            i3 = R.id.f88224wh;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f88224wh);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                i3 = R.id.f96545hz;
                                                                                                                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f96545hz);
                                                                                                                if (findChildViewById2 != null) {
                                                                                                                    return new n(relativeLayout, lottieAnimationView, frameLayout, linearLayout, guildMediaNetStatusView, findChildViewById, textView, linearLayout2, textView2, guildWavAvatarImageView, guildMediaVoiceMicView, imageView, textView3, imageView2, frameLayout2, relativeLayout, imageView3, textView4, textView5, linearLayout3, imageView4, frameLayout3, imageView5, linearLayout4, linearLayout5, linearLayout6, guildMediaNetStatusView2, linearLayout7, findChildViewById2);
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
    public static n g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildAudioMediaItemViewBinding guildAudioMediaItemViewBinding = new GuildAudioMediaItemViewBinding();
        guildAudioMediaItemViewBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildAudioMediaItemViewBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.egf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f443040a;
    }
}
