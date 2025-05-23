package sj;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010/\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010&\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*\u00a8\u00062"}, d2 = {"Lsj/b;", "Lsj/d;", "Ljava/util/ArrayList;", "Lqzone/QZoneBaseMeta$StMedia;", "Lkotlin/collections/ArrayList;", "mediaList", "", HippyTKDListViewAdapter.X, "", "L", "Z", "k0", "()Z", "s0", "(Z)V", "isRefresh", "M", "h0", "n0", "isFetchLeft", "N", "i0", "o0", "isFetchRight", "P", "j0", "q0", "isLeftFinish", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "l0", "t0", "isRightFinish", BdhLogUtil.LogTag.Tag_Req, "g0", "m0", "isDeleteChange", "", ExifInterface.LATITUDE_SOUTH, "I", "f0", "()I", "r0", "(I)V", "mediumSum", "T", "e0", "p0", "initMediaPositionInAlbum", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends d {

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isRefresh;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFetchLeft;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isFetchRight;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isLeftFinish;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isRightFinish;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isDeleteChange;

    /* renamed from: S, reason: from kotlin metadata */
    private int mediumSum;

    /* renamed from: T, reason: from kotlin metadata */
    private int initMediaPositionInAlbum;

    /* renamed from: e0, reason: from getter */
    public final int getInitMediaPositionInAlbum() {
        return this.initMediaPositionInAlbum;
    }

    /* renamed from: f0, reason: from getter */
    public final int getMediumSum() {
        return this.mediumSum;
    }

    /* renamed from: g0, reason: from getter */
    public final boolean getIsDeleteChange() {
        return this.isDeleteChange;
    }

    /* renamed from: h0, reason: from getter */
    public final boolean getIsFetchLeft() {
        return this.isFetchLeft;
    }

    /* renamed from: i0, reason: from getter */
    public final boolean getIsFetchRight() {
        return this.isFetchRight;
    }

    /* renamed from: j0, reason: from getter */
    public final boolean getIsLeftFinish() {
        return this.isLeftFinish;
    }

    /* renamed from: k0, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    /* renamed from: l0, reason: from getter */
    public final boolean getIsRightFinish() {
        return this.isRightFinish;
    }

    public final void m0(boolean z16) {
        this.isDeleteChange = z16;
    }

    public final void n0(boolean z16) {
        this.isFetchLeft = z16;
    }

    public final void o0(boolean z16) {
        this.isFetchRight = z16;
    }

    public final void p0(int i3) {
        this.initMediaPositionInAlbum = i3;
    }

    public final void q0(boolean z16) {
        this.isLeftFinish = z16;
    }

    public final void r0(int i3) {
        this.mediumSum = i3;
    }

    public final void s0(boolean z16) {
        this.isRefresh = z16;
    }

    public final void t0(boolean z16) {
        this.isRightFinish = z16;
    }

    @Override // sj.d
    public void x(ArrayList<QZoneBaseMeta$StMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return;
        }
        ArrayList<RFWLayerItemMediaInfo> arrayList = new ArrayList<>();
        Iterator<QZoneBaseMeta$StMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            QZoneBaseMeta$StMedia media = it.next();
            Intrinsics.checkNotNullExpressionValue(media, "media");
            RFWLayerItemMediaInfo y16 = y(media);
            y16.setExtraData(v(media));
            arrayList.add(y16);
        }
        o(arrayList);
    }
}
