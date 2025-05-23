package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cg implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442691a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Barrier f442692b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f442693c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final Flow f442694d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442695e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442696f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442697g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f442698h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f442699i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final Layer f442700j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442701k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f442702l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442703m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f442704n;

    cg(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull View view, @NonNull Flow flow, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull Layer layer, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f442691a = constraintLayout;
        this.f442692b = barrier;
        this.f442693c = view;
        this.f442694d = flow;
        this.f442695e = imageView;
        this.f442696f = imageView2;
        this.f442697g = imageView3;
        this.f442698h = imageView4;
        this.f442699i = imageView5;
        this.f442700j = layer;
        this.f442701k = constraintLayout2;
        this.f442702l = textView;
        this.f442703m = textView2;
        this.f442704n = textView3;
    }

    @NonNull
    public static cg e(@NonNull View view) {
        int i3 = R.id.t4t;
        Barrier barrier = (Barrier) ViewBindings.findChildViewById(view, R.id.t4t);
        if (barrier != null) {
            i3 = R.id.ugx;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.ugx);
            if (findChildViewById != null) {
                i3 = R.id.f165252vc4;
                Flow flow = (Flow) ViewBindings.findChildViewById(view, R.id.f165252vc4);
                if (flow != null) {
                    i3 = R.id.f165909du3;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165909du3);
                    if (imageView != null) {
                        i3 = R.id.y0k;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.y0k);
                        if (imageView2 != null) {
                            i3 = R.id.y4x;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.y4x);
                            if (imageView3 != null) {
                                i3 = R.id.dwf;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.dwf);
                                if (imageView4 != null) {
                                    i3 = R.id.y99;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.y99);
                                    if (imageView5 != null) {
                                        i3 = R.id.yd7;
                                        Layer layer = (Layer) ViewBindings.findChildViewById(view, R.id.yd7);
                                        if (layer != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i3 = R.id.f107006_9;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f107006_9);
                                            if (textView != null) {
                                                i3 = R.id.f167042k73;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f167042k73);
                                                if (textView2 != null) {
                                                    i3 = R.id.f107786bc;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f107786bc);
                                                    if (textView3 != null) {
                                                        return new cg(constraintLayout, barrier, findChildViewById, flow, imageView, imageView2, imageView3, imageView4, imageView5, layer, constraintLayout, textView, textView2, textView3);
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
    public static cg g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f16, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442691a;
    }
}
