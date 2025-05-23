package vp1;

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
/* loaded from: classes13.dex */
public final class w implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f443128a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f443129b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f443130c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f443131d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f443132e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f443133f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443134g;

    w(@NonNull View view, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout) {
        this.f443128a = view;
        this.f443129b = imageView;
        this.f443130c = imageView2;
        this.f443131d = imageView3;
        this.f443132e = textView;
        this.f443133f = imageView4;
        this.f443134g = linearLayout;
    }

    @NonNull
    public static w e(@NonNull View view) {
        int i3 = R.id.f164897b91;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164897b91);
        if (imageView != null) {
            i3 = R.id.u7i;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.u7i);
            if (imageView2 != null) {
                i3 = R.id.f83754ke;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f83754ke);
                if (imageView3 != null) {
                    i3 = R.id.title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                    if (textView != null) {
                        i3 = R.id.jo8;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.jo8);
                        if (imageView4 != null) {
                            i3 = R.id.title_container;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.title_container);
                            if (linearLayout != null) {
                                return new w(view, imageView, imageView2, imageView3, textView, imageView4, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static w f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.ehz, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f443128a;
    }
}
