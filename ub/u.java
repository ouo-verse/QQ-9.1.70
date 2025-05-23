package ub;

import com.qzone.reborn.albumx.common.convert.bean.CommonPageEndMsg;
import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoTabByTimeLineCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoTabCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoTabByTimeLineReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoTabByTimeLineRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoTabReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoTabRsp;
import com.tencent.qqnt.kernel.nativeinterface.PageEndMsg;
import com.tencent.qqnt.kernel.nativeinterface.PhotoInfo;
import com.tencent.qqnt.kernel.nativeinterface.StTimeLine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0080\u0001\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\rH\u0002Jd\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J,\u0010\u001a\u001a\u00020\u00152\u001a\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016J(\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\rJ\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016\u00a8\u0006'"}, d2 = {"Lub/u;", "Lub/p;", "", "loadType", "result", "", "errMsg", "photoNum", "videoNum", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/PhotoInfo;", "Lkotlin/collections/ArrayList;", "medias", "", "hasMore", "attachInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/StTimeLine;", "timeLine", "Lcom/tencent/qqnt/kernel/nativeinterface/PageEndMsg;", "endMsg", "isNeedScrollToFirst", "", "P", "prevHasMore", "nextHasMore", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, VideoProxy.PARAM_ENABLE_CACHE, HippyTKDListViewAdapter.X, "updateType", "Lcb/a;", "N", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "event", "y", "<init>", "()V", "o", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class u extends p {
    private final void P(int loadType, int result, String errMsg, int photoNum, int videoNum, ArrayList<PhotoInfo> medias, boolean hasMore, String attachInfo, StTimeLine timeLine, PageEndMsg endMsg, boolean isNeedScrollToFirst) {
        if (result != 0) {
            p(O(this, loadType, result, errMsg, false, 8, null));
            return;
        }
        if (loadType == 1) {
            u();
        }
        D(photoNum);
        H(videoNum);
        ArrayList arrayList = new ArrayList();
        for (PhotoInfo photoInfo : medias) {
            if (photoInfo != null) {
                CommonPhotoInfo b16 = com.qzone.reborn.albumx.qzonex.utils.g.f53410a.b(photoInfo);
                h().add(b16);
                arrayList.add(b16);
            }
        }
        c(arrayList, loadType == 3);
        z(attachInfo);
        B(hasMore);
        C(fb.a.l(endMsg));
        if (loadType == 1) {
            f().addAll(com.qzone.reborn.albumx.qzonex.utils.g.f53410a.a(timeLine));
        }
        p(N(loadType, result, errMsg, isNeedScrollToFirst));
    }

    private final void R(ArrayList<PhotoInfo> medias, int loadType) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (PhotoInfo photoInfo : medias) {
            if (photoInfo != null) {
                CommonPhotoInfo b16 = com.qzone.reborn.albumx.qzonex.utils.g.f53410a.b(photoInfo);
                arrayList.add(b16);
                arrayList2.add(b16);
            }
        }
        c(arrayList2, loadType == 3);
        if (loadType == 3) {
            h().addAll(0, arrayList);
        } else {
            h().addAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(long j3, final u this$0, final int i3, final boolean z16, final PAGetPhotoTabRsp pAGetPhotoTabRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!pAGetPhotoTabRsp.isFromCache) {
            mc.c.f416541a.e("getPhotoTab", System.currentTimeMillis() - j3, pAGetPhotoTabRsp.result);
        }
        RFWLog.e("QZAlbumxTabPicRepo", RFWLog.USR, "requestTabList traceId:" + pAGetPhotoTabRsp.traceId + " result:" + pAGetPhotoTabRsp.result + " errmsg:" + pAGetPhotoTabRsp.errMs + "attachInfo:" + pAGetPhotoTabRsp.attachInfo);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ub.s
            @Override // java.lang.Runnable
            public final void run() {
                u.T(u.this, i3, pAGetPhotoTabRsp, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(long j3, final u this$0, final int i3, final PAGetPhotoTabByTimeLineRsp pAGetPhotoTabByTimeLineRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mc.c.f416541a.e("getPhotoTabByTimeLine", System.currentTimeMillis() - j3, pAGetPhotoTabByTimeLineRsp.result);
        RFWLog.e("QZAlbumxTabPicRepo", RFWLog.USR, "getPhotoTabByTimeLine traceId:" + pAGetPhotoTabByTimeLineRsp.traceId + " result:" + pAGetPhotoTabByTimeLineRsp.result + " errmsg:" + pAGetPhotoTabByTimeLineRsp.errMs);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ub.t
            @Override // java.lang.Runnable
            public final void run() {
                u.V(u.this, i3, pAGetPhotoTabByTimeLineRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(u this$0, int i3, PAGetPhotoTabByTimeLineRsp it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        int i16 = it.result;
        String str = it.errMs;
        Intrinsics.checkNotNullExpressionValue(str, "it.errMs");
        ArrayList<PhotoInfo> arrayList = it.photos;
        Intrinsics.checkNotNullExpressionValue(arrayList, "it.photos");
        boolean z16 = it.preHasMore;
        boolean z17 = it.nextHasMore;
        String str2 = it.attachInfo;
        Intrinsics.checkNotNullExpressionValue(str2, "it.attachInfo");
        PageEndMsg pageEndMsg = it.endMsg;
        Intrinsics.checkNotNullExpressionValue(pageEndMsg, "it.endMsg");
        this$0.Q(i3, i16, str, arrayList, z16, z17, str2, pageEndMsg);
    }

    public final cb.a N(int updateType, int result, String errMsg, boolean isNeedScrollToFirst) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        cb.a aVar = new cb.a();
        aVar.z(getUin());
        aVar.D(updateType);
        aVar.B(h());
        aVar.C(f());
        aVar.y(getPhotoNum());
        aVar.E(getVideoNum());
        aVar.A(result);
        aVar.t(errMsg);
        CommonPageEndMsg pageEndMsg = getPageEndMsg();
        if (pageEndMsg == null) {
            pageEndMsg = new CommonPageEndMsg();
        }
        aVar.x(pageEndMsg);
        aVar.w(isNeedScrollToFirst);
        aVar.r();
        return aVar;
    }

    @Override // ub.p
    public void x(final int loadType, boolean enableCache, final boolean isNeedScrollToFirst) {
        String attachInfo;
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        PAGetPhotoTabReq pAGetPhotoTabReq = new PAGetPhotoTabReq();
        pAGetPhotoTabReq.requestTimeLine.requestInvokeTime = currentTimeMillis;
        pAGetPhotoTabReq.owner.uin = getUin();
        if (loadType == 1) {
            attachInfo = "";
        } else {
            attachInfo = getAttachInfo();
        }
        pAGetPhotoTabReq.attachInfo = attachInfo;
        if (enableCache) {
            pAGetPhotoTabReq.enableCache = true;
            pAGetPhotoTabReq.canReadCache = true;
        }
        b16.getPhotoTab(pAGetPhotoTabReq, new IPersonalAlbumServiceGetPhotoTabCallback() { // from class: ub.q
            @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoTabCallback
            public final void onGetPhotoTab(PAGetPhotoTabRsp pAGetPhotoTabRsp) {
                u.S(currentTimeMillis, this, loadType, isNeedScrollToFirst, pAGetPhotoTabRsp);
            }
        });
    }

    @Override // ub.p
    public void y(final int loadType, CommonStTimeLineEvent event) {
        String attachInfo;
        Intrinsics.checkNotNullParameter(event, "event");
        F(true);
        A(event);
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        PAGetPhotoTabByTimeLineReq pAGetPhotoTabByTimeLineReq = new PAGetPhotoTabByTimeLineReq();
        pAGetPhotoTabByTimeLineReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        pAGetPhotoTabByTimeLineReq.owner.uin = getUin();
        if (loadType == 1) {
            attachInfo = "";
        } else {
            attachInfo = getAttachInfo();
        }
        pAGetPhotoTabByTimeLineReq.attachInfo = attachInfo;
        pAGetPhotoTabByTimeLineReq.timeLineParam.event = com.qzone.reborn.albumx.qzonex.utils.g.f53410a.c(event);
        pAGetPhotoTabByTimeLineReq.timeLineParam.type = loadType;
        b16.getPhotoTabByTimeLine(pAGetPhotoTabByTimeLineReq, new IPersonalAlbumServiceGetPhotoTabByTimeLineCallback() { // from class: ub.r
            @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoTabByTimeLineCallback
            public final void onGetPhotoTabByTimeLine(PAGetPhotoTabByTimeLineRsp pAGetPhotoTabByTimeLineRsp) {
                u.U(currentTimeMillis, this, loadType, pAGetPhotoTabByTimeLineRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(u this$0, int i3, PAGetPhotoTabRsp it, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        int i16 = it.result;
        String str = it.errMs;
        Intrinsics.checkNotNullExpressionValue(str, "it.errMs");
        int i17 = it.photoNum;
        int i18 = it.videoNum;
        ArrayList<PhotoInfo> arrayList = it.photos;
        Intrinsics.checkNotNullExpressionValue(arrayList, "it.photos");
        boolean z17 = it.hasMore;
        String str2 = it.attachInfo;
        Intrinsics.checkNotNullExpressionValue(str2, "it.attachInfo");
        StTimeLine stTimeLine = it.timeLine;
        Intrinsics.checkNotNullExpressionValue(stTimeLine, "it.timeLine");
        PageEndMsg pageEndMsg = it.endMsg;
        Intrinsics.checkNotNullExpressionValue(pageEndMsg, "it.endMsg");
        this$0.P(i3, i16, str, i17, i18, arrayList, z17, str2, stTimeLine, pageEndMsg, z16);
    }

    public static /* synthetic */ cb.a O(u uVar, int i3, int i16, String str, boolean z16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            z16 = false;
        }
        return uVar.N(i3, i16, str, z16);
    }

    private final void Q(int loadType, int result, String errMsg, ArrayList<PhotoInfo> medias, boolean prevHasMore, boolean nextHasMore, String attachInfo, PageEndMsg endMsg) {
        if (result != 0) {
            p(O(this, loadType, result, errMsg, false, 8, null));
            return;
        }
        if (loadType == 1) {
            v();
        }
        R(medias, loadType);
        z(attachInfo);
        E(prevHasMore);
        B(nextHasMore);
        C(fb.a.l(endMsg));
        p(O(this, loadType, result, errMsg, false, 8, null));
    }
}
