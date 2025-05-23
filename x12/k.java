package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f446943a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f446944b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f446945c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f446946d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RoundImageView f446947e;

    k(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull RoundImageView roundImageView) {
        this.f446943a = radiusFrameLayout;
        this.f446944b = frameLayout;
        this.f446945c = textView;
        this.f446946d = imageView;
        this.f446947e = roundImageView;
    }

    @NonNull
    public static k e(@NonNull View view) {
        int i3 = R.id.f1172670z;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f1172670z);
        if (frameLayout != null) {
            i3 = R.id.kqr;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.kqr);
            if (textView != null) {
                i3 = R.id.f1177872d;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f1177872d);
                if (imageView != null) {
                    i3 = R.id.kuw;
                    RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.kuw);
                    if (roundImageView != null) {
                        return new k((RadiusFrameLayout) view, frameLayout, textView, imageView, roundImageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static k g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static k h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eqr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f446943a;
    }
}
