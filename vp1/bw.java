package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView;
import com.tencent.mobileqq.guild.widget.ScanningView;
import com.tx.x2j.GuildMediaChannelFragmentBottomBinding;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bw implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442604a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildFreeGiftView f442605b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442606c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442607d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442608e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442609f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442610g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f442611h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f442612i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442613j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f442614k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f442615l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442616m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442617n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final ImageView f442618o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442619p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final ImageView f442620q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final GuildAIOInputEditText f442621r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final ImageView f442622s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    public final TextView f442623t;

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    public final ScanningView f442624u;

    bw(@NonNull LinearLayout linearLayout, @NonNull GuildFreeGiftView guildFreeGiftView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull FrameLayout frameLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView7, @NonNull LinearLayout linearLayout4, @NonNull ImageView imageView8, @NonNull GuildAIOInputEditText guildAIOInputEditText, @NonNull ImageView imageView9, @NonNull TextView textView3, @NonNull ScanningView scanningView) {
        this.f442604a = linearLayout;
        this.f442605b = guildFreeGiftView;
        this.f442606c = imageView;
        this.f442607d = imageView2;
        this.f442608e = imageView3;
        this.f442609f = imageView4;
        this.f442610g = frameLayout;
        this.f442611h = lottieAnimationView;
        this.f442612i = textView;
        this.f442613j = linearLayout2;
        this.f442614k = imageView5;
        this.f442615l = imageView6;
        this.f442616m = textView2;
        this.f442617n = linearLayout3;
        this.f442618o = imageView7;
        this.f442619p = linearLayout4;
        this.f442620q = imageView8;
        this.f442621r = guildAIOInputEditText;
        this.f442622s = imageView9;
        this.f442623t = textView3;
        this.f442624u = scanningView;
    }

    @NonNull
    public static bw e(@NonNull View view) {
        int i3 = R.id.swx;
        GuildFreeGiftView guildFreeGiftView = (GuildFreeGiftView) ViewBindings.findChildViewById(view, R.id.swx);
        if (guildFreeGiftView != null) {
            i3 = R.id.swz;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.swz);
            if (imageView != null) {
                i3 = R.id.f164504sx0;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f164504sx0);
                if (imageView2 != null) {
                    i3 = R.id.f164508sx1;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f164508sx1);
                    if (imageView3 != null) {
                        i3 = R.id.f164509sx2;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f164509sx2);
                        if (imageView4 != null) {
                            i3 = R.id.f164510sx3;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f164510sx3);
                            if (frameLayout != null) {
                                i3 = R.id.f164511sx4;
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.f164511sx4);
                                if (lottieAnimationView != null) {
                                    i3 = R.id.sx5;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sx5);
                                    if (textView != null) {
                                        i3 = R.id.sx6;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sx6);
                                        if (linearLayout != null) {
                                            i3 = R.id.sx7;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.sx7);
                                            if (imageView5 != null) {
                                                i3 = R.id.sx9;
                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.sx9);
                                                if (imageView6 != null) {
                                                    i3 = R.id.vzm;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.vzm);
                                                    if (textView2 != null) {
                                                        i3 = R.id.wq7;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wq7);
                                                        if (linearLayout2 != null) {
                                                            i3 = R.id.wq8;
                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.wq8);
                                                            if (imageView7 != null) {
                                                                i3 = R.id.wq9;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wq9);
                                                                if (linearLayout3 != null) {
                                                                    i3 = R.id.wq_;
                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R.id.wq_);
                                                                    if (imageView8 != null) {
                                                                        i3 = R.id.wqa;
                                                                        GuildAIOInputEditText guildAIOInputEditText = (GuildAIOInputEditText) ViewBindings.findChildViewById(view, R.id.wqa);
                                                                        if (guildAIOInputEditText != null) {
                                                                            i3 = R.id.wqb;
                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, R.id.wqb);
                                                                            if (imageView9 != null) {
                                                                                i3 = R.id.wqc;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.wqc);
                                                                                if (textView3 != null) {
                                                                                    i3 = R.id.f79734_k;
                                                                                    ScanningView scanningView = (ScanningView) ViewBindings.findChildViewById(view, R.id.f79734_k);
                                                                                    if (scanningView != null) {
                                                                                        return new bw((LinearLayout) view, guildFreeGiftView, imageView, imageView2, imageView3, imageView4, frameLayout, lottieAnimationView, textView, linearLayout, imageView5, imageView6, textView2, linearLayout2, imageView7, linearLayout3, imageView8, guildAIOInputEditText, imageView9, textView3, scanningView);
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
    public static bw g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static bw h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        GuildMediaChannelFragmentBottomBinding guildMediaChannelFragmentBottomBinding = new GuildMediaChannelFragmentBottomBinding();
        guildMediaChannelFragmentBottomBinding.t(layoutInflater, viewGroup, z16);
        View u16 = guildMediaChannelFragmentBottomBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.ey_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442604a;
    }
}
