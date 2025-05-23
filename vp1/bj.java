package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.view.GuildChannelNameTextView;
import com.tencent.mobileqq.guild.widget.GuildBannerTitleLayout;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tx.x2j.GuildHomeHeaderTitleBarBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442493a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildBannerTitleLayout f442494b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442495c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442496d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f442497e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442498f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final GuildChannelNameTextView f442499g;

    bj(@NonNull FrameLayout frameLayout, @NonNull GuildBannerTitleLayout guildBannerTitleLayout, @NonNull ConstraintLayout constraintLayout, @NonNull RoundImageView roundImageView, @NonNull View view, @NonNull TextView textView, @NonNull GuildChannelNameTextView guildChannelNameTextView) {
        this.f442493a = frameLayout;
        this.f442494b = guildBannerTitleLayout;
        this.f442495c = constraintLayout;
        this.f442496d = roundImageView;
        this.f442497e = view;
        this.f442498f = textView;
        this.f442499g = guildChannelNameTextView;
    }

    @NonNull
    public static bj e(@NonNull View view) {
        int i3 = R.id.t4b;
        GuildBannerTitleLayout guildBannerTitleLayout = (GuildBannerTitleLayout) ViewBindings.findChildViewById(view, R.id.t4b);
        if (guildBannerTitleLayout != null) {
            i3 = R.id.b8q;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.b8q);
            if (constraintLayout != null) {
                i3 = R.id.f165417vw2;
                RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.f165417vw2);
                if (roundImageView != null) {
                    i3 = R.id.f165418vw3;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.f165418vw3);
                    if (findChildViewById != null) {
                        i3 = R.id.f166221z24;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f166221z24);
                        if (textView != null) {
                            i3 = R.id.f166992jq2;
                            GuildChannelNameTextView guildChannelNameTextView = (GuildChannelNameTextView) ViewBindings.findChildViewById(view, R.id.f166992jq2);
                            if (guildChannelNameTextView != null) {
                                return new bj((FrameLayout) view, guildBannerTitleLayout, constraintLayout, roundImageView, findChildViewById, textView, guildChannelNameTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bj g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildHomeHeaderTitleBarBinding guildHomeHeaderTitleBarBinding = new GuildHomeHeaderTitleBarBinding();
        guildHomeHeaderTitleBarBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildHomeHeaderTitleBarBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.etr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442493a;
    }
}
