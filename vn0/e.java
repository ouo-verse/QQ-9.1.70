package vn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
/* loaded from: classes6.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f441931a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441932b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441933c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441934d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f441935e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f441936f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final GuildAIOInputEditText f441937g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f441938h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f441939i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f441940j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441941k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f441942l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441943m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f441944n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f441945o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f441946p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final QUIButton f441947q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441948r;

    e(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout2, @NonNull GuildAIOInputEditText guildAIOInputEditText, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout4, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout5, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull QUIButton qUIButton, @NonNull LinearLayout linearLayout6) {
        this.f441931a = frameLayout;
        this.f441932b = linearLayout;
        this.f441933c = linearLayout2;
        this.f441934d = linearLayout3;
        this.f441935e = constraintLayout;
        this.f441936f = frameLayout2;
        this.f441937g = guildAIOInputEditText;
        this.f441938h = relativeLayout;
        this.f441939i = relativeLayout2;
        this.f441940j = imageView;
        this.f441941k = linearLayout4;
        this.f441942l = imageView2;
        this.f441943m = linearLayout5;
        this.f441944n = textView;
        this.f441945o = textView2;
        this.f441946p = textView3;
        this.f441947q = qUIButton;
        this.f441948r = linearLayout6;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.sjm;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sjm);
        if (linearLayout != null) {
            i3 = R.id.f165423vx3;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165423vx3);
            if (linearLayout2 != null) {
                i3 = R.id.vxc;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vxc);
                if (linearLayout3 != null) {
                    i3 = R.id.vxi;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.vxi);
                    if (constraintLayout != null) {
                        FrameLayout frameLayout = (FrameLayout) view;
                        i3 = R.id.vxk;
                        GuildAIOInputEditText guildAIOInputEditText = (GuildAIOInputEditText) ViewBindings.findChildViewById(view, R.id.vxk);
                        if (guildAIOInputEditText != null) {
                            i3 = R.id.vxq;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.vxq);
                            if (relativeLayout != null) {
                                i3 = R.id.f165425vy0;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f165425vy0);
                                if (relativeLayout2 != null) {
                                    i3 = R.id.f165426vy1;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165426vy1);
                                    if (imageView != null) {
                                        i3 = R.id.f165427vy2;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165427vy2);
                                        if (linearLayout4 != null) {
                                            i3 = R.id.f165428vy3;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165428vy3);
                                            if (imageView2 != null) {
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
                                                                        return new e(frameLayout, linearLayout, linearLayout2, linearLayout3, constraintLayout, frameLayout, guildAIOInputEditText, relativeLayout, relativeLayout2, imageView, linearLayout4, imageView2, linearLayout5, textView, textView2, textView3, qUIButton, linearLayout6);
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
    public static e g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eek, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f441931a;
    }
}
