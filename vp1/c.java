package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442647a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442648b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442649c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ai f442650d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442651e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442652f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final GuildAIOInputEditText f442653g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442654h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442655i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442656j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442657k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f442658l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f442659m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f442660n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final QUIButton f442661o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442662p;

    c(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ai aiVar, @NonNull LinearLayout linearLayout3, @NonNull ConstraintLayout constraintLayout, @NonNull GuildAIOInputEditText guildAIOInputEditText, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout4, @NonNull FrameLayout frameLayout2, @NonNull LinearLayout linearLayout5, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull QUIButton qUIButton, @NonNull LinearLayout linearLayout6) {
        this.f442647a = frameLayout;
        this.f442648b = linearLayout;
        this.f442649c = linearLayout2;
        this.f442650d = aiVar;
        this.f442651e = linearLayout3;
        this.f442652f = constraintLayout;
        this.f442653g = guildAIOInputEditText;
        this.f442654h = relativeLayout;
        this.f442655i = linearLayout4;
        this.f442656j = frameLayout2;
        this.f442657k = linearLayout5;
        this.f442658l = textView;
        this.f442659m = textView2;
        this.f442660n = textView3;
        this.f442661o = qUIButton;
        this.f442662p = linearLayout6;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.sjm;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sjm);
        if (linearLayout != null) {
            i3 = R.id.f165423vx3;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165423vx3);
            if (linearLayout2 != null) {
                i3 = R.id.vx8;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.vx8);
                if (findChildViewById != null) {
                    ai e16 = ai.e(findChildViewById);
                    i3 = R.id.vxc;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vxc);
                    if (linearLayout3 != null) {
                        i3 = R.id.vxi;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.vxi);
                        if (constraintLayout != null) {
                            i3 = R.id.vxk;
                            GuildAIOInputEditText guildAIOInputEditText = (GuildAIOInputEditText) ViewBindings.findChildViewById(view, R.id.vxk);
                            if (guildAIOInputEditText != null) {
                                i3 = R.id.vxq;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.vxq);
                                if (relativeLayout != null) {
                                    i3 = R.id.f165427vy2;
                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165427vy2);
                                    if (linearLayout4 != null) {
                                        i3 = R.id.f165429vy4;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f165429vy4);
                                        if (frameLayout != null) {
                                            i3 = R.id.vyc;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vyc);
                                            if (linearLayout5 != null) {
                                                i3 = R.id.vyd;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vyd);
                                                if (textView != null) {
                                                    i3 = R.id.vye;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.vye);
                                                    if (textView2 != null) {
                                                        i3 = R.id.vyf;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.vyf);
                                                        if (textView3 != null) {
                                                            i3 = R.id.vyg;
                                                            QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.vyg);
                                                            if (qUIButton != null) {
                                                                i3 = R.id.vyo;
                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vyo);
                                                                if (linearLayout6 != null) {
                                                                    return new c((FrameLayout) view, linearLayout, linearLayout2, e16, linearLayout3, constraintLayout, guildAIOInputEditText, relativeLayout, linearLayout4, frameLayout, linearLayout5, textView, textView2, textView3, qUIButton, linearLayout6);
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
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eea, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442647a;
    }
}
