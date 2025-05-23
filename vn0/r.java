package vn0;

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
/* loaded from: classes6.dex */
public final class r implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f442015a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f442016b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f442017c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f442018d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f442019e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f442020f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f442021g;

    r(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2) {
        this.f442015a = relativeLayout;
        this.f442016b = view;
        this.f442017c = relativeLayout2;
        this.f442018d = imageView;
        this.f442019e = textView;
        this.f442020f = imageView2;
        this.f442021g = textView2;
    }

    @NonNull
    public static r e(@NonNull View view) {
        int i3 = R.id.uzi;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.uzi);
        if (findChildViewById != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i3 = R.id.w2m;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.w2m);
            if (imageView != null) {
                i3 = R.id.w2n;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.w2n);
                if (textView != null) {
                    i3 = R.id.w2o;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.w2o);
                    if (imageView2 != null) {
                        i3 = R.id.w2p;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.w2p);
                        if (textView2 != null) {
                            return new r(relativeLayout, findChildViewById, relativeLayout, imageView, textView, imageView2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static r g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ej8, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f442015a;
    }
}
