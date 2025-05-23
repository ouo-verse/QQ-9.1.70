package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class dc implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FlexboxLayout f442875a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442876b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442877c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442878d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442879e;

    dc(@NonNull FlexboxLayout flexboxLayout, @NonNull RoundImageView roundImageView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f442875a = flexboxLayout;
        this.f442876b = roundImageView;
        this.f442877c = textView;
        this.f442878d = imageView;
        this.f442879e = textView2;
    }

    @NonNull
    public static dc e(@NonNull View view) {
        int i3 = R.id.vzu;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.vzu);
        if (roundImageView != null) {
            i3 = R.id.wrw;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
            if (textView != null) {
                i3 = R.id.f74613wq;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f74613wq);
                if (imageView != null) {
                    i3 = R.id.jmp;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.jmp);
                    if (textView2 != null) {
                        return new dc((FlexboxLayout) view, roundImageView, textView, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static dc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f4h, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout getRoot() {
        return this.f442875a;
    }
}
