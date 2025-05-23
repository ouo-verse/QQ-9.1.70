package ts2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView;
import com.tx.x2j.QbGroupNotificationDetailDefaultLayoutBinding;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class c implements ViewBinding {

    @NonNull
    public final LinearLayout A;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ScrollView f437336a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f437337b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f437338c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUIButton f437339d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f437340e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f437341f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final QQProAvatarView f437342g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f437343h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437344i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final QUIButton f437345j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ViewStub f437346k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437347l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TroopNotificationRichTextView f437348m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f437349n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final View f437350o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437351p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final QUIButton f437352q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437353r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final TextView f437354s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437355t;

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    public final TextView f437356u;

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437357v;

    /* renamed from: w, reason: collision with root package name */
    @NonNull
    public final TroopNotificationRichTextView f437358w;

    /* renamed from: x, reason: collision with root package name */
    @NonNull
    public final TextView f437359x;

    /* renamed from: y, reason: collision with root package name */
    @NonNull
    public final TextView f437360y;

    /* renamed from: z, reason: collision with root package name */
    @NonNull
    public final TextView f437361z;

    c(@NonNull ScrollView scrollView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull QUIButton qUIButton, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull QQProAvatarView qQProAvatarView, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull QUIButton qUIButton2, @NonNull ViewStub viewStub, @NonNull LinearLayout linearLayout2, @NonNull TroopNotificationRichTextView troopNotificationRichTextView, @NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull LinearLayout linearLayout3, @NonNull QUIButton qUIButton3, @NonNull LinearLayout linearLayout4, @NonNull TextView textView4, @NonNull LinearLayout linearLayout5, @NonNull TextView textView5, @NonNull LinearLayout linearLayout6, @NonNull TroopNotificationRichTextView troopNotificationRichTextView2, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull LinearLayout linearLayout7) {
        this.f437336a = scrollView;
        this.f437337b = imageView;
        this.f437338c = textView;
        this.f437339d = qUIButton;
        this.f437340e = textView2;
        this.f437341f = imageView2;
        this.f437342g = qQProAvatarView;
        this.f437343h = textView3;
        this.f437344i = linearLayout;
        this.f437345j = qUIButton2;
        this.f437346k = viewStub;
        this.f437347l = linearLayout2;
        this.f437348m = troopNotificationRichTextView;
        this.f437349n = relativeLayout;
        this.f437350o = view;
        this.f437351p = linearLayout3;
        this.f437352q = qUIButton3;
        this.f437353r = linearLayout4;
        this.f437354s = textView4;
        this.f437355t = linearLayout5;
        this.f437356u = textView5;
        this.f437357v = linearLayout6;
        this.f437358w = troopNotificationRichTextView2;
        this.f437359x = textView6;
        this.f437360y = textView7;
        this.f437361z = textView8;
        this.A = linearLayout7;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.f767642j;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f767642j);
        if (imageView != null) {
            i3 = R.id.f102355xo;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f102355xo);
            if (textView != null) {
                i3 = R.id.f103015zg;
                QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.f103015zg);
                if (qUIButton != null) {
                    i3 = R.id.f103025zh;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f103025zh);
                    if (textView2 != null) {
                        i3 = R.id.f103065zl;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f103065zl);
                        if (imageView2 != null) {
                            i3 = R.id.f103075zm;
                            QQProAvatarView qQProAvatarView = (QQProAvatarView) ViewBindings.findChildViewById(view, R.id.f103075zm);
                            if (qQProAvatarView != null) {
                                i3 = R.id.f103085zn;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f103085zn);
                                if (textView3 != null) {
                                    i3 = R.id.f103095zo;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f103095zo);
                                    if (linearLayout != null) {
                                        i3 = R.id.f103105zp;
                                        QUIButton qUIButton2 = (QUIButton) ViewBindings.findChildViewById(view, R.id.f103105zp);
                                        if (qUIButton2 != null) {
                                            i3 = R.id.f103135zs;
                                            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.f103135zs);
                                            if (viewStub != null) {
                                                i3 = R.id.f103155zu;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f103155zu);
                                                if (linearLayout2 != null) {
                                                    i3 = R.id.f103205zz;
                                                    TroopNotificationRichTextView troopNotificationRichTextView = (TroopNotificationRichTextView) ViewBindings.findChildViewById(view, R.id.f103205zz);
                                                    if (troopNotificationRichTextView != null) {
                                                        i3 = R.id.f10324603;
                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f10324603);
                                                        if (relativeLayout != null) {
                                                            i3 = R.id.f10325604;
                                                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f10325604);
                                                            if (findChildViewById != null) {
                                                                i3 = R.id.f10326605;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f10326605);
                                                                if (linearLayout3 != null) {
                                                                    i3 = R.id.f10328607;
                                                                    QUIButton qUIButton3 = (QUIButton) ViewBindings.findChildViewById(view, R.id.f10328607);
                                                                    if (qUIButton3 != null) {
                                                                        i3 = R.id.f1033160_;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f1033160_);
                                                                        if (linearLayout4 != null) {
                                                                            i3 = R.id.f1033260a;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f1033260a);
                                                                            if (textView4 != null) {
                                                                                i3 = R.id.f1033360b;
                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f1033360b);
                                                                                if (linearLayout5 != null) {
                                                                                    i3 = R.id.f1033460c;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f1033460c);
                                                                                    if (textView5 != null) {
                                                                                        i3 = R.id.f1033660e;
                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f1033660e);
                                                                                        if (linearLayout6 != null) {
                                                                                            i3 = R.id.f1033760f;
                                                                                            TroopNotificationRichTextView troopNotificationRichTextView2 = (TroopNotificationRichTextView) ViewBindings.findChildViewById(view, R.id.f1033760f);
                                                                                            if (troopNotificationRichTextView2 != null) {
                                                                                                i3 = R.id.f1033860g;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.f1033860g);
                                                                                                if (textView6 != null) {
                                                                                                    i3 = R.id.f1033960h;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.f1033960h);
                                                                                                    if (textView7 != null) {
                                                                                                        i3 = R.id.f1034060i;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.f1034060i);
                                                                                                        if (textView8 != null) {
                                                                                                            i3 = R.id.f1034160j;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f1034160j);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                return new c((ScrollView) view, imageView, textView, qUIButton, textView2, imageView2, qQProAvatarView, textView3, linearLayout, qUIButton2, viewStub, linearLayout2, troopNotificationRichTextView, relativeLayout, findChildViewById, linearLayout3, qUIButton3, linearLayout4, textView4, linearLayout5, textView5, linearLayout6, troopNotificationRichTextView2, textView6, textView7, textView8, linearLayout7);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static c g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static c h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        QbGroupNotificationDetailDefaultLayoutBinding qbGroupNotificationDetailDefaultLayoutBinding = new QbGroupNotificationDetailDefaultLayoutBinding();
        qbGroupNotificationDetailDefaultLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = qbGroupNotificationDetailDefaultLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.fvb, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ScrollView getMRv() {
        return this.f437336a;
    }
}
