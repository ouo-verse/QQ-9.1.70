package vp1;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bv implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f442598a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442599b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUIButton f442600c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUIButton f442601d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442602e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442603f;

    bv(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull QUIButton qUIButton, @NonNull QUIButton qUIButton2, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f442598a = relativeLayout;
        this.f442599b = textView;
        this.f442600c = qUIButton;
        this.f442601d = qUIButton2;
        this.f442602e = textView2;
        this.f442603f = imageView;
    }

    @NonNull
    public static bv e(@NonNull View view) {
        int i3 = R.id.t37;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.t37);
        if (textView != null) {
            i3 = R.id.w0d;
            QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.w0d);
            if (qUIButton != null) {
                i3 = R.id.w0e;
                QUIButton qUIButton2 = (QUIButton) ViewBindings.findChildViewById(view, R.id.w0e);
                if (qUIButton2 != null) {
                    i3 = R.id.w0f;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.w0f);
                    if (textView2 != null) {
                        i3 = R.id.f120607_0;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f120607_0);
                        if (imageView != null) {
                            return new bv((RelativeLayout) view, textView, qUIButton, qUIButton2, textView2, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f442598a;
    }
}
