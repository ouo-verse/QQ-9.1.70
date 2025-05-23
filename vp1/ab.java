package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discovery.widget.RoundImageView;
import com.tencent.mobileqq.guild.mainframe.view.GuildChannelNameTextView;
import com.tencent.mobileqq.guild.widget.GuildBannerTitleLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ab implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442140a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildBannerTitleLayout f442141b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442142c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442143d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ViewStub f442144e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442145f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442146g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ViewStub f442147h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442148i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442149j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442150k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442151l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final GuildChannelNameTextView f442152m;

    ab(@NonNull LinearLayout linearLayout, @NonNull GuildBannerTitleLayout guildBannerTitleLayout, @NonNull FrameLayout frameLayout, @NonNull RoundImageView roundImageView, @NonNull ViewStub viewStub, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2, @NonNull ViewStub viewStub2, @NonNull LinearLayout linearLayout2, @NonNull RoundImageView roundImageView2, @NonNull FrameLayout frameLayout3, @NonNull LinearLayout linearLayout3, @NonNull GuildChannelNameTextView guildChannelNameTextView) {
        this.f442140a = linearLayout;
        this.f442141b = guildBannerTitleLayout;
        this.f442142c = frameLayout;
        this.f442143d = roundImageView;
        this.f442144e = viewStub;
        this.f442145f = imageView;
        this.f442146g = frameLayout2;
        this.f442147h = viewStub2;
        this.f442148i = linearLayout2;
        this.f442149j = roundImageView2;
        this.f442150k = frameLayout3;
        this.f442151l = linearLayout3;
        this.f442152m = guildChannelNameTextView;
    }

    @NonNull
    public static ab e(@NonNull View view) {
        int i3 = R.id.w0k;
        GuildBannerTitleLayout guildBannerTitleLayout = (GuildBannerTitleLayout) ViewBindings.findChildViewById(view, R.id.w0k);
        if (guildBannerTitleLayout != null) {
            i3 = R.id.djy;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.djy);
            if (frameLayout != null) {
                i3 = R.id.xmf;
                RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.xmf);
                if (roundImageView != null) {
                    i3 = R.id.xmg;
                    ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.xmg);
                    if (viewStub != null) {
                        i3 = R.id.yww;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.yww);
                        if (imageView != null) {
                            i3 = R.id.zwv;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.zwv);
                            if (frameLayout2 != null) {
                                i3 = R.id.zww;
                                ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.zww);
                                if (viewStub2 != null) {
                                    LinearLayout linearLayout = (LinearLayout) view;
                                    i3 = R.id.f84144lg;
                                    RoundImageView roundImageView2 = (RoundImageView) ViewBindings.findChildViewById(view, R.id.f84144lg);
                                    if (roundImageView2 != null) {
                                        i3 = R.id.f84164li;
                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f84164li);
                                        if (frameLayout3 != null) {
                                            i3 = R.id.jnz;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jnz);
                                            if (linearLayout2 != null) {
                                                i3 = R.id.f98175md;
                                                GuildChannelNameTextView guildChannelNameTextView = (GuildChannelNameTextView) ViewBindings.findChildViewById(view, R.id.f98175md);
                                                if (guildChannelNameTextView != null) {
                                                    return new ab(linearLayout, guildBannerTitleLayout, frameLayout, roundImageView, viewStub, imageView, frameLayout2, viewStub2, linearLayout, roundImageView2, frameLayout3, linearLayout2, guildChannelNameTextView);
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
    public static ab g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eit, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442140a;
    }
}
