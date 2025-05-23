package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.widget.AIOTitleRelativeLayout;
import com.tencent.mobileqq.aio.widget.CommonTextView;
import com.tencent.mobileqq.aio.widget.QUIBadgeMosaic;
import com.tencent.mobileqq.aio.widget.RedDotImageView;
import com.tx.x2j.AioTitleBarLayoutBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class t implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f444900a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewStub f444901b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewStub f444902c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f444903d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ViewStub f444904e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f444905f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ViewStub f444906g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RedDotImageView f444907h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RedDotImageView f444908i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f444909j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444910k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final AIOTitleRelativeLayout f444911l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final ViewStub f444912m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final CommonTextView f444913n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final CommonTextView f444914o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final ViewStub f444915p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final QUIBadgeMosaic f444916q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final View f444917r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final ViewStub f444918s;

    t(@NonNull RelativeLayout relativeLayout, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull ImageView imageView, @NonNull ViewStub viewStub3, @NonNull TextView textView, @NonNull ViewStub viewStub4, @NonNull RedDotImageView redDotImageView, @NonNull RedDotImageView redDotImageView2, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull AIOTitleRelativeLayout aIOTitleRelativeLayout, @NonNull ViewStub viewStub5, @NonNull CommonTextView commonTextView, @NonNull CommonTextView commonTextView2, @NonNull ViewStub viewStub6, @NonNull QUIBadgeMosaic qUIBadgeMosaic, @NonNull View view, @NonNull ViewStub viewStub7) {
        this.f444900a = relativeLayout;
        this.f444901b = viewStub;
        this.f444902c = viewStub2;
        this.f444903d = imageView;
        this.f444904e = viewStub3;
        this.f444905f = textView;
        this.f444906g = viewStub4;
        this.f444907h = redDotImageView;
        this.f444908i = redDotImageView2;
        this.f444909j = imageView2;
        this.f444910k = relativeLayout2;
        this.f444911l = aIOTitleRelativeLayout;
        this.f444912m = viewStub5;
        this.f444913n = commonTextView;
        this.f444914o = commonTextView2;
        this.f444915p = viewStub6;
        this.f444916q = qUIBadgeMosaic;
        this.f444917r = view;
        this.f444918s = viewStub7;
    }

    @NonNull
    public static t e(@NonNull View view) {
        int i3 = R.id.tqe;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.tqe);
        if (viewStub != null) {
            i3 = R.id.tqf;
            ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.tqf);
            if (viewStub2 != null) {
                i3 = R.id.uj_;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.uj_);
                if (imageView != null) {
                    i3 = R.id.up5;
                    ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, R.id.up5);
                    if (viewStub3 != null) {
                        i3 = R.id.ivTitleBtnLeft;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ivTitleBtnLeft);
                        if (textView != null) {
                            i3 = R.id.yhl;
                            ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, R.id.yhl);
                            if (viewStub4 != null) {
                                i3 = R.id.f74333vz;
                                RedDotImageView redDotImageView = (RedDotImageView) ViewBindings.findChildViewById(view, R.id.f74333vz);
                                if (redDotImageView != null) {
                                    i3 = R.id.f74343w0;
                                    RedDotImageView redDotImageView2 = (RedDotImageView) ViewBindings.findChildViewById(view, R.id.f74343w0);
                                    if (redDotImageView2 != null) {
                                        i3 = R.id.f9032526;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f9032526);
                                        if (imageView2 != null) {
                                            RelativeLayout relativeLayout = (RelativeLayout) view;
                                            i3 = R.id.f98705nt;
                                            AIOTitleRelativeLayout aIOTitleRelativeLayout = (AIOTitleRelativeLayout) ViewBindings.findChildViewById(view, R.id.f98705nt);
                                            if (aIOTitleRelativeLayout != null) {
                                                i3 = R.id.f98855o8;
                                                ViewStub viewStub5 = (ViewStub) ViewBindings.findChildViewById(view, R.id.f98855o8);
                                                if (viewStub5 != null) {
                                                    i3 = R.id.f98155mb;
                                                    CommonTextView commonTextView = (CommonTextView) ViewBindings.findChildViewById(view, R.id.f98155mb);
                                                    if (commonTextView != null) {
                                                        i3 = R.id.f98175md;
                                                        CommonTextView commonTextView2 = (CommonTextView) ViewBindings.findChildViewById(view, R.id.f98175md);
                                                        if (commonTextView2 != null) {
                                                            i3 = R.id.f10366618;
                                                            ViewStub viewStub6 = (ViewStub) ViewBindings.findChildViewById(view, R.id.f10366618);
                                                            if (viewStub6 != null) {
                                                                i3 = R.id.f114256su;
                                                                QUIBadgeMosaic qUIBadgeMosaic = (QUIBadgeMosaic) ViewBindings.findChildViewById(view, R.id.f114256su);
                                                                if (qUIBadgeMosaic != null) {
                                                                    i3 = R.id.f1198177v;
                                                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.f1198177v);
                                                                    if (findChildViewById != null) {
                                                                        i3 = R.id.f1198377x;
                                                                        ViewStub viewStub7 = (ViewStub) ViewBindings.findChildViewById(view, R.id.f1198377x);
                                                                        if (viewStub7 != null) {
                                                                            return new t(relativeLayout, viewStub, viewStub2, imageView, viewStub3, textView, viewStub4, redDotImageView, redDotImageView2, imageView2, relativeLayout, aIOTitleRelativeLayout, viewStub5, commonTextView, commonTextView2, viewStub6, qUIBadgeMosaic, findChildViewById, viewStub7);
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
    public static t g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioTitleBarLayoutBinding aioTitleBarLayoutBinding = new AioTitleBarLayoutBinding();
        aioTitleBarLayoutBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioTitleBarLayoutBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dwn, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f444900a;
    }
}
