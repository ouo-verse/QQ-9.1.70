package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class v implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f442039a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442040b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442041c;

    v(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView) {
        this.f442039a = relativeLayout;
        this.f442040b = relativeLayout2;
        this.f442041c = textView;
    }

    @NonNull
    public static v e(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f108686ds);
        if (textView != null) {
            return new v(relativeLayout, relativeLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f108686ds)));
    }

    @NonNull
    public static v g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ezl, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f442039a;
    }
}
