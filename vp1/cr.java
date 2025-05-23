package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.FlowLayout;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cr implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442772a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442773b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442774c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442775d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ViewStub f442776e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FlowLayout f442777f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442778g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442779h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f442780i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f442781j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarViewWithPendant f442782k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442783l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final ImageView f442784m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final ImageView f442785n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442786o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final FlowLayout f442787p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final ImageView f442788q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442789r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442790s;

    cr(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull ViewStub viewStub, @NonNull FlowLayout flowLayout, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout, @NonNull FlexboxLayout flexboxLayout, @NonNull TextView textView2, @NonNull GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull FrameLayout frameLayout2, @NonNull FlowLayout flowLayout2, @NonNull ImageView imageView5, @NonNull RoundImageView roundImageView, @NonNull FrameLayout frameLayout3) {
        this.f442772a = linearLayout;
        this.f442773b = imageView;
        this.f442774c = linearLayout2;
        this.f442775d = textView;
        this.f442776e = viewStub;
        this.f442777f = flowLayout;
        this.f442778g = imageView2;
        this.f442779h = frameLayout;
        this.f442780i = flexboxLayout;
        this.f442781j = textView2;
        this.f442782k = guildUserAvatarViewWithPendant;
        this.f442783l = linearLayout3;
        this.f442784m = imageView3;
        this.f442785n = imageView4;
        this.f442786o = frameLayout2;
        this.f442787p = flowLayout2;
        this.f442788q = imageView5;
        this.f442789r = roundImageView;
        this.f442790s = frameLayout3;
    }

    @NonNull
    public static cr e(@NonNull View view) {
        int i3 = R.id.f164999bn3;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164999bn3);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i3 = R.id.f165593wu3;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165593wu3);
            if (textView != null) {
                i3 = R.id.wu8;
                ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.wu8);
                if (viewStub != null) {
                    i3 = R.id.wub;
                    FlowLayout flowLayout = (FlowLayout) ViewBindings.findChildViewById(view, R.id.wub);
                    if (flowLayout != null) {
                        i3 = R.id.wue;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.wue);
                        if (imageView2 != null) {
                            i3 = R.id.wuf;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wuf);
                            if (frameLayout != null) {
                                i3 = R.id.z1z;
                                FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, R.id.z1z);
                                if (flexboxLayout != null) {
                                    i3 = R.id.eos;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.eos);
                                    if (textView2 != null) {
                                        i3 = R.id.f166222z25;
                                        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = (GuildUserAvatarViewWithPendant) ViewBindings.findChildViewById(view, R.id.f166222z25);
                                        if (guildUserAvatarViewWithPendant != null) {
                                            i3 = R.id.f28120i3;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f28120i3);
                                            if (linearLayout2 != null) {
                                                i3 = R.id.f28190i_;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f28190i_);
                                                if (imageView3 != null) {
                                                    i3 = R.id.f28380is;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f28380is);
                                                    if (imageView4 != null) {
                                                        i3 = R.id.f61862z_;
                                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f61862z_);
                                                        if (frameLayout2 != null) {
                                                            i3 = R.id.f778145d;
                                                            FlowLayout flowLayout2 = (FlowLayout) ViewBindings.findChildViewById(view, R.id.f778145d);
                                                            if (flowLayout2 != null) {
                                                                i3 = R.id.f85484p3;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f85484p3);
                                                                if (imageView5 != null) {
                                                                    i3 = R.id.f99735ql;
                                                                    RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.f99735ql);
                                                                    if (roundImageView != null) {
                                                                        i3 = R.id.f99745qm;
                                                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f99745qm);
                                                                        if (frameLayout3 != null) {
                                                                            return new cr(linearLayout, imageView, linearLayout, textView, viewStub, flowLayout, imageView2, frameLayout, flexboxLayout, textView2, guildUserAvatarViewWithPendant, linearLayout2, imageView3, imageView4, frameLayout2, flowLayout2, imageView5, roundImageView, frameLayout3);
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
    public static cr g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static cr h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168146f22, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442772a;
    }
}
