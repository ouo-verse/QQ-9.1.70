package un;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.qzone.reborn.reedit.QZoneIPCDiscardLastRecordEvent;
import com.qzone.reborn.reedit.QZoneIPCRecordContentProxyEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c implements SimpleEventReceiver {
    private static volatile c D;
    private String C;

    /* renamed from: e, reason: collision with root package name */
    private volatile long f439245e;

    /* renamed from: f, reason: collision with root package name */
    private volatile long f439246f;

    /* renamed from: h, reason: collision with root package name */
    private volatile a f439247h;

    /* renamed from: i, reason: collision with root package name */
    private volatile BusinessFeedData f439248i;

    /* renamed from: d, reason: collision with root package name */
    private final long f439244d = QzoneConfig.getSupportReeditLifeCycle() * 1000;

    /* renamed from: m, reason: collision with root package name */
    private boolean f439249m = QzoneConfig.getSupportDeleteFeedReedit();

    c() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void d() {
        r();
        this.f439247h = null;
        this.f439245e = 0L;
        this.f439246f = 0L;
        c();
    }

    public static c e() {
        if (D == null) {
            synchronized (c.class) {
                if (D == null) {
                    D = new c();
                }
            }
        }
        return D;
    }

    private boolean i() {
        boolean needShowQzoneFrame = ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).needShowQzoneFrame(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
        QLog.d("QZoneReeditContentRecordManager", 1, "isLebaStyleQZoneFrame: " + needShowQzoneFrame);
        return needShowQzoneFrame;
    }

    private boolean j() {
        boolean z16 = MobileQQ.sProcessId == 2;
        QLog.d("QZoneReeditContentRecordManager", 1, "isQZoneProcess : " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(String str) {
        if (this.f439247h == null || !TextUtils.equals(this.f439247h.a(), str) || b()) {
            return;
        }
        d();
        QLog.d("QZoneReeditContentRecordManager", 1, "setLastRecordContentAutoRetire occur,discard retire record");
    }

    private void r() {
        a aVar = this.f439247h;
        if (aVar != null && i() && j()) {
            SimpleEventBus.getInstance().dispatchEvent(new QZoneIPCDiscardLastRecordEvent(aVar.a()), true);
        }
    }

    private void s(long j3) {
        if (i() && j()) {
            SimpleEventBus.getInstance().dispatchEvent(new QZoneIPCRecordContentProxyEvent(j3, this.f439245e, this.f439247h.b(), this.f439247h.a()), true);
        }
    }

    private void t() {
        final String a16 = this.f439247h.a();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: un.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.l(a16);
            }
        }, this.f439244d);
    }

    public boolean b() {
        return this.f439247h != null && LoginData.getInstance().getUin() == this.f439246f && System.currentTimeMillis() - this.f439245e <= this.f439244d;
    }

    public void c() {
        BusinessFeedData businessFeedData = this.f439248i;
        if (businessFeedData != null) {
            businessFeedData.setIsReeditFeed(false);
            QZoneFeedService.U().Q(businessFeedData);
            QLog.d("QZoneReeditContentRecordManager", 1, "clearLastRecordFeedIfExist deleteLastRecordFeed key:", businessFeedData.getFeedCommInfo().clientkey);
            this.f439248i = null;
        }
    }

    public ShuoshuoContent f() {
        if (b() && (this.f439247h instanceof e)) {
            return ((e) this.f439247h).d();
        }
        return null;
    }

    public com.qzone.publish.ui.model.d g() {
        if (b() && (this.f439247h instanceof f)) {
            return ((f) this.f439247h).d();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneIPCRecordContentProxyEvent.class);
        arrayList.add(QZoneIPCDiscardLastRecordEvent.class);
        return arrayList;
    }

    public boolean h(BusinessFeedData businessFeedData) {
        if (!this.f439249m) {
            QLog.d("QZoneReeditContentRecordManager", 1, "isHitReeditTipsFeed false\uff0cdon't support reedit!");
            return false;
        }
        if (businessFeedData != null && b()) {
            if (!TextUtils.isEmpty(this.C) && TextUtils.equals(this.C, businessFeedData.getFeedCommInfo().clientkey)) {
                QLog.d("QZoneReeditContentRecordManager", 1, "isHitReeditTipsFeed false\uff0cis black list feeds");
                return false;
            }
            if (LoginData.getInstance().getUin() != businessFeedData.getHostUin()) {
                QLog.d("QZoneReeditContentRecordManager", 1, "isHitReeditTipsFeed false\uff0cdeleteFeed hostUin:", Long.valueOf(businessFeedData.getHostUin()), "curerntUin:", Long.valueOf(LoginData.getInstance().getUin()));
                return false;
            }
            if (this.f439247h.b() != businessFeedData.getFeedCommInfo().appid) {
                QLog.d("QZoneReeditContentRecordManager", 1, "isHitReeditTipsFeed false\uff0cdeleteFeed appid:", Integer.valueOf(businessFeedData.getFeedCommInfo().appid), "mLastRecordContent appid:", Integer.valueOf(this.f439247h.b()));
                return false;
            }
            if (!TextUtils.equals(businessFeedData.getFeedCommInfo().clientkey, this.f439247h.a())) {
                QLog.d("QZoneReeditContentRecordManager", 1, "isHitReeditTipsFeed false\uff0cdeleteFeed clientKey:", businessFeedData.getFeedCommInfo().clientkey, "mLastRecordContent clientKey:", this.f439247h.a());
                return false;
            }
            QLog.d("QZoneReeditContentRecordManager", 1, "isHitReeditTipsFeed feedskey:", businessFeedData.getFeedCommInfo().feedskey, ",ugckey:", businessFeedData.getFeedCommInfo().ugckey, ",clientkey:", businessFeedData.getFeedCommInfo().clientkey, "isFakeFeed:", Boolean.valueOf(businessFeedData.isFakeFeedSafe()));
            return true;
        }
        QLog.d("QZoneReeditContentRecordManager", 1, "isHitReeditTipsFeed false\uff0cdeleteFeed is null or mLastRecordContent invalid");
        return false;
    }

    public void k(Context context) {
        if (this.f439247h != null) {
            this.f439247h.c(context);
            QLog.d("QZoneReeditContentRecordManager", 1, "jumpToReedit appid:", Integer.valueOf(this.f439247h.b()), "clientKey:", this.f439247h.a());
        }
    }

    public void m(String str) {
        this.C = str;
    }

    public void n(long j3, ShuoshuoContent shuoshuoContent) {
        if (!this.f439249m || shuoshuoContent == null || j3 == 0) {
            return;
        }
        this.f439247h = new e(shuoshuoContent);
        this.f439245e = System.currentTimeMillis();
        this.f439246f = j3;
        c();
        t();
        s(j3);
    }

    public void o(long j3, com.qzone.publish.ui.model.d dVar) {
        if (!this.f439249m || dVar == null || j3 == 0) {
            return;
        }
        this.f439247h = new f(dVar);
        this.f439245e = System.currentTimeMillis();
        this.f439246f = j3;
        c();
        t();
        s(j3);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        a aVar;
        if (simpleBaseEvent instanceof QZoneIPCRecordContentProxyEvent) {
            QZoneIPCRecordContentProxyEvent qZoneIPCRecordContentProxyEvent = (QZoneIPCRecordContentProxyEvent) simpleBaseEvent;
            if (j()) {
                return;
            }
            p(qZoneIPCRecordContentProxyEvent.mUin, qZoneIPCRecordContentProxyEvent.mRecordTimeStamp, qZoneIPCRecordContentProxyEvent.mAppid, qZoneIPCRecordContentProxyEvent.mClientKey);
            return;
        }
        if (simpleBaseEvent instanceof QZoneIPCDiscardLastRecordEvent) {
            QZoneIPCDiscardLastRecordEvent qZoneIPCDiscardLastRecordEvent = (QZoneIPCDiscardLastRecordEvent) simpleBaseEvent;
            if (j() || (aVar = this.f439247h) == null) {
                return;
            }
            QLog.d("QZoneReeditContentRecordManager", 1, "receive ipc discard last record clientKey:", qZoneIPCDiscardLastRecordEvent.mClientKey);
            if (TextUtils.equals(aVar.a(), qZoneIPCDiscardLastRecordEvent.mClientKey)) {
                d();
            }
        }
    }

    public void p(long j3, long j16, int i3, String str) {
        if (this.f439249m) {
            this.f439247h = new d(str, i3);
            this.f439245e = j16;
            this.f439246f = j3;
            c();
            t();
            QLog.d("QZoneReeditContentRecordManager", 1, "recordIPCContentProxyBeforeUpload,clientKey:", str);
        }
    }

    public boolean q(BusinessFeedData businessFeedData, List<BusinessFeedData> list) {
        String str;
        if (!this.f439249m) {
            QLog.d("QZoneReeditContentRecordManager", 1, "replaceWithReeditTipsFeed false\uff0cdon't support reedit!");
            return false;
        }
        if (businessFeedData == null || list == null || list.isEmpty()) {
            return false;
        }
        String str2 = businessFeedData.getFeedCommInfo().clientkey;
        boolean z16 = false;
        for (BusinessFeedData businessFeedData2 : list) {
            if (businessFeedData2 != null && businessFeedData2.getFeedCommInfo().clientkey.equals(str2)) {
                businessFeedData2.setIsReeditFeed(true);
                this.f439248i = businessFeedData2;
                z16 = true;
            }
        }
        Object[] objArr = new Object[4];
        objArr[0] = "replaceWithReeditTipsFeed result:";
        objArr[1] = Boolean.valueOf(z16);
        objArr[2] = "clientKey:";
        if (this.f439248i != null) {
            str = this.f439248i.getFeedCommInfo().clientkey;
        } else {
            str = "";
        }
        objArr[3] = str;
        QLog.d("QZoneReeditContentRecordManager", 1, objArr);
        return z16;
    }
}
