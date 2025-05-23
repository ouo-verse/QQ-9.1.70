package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tx.x2j.AioTitleBarBlurBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class s implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final QQBlurViewWrapper f444898a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QQBlurViewWrapper f444899b;

    s(@NonNull QQBlurViewWrapper qQBlurViewWrapper, @NonNull QQBlurViewWrapper qQBlurViewWrapper2) {
        this.f444898a = qQBlurViewWrapper;
        this.f444899b = qQBlurViewWrapper2;
    }

    @NonNull
    public static s e(@NonNull View view) {
        if (view != null) {
            QQBlurViewWrapper qQBlurViewWrapper = (QQBlurViewWrapper) view;
            return new s(qQBlurViewWrapper, qQBlurViewWrapper);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    @NonNull
    public static s g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioTitleBarBlurBinding aioTitleBarBlurBinding = new AioTitleBarBlurBinding();
        aioTitleBarBlurBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioTitleBarBlurBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dwl, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public QQBlurViewWrapper getRoot() {
        return this.f444898a;
    }
}
