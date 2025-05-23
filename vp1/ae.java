package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ae implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442177a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442178b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RadiusFrameLayout f442179c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442180d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442181e;

    ae(@NonNull View view, @NonNull ImageView imageView, @NonNull RadiusFrameLayout radiusFrameLayout, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout) {
        this.f442177a = view;
        this.f442178b = imageView;
        this.f442179c = radiusFrameLayout;
        this.f442180d = imageView2;
        this.f442181e = frameLayout;
    }

    @NonNull
    public static ae e(@NonNull View view) {
        int i3 = R.id.zs5;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.zs5);
        if (imageView != null) {
            i3 = R.id.zs6;
            RadiusFrameLayout radiusFrameLayout = (RadiusFrameLayout) ViewBindings.findChildViewById(view, R.id.zs6);
            if (radiusFrameLayout != null) {
                i3 = R.id.f2181021;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f2181021);
                if (imageView2 != null) {
                    i3 = R.id.f2182022;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f2182022);
                    if (frameLayout != null) {
                        return new ae(view, imageView, radiusFrameLayout, imageView2, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ae f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f168055ek2, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442177a;
    }
}
