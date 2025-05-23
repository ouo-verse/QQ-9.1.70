package pw3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f427795a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f427796b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f427797c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f427798d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f427799e;

    b(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.f427795a = constraintLayout;
        this.f427796b = imageView;
        this.f427797c = constraintLayout2;
        this.f427798d = imageView2;
        this.f427799e = textView;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.f164786tu2;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164786tu2);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i3 = R.id.f80694c6;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f80694c6);
            if (imageView2 != null) {
                i3 = R.id.jfo;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jfo);
                if (textView != null) {
                    return new b(constraintLayout, imageView, constraintLayout, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f427795a;
    }
}
