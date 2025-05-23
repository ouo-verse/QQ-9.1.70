package ts2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f437373a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f437374b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f437375c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f437376d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f437377e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final QUIButton f437378f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RadiusFrameLayout f437379g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final QUIButton f437380h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final Space f437381i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f437382j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f437383k;

    e(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull ImageFilterView imageFilterView, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull QUIButton qUIButton, @NonNull RadiusFrameLayout radiusFrameLayout, @NonNull QUIButton qUIButton2, @NonNull Space space, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f437373a = constraintLayout;
        this.f437374b = linearLayout;
        this.f437375c = imageFilterView;
        this.f437376d = constraintLayout2;
        this.f437377e = imageView;
        this.f437378f = qUIButton;
        this.f437379g = radiusFrameLayout;
        this.f437380h = qUIButton2;
        this.f437381i = space;
        this.f437382j = textView;
        this.f437383k = textView2;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.amr;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.amr);
        if (linearLayout != null) {
            i3 = R.id.azb;
            ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.azb);
            if (imageFilterView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i3 = R.id.at7;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.at7);
                if (imageView != null) {
                    i3 = R.id.yw8;
                    QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.yw8);
                    if (qUIButton != null) {
                        i3 = R.id.elu;
                        RadiusFrameLayout radiusFrameLayout = (RadiusFrameLayout) ViewBindings.findChildViewById(view, R.id.elu);
                        if (radiusFrameLayout != null) {
                            i3 = R.id.f81664es;
                            QUIButton qUIButton2 = (QUIButton) ViewBindings.findChildViewById(view, R.id.f81664es);
                            if (qUIButton2 != null) {
                                i3 = R.id.iz9;
                                Space space = (Space) ViewBindings.findChildViewById(view, R.id.iz9);
                                if (space != null) {
                                    i3 = R.id.j7y;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.j7y);
                                    if (textView != null) {
                                        i3 = R.id.title;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                        if (textView2 != null) {
                                            return new e(constraintLayout, linearLayout, imageFilterView, constraintLayout, imageView, qUIButton, radiusFrameLayout, qUIButton2, space, textView, textView2);
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

    @NonNull
    public static e g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static e h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hzc, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f437373a;
    }
}
