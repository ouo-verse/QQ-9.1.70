package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class u implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f447020a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RadiusFrameLayout f447021b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f447022c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f447023d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f447024e;

    u(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull RadiusFrameLayout radiusFrameLayout2, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull TextView textView) {
        this.f447020a = radiusFrameLayout;
        this.f447021b = radiusFrameLayout2;
        this.f447022c = imageView;
        this.f447023d = frameLayout;
        this.f447024e = textView;
    }

    @NonNull
    public static u e(@NonNull View view) {
        RadiusFrameLayout radiusFrameLayout = (RadiusFrameLayout) view;
        int i3 = R.id.wfg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.wfg);
        if (imageView != null) {
            i3 = R.id.wfh;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wfh);
            if (frameLayout != null) {
                i3 = R.id.wfi;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wfi);
                if (textView != null) {
                    return new u(radiusFrameLayout, radiusFrameLayout, imageView, frameLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static u g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static u h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.exg, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f447020a;
    }
}
