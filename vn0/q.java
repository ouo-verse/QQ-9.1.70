package vn0;

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
import com.tencent.guild.aio.title.GuildImmersiveTitleBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class q implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f441999a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442000b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442001c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442002d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442003e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442004f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442005g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final GuildImmersiveTitleBar f442006h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f442007i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442008j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442009k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442010l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442011m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f442012n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442013o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f442014p;

    q(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull FrameLayout frameLayout2, @NonNull GuildImmersiveTitleBar guildImmersiveTitleBar, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout3, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull RelativeLayout relativeLayout4, @NonNull TextView textView5) {
        this.f441999a = relativeLayout;
        this.f442000b = textView;
        this.f442001c = imageView;
        this.f442002d = frameLayout;
        this.f442003e = imageView2;
        this.f442004f = relativeLayout2;
        this.f442005g = frameLayout2;
        this.f442006h = guildImmersiveTitleBar;
        this.f442007i = textView2;
        this.f442008j = relativeLayout3;
        this.f442009k = textView3;
        this.f442010l = linearLayout;
        this.f442011m = textView4;
        this.f442012n = guildUserAvatarView;
        this.f442013o = relativeLayout4;
        this.f442014p = textView5;
    }

    @NonNull
    public static q e(@NonNull View view) {
        int i3 = R.id.s98;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.s98);
        if (textView != null) {
            i3 = R.id.s99;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.s99);
            if (imageView != null) {
                i3 = R.id.f163922cf;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f163922cf);
                if (frameLayout != null) {
                    i3 = R.id.s9l;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.s9l);
                    if (imageView2 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        i3 = R.id.xhb;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.xhb);
                        if (frameLayout2 != null) {
                            i3 = R.id.xl7;
                            GuildImmersiveTitleBar guildImmersiveTitleBar = (GuildImmersiveTitleBar) ViewBindings.findChildViewById(view, R.id.xl7);
                            if (guildImmersiveTitleBar != null) {
                                i3 = R.id.ywg;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ywg);
                                if (textView2 != null) {
                                    i3 = R.id.zmg;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.zmg);
                                    if (relativeLayout2 != null) {
                                        i3 = R.id.zmh;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.zmh);
                                        if (textView3 != null) {
                                            i3 = R.id.f9c;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f9c);
                                            if (linearLayout != null) {
                                                i3 = R.id.g5c;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.g5c);
                                                if (textView4 != null) {
                                                    i3 = R.id.f115206ve;
                                                    GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.f115206ve);
                                                    if (guildUserAvatarView != null) {
                                                        i3 = R.id.klq;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.klq);
                                                        if (relativeLayout3 != null) {
                                                            i3 = R.id.f115646wl;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f115646wl);
                                                            if (textView5 != null) {
                                                                return new q(relativeLayout, textView, imageView, frameLayout, imageView2, relativeLayout, frameLayout2, guildImmersiveTitleBar, textView2, relativeLayout2, textView3, linearLayout, textView4, guildUserAvatarView, relativeLayout3, textView5);
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
    public static q g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168037eg4, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f441999a;
    }
}
