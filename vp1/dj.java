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
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442913a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442914b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUIColorfulQRCodeView f442915c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442916d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442917e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442918f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f442919g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442920h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442921i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f442922j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442923k;

    dj(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull QUIColorfulQRCodeView qUIColorfulQRCodeView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f442913a = frameLayout;
        this.f442914b = imageView;
        this.f442915c = qUIColorfulQRCodeView;
        this.f442916d = imageView2;
        this.f442917e = textView;
        this.f442918f = textView2;
        this.f442919g = view;
        this.f442920h = linearLayout;
        this.f442921i = frameLayout2;
        this.f442922j = textView3;
        this.f442923k = textView4;
    }

    @NonNull
    public static dj e(@NonNull View view) {
        int i3 = R.id.wp5;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.wp5);
        if (imageView != null) {
            i3 = R.id.wuq;
            QUIColorfulQRCodeView qUIColorfulQRCodeView = (QUIColorfulQRCodeView) ViewBindings.findChildViewById(view, R.id.wuq);
            if (qUIColorfulQRCodeView != null) {
                i3 = R.id.f165621x01;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165621x01);
                if (imageView2 != null) {
                    i3 = R.id.f165622x02;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165622x02);
                    if (textView != null) {
                        i3 = R.id.x0_;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.x0_);
                        if (textView2 != null) {
                            i3 = R.id.x0c;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.x0c);
                            if (findChildViewById != null) {
                                i3 = R.id.x0d;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.x0d);
                                if (linearLayout != null) {
                                    i3 = R.id.x0e;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.x0e);
                                    if (frameLayout != null) {
                                        i3 = R.id.x0f;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.x0f);
                                        if (textView3 != null) {
                                            i3 = R.id.x2c;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.x2c);
                                            if (textView4 != null) {
                                                return new dj((FrameLayout) view, imageView, qUIColorfulQRCodeView, imageView2, textView, textView2, findChildViewById, linearLayout, frameLayout, textView3, textView4);
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
    public static dj g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static dj h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f7x, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442913a;
    }
}
