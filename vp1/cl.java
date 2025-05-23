package vp1;

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
/* loaded from: classes13.dex */
public final class cl implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442727a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442728b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442729c;

    cl(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView) {
        this.f442727a = linearLayout;
        this.f442728b = textView;
        this.f442729c = imageView;
    }

    @NonNull
    public static cl e(@NonNull View view) {
        int i3 = R.id.u8m;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.u8m);
        if (textView != null) {
            i3 = R.id.imo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imo);
            if (imageView != null) {
                return new cl((LinearLayout) view, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static cl g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f1b, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442727a;
    }
}
