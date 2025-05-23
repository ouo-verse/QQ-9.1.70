package tk;

import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\t"}, d2 = {"Ltk/j;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f436437a = new j();

    j() {
    }

    public final int a(RFWLayerState layerState) {
        if (layerState == null) {
            return 1;
        }
        return 1 + layerState.getSelectedPosition() + layerState.getPositionOffset();
    }

    public final int b(RFWLayerState layerState) {
        if (layerState == null) {
            return 1;
        }
        if (layerState.getRichMediaDataList() == null) {
            return layerState.getMediaSum();
        }
        int mediaSum = layerState.getMediaSum();
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        Intrinsics.checkNotNull(richMediaDataList);
        return Math.max(mediaSum, richMediaDataList.size());
    }
}
