package pw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.chats.view.widget.RecentAvatarViewWrapper;
import com.tencent.qqnt.chats.view.widget.RoundFrameLayout;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f427803a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f427804b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecentAvatarViewWrapper f427805c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundFrameLayout f427806d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f427807e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f427808f;

    d(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RecentAvatarViewWrapper recentAvatarViewWrapper, @NonNull RoundFrameLayout roundFrameLayout, @NonNull RelativeLayout relativeLayout3, @NonNull ImageView imageView) {
        this.f427803a = relativeLayout;
        this.f427804b = relativeLayout2;
        this.f427805c = recentAvatarViewWrapper;
        this.f427806d = roundFrameLayout;
        this.f427807e = relativeLayout3;
        this.f427808f = imageView;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.f164548a32;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f164548a32);
        if (relativeLayout != null) {
            i3 = R.id.a39;
            RecentAvatarViewWrapper recentAvatarViewWrapper = (RecentAvatarViewWrapper) ViewBindings.findChildViewById(view, R.id.a39);
            if (recentAvatarViewWrapper != null) {
                i3 = R.id.t1t;
                RoundFrameLayout roundFrameLayout = (RoundFrameLayout) ViewBindings.findChildViewById(view, R.id.t1t);
                if (roundFrameLayout != null) {
                    RelativeLayout relativeLayout2 = (RelativeLayout) view;
                    i3 = R.id.f165003uk2;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165003uk2);
                    if (imageView != null) {
                        return new d(relativeLayout2, relativeLayout, recentAvatarViewWrapper, roundFrameLayout, relativeLayout2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static d h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eky, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f427803a;
    }
}
