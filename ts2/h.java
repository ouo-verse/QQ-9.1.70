package ts2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f437396a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437397b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUISettingsRecyclerView f437398c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f437399d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QQBlurViewWrapper f437400e;

    h(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull QUISettingsRecyclerView qUISettingsRecyclerView, @NonNull ImageView imageView, @NonNull QQBlurViewWrapper qQBlurViewWrapper) {
        this.f437396a = frameLayout;
        this.f437397b = linearLayout;
        this.f437398c = qUISettingsRecyclerView;
        this.f437399d = imageView;
        this.f437400e = qQBlurViewWrapper;
    }

    @NonNull
    public static h e(@NonNull View view) {
        int i3 = R.id.b9t;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.b9t);
        if (linearLayout != null) {
            i3 = R.id.f166238z40;
            QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) ViewBindings.findChildViewById(view, R.id.f166238z40);
            if (qUISettingsRecyclerView != null) {
                i3 = R.id.z4q;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.z4q);
                if (imageView != null) {
                    i3 = R.id.f10362614;
                    QQBlurViewWrapper qQBlurViewWrapper = (QQBlurViewWrapper) ViewBindings.findChildViewById(view, R.id.f10362614);
                    if (qQBlurViewWrapper != null) {
                        return new h((FrameLayout) view, linearLayout, qUISettingsRecyclerView, imageView, qQBlurViewWrapper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static h g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static h h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f169159i12, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f437396a;
    }
}
