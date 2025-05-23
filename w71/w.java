package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tx.x2j.AioTopMaskBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class w implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f444925a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f444926b;

    w(@NonNull View view, @NonNull View view2) {
        this.f444925a = view;
        this.f444926b = view2;
    }

    @NonNull
    public static w e(@NonNull View view) {
        if (view != null) {
            return new w(view, view);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    @NonNull
    public static w f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioTopMaskBinding aioTopMaskBinding = new AioTopMaskBinding();
        aioTopMaskBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioTopMaskBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dwq, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f444925a;
    }
}
