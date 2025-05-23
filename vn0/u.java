package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class u implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442036a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442037b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442038c;

    u(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull LinearLayout linearLayout) {
        this.f442036a = constraintLayout;
        this.f442037b = constraintLayout2;
        this.f442038c = linearLayout;
    }

    @NonNull
    public static u e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.zfv);
        if (linearLayout != null) {
            return new u(constraintLayout, constraintLayout, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.zfv)));
    }

    @NonNull
    public static u g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.exw, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442036a;
    }
}
