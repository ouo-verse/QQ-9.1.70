package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class m implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f446959a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f446960b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f446961c;

    m(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.f446959a = frameLayout;
        this.f446960b = imageView;
        this.f446961c = imageView2;
    }

    @NonNull
    public static m e(@NonNull View view) {
        int i3 = R.id.ddn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ddn);
        if (imageView != null) {
            i3 = R.id.f25730bm;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f25730bm);
            if (imageView2 != null) {
                return new m((FrameLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static m g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static m h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eqt, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f446959a;
    }
}
