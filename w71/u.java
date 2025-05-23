package w71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.widget.RedDotImageView;
import com.tx.x2j.AioTitleBarRight3IvBinding;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class u implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RedDotImageView f444919a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RedDotImageView f444920b;

    u(@NonNull RedDotImageView redDotImageView, @NonNull RedDotImageView redDotImageView2) {
        this.f444919a = redDotImageView;
        this.f444920b = redDotImageView2;
    }

    @NonNull
    public static u e(@NonNull View view) {
        if (view != null) {
            RedDotImageView redDotImageView = (RedDotImageView) view;
            return new u(redDotImageView, redDotImageView);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    @NonNull
    public static u g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioTitleBarRight3IvBinding aioTitleBarRight3IvBinding = new AioTitleBarRight3IvBinding();
        aioTitleBarRight3IvBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioTitleBarRight3IvBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dwo, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RedDotImageView getRoot() {
        return this.f444919a;
    }
}
