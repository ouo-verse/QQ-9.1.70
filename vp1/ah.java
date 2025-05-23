package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ah implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442207a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442208b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442209c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f442210d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442211e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442212f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ag f442213g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f442214h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ViewStub f442215i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442216j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442217k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f442218l;

    ah(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView, @NonNull ag agVar, @NonNull TextView textView5, @NonNull ViewStub viewStub, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView6, @NonNull TextView textView7) {
        this.f442207a = view;
        this.f442208b = textView;
        this.f442209c = textView2;
        this.f442210d = textView3;
        this.f442211e = textView4;
        this.f442212f = imageView;
        this.f442213g = agVar;
        this.f442214h = textView5;
        this.f442215i = viewStub;
        this.f442216j = relativeLayout;
        this.f442217k = textView6;
        this.f442218l = textView7;
    }

    @NonNull
    public static ah e(@NonNull View view) {
        int i3 = R.id.ivTitleBtnLeft;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ivTitleBtnLeft);
        if (textView != null) {
            i3 = R.id.ivTitleBtnLeftButton;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ivTitleBtnLeftButton);
            if (textView2 != null) {
                i3 = R.id.dt6;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.dt6);
                if (textView3 != null) {
                    i3 = R.id.ivTitleName;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.ivTitleName);
                    if (textView4 != null) {
                        i3 = R.id.f165972dz1;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165972dz1);
                        if (imageView != null) {
                            i3 = R.id.f166811ie3;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f166811ie3);
                            if (findChildViewById != null) {
                                ag e16 = ag.e(findChildViewById);
                                i3 = R.id.joi;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.joi);
                                if (textView5 != null) {
                                    i3 = R.id.f98365mw;
                                    ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.f98365mw);
                                    if (viewStub != null) {
                                        i3 = R.id.jp7;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.jp7);
                                        if (relativeLayout != null) {
                                            i3 = R.id.jq5;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.jq5);
                                            if (textView6 != null) {
                                                i3 = R.id.k4f;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.k4f);
                                                if (textView7 != null) {
                                                    return new ah(view, textView, textView2, textView3, textView4, imageView, e16, textView5, viewStub, relativeLayout, textView6, textView7);
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
    public static ah f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.ek9, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442207a;
    }
}
