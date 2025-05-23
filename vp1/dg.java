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
public final class dg implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442892a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442893b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442894c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442895d;

    dg(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull ImageView imageView) {
        this.f442892a = linearLayout;
        this.f442893b = linearLayout2;
        this.f442894c = textView;
        this.f442895d = imageView;
    }

    @NonNull
    public static dg e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.wwn;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wwn);
        if (textView != null) {
            i3 = R.id.dvu;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.dvu);
            if (imageView != null) {
                return new dg(linearLayout, linearLayout, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static dg g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168166f54, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442892a;
    }
}
