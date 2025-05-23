package r71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f430915a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f430916b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f430917c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f430918d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final Button f430919e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f430920f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f430921g;

    b(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Button button, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2) {
        this.f430915a = frameLayout;
        this.f430916b = imageView;
        this.f430917c = textView;
        this.f430918d = textView2;
        this.f430919e = button;
        this.f430920f = linearLayout;
        this.f430921g = frameLayout2;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.a4f;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.a4f);
        if (imageView != null) {
            i3 = R.id.tis;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tis);
            if (textView != null) {
                i3 = R.id.tit;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tit);
                if (textView2 != null) {
                    i3 = R.id.close;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.close);
                    if (button != null) {
                        i3 = R.id.content;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.content);
                        if (linearLayout != null) {
                            i3 = R.id.jsv;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.jsv);
                            if (frameLayout != null) {
                                return new b((FrameLayout) view, imageView, textView, textView2, button, linearLayout, frameLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e_g, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f430915a;
    }
}
