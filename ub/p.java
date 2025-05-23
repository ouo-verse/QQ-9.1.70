package ub;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonPageEndMsg;
import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxTabLayerDeleteMediaEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 A2\u00020\u0001:\u0002\u001f3B\u0007\u00a2\u0006\u0004\bb\u0010cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\u001f\u001a\u00020\u00042\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J \u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH&J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0010H&J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'J\u001c\u0010-\u001a\u00020\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0*2\u0006\u0010,\u001a\u00020\u000eR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u00109\u001a\b\u0012\u0004\u0012\u00020\u00130*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010:R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0*8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b<\u00106R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00100*8\u0006\u00a2\u0006\f\n\u0004\b>\u00104\u001a\u0004\b?\u00106R\"\u0010E\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u0005\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010H\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0005\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR\"\u0010J\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010.\u001a\u0004\b>\u00100\"\u0004\bI\u00102R\"\u0010Q\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010T\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010L\u001a\u0004\bK\u0010N\"\u0004\bS\u0010PR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010L\u001a\u0004\b\u000f\u0010N\"\u0004\bU\u0010PR$\u0010[\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010a\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010]\u001a\u0004\bR\u0010^\"\u0004\b_\u0010`\u00a8\u0006d"}, d2 = {"Lub/p;", "Lub/a;", "Lbb/g;", "requestBean", "", "I", "Lbb/i;", "d", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "photoInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "uin", "o", "", "isTimeline", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "curEvent", "G", "Lub/p$b;", "listener", ReportConstant.COSTREPORT_PREFIX, "t", "u", "v", "w", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lkotlin/collections/ArrayList;", "mediaList", "spaceId", "a", "", "loadType", VideoProxy.PARAM_ENABLE_CACHE, "isNeedScrollToFirst", HippyTKDListViewAdapter.X, "event", "y", "Lcb/a;", "repoBean", "p", "", "preloadList", "isUpTurning", "c", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "b", "Ljava/util/List;", "g", "()Ljava/util/List;", "setListenerList", "(Ljava/util/List;)V", "listenerList", "Lbb/g;", "layerRequestBean", tl.h.F, "mediaInfoList", "e", "f", "eventList", DomainData.DOMAIN_NAME, "()I", "H", "(I)V", "videoNum", "k", "D", "photoNum", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "attachInfo", "i", "Z", "l", "()Z", "E", "(Z)V", "prevHasMore", "j", "B", "nextHasMore", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "getCurTimeLineEvent", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;)V", "curTimeLineEvent", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;)V", "pageEndMsg", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class p implements a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private bb.g layerRequestBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int videoNum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int photoNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean prevHasMore;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean nextHasMore;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isTimeline;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private CommonStTimeLineEvent curTimeLineEvent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private CommonPageEndMsg pageEndMsg;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String uin = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<b> listenerList = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<CommonPhotoInfo> mediaInfoList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<CommonStTimeLineEvent> eventList = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String attachInfo = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lub/p$b;", "", "Lcb/a;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public interface b {
        void a(cb.a repoBean);
    }

    private final void I(bb.g requestBean) {
        bb.i d16 = d(requestBean);
        cb.a aVar = new cb.a();
        aVar.v(d16);
        aVar.u(true);
        p(aVar);
    }

    private final bb.i d(bb.g requestBean) {
        bb.i iVar = new bb.i();
        if (requestBean == null) {
            return iVar;
        }
        iVar.j0(this.attachInfo);
        iVar.w0(requestBean.getIsRefresh());
        iVar.s0(requestBean.getIsFetchLeft());
        iVar.t0(requestBean.getIsFetchRight());
        iVar.u0(this.prevHasMore);
        iVar.x0(this.nextHasMore);
        iVar.v0(this.photoNum + this.videoNum);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mediaInfoList);
        String uin = requestBean.getUin();
        if (uin == null) {
            uin = "";
        }
        iVar.k0(uin);
        iVar.n0(new ArrayList<>(arrayList));
        return iVar;
    }

    private final void q(final CommonPhotoInfo photoInfo) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: ub.o
            @Override // java.lang.Runnable
            public final void run() {
                p.r(CommonPhotoInfo.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(CommonPhotoInfo photoInfo) {
        String e16;
        Intrinsics.checkNotNullParameter(photoInfo, "$photoInfo");
        if (photoInfo.getMedia().getType() != 1 && photoInfo.getMedia().getType() != 0) {
            e16 = "";
        } else if (!TextUtils.isEmpty(k9.a.g(photoInfo.getMedia()))) {
            e16 = k9.a.g(photoInfo.getMedia());
        } else {
            e16 = k9.a.e(photoInfo.getMedia(), 0, 1, null);
        }
        com.qzone.reborn.feedx.scroller.g.g(e16);
    }

    public final void A(CommonStTimeLineEvent commonStTimeLineEvent) {
        this.curTimeLineEvent = commonStTimeLineEvent;
    }

    public final void B(boolean z16) {
        this.nextHasMore = z16;
    }

    public final void C(CommonPageEndMsg commonPageEndMsg) {
        this.pageEndMsg = commonPageEndMsg;
    }

    public final void D(int i3) {
        this.photoNum = i3;
    }

    public final void E(boolean z16) {
        this.prevHasMore = z16;
    }

    public final void F(boolean z16) {
        this.isTimeline = z16;
    }

    public final void G(boolean isTimeline, CommonStTimeLineEvent curEvent) {
        this.isTimeline = isTimeline;
        this.curTimeLineEvent = curEvent;
    }

    public final void H(int i3) {
        this.videoNum = i3;
    }

    @Override // ub.a
    public void a(ArrayList<CommonStMedia> mediaList, String spaceId) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Iterator<CommonStMedia> it = mediaList.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            CommonStMedia next = it.next();
            Iterator<CommonPhotoInfo> it5 = this.mediaInfoList.iterator();
            while (true) {
                if (it5.hasNext()) {
                    if (Intrinsics.areEqual(next.k(), it5.next().getMedia().m())) {
                        it5.remove();
                        if (next.u()) {
                            i16++;
                        } else {
                            i3++;
                        }
                    }
                }
            }
        }
        this.photoNum -= i3;
        this.videoNum -= i16;
        bb.i d16 = d(this.layerRequestBean);
        cb.a aVar = new cb.a();
        aVar.v(d16);
        aVar.u(true);
        p(aVar);
        SimpleEventBus.getInstance().dispatchEvent(new QZAlbumxTabLayerDeleteMediaEvent(i16, i3));
    }

    public final void c(List<CommonPhotoInfo> preloadList, boolean isUpTurning) {
        Intrinsics.checkNotNullParameter(preloadList, "preloadList");
        if (isUpTurning) {
            CollectionsKt___CollectionsJvmKt.reverse(preloadList);
        }
        Iterator<CommonPhotoInfo> it = preloadList.iterator();
        while (it.hasNext()) {
            q(it.next());
        }
    }

    /* renamed from: e, reason: from getter */
    public final String getAttachInfo() {
        return this.attachInfo;
    }

    public final List<CommonStTimeLineEvent> f() {
        return this.eventList;
    }

    public final List<b> g() {
        return this.listenerList;
    }

    public final List<CommonPhotoInfo> h() {
        return this.mediaInfoList;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getNextHasMore() {
        return this.nextHasMore;
    }

    /* renamed from: j, reason: from getter */
    public final CommonPageEndMsg getPageEndMsg() {
        return this.pageEndMsg;
    }

    /* renamed from: k, reason: from getter */
    public final int getPhotoNum() {
        return this.photoNum;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getPrevHasMore() {
        return this.prevHasMore;
    }

    /* renamed from: m, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: n, reason: from getter */
    public final int getVideoNum() {
        return this.videoNum;
    }

    public final void p(cb.a repoBean) {
        Intrinsics.checkNotNullParameter(repoBean, "repoBean");
        Iterator<T> it = this.listenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(repoBean);
        }
    }

    public final void s(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.listenerList.contains(listener)) {
            return;
        }
        this.listenerList.add(listener);
    }

    public final void t() {
        this.listenerList.clear();
        u();
        this.layerRequestBean = null;
    }

    public final void u() {
        this.mediaInfoList.clear();
        this.eventList.clear();
        this.videoNum = 0;
        this.photoNum = 0;
        this.attachInfo = "";
        this.prevHasMore = false;
        this.nextHasMore = false;
        this.isTimeline = false;
        this.curTimeLineEvent = null;
    }

    public final void v() {
        this.mediaInfoList.clear();
        this.attachInfo = "";
        this.prevHasMore = false;
        this.nextHasMore = false;
        this.pageEndMsg = null;
    }

    public final void w(bb.g requestBean) {
        CommonStTimeLineEvent commonStTimeLineEvent;
        CommonStTimeLineEvent commonStTimeLineEvent2;
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        this.layerRequestBean = requestBean;
        if (requestBean.getIsRefresh()) {
            I(requestBean);
            return;
        }
        if (requestBean.getIsFetchRight() && this.nextHasMore) {
            if (this.isTimeline && (commonStTimeLineEvent2 = this.curTimeLineEvent) != null) {
                Intrinsics.checkNotNull(commonStTimeLineEvent2);
                y(2, commonStTimeLineEvent2);
                return;
            } else {
                x(2, false, false);
                return;
            }
        }
        if (requestBean.getIsFetchLeft() && this.prevHasMore && this.isTimeline && (commonStTimeLineEvent = this.curTimeLineEvent) != null) {
            Intrinsics.checkNotNull(commonStTimeLineEvent);
            y(2, commonStTimeLineEvent);
        }
    }

    public abstract void x(int loadType, boolean enableCache, boolean isNeedScrollToFirst);

    public abstract void y(int loadType, CommonStTimeLineEvent event);

    public final void z(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attachInfo = str;
    }

    public final void o(String uin) {
        if (uin == null) {
            uin = "";
        }
        this.uin = uin;
    }
}
