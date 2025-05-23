package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dd implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FlexboxLayout f442880a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f442881b;

    dd(@NonNull FlexboxLayout flexboxLayout, @NonNull QUIButton qUIButton) {
        this.f442880a = flexboxLayout;
        this.f442881b = qUIButton;
    }

    @NonNull
    public static dd e(@NonNull View view) {
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.tk5);
        if (qUIButton != null) {
            return new dd((FlexboxLayout) view, qUIButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tk5)));
    }

    @NonNull
    public static dd g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f4i, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout getRoot() {
        return this.f442880a;
    }
}
