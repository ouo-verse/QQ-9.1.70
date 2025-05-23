package vp1;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class cy implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f442830a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f442831b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f442832c;

    cy(@NonNull LinearLayout linearLayout, @NonNull QUICheckBox qUICheckBox, @NonNull TextView textView) {
        this.f442830a = linearLayout;
        this.f442831b = qUICheckBox;
        this.f442832c = textView;
    }

    @NonNull
    public static cy e(@NonNull View view) {
        int i3 = R.id.f82664hh;
        QUICheckBox qUICheckBox = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.f82664hh);
        if (qUICheckBox != null) {
            i3 = R.id.jfb;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jfb);
            if (textView != null) {
                return new cy((LinearLayout) view, qUICheckBox, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f442830a;
    }
}
