package ts2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f437423a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f437424b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f437425c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437426d;

    l(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinearLayout linearLayout) {
        this.f437423a = view;
        this.f437424b = imageView;
        this.f437425c = textView;
        this.f437426d = linearLayout;
    }

    @NonNull
    public static l e(@NonNull View view) {
        int i3 = R.id.yzo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.yzo);
        if (imageView != null) {
            i3 = R.id.yzq;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.yzq);
            if (textView != null) {
                i3 = R.id.yzr;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.yzr);
                if (linearLayout != null) {
                    return new l(view, imageView, textView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static l f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.i1j, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f437423a;
    }
}
