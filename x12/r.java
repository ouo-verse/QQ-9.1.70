package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class r implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f446996a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f446997b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f446998c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f446999d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RoundImageView f447000e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f447001f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f447002g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f447003h;

    r(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull RoundImageView roundImageView, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout) {
        this.f446996a = constraintLayout;
        this.f446997b = appCompatTextView;
        this.f446998c = frameLayout;
        this.f446999d = textView;
        this.f447000e = roundImageView;
        this.f447001f = constraintLayout2;
        this.f447002g = imageView;
        this.f447003h = linearLayout;
    }

    @NonNull
    public static r e(@NonNull View view) {
        int i3 = R.id.f165005uk4;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, R.id.f165005uk4);
        if (appCompatTextView != null) {
            i3 = R.id.uk5;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.uk5);
            if (frameLayout != null) {
                i3 = R.id.uk7;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.uk7);
                if (textView != null) {
                    i3 = R.id.f25610ba;
                    RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.f25610ba);
                    if (roundImageView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i3 = R.id.e16;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.e16);
                        if (imageView != null) {
                            i3 = R.id.kq_;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.kq_);
                            if (linearLayout != null) {
                                return new r(constraintLayout, appCompatTextView, frameLayout, textView, roundImageView, constraintLayout, imageView, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static r g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static r h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.erf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f446996a;
    }
}
