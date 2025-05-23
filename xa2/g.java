package xa2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f447593a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f447594b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f447595c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f447596d;

    g(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f447593a = linearLayout;
        this.f447594b = textView;
        this.f447595c = textView2;
        this.f447596d = textView3;
    }

    @NonNull
    public static g e(@NonNull View view) {
        int i3 = R.id.f165273ve3;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165273ve3);
        if (textView != null) {
            i3 = R.id.f80334b7;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f80334b7);
            if (textView2 != null) {
                i3 = R.id.f126077ns;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f126077ns);
                if (textView3 != null) {
                    return new g((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f447593a;
    }
}
