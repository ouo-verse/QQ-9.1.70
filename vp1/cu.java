package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.LeftBarAvatarFrameLayout;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cu implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442802a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LeftBarAvatarFrameLayout f442803b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442804c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RadiusFrameLayout f442805d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442806e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442807f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442808g;

    cu(@NonNull View view, @NonNull LeftBarAvatarFrameLayout leftBarAvatarFrameLayout, @NonNull RelativeLayout relativeLayout, @NonNull RadiusFrameLayout radiusFrameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2) {
        this.f442802a = view;
        this.f442803b = leftBarAvatarFrameLayout;
        this.f442804c = relativeLayout;
        this.f442805d = radiusFrameLayout;
        this.f442806e = imageView;
        this.f442807f = textView;
        this.f442808g = imageView2;
    }

    @NonNull
    public static cu e(@NonNull View view) {
        int i3 = R.id.t18;
        LeftBarAvatarFrameLayout leftBarAvatarFrameLayout = (LeftBarAvatarFrameLayout) ViewBindings.findChildViewById(view, R.id.t18);
        if (leftBarAvatarFrameLayout != null) {
            i3 = R.id.b8q;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.b8q);
            if (relativeLayout != null) {
                i3 = R.id.f164919bb0;
                RadiusFrameLayout radiusFrameLayout = (RadiusFrameLayout) ViewBindings.findChildViewById(view, R.id.f164919bb0);
                if (radiusFrameLayout != null) {
                    i3 = R.id.f165453w30;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165453w30);
                    if (imageView != null) {
                        i3 = R.id.wrw;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
                        if (textView != null) {
                            i3 = R.id.f88084w4;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f88084w4);
                            if (imageView2 != null) {
                                return new cu(view, leftBarAvatarFrameLayout, relativeLayout, radiusFrameLayout, imageView, textView, imageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static cu f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f2o, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442802a;
    }
}
