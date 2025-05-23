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
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f441959a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441960b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f441961c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f441962d;

    i(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f441959a = linearLayout;
        this.f441960b = linearLayout2;
        this.f441961c = imageView;
        this.f441962d = textView;
    }

    @NonNull
    public static i e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.vxs;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.vxs);
        if (imageView != null) {
            i3 = R.id.vxu;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vxu);
            if (textView != null) {
                return new i(linearLayout, linearLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static i g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eew, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f441959a;
    }
}
