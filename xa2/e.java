package xa2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f447586a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f447587b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f447588c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f447589d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f447590e;

    e(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView) {
        this.f447586a = relativeLayout;
        this.f447587b = imageView;
        this.f447588c = imageView2;
        this.f447589d = relativeLayout2;
        this.f447590e = textView;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.t2r;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.t2r);
        if (imageView != null) {
            i3 = R.id.ztt;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ztt);
            if (imageView2 != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i3 = R.id.jpe;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jpe);
                if (textView != null) {
                    return new e(relativeLayout, imageView, imageView2, relativeLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static e g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fmx, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f447586a;
    }
}
