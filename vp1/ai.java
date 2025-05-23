package vp1;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ai implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442219a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f442220b;

    ai(@NonNull LinearLayout linearLayout, @NonNull QUIButton qUIButton) {
        this.f442219a = linearLayout;
        this.f442220b = qUIButton;
    }

    @NonNull
    public static ai e(@NonNull View view) {
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.zyo);
        if (qUIButton != null) {
            return new ai((LinearLayout) view, qUIButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.zyo)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442219a;
    }
}
