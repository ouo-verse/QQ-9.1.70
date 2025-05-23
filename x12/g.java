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
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f446929a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundImageView f446930b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f446931c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f446932d;

    g(@NonNull FrameLayout frameLayout, @NonNull RoundImageView roundImageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f446929a = frameLayout;
        this.f446930b = roundImageView;
        this.f446931c = textView;
        this.f446932d = textView2;
    }

    @NonNull
    public static g e(@NonNull View view) {
        int i3 = R.id.wcp;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wcp);
        if (roundImageView != null) {
            i3 = R.id.wcq;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wcq);
            if (textView != null) {
                i3 = R.id.wcr;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.wcr);
                if (textView2 != null) {
                    return new g((FrameLayout) view, roundImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static g g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static g h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eqn, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f446929a;
    }
}
