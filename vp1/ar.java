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
public final class ar implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442280a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundImageView f442281b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442282c;

    ar(@NonNull View view, @NonNull RoundImageView roundImageView, @NonNull TextView textView) {
        this.f442280a = view;
        this.f442281b = roundImageView;
        this.f442282c = textView;
    }

    @NonNull
    public static ar e(@NonNull View view) {
        int i3 = R.id.wic;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.wic);
        if (roundImageView != null) {
            i3 = R.id.wrw;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wrw);
            if (textView != null) {
                return new ar(view, roundImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ar f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.el9, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442280a;
    }
}
