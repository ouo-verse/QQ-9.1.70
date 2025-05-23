package xa2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f447573a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f447574b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f447575c;

    c(@NonNull View view, @NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout) {
        this.f447573a = view;
        this.f447574b = relativeLayout;
        this.f447575c = frameLayout;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.l_k;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.l_k);
        if (relativeLayout != null) {
            i3 = R.id.f164553t21;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f164553t21);
            if (frameLayout != null) {
                return new c(view, relativeLayout, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static c f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.fmv, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f447573a;
    }
}
