package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ch implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442705a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f442706b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f442707c;

    ch(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2) {
        this.f442705a = constraintLayout;
        this.f442706b = view;
        this.f442707c = view2;
    }

    @NonNull
    public static ch e(@NonNull View view) {
        int i3 = R.id.y2r;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.y2r);
        if (findChildViewById != null) {
            i3 = R.id.f107706b5;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f107706b5);
            if (findChildViewById2 != null) {
                return new ch((ConstraintLayout) view, findChildViewById, findChildViewById2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ch g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f17, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442705a;
    }
}
