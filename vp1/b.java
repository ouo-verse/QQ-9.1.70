package vp1;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.views.AIReplyView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442365a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442366b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final AIReplyView f442367c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442368d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442369e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442370f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442371g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442372h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442373i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final AIReplyView f442374j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f442375k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f442376l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final ImageView f442377m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f442378n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442379o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final ImageView f442380p;

    b(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull AIReplyView aIReplyView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull AIReplyView aIReplyView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull TextView textView3, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView6) {
        this.f442365a = constraintLayout;
        this.f442366b = constraintLayout2;
        this.f442367c = aIReplyView;
        this.f442368d = textView;
        this.f442369e = linearLayout;
        this.f442370f = imageView;
        this.f442371g = imageView2;
        this.f442372h = textView2;
        this.f442373i = linearLayout2;
        this.f442374j = aIReplyView2;
        this.f442375k = imageView3;
        this.f442376l = imageView4;
        this.f442377m = imageView5;
        this.f442378n = textView3;
        this.f442379o = linearLayout3;
        this.f442380p = imageView6;
    }

    @NonNull
    public static b e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i3 = R.id.content;
        AIReplyView aIReplyView = (AIReplyView) ViewBindings.findChildViewById(view, R.id.content);
        if (aIReplyView != null) {
            i3 = R.id.uww;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.uww);
            if (textView != null) {
                i3 = R.id.byk;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.byk);
                if (linearLayout != null) {
                    i3 = R.id.ysu;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ysu);
                    if (imageView != null) {
                        i3 = R.id.ysy;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ysy);
                        if (imageView2 != null) {
                            i3 = R.id.yt8;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.yt8);
                            if (textView2 != null) {
                                i3 = R.id.efs;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.efs);
                                if (linearLayout2 != null) {
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
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f96405hl);
                                                    if (textView3 != null) {
                                                        i3 = R.id.f96415hm;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f96415hm);
                                                        if (linearLayout3 != null) {
                                                            i3 = R.id.f96425hn;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.f96425hn);
                                                            if (imageView6 != null) {
                                                                return new b(constraintLayout, constraintLayout, aIReplyView, textView, linearLayout, imageView, imageView2, textView2, linearLayout2, aIReplyView2, imageView3, imageView4, imageView5, textView3, linearLayout3, imageView6);
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
        return this.f442365a;
    }
}
