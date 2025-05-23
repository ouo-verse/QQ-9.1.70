package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ad implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442173a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f442174b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442175c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f442176d;

    ad(@NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull View view3) {
        this.f442173a = view;
        this.f442174b = view2;
        this.f442175c = imageView;
        this.f442176d = view3;
    }

    @NonNull
    public static ad e(@NonNull View view) {
        int i3 = R.id.ywa;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.ywa);
        if (findChildViewById != null) {
            i3 = R.id.zs5;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.zs5);
            if (imageView != null) {
                i3 = R.id.f84034l6;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f84034l6);
                if (findChildViewById2 != null) {
                    return new ad(view, findChildViewById, imageView, findChildViewById2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ad f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f168054ek1, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442173a;
    }
}
