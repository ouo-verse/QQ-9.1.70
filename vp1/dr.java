package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dr implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442978a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442979b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f442980c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442981d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RFWRoundImageView f442982e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442983f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442984g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442985h;

    dr(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull TextView textView, @NonNull RFWRoundImageView rFWRoundImageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f442978a = frameLayout;
        this.f442979b = linearLayout;
        this.f442980c = view;
        this.f442981d = textView;
        this.f442982e = rFWRoundImageView;
        this.f442983f = textView2;
        this.f442984g = textView3;
        this.f442985h = textView4;
    }

    @NonNull
    public static dr e(@NonNull View view) {
        int i3 = R.id.u9t;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.u9t);
        if (linearLayout != null) {
            i3 = R.id.u_0;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.u_0);
            if (findChildViewById != null) {
                i3 = R.id.v1l;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.v1l);
                if (textView != null) {
                    i3 = R.id.vzu;
                    RFWRoundImageView rFWRoundImageView = (RFWRoundImageView) ViewBindings.findChildViewById(view, R.id.vzu);
                    if (rFWRoundImageView != null) {
                        i3 = R.id.wrw;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
                        if (textView2 != null) {
                            i3 = R.id.ya5;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.ya5);
                            if (textView3 != null) {
                                i3 = R.id.eom;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.eom);
                                if (textView4 != null) {
                                    return new dr((FrameLayout) view, linearLayout, findChildViewById, textView, rFWRoundImageView, textView2, textView3, textView4);
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
    public static dr g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static dr h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f8x, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442978a;
    }
}
