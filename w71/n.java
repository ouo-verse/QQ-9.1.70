package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tx.x2j.AioReserve1LayoutBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class n implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f444859a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f444860b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f444861c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewStub f444862d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444863e;

    n(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull View view, @NonNull ViewStub viewStub, @NonNull FrameLayout frameLayout) {
        this.f444859a = constraintLayout;
        this.f444860b = constraintLayout2;
        this.f444861c = view;
        this.f444862d = viewStub;
        this.f444863e = frameLayout;
    }

    @NonNull
    public static n e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i3 = R.id.slg;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.slg);
        if (findChildViewById != null) {
            i3 = R.id.tid;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.tid);
            if (viewStub != null) {
                i3 = R.id.f100035re;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f100035re);
                if (frameLayout != null) {
                    return new n(constraintLayout, constraintLayout, findChildViewById, viewStub, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static n g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioReserve1LayoutBinding aioReserve1LayoutBinding = new AioReserve1LayoutBinding();
        aioReserve1LayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioReserve1LayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dw7, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f444859a;
    }
}
