package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f444784a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f444785b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f444786c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f444787d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f444788e;

    e(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView3) {
        this.f444784a = linearLayout;
        this.f444785b = imageView;
        this.f444786c = imageView2;
        this.f444787d = linearLayout2;
        this.f444788e = imageView3;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.f164717lc1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164717lc1);
        if (imageView != null) {
            i3 = R.id.usy;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.usy);
            if (imageView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i3 = R.id.f24780_2;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f24780_2);
                if (imageView3 != null) {
                    return new e(linearLayout, imageView, imageView2, linearLayout, imageView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static e g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dvb, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f444784a;
    }
}
