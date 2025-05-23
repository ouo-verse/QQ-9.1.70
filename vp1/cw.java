package vp1;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cw implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442818a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442819b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f442820c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUIButton f442821d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QUIButton f442822e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442823f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442824g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442825h;

    cw(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ViewPager2 viewPager2, @NonNull QUIButton qUIButton, @NonNull QUIButton qUIButton2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout2) {
        this.f442818a = linearLayout;
        this.f442819b = textView;
        this.f442820c = viewPager2;
        this.f442821d = qUIButton;
        this.f442822e = qUIButton2;
        this.f442823f = imageView;
        this.f442824g = imageView2;
        this.f442825h = linearLayout2;
    }

    @NonNull
    public static cw e(@NonNull View view) {
        int i3 = R.id.f164715tl4;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f164715tl4);
        if (textView != null) {
            i3 = R.id.tl6;
            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.tl6);
            if (viewPager2 != null) {
                i3 = R.id.aya;
                QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.aya);
                if (qUIButton != null) {
                    i3 = R.id.b7m;
                    QUIButton qUIButton2 = (QUIButton) ViewBindings.findChildViewById(view, R.id.b7m);
                    if (qUIButton2 != null) {
                        i3 = R.id.wsd;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.wsd);
                        if (imageView != null) {
                            i3 = R.id.wtx;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.wtx);
                            if (imageView2 != null) {
                                i3 = R.id.f122177d9;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f122177d9);
                                if (linearLayout != null) {
                                    return new cw((LinearLayout) view, textView, viewPager2, qUIButton, qUIButton2, imageView, imageView2, linearLayout);
                                }
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
    public LinearLayout getRoot() {
        return this.f442818a;
    }
}
