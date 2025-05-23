package tb;

import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.utils.i;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.z;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoListCallback;
import com.tencent.qqnt.kernel.nativeinterface.MediaScene;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetPhotoListRsp;
import cooperation.qzone.QZoneHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\t\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\b\u0012\u00060\u0002R\u00020\u0000\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Ltb/d;", "Lcom/tencent/mobileqq/engineering/preload/BasePreLoadTask;", "Ltb/d$b;", "Lcom/tencent/mobileqq/engineering/preload/inter/OnPreLoadListener;", "preLoadListener", "", "startLoadData", "onRemove", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "a", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "getInitBean", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "initBean", "<init>", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;)V", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends BasePreLoadTask<b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final QZAlbumxAlbumDetailInitBean initBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Ltb/d$b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoListRsp;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoListRsp;", "()Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoListRsp;", "setResponse", "(Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoListRsp;)V", "response", "<init>", "(Ltb/d;Lcom/tencent/qqnt/kernel/nativeinterface/PAGetPhotoListRsp;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private PAGetPhotoListRsp response;

        public b(PAGetPhotoListRsp pAGetPhotoListRsp) {
            this.response = pAGetPhotoListRsp;
        }

        /* renamed from: a, reason: from getter */
        public final PAGetPhotoListRsp getResponse() {
            return this.response;
        }
    }

    public d(QZAlbumxAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(final OnPreLoadListener<b> preLoadListener) {
        int ordinal;
        QLog.d("QZAlbumxDetailListPreLoaderTask", 1, "prefetch: CmdName: getAlbumList , uin=" + this.initBean.getUin());
        PAGetPhotoListReq pAGetPhotoListReq = new PAGetPhotoListReq();
        pAGetPhotoListReq.owner.uin = this.initBean.getUin();
        pAGetPhotoListReq.albumId = this.initBean.getAlbumId();
        pAGetPhotoListReq.curLloc = "";
        if (this.initBean.getSortType() != null) {
            ordinal = MediaScene.KMEDIASCENEALBUMPAGE.ordinal();
        } else {
            ordinal = MediaScene.KMEDIASCENEUNKNOWN.ordinal();
        }
        pAGetPhotoListReq.scene = ordinal;
        Integer sortType = this.initBean.getSortType();
        pAGetPhotoListReq.sortType = sortType != null ? sortType.intValue() : 0;
        pAGetPhotoListReq.attachInfo = "";
        pAGetPhotoListReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        pAGetPhotoListReq.enableCache = true;
        pAGetPhotoListReq.canReadCache = true;
        final long currentTimeMillis = System.currentTimeMillis();
        z b16 = i.b();
        if (b16 != null) {
            b16.getPhotoList(pAGetPhotoListReq, new IPersonalAlbumServiceGetPhotoListCallback() { // from class: tb.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetPhotoListCallback
                public final void onGetPhotoList(PAGetPhotoListRsp pAGetPhotoListRsp) {
                    d.b(currentTimeMillis, preLoadListener, this, pAGetPhotoListRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(long j3, OnPreLoadListener onPreLoadListener, d this$0, PAGetPhotoListRsp pAGetPhotoListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = pAGetPhotoListRsp.seq;
        long currentTimeMillis = System.currentTimeMillis() - j3;
        String str = pAGetPhotoListRsp.traceId;
        int i16 = pAGetPhotoListRsp.result;
        String str2 = pAGetPhotoListRsp.errMs;
        String str3 = pAGetPhotoListRsp.attachInfo;
        boolean z16 = pAGetPhotoListRsp.hasMore;
        AlbumInfo albumInfo = pAGetPhotoListRsp.albumInfo;
        QLog.i("QZAlbumxDetailListPreLoaderTask", 1, "requestGetAlbumBatchList seq:" + i3 + " | requestCostTime:" + currentTimeMillis + " | traceId:" + str + " | resultCode:" + i16 + " | errMsg:" + str2 + " | attachInfo:" + str3 + " | hasMore:" + z16 + " | albumId:" + albumInfo.albumId + " | albumName:" + albumInfo.name + " | batchSize:" + pAGetPhotoListRsp.batchList.size() + " | mediasSize:" + pAGetPhotoListRsp.medias.size() + " | isFromCache:" + pAGetPhotoListRsp.isFromCache);
        if (!pAGetPhotoListRsp.isFromCache) {
            mc.c.f416541a.e(QZoneHelper.QZoneAppConstants.REFER_PHOTO_LIST, System.currentTimeMillis() - j3, pAGetPhotoListRsp.result);
        }
        if (onPreLoadListener != null) {
            onPreLoadListener.onLoaded(new b(pAGetPhotoListRsp));
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
