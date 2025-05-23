package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discover.widget.GuildRoundBoardImageView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.widget.CommentEllipsizeLayout;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f446898a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f446899b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f446900c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f446901d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f446902e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final GuildRoundBoardImageView f446903f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final QUIButton f446904g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final QUIButton f446905h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f446906i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final CommentEllipsizeLayout f446907j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f446908k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f446909l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayout f446910m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f446911n;

    d(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull GuildRoundBoardImageView guildRoundBoardImageView, @NonNull QUIButton qUIButton, @NonNull QUIButton qUIButton2, @NonNull TextView textView2, @NonNull CommentEllipsizeLayout commentEllipsizeLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull View view) {
        this.f446898a = relativeLayout;
        this.f446899b = linearLayout;
        this.f446900c = textView;
        this.f446901d = relativeLayout2;
        this.f446902e = relativeLayout3;
        this.f446903f = guildRoundBoardImageView;
        this.f446904g = qUIButton;
        this.f446905h = qUIButton2;
        this.f446906i = textView2;
        this.f446907j = commentEllipsizeLayout;
        this.f446908k = linearLayout2;
        this.f446909l = linearLayout3;
        this.f446910m = linearLayout4;
        this.f446911n = view;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.t_g;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.t_g);
        if (linearLayout != null) {
            i3 = R.id.t_h;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.t_h);
            if (textView != null) {
                i3 = R.id.tq_;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.tq_);
                if (relativeLayout != null) {
                    RelativeLayout relativeLayout2 = (RelativeLayout) view;
                    i3 = R.id.vzu;
                    GuildRoundBoardImageView guildRoundBoardImageView = (GuildRoundBoardImageView) ViewBindings.findChildViewById(view, R.id.vzu);
                    if (guildRoundBoardImageView != null) {
                        i3 = R.id.wkv;
                        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.wkv);
                        if (qUIButton != null) {
                            i3 = R.id.f165548wl3;
                            QUIButton qUIButton2 = (QUIButton) ViewBindings.findChildViewById(view, R.id.f165548wl3);
                            if (qUIButton2 != null) {
                                i3 = R.id.wrw;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
                                if (textView2 != null) {
                                    i3 = R.id.e1p;
                                    CommentEllipsizeLayout commentEllipsizeLayout = (CommentEllipsizeLayout) ViewBindings.findChildViewById(view, R.id.e1p);
                                    if (commentEllipsizeLayout != null) {
                                        i3 = R.id.ygy;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ygy);
                                        if (linearLayout2 != null) {
                                            i3 = R.id.f71233nl;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f71233nl);
                                            if (linearLayout3 != null) {
                                                i3 = R.id.f74713x0;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f74713x0);
                                                if (linearLayout4 != null) {
                                                    i3 = R.id.f11877752;
                                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.f11877752);
                                                    if (findChildViewById != null) {
                                                        return new d(relativeLayout2, linearLayout, textView, relativeLayout, relativeLayout2, guildRoundBoardImageView, qUIButton, qUIButton2, textView2, commentEllipsizeLayout, linearLayout2, linearLayout3, linearLayout4, findChildViewById);
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
    public static d g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.epp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f446898a;
    }
}
