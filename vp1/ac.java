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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.client.widget.GuildClientIdentityView;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tx.x2j.GuildColorMemberItemLayoutBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ac implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442153a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442154b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442155c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f442156d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442157e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442158f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442159g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442160h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final GuildLevelRoleView f442161i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442162j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final GuildClientIdentityView f442163k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f442164l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442165m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final ImageView f442166n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final ImageView f442167o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f442168p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final ImageView f442169q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final ImageView f442170r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f442171s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442172t;

    ac(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull GuildLevelRoleView guildLevelRoleView, @NonNull ConstraintLayout constraintLayout2, @NonNull GuildClientIdentityView guildClientIdentityView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull TextView textView5, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull QUICheckBox qUICheckBox, @NonNull LinearLayout linearLayout2) {
        this.f442153a = constraintLayout;
        this.f442154b = frameLayout;
        this.f442155c = imageView;
        this.f442156d = guildUserAvatarView;
        this.f442157e = imageView2;
        this.f442158f = textView;
        this.f442159g = linearLayout;
        this.f442160h = textView2;
        this.f442161i = guildLevelRoleView;
        this.f442162j = constraintLayout2;
        this.f442163k = guildClientIdentityView;
        this.f442164l = textView3;
        this.f442165m = textView4;
        this.f442166n = imageView3;
        this.f442167o = imageView4;
        this.f442168p = textView5;
        this.f442169q = imageView5;
        this.f442170r = imageView6;
        this.f442171s = qUICheckBox;
        this.f442172t = linearLayout2;
    }

    @NonNull
    public static ac e(@NonNull View view) {
        int i3 = R.id.f164548a32;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f164548a32);
        if (frameLayout != null) {
            i3 = R.id.t1e;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.t1e);
            if (imageView != null) {
                i3 = R.id.xsl;
                GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.xsl);
                if (guildUserAvatarView != null) {
                    i3 = R.id.xsx;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.xsx);
                    if (imageView2 != null) {
                        i3 = R.id.xsy;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.xsy);
                        if (textView != null) {
                            i3 = R.id.xsz;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xsz);
                            if (linearLayout != null) {
                                i3 = R.id.xvf;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.xvf);
                                if (textView2 != null) {
                                    i3 = R.id.xvh;
                                    GuildLevelRoleView guildLevelRoleView = (GuildLevelRoleView) ViewBindings.findChildViewById(view, R.id.xvh);
                                    if (guildLevelRoleView != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        i3 = R.id.xw5;
                                        GuildClientIdentityView guildClientIdentityView = (GuildClientIdentityView) ViewBindings.findChildViewById(view, R.id.xw5);
                                        if (guildClientIdentityView != null) {
                                            i3 = R.id.xw6;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.xw6);
                                            if (textView3 != null) {
                                                i3 = R.id.xw7;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.xw7);
                                                if (textView4 != null) {
                                                    i3 = R.id.xw8;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.xw8);
                                                    if (imageView3 != null) {
                                                        i3 = R.id.xw9;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.xw9);
                                                        if (imageView4 != null) {
                                                            i3 = R.id.xw_;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.xw_);
                                                            if (textView5 != null) {
                                                                i3 = R.id.xwf;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.xwf);
                                                                if (imageView5 != null) {
                                                                    i3 = R.id.f767642j;
                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.f767642j);
                                                                    if (imageView6 != null) {
                                                                        i3 = R.id.f82074fw;
                                                                        QUICheckBox qUICheckBox = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.f82074fw);
                                                                        if (qUICheckBox != null) {
                                                                            i3 = R.id.jbb;
                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jbb);
                                                                            if (linearLayout2 != null) {
                                                                                return new ac(constraintLayout, frameLayout, imageView, guildUserAvatarView, imageView2, textView, linearLayout, textView2, guildLevelRoleView, constraintLayout, guildClientIdentityView, textView3, textView4, imageView3, imageView4, textView5, imageView5, imageView6, qUICheckBox, linearLayout2);
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
    public static ac g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildColorMemberItemLayoutBinding guildColorMemberItemLayoutBinding = new GuildColorMemberItemLayoutBinding();
        guildColorMemberItemLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildColorMemberItemLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.ejp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMRv() {
        return this.f442153a;
    }
}
