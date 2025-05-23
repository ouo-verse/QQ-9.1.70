package vp1;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f443031a;

    l(@NonNull LinearLayout linearLayout) {
        this.f443031a = linearLayout;
    }

    @NonNull
    public static l e(@NonNull View view) {
        if (view != null) {
            return new l((LinearLayout) view);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f443031a;
    }
}
