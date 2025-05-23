package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class av implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442319a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f442320b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442321c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442322d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442323e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442324f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f442325g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442326h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f442327i;

    av(@NonNull ConstraintLayout constraintLayout, @NonNull QUIButton qUIButton, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f442319a = constraintLayout;
        this.f442320b = qUIButton;
        this.f442321c = constraintLayout2;
        this.f442322d = textView;
        this.f442323e = imageView;
        this.f442324f = imageView2;
        this.f442325g = imageView3;
        this.f442326h = textView2;
        this.f442327i = textView3;
    }

    @NonNull
    public static av e(@NonNull View view) {
        int i3 = R.id.u4k;
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.u4k);
        if (qUIButton != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i3 = R.id.bgt;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bgt);
            if (textView != null) {
                i3 = R.id.uli;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.uli);
                if (imageView != null) {
                    i3 = R.id.image;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.image);
                    if (imageView2 != null) {
                        i3 = R.id.xi7;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.xi7);
                        if (imageView3 != null) {
                            i3 = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                            if (textView2 != null) {
                                i3 = R.id.f99145p0;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f99145p0);
                                if (textView3 != null) {
                                    return new av(constraintLayout, qUIButton, constraintLayout, textView, imageView, imageView2, imageView3, textView2, textView3);
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
    public static av g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168093es0, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442319a;
    }
}
