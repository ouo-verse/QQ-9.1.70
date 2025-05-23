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
public final class di implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442909a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442910b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442911c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442912d;

    di(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull ImageView imageView) {
        this.f442909a = linearLayout;
        this.f442910b = linearLayout2;
        this.f442911c = textView;
        this.f442912d = imageView;
    }

    @NonNull
    public static di e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.wwt;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wwt);
        if (textView != null) {
            i3 = R.id.dvu;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.dvu);
            if (imageView != null) {
                return new di(linearLayout, linearLayout, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static di g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f5y, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442909a;
    }
}
