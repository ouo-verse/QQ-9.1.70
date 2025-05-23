package z20;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedExposeEvent;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.qcircle.api.event.QCircleAddblackUpdateEvent;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f implements SimpleEventReceiver, IProcessStateChangeCallback {

    /* renamed from: e, reason: collision with root package name */
    private static volatile f f451789e;

    /* renamed from: d, reason: collision with root package name */
    private final e f451790d;

    f() {
        RFWLifecycleHelper.getInstance().registerProcessChangeListener(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f451790d = new e();
    }

    private boolean a(@NotNull List<FeedCloudMeta$StFeed> list) {
        e30.b h16 = h(j(list));
        if (h16 != null && h16.g() != null) {
            list.add(h16.g());
            int size = list.size();
            RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[appendBackUpFeedList] backUpFeedId:" + h16.g().f398449id.get() + " | newFeedsSize: " + size);
            return true;
        }
        RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[appendBackUpFeedList] backUpFeed == null || backUpFeed.getSourceData() == null.");
        return false;
    }

    private boolean b(List<e30.b> list, List<FeedCloudMeta$StFeed> list2) {
        e30.b bVar;
        if (list != null && list2 != null) {
            RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[getKeepConsumeBackUpFeedList] originFeeds size: " + RFSafeListUtils.getSize(list) + " | new feeds size: " + RFSafeListUtils.getSize(list2));
            if (list.size() != 2 || (bVar = list.get(1)) == null || bVar.g() == null || !TextUtils.equals(fb0.b.c(bVar.g().debugInfo.debugMap, "is_client_back_up_feed", ""), "1")) {
                return false;
            }
            RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[getKeepConsumeBackUpFeedList] real addBackUpFeed");
            if (list2.isEmpty()) {
                list2.add(bVar.g());
            } else {
                list2.add(1, bVar.g());
            }
            return true;
        }
        RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[appendConsumeBackUpFeedToNew] originFeeds == null || newFeeds == null.");
        return false;
    }

    private boolean d(List<e30.b> list, List<FeedCloudMeta$StFeed> list2, int i3) {
        if (i3 == 0) {
            if (list2.size() == 1) {
                a(list2);
            } else if (e(list, i3)) {
                RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[dealWithFeedChange] have remove reason server rsp");
            }
        } else if (i3 == 1) {
            if (list2.size() == 1) {
                if (a(list2)) {
                    RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[dealWithFeedChange] appendBackUpFeedList ture,needJumpBackup pos");
                    return true;
                }
            } else if (b(list, list2)) {
                RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[dealWithFeedChange] appendConsumeBackUpFeedToNew ture,needJumpBackup pos");
                return true;
            }
        }
        return false;
    }

    private boolean f() {
        return false;
    }

    public static String i(List<e30.b> list) {
        FeedCloudMeta$StFeed g16;
        if (list == null || list.isEmpty() || list.get(0) == null || (g16 = list.get(0).g()) == null) {
            return null;
        }
        return g16.f398449id.get();
    }

    public static String j(List<FeedCloudMeta$StFeed> list) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (list == null || list.isEmpty() || (feedCloudMeta$StFeed = list.get(0)) == null) {
            return null;
        }
        return feedCloudMeta$StFeed.f398449id.get();
    }

    public static f k() {
        if (f451789e == null) {
            synchronized (f.class) {
                if (f451789e == null) {
                    f451789e = new f();
                }
            }
        }
        return f451789e;
    }

    private void l(QCircleAddblackUpdateEvent qCircleAddblackUpdateEvent) {
        if (!f()) {
            return;
        }
        String str = qCircleAddblackUpdateEvent.mUserId;
        RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[handleAddBlackEvent] remove by userId:" + str);
        this.f451790d.t(str);
    }

    private void m(@NotNull QFSFeedExposeEvent qFSFeedExposeEvent) {
        FeedCloudMeta$StFeed feed;
        if (!f() || (feed = qFSFeedExposeEvent.getFeed()) == null || !this.f451790d.f(feed.f398449id.get())) {
            return;
        }
        RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[handleFeedExposeEvent] do back up feed consume, feedId:" + feed.f398449id.get());
        this.f451790d.u(feed.f398449id.get());
    }

    public static boolean n(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        return TextUtils.equals(fb0.b.c(feedCloudMeta$StFeed.debugInfo.debugMap, "is_client_back_up_feed", ""), "1");
    }

    private e30.b q(e30.b bVar) {
        if (bVar == null) {
            return null;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        if (g16 != null) {
            fb0.b.e(g16.debugInfo.debugMap, "is_client_back_up_feed", "1");
        }
        return bVar;
    }

    public boolean c(List<e30.b> list, List<FeedCloudMeta$StFeed> list2, int i3, boolean z16) {
        if (list2 == null || list == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
        RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[dealWithFeedChange] currentPos:" + i3 + " | isLoadMore:" + z16 + " | oldFeedsSize: " + size + " | newFeedsSize: " + size2);
        if (z16) {
            if (size == 2 && i3 == 0 && e(list, i3)) {
                RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[dealWithFeedChange] have remove reason server rsp");
            }
            return false;
        }
        return d(list, list2, i3);
    }

    public boolean e(List<e30.b> list, int i3) {
        e30.b bVar;
        if (!f() || list == null || list.size() < 2 || i3 != 0 || (bVar = list.get(1)) == null || !TextUtils.equals(fb0.b.c(bVar.g().debugInfo.debugMap, "is_client_back_up_feed", ""), "1") || !this.f451790d.f(bVar.g().f398449id.get())) {
            return false;
        }
        RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[doBackUpFeedRemove] reason load server rsp have receive;feedId:" + bVar.g().f398449id.get());
        list.remove(bVar);
        return true;
    }

    public void g() {
        if (!f()) {
            return;
        }
        this.f451790d.g();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSFeedExposeEvent.class);
        arrayList.add(QCircleAddblackUpdateEvent.class);
        return arrayList;
    }

    public e30.b h(String str) {
        if (!f()) {
            return null;
        }
        RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[getBackUpFeed] firstFeedId\uff1a" + str);
        List<QFSEdgeItem> j3 = this.f451790d.j();
        if (j3 != null && !j3.isEmpty()) {
            ArrayList arrayList = new ArrayList(j3);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                QFSEdgeItem qFSEdgeItem = (QFSEdgeItem) arrayList.get(i3);
                if (qFSEdgeItem != null && !TextUtils.equals(str, qFSEdgeItem.getItemID())) {
                    RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[getBackUpFeed] return from mFileCacheItems,feed id:" + qFSEdgeItem.getItemID());
                    return q(qFSEdgeItem.getFeedBlockData());
                }
            }
            return null;
        }
        RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[getBackUpFeed] is null, reload from server");
        this.f451790d.w();
        return null;
    }

    public void o() {
        if (f()) {
            RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[preloadDiskFeed]");
            this.f451790d.e();
        }
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public /* synthetic */ void onProcessBackground() {
        com.tencent.richframework.lifecycle.a.a(this);
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessForeground() {
        if (this.f451790d != null && f() && h.b()) {
            this.f451790d.e();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFeedExposeEvent) {
            m((QFSFeedExposeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleAddblackUpdateEvent) {
            l((QCircleAddblackUpdateEvent) simpleBaseEvent);
        }
    }

    public void p(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (h.b() && !this.f451790d.f(feedCloudMeta$StFeed.f398449id.get())) {
            return;
        }
        RFWLog.d("FeedLine_QFSLoadMoreDataPollManager", RFWLog.USR, "[removeFeed] feedId:" + feedCloudMeta$StFeed.f398449id.get());
        this.f451790d.u(feedCloudMeta$StFeed.f398449id.get());
    }
}
