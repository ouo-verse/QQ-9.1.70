package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ag implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f444736a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f444737b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f444738c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f444739d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f444740e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final URLImageView f444741f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f444742g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f444743h;

    ag(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull QUICheckBox qUICheckBox, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull URLImageView uRLImageView, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.f444736a = relativeLayout;
        this.f444737b = relativeLayout2;
        this.f444738c = qUICheckBox;
        this.f444739d = frameLayout;
        this.f444740e = imageView;
        this.f444741f = uRLImageView;
        this.f444742g = imageView2;
        this.f444743h = textView;
    }

    @NonNull
    public static ag e(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i3 = R.id.dpo;
        QUICheckBox qUICheckBox = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.dpo);
        if (qUICheckBox != null) {
            i3 = R.id.xsw;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.xsw);
            if (frameLayout != null) {
                i3 = R.id.xtb;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.xtb);
                if (imageView != null) {
                    i3 = R.id.f165862dq3;
                    URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.f165862dq3);
                    if (uRLImageView != null) {
                        i3 = R.id.f165863dq4;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165863dq4);
                        if (imageView2 != null) {
                            i3 = R.id.drh;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.drh);
                            if (textView != null) {
                                return new ag(relativeLayout, relativeLayout, qUICheckBox, frameLayout, imageView, uRLImageView, imageView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ag g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fr6, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f444736a;
    }
}
