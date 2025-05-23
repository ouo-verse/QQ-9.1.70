package sw3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.base.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f434892a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundRectImageView f434893b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f434894c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final i f434895d;

    c(@NonNull ConstraintLayout constraintLayout, @NonNull RoundRectImageView roundRectImageView, @NonNull TextView textView, @NonNull i iVar) {
        this.f434892a = constraintLayout;
        this.f434893b = roundRectImageView;
        this.f434894c = textView;
        this.f434895d = iVar;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.f164892u60;
        RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.f164892u60);
        if (roundRectImageView != null) {
            i3 = R.id.f164893u61;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f164893u61);
            if (textView != null) {
                i3 = R.id.f83294j6;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f83294j6);
                if (findChildViewById != null) {
                    return new c((ConstraintLayout) view, roundRectImageView, textView, i.e(findChildViewById));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fdy, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f434892a;
    }
}
