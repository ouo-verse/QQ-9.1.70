package vn0;

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
/* loaded from: classes6.dex */
public final class o implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f441984a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441985b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441986c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f441987d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f441988e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final GuildAIOInputEditText f441989f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f441990g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f441991h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f441992i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f441993j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final QUIButton f441994k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f441995l;

    o(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout2, @NonNull GuildAIOInputEditText guildAIOInputEditText, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull QUIButton qUIButton, @NonNull LinearLayout linearLayout3) {
        this.f441984a = frameLayout;
        this.f441985b = linearLayout;
        this.f441986c = linearLayout2;
        this.f441987d = constraintLayout;
        this.f441988e = frameLayout2;
        this.f441989f = guildAIOInputEditText;
        this.f441990g = relativeLayout;
        this.f441991h = textView;
        this.f441992i = textView2;
        this.f441993j = textView3;
        this.f441994k = qUIButton;
        this.f441995l = linearLayout3;
    }

    @NonNull
    public static o e(@NonNull View view) {
        int i3 = R.id.sjm;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sjm);
        if (linearLayout != null) {
            i3 = R.id.vxc;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vxc);
            if (linearLayout2 != null) {
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
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vyo);
                                            if (linearLayout3 != null) {
                                                return new o(frameLayout, linearLayout, linearLayout2, constraintLayout, frameLayout, guildAIOInputEditText, relativeLayout, textView, textView2, textView3, qUIButton, linearLayout3);
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
    public static o g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168033eg0, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f441984a;
    }
}
