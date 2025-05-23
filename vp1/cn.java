package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cn implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442738a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442739b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442740c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442741d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442742e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442743f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442744g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f442745h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442746i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f442747j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f442748k;

    cn(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView3, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView4, @NonNull RelativeLayout relativeLayout3, @NonNull ImageView imageView5, @NonNull TextView textView) {
        this.f442738a = linearLayout;
        this.f442739b = linearLayout2;
        this.f442740c = imageView;
        this.f442741d = imageView2;
        this.f442742e = relativeLayout;
        this.f442743f = imageView3;
        this.f442744g = relativeLayout2;
        this.f442745h = imageView4;
        this.f442746i = relativeLayout3;
        this.f442747j = imageView5;
        this.f442748k = textView;
    }

    @NonNull
    public static cn e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.f165568wp3;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165568wp3);
        if (imageView != null) {
            i3 = R.id.f165587wt2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165587wt2);
            if (imageView2 != null) {
                i3 = R.id.zuh;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.zuh);
                if (relativeLayout != null) {
                    i3 = R.id.zui;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.zui);
                    if (imageView3 != null) {
                        i3 = R.id.zuv;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.zuv);
                        if (relativeLayout2 != null) {
                            i3 = R.id.zuw;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.zuw);
                            if (imageView4 != null) {
                                i3 = R.id.zux;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.zux);
                                if (relativeLayout3 != null) {
                                    i3 = R.id.zuy;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.zuy);
                                    if (imageView5 != null) {
                                        i3 = R.id.f166992jq2;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f166992jq2);
                                        if (textView != null) {
                                            return new cn(linearLayout, linearLayout, imageView, imageView2, relativeLayout, imageView3, relativeLayout2, imageView4, relativeLayout3, imageView5, textView);
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
    public static cn g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f1m, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442738a;
    }
}
