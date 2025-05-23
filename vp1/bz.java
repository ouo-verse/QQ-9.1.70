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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.client.widget.GuildClientIdentityView;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bz implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442633a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442634b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442635c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f442636d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442637e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final GuildLevelRoleView f442638f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442639g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final GuildClientIdentityView f442640h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f442641i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f442642j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f442643k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f442644l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final ImageView f442645m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442646n;

    bz(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull TextView textView, @NonNull GuildLevelRoleView guildLevelRoleView, @NonNull ConstraintLayout constraintLayout2, @NonNull GuildClientIdentityView guildClientIdentityView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull LinearLayout linearLayout) {
        this.f442633a = constraintLayout;
        this.f442634b = frameLayout;
        this.f442635c = imageView;
        this.f442636d = guildUserAvatarView;
        this.f442637e = textView;
        this.f442638f = guildLevelRoleView;
        this.f442639g = constraintLayout2;
        this.f442640h = guildClientIdentityView;
        this.f442641i = textView2;
        this.f442642j = imageView2;
        this.f442643k = imageView3;
        this.f442644l = imageView4;
        this.f442645m = imageView5;
        this.f442646n = linearLayout;
    }

    @NonNull
    public static bz e(@NonNull View view) {
        int i3 = R.id.f164548a32;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f164548a32);
        if (frameLayout != null) {
            i3 = R.id.t1e;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.t1e);
            if (imageView != null) {
                i3 = R.id.xsl;
                GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.xsl);
                if (guildUserAvatarView != null) {
                    i3 = R.id.xvf;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.xvf);
                    if (textView != null) {
                        i3 = R.id.xvh;
                        GuildLevelRoleView guildLevelRoleView = (GuildLevelRoleView) ViewBindings.findChildViewById(view, R.id.xvh);
                        if (guildLevelRoleView != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i3 = R.id.xw5;
                            GuildClientIdentityView guildClientIdentityView = (GuildClientIdentityView) ViewBindings.findChildViewById(view, R.id.xw5);
                            if (guildClientIdentityView != null) {
                                i3 = R.id.xw7;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.xw7);
                                if (textView2 != null) {
                                    i3 = R.id.xw8;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.xw8);
                                    if (imageView2 != null) {
                                        i3 = R.id.xw9;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.xw9);
                                        if (imageView3 != null) {
                                            i3 = R.id.xwf;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.xwf);
                                            if (imageView4 != null) {
                                                i3 = R.id.f767642j;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f767642j);
                                                if (imageView5 != null) {
                                                    i3 = R.id.jbb;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jbb);
                                                    if (linearLayout != null) {
                                                        return new bz(constraintLayout, frameLayout, imageView, guildUserAvatarView, textView, guildLevelRoleView, constraintLayout, guildClientIdentityView, textView2, imageView2, imageView3, imageView4, imageView5, linearLayout);
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
    public static bz g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ezr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442633a;
    }
}
