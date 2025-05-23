package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import com.tx.x2j.GuildMyGuildListItemBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cb implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final SwipeMenuLayout f442668a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442669b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442670c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442671d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442672e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442673f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442674g;

    cb(@NonNull SwipeMenuLayout swipeMenuLayout, @NonNull RoundImageView roundImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f442668a = swipeMenuLayout;
        this.f442669b = roundImageView;
        this.f442670c = textView;
        this.f442671d = textView2;
        this.f442672e = linearLayout;
        this.f442673f = textView3;
        this.f442674g = textView4;
    }

    @NonNull
    public static cb e(@NonNull View view) {
        int i3 = R.id.vzu;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.vzu);
        if (roundImageView != null) {
            i3 = R.id.w3j;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.w3j);
            if (textView != null) {
                i3 = R.id.x2e;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.x2e);
                if (textView2 != null) {
                    i3 = R.id.yji;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.yji);
                    if (linearLayout != null) {
                        i3 = R.id.f74743x3;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f74743x3);
                        if (textView3 != null) {
                            i3 = R.id.f74753x4;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f74753x4);
                            if (textView4 != null) {
                                return new cb((SwipeMenuLayout) view, roundImageView, textView, textView2, linearLayout, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static cb g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildMyGuildListItemBinding guildMyGuildListItemBinding = new GuildMyGuildListItemBinding();
        guildMyGuildListItemBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildMyGuildListItemBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f0p, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public SwipeMenuLayout getRoot() {
        return this.f442668a;
    }
}
