package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f443021a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f443022b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f443023c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f443024d;

    j(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f443021a = constraintLayout;
        this.f443022b = textView;
        this.f443023c = textView2;
        this.f443024d = textView3;
    }

    @NonNull
    public static j e(@NonNull View view) {
        int i3 = R.id.f107636ay;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f107636ay);
        if (textView != null) {
            i3 = R.id.f107676b2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f107676b2);
            if (textView2 != null) {
                i3 = R.id.f109186f5;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f109186f5);
                if (textView3 != null) {
                    return new j((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static j g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.efs, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f443021a;
    }
}
