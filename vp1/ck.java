package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.FeedBackItemView;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ck implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442717a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442718b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FeedBackItemView f442719c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FeedBackItemView f442720d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FeedBackItemView f442721e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FeedBackItemView f442722f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442723g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ShadowFrameLayout f442724h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final QUIButton f442725i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f442726j;

    ck(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull FeedBackItemView feedBackItemView, @NonNull FeedBackItemView feedBackItemView2, @NonNull FeedBackItemView feedBackItemView3, @NonNull FeedBackItemView feedBackItemView4, @NonNull ConstraintLayout constraintLayout2, @NonNull ShadowFrameLayout shadowFrameLayout, @NonNull QUIButton qUIButton, @NonNull View view) {
        this.f442717a = constraintLayout;
        this.f442718b = textView;
        this.f442719c = feedBackItemView;
        this.f442720d = feedBackItemView2;
        this.f442721e = feedBackItemView3;
        this.f442722f = feedBackItemView4;
        this.f442723g = constraintLayout2;
        this.f442724h = shadowFrameLayout;
        this.f442725i = qUIButton;
        this.f442726j = view;
    }

    @NonNull
    public static ck e(@NonNull View view) {
        int i3 = R.id.v4d;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.v4d);
        if (textView != null) {
            i3 = R.id.xsg;
            FeedBackItemView feedBackItemView = (FeedBackItemView) ViewBindings.findChildViewById(view, R.id.xsg);
            if (feedBackItemView != null) {
                i3 = R.id.xsh;
                FeedBackItemView feedBackItemView2 = (FeedBackItemView) ViewBindings.findChildViewById(view, R.id.xsh);
                if (feedBackItemView2 != null) {
                    i3 = R.id.xsi;
                    FeedBackItemView feedBackItemView3 = (FeedBackItemView) ViewBindings.findChildViewById(view, R.id.xsi);
                    if (feedBackItemView3 != null) {
                        i3 = R.id.xsj;
                        FeedBackItemView feedBackItemView4 = (FeedBackItemView) ViewBindings.findChildViewById(view, R.id.xsj);
                        if (feedBackItemView4 != null) {
                            i3 = R.id.f212900m;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.f212900m);
                            if (constraintLayout != null) {
                                i3 = R.id.f84074l_;
                                ShadowFrameLayout shadowFrameLayout = (ShadowFrameLayout) ViewBindings.findChildViewById(view, R.id.f84074l_);
                                if (shadowFrameLayout != null) {
                                    i3 = R.id.j6p;
                                    QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.j6p);
                                    if (qUIButton != null) {
                                        i3 = R.id.f167009jw1;
                                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f167009jw1);
                                        if (findChildViewById != null) {
                                            return new ck((ConstraintLayout) view, textView, feedBackItemView, feedBackItemView2, feedBackItemView3, feedBackItemView4, constraintLayout, shadowFrameLayout, qUIButton, findChildViewById);
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
    public static ck g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f1a, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442717a;
    }
}
