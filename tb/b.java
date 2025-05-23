package tb;

import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.qzone.reborn.albumx.qzonex.utils.i;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.z;
import com.tencent.qqnt.kernel.nativeinterface.AlbumListReqScene;
import com.tencent.qqnt.kernel.nativeinterface.AlbumPageInfo;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumListCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumListRsp;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\t\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\b\u0012\u00060\u0002R\u00020\u0000\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Ltb/b;", "Lcom/tencent/mobileqq/engineering/preload/BasePreLoadTask;", "Ltb/b$b;", "Lcom/tencent/mobileqq/engineering/preload/inter/OnPreLoadListener;", "preLoadListener", "", "startLoadData", "onRemove", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", "a", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", "getInitBean", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", "initBean", "<init>", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;)V", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends BasePreLoadTask<C11280b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final QZAlbumxMainPageInitBean initBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Ltb/b$b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumListRsp;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumListRsp;", "()Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumListRsp;", "setResponse", "(Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumListRsp;)V", "response", "<init>", "(Ltb/b;Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumListRsp;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tb.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public final class C11280b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private PAGetAlbumListRsp response;

        public C11280b(PAGetAlbumListRsp pAGetAlbumListRsp) {
            this.response = pAGetAlbumListRsp;
        }

        /* renamed from: a, reason: from getter */
        public final PAGetAlbumListRsp getResponse() {
            return this.response;
        }
    }

    public b(QZAlbumxMainPageInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(final OnPreLoadListener<C11280b> preLoadListener) {
        QLog.d("QZAlbumxAlbumListPreLoaderTask", 1, "prefetch: CmdName: getAlbumList , uin=" + this.initBean.getUin());
        PAGetAlbumListReq pAGetAlbumListReq = new PAGetAlbumListReq();
        final long currentTimeMillis = System.currentTimeMillis();
        pAGetAlbumListReq.user.uin = this.initBean.getUin();
        pAGetAlbumListReq.attachInfo = "";
        pAGetAlbumListReq.requestTimeLine.requestInvokeTime = currentTimeMillis;
        pAGetAlbumListReq.count = 10;
        pAGetAlbumListReq.scene = AlbumListReqScene.KALBUMLISTREQSCENEALBUMTAB.ordinal();
        pAGetAlbumListReq.enableCache = true;
        pAGetAlbumListReq.canReadCache = true;
        z b16 = i.b();
        if (b16 != null) {
            b16.getAlbumList(pAGetAlbumListReq, new IPersonalAlbumServiceGetAlbumListCallback() { // from class: tb.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumListCallback
                public final void onGetAlbumList(PAGetAlbumListRsp pAGetAlbumListRsp) {
                    b.b(currentTimeMillis, preLoadListener, this, pAGetAlbumListRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(long j3, OnPreLoadListener onPreLoadListener, b this$0, PAGetAlbumListRsp pAGetAlbumListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = pAGetAlbumListRsp.seq;
        String str = pAGetAlbumListRsp.traceId;
        int i16 = pAGetAlbumListRsp.result;
        String str2 = pAGetAlbumListRsp.errMs;
        String str3 = pAGetAlbumListRsp.attachInfo;
        boolean z16 = pAGetAlbumListRsp.hasMore;
        AlbumPageInfo albumPageInfo = pAGetAlbumListRsp.pageInfo;
        QLog.i("QZAlbumxAlbumListPreLoaderTask", 1, "handleAlbumListRsp seq:" + i3 + " | traceId:" + str + " | resultCode:" + i16 + " | errMsg:" + str2 + " | attachInfo:" + str3 + " | hasMore:" + z16 + " | albumNum:" + albumPageInfo.albumNum + " | photoNum:" + albumPageInfo.photoNum + " | videoNum:" + albumPageInfo.videoNum + " | masks:" + Arrays.toString(albumPageInfo.masks.toArray()) + " | isFromCache:" + pAGetAlbumListRsp.isFromCache);
        if (!pAGetAlbumListRsp.isFromCache) {
            mc.c.f416541a.e("getAlbumList", System.currentTimeMillis() - j3, pAGetAlbumListRsp.result);
        }
        if (onPreLoadListener != null) {
            onPreLoadListener.onLoaded(new C11280b(pAGetAlbumListRsp));
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
