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
public final class u implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f443100a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f443101b;

    u(@NonNull View view, @NonNull ImageView imageView) {
        this.f443100a = view;
        this.f443101b = imageView;
    }

    @NonNull
    public static u e(@NonNull View view) {
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.zs5);
        if (imageView != null) {
            return new u(view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.zs5)));
    }

    @NonNull
    public static u f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.eht, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f443100a;
    }
}
