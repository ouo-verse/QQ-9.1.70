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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.widget.GuildMediaNetStatusView;
import com.tencent.mobileqq.guild.media.widget.GuildMediaVoiceMicView;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ay implements ViewBinding {

    @NonNull
    public final LinearLayout A;

    @NonNull
    public final GuildMediaNetStatusView B;

    @NonNull
    public final ConstraintLayout C;

    @NonNull
    public final ImageView D;

    @NonNull
    public final ImageView E;

    @NonNull
    public final LinearLayout F;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442334a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f442335b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442336c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildWavAvatarImageView f442337d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final GuildMediaVoiceMicView f442338e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442339f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442340g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f442341h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442342i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f442343j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f442344k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442345l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final ImageView f442346m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f442347n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442348o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442349p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442350q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442351r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final ImageView f442352s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442353t;

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    public final TextView f442354u;

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442355v;

    /* renamed from: w, reason: collision with root package name */
    @NonNull
    public final TextView f442356w;

    /* renamed from: x, reason: collision with root package name */
    @NonNull
    public final ImageView f442357x;

    /* renamed from: y, reason: collision with root package name */
    @NonNull
    public final ImageView f442358y;

    /* renamed from: z, reason: collision with root package name */
    @NonNull
    public final TextView f442359z;

    ay(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull TextView textView, @NonNull GuildWavAvatarImageView guildWavAvatarImageView, @NonNull GuildMediaVoiceMicView guildMediaVoiceMicView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView3, @NonNull View view2, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView4, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull ImageView imageView5, @NonNull LinearLayout linearLayout5, @NonNull TextView textView3, @NonNull LinearLayout linearLayout6, @NonNull TextView textView4, @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull TextView textView5, @NonNull LinearLayout linearLayout7, @NonNull GuildMediaNetStatusView guildMediaNetStatusView, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView8, @NonNull ImageView imageView9, @NonNull LinearLayout linearLayout8) {
        this.f442334a = constraintLayout;
        this.f442335b = view;
        this.f442336c = textView;
        this.f442337d = guildWavAvatarImageView;
        this.f442338e = guildMediaVoiceMicView;
        this.f442339f = imageView;
        this.f442340g = frameLayout;
        this.f442341h = imageView2;
        this.f442342i = frameLayout2;
        this.f442343j = imageView3;
        this.f442344k = view2;
        this.f442345l = linearLayout;
        this.f442346m = imageView4;
        this.f442347n = textView2;
        this.f442348o = linearLayout2;
        this.f442349p = relativeLayout;
        this.f442350q = linearLayout3;
        this.f442351r = linearLayout4;
        this.f442352s = imageView5;
        this.f442353t = linearLayout5;
        this.f442354u = textView3;
        this.f442355v = linearLayout6;
        this.f442356w = textView4;
        this.f442357x = imageView6;
        this.f442358y = imageView7;
        this.f442359z = textView5;
        this.A = linearLayout7;
        this.B = guildMediaNetStatusView;
        this.C = constraintLayout2;
        this.D = imageView8;
        this.E = imageView9;
        this.F = linearLayout8;
    }

    @NonNull
    public static ay e(@NonNull View view) {
        int i3 = R.id.f165323vj1;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f165323vj1);
        if (findChildViewById != null) {
            i3 = R.id.vwy;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vwy);
            if (textView != null) {
                i3 = R.id.f165434vz4;
                GuildWavAvatarImageView guildWavAvatarImageView = (GuildWavAvatarImageView) ViewBindings.findChildViewById(view, R.id.f165434vz4);
                if (guildWavAvatarImageView != null) {
                    i3 = R.id.vz5;
                    GuildMediaVoiceMicView guildMediaVoiceMicView = (GuildMediaVoiceMicView) ViewBindings.findChildViewById(view, R.id.vz5);
                    if (guildMediaVoiceMicView != null) {
                        i3 = R.id.vz6;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.vz6);
                        if (imageView != null) {
                            i3 = R.id.wh6;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wh6);
                            if (frameLayout != null) {
                                i3 = R.id.wpy;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.wpy);
                                if (imageView2 != null) {
                                    i3 = R.id.wpz;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wpz);
                                    if (frameLayout2 != null) {
                                        i3 = R.id.x4f;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.x4f);
                                        if (imageView3 != null) {
                                            i3 = R.id.xsn;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.xsn);
                                            if (findChildViewById2 != null) {
                                                i3 = R.id.xso;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xso);
                                                if (linearLayout != null) {
                                                    i3 = R.id.xv6;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.xv6);
                                                    if (imageView4 != null) {
                                                        i3 = R.id.xv7;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.xv7);
                                                        if (textView2 != null) {
                                                            i3 = R.id.xv8;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xv8);
                                                            if (linearLayout2 != null) {
                                                                i3 = R.id.xv_;
                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.xv_);
                                                                if (relativeLayout != null) {
                                                                    i3 = R.id.xva;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xva);
                                                                    if (linearLayout3 != null) {
                                                                        i3 = R.id.xvk;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xvk);
                                                                        if (linearLayout4 != null) {
                                                                            i3 = R.id.f165864xw0;
                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165864xw0);
                                                                            if (imageView5 != null) {
                                                                                i3 = R.id.f165865xw1;
                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165865xw1);
                                                                                if (linearLayout5 != null) {
                                                                                    i3 = R.id.f165866xw2;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f165866xw2);
                                                                                    if (textView3 != null) {
                                                                                        i3 = R.id.xwa;
                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xwa);
                                                                                        if (linearLayout6 != null) {
                                                                                            i3 = R.id.xwb;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.xwb);
                                                                                            if (textView4 != null) {
                                                                                                i3 = R.id.xxy;
                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.xxy);
                                                                                                if (imageView6 != null) {
                                                                                                    i3 = R.id.xxz;
                                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.xxz);
                                                                                                    if (imageView7 != null) {
                                                                                                        i3 = R.id.f165877xy0;
                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f165877xy0);
                                                                                                        if (textView5 != null) {
                                                                                                            i3 = R.id.f165878xy1;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165878xy1);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                i3 = R.id.zph;
                                                                                                                GuildMediaNetStatusView guildMediaNetStatusView = (GuildMediaNetStatusView) ViewBindings.findChildViewById(view, R.id.zph);
                                                                                                                if (guildMediaNetStatusView != null) {
                                                                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                                                                    i3 = R.id.f783046p;
                                                                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R.id.f783046p);
                                                                                                                    if (imageView8 != null) {
                                                                                                                        i3 = R.id.f783146q;
                                                                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, R.id.f783146q);
                                                                                                                        if (imageView9 != null) {
                                                                                                                            i3 = R.id.f115796x0;
                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f115796x0);
                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                return new ay(constraintLayout, findChildViewById, textView, guildWavAvatarImageView, guildMediaVoiceMicView, imageView, frameLayout, imageView2, frameLayout2, imageView3, findChildViewById2, linearLayout, imageView4, textView2, linearLayout2, relativeLayout, linearLayout3, linearLayout4, imageView5, linearLayout5, textView3, linearLayout6, textView4, imageView6, imageView7, textView5, linearLayout7, guildMediaNetStatusView, constraintLayout, imageView8, imageView9, linearLayout8);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ay g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static ay h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eso, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442334a;
    }
}
