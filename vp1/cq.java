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
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tx.x2j.GuildPersonalProfileGameContainerBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cq implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442758a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442759b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442760c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RadiusFrameLayout f442761d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RadiusFrameLayout f442762e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442763f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442764g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442765h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442766i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f442767j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442768k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f442769l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442770m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f442771n;

    cq(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RadiusFrameLayout radiusFrameLayout, @NonNull RadiusFrameLayout radiusFrameLayout2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f442758a = linearLayout;
        this.f442759b = imageView;
        this.f442760c = imageView2;
        this.f442761d = radiusFrameLayout;
        this.f442762e = radiusFrameLayout2;
        this.f442763f = imageView3;
        this.f442764g = linearLayout2;
        this.f442765h = linearLayout3;
        this.f442766i = relativeLayout;
        this.f442767j = textView;
        this.f442768k = textView2;
        this.f442769l = textView3;
        this.f442770m = textView4;
        this.f442771n = textView5;
    }

    @NonNull
    public static cq e(@NonNull View view) {
        int i3 = R.id.f165000bn4;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165000bn4);
        if (imageView != null) {
            i3 = R.id.bn5;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.bn5);
            if (imageView2 != null) {
                i3 = R.id.wfv;
                RadiusFrameLayout radiusFrameLayout = (RadiusFrameLayout) ViewBindings.findChildViewById(view, R.id.wfv);
                if (radiusFrameLayout != null) {
                    i3 = R.id.wfy;
                    RadiusFrameLayout radiusFrameLayout2 = (RadiusFrameLayout) ViewBindings.findChildViewById(view, R.id.wfy);
                    if (radiusFrameLayout2 != null) {
                        i3 = R.id.wkc;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.wkc);
                        if (imageView3 != null) {
                            i3 = R.id.wom;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wom);
                            if (linearLayout != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view;
                                i3 = R.id.f165602ww2;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f165602ww2);
                                if (relativeLayout != null) {
                                    i3 = R.id.f165643x35;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165643x35);
                                    if (textView != null) {
                                        i3 = R.id.x36;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.x36);
                                        if (textView2 != null) {
                                            i3 = R.id.x38;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.x38);
                                            if (textView3 != null) {
                                                i3 = R.id.x39;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.x39);
                                                if (textView4 != null) {
                                                    i3 = R.id.x3_;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.x3_);
                                                    if (textView5 != null) {
                                                        return new cq(linearLayout2, imageView, imageView2, radiusFrameLayout, radiusFrameLayout2, imageView3, linearLayout, linearLayout2, relativeLayout, textView, textView2, textView3, textView4, textView5);
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
    public static cq g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static cq h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildPersonalProfileGameContainerBinding guildPersonalProfileGameContainerBinding = new GuildPersonalProfileGameContainerBinding();
        guildPersonalProfileGameContainerBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildPersonalProfileGameContainerBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f168144f20, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442758a;
    }
}
