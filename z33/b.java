package z33;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f451860a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f451861b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f451862c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f451863d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f451864e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f451865f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f451866g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f451867h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f451868i;

    b(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull View view2, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView2) {
        this.f451860a = view;
        this.f451861b = imageView;
        this.f451862c = textView;
        this.f451863d = view2;
        this.f451864e = relativeLayout;
        this.f451865f = relativeLayout2;
        this.f451866g = imageView2;
        this.f451867h = imageView3;
        this.f451868i = textView2;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.lzp;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.lzp);
        if (imageView != null) {
            i3 = R.id.lzq;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.lzq);
            if (textView != null) {
                i3 = R.id.f26090cl;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f26090cl);
                if (findChildViewById != null) {
                    i3 = R.id.f26100cm;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f26100cm);
                    if (relativeLayout != null) {
                        i3 = R.id.lzs;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.lzs);
                        if (relativeLayout2 != null) {
                            i3 = R.id.f26110cn;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f26110cn);
                            if (imageView2 != null) {
                                i3 = R.id.f26120co;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f26120co);
                                if (imageView3 != null) {
                                    i3 = R.id.lzy;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.lzy);
                                    if (textView2 != null) {
                                        return new b(view, imageView, textView, findChildViewById, relativeLayout, relativeLayout2, imageView2, imageView3, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.i36, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f451860a;
    }
}
