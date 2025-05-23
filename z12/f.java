package z12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ViewStub f451760a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewStub f451761b;

    f(@NonNull ViewStub viewStub, @NonNull ViewStub viewStub2) {
        this.f451760a = viewStub;
        this.f451761b = viewStub2;
    }

    @NonNull
    public static f e(@NonNull View view) {
        if (view != null) {
            ViewStub viewStub = (ViewStub) view;
            return new f(viewStub, viewStub);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    @NonNull
    public static f g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ewj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ViewStub getRoot() {
        return this.f451760a;
    }
}
