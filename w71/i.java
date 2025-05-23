package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f444811a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f444812b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f444813c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f444814d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444815e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f444816f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f444817g;

    i(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView4, @NonNull LinearLayout linearLayout2) {
        this.f444811a = linearLayout;
        this.f444812b = textView;
        this.f444813c = textView2;
        this.f444814d = textView3;
        this.f444815e = relativeLayout;
        this.f444816f = textView4;
        this.f444817g = linearLayout2;
    }

    @NonNull
    public static i e(@NonNull View view) {
        int i3 = R.id.ehf;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ehf);
        if (textView != null) {
            i3 = R.id.ehg;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ehg);
            if (textView2 != null) {
                i3 = R.id.ehh;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.ehh);
                if (textView3 != null) {
                    i3 = R.id.ibn;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ibn);
                    if (relativeLayout != null) {
                        i3 = R.id.f84904ni;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f84904ni);
                        if (textView4 != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            return new i(linearLayout, textView, textView2, textView3, relativeLayout, textView4, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static i g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dvr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f444811a;
    }
}
