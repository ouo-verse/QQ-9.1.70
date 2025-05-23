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
import com.tencent.widget.FoldableTextView;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class p implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f444867a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FoldableTextView f444868b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f444869c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f444870d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f444871e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f444872f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f444873g;

    p(@NonNull LinearLayout linearLayout, @NonNull FoldableTextView foldableTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView4) {
        this.f444867a = linearLayout;
        this.f444868b = foldableTextView;
        this.f444869c = textView;
        this.f444870d = textView2;
        this.f444871e = textView3;
        this.f444872f = linearLayout2;
        this.f444873g = textView4;
    }

    @NonNull
    public static p e(@NonNull View view) {
        int i3 = R.id.z_8;
        FoldableTextView foldableTextView = (FoldableTextView) ViewBindings.findChildViewById(view, R.id.z_8);
        if (foldableTextView != null) {
            i3 = R.id.z_9;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.z_9);
            if (textView != null) {
                i3 = R.id.z__;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.z__);
                if (textView2 != null) {
                    i3 = R.id.z_a;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.z_a);
                    if (textView3 != null) {
                        i3 = R.id.z_b;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.z_b);
                        if (linearLayout != null) {
                            i3 = R.id.z_c;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.z_c);
                            if (textView4 != null) {
                                return new p((LinearLayout) view, foldableTextView, textView, textView2, textView3, linearLayout, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static p g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dw_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f444867a;
    }
}
