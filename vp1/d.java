package vp1;

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
/* loaded from: classes13.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442852a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442853b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442854c;

    d(@NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView) {
        this.f442852a = linearLayout;
        this.f442853b = relativeLayout;
        this.f442854c = textView;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.ww8;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ww8);
        if (relativeLayout != null) {
            i3 = R.id.f115156v_;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f115156v_);
            if (textView != null) {
                return new d((LinearLayout) view, relativeLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.efj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442852a;
    }
}
