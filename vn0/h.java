package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f441956a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f441957b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f441958c;

    h(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView) {
        this.f441956a = constraintLayout;
        this.f441957b = constraintLayout2;
        this.f441958c = textView;
    }

    @NonNull
    public static h e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jfb);
        if (textView != null) {
            return new h(constraintLayout, constraintLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.jfb)));
    }

    @NonNull
    public static h g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eeq, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f441956a;
    }
}
