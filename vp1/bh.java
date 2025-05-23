package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.view.GuildChannelNameTextView;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.widget.GuildBannerTitleLayout;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tx.x2j.GuildHomeHeaderChannelTitleLayoutInStandaloneBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bh implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442454a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442455b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442456c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildBannerTitleLayout f442457d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f442458e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442459f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442460g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442461h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f442462i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442463j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f442464k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442465l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442466m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442467n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final ImageView f442468o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442469p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final GuildDragTextView f442470q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final ImageView f442471r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442472s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    public final ImageView f442473t;

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    public final ImageView f442474u;

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    public final GuildChannelNameTextView f442475v;

    /* renamed from: w, reason: collision with root package name */
    @NonNull
    public final TextView f442476w;

    /* renamed from: x, reason: collision with root package name */
    @NonNull
    public final ShadowFrameLayout f442477x;

    bh(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2, @NonNull GuildBannerTitleLayout guildBannerTitleLayout, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout3, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout3, @NonNull RoundImageView roundImageView, @NonNull LinearLayout linearLayout4, @NonNull ImageView imageView4, @NonNull FrameLayout frameLayout4, @NonNull GuildDragTextView guildDragTextView, @NonNull ImageView imageView5, @NonNull FrameLayout frameLayout5, @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull GuildChannelNameTextView guildChannelNameTextView, @NonNull TextView textView2, @NonNull ShadowFrameLayout shadowFrameLayout) {
        this.f442454a = frameLayout;
        this.f442455b = imageView;
        this.f442456c = frameLayout2;
        this.f442457d = guildBannerTitleLayout;
        this.f442458e = view;
        this.f442459f = linearLayout;
        this.f442460g = textView;
        this.f442461h = linearLayout2;
        this.f442462i = imageView2;
        this.f442463j = frameLayout3;
        this.f442464k = imageView3;
        this.f442465l = linearLayout3;
        this.f442466m = roundImageView;
        this.f442467n = linearLayout4;
        this.f442468o = imageView4;
        this.f442469p = frameLayout4;
        this.f442470q = guildDragTextView;
        this.f442471r = imageView5;
        this.f442472s = frameLayout5;
        this.f442473t = imageView6;
        this.f442474u = imageView7;
        this.f442475v = guildChannelNameTextView;
        this.f442476w = textView2;
        this.f442477x = shadowFrameLayout;
    }

    @NonNull
    public static bh e(@NonNull View view) {
        int i3 = R.id.f164897b91;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164897b91);
        if (imageView != null) {
            i3 = R.id.vzz;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.vzz);
            if (frameLayout != null) {
                i3 = R.id.w0k;
                GuildBannerTitleLayout guildBannerTitleLayout = (GuildBannerTitleLayout) ViewBindings.findChildViewById(view, R.id.w0k);
                if (guildBannerTitleLayout != null) {
                    i3 = R.id.wih;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.wih);
                    if (findChildViewById != null) {
                        i3 = R.id.wqt;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wqt);
                        if (linearLayout != null) {
                            i3 = R.id.wqv;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wqv);
                            if (textView != null) {
                                i3 = R.id.wrx;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wrx);
                                if (linearLayout2 != null) {
                                    i3 = R.id.i4v;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.i4v);
                                    if (imageView2 != null) {
                                        FrameLayout frameLayout2 = (FrameLayout) view;
                                        i3 = R.id.jo8;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.jo8);
                                        if (imageView3 != null) {
                                            i3 = R.id.title_container;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.title_container);
                                            if (linearLayout3 != null) {
                                                i3 = R.id.f98495n9;
                                                RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.f98495n9);
                                                if (roundImageView != null) {
                                                    i3 = R.id.jnz;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jnz);
                                                    if (linearLayout4 != null) {
                                                        i3 = R.id.f98725nv;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f98725nv);
                                                        if (imageView4 != null) {
                                                            i3 = R.id.f98095m6;
                                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f98095m6);
                                                            if (frameLayout3 != null) {
                                                                i3 = R.id.f98105m7;
                                                                GuildDragTextView guildDragTextView = (GuildDragTextView) ViewBindings.findChildViewById(view, R.id.f98105m7);
                                                                if (guildDragTextView != null) {
                                                                    i3 = R.id.jpu;
                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.jpu);
                                                                    if (imageView5 != null) {
                                                                        i3 = R.id.f98825o5;
                                                                        FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f98825o5);
                                                                        if (frameLayout4 != null) {
                                                                            i3 = R.id.f98835o6;
                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.f98835o6);
                                                                            if (imageView6 != null) {
                                                                                i3 = R.id.f98915od;
                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.f98915od);
                                                                                if (imageView7 != null) {
                                                                                    i3 = R.id.f98175md;
                                                                                    GuildChannelNameTextView guildChannelNameTextView = (GuildChannelNameTextView) ViewBindings.findChildViewById(view, R.id.f98175md);
                                                                                    if (guildChannelNameTextView != null) {
                                                                                        i3 = R.id.f1067269h;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f1067269h);
                                                                                        if (textView2 != null) {
                                                                                            i3 = R.id.f1067369i;
                                                                                            ShadowFrameLayout shadowFrameLayout = (ShadowFrameLayout) ViewBindings.findChildViewById(view, R.id.f1067369i);
                                                                                            if (shadowFrameLayout != null) {
                                                                                                return new bh(frameLayout2, imageView, frameLayout, guildBannerTitleLayout, findChildViewById, linearLayout, textView, linearLayout2, imageView2, frameLayout2, imageView3, linearLayout3, roundImageView, linearLayout4, imageView4, frameLayout3, guildDragTextView, imageView5, frameLayout4, imageView6, imageView7, guildChannelNameTextView, textView2, shadowFrameLayout);
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
    public static bh g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildHomeHeaderChannelTitleLayoutInStandaloneBinding guildHomeHeaderChannelTitleLayoutInStandaloneBinding = new GuildHomeHeaderChannelTitleLayoutInStandaloneBinding();
        guildHomeHeaderChannelTitleLayoutInStandaloneBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildHomeHeaderChannelTitleLayoutInStandaloneBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.etn, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442454a;
    }
}
