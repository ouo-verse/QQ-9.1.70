package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes7.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f446939a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f446940b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUIColorfulQRCodeView f446941c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f446942d;

    j(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull QUIColorfulQRCodeView qUIColorfulQRCodeView, @NonNull TextView textView) {
        this.f446939a = linearLayout;
        this.f446940b = imageView;
        this.f446941c = qUIColorfulQRCodeView;
        this.f446942d = textView;
    }

    @NonNull
    public static j e(@NonNull View view) {
        int i3 = R.id.f165569wp4;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165569wp4);
        if (imageView != null) {
            i3 = R.id.wuq;
            QUIColorfulQRCodeView qUIColorfulQRCodeView = (QUIColorfulQRCodeView) ViewBindings.findChildViewById(view, R.id.wuq);
            if (qUIColorfulQRCodeView != null) {
                i3 = R.id.x2c;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.x2c);
                if (textView != null) {
                    return new j((LinearLayout) view, imageView, qUIColorfulQRCodeView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static j g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static j h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eqq, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f446939a;
    }
}
