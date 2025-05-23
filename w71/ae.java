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
public final class ae implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f444729a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FadeIconImageView f444730b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f444731c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FadeIconImageView f444732d;

    ae(@NonNull LinearLayout linearLayout, @NonNull FadeIconImageView fadeIconImageView, @NonNull TextView textView, @NonNull FadeIconImageView fadeIconImageView2) {
        this.f444729a = linearLayout;
        this.f444730b = fadeIconImageView;
        this.f444731c = textView;
        this.f444732d = fadeIconImageView2;
    }

    @NonNull
    public static ae e(@NonNull View view) {
        int i3 = R.id.az7;
        FadeIconImageView fadeIconImageView = (FadeIconImageView) ViewBindings.findChildViewById(view, R.id.az7);
        if (fadeIconImageView != null) {
            i3 = R.id.jpe;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jpe);
            if (textView != null) {
                i3 = R.id.f126067nr;
                FadeIconImageView fadeIconImageView2 = (FadeIconImageView) ViewBindings.findChildViewById(view, R.id.f126067nr);
                if (fadeIconImageView2 != null) {
                    return new ae((LinearLayout) view, fadeIconImageView, textView, fadeIconImageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ae g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static ae h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fjs, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f444729a;
    }
}
