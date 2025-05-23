package td1;

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
/* loaded from: classes12.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f435862a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f435863b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f435864c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final GuildAIOInputEditText f435865d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f435866e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f435867f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f435868g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f435869h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f435870i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final QUIButton f435871j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f435872k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final QUIButton f435873l;

    a(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout, @NonNull GuildAIOInputEditText guildAIOInputEditText, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull QUIButton qUIButton, @NonNull LinearLayout linearLayout3, @NonNull QUIButton qUIButton2) {
        this.f435862a = frameLayout;
        this.f435863b = linearLayout;
        this.f435864c = constraintLayout;
        this.f435865d = guildAIOInputEditText;
        this.f435866e = relativeLayout;
        this.f435867f = linearLayout2;
        this.f435868g = textView;
        this.f435869h = textView2;
        this.f435870i = textView3;
        this.f435871j = qUIButton;
        this.f435872k = linearLayout3;
        this.f435873l = qUIButton2;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.sjm;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sjm);
        if (linearLayout != null) {
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
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165427vy2);
                        if (linearLayout2 != null) {
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
                                                i3 = R.id.f29770mj;
                                                QUIButton qUIButton2 = (QUIButton) ViewBindings.findChildViewById(view, R.id.f29770mj);
                                                if (qUIButton2 != null) {
                                                    return new a((FrameLayout) view, linearLayout, constraintLayout, guildAIOInputEditText, relativeLayout, linearLayout2, textView, textView2, textView3, qUIButton, linearLayout3, qUIButton2);
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
        View inflate = layoutInflater.inflate(R.layout.eby, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f435862a;
    }
}
