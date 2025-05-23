package sm;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.publish.business.publishqueue.common.CommonPublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.publish.QZoneFakeFeedDbEntity;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StFeed;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0007J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0007J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0007J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0016\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010 \u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dJ\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\"\u001a\u00020\u00072\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013J\u0006\u0010#\u001a\u00020\u0015R)\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R#\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0$8\u0006\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R)\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00040$8\u0006\u00a2\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(R\"\u00106\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lsm/h;", "", "", "spaceId", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "p", "", "y", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "r", "Lqzone/QZoneBaseMeta$StFeed;", "feed", "Lqzone/QZoneBaseCommon$StCommonExt;", "extInfo", "j", "ext", "g", "feedClientKey", "", "realFeedList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "clientKey", "t", "v", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "o", "Lsm/i;", "listener", "i", HippyTKDListViewAdapter.X, DomainData.DOMAIN_NAME, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "getMFakeFeedMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "mFakeFeedMap", "c", "getMFakeStFeedMap", "mFakeStFeedMap", "d", "getMPublishListenerMap", "mPublishListenerMap", "e", "Z", "getMHaveInitDbHistory", "()Z", "setMHaveInitDbHistory", "(Z)V", "mHaveInitDbHistory", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f433971a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<BusinessFeedData>> mFakeFeedMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, QZoneBaseMeta$StFeed> mFakeStFeedMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<i>> mPublishListenerMap = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean mHaveInitDbHistory;

    h() {
    }

    @JvmStatic
    public static final synchronized void A(String spaceId, QZoneBaseMeta$StFeed feed, QZoneBaseCommon$StCommonExt ext) {
        synchronized (h.class) {
            Intrinsics.checkNotNullParameter(spaceId, "spaceId");
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(ext, "ext");
            RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[updateFeed] spaceId: " + spaceId + ", feedId:" + feed.cell_common.feed_id.get() + ",clientKey" + feed.cell_common.client_key.get());
            h hVar = f433971a;
            if (!hVar.m()) {
                RFWLog.e("upload2-QZoneFakeFeedManager", RFWLog.USR, "[updateFeed] enableFakeFeed return false");
            }
            QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed = mFakeStFeedMap.get(feed.cell_common.client_key.get());
            if (qZoneBaseMeta$StFeed != null) {
                RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[updateFeed] convert clint feed succeed");
                feed.cell_media = qZoneBaseMeta$StFeed.cell_media.get();
            }
            final BusinessFeedData B = oj.a.f423008a.B(feed, ext);
            String str = B.getFeedCommInfo().clientkey;
            Intrinsics.checkNotNullExpressionValue(str, "data.feedCommInfo.clientkey");
            hVar.v(spaceId, str);
            final CopyOnWriteArrayList<i> copyOnWriteArrayList = mPublishListenerMap.get(spaceId);
            if (copyOnWriteArrayList != null) {
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: sm.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.B(copyOnWriteArrayList, B);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CopyOnWriteArrayList it, BusinessFeedData data) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(data, "$data");
        Iterator it5 = it.iterator();
        while (it5.hasNext()) {
            ((i) it5.next()).I4(data);
        }
    }

    @JvmStatic
    public static final synchronized void g(final String spaceId, final QZoneBaseMeta$StFeed feed, final QZoneBaseCommon$StCommonExt ext) {
        synchronized (h.class) {
            Intrinsics.checkNotNullParameter(spaceId, "spaceId");
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(ext, "ext");
            h hVar = f433971a;
            if (!hVar.m()) {
                RFWLog.e("upload2-QZoneFakeFeedManager", RFWLog.USR, "[addFeed] enableFakeFeed return false");
            }
            ConcurrentHashMap<String, QZoneBaseMeta$StFeed> concurrentHashMap = mFakeStFeedMap;
            String str = feed.cell_common.client_key.get();
            Intrinsics.checkNotNullExpressionValue(str, "feed.cell_common.client_key.get()");
            concurrentHashMap.put(str, feed);
            final BusinessFeedData j3 = hVar.j(feed, ext);
            CopyOnWriteArrayList<BusinessFeedData> p16 = hVar.p(spaceId);
            p16.add(0, j3);
            RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[addFeed] spaceId: " + spaceId + ", feedId:" + feed.cell_common.feed_id.get() + ",fake feed size:" + p16.size() + ",clientKey:" + feed.cell_common.client_key.get());
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: sm.d
                @Override // java.lang.Runnable
                public final void run() {
                    h.h(QZoneBaseMeta$StFeed.this, ext, spaceId, j3);
                }
            });
            hVar.r(spaceId, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(QZoneBaseMeta$StFeed feed, QZoneBaseCommon$StCommonExt ext, String spaceId, BusinessFeedData data) {
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(ext, "$ext");
        Intrinsics.checkNotNullParameter(spaceId, "$spaceId");
        Intrinsics.checkNotNullParameter(data, "$data");
        QZoneFakeFeedDbEntity qZoneFakeFeedDbEntity = new QZoneFakeFeedDbEntity(spaceId, data.getFeedCommInfo().clientkey, feed.toByteArray(), ext.toByteArray());
        qZoneFakeFeedDbEntity.insertTime = System.currentTimeMillis();
        a.c().d(qZoneFakeFeedDbEntity);
    }

    private final BusinessFeedData j(QZoneBaseMeta$StFeed feed, QZoneBaseCommon$StCommonExt extInfo) {
        BusinessFeedData B = oj.a.f423008a.B(feed, extInfo);
        CellLocalInfo localInfo = B.getLocalInfo();
        if (localInfo != null) {
            RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[buildBussFeedData] spaceId: " + feed.cell_common.client_key.get() + ", feedId:" + feed.cell_common.feed_id.get() + ",set fake flag");
            localInfo.setFake();
        } else {
            RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[buildBussFeedData] spaceId: " + feed.cell_common.client_key.get() + ", feedId:" + feed.cell_common.feed_id.get() + ",set fake flag error");
        }
        B.setMixFake(1);
        CellPictureInfo pictureInfo = B.getPictureInfo();
        if (pictureInfo != null) {
            pictureInfo.setVideoPicMix(true);
        }
        return B;
    }

    private final long o() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_INTIMATE_FAKE_FEED_TIME_OUT_MILLIS, 3600000L);
    }

    private final synchronized CopyOnWriteArrayList<BusinessFeedData> p(String spaceId) {
        CopyOnWriteArrayList<BusinessFeedData> copyOnWriteArrayList;
        ConcurrentHashMap<String, CopyOnWriteArrayList<BusinessFeedData>> concurrentHashMap = mFakeFeedMap;
        copyOnWriteArrayList = concurrentHashMap.get(spaceId);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            concurrentHashMap.put(spaceId, copyOnWriteArrayList);
        }
        return copyOnWriteArrayList;
    }

    private final void r(String spaceId, final BusinessFeedData businessData) {
        final CopyOnWriteArrayList<i> copyOnWriteArrayList = mPublishListenerMap.get(spaceId);
        if (copyOnWriteArrayList != null) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: sm.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.s(copyOnWriteArrayList, businessData);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(CopyOnWriteArrayList it, BusinessFeedData businessData) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(businessData, "$businessData");
        Iterator it5 = it.iterator();
        while (it5.hasNext()) {
            ((i) it5.next()).i7(businessData);
        }
    }

    @JvmStatic
    public static final synchronized void t(String spaceId, final String clientKey) {
        synchronized (h.class) {
            Intrinsics.checkNotNullParameter(spaceId, "spaceId");
            Intrinsics.checkNotNullParameter(clientKey, "clientKey");
            RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[removeFeed] spaceId: " + spaceId + ", clientKey:" + clientKey);
            h hVar = f433971a;
            if (!hVar.m()) {
                RFWLog.e("upload2-QZoneFakeFeedManager", RFWLog.USR, "[removeFeed] enableFakeFeed return false");
            }
            hVar.v(spaceId, clientKey);
            final CopyOnWriteArrayList<i> copyOnWriteArrayList = mPublishListenerMap.get(spaceId);
            if (copyOnWriteArrayList != null) {
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: sm.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.u(copyOnWriteArrayList, clientKey);
                    }
                });
            }
            eo.d.b(new WinkPublishQualityReportData.Builder().eventId(eo.d.f396887g).ext1(clientKey).ext4(eo.d.f396890j).getReportData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(CopyOnWriteArrayList it, String clientKey) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(clientKey, "$clientKey");
        Iterator it5 = it.iterator();
        while (it5.hasNext()) {
            ((i) it5.next()).v1(clientKey);
        }
    }

    private final synchronized void v(final String spaceId, final String clientKey) {
        CopyOnWriteArrayList<BusinessFeedData> copyOnWriteArrayList = mFakeFeedMap.get(spaceId);
        if (copyOnWriteArrayList != null) {
            for (BusinessFeedData businessFeedData : copyOnWriteArrayList) {
                CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
                if (Intrinsics.areEqual(feedCommInfo != null ? feedCommInfo.clientkey : null, clientKey)) {
                    RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[removeFromFakeFeedMap] spaceId: " + spaceId + ", clientKey:" + clientKey);
                    copyOnWriteArrayList.remove(businessFeedData);
                }
            }
        }
        if (copyOnWriteArrayList != null) {
            RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[removeFromFakeFeedMap] spaceId: " + spaceId + " ,current data size:" + copyOnWriteArrayList.size());
        }
        mFakeStFeedMap.remove(clientKey);
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: sm.f
            @Override // java.lang.Runnable
            public final void run() {
                h.w(spaceId, clientKey);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(String spaceId, String clientKey) {
        Intrinsics.checkNotNullParameter(spaceId, "$spaceId");
        Intrinsics.checkNotNullParameter(clientKey, "$clientKey");
        a.c().a(spaceId, clientKey);
    }

    @JvmStatic
    public static final synchronized void y() {
        synchronized (h.class) {
            if (mHaveInitDbHistory) {
                return;
            }
            mHaveInitDbHistory = true;
            if (!f433971a.m()) {
                RFWLog.e("upload2-QZoneFakeFeedManager", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] enableFakeFeed return false");
            }
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: sm.e
                @Override // java.lang.Runnable
                public final void run() {
                    h.z();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z() {
        List<QZoneFakeFeedDbEntity> e16 = a.c().e();
        if (e16 != null && !e16.isEmpty()) {
            for (QZoneFakeFeedDbEntity qZoneFakeFeedDbEntity : e16) {
                try {
                    QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed = new QZoneBaseMeta$StFeed();
                    QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = new QZoneBaseCommon$StCommonExt();
                    qZoneBaseMeta$StFeed.mergeFrom(qZoneFakeFeedDbEntity.data);
                    qZoneBaseCommon$StCommonExt.mergeFrom(qZoneFakeFeedDbEntity.extData);
                    h hVar = f433971a;
                    BusinessFeedData j3 = hVar.j(qZoneBaseMeta$StFeed, qZoneBaseCommon$StCommonExt);
                    String str = qZoneFakeFeedDbEntity.spaceId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.spaceId");
                    hVar.p(str).add(0, j3);
                    ConcurrentHashMap<String, QZoneBaseMeta$StFeed> concurrentHashMap = mFakeStFeedMap;
                    String str2 = qZoneBaseMeta$StFeed.cell_common.client_key.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "feed.cell_common.client_key.get()");
                    concurrentHashMap.put(str2, qZoneBaseMeta$StFeed);
                    String str3 = qZoneFakeFeedDbEntity.spaceId;
                    Intrinsics.checkNotNullExpressionValue(str3, "it.spaceId");
                    hVar.r(str3, j3);
                    RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] convert businessData succeed,spaceID:" + qZoneFakeFeedDbEntity.spaceId + ",clientKey:" + qZoneFakeFeedDbEntity.clintKey + "\uff0cpublishTime\uff1a" + qZoneFakeFeedDbEntity.insertTime);
                } catch (Exception unused) {
                    RFWLog.e("upload2-QZoneFakeFeedManager", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] convert businessData error,spaceID:" + qZoneFakeFeedDbEntity.spaceId + ",clientKey:" + qZoneFakeFeedDbEntity.clintKey);
                }
            }
            l(f433971a, null, 1, null);
            return;
        }
        RFWLog.e("upload2-QZoneFakeFeedManager", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] db size is 0");
    }

    public final synchronized void i(String spaceId, i listener) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[addPublishListener] spaceId: " + spaceId + ", listener:" + listener);
        ConcurrentHashMap<String, CopyOnWriteArrayList<i>> concurrentHashMap = mPublishListenerMap;
        CopyOnWriteArrayList<i> copyOnWriteArrayList = concurrentHashMap.get(spaceId);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            concurrentHashMap.put(spaceId, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(listener);
    }

    public final synchronized void k(List<? extends BusinessFeedData> realFeedList) {
        if (!m()) {
            RFWLog.e("upload2-QZoneFakeFeedManager", RFWLog.USR, "[deleteInvalidFakeFeed] enableFakeFeed return false");
        }
        for (Map.Entry<String, CopyOnWriteArrayList<BusinessFeedData>> entry : mFakeFeedMap.entrySet()) {
            String key = entry.getKey();
            CopyOnWriteArrayList<BusinessFeedData> value = entry.getValue();
            CommonPublishQueue c16 = com.qzone.publish.business.publishqueue.intimate.i.f51168a.c(key);
            for (BusinessFeedData businessFeedData : value) {
                CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
                Object obj = null;
                String str = feedCommInfo != null ? feedCommInfo.clientkey : null;
                if (str == null) {
                    RFWLog.e("upload2-QZoneFakeFeedManager", RFWLog.USR, "[deleteInvalidFakeFeed] clientKey is null,spaceId is:" + key);
                } else if (f433971a.q(str, realFeedList)) {
                    RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[deleteInvalidFakeFeed] do delete by real feed,space id:" + key + ",clientKey:" + str);
                    t(key, str);
                } else {
                    Iterator<T> it = c16.a().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.areEqual(((IQueueTask) next).getClientKey(), str)) {
                            obj = next;
                            break;
                        }
                    }
                    IQueueTask iQueueTask = (IQueueTask) obj;
                    CellFeedCommInfo feedCommInfo2 = businessFeedData.getFeedCommInfo();
                    long j3 = feedCommInfo2 != null ? feedCommInfo2.time : 0L;
                    if (iQueueTask == null && Math.abs(System.currentTimeMillis() - j3) > f433971a.o()) {
                        RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[deleteInvalidFakeFeed] do delete by timeout,space id:" + key + ",clientKey:" + str + ",publishTime:" + j3);
                        t(key, str);
                    }
                }
            }
        }
    }

    public final boolean m() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_INTIMATE_ENABLE_FAKE_FEED, 1) == 1;
    }

    public final synchronized CopyOnWriteArrayList<BusinessFeedData> n(String spaceId) {
        CopyOnWriteArrayList<BusinessFeedData> copyOnWriteArrayList;
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        copyOnWriteArrayList = new CopyOnWriteArrayList<>(p(spaceId));
        y();
        return copyOnWriteArrayList;
    }

    public final synchronized void x(String spaceId, i listener) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RFWLog.d("upload2-QZoneFakeFeedManager", RFWLog.USR, "[removePublishListener] spaceId: " + spaceId + ", listener:" + listener);
        ConcurrentHashMap<String, CopyOnWriteArrayList<i>> concurrentHashMap = mPublishListenerMap;
        CopyOnWriteArrayList<i> copyOnWriteArrayList = concurrentHashMap.get(spaceId);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(listener);
        if (copyOnWriteArrayList.isEmpty()) {
            concurrentHashMap.remove(spaceId);
        }
    }

    private final boolean q(String feedClientKey, List<? extends BusinessFeedData> realFeedList) {
        boolean z16;
        if (realFeedList == null) {
            return false;
        }
        List<? extends BusinessFeedData> list = realFeedList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                CellFeedCommInfo feedCommInfo = ((BusinessFeedData) it.next()).getFeedCommInfo();
                if (Intrinsics.areEqual(feedCommInfo != null ? feedCommInfo.clientkey : null, feedClientKey)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(h hVar, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = null;
        }
        hVar.k(list);
    }
}
