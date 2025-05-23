package pw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemRightLayout;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.qqnt.chats.view.widget.GuildSummaryLayout;
import com.tencent.qqnt.chats.view.widget.RecentAvatarViewWrapper;
import com.tencent.qqnt.chats.view.widget.RoundFrameLayout;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.widget.SwipeMenuLayout;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final SwipeMenuLayout f427809a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f427810b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecentAvatarViewWrapper f427811c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundFrameLayout f427812d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f427813e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f427814f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final SwipeMenuLayout f427815g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f427816h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RecentContactItemRightLayout f427817i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final GuildSummaryLayout f427818j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f427819k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final SingleLineTextView f427820l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayout f427821m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final ImageView f427822n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final RollingTextView f427823o;

    e(@NonNull SwipeMenuLayout swipeMenuLayout, @NonNull RelativeLayout relativeLayout, @NonNull RecentAvatarViewWrapper recentAvatarViewWrapper, @NonNull RoundFrameLayout roundFrameLayout, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull SwipeMenuLayout swipeMenuLayout2, @NonNull ImageView imageView, @NonNull RecentContactItemRightLayout recentContactItemRightLayout, @NonNull GuildSummaryLayout guildSummaryLayout, @NonNull ImageView imageView2, @NonNull SingleLineTextView singleLineTextView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView3, @NonNull RollingTextView rollingTextView) {
        this.f427809a = swipeMenuLayout;
        this.f427810b = relativeLayout;
        this.f427811c = recentAvatarViewWrapper;
        this.f427812d = roundFrameLayout;
        this.f427813e = relativeLayout2;
        this.f427814f = linearLayoutCompat;
        this.f427815g = swipeMenuLayout2;
        this.f427816h = imageView;
        this.f427817i = recentContactItemRightLayout;
        this.f427818j = guildSummaryLayout;
        this.f427819k = imageView2;
        this.f427820l = singleLineTextView;
        this.f427821m = linearLayout;
        this.f427822n = imageView3;
        this.f427823o = rollingTextView;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.f164548a32;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f164548a32);
        if (relativeLayout != null) {
            i3 = R.id.a39;
            RecentAvatarViewWrapper recentAvatarViewWrapper = (RecentAvatarViewWrapper) ViewBindings.findChildViewById(view, R.id.a39);
            if (recentAvatarViewWrapper != null) {
                i3 = R.id.t1t;
                RoundFrameLayout roundFrameLayout = (RoundFrameLayout) ViewBindings.findChildViewById(view, R.id.t1t);
                if (roundFrameLayout != null) {
                    i3 = R.id.aua;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.aua);
                    if (relativeLayout2 != null) {
                        i3 = R.id.ttm;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, R.id.ttm);
                        if (linearLayoutCompat != null) {
                            SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) view;
                            i3 = R.id.f165003uk2;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165003uk2);
                            if (imageView != null) {
                                i3 = R.id.iag;
                                RecentContactItemRightLayout recentContactItemRightLayout = (RecentContactItemRightLayout) ViewBindings.findChildViewById(view, R.id.iag);
                                if (recentContactItemRightLayout != null) {
                                    i3 = R.id.j8_;
                                    GuildSummaryLayout guildSummaryLayout = (GuildSummaryLayout) ViewBindings.findChildViewById(view, R.id.j8_);
                                    if (guildSummaryLayout != null) {
                                        i3 = R.id.f907853e;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f907853e);
                                        if (imageView2 != null) {
                                            i3 = R.id.title;
                                            SingleLineTextView singleLineTextView = (SingleLineTextView) ViewBindings.findChildViewById(view, R.id.title);
                                            if (singleLineTextView != null) {
                                                i3 = R.id.jp7;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jp7);
                                                if (linearLayout != null) {
                                                    i3 = R.id.f98685nr;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f98685nr);
                                                    if (imageView3 != null) {
                                                        i3 = R.id.f114236ss;
                                                        RollingTextView rollingTextView = (RollingTextView) ViewBindings.findChildViewById(view, R.id.f114236ss);
                                                        if (rollingTextView != null) {
                                                            return new e(swipeMenuLayout, relativeLayout, recentAvatarViewWrapper, roundFrameLayout, relativeLayout2, linearLayoutCompat, swipeMenuLayout, imageView, recentContactItemRightLayout, guildSummaryLayout, imageView2, singleLineTextView, linearLayout, imageView3, rollingTextView);
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
    public static e g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static e h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f3s, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public SwipeMenuLayout getRoot() {
        return this.f427809a;
    }
}
