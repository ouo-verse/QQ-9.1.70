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
public final class am implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442254a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442255b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442256c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442257d;

    am(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2) {
        this.f442254a = linearLayout;
        this.f442255b = textView;
        this.f442256c = imageView;
        this.f442257d = linearLayout2;
    }

    @NonNull
    public static am e(@NonNull View view) {
        int i3 = R.id.xbi;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.xbi);
        if (textView != null) {
            i3 = R.id.ijw;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ijw);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new am(linearLayout, textView, imageView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static am g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ekt, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442254a;
    }
}
