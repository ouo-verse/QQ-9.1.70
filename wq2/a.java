package wq2;

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
/* loaded from: classes18.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f446053a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f446054b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f446055c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f446056d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f446057e;

    a(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull TextView textView, @NonNull ImageView imageView2) {
        this.f446053a = constraintLayout;
        this.f446054b = imageView;
        this.f446055c = view;
        this.f446056d = textView;
        this.f446057e = imageView2;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.a2o;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.a2o);
        if (imageView != null) {
            i3 = R.id.bmt;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.bmt);
            if (findChildViewById != null) {
                i3 = R.id.f9d;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f9d);
                if (textView != null) {
                    i3 = R.id.i_m;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.i_m);
                    if (imageView2 != null) {
                        return new a((ConstraintLayout) view, imageView, findChildViewById, textView, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f169088hq3, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f446053a;
    }
}
