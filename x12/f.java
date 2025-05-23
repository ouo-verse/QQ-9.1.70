package x12;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f446921a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f446922b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f446923c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f446924d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f446925e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f446926f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f446927g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f446928h;

    f(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull TextView textView3) {
        this.f446921a = constraintLayout;
        this.f446922b = constraintLayout2;
        this.f446923c = textView;
        this.f446924d = linearLayout;
        this.f446925e = textView2;
        this.f446926f = imageView;
        this.f446927g = frameLayout;
        this.f446928h = textView3;
    }

    @NonNull
    public static f e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i3 = R.id.f26550du;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f26550du);
        if (textView != null) {
            i3 = R.id.f26560dv;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f26560dv);
            if (linearLayout != null) {
                i3 = R.id.f26570dw;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f26570dw);
                if (textView2 != null) {
                    i3 = R.id.f26580dx;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f26580dx);
                    if (imageView != null) {
                        i3 = R.id.f26590dy;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f26590dy);
                        if (frameLayout != null) {
                            i3 = R.id.f26600dz;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f26600dz);
                            if (textView3 != null) {
                                return new f(constraintLayout, constraintLayout, textView, linearLayout, textView2, imageView, frameLayout, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f446921a;
    }
}
