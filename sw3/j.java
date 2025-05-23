package sw3;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.base.widget.NTImmersiveTitleBar;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f434909a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final NTImmersiveTitleBar f434910b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f434911c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f434912d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f434913e;

    j(@NonNull LinearLayout linearLayout, @NonNull NTImmersiveTitleBar nTImmersiveTitleBar, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.f434909a = linearLayout;
        this.f434910b = nTImmersiveTitleBar;
        this.f434911c = textView;
        this.f434912d = textView2;
        this.f434913e = linearLayout2;
    }

    @NonNull
    public static j e(@NonNull View view) {
        int i3 = R.id.xl7;
        NTImmersiveTitleBar nTImmersiveTitleBar = (NTImmersiveTitleBar) ViewBindings.findChildViewById(view, R.id.xl7);
        if (nTImmersiveTitleBar != null) {
            i3 = R.id.ivTitleBtnLeft;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ivTitleBtnLeft);
            if (textView != null) {
                i3 = R.id.f97;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f97);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new j(linearLayout, nTImmersiveTitleBar, textView, textView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f434909a;
    }
}
