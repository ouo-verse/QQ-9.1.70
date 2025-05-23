package z12;

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
/* loaded from: classes7.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f451734a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f451735b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451736c;

    c(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull LinearLayout linearLayout) {
        this.f451734a = constraintLayout;
        this.f451735b = constraintLayout2;
        this.f451736c = linearLayout;
    }

    @NonNull
    public static c e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.zfv);
        if (linearLayout != null) {
            return new c(constraintLayout, constraintLayout, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.zfv)));
    }

    @NonNull
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ewg, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f451734a;
    }
}
