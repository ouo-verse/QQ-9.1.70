package w71;

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
/* loaded from: classes10.dex */
public final class ab implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f444717a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f444718b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444719c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f444720d;

    ab(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView) {
        this.f444717a = relativeLayout;
        this.f444718b = imageView;
        this.f444719c = relativeLayout2;
        this.f444720d = textView;
    }

    @NonNull
    public static ab e(@NonNull View view) {
        int i3 = R.id.t2h;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.t2h);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jpe);
            if (textView != null) {
                return new ab(relativeLayout, imageView, relativeLayout, textView);
            }
            i3 = R.id.jpe;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ab g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static ab h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e9j, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f444717a;
    }
}
