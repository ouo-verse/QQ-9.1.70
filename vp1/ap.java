package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class ap implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442270a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442271b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442272c;

    ap(@NonNull View view, @NonNull RoundImageView roundImageView, @NonNull TextView textView) {
        this.f442270a = view;
        this.f442271b = roundImageView;
        this.f442272c = textView;
    }

    @NonNull
    public static ap e(@NonNull View view) {
        int i3 = R.id.wic;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wic);
        if (roundImageView != null) {
            i3 = R.id.wrw;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
            if (textView != null) {
                return new ap(view, roundImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ap f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.el7, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442270a;
    }
}
