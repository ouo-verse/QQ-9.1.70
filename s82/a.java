package s82;

import android.graphics.Bitmap;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001f\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R%\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Ls82/a;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "currentText", "Landroid/graphics/Bitmap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "M1", "currentPicBitmap", "Ls82/b;", BdhLogUtil.LogTag.Tag_Conn, "N1", "currentPicInfo", "", "kotlin.jvm.PlatformType", "D", "L1", "canPublish", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<CharSequence> currentText = new MutableLiveData<>("");

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Bitmap> currentPicBitmap = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<SquarePublishPicInfo> currentPicInfo = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> canPublish = new MutableLiveData<>(Boolean.FALSE);

    public final MutableLiveData<Boolean> L1() {
        return this.canPublish;
    }

    public final MutableLiveData<Bitmap> M1() {
        return this.currentPicBitmap;
    }

    public final MutableLiveData<SquarePublishPicInfo> N1() {
        return this.currentPicInfo;
    }

    public final MutableLiveData<CharSequence> O1() {
        return this.currentText;
    }
}
