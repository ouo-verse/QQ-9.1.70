package vp1;

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
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ds implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f442986a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442987b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442988c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RFWRoundImageView f442989d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442990e;

    ds(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RFWRoundImageView rFWRoundImageView, @NonNull TextView textView2) {
        this.f442986a = frameLayout;
        this.f442987b = imageView;
        this.f442988c = textView;
        this.f442989d = rFWRoundImageView;
        this.f442990e = textView2;
    }

    @NonNull
    public static ds e(@NonNull View view) {
        int i3 = R.id.trz;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.trz);
        if (imageView != null) {
            i3 = R.id.ato;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ato);
            if (textView != null) {
                i3 = R.id.vzu;
                RFWRoundImageView rFWRoundImageView = (RFWRoundImageView) ViewBindings.findChildViewById(view, R.id.vzu);
                if (rFWRoundImageView != null) {
                    i3 = R.id.ya5;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ya5);
                    if (textView2 != null) {
                        return new ds((FrameLayout) view, imageView, textView, rFWRoundImageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ds g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static ds h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f8y, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f442986a;
    }
}
