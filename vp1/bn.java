package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bn implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442523a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f442524b;

    bn(@NonNull ConstraintLayout constraintLayout, @NonNull QUIButton qUIButton) {
        this.f442523a = constraintLayout;
        this.f442524b = qUIButton;
    }

    @NonNull
    public static bn e(@NonNull View view) {
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.wku);
        if (qUIButton != null) {
            return new bn((ConstraintLayout) view, qUIButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.wku)));
    }

    @NonNull
    public static bn g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.euc, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442523a;
    }
}
