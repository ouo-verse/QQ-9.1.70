package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class da implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FlexboxLayout f442855a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f442856b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f442857c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f442858d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f442859e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f442860f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f442861g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442862h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f442863i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f442864j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442865k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f442866l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f442867m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f442868n;

    da(@NonNull FlexboxLayout flexboxLayout, @NonNull QUICheckBox qUICheckBox, @NonNull QUICheckBox qUICheckBox2, @NonNull QUICheckBox qUICheckBox3, @NonNull QUICheckBox qUICheckBox4, @NonNull FlexboxLayout flexboxLayout2, @NonNull FlexboxLayout flexboxLayout3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull FlexboxLayout flexboxLayout4, @NonNull FlexboxLayout flexboxLayout5) {
        this.f442855a = flexboxLayout;
        this.f442856b = qUICheckBox;
        this.f442857c = qUICheckBox2;
        this.f442858d = qUICheckBox3;
        this.f442859e = qUICheckBox4;
        this.f442860f = flexboxLayout2;
        this.f442861g = flexboxLayout3;
        this.f442862h = textView;
        this.f442863i = textView2;
        this.f442864j = textView3;
        this.f442865k = textView4;
        this.f442866l = textView5;
        this.f442867m = flexboxLayout4;
        this.f442868n = flexboxLayout5;
    }

    @NonNull
    public static da e(@NonNull View view) {
        int i3 = R.id.tvm;
        QUICheckBox qUICheckBox = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.tvm);
        if (qUICheckBox != null) {
            i3 = R.id.tvn;
            QUICheckBox qUICheckBox2 = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.tvn);
            if (qUICheckBox2 != null) {
                i3 = R.id.tvt;
                QUICheckBox qUICheckBox3 = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.tvt);
                if (qUICheckBox3 != null) {
                    i3 = R.id.tvu;
                    QUICheckBox qUICheckBox4 = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.tvu);
                    if (qUICheckBox4 != null) {
                        i3 = R.id.f165211cb4;
                        FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, R.id.f165211cb4);
                        if (flexboxLayout != null) {
                            i3 = R.id.vdx;
                            FlexboxLayout flexboxLayout2 = (FlexboxLayout) ViewBindings.findChildViewById(view, R.id.vdx);
                            if (flexboxLayout2 != null) {
                                i3 = R.id.yjs;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.yjs);
                                if (textView != null) {
                                    i3 = R.id.yjt;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.yjt);
                                    if (textView2 != null) {
                                        i3 = R.id.yju;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.yju);
                                        if (textView3 != null) {
                                            i3 = R.id.yjv;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.yjv);
                                            if (textView4 != null) {
                                                i3 = R.id.f657439r;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f657439r);
                                                if (textView5 != null) {
                                                    i3 = R.id.iky;
                                                    FlexboxLayout flexboxLayout3 = (FlexboxLayout) ViewBindings.findChildViewById(view, R.id.iky);
                                                    if (flexboxLayout3 != null) {
                                                        i3 = R.id.jkh;
                                                        FlexboxLayout flexboxLayout4 = (FlexboxLayout) ViewBindings.findChildViewById(view, R.id.jkh);
                                                        if (flexboxLayout4 != null) {
                                                            return new da((FlexboxLayout) view, qUICheckBox, qUICheckBox2, qUICheckBox3, qUICheckBox4, flexboxLayout, flexboxLayout2, textView, textView2, textView3, textView4, textView5, flexboxLayout3, flexboxLayout4);
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
    public static da g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f4f, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout getRoot() {
        return this.f442855a;
    }
}
