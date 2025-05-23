package w71;

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
/* loaded from: classes10.dex */
public final class aj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f444768a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f444769b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f444770c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f444771d;

    aj(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f444768a = linearLayout;
        this.f444769b = textView;
        this.f444770c = textView2;
        this.f444771d = textView3;
    }

    @NonNull
    public static aj e(@NonNull View view) {
        int i3 = R.id.tct;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tct);
        if (textView != null) {
            i3 = R.id.tg6;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tg6);
            if (textView2 != null) {
                i3 = R.id.tgt;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tgt);
                if (textView3 != null) {
                    return new aj((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aj g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static aj h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.i0z, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f444768a;
    }
}
