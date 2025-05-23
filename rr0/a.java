package rr0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f431980a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f431981b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f431982c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f431983d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f431984e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f431985f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f431986g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f431987h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f431988i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f431989j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f431990k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f431991l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f431992m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f431993n;

    a(@NonNull RelativeLayout relativeLayout, @NonNull Button button, @NonNull RoundCornerImageView roundCornerImageView, @NonNull FrameLayout frameLayout, @NonNull RoundCornerImageView roundCornerImageView2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f431980a = relativeLayout;
        this.f431981b = button;
        this.f431982c = roundCornerImageView;
        this.f431983d = frameLayout;
        this.f431984e = roundCornerImageView2;
        this.f431985f = imageView;
        this.f431986g = imageView2;
        this.f431987h = imageView3;
        this.f431988i = imageView4;
        this.f431989j = relativeLayout2;
        this.f431990k = textView;
        this.f431991l = textView2;
        this.f431992m = textView3;
        this.f431993n = textView4;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.tij;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.tij);
        if (button != null) {
            i3 = R.id.tik;
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.tik);
            if (roundCornerImageView != null) {
                i3 = R.id.why;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.why);
                if (frameLayout != null) {
                    i3 = R.id.xj9;
                    RoundCornerImageView roundCornerImageView2 = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.xj9);
                    if (roundCornerImageView2 != null) {
                        i3 = R.id.xjn;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.xjn);
                        if (imageView != null) {
                            i3 = R.id.f165775xk0;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165775xk0);
                            if (imageView2 != null) {
                                i3 = R.id.f165776xk1;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165776xk1);
                                if (imageView3 != null) {
                                    i3 = R.id.xk7;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.xk7);
                                    if (imageView4 != null) {
                                        RelativeLayout relativeLayout = (RelativeLayout) view;
                                        i3 = R.id.f112946pa;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f112946pa);
                                        if (textView != null) {
                                            i3 = R.id.f113086po;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f113086po);
                                            if (textView2 != null) {
                                                i3 = R.id.f113116pr;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f113116pr);
                                                if (textView3 != null) {
                                                    i3 = R.id.f113336qc;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f113336qc);
                                                    if (textView4 != null) {
                                                        return new a(relativeLayout, button, roundCornerImageView, frameLayout, roundCornerImageView2, imageView, imageView2, imageView3, imageView4, relativeLayout, textView, textView2, textView3, textView4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168049ej1, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f431980a;
    }
}
