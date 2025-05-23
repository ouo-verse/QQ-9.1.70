package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class m implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f443032a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RadiusFrameLayout f443033b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f443034c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f443035d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f443036e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f443037f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443038g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f443039h;

    m(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull RadiusFrameLayout radiusFrameLayout2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2) {
        this.f443032a = radiusFrameLayout;
        this.f443033b = radiusFrameLayout2;
        this.f443034c = imageView;
        this.f443035d = textView;
        this.f443036e = imageView2;
        this.f443037f = imageView3;
        this.f443038g = linearLayout;
        this.f443039h = linearLayout2;
    }

    @NonNull
    public static m e(@NonNull View view) {
        RadiusFrameLayout radiusFrameLayout = (RadiusFrameLayout) view;
        int i3 = R.id.sa_;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.sa_);
        if (imageView != null) {
            i3 = R.id.sx8;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sx8);
            if (textView != null) {
                i3 = R.id.ton;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ton);
                if (imageView2 != null) {
                    i3 = R.id.xaf;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.xaf);
                    if (imageView3 != null) {
                        i3 = R.id.xag;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xag);
                        if (linearLayout != null) {
                            i3 = R.id.xak;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xak);
                            if (linearLayout2 != null) {
                                return new m(radiusFrameLayout, radiusFrameLayout, imageView, textView, imageView2, imageView3, linearLayout, linearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static m g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ege, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f443032a;
    }
}
