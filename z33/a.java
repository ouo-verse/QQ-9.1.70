package z33;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.base.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f451845a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f451846b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f451847c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundRectImageView f451848d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f451849e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RoundRectImageView f451850f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f451851g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f451852h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f451853i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f451854j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f451855k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f451856l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f451857m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f451858n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f451859o;

    a(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull RoundRectImageView roundRectImageView, @NonNull FrameLayout frameLayout2, @NonNull RoundRectImageView roundRectImageView2, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f451845a = relativeLayout;
        this.f451846b = frameLayout;
        this.f451847c = imageView;
        this.f451848d = roundRectImageView;
        this.f451849e = frameLayout2;
        this.f451850f = roundRectImageView2;
        this.f451851g = imageView2;
        this.f451852h = imageView3;
        this.f451853i = imageView4;
        this.f451854j = imageView5;
        this.f451855k = relativeLayout2;
        this.f451856l = textView;
        this.f451857m = textView2;
        this.f451858n = textView3;
        this.f451859o = textView4;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.t6e;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.t6e);
        if (frameLayout != null) {
            i3 = R.id.tij;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.tij);
            if (imageView != null) {
                i3 = R.id.tik;
                RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.tik);
                if (roundRectImageView != null) {
                    i3 = R.id.f165678x82;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f165678x82);
                    if (frameLayout2 != null) {
                        i3 = R.id.xj9;
                        RoundRectImageView roundRectImageView2 = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.xj9);
                        if (roundRectImageView2 != null) {
                            i3 = R.id.xjn;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.xjn);
                            if (imageView2 != null) {
                                i3 = R.id.f165775xk0;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165775xk0);
                                if (imageView3 != null) {
                                    i3 = R.id.f165776xk1;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165776xk1);
                                    if (imageView4 != null) {
                                        i3 = R.id.xk7;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.xk7);
                                        if (imageView5 != null) {
                                            RelativeLayout relativeLayout = (RelativeLayout) view;
                                            i3 = R.id.f112946pa;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f112946pa);
                                            if (textView != null) {
                                                i3 = R.id.f113086po;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f113086po);
                                                if (textView2 != null) {
                                                    i3 = R.id.f113116pr;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f113116pr);
                                                    if (textView3 != null) {
                                                        i3 = R.id.f113336qc;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f113336qc);
                                                        if (textView4 != null) {
                                                            return new a(relativeLayout, frameLayout, imageView, roundRectImageView, frameLayout2, roundRectImageView2, imageView2, imageView3, imageView4, imageView5, relativeLayout, textView, textView2, textView3, textView4);
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f169171i32, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f451845a;
    }
}
