package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dh implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442896a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442897b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442898c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442899d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442900e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442901f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442902g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f442903h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final GuildSwitchButton f442904i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f442905j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442906k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f442907l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442908m;

    dh(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView2, @NonNull GuildSwitchButton guildSwitchButton, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull RelativeLayout relativeLayout3) {
        this.f442896a = linearLayout;
        this.f442897b = linearLayout2;
        this.f442898c = textView;
        this.f442899d = relativeLayout;
        this.f442900e = imageView;
        this.f442901f = textView2;
        this.f442902g = relativeLayout2;
        this.f442903h = imageView2;
        this.f442904i = guildSwitchButton;
        this.f442905j = textView3;
        this.f442906k = textView4;
        this.f442907l = textView5;
        this.f442908m = relativeLayout3;
    }

    @NonNull
    public static dh e(@NonNull View view) {
        int i3 = R.id.to6;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.to6);
        if (linearLayout != null) {
            i3 = R.id.v0m;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.v0m);
            if (textView != null) {
                i3 = R.id.v0n;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.v0n);
                if (relativeLayout != null) {
                    i3 = R.id.v0o;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.v0o);
                    if (imageView != null) {
                        i3 = R.id.v0p;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.v0p);
                        if (textView2 != null) {
                            i3 = R.id.v4_;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.v4_);
                            if (relativeLayout2 != null) {
                                i3 = R.id.v4c;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.v4c);
                                if (imageView2 != null) {
                                    i3 = R.id.vqj;
                                    GuildSwitchButton guildSwitchButton = (GuildSwitchButton) ViewBindings.findChildViewById(view, R.id.vqj);
                                    if (guildSwitchButton != null) {
                                        i3 = R.id.wqg;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.wqg);
                                        if (textView3 != null) {
                                            i3 = R.id.x2v;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.x2v);
                                            if (textView4 != null) {
                                                i3 = R.id.f73623u2;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f73623u2);
                                                if (textView5 != null) {
                                                    i3 = R.id.f760140i;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f760140i);
                                                    if (relativeLayout3 != null) {
                                                        return new dh((LinearLayout) view, linearLayout, textView, relativeLayout, imageView, textView2, relativeLayout2, imageView2, guildSwitchButton, textView3, textView4, textView5, relativeLayout3);
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
    public static dh g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f5a, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442896a;
    }
}
