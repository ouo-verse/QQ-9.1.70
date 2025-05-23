package z12;

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
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.guild.widget.ScanningView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f451741a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451742b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GuildUserAvatarView f451743c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f451744d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451745e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final GuildAIOInputEditText f451746f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f451747g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f451748h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451749i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451750j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451751k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final FrameLayout f451752l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final FrameLayout f451753m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final ImageView f451754n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final LinearLayout f451755o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final ImageView f451756p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final TextView f451757q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final TextView f451758r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final ScanningView f451759s;

    e(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull GuildUserAvatarView guildUserAvatarView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout3, @NonNull GuildAIOInputEditText guildAIOInputEditText, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout7, @NonNull ImageView imageView4, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ScanningView scanningView) {
        this.f451741a = linearLayout;
        this.f451742b = linearLayout2;
        this.f451743c = guildUserAvatarView;
        this.f451744d = imageView;
        this.f451745e = linearLayout3;
        this.f451746f = guildAIOInputEditText;
        this.f451747g = imageView2;
        this.f451748h = textView;
        this.f451749i = linearLayout4;
        this.f451750j = linearLayout5;
        this.f451751k = linearLayout6;
        this.f451752l = frameLayout;
        this.f451753m = frameLayout2;
        this.f451754n = imageView3;
        this.f451755o = linearLayout7;
        this.f451756p = imageView4;
        this.f451757q = textView2;
        this.f451758r = textView3;
        this.f451759s = scanningView;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.sjm;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sjm);
        if (linearLayout != null) {
            i3 = R.id.vx5;
            GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) ViewBindings.findChildViewById(view, R.id.vx5);
            if (guildUserAvatarView != null) {
                i3 = R.id.vxa;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.vxa);
                if (imageView != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view;
                    i3 = R.id.vxk;
                    GuildAIOInputEditText guildAIOInputEditText = (GuildAIOInputEditText) ViewBindings.findChildViewById(view, R.id.vxk);
                    if (guildAIOInputEditText != null) {
                        i3 = R.id.vxz;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.vxz);
                        if (imageView2 != null) {
                            i3 = R.id.vyg;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vyg);
                            if (textView != null) {
                                i3 = R.id.vyo;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vyo);
                                if (linearLayout3 != null) {
                                    i3 = R.id.wjq;
                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wjq);
                                    if (linearLayout4 != null) {
                                        i3 = R.id.wjs;
                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wjs);
                                        if (linearLayout5 != null) {
                                            i3 = R.id.wmi;
                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wmi);
                                            if (frameLayout != null) {
                                                i3 = R.id.wmm;
                                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wmm);
                                                if (frameLayout2 != null) {
                                                    i3 = R.id.wmz;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.wmz);
                                                    if (imageView3 != null) {
                                                        i3 = R.id.wsg;
                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wsg);
                                                        if (linearLayout6 != null) {
                                                            i3 = R.id.f73093sm;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f73093sm);
                                                            if (imageView4 != null) {
                                                                i3 = R.id.f73253t2;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f73253t2);
                                                                if (textView2 != null) {
                                                                    i3 = R.id.f73333t_;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f73333t_);
                                                                    if (textView3 != null) {
                                                                        i3 = R.id.f79734_k;
                                                                        ScanningView scanningView = (ScanningView) ViewBindings.findChildViewById(view, R.id.f79734_k);
                                                                        if (scanningView != null) {
                                                                            return new e(linearLayout2, linearLayout, guildUserAvatarView, imageView, linearLayout2, guildAIOInputEditText, imageView2, textView, linearLayout3, linearLayout4, linearLayout5, frameLayout, frameLayout2, imageView3, linearLayout6, imageView4, textView2, textView3, scanningView);
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
    public static e g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ewi, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f451741a;
    }
}
