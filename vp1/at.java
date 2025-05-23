package vp1;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.views.AIReplyView;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.FadeFrameLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class at implements ViewBinding {

    @NonNull
    public final LinearLayout A;

    @NonNull
    public final TextView B;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442287a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442288b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442289c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442290d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442291e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final AIReplyView f442292f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FadeFrameLayout f442293g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442294h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442295i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442296j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f442297k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f442298l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final FrameLayout f442299m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final ImageView f442300n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final ImageView f442301o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f442302p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442303q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442304r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final AIReplyView f442305s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    public final ImageView f442306t;

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    public final ImageView f442307u;

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    public final ImageView f442308v;

    /* renamed from: w, reason: collision with root package name */
    @NonNull
    public final TextView f442309w;

    /* renamed from: x, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442310x;

    /* renamed from: y, reason: collision with root package name */
    @NonNull
    public final ImageView f442311y;

    /* renamed from: z, reason: collision with root package name */
    @NonNull
    public final TextView f442312z;

    at(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull AIReplyView aIReplyView, @NonNull FadeFrameLayout fadeFrameLayout, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull View view, @NonNull TextView textView3, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView4, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull AIReplyView aIReplyView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull TextView textView5, @NonNull LinearLayout linearLayout6, @NonNull ImageView imageView6, @NonNull TextView textView6, @NonNull LinearLayout linearLayout7, @NonNull TextView textView7) {
        this.f442287a = constraintLayout;
        this.f442288b = constraintLayout2;
        this.f442289c = constraintLayout3;
        this.f442290d = linearLayout;
        this.f442291e = textView;
        this.f442292f = aIReplyView;
        this.f442293g = fadeFrameLayout;
        this.f442294h = textView2;
        this.f442295i = linearLayout2;
        this.f442296j = linearLayout3;
        this.f442297k = view;
        this.f442298l = textView3;
        this.f442299m = frameLayout;
        this.f442300n = imageView;
        this.f442301o = imageView2;
        this.f442302p = textView4;
        this.f442303q = linearLayout4;
        this.f442304r = linearLayout5;
        this.f442305s = aIReplyView2;
        this.f442306t = imageView3;
        this.f442307u = imageView4;
        this.f442308v = imageView5;
        this.f442309w = textView5;
        this.f442310x = linearLayout6;
        this.f442311y = imageView6;
        this.f442312z = textView6;
        this.A = linearLayout7;
        this.B = textView7;
    }

    @NonNull
    public static at e(@NonNull View view) {
        int i3 = R.id.sfv;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.sfv);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
            i3 = R.id.acy;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.acy);
            if (linearLayout != null) {
                i3 = R.id.tay;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tay);
                if (textView != null) {
                    i3 = R.id.content;
                    AIReplyView aIReplyView = (AIReplyView) ViewBindings.findChildViewById(view, R.id.content);
                    if (aIReplyView != null) {
                        i3 = R.id.leh;
                        FadeFrameLayout fadeFrameLayout = (FadeFrameLayout) ViewBindings.findChildViewById(view, R.id.leh);
                        if (fadeFrameLayout != null) {
                            i3 = R.id.uww;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.uww);
                            if (textView2 != null) {
                                i3 = R.id.byk;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.byk);
                                if (linearLayout2 != null) {
                                    i3 = R.id.bzj;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.bzj);
                                    if (linearLayout3 != null) {
                                        i3 = R.id.uy_;
                                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.uy_);
                                        if (findChildViewById != null) {
                                            i3 = R.id.uyc;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.uyc);
                                            if (textView3 != null) {
                                                i3 = R.id.v4b;
                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.v4b);
                                                if (frameLayout != null) {
                                                    i3 = R.id.ysu;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ysu);
                                                    if (imageView != null) {
                                                        i3 = R.id.efg;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.efg);
                                                        if (imageView2 != null) {
                                                            i3 = R.id.yt8;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.yt8);
                                                            if (textView4 != null) {
                                                                i3 = R.id.efs;
                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.efs);
                                                                if (linearLayout4 != null) {
                                                                    i3 = R.id.f166295zc0;
                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f166295zc0);
                                                                    if (linearLayout5 != null) {
                                                                        i3 = R.id.f70693m5;
                                                                        AIReplyView aIReplyView2 = (AIReplyView) ViewBindings.findChildViewById(view, R.id.f70693m5);
                                                                        if (aIReplyView2 != null) {
                                                                            i3 = R.id.i9b;
                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.i9b);
                                                                            if (imageView3 != null) {
                                                                                i3 = R.id.f96385hj;
                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f96385hj);
                                                                                if (imageView4 != null) {
                                                                                    i3 = R.id.f96395hk;
                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f96395hk);
                                                                                    if (imageView5 != null) {
                                                                                        i3 = R.id.f96405hl;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f96405hl);
                                                                                        if (textView5 != null) {
                                                                                            i3 = R.id.f96415hm;
                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f96415hm);
                                                                                            if (linearLayout6 != null) {
                                                                                                i3 = R.id.f96425hn;
                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.f96425hn);
                                                                                                if (imageView6 != null) {
                                                                                                    i3 = R.id.title;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                                                                                    if (textView6 != null) {
                                                                                                        i3 = R.id.jp7;
                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jp7);
                                                                                                        if (linearLayout7 != null) {
                                                                                                            i3 = R.id.f1059167a;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.f1059167a);
                                                                                                            if (textView7 != null) {
                                                                                                                return new at(constraintLayout2, constraintLayout, constraintLayout2, linearLayout, textView, aIReplyView, fadeFrameLayout, textView2, linearLayout2, linearLayout3, findChildViewById, textView3, frameLayout, imageView, imageView2, textView4, linearLayout4, linearLayout5, aIReplyView2, imageView3, imageView4, imageView5, textView5, linearLayout6, imageView6, textView6, linearLayout7, textView7);
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

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442287a;
    }
}
