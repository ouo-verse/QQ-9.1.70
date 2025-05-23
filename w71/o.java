package w71;

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
import com.tencent.mobileqq.qqui.widget.AutoBgImageView;
import com.tx.x2j.AioRevokeGrayTipsBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class o implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f444864a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final AutoBgImageView f444865b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f444866c;

    o(@NonNull ConstraintLayout constraintLayout, @NonNull AutoBgImageView autoBgImageView, @NonNull TextView textView) {
        this.f444864a = constraintLayout;
        this.f444865b = autoBgImageView;
        this.f444866c = textView;
    }

    @NonNull
    public static o e(@NonNull View view) {
        int i3 = R.id.vs8;
        AutoBgImageView autoBgImageView = (AutoBgImageView) ViewBindings.findChildViewById(view, R.id.vs8);
        if (autoBgImageView != null) {
            i3 = R.id.vsi;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vsi);
            if (textView != null) {
                return new o((ConstraintLayout) view, autoBgImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static o g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioRevokeGrayTipsBinding aioRevokeGrayTipsBinding = new AioRevokeGrayTipsBinding();
        aioRevokeGrayTipsBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioRevokeGrayTipsBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dw9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f444864a;
    }
}
