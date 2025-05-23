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
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class bg implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f442449a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f442450b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442451c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442452d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442453e;

    bg(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView) {
        this.f442449a = constraintLayout;
        this.f442450b = imageView;
        this.f442451c = imageView2;
        this.f442452d = imageView3;
        this.f442453e = textView;
    }

    @NonNull
    public static bg e(@NonNull View view) {
        int i3 = R.id.ton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ton);
        if (imageView != null) {
            i3 = R.id.xlp;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.xlp);
            if (imageView2 != null) {
                i3 = R.id.xlq;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.xlq);
                if (imageView3 != null) {
                    i3 = R.id.ykm;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ykm);
                    if (textView != null) {
                        return new bg((ConstraintLayout) view, imageView, imageView2, imageView3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bg g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.etl, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f442449a;
    }
}
