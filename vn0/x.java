package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class x implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442048a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442049b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442050c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442051d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442052e;

    x(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.f442048a = linearLayout;
        this.f442049b = imageView;
        this.f442050c = textView;
        this.f442051d = textView2;
        this.f442052e = linearLayout2;
    }

    @NonNull
    public static x e(@NonNull View view) {
        int i3 = R.id.vs9;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.vs9);
        if (imageView != null) {
            i3 = R.id.vsc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vsc);
            if (textView != null) {
                i3 = R.id.zqb;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.zqb);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new x(linearLayout, imageView, textView, textView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static x g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f1i, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442048a;
    }
}
