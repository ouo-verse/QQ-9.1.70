package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.widget.FadeIconImageView;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class aa implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f444711a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FadeIconImageView f444712b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f444713c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FadeIconImageView f444714d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f444715e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f444716f;

    aa(@NonNull LinearLayout linearLayout, @NonNull FadeIconImageView fadeIconImageView, @NonNull View view, @NonNull FadeIconImageView fadeIconImageView2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.f444711a = linearLayout;
        this.f444712b = fadeIconImageView;
        this.f444713c = view;
        this.f444714d = fadeIconImageView2;
        this.f444715e = linearLayout2;
        this.f444716f = textView;
    }

    @NonNull
    public static aa e(@NonNull View view) {
        int i3 = R.id.t2h;
        FadeIconImageView fadeIconImageView = (FadeIconImageView) ViewBindings.findChildViewById(view, R.id.t2h);
        if (fadeIconImageView != null) {
            i3 = R.id.bmt;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.bmt);
            if (findChildViewById != null) {
                i3 = R.id.eol;
                FadeIconImageView fadeIconImageView2 = (FadeIconImageView) ViewBindings.findChildViewById(view, R.id.eol);
                if (fadeIconImageView2 != null) {
                    i3 = R.id.jod;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.jod);
                    if (linearLayout != null) {
                        i3 = R.id.jpe;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jpe);
                        if (textView != null) {
                            return new aa((LinearLayout) view, fadeIconImageView, findChildViewById, fadeIconImageView2, linearLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aa g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static aa h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e9c, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f444711a;
    }
}
