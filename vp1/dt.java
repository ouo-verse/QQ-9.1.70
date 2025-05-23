package vp1;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dt implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442991a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442992b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442993c;

    dt(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2) {
        this.f442991a = frameLayout;
        this.f442992b = imageView;
        this.f442993c = frameLayout2;
    }

    @NonNull
    public static dt e(@NonNull View view) {
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f167073kg2);
        if (imageView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new dt(frameLayout, imageView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f167073kg2)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442991a;
    }
}
