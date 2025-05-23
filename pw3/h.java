package pw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;
import com.tencent.widget.FadeIconImageView;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f427836a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SkinnableRecycleView f427837b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FadeIconImageView f427838c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUIBadgeDragLayout f427839d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f427840e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final SmartRefreshLayout f427841f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f427842g;

    h(@NonNull LinearLayout linearLayout, @NonNull SkinnableRecycleView skinnableRecycleView, @NonNull FadeIconImageView fadeIconImageView, @NonNull QUIBadgeDragLayout qUIBadgeDragLayout, @NonNull RelativeLayout relativeLayout, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull TextView textView) {
        this.f427836a = linearLayout;
        this.f427837b = skinnableRecycleView;
        this.f427838c = fadeIconImageView;
        this.f427839d = qUIBadgeDragLayout;
        this.f427840e = relativeLayout;
        this.f427841f = smartRefreshLayout;
        this.f427842g = textView;
    }

    @NonNull
    public static h e(@NonNull View view) {
        int i3 = R.id.tug;
        SkinnableRecycleView skinnableRecycleView = (SkinnableRecycleView) ViewBindings.findChildViewById(view, R.id.tug);
        if (skinnableRecycleView != null) {
            i3 = R.id.bf5;
            FadeIconImageView fadeIconImageView = (FadeIconImageView) ViewBindings.findChildViewById(view, R.id.bf5);
            if (fadeIconImageView != null) {
                i3 = R.id.evx;
                QUIBadgeDragLayout qUIBadgeDragLayout = (QUIBadgeDragLayout) ViewBindings.findChildViewById(view, R.id.evx);
                if (qUIBadgeDragLayout != null) {
                    i3 = R.id.d4l;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.d4l);
                    if (relativeLayout != null) {
                        i3 = R.id.f72183q6;
                        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, R.id.f72183q6);
                        if (smartRefreshLayout != null) {
                            i3 = R.id.js6;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.js6);
                            if (textView != null) {
                                return new h((LinearLayout) view, skinnableRecycleView, fadeIconImageView, qUIBadgeDragLayout, relativeLayout, smartRefreshLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static h g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static h h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fhe, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f427836a;
    }
}
