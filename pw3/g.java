package pw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.qqnt.chats.view.widget.DefaultRecentAvatarView;
import com.tencent.qqnt.chats.view.widget.SummaryLayout;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.widget.SwipeMenuLayout;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final SwipeMenuLayout f427825a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final DefaultRecentAvatarView f427826b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f427827c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f427828d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final SwipeMenuLayout f427829e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f427830f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f427831g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f427832h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final SummaryLayout f427833i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final SingleLineTextView f427834j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final RollingTextView f427835k;

    g(@NonNull SwipeMenuLayout swipeMenuLayout, @NonNull DefaultRecentAvatarView defaultRecentAvatarView, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull SwipeMenuLayout swipeMenuLayout2, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView2, @NonNull SummaryLayout summaryLayout, @NonNull SingleLineTextView singleLineTextView, @NonNull RollingTextView rollingTextView) {
        this.f427825a = swipeMenuLayout;
        this.f427826b = defaultRecentAvatarView;
        this.f427827c = relativeLayout;
        this.f427828d = linearLayoutCompat;
        this.f427829e = swipeMenuLayout2;
        this.f427830f = imageView;
        this.f427831g = relativeLayout2;
        this.f427832h = imageView2;
        this.f427833i = summaryLayout;
        this.f427834j = singleLineTextView;
        this.f427835k = rollingTextView;
    }

    @NonNull
    public static g e(@NonNull View view) {
        int i3 = R.id.a2o;
        DefaultRecentAvatarView defaultRecentAvatarView = (DefaultRecentAvatarView) ViewBindings.findChildViewById(view, R.id.a2o);
        if (defaultRecentAvatarView != null) {
            i3 = R.id.aua;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.aua);
            if (relativeLayout != null) {
                i3 = R.id.ttm;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, R.id.ttm);
                if (linearLayoutCompat != null) {
                    SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) view;
                    i3 = R.id.f165003uk2;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165003uk2);
                    if (imageView != null) {
                        i3 = R.id.iag;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.iag);
                        if (relativeLayout2 != null) {
                            i3 = R.id.f82614hc;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f82614hc);
                            if (imageView2 != null) {
                                i3 = R.id.j8_;
                                SummaryLayout summaryLayout = (SummaryLayout) ViewBindings.findChildViewById(view, R.id.j8_);
                                if (summaryLayout != null) {
                                    i3 = R.id.title;
                                    SingleLineTextView singleLineTextView = (SingleLineTextView) ViewBindings.findChildViewById(view, R.id.title);
                                    if (singleLineTextView != null) {
                                        i3 = R.id.f114236ss;
                                        RollingTextView rollingTextView = (RollingTextView) ViewBindings.findChildViewById(view, R.id.f114236ss);
                                        if (rollingTextView != null) {
                                            return new g(swipeMenuLayout, defaultRecentAvatarView, relativeLayout, linearLayoutCompat, swipeMenuLayout, imageView, relativeLayout2, imageView2, summaryLayout, singleLineTextView, rollingTextView);
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
    public static g g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fhd, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public SwipeMenuLayout getRoot() {
        return this.f427825a;
    }
}
