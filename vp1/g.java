package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f443015a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f443016b;

    g(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.f443015a = linearLayout;
        this.f443016b = textView;
    }

    @NonNull
    public static g e(@NonNull View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.kbr);
        if (textView != null) {
            return new g((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.kbr)));
    }

    @NonNull
    public static g g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.efp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f443015a;
    }
}
