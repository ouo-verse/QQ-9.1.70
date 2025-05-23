package ts2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f437391a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437392b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f437393c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f437394d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f437395e;

    g(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageFilterView imageFilterView, @NonNull TextView textView, @NonNull ImageView imageView) {
        this.f437391a = linearLayout;
        this.f437392b = linearLayout2;
        this.f437393c = imageFilterView;
        this.f437394d = textView;
        this.f437395e = imageView;
    }

    @NonNull
    public static g e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.f164379vi;
        ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f164379vi);
        if (imageFilterView != null) {
            i3 = R.id.f164389w0;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f164389w0);
            if (textView != null) {
                i3 = R.id.xe9;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.xe9);
                if (imageView != null) {
                    return new g(linearLayout, linearLayout, imageFilterView, textView, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static g g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static g h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f169158i11, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f437391a;
    }
}
