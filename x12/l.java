package x12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f446948a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f446949b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f446950c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f446951d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f446952e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f446953f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f446954g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f446955h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ScrollView f446956i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f446957j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final FrameLayout f446958k;

    l(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull View view2, @NonNull View view3, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout3, @NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout4, @NonNull FrameLayout frameLayout) {
        this.f446948a = view;
        this.f446949b = linearLayout;
        this.f446950c = linearLayout2;
        this.f446951d = textView;
        this.f446952e = view2;
        this.f446953f = view3;
        this.f446954g = imageView;
        this.f446955h = linearLayout3;
        this.f446956i = scrollView;
        this.f446957j = linearLayout4;
        this.f446958k = frameLayout;
    }

    @NonNull
    public static l e(@NonNull View view) {
        int i3 = R.id.b9w;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.b9w);
        if (linearLayout != null) {
            i3 = R.id.ciw;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ciw);
            if (linearLayout2 != null) {
                i3 = R.id.we9;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.we9);
                if (textView != null) {
                    i3 = R.id.we_;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.we_);
                    if (findChildViewById != null) {
                        i3 = R.id.wea;
                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.wea);
                        if (findChildViewById2 != null) {
                            i3 = R.id.x2m;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.x2m);
                            if (imageView != null) {
                                i3 = R.id.d4l;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.d4l);
                                if (linearLayout3 != null) {
                                    i3 = R.id.yit;
                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.yit);
                                    if (scrollView != null) {
                                        i3 = R.id.yiu;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.yiu);
                                        if (linearLayout4 != null) {
                                            i3 = R.id.f85104o2;
                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f85104o2);
                                            if (frameLayout != null) {
                                                return new l(view, linearLayout, linearLayout2, textView, findChildViewById, findChildViewById2, imageView, linearLayout3, scrollView, linearLayout4, frameLayout);
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
    public static l f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.eqs, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f446948a;
    }
}
