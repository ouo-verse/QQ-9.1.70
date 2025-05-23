package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tx.x2j.GuildSettingItemOwnerManagerLayoutBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dm implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442941a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442942b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442943c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442944d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442945e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442946f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442947g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f442948h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442949i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442950j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442951k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f442952l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442953m;

    dm(@NonNull ConstraintLayout constraintLayout, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RoundImageView roundImageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView3, @NonNull ConstraintLayout constraintLayout2, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView2, @NonNull ImageView imageView4, @NonNull TextView textView3) {
        this.f442941a = constraintLayout;
        this.f442942b = relativeLayout;
        this.f442943c = imageView;
        this.f442944d = roundImageView;
        this.f442945e = textView;
        this.f442946f = imageView2;
        this.f442947g = relativeLayout2;
        this.f442948h = imageView3;
        this.f442949i = constraintLayout2;
        this.f442950j = lottieAnimationView;
        this.f442951k = textView2;
        this.f442952l = imageView4;
        this.f442953m = textView3;
    }

    @NonNull
    public static dm e(@NonNull View view) {
        int i3 = R.id.wpc;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.wpc);
        if (relativeLayout != null) {
            i3 = R.id.wpi;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.wpi);
            if (imageView != null) {
                i3 = R.id.wta;
                RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wta);
                if (roundImageView != null) {
                    i3 = R.id.wtb;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wtb);
                    if (textView != null) {
                        i3 = R.id.wtc;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.wtc);
                        if (imageView2 != null) {
                            i3 = R.id.wtd;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.wtd);
                            if (relativeLayout2 != null) {
                                i3 = R.id.wte;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.wte);
                                if (imageView3 != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                    i3 = R.id.xnh;
                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.xnh);
                                    if (lottieAnimationView != null) {
                                        i3 = R.id.y5k;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.y5k);
                                        if (textView2 != null) {
                                            i3 = R.id.e_3;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.e_3);
                                            if (imageView4 != null) {
                                                i3 = R.id.f109796gs;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f109796gs);
                                                if (textView3 != null) {
                                                    return new dm(constraintLayout, relativeLayout, imageView, roundImageView, textView, imageView2, relativeLayout2, imageView3, constraintLayout, lottieAnimationView, textView2, imageView4, textView3);
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
    public static dm g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildSettingItemOwnerManagerLayoutBinding guildSettingItemOwnerManagerLayoutBinding = new GuildSettingItemOwnerManagerLayoutBinding();
        guildSettingItemOwnerManagerLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildSettingItemOwnerManagerLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f8g, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMContainer() {
        return this.f442941a;
    }
}
