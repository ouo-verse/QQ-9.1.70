package vp1;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cx implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442826a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442827b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442828c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442829d;

    cx(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.f442826a = linearLayout;
        this.f442827b = imageView;
        this.f442828c = imageView2;
        this.f442829d = textView;
    }

    @NonNull
    public static cx e(@NonNull View view) {
        int i3 = R.id.dtx;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.dtx);
        if (imageView != null) {
            i3 = R.id.y1g;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.y1g);
            if (imageView2 != null) {
                i3 = R.id.f1057766x;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f1057766x);
                if (textView != null) {
                    return new cx((LinearLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442826a;
    }
}
