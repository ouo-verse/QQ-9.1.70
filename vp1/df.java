package vp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class df implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f442886a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f442887b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUIButton f442888c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f442889d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QUIButton f442890e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f442891f;

    df(@NonNull View view, @NonNull TextView textView, @NonNull QUIButton qUIButton, @NonNull ConstraintLayout constraintLayout, @NonNull QUIButton qUIButton2, @NonNull TextView textView2) {
        this.f442886a = view;
        this.f442887b = textView;
        this.f442888c = qUIButton;
        this.f442889d = constraintLayout;
        this.f442890e = qUIButton2;
        this.f442891f = textView2;
    }

    @NonNull
    public static df e(@NonNull View view) {
        int i3 = R.id.cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.cancel);
        if (textView != null) {
            i3 = R.id.vqv;
            QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.vqv);
            if (qUIButton != null) {
                i3 = R.id.x5w;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.x5w);
                if (constraintLayout != null) {
                    i3 = R.id.f72863s0;
                    QUIButton qUIButton2 = (QUIButton) ViewBindings.findChildViewById(view, R.id.f72863s0);
                    if (qUIButton2 != null) {
                        i3 = R.id.f82684hj;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f82684hj);
                        if (textView2 != null) {
                            return new df(view, textView, qUIButton, constraintLayout, qUIButton2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static df f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f4p, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f442886a;
    }
}
