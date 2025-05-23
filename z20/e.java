package z20;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.thread.RFWThreadManager;
import ec0.a;
import hc0.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import uq3.n;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final List<QFSEdgeItem> f451785a = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f451787c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f451788d = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final m f451786b = new m();

    private int h() {
        if (h.b()) {
            return o.F0(1);
        }
        return 0;
    }

    private int i() {
        String str;
        int videoDeviceLevel = QCircleVideoDeviceInfoUtils.getVideoDeviceLevel();
        int i3 = 3;
        if (videoDeviceLevel != 3 && videoDeviceLevel != 4) {
            str = "qqcircle_enable_load_more_backup_expired_day_low_device";
            i3 = 7;
        } else {
            str = "qqcircle_enable_load_more_backup_expired_day_high_device";
        }
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(str, String.valueOf(i3)));
        } catch (Exception e16) {
            RFWLog.e("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "getExpiredDay error:" + e16);
            return i3;
        }
    }

    private int k() {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_enable_load_more_backup_exp_9070", String.valueOf(6)));
        } catch (Exception e16) {
            RFWLog.e("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "getNeedCount error:" + e16);
            return 6;
        }
    }

    private List<QFSEdgeItem> l(List<QFSEdgeItem> list) {
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        if (size != h()) {
            return arrayList;
        }
        arrayList.addAll(list);
        return arrayList;
    }

    private boolean m(QFSEdgeItem qFSEdgeItem) {
        if (qFSEdgeItem == null) {
            return false;
        }
        long timeStamp = qFSEdgeItem.getTimeStamp();
        RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[isItemExpired] itemTime:" + timeStamp);
        if (timeStamp <= 0) {
            return false;
        }
        return n.b(timeStamp, System.currentTimeMillis(), i());
    }

    private boolean n() {
        int h16 = h();
        List<QFSEdgeItem> list = this.f451785a;
        if (list != null && list.size() <= h16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        try {
            v();
        } catch (Throwable th5) {
            RFWLog.e("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[asyncStartLoadFeed] error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        ArrayList arrayList = new ArrayList(this.f451785a);
        RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[doSaveFeedLogic] size:" + arrayList.size() + " | feed ids: " + s());
        m.x(arrayList, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(boolean z16, List list, Map map) {
        if (list != null) {
            x(list, true);
        }
        RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[startLoadFeedFromServer] load detail size:" + RFSafeListUtils.getSize(list) + " | isSucceed:" + z16);
        this.f451788d.set(false);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(boolean z16, List list, Map map) {
        RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[startLoadFeedFromServer] load raw size:" + RFSafeListUtils.getSize(list) + "|isSucceed:" + z16);
        if (z16 && list != null) {
            this.f451786b.e(list, new a.InterfaceC10228a() { // from class: z20.d
                @Override // ec0.a.InterfaceC10228a
                public final void a(boolean z17, List list2, Map map2) {
                    e.this.q(z17, list2, map2);
                }
            });
        } else {
            g();
            this.f451788d.set(false);
        }
    }

    private List<String> s() {
        ArrayList arrayList = new ArrayList();
        try {
        } catch (Throwable th5) {
            RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "obtainFeedIds ex:", th5);
        }
        if (this.f451785a.isEmpty()) {
            return arrayList;
        }
        for (QFSEdgeItem qFSEdgeItem : this.f451785a) {
            if (qFSEdgeItem != null) {
                arrayList.add(qFSEdgeItem.getItemID());
            }
        }
        return arrayList;
    }

    private void v() {
        List<QFSEdgeItem> w3 = m.w(2);
        if (w3 != null && !w3.isEmpty()) {
            if (m(w3.get(0))) {
                RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[startLoadFeed] item expired");
                w();
                return;
            }
            RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[startLoadFeed] load from file succeed; feed size:" + w3.size());
            x(w3, false);
            return;
        }
        RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[startLoadFeed] is empty");
        w();
    }

    private void x(List<QFSEdgeItem> list, boolean z16) {
        List<QFSEdgeItem> list2;
        if (list != null && !list.isEmpty()) {
            try {
                int k3 = k();
                if (k3 <= -1) {
                    RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[updateResultToCache] needAddCount <= Int.NUM_MINUS_1.");
                    return;
                }
                if (z16) {
                    list2 = l(this.f451785a);
                } else {
                    list2 = null;
                }
                int min = Math.min(list.size(), k3);
                RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[updateResultToCache] needAddCount: " + k3 + " | residueSource: " + RFSafeListUtils.getSize(list2) + " | serverRspSize: " + min);
                this.f451785a.clear();
                if (list2 != null && !list2.isEmpty()) {
                    this.f451785a.addAll(list2);
                }
                for (int i3 = 0; i3 < min; i3++) {
                    this.f451785a.add(list.get(i3));
                }
            } catch (Throwable th5) {
                RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[updateResultToCache] ex: ", th5);
            }
        }
    }

    public void e() {
        if (!this.f451787c.compareAndSet(false, true)) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: z20.a
            @Override // java.lang.Runnable
            public final void run() {
                e.this.o();
            }
        });
    }

    public boolean f(String str) {
        if (this.f451785a.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(this.f451785a);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            QFSEdgeItem qFSEdgeItem = (QFSEdgeItem) arrayList.get(i3);
            if (qFSEdgeItem != null && TextUtils.equals(qFSEdgeItem.getItemID(), str)) {
                return true;
            }
        }
        return false;
    }

    public void g() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: z20.b
            @Override // java.lang.Runnable
            public final void run() {
                e.this.p();
            }
        });
    }

    public List<QFSEdgeItem> j() {
        return this.f451785a;
    }

    public void t(String str) {
        RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[removeByUserId] userId:" + str);
        ArrayList arrayList = new ArrayList(this.f451785a);
        boolean z16 = false;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            QFSEdgeItem qFSEdgeItem = (QFSEdgeItem) arrayList.get(i3);
            if (qFSEdgeItem != null) {
                e30.b feedBlockData = qFSEdgeItem.getFeedBlockData();
                if (feedBlockData != null && feedBlockData.g() != null) {
                    if (TextUtils.equals(feedBlockData.g().poster.f398463id.get(), str)) {
                        String itemID = qFSEdgeItem.getItemID();
                        RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[removeByUserId] do back up feed consume do remove, userId: " + str + " | feedId: " + itemID);
                        this.f451785a.remove(qFSEdgeItem);
                    }
                } else {
                    this.f451785a.remove(qFSEdgeItem);
                }
                z16 = true;
            }
        }
        if (n()) {
            RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[removeByUserId] current update server data, preload backup source.");
            w();
        } else if (z16) {
            g();
        }
    }

    public void u(String str) {
        RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[removeFeed] feedId:" + str);
        ArrayList arrayList = new ArrayList(this.f451785a);
        boolean z16 = false;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            QFSEdgeItem qFSEdgeItem = (QFSEdgeItem) arrayList.get(i3);
            if (qFSEdgeItem != null && TextUtils.equals(qFSEdgeItem.getItemID(), str)) {
                RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[removeFeed] do back up feed consume do remove");
                this.f451785a.remove(qFSEdgeItem);
                z16 = true;
            }
        }
        if (n()) {
            RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[removeFeed] current update server data, preload backup source.");
            w();
        } else if (z16) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        if (!this.f451788d.compareAndSet(false, true)) {
            return;
        }
        int k3 = k();
        int h16 = h();
        int i3 = k3 - h16;
        if (i3 <= 0) {
            i3 = k3;
        }
        RFWLog.d("FeedLine_QFSLoadMoreBackUpDataSource", RFWLog.USR, "[startLoadFeedFromServer] requestCount: " + i3 + " | needCount: " + k3 + " | residueNum: " + h16);
        this.f451786b.a(i3, "", new a.InterfaceC10228a() { // from class: z20.c
            @Override // ec0.a.InterfaceC10228a
            public final void a(boolean z16, List list, Map map) {
                e.this.r(z16, list, map);
            }
        });
    }
}
