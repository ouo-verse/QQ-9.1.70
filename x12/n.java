package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class n implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f446962a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f446963b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundImageView f446964c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundImageView f446965d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f446966e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f446967f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f446968g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f446969h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f446970i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f446971j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f446972k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f446973l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f446974m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f446975n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final QUIColorfulQRCodeView f446976o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f446977p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final ImageView f446978q;

    n(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull RoundImageView roundImageView, @NonNull RoundImageView roundImageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view, @NonNull View view2, @NonNull TextView textView4, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull QUIColorfulQRCodeView qUIColorfulQRCodeView, @NonNull TextView textView7, @NonNull ImageView imageView3) {
        this.f446962a = frameLayout;
        this.f446963b = frameLayout2;
        this.f446964c = roundImageView;
        this.f446965d = roundImageView2;
        this.f446966e = textView;
        this.f446967f = textView2;
        this.f446968g = textView3;
        this.f446969h = view;
        this.f446970i = view2;
        this.f446971j = textView4;
        this.f446972k = imageView;
        this.f446973l = imageView2;
        this.f446974m = textView5;
        this.f446975n = textView6;
        this.f446976o = qUIColorfulQRCodeView;
        this.f446977p = textView7;
        this.f446978q = imageView3;
    }

    @NonNull
    public static n e(@NonNull View view) {
        int i3 = R.id.b9t;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.b9t);
        if (frameLayout != null) {
            i3 = R.id.vzu;
            RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.vzu);
            if (roundImageView != null) {
                i3 = R.id.wcp;
                RoundImageView roundImageView2 = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wcp);
                if (roundImageView2 != null) {
                    i3 = R.id.wcq;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wcq);
                    if (textView != null) {
                        i3 = R.id.wcr;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.wcr);
                        if (textView2 != null) {
                            i3 = R.id.we9;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.we9);
                            if (textView3 != null) {
                                i3 = R.id.we_;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.we_);
                                if (findChildViewById != null) {
                                    i3 = R.id.wea;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.wea);
                                    if (findChildViewById2 != null) {
                                        i3 = R.id.wf6;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.wf6);
                                        if (textView4 != null) {
                                            i3 = R.id.wp5;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.wp5);
                                            if (imageView != null) {
                                                i3 = R.id.wp6;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.wp6);
                                                if (imageView2 != null) {
                                                    i3 = R.id.wqy;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.wqy);
                                                    if (textView5 != null) {
                                                        i3 = R.id.f165583ws3;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.f165583ws3);
                                                        if (textView6 != null) {
                                                            i3 = R.id.wuq;
                                                            QUIColorfulQRCodeView qUIColorfulQRCodeView = (QUIColorfulQRCodeView) ViewBindings.findChildViewById(view, R.id.wuq);
                                                            if (qUIColorfulQRCodeView != null) {
                                                                i3 = R.id.x2c;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.x2c);
                                                                if (textView7 != null) {
                                                                    i3 = R.id.x2m;
                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.x2m);
                                                                    if (imageView3 != null) {
                                                                        return new n((FrameLayout) view, frameLayout, roundImageView, roundImageView2, textView, textView2, textView3, findChildViewById, findChildViewById2, textView4, imageView, imageView2, textView5, textView6, qUIColorfulQRCodeView, textView7, imageView3);
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
    public static n g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static n h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.equ, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f446962a;
    }
}
