package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f441916a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441917b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f441918c;

    b(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView) {
        this.f441916a = view;
        this.f441917b = linearLayout;
        this.f441918c = imageView;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.zs7;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.zs7);
        if (linearLayout != null) {
            i3 = R.id.f82654hg;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f82654hg);
            if (imageView != null) {
                return new b(view, linearLayout, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.eeb, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f441916a;
    }
}
