package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class al implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442251a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442252b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442253c;

    al(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f442251a = view;
        this.f442252b = imageView;
        this.f442253c = textView;
    }

    @NonNull
    public static al e(@NonNull View view) {
        int i3 = R.id.bat;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.bat);
        if (imageView != null) {
            i3 = R.id.f5e;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f5e);
            if (textView != null) {
                return new al(view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static al f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.ekl, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442251a;
    }
}
