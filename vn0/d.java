package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f441927a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f441928b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f441929c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f441930d;

    d(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView) {
        this.f441927a = frameLayout;
        this.f441928b = frameLayout2;
        this.f441929c = relativeLayout;
        this.f441930d = textView;
    }

    @NonNull
    public static d e(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i3 = R.id.vxq;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.vxq);
        if (relativeLayout != null) {
            i3 = R.id.vyf;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vyf);
            if (textView != null) {
                return new d(frameLayout, frameLayout, relativeLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eej, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f441927a;
    }
}
