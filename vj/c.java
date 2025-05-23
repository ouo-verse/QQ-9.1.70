package vj;

import ak.b;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumCommData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStVideo;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.event.QZoneIntimateEditAlbumEvent;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.qzone.reborn.intimate.request.QZoneIntimateGetMediasListRequest;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import qzone.QZIntimateSpaceAlbum$AlbumCommData;
import qzone.QZIntimateSpaceAlbum$GetMediasListRsp;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;
import qzone.QZoneBaseAlbumMeta$BatchInfo;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StMedia;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0002AIB\u0007\u00a2\u0006\u0004\bw\u0010xJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J2\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0002J \u0010\u0019\u001a\u00020\t2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017H\u0002J \u0010\u001a\u001a\u00020\t2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017H\u0002J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0002J2\u0010\"\u001a\u00020\u00042\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J8\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0002J\u001a\u0010+\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001fH\u0002J\u0018\u0010/\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020-H\u0002J\u000e\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200J\u000e\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203J\u000e\u00106\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00107\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\tJ&\u00109\u001a\u00020\u00042\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00172\u0006\u00108\u001a\u00020\u000fJ\u0006\u0010:\u001a\u00020\u000fJ\u0006\u0010;\u001a\u00020\tJ\u0016\u0010=\u001a\u0002032\u0006\u0010<\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u000fJ\u000e\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u000203R2\u0010G\u001a\u0012\u0012\u0004\u0012\u00020@0\u0015j\b\u0012\u0004\u0012\u00020@`\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010O\u001a\u00020H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010SR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020(0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010UR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020-0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u0018\u0010[\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\\R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010^R\"\u00108\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010i\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010o\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010v\u001a\u0004\u0018\u00010p8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010u\u00a8\u0006y"}, d2 = {"Lvj/c;", "", "Lsj/c;", "requestBean", "", "D", "Lsj/b;", "i", h.F, "", "d", "e", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/QZIntimateSpaceAlbum$GetMediasListRsp;", "rsp", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, DomainData.DOMAIN_NAME, "Ljava/util/ArrayList;", "Lqzone/QZoneBaseMeta$StMedia;", "Lkotlin/collections/ArrayList;", "mediaList", ReportConstant.COSTREPORT_PREFIX, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Lqzone/QZoneBaseAlbumMeta$BatchInfo;", "batchList", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "commonExt", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "req", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "g", "j", "lLoc", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "p", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "bean", BdhLogUtil.LogTag.Tag_Conn, "", "right", "E", "w", "u", "spaceId", "r", "k", "o", "batchId", "c", "hashCode", HippyTKDListViewAdapter.X, "Lvj/c$b;", "a", "Ljava/util/ArrayList;", "l", "()Ljava/util/ArrayList;", "setListenerList", "(Ljava/util/ArrayList;)V", "listenerList", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "b", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "setLoadInfo", "(Lcom/tencent/biz/richframework/part/block/base/LoadInfo;)V", "loadInfo", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "initBean", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "commData", "Ljava/util/List;", "allBatch", "f", "mediaInfoList", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfoData", "Lsj/c;", "layerRequestBean", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "Ljava/lang/String;", "getSpaceId", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "I", "getRightBoundIndex", "()I", "setRightBoundIndex", "(I)V", "rightBoundIndex", "Z", "getRightHasMore", "()Z", "setRightHasMore", "(Z)V", "rightHasMore", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "getCurrentExtraInfo", "()Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "B", "(Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;)V", "currentExtraInfo", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateAlbumDetailInitBean initBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumCommData commData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumInfo albumInfoData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private sj.c layerRequestBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommonStCommonExt commonExt;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int rightBoundIndex;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean rightHasMore;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZIntimateLayerExtraInfoBean currentExtraInfo;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ArrayList<b> listenerList = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<com.qzone.reborn.albumx.common.bean.a> allBatch = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<CommonStMedia> mediaInfoList = new ArrayList();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String spaceId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lvj/c$b;", "", "Lsj/a;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public interface b {
        void a(sj.a repoBean);
    }

    private final void A(String msg2, boolean isSuccess, BaseRequest req, long retCode, String errMsg, boolean isLoadMore) {
        QLog.i("QZIntimateAlbumDetailRepo", 1, msg2 + " responseLog onReceive, isSuccess: " + isSuccess + " | traceId: " + req.getTraceId() + " | seqId:" + req.getCurrentSeq() + " | cmdName:" + req.get$cmd() + " | retCode:" + retCode + " | retMessage:" + errMsg + " | isLoadMore:" + isLoadMore);
    }

    private final void D(sj.c requestBean) {
        sj.b h16 = h(requestBean);
        sj.a aVar = new sj.a();
        aVar.v(h16);
        aVar.p(true);
        aVar.t(this.mediaInfoList.size() - 1);
        Iterator<b> it = this.listenerList.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    private final boolean d() {
        if (!PreLoader.exists("album_detail_batch_data_preload_id")) {
            return false;
        }
        QLog.d("QZIntimateAlbumDetailRepo", 1, "canFetchDataFromPreloadTask from preload task");
        e();
        return true;
    }

    private final void e() {
        PreLoader.addListener("album_detail_batch_data_preload_id", new OnTaskListener() { // from class: vj.b
            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            public final void onComplete(Object[] objArr) {
                c.f(c.this, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0, Object[] objArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (objArr == null || objArr.length != 1) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof b.C0041b) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.intimate.preload.QZoneIntimateAlbumDetailPreLoaderTask.RspBean");
            b.C0041b c0041b = (b.C0041b) obj;
            this$0.n(c0041b.getIsSuccess(), c0041b.getRetCode(), c0041b.getErrMsg(), c0041b.getRsp(), false);
        }
    }

    private final void g(com.qzone.reborn.albumx.common.bean.a batchBean) {
        List reversed;
        batchBean.k(batchBean.getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String());
        reversed = CollectionsKt___CollectionsKt.reversed(this.allBatch);
        Iterator it = reversed.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((com.qzone.reborn.albumx.common.bean.a) it.next()).getTimeId(), batchBean.getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String())) {
                batchBean.getBatchInfo().w("");
            }
        }
    }

    private final sj.b h(sj.c requestBean) {
        long coerceIn;
        String str;
        sj.b bVar = new sj.b();
        if (requestBean == null) {
            return bVar;
        }
        String stringAttachInfo = this.loadInfo.getStringAttachInfo();
        Intrinsics.checkNotNullExpressionValue(stringAttachInfo, "loadInfo.stringAttachInfo");
        bVar.a0(stringAttachInfo);
        bVar.s0(requestBean.getIsRefresh());
        bVar.n0(requestBean.getIsFetchLeft());
        bVar.o0(requestBean.getIsFetchRight());
        bVar.m0(requestBean.getIsDeleteChange());
        this.rightHasMore = !this.loadInfo.isFinish();
        bVar.q0(true);
        bVar.t0(!this.rightHasMore);
        CommonAlbumInfo commonAlbumInfo = this.albumInfoData;
        bVar.k(commonAlbumInfo != null ? commonAlbumInfo.getName() : null);
        CommonAlbumInfo commonAlbumInfo2 = this.albumInfoData;
        bVar.j(commonAlbumInfo2 != null ? commonAlbumInfo2.getAlbumId() : null);
        CommonAlbumInfo commonAlbumInfo3 = this.albumInfoData;
        coerceIn = RangesKt___RangesKt.coerceIn(commonAlbumInfo3 != null ? commonAlbumInfo3.getUploadNumber() : 0L, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, TTL.MAX_VALUE);
        bVar.r0((int) coerceIn);
        ArrayList arrayList = new ArrayList();
        if (bVar.getIsRefresh()) {
            Iterator<T> it = this.mediaInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(xh.e.i((CommonStMedia) it.next()));
            }
        } else if (this.rightBoundIndex + 1 <= this.mediaInfoList.size()) {
            List<CommonStMedia> list = this.mediaInfoList;
            Iterator<T> it5 = list.subList(this.rightBoundIndex + 1, list.size()).iterator();
            while (it5.hasNext()) {
                arrayList.add(xh.e.i((CommonStMedia) it5.next()));
            }
        }
        int size = this.mediaInfoList.size() - 1;
        this.rightBoundIndex = size;
        bVar.b0(size);
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = this.initBean;
        if (qZoneIntimateAlbumDetailInitBean == null || (str = qZoneIntimateAlbumDetailInitBean.getSpaceId()) == null) {
            str = "";
        }
        bVar.c0(str);
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean2 = this.initBean;
        bVar.d0(qZoneIntimateAlbumDetailInitBean2 != null ? qZoneIntimateAlbumDetailInitBean2.getSpaceType() : 0);
        bVar.x(new ArrayList<>(arrayList));
        return bVar;
    }

    private final sj.b i() {
        sj.c cVar = this.layerRequestBean;
        if (cVar != null) {
            cVar.q(true);
        }
        sj.c cVar2 = this.layerRequestBean;
        if (cVar2 != null) {
            cVar2.m(true);
        }
        sj.c cVar3 = this.layerRequestBean;
        if (cVar3 != null) {
            cVar3.n(true);
        }
        sj.c cVar4 = this.layerRequestBean;
        if (cVar4 != null) {
            cVar4.l(true);
        }
        return h(this.layerRequestBean);
    }

    private final String j(List<QZoneBaseAlbumMeta$BatchInfo> batchList) {
        StringBuilder sb5 = new StringBuilder();
        if (bl.b(batchList)) {
            return sb5.toString();
        }
        for (QZoneBaseAlbumMeta$BatchInfo qZoneBaseAlbumMeta$BatchInfo : batchList) {
            Intrinsics.checkNotNull(qZoneBaseAlbumMeta$BatchInfo);
            PBUInt64Field pBUInt64Field = qZoneBaseAlbumMeta$BatchInfo.batch_id;
            Intrinsics.checkNotNull(pBUInt64Field);
            sb5.append(pBUInt64Field.get());
            sb5.append(",");
        }
        return sb5.toString();
    }

    private final void n(boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceAlbum$GetMediasListRsp rsp, boolean isLoadMore) {
        List<QZoneBaseMeta$StMedia> list;
        this.loadInfo.setCurrentState(4);
        if (isSuccess && rsp != null && retCode == 0) {
            this.loadInfo.setStringAttachInfo(rsp.next_attach_info.get());
            QZIntimateSpaceAlbum$AlbumCommData qZIntimateSpaceAlbum$AlbumCommData = rsp.comm_data.get();
            Intrinsics.checkNotNullExpressionValue(qZIntimateSpaceAlbum$AlbumCommData, "rsp.comm_data.get()");
            this.commData = mj.a.a(qZIntimateSpaceAlbum$AlbumCommData);
            QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = rsp.ext.get();
            Intrinsics.checkNotNullExpressionValue(qZoneBaseCommon$StCommonExt, "rsp.ext.get()");
            this.commonExt = mj.a.d(qZoneBaseCommon$StCommonExt);
            if (!isLoadMore) {
                this.allBatch.clear();
            }
            q(rsp.batch_list.get(), rsp.medias.get(), this.commonExt);
            z(rsp, isLoadMore);
            String stringAttachInfo = this.loadInfo.getStringAttachInfo();
            boolean z16 = rsp.next_has_more.get();
            int size = rsp.batch_list.get().size();
            int size2 = this.allBatch.size();
            List<QZoneBaseAlbumMeta$BatchInfo> list2 = rsp.batch_list.get();
            Intrinsics.checkNotNullExpressionValue(list2, "rsp.batch_list.get()");
            String j3 = j(list2);
            PBRepeatMessageField<QZoneBaseMeta$StMedia> pBRepeatMessageField = rsp.medias;
            QLog.d("QZIntimateAlbumDetailRepo", 1, "[handleFeedListResponse]  | attachInfo: " + stringAttachInfo + " | hasMore: " + z16 + " | rsp.batch_list.size: " + size + " | allBatch.size: " + size2 + " | newBatchIdList = " + j3 + " | mediaList.size: " + ((pBRepeatMessageField == null || (list = pBRepeatMessageField.get()) == null) ? null : Integer.valueOf(list.size())));
            this.loadInfo.setFinish(rsp.next_has_more.get() ^ true);
            if (!isLoadMore) {
                QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo = rsp.album_info.get();
                Intrinsics.checkNotNullExpressionValue(qZoneBaseAlbumMeta$AlbumInfo, "rsp.album_info.get()");
                this.albumInfoData = mj.a.b(qZoneBaseAlbumMeta$AlbumInfo);
            }
            sj.a aVar = new sj.a();
            aVar.m(this.commData);
            aVar.l(this.allBatch);
            aVar.k(this.albumInfoData);
            aVar.n(this.commonExt);
            aVar.o(errMsg);
            aVar.s(retCode);
            aVar.q(isLoadMore);
            aVar.v(h(this.layerRequestBean));
            aVar.t(this.rightBoundIndex);
            Iterator<b> it = this.listenerList.iterator();
            while (it.hasNext()) {
                it.next().a(aVar);
            }
            return;
        }
        QLog.e("QZIntimateAlbumDetailRepo", 1, "handleFeedListResponse rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
    }

    private final boolean p(String lLoc, CommonStMedia media) {
        CommonStImage cover;
        if (media.getType() == CommonEnumMediaType.IMAGE.ordinal()) {
            CommonStImage image = media.getImage();
            return TextUtils.equals(image != null ? image.getLloc() : null, lLoc);
        }
        CommonStVideo video = media.getVideo();
        if (video != null && (cover = video.getCover()) != null) {
            r2 = cover.getLloc();
        }
        return TextUtils.equals(r2, lLoc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(c this$0, boolean z16, BaseRequest request1, boolean z17, long j3, String errMsg, QZIntimateSpaceAlbum$GetMediasListRsp qZIntimateSpaceAlbum$GetMediasListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request1, "request1");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.A("[requestGetAlbumBatchList]", z17, request1, j3, errMsg, z16);
        this$0.n(z17, j3, errMsg, qZIntimateSpaceAlbum$GetMediasListRsp, z16);
    }

    private final void y() {
        LoadInfo loadInfo = new LoadInfo();
        this.loadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.loadInfo.setFinish(false);
    }

    public final void B(QZIntimateLayerExtraInfoBean qZIntimateLayerExtraInfoBean) {
        this.currentExtraInfo = qZIntimateLayerExtraInfoBean;
    }

    public final void C(QZoneIntimateAlbumDetailInitBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        QLog.i("QZIntimateAlbumDetailRepo", 1, "hash code is " + bean.getViewModelHashCode());
        this.initBean = bean;
    }

    public final void E(int right) {
        this.rightBoundIndex = right;
    }

    public final int c(long batchId, String lLoc) {
        Intrinsics.checkNotNullParameter(lLoc, "lLoc");
        Iterator<com.qzone.reborn.albumx.common.bean.a> it = this.allBatch.iterator();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.qzone.reborn.albumx.common.bean.a next = it.next();
            if (next.getBatchInfo().getLinkId() == batchId) {
                List<CommonStMedia> j3 = next.getBatchInfo().j();
                if (!bl.b(j3)) {
                    Iterator<CommonStMedia> it5 = j3.iterator();
                    int i16 = 0;
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        if (p(lLoc, it5.next())) {
                            z16 = true;
                            break;
                        }
                        i16++;
                    }
                    i3 += i16;
                }
            } else {
                i3 += next.getBatchInfo().j().size();
            }
        }
        if (z16) {
            return i3;
        }
        return -1;
    }

    public final String k() {
        String emptyMessage;
        CommonAlbumCommData commonAlbumCommData = this.commData;
        return (commonAlbumCommData == null || (emptyMessage = commonAlbumCommData.getEmptyMessage()) == null) ? "" : emptyMessage;
    }

    public final ArrayList<b> l() {
        return this.listenerList;
    }

    /* renamed from: m, reason: from getter */
    public final LoadInfo getLoadInfo() {
        return this.loadInfo;
    }

    public final boolean o() {
        return this.loadInfo.isFinish();
    }

    public final void r(ArrayList<QZoneBaseMeta$StMedia> mediaList, String spaceId) {
        CommonAlbumInfo commonAlbumInfo;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        boolean s16 = s(mediaList);
        boolean t16 = t(mediaList);
        if (s16 && t16) {
            CommonAlbumInfo commonAlbumInfo2 = this.albumInfoData;
            long uploadNumber = (commonAlbumInfo2 != null ? commonAlbumInfo2.getUploadNumber() : 0L) - mediaList.size();
            if (uploadNumber >= 0 && (commonAlbumInfo = this.albumInfoData) != null) {
                commonAlbumInfo.y0(uploadNumber);
            }
            if (s16 && t16) {
                sj.a aVar = new sj.a();
                aVar.m(this.commData);
                aVar.l(this.allBatch);
                aVar.k(this.albumInfoData);
                aVar.n(this.commonExt);
                aVar.q(true);
                aVar.v(i());
                aVar.t(this.rightBoundIndex);
                Iterator<b> it = this.listenerList.iterator();
                while (it.hasNext()) {
                    it.next().a(aVar);
                }
                SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateEditAlbumEvent(spaceId, null, xh.e.f(this.albumInfoData), null, 10, null));
                return;
            }
            return;
        }
        RFWLog.e("QZIntimateAlbumDetailRepo", RFWLog.USR, "isFindInBatchList = " + s16 + " isFindInMediaInfoList = " + t16);
    }

    public final void w(sj.c requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (this.initBean == null) {
            RFWLog.e("QZIntimateAlbumDetailRepo", RFWLog.USR, "initBean is null");
            return;
        }
        this.layerRequestBean = requestBean;
        if (requestBean.getIsRefresh()) {
            D(requestBean);
        } else {
            u(true);
        }
    }

    public final void x(int hashCode) {
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = this.initBean;
        boolean z16 = false;
        if (qZoneIntimateAlbumDetailInitBean != null && hashCode == qZoneIntimateAlbumDetailInitBean.getViewModelHashCode()) {
            z16 = true;
        }
        if (!z16) {
            QLog.i("QZIntimateAlbumDetailRepo", 1, "not same hash code");
            return;
        }
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean2 = this.initBean;
        QLog.i("QZIntimateAlbumDetailRepo", 1, "resetAllAlbumInfo " + (qZoneIntimateAlbumDetailInitBean2 != null ? Integer.valueOf(qZoneIntimateAlbumDetailInitBean2.getViewModelHashCode()) : null));
        y();
        this.listenerList.clear();
        this.commData = null;
        this.allBatch.clear();
        this.mediaInfoList.clear();
        this.albumInfoData = null;
        this.commonExt = null;
        this.initBean = null;
        this.layerRequestBean = null;
        this.currentExtraInfo = null;
    }

    private final boolean s(ArrayList<QZoneBaseMeta$StMedia> mediaList) {
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<QZoneBaseMeta$StMedia> it = mediaList.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            QZoneBaseMeta$StMedia stMedia = it.next();
            d dVar = d.f441734a;
            Intrinsics.checkNotNullExpressionValue(stMedia, "stMedia");
            String j3 = dVar.j(stMedia);
            Iterator<com.qzone.reborn.albumx.common.bean.a> it5 = this.allBatch.iterator();
            while (true) {
                if (it5.hasNext()) {
                    com.qzone.reborn.albumx.common.bean.a next = it5.next();
                    if (next.getBatchInfo().getLinkId() == stMedia.batch_id.get()) {
                        List<CommonStMedia> j16 = next.getBatchInfo().j();
                        if (!bl.b(j16)) {
                            Iterator<CommonStMedia> it6 = j16.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    break;
                                }
                                if (p(j3, it6.next())) {
                                    it6.remove();
                                    next.getBatchInfo().z(next.getBatchInfo().getUploadNumber() - 1);
                                    if (next.getBatchInfo().j().size() == 0) {
                                        this.allBatch.remove(next);
                                        if ((!this.allBatch.isEmpty()) && Intrinsics.areEqual(this.allBatch.get(0).getTimeId(), next.getTimeId())) {
                                            if (this.allBatch.get(0).getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String().length() == 0) {
                                                this.allBatch.get(0).getBatchInfo().w(next.getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String());
                                            }
                                        }
                                    }
                                    z16 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z16;
    }

    private final boolean t(ArrayList<QZoneBaseMeta$StMedia> mediaList) {
        boolean z16 = false;
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<QZoneBaseMeta$StMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            QZoneBaseMeta$StMedia stMedia = it.next();
            d dVar = d.f441734a;
            Intrinsics.checkNotNullExpressionValue(stMedia, "stMedia");
            String j3 = dVar.j(stMedia);
            Iterator<CommonStMedia> it5 = this.mediaInfoList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                if (p(j3, it5.next())) {
                    it5.remove();
                    z16 = true;
                    break;
                }
            }
        }
        return z16;
    }

    private final void q(List<QZoneBaseAlbumMeta$BatchInfo> batchList, List<QZoneBaseMeta$StMedia> mediaList, CommonStCommonExt commonExt) {
        if (mediaList != null) {
            for (QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia : mediaList) {
                if (batchList != null) {
                    for (QZoneBaseAlbumMeta$BatchInfo qZoneBaseAlbumMeta$BatchInfo : batchList) {
                        if (qZoneBaseMeta$StMedia.batch_id.get() == qZoneBaseAlbumMeta$BatchInfo.batch_id.get()) {
                            qZoneBaseAlbumMeta$BatchInfo.medias.add(qZoneBaseMeta$StMedia);
                        }
                    }
                }
            }
        }
        int i3 = 0;
        if (!bl.b(batchList) && !bl.b(this.allBatch)) {
            Intrinsics.checkNotNull(batchList);
            long j3 = batchList.get(0).batch_id.get();
            List<com.qzone.reborn.albumx.common.bean.a> list = this.allBatch;
            if (j3 == list.get(list.size() - 1).getBatchInfo().getLinkId()) {
                List<QZoneBaseMeta$StMedia> list2 = batchList.get(0).medias.get();
                Intrinsics.checkNotNullExpressionValue(list2, "batchList[0].medias.get()");
                for (QZoneBaseMeta$StMedia it : list2) {
                    List<com.qzone.reborn.albumx.common.bean.a> list3 = this.allBatch;
                    List<CommonStMedia> j16 = list3.get(list3.size() - 1).getBatchInfo().j();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    j16.add(mj.b.b(it));
                }
                i3 = 1;
            }
        }
        QLog.d("QZIntimateAlbumDetailRepo", 1, "polymerizeBatchListData  startMergeBatchPos = " + i3);
        if (batchList != null) {
            int size = batchList.size();
            while (i3 < size) {
                com.qzone.reborn.albumx.common.bean.a aVar = new com.qzone.reborn.albumx.common.bean.a(mj.a.c(batchList.get(i3)));
                aVar.j(commonExt);
                g(aVar);
                this.allBatch.add(aVar);
                i3++;
            }
        }
    }

    public final void u(final boolean isLoadMore) {
        if (!isLoadMore) {
            y();
        }
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = this.initBean;
        if (qZoneIntimateAlbumDetailInitBean != null) {
            Intrinsics.checkNotNull(qZoneIntimateAlbumDetailInitBean);
            if (TextUtils.isEmpty(qZoneIntimateAlbumDetailInitBean.getAlbumId())) {
                return;
            }
            QLog.d("QZIntimateAlbumDetailRepo", 1, "requestGetAlbumBatchList  attachInfo : " + this.loadInfo.getStringAttachInfo() + " | isLoadMore : " + isLoadMore + " | initBean : " + this.initBean);
            if (isLoadMore || !d()) {
                if (isLoadMore && o()) {
                    return;
                }
                if (this.loadInfo.getCurrentState() != 4) {
                    QLog.w("QZIntimateAlbumDetailRepo", 1, "requestGetAlbumBatchList  mLoadInfo.currentState = " + this.loadInfo.getCurrentState());
                    return;
                }
                this.loadInfo.setCurrentState(2);
                VSNetworkHelper.getInstance().sendRequest(new QZoneIntimateGetMediasListRequest(this.initBean, this.loadInfo.getStringAttachInfo()), new VSDispatchObserver.OnVSRspCallBack() { // from class: vj.a
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        c.v(c.this, isLoadMore, baseRequest, z16, j3, str, (QZIntimateSpaceAlbum$GetMediasListRsp) obj);
                    }
                });
            }
        }
    }

    private final void z(QZIntimateSpaceAlbum$GetMediasListRsp rsp, boolean isLoadMore) {
        if (rsp == null) {
            return;
        }
        if (!isLoadMore) {
            this.mediaInfoList.clear();
            QLog.i("QZIntimateAlbumDetailRepo", 1, "media list size is` " + rsp.medias.get().size());
            List<QZoneBaseMeta$StMedia> list = rsp.medias.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.medias.get()");
            for (QZoneBaseMeta$StMedia it : list) {
                List<CommonStMedia> list2 = this.mediaInfoList;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                list2.add(mj.b.b(it));
            }
            return;
        }
        QLog.i("QZIntimateAlbumDetailRepo", 1, "media list size is1 " + rsp.medias.get().size());
        List<QZoneBaseMeta$StMedia> list3 = rsp.medias.get();
        Intrinsics.checkNotNullExpressionValue(list3, "rsp.medias.get()");
        for (QZoneBaseMeta$StMedia it5 : list3) {
            List<CommonStMedia> list4 = this.mediaInfoList;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            list4.add(mj.b.b(it5));
        }
    }
}
