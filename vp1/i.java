package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f443019a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f443020b;

    i(@NonNull FrameLayout frameLayout, @NonNull TextView textView) {
        this.f443019a = frameLayout;
        this.f443020b = textView;
    }

    @NonNull
    public static i e(@NonNull View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.kbs);
        if (textView != null) {
            return new i((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.kbs)));
    }

    @NonNull
    public static i g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.efr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f443019a;
    }
}
