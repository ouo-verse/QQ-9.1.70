package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class o implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f443066a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f443067b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundImageView f443068c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f443069d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f443070e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f443071f;

    o(@NonNull View view, @NonNull ImageView imageView, @NonNull RoundImageView roundImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2) {
        this.f443066a = view;
        this.f443067b = imageView;
        this.f443068c = roundImageView;
        this.f443069d = textView;
        this.f443070e = textView2;
        this.f443071f = imageView2;
    }

    @NonNull
    public static o e(@NonNull View view) {
        int i3 = R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_back);
        if (imageView != null) {
            i3 = R.id.vzu;
            RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.vzu);
            if (roundImageView != null) {
                i3 = R.id.wqy;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wqy);
                if (textView != null) {
                    i3 = R.id.f165583ws3;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f165583ws3);
                    if (textView2 != null) {
                        i3 = R.id.y0p;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.y0p);
                        if (imageView2 != null) {
                            return new o(view, imageView, roundImageView, textView, textView2, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static o f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.egn, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f443066a;
    }
}
