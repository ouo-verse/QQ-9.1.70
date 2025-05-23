package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class w implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f442042a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckBox f442043b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442044c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442045d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442046e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442047f;

    w(@NonNull RelativeLayout relativeLayout, @NonNull CheckBox checkBox, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f442042a = relativeLayout;
        this.f442043b = checkBox;
        this.f442044c = relativeLayout2;
        this.f442045d = relativeLayout3;
        this.f442046e = textView;
        this.f442047f = textView2;
    }

    @NonNull
    public static w e(@NonNull View view) {
        int i3 = R.id.tpf;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.tpf);
        if (checkBox != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i3 = R.id.dv_;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.dv_);
            if (relativeLayout2 != null) {
                i3 = R.id.k8i;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.k8i);
                if (textView != null) {
                    i3 = R.id.f108676dr;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f108676dr);
                    if (textView2 != null) {
                        return new w(relativeLayout, checkBox, relativeLayout, relativeLayout2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static w g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ezm, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f442042a;
    }
}
