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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class be implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f442432a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442433b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f442434c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f442435d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442436e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442437f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442438g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442439h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442440i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f442441j;

    be(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.f442432a = radiusFrameLayout;
        this.f442433b = frameLayout;
        this.f442434c = view;
        this.f442435d = view2;
        this.f442436e = imageView;
        this.f442437f = linearLayout;
        this.f442438g = imageView2;
        this.f442439h = textView;
        this.f442440i = linearLayout2;
        this.f442441j = textView2;
    }

    @NonNull
    public static be e(@NonNull View view) {
        int i3 = R.id.sa7;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.sa7);
        if (frameLayout != null) {
            i3 = R.id.u_v;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.u_v);
            if (findChildViewById != null) {
                i3 = R.id.ua9;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.ua9);
                if (findChildViewById2 != null) {
                    i3 = R.id.xaf;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.xaf);
                    if (imageView != null) {
                        i3 = R.id.xag;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xag);
                        if (linearLayout != null) {
                            i3 = R.id.xah;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.xah);
                            if (imageView2 != null) {
                                i3 = R.id.xai;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.xai);
                                if (textView != null) {
                                    i3 = R.id.xaj;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xaj);
                                    if (linearLayout2 != null) {
                                        i3 = R.id.ykm;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ykm);
                                        if (textView2 != null) {
                                            return new be((RadiusFrameLayout) view, frameLayout, findChildViewById, findChildViewById2, imageView, linearLayout, imageView2, textView, linearLayout2, textView2);
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
    public static be g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eti, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f442432a;
    }
}
