package z12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f451737a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f451738b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f451739c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451740d;

    d(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull View view, @NonNull LinearLayout linearLayout) {
        this.f451737a = relativeLayout;
        this.f451738b = relativeLayout2;
        this.f451739c = view;
        this.f451740d = linearLayout;
    }

    @NonNull
    public static d e(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i3 = R.id.wri;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.wri);
        if (findChildViewById != null) {
            i3 = R.id.zfv;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.zfv);
            if (linearLayout != null) {
                return new d(relativeLayout, relativeLayout, findChildViewById, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ewh, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f451737a;
    }
}
