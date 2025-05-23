package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f446933a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundImageView f446934b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f446935c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f446936d;

    h(@NonNull FrameLayout frameLayout, @NonNull RoundImageView roundImageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f446933a = frameLayout;
        this.f446934b = roundImageView;
        this.f446935c = textView;
        this.f446936d = textView2;
    }

    @NonNull
    public static h e(@NonNull View view) {
        int i3 = R.id.vzu;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.vzu);
        if (roundImageView != null) {
            i3 = R.id.wqy;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wqy);
            if (textView != null) {
                i3 = R.id.f165583ws3;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f165583ws3);
                if (textView2 != null) {
                    return new h((FrameLayout) view, roundImageView, textView, textView2);
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
        View inflate = layoutInflater.inflate(R.layout.eqo, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f446933a;
    }
}
