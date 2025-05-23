package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.PttAudioWaveView;
import com.tx.x2j.AioPttContentBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f444824a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f444825b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final PttAudioWaveView f444826c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444827d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f444828e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f444829f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f444830g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f444831h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f444832i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444833j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f444834k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ViewStub f444835l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final ImageView f444836m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final LinearLayout f444837n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f444838o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final ImageView f444839p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final ImageView f444840q;

    k(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull PttAudioWaveView pttAudioWaveView, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView6, @NonNull ViewStub viewStub, @NonNull ImageView imageView7, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull ImageView imageView8, @NonNull ImageView imageView9) {
        this.f444824a = constraintLayout;
        this.f444825b = imageView;
        this.f444826c = pttAudioWaveView;
        this.f444827d = relativeLayout;
        this.f444828e = textView;
        this.f444829f = imageView2;
        this.f444830g = imageView3;
        this.f444831h = imageView4;
        this.f444832i = imageView5;
        this.f444833j = relativeLayout2;
        this.f444834k = imageView6;
        this.f444835l = viewStub;
        this.f444836m = imageView7;
        this.f444837n = linearLayout;
        this.f444838o = textView2;
        this.f444839p = imageView8;
        this.f444840q = imageView9;
    }

    @NonNull
    public static k e(@NonNull View view) {
        int i3 = R.id.uzh;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.uzh);
        if (imageView != null) {
            i3 = R.id.f28750js;
            PttAudioWaveView pttAudioWaveView = (PttAudioWaveView) ViewBindings.findChildViewById(view, R.id.f28750js);
            if (pttAudioWaveView != null) {
                i3 = R.id.f28770ju;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f28770ju);
                if (relativeLayout != null) {
                    i3 = R.id.f28780jv;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f28780jv);
                    if (textView != null) {
                        i3 = R.id.f28790jw;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f28790jw);
                        if (imageView2 != null) {
                            i3 = R.id.f28800jx;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f28800jx);
                            if (imageView3 != null) {
                                i3 = R.id.f28810jy;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f28810jy);
                                if (imageView4 != null) {
                                    i3 = R.id.f28820jz;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f28820jz);
                                    if (imageView5 != null) {
                                        i3 = R.id.f28830k0;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f28830k0);
                                        if (relativeLayout2 != null) {
                                            i3 = R.id.f28870k4;
                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.f28870k4);
                                            if (imageView6 != null) {
                                                i3 = R.id.f28890k6;
                                                ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.f28890k6);
                                                if (viewStub != null) {
                                                    i3 = R.id.f28900k7;
                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.f28900k7);
                                                    if (imageView7 != null) {
                                                        i3 = R.id.f28910k8;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f28910k8);
                                                        if (linearLayout != null) {
                                                            i3 = R.id.f28920k9;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f28920k9);
                                                            if (textView2 != null) {
                                                                i3 = R.id.f28930k_;
                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R.id.f28930k_);
                                                                if (imageView8 != null) {
                                                                    i3 = R.id.f28940ka;
                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, R.id.f28940ka);
                                                                    if (imageView9 != null) {
                                                                        return new k((ConstraintLayout) view, imageView, pttAudioWaveView, relativeLayout, textView, imageView2, imageView3, imageView4, imageView5, relativeLayout2, imageView6, viewStub, imageView7, linearLayout, textView2, imageView8, imageView9);
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
    public static k g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioPttContentBinding aioPttContentBinding = new AioPttContentBinding();
        aioPttContentBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioPttContentBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.f167619dw4, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f444824a;
    }
}
