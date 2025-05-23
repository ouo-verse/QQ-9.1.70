package wj;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import qzone.QZIntimateSpaceAlbum$GetMediasListRsp;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001d\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0004J2\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0004R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\"\u0010(\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\"\u0010,\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\"\u0010/\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\"\u00103\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017\u00a8\u00066"}, d2 = {"Lwj/d;", "Lq9/a;", "Lsj/b;", "Lsj/c;", "requestBean", "", "U1", "layerBean", "b2", "", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/QZIntimateSpaceAlbum$GetMediasListRsp;", "rsp", "T1", "D", "Ljava/lang/String;", "R1", "()Ljava/lang/String;", "Z1", "(Ljava/lang/String;)V", "spaceId", "", "E", "I", "S1", "()I", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(I)V", "spaceType", UserInfo.SEX_FEMALE, "O1", "W1", "feedId", "G", "getAlbumId", "setAlbumId", "albumId", "H", "getAlbumName", "setAlbumName", AEEditorConstants.ALBUMNAME, "P1", "setLeftAttachInfo", "leftAttachInfo", "J", "Q1", "X1", "rightAttachInfo", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class d extends q9.a<sj.b> {

    /* renamed from: E, reason: from kotlin metadata */
    private int spaceType;

    /* renamed from: D, reason: from kotlin metadata */
    private String spaceId = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String feedId = "";

    /* renamed from: G, reason: from kotlin metadata */
    private String albumId = "";

    /* renamed from: H, reason: from kotlin metadata */
    private String albumName = "";

    /* renamed from: I, reason: from kotlin metadata */
    private String leftAttachInfo = "";

    /* renamed from: J, reason: from kotlin metadata */
    private String rightAttachInfo = "";

    /* renamed from: O1, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: P1, reason: from getter */
    public final String getLeftAttachInfo() {
        return this.leftAttachInfo;
    }

    /* renamed from: Q1, reason: from getter */
    public final String getRightAttachInfo() {
        return this.rightAttachInfo;
    }

    /* renamed from: R1, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    /* renamed from: S1, reason: from getter */
    public final int getSpaceType() {
        return this.spaceType;
    }

    public abstract void U1(sj.c requestBean);

    public final void W1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void X1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightAttachInfo = str;
    }

    public final void Z1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void a2(int i3) {
        this.spaceType = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b2(sj.c layerBean) {
        Intrinsics.checkNotNullParameter(layerBean, "layerBean");
        if (layerBean.getIsRefresh()) {
            getLoadInfo().setCurrentState(2);
        } else if (layerBean.getIsFetchRight()) {
            getLoadInfo().setCurrentState(0);
        } else {
            getLoadInfo().setCurrentState(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void T1(boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceAlbum$GetMediasListRsp rsp, sj.c requestBean) {
        long coerceIn;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        getLoadInfo().setCurrentState(4);
        sj.b bVar = new sj.b();
        if (isSuccess && rsp != null) {
            if (retCode == 0) {
                PBBoolField pBBoolField = rsp.prev_has_more;
                boolean z16 = pBBoolField != null ? pBBoolField.get() : false;
                PBBoolField pBBoolField2 = rsp.next_has_more;
                boolean z17 = pBBoolField2 != null ? pBBoolField2.get() : false;
                if (requestBean.getIsFetchRight()) {
                    String str = rsp.next_attach_info.get();
                    Intrinsics.checkNotNullExpressionValue(str, "rsp.next_attach_info.get()");
                    this.rightAttachInfo = str;
                    bVar.t0(!z17);
                }
                if (requestBean.getIsFetchLeft()) {
                    String str2 = rsp.prev_attach_info.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "rsp.prev_attach_info.get()");
                    this.leftAttachInfo = str2;
                    bVar.q0(!z16);
                }
                bVar.s0(requestBean.getIsRefresh());
                bVar.n0(requestBean.getIsFetchLeft());
                bVar.o0(requestBean.getIsFetchRight());
                bVar.p0(rsp.medias_index.get());
                PBStringField pBStringField = rsp.album_info.name;
                bVar.k(pBStringField != null ? pBStringField.get() : null);
                PBStringField pBStringField2 = rsp.album_info.album_id;
                bVar.j(pBStringField2 != null ? pBStringField2.get() : null);
                PBUInt64Field pBUInt64Field = rsp.album_info.upload_number;
                coerceIn = RangesKt___RangesKt.coerceIn(pBUInt64Field != null ? pBUInt64Field.get() : 0L, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, TTL.MAX_VALUE);
                bVar.r0((int) coerceIn);
                List<QZoneBaseMeta$StMedia> list = rsp.medias.get();
                Intrinsics.checkNotNullExpressionValue(list, "rsp.medias.get()");
                bVar.x(new ArrayList<>(list));
                if (bVar.getMediumSum() == 0) {
                    bVar.r0(bVar.g().size());
                }
                if (ArrayUtils.isOutOfArrayIndex(0, bVar.g())) {
                    M1().postValue(UIStateData.obtainEmpty().setRetCode(retCode));
                    return;
                } else {
                    M1().postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setDataList(bVar));
                    return;
                }
            }
        }
        RFWLog.e(getLogTag(), RFWLog.USR, "handleFeedListResponse rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
    }
}
