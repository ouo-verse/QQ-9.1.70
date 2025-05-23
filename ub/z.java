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
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetVideoTabByTimeLineCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetVideoTabCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAGetVideoTabByTimeLineReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetVideoTabByTimeLineRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAGetVideoTabReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetVideoTabRsp;
import com.tencent.qqnt.kernel.nativeinterface.PageEndMsg;
import com.tencent.qqnt.kernel.nativeinterface.PhotoInfo;
import com.tencent.qqnt.kernel.nativeinterface.StTimeLine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$Jv\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0002Jd\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\n2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J,\u0010\u001a\u001a\u00020\u00142\u001a\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0016J(\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\fJ\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016\u00a8\u0006'"}, d2 = {"Lub/z;", "Lub/p;", "", "loadType", "result", "", "errMsg", "videoNum", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/PhotoInfo;", "Lkotlin/collections/ArrayList;", "videos", "", "hasMore", "attachInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/StTimeLine;", "timeLine", "Lcom/tencent/qqnt/kernel/nativeinterface/PageEndMsg;", "endMsg", "isNeedScrollToFirst", "", "P", "prevHasMore", "nextHasMore", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "medias", BdhLogUtil.LogTag.Tag_Req, VideoProxy.PARAM_ENABLE_CACHE, HippyTKDListViewAdapter.X, "updateType", "Lcb/a;", "N", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "event", "y", "<init>", "()V", "o", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class z extends p {
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
    public static final void S(long j3, final z this$0, final int i3, final boolean z16, final PAGetVideoTabRsp pAGetVideoTabRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!pAGetVideoTabRsp.isFromCache) {
            mc.c.f416541a.e("getVideoTab", System.currentTimeMillis() - j3, pAGetVideoTabRsp.result);
        }
        int i16 = pAGetVideoTabRsp.result;
        if (i16 != 0) {
            RFWLog.e("QZAlbumxTabVideoRepo", RFWLog.USR, "getVideoTab seq:" + pAGetVideoTabRsp.seq + " result:" + i16 + " errmsg:" + pAGetVideoTabRsp.errMs);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ub.x
            @Override // java.lang.Runnable
            public final void run() {
                z.T(z.this, i3, pAGetVideoTabRsp, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(z this$0, int i3, PAGetVideoTabRsp it, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        int i16 = it.result;
        String str = it.errMs;
        Intrinsics.checkNotNullExpressionValue(str, "it.errMs");
        int i17 = it.videoNum;
        ArrayList<PhotoInfo> arrayList = it.videos;
        Intrinsics.checkNotNullExpressionValue(arrayList, "it.videos");
        boolean z17 = it.hasMore;
        String str2 = it.attachInfo;
        Intrinsics.checkNotNullExpressionValue(str2, "it.attachInfo");
        StTimeLine stTimeLine = it.timeLine;
        Intrinsics.checkNotNullExpressionValue(stTimeLine, "it.timeLine");
        PageEndMsg pageEndMsg = it.endMsg;
        Intrinsics.checkNotNullExpressionValue(pageEndMsg, "it.endMsg");
        this$0.P(i3, i16, str, i17, arrayList, z17, str2, stTimeLine, pageEndMsg, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(long j3, final z this$0, final int i3, final PAGetVideoTabByTimeLineRsp pAGetVideoTabByTimeLineRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mc.c.f416541a.e("getVideoTabByTimeLine", System.currentTimeMillis() - j3, pAGetVideoTabByTimeLineRsp.result);
        int i16 = pAGetVideoTabByTimeLineRsp.result;
        if (i16 != 0) {
            RFWLog.e("QZAlbumxTabVideoRepo", RFWLog.USR, "getVideoTabByTimeLine seq:" + pAGetVideoTabByTimeLineRsp.seq + " result:" + i16 + " errmsg:" + pAGetVideoTabByTimeLineRsp.errMs);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ub.y
            @Override // java.lang.Runnable
            public final void run() {
                z.V(z.this, i3, pAGetVideoTabByTimeLineRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(z this$0, int i3, PAGetVideoTabByTimeLineRsp it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        int i16 = it.result;
        String str = it.errMs;
        Intrinsics.checkNotNullExpressionValue(str, "it.errMs");
        ArrayList<PhotoInfo> arrayList = it.videos;
        Intrinsics.checkNotNullExpressionValue(arrayList, "it.videos");
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
        PAGetVideoTabReq pAGetVideoTabReq = new PAGetVideoTabReq();
        pAGetVideoTabReq.requestTimeLine.requestInvokeTime = currentTimeMillis;
        pAGetVideoTabReq.owner.uin = getUin();
        if (loadType == 1) {
            attachInfo = "";
        } else {
            attachInfo = getAttachInfo();
        }
        pAGetVideoTabReq.attachInfo = attachInfo;
        if (enableCache) {
            pAGetVideoTabReq.enableCache = true;
            pAGetVideoTabReq.canReadCache = true;
        }
        b16.getVideoTab(pAGetVideoTabReq, new IPersonalAlbumServiceGetVideoTabCallback() { // from class: ub.v
            @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetVideoTabCallback
            public final void onGetVideoTab(PAGetVideoTabRsp pAGetVideoTabRsp) {
                z.S(currentTimeMillis, this, loadType, isNeedScrollToFirst, pAGetVideoTabRsp);
            }
        });
    }

    @Override // ub.p
    public void y(final int loadType, CommonStTimeLineEvent event) {
        String attachInfo;
        Intrinsics.checkNotNullParameter(event, "event");
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        PAGetVideoTabByTimeLineReq pAGetVideoTabByTimeLineReq = new PAGetVideoTabByTimeLineReq();
        pAGetVideoTabByTimeLineReq.requestTimeLine.requestInvokeTime = currentTimeMillis;
        pAGetVideoTabByTimeLineReq.owner.uin = getUin();
        if (loadType == 1) {
            attachInfo = "";
        } else {
            attachInfo = getAttachInfo();
        }
        pAGetVideoTabByTimeLineReq.attachInfo = attachInfo;
        pAGetVideoTabByTimeLineReq.timeLineParam.event = com.qzone.reborn.albumx.qzonex.utils.g.f53410a.c(event);
        pAGetVideoTabByTimeLineReq.timeLineParam.type = loadType;
        b16.getVideoTabByTimeLine(pAGetVideoTabByTimeLineReq, new IPersonalAlbumServiceGetVideoTabByTimeLineCallback() { // from class: ub.w
            @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetVideoTabByTimeLineCallback
            public final void onGetVideoTabByTimeLine(PAGetVideoTabByTimeLineRsp pAGetVideoTabByTimeLineRsp) {
                z.U(currentTimeMillis, this, loadType, pAGetVideoTabByTimeLineRsp);
            }
        });
    }

    public static /* synthetic */ cb.a O(z zVar, int i3, int i16, String str, boolean z16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            z16 = false;
        }
        return zVar.N(i3, i16, str, z16);
    }

    private final void P(int loadType, int result, String errMsg, int videoNum, ArrayList<PhotoInfo> videos, boolean hasMore, String attachInfo, StTimeLine timeLine, PageEndMsg endMsg, boolean isNeedScrollToFirst) {
        if (result != 0) {
            p(O(this, loadType, result, errMsg, false, 8, null));
            return;
        }
        if (loadType == 1) {
            u();
        }
        H(videoNum);
        ArrayList arrayList = new ArrayList();
        for (PhotoInfo photoInfo : videos) {
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

    private final void Q(int loadType, int result, String errMsg, ArrayList<PhotoInfo> videos, boolean prevHasMore, boolean nextHasMore, String attachInfo, PageEndMsg endMsg) {
        if (result != 0) {
            p(O(this, loadType, result, errMsg, false, 8, null));
            return;
        }
        if (loadType == 1) {
            v();
        }
        R(videos, loadType);
        z(attachInfo);
        E(prevHasMore);
        B(nextHasMore);
        C(fb.a.l(endMsg));
        p(O(this, loadType, result, errMsg, false, 8, null));
    }
}
