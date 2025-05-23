package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dv implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442998a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final WheelView f442999b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f443000c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f443001d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f443002e;

    dv(@NonNull View view, @NonNull WheelView wheelView, @NonNull View view2, @NonNull View view3, @NonNull View view4) {
        this.f442998a = view;
        this.f442999b = wheelView;
        this.f443000c = view2;
        this.f443001d = view3;
        this.f443002e = view4;
    }

    @NonNull
    public static dv e(@NonNull View view) {
        int i3 = R.id.yaf;
        WheelView wheelView = (WheelView) ViewBindings.findChildViewById(view, R.id.yaf);
        if (wheelView != null) {
            i3 = R.id.e_b;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.e_b);
            if (findChildViewById != null) {
                i3 = R.id.yin;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.yin);
                if (findChildViewById2 != null) {
                    i3 = R.id.e_x;
                    View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.e_x);
                    if (findChildViewById3 != null) {
                        return new dv(view, wheelView, findChildViewById, findChildViewById2, findChildViewById3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static dv f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f_g, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442998a;
    }
}
