package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class p implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f446981a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f446982b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f446983c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f446984d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f446985e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f446986f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f446987g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f446988h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f446989i;

    p(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView3, @NonNull TextView textView, @NonNull ImageView imageView4, @NonNull TextView textView2) {
        this.f446981a = relativeLayout;
        this.f446982b = imageView;
        this.f446983c = view;
        this.f446984d = imageView2;
        this.f446985e = relativeLayout2;
        this.f446986f = imageView3;
        this.f446987g = textView;
        this.f446988h = imageView4;
        this.f446989i = textView2;
    }

    @NonNull
    public static p e(@NonNull View view) {
        int i3 = R.id.f164495sw4;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164495sw4);
        if (imageView != null) {
            i3 = R.id.uj_;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.uj_);
            if (findChildViewById != null) {
                i3 = R.id.usq;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.usq);
                if (imageView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i3 = R.id.yzb;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.yzb);
                    if (imageView3 != null) {
                        i3 = R.id.f2184024;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f2184024);
                        if (textView != null) {
                            i3 = R.id.f26030cf;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f26030cf);
                            if (imageView4 != null) {
                                i3 = R.id.f28990kf;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f28990kf);
                                if (textView2 != null) {
                                    return new p(relativeLayout, imageView, findChildViewById, imageView2, relativeLayout, imageView3, textView, imageView4, textView2);
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
    public static p g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.eqw, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f446981a;
    }
}
