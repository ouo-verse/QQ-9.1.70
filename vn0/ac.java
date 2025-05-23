package vn0;

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
/* loaded from: classes6.dex */
public final class ac implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f441912a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f441913b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441914c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f441915d;

    ac(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.f441912a = linearLayout;
        this.f441913b = textView;
        this.f441914c = linearLayout2;
        this.f441915d = textView2;
    }

    @NonNull
    public static ac e(@NonNull View view) {
        int i3 = R.id.vsc;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vsc);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f905252p);
            if (textView2 != null) {
                return new ac(linearLayout, textView, linearLayout, textView2);
            }
            i3 = R.id.f905252p;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ac g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f9o, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f441912a;
    }
}
