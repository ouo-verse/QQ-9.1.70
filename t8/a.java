package t8;

import com.qzone.adapter.feedcomponent.n;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.misc.network.ttt.TTTBigDataReport;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import u5.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements IQZoneServiceListener, NetworkState.NetworkStateListener, n {

    /* renamed from: h, reason: collision with root package name */
    public static int f435590h = 1;

    /* renamed from: d, reason: collision with root package name */
    private final String f435591d = "FeedActionReporter";

    /* renamed from: e, reason: collision with root package name */
    private final int f435592e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private byte f435593f = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: t8.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11275a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f435594a = new a();
    }

    a() {
        NetworkState.addListener(this);
    }

    public static final a d() {
        return C11275a.f435594a;
    }

    private void e() {
        int networkType = NetworkState.getNetworkType();
        if (networkType == 1) {
            this.f435593f = (byte) 1;
            return;
        }
        if (networkType == 2) {
            this.f435593f = (byte) 2;
            return;
        }
        if (networkType == 3) {
            this.f435593f = (byte) 3;
            return;
        }
        if (networkType == 4) {
            this.f435593f = (byte) 4;
        } else if (networkType != 5) {
            this.f435593f = (byte) 0;
        } else {
            this.f435593f = (byte) 5;
        }
    }

    private void f(int i3) {
        TTTBigDataReport.t().z(i3);
    }

    @Override // com.qzone.adapter.feedcomponent.n
    public void a(String str) {
        e();
        TTTBigDataReport.t().x(System.currentTimeMillis() / 1000, this.f435593f, QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FEED_ACTION_REPORT_SESSION_SIZE, 800), str);
    }

    @Override // com.qzone.adapter.feedcomponent.n
    public void b(long j3, long j16) {
        b.E0(j3, j16);
    }

    public int c() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FEED_ACTION_REPORT_SESSION_SIZE, 800);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask == null) {
            QZLog.w("FeedActionReporter", "onTaskResponse null");
        } else if (qZoneTask.mType != 1000) {
            QZLog.w("FeedActionReporter", "onTaskResponse switch to default");
        }
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        if (z16) {
            e();
        } else {
            this.f435593f = (byte) 0;
        }
        f(this.f435593f);
    }
}
