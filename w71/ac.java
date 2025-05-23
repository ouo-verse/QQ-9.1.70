package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ac implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f444721a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444722b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444723c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444724d;

    ac(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3) {
        this.f444721a = constraintLayout;
        this.f444722b = frameLayout;
        this.f444723c = frameLayout2;
        this.f444724d = frameLayout3;
    }

    @NonNull
    public static ac e(@NonNull View view) {
        int i3 = R.id.vee;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.vee);
        if (frameLayout != null) {
            i3 = R.id.veg;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.veg);
            if (frameLayout2 != null) {
                i3 = R.id.vek;
                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.vek);
                if (frameLayout3 != null) {
                    return new ac((ConstraintLayout) view, frameLayout, frameLayout2, frameLayout3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ac g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e_d, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f444721a;
    }
}
