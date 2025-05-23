package wq2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.sharepanel.multiSelect.widget.SharePanelAvatarView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f446058a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SharePanelAvatarView f446059b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f446060c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f446061d;

    b(@NonNull ConstraintLayout constraintLayout, @NonNull SharePanelAvatarView sharePanelAvatarView, @NonNull QUICheckBox qUICheckBox, @NonNull TextView textView) {
        this.f446058a = constraintLayout;
        this.f446059b = sharePanelAvatarView;
        this.f446060c = qUICheckBox;
        this.f446061d = textView;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.a2o;
        SharePanelAvatarView sharePanelAvatarView = (SharePanelAvatarView) ViewBindings.findChildViewById(view, R.id.a2o);
        if (sharePanelAvatarView != null) {
            i3 = R.id.axa;
            QUICheckBox qUICheckBox = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.axa);
            if (qUICheckBox != null) {
                i3 = R.id.tv_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name);
                if (textView != null) {
                    return new b((ConstraintLayout) view, sharePanelAvatarView, qUICheckBox, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hqb, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f446058a;
    }
}
