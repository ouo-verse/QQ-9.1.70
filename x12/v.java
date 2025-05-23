package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class v implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f447025a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f447026b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f447027c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f447028d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f447029e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f447030f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f447031g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f447032h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f447033i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f447034j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f447035k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f447036l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f447037m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final LinearLayout f447038n;

    v(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull View view, @NonNull LottieAnimationView lottieAnimationView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout3, @NonNull TextView textView4, @NonNull LinearLayout linearLayout4) {
        this.f447025a = constraintLayout;
        this.f447026b = textView;
        this.f447027c = imageView;
        this.f447028d = linearLayout;
        this.f447029e = textView2;
        this.f447030f = view;
        this.f447031g = lottieAnimationView;
        this.f447032h = imageView2;
        this.f447033i = linearLayout2;
        this.f447034j = textView3;
        this.f447035k = imageView3;
        this.f447036l = linearLayout3;
        this.f447037m = textView4;
        this.f447038n = linearLayout4;
    }

    @NonNull
    public static v e(@NonNull View view) {
        int i3 = R.id.u1l;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.u1l);
        if (textView != null) {
            i3 = R.id.b4f;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.b4f);
            if (imageView != null) {
                i3 = R.id.b4g;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.b4g);
                if (linearLayout != null) {
                    i3 = R.id.f164861b54;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f164861b54);
                    if (textView2 != null) {
                        i3 = R.id.w8t;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.w8t);
                        if (findChildViewById != null) {
                            i3 = R.id.yi5;
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.yi5);
                            if (lottieAnimationView != null) {
                                i3 = R.id.e9k;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.e9k);
                                if (imageView2 != null) {
                                    i3 = R.id.e9l;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.e9l);
                                    if (linearLayout2 != null) {
                                        i3 = R.id.e9q;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.e9q);
                                        if (textView3 != null) {
                                            i3 = R.id.f84344m0;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f84344m0);
                                            if (imageView3 != null) {
                                                i3 = R.id.f84364m2;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f84364m2);
                                                if (linearLayout3 != null) {
                                                    i3 = R.id.f84514mg;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f84514mg);
                                                    if (textView4 != null) {
                                                        i3 = R.id.jnc;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jnc);
                                                        if (linearLayout4 != null) {
                                                            return new v((ConstraintLayout) view, textView, imageView, linearLayout, textView2, findChildViewById, lottieAnimationView, imageView2, linearLayout2, textView3, imageView3, linearLayout3, textView4, linearLayout4);
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
    public static v g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f0x, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f447025a;
    }
}
