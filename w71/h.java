package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f444808a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f444809b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f444810c;

    h(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f444808a = constraintLayout;
        this.f444809b = imageView;
        this.f444810c = textView;
    }

    @NonNull
    public static h e(@NonNull View view) {
        int i3 = R.id.d_m;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.d_m);
        if (imageView != null) {
            i3 = R.id.f73343ta;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f73343ta);
            if (textView != null) {
                return new h((ConstraintLayout) view, imageView, textView);
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
        View inflate = layoutInflater.inflate(R.layout.dvq, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f444808a;
    }
}
