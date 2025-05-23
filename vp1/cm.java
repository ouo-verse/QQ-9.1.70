package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cm implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442730a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final OverScrollRecyclerViewWithHeaderFooter f442731b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f442732c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442733d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f442734e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f442735f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442736g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f442737h;

    cm(@NonNull LinearLayout linearLayout, @NonNull OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull View view) {
        this.f442730a = linearLayout;
        this.f442731b = overScrollRecyclerViewWithHeaderFooter;
        this.f442732c = imageView;
        this.f442733d = imageView2;
        this.f442734e = imageView3;
        this.f442735f = linearLayout2;
        this.f442736g = textView;
        this.f442737h = view;
    }

    @NonNull
    public static cm e(@NonNull View view) {
        int i3 = R.id.wjd;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) ViewBindings.findChildViewById(view, R.id.wjd);
        if (overScrollRecyclerViewWithHeaderFooter != null) {
            i3 = R.id.wkk;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.wkk);
            if (imageView != null) {
                i3 = R.id.wkm;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.wkm);
                if (imageView2 != null) {
                    i3 = R.id.wkn;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.wkn);
                    if (imageView3 != null) {
                        i3 = R.id.wsu;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wsu);
                        if (linearLayout != null) {
                            i3 = R.id.x3f;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.x3f);
                            if (textView != null) {
                                i3 = R.id.xl7;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.xl7);
                                if (findChildViewById != null) {
                                    return new cm((LinearLayout) view, overScrollRecyclerViewWithHeaderFooter, imageView, imageView2, imageView3, linearLayout, textView, findChildViewById);
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
    public static cm g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static cm h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f1l, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442730a;
    }
}
