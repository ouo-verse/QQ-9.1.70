package vp1;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.widget.Switch;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ct implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442797a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442798b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final Switch f442799c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final Switch f442800d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442801e;

    ct(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull Switch r36, @NonNull Switch r46, @NonNull LinearLayout linearLayout2) {
        this.f442797a = linearLayout;
        this.f442798b = textView;
        this.f442799c = r36;
        this.f442800d = r46;
        this.f442801e = linearLayout2;
    }

    @NonNull
    public static ct e(@NonNull View view) {
        int i3 = R.id.x2v;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.x2v);
        if (textView != null) {
            i3 = R.id.f85044nw;
            Switch r56 = (Switch) ViewBindings.findChildViewById(view, R.id.f85044nw);
            if (r56 != null) {
                i3 = R.id.f85124o4;
                Switch r65 = (Switch) ViewBindings.findChildViewById(view, R.id.f85124o4);
                if (r65 != null) {
                    i3 = R.id.f85134o5;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f85134o5);
                    if (linearLayout != null) {
                        return new ct((LinearLayout) view, textView, r56, r65, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442797a;
    }
}
