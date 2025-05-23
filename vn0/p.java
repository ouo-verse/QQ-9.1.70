package vn0;

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
/* loaded from: classes6.dex */
public final class p implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f441996a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f441997b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f441998c;

    p(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView) {
        this.f441996a = frameLayout;
        this.f441997b = frameLayout2;
        this.f441998c = imageView;
    }

    @NonNull
    public static p e(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.y3z);
        if (imageView != null) {
            return new p(frameLayout, frameLayout, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.y3z)));
    }

    @NonNull
    public static p g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168034eg1, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f441996a;
    }
}
