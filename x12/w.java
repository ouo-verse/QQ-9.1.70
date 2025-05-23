package x12;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.ThemeableImageView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class w implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f447039a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f447040b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f447041c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f447042d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f447043e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f447044f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ThemeableImageView f447045g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f447046h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f447047i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f447048j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f447049k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final View f447050l;

    w(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull ConstraintLayout constraintLayout2, @NonNull ThemeableImageView themeableImageView, @NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view2) {
        this.f447039a = constraintLayout;
        this.f447040b = linearLayout;
        this.f447041c = linearLayout2;
        this.f447042d = linearLayout3;
        this.f447043e = linearLayout4;
        this.f447044f = constraintLayout2;
        this.f447045g = themeableImageView;
        this.f447046h = view;
        this.f447047i = imageView;
        this.f447048j = textView;
        this.f447049k = textView2;
        this.f447050l = view2;
    }

    @NonNull
    public static w e(@NonNull View view) {
        int i3 = R.id.vug;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vug);
        if (linearLayout != null) {
            i3 = R.id.vuh;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vuh);
            if (linearLayout2 != null) {
                i3 = R.id.vui;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vui);
                if (linearLayout3 != null) {
                    i3 = R.id.vuj;
                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vuj);
                    if (linearLayout4 != null) {
                        i3 = R.id.d_b;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.d_b);
                        if (constraintLayout != null) {
                            i3 = R.id.y5i;
                            ThemeableImageView themeableImageView = (ThemeableImageView) ViewBindings.findChildViewById(view, R.id.y5i);
                            if (themeableImageView != null) {
                                i3 = R.id.y5j;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.y5j);
                                if (findChildViewById != null) {
                                    i3 = R.id.y7g;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.y7g);
                                    if (imageView != null) {
                                        i3 = R.id.f109166f3;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f109166f3);
                                        if (textView != null) {
                                            i3 = R.id.f111586lm;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f111586lm);
                                            if (textView2 != null) {
                                                i3 = R.id.f116116xv;
                                                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f116116xv);
                                                if (findChildViewById2 != null) {
                                                    return new w((ConstraintLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, constraintLayout, themeableImageView, findChildViewById, imageView, textView, textView2, findChildViewById2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f447039a;
    }
}
