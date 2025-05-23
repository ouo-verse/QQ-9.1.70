package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f441971a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441972b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f441973c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f441974d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f441975e;

    l(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view) {
        this.f441971a = linearLayout;
        this.f441972b = linearLayout2;
        this.f441973c = textView;
        this.f441974d = textView2;
        this.f441975e = view;
    }

    @NonNull
    public static l e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.vx6;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vx6);
        if (textView != null) {
            i3 = R.id.vya;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.vya);
            if (textView2 != null) {
                i3 = R.id.wvv;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.wvv);
                if (findChildViewById != null) {
                    return new l(linearLayout, linearLayout, textView, textView2, findChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static l g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168030ef2, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f441971a;
    }
}
