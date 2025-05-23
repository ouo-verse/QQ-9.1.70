package pw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f427800a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f427801b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final b f427802c;

    c(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull b bVar) {
        this.f427800a = constraintLayout;
        this.f427801b = button;
        this.f427802c = bVar;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.cancel;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancel);
        if (button != null) {
            i3 = R.id.iji;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.iji);
            if (findChildViewById != null) {
                return new c((ConstraintLayout) view, button, b.e(findChildViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e2a, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f427800a;
    }
}
