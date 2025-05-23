package x12;

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
/* loaded from: classes7.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f446884a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f446885b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f446886c;

    b(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f446884a = linearLayout;
        this.f446885b = textView;
        this.f446886c = textView2;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.f1068369s;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f1068369s);
        if (textView != null) {
            i3 = R.id.f107576as;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f107576as);
            if (textView2 != null) {
                return new b((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.emt, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f446884a;
    }
}
