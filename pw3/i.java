package pw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final SwipeMenuLayout f427843a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final DefaultRecentAvatarView f427844b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f427845c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f427846d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final SwipeMenuLayout f427847e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f427848f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f427849g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final SummaryLayout f427850h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final SingleLineTextView f427851i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f427852j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f427853k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final RollingTextView f427854l;

    i(@NonNull SwipeMenuLayout swipeMenuLayout, @NonNull DefaultRecentAvatarView defaultRecentAvatarView, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull SwipeMenuLayout swipeMenuLayout2, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull SummaryLayout summaryLayout, @NonNull SingleLineTextView singleLineTextView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull RollingTextView rollingTextView) {
        this.f427843a = swipeMenuLayout;
        this.f427844b = defaultRecentAvatarView;
        this.f427845c = relativeLayout;
        this.f427846d = linearLayoutCompat;
        this.f427847e = swipeMenuLayout2;
        this.f427848f = imageView;
        this.f427849g = relativeLayout2;
        this.f427850h = summaryLayout;
        this.f427851i = singleLineTextView;
        this.f427852j = linearLayout;
        this.f427853k = imageView2;
        this.f427854l = rollingTextView;
    }

    @NonNull
    public static i e(@NonNull View view) {
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
                            i3 = R.id.j8_;
                            SummaryLayout summaryLayout = (SummaryLayout) ViewBindings.findChildViewById(view, R.id.j8_);
                            if (summaryLayout != null) {
                                i3 = R.id.title;
                                SingleLineTextView singleLineTextView = (SingleLineTextView) ViewBindings.findChildViewById(view, R.id.title);
                                if (singleLineTextView != null) {
                                    i3 = R.id.jp7;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jp7);
                                    if (linearLayout != null) {
                                        i3 = R.id.f98685nr;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f98685nr);
                                        if (imageView2 != null) {
                                            i3 = R.id.f114236ss;
                                            RollingTextView rollingTextView = (RollingTextView) ViewBindings.findChildViewById(view, R.id.f114236ss);
                                            if (rollingTextView != null) {
                                                return new i(swipeMenuLayout, defaultRecentAvatarView, relativeLayout, linearLayoutCompat, swipeMenuLayout, imageView, relativeLayout2, summaryLayout, singleLineTextView, linearLayout, imageView2, rollingTextView);
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
    public static i g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fhf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public SwipeMenuLayout getRoot() {
        return this.f427843a;
    }
}
