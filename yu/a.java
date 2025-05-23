package yu;

import com.tencent.av.network.api.INetworkAccelerationControlApi;
import com.tencent.av.network.business.api.INetworkAccelerationReportApi;
import com.tencent.avcore.jni.net.INetworkAccelerationAdapter;
import com.tencent.avcore.jni.net.SocketInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements INetworkAccelerationAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final List<SocketInfo> f451220a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f451221b = false;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f451222c = false;

    /* renamed from: d, reason: collision with root package name */
    private final INetworkAccelerationControlApi f451223d;

    /* compiled from: P */
    /* renamed from: yu.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C11632a implements zu.a {
        C11632a() {
        }

        @Override // zu.a
        public void a(int i3) {
            boolean z16;
            a aVar = a.this;
            boolean z17 = false;
            if (i3 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.f451221b = z16;
            a aVar2 = a.this;
            if (aVar2.f451221b && a.this.f451223d.hasFeature(2)) {
                z17 = true;
            }
            aVar2.f451222c = z17;
            QLog.d("AVNetworkAccelerationAdapterImpl", 1, "mInitSuccess:=" + a.this.f451221b);
        }
    }

    public a() {
        INetworkAccelerationControlApi c16 = hv.a.c();
        this.f451223d = c16;
        if (!c16.hasInit()) {
            c16.initAsync(new C11632a());
        }
    }

    private boolean e(SocketInfo socketInfo) {
        synchronized (this.f451220a) {
            Iterator<SocketInfo> it = this.f451220a.iterator();
            while (it.hasNext()) {
                if (hv.a.a(it.next(), socketInfo)) {
                    return false;
                }
            }
            if (this.f451220a.size() >= 3) {
                this.f451220a.remove(0);
            }
            this.f451220a.add(socketInfo);
            QLog.d("AVNetworkAccelerationAdapterImpl", 1, "addSocketInfo addSocket " + socketInfo.destIP + "port:=" + socketInfo.destPort);
            return true;
        }
    }

    private boolean f() {
        boolean z16 = false;
        if (!this.f451221b) {
            QLog.d("AVNetworkAccelerationAdapterImpl", 1, "isSupportInternal initFail");
            return false;
        }
        if (!this.f451223d.isSupportNetworkAcceleration()) {
            QLog.d("AVNetworkAccelerationAdapterImpl", 1, "isSupportInternal support fail");
            return false;
        }
        if (this.f451223d.hasFeature(1) && this.f451223d.hasFeature(4)) {
            z16 = true;
        }
        ((INetworkAccelerationReportApi) QRoute.api(INetworkAccelerationReportApi.class)).reportEnableEntry(z16);
        return z16;
    }

    private void g(SocketInfo socketInfo) {
        synchronized (this.f451220a) {
            Iterator<SocketInfo> it = this.f451220a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SocketInfo next = it.next();
                if (hv.a.a(next, socketInfo)) {
                    this.f451220a.remove(next);
                    QLog.d("AVNetworkAccelerationAdapterImpl", 1, "removeSocketInfo removeSocket " + socketInfo.destIP + "port:=" + socketInfo.destPort);
                    break;
                }
            }
        }
    }

    @Override // com.tencent.avcore.jni.net.INetworkAccelerationAdapter
    public void bindToNetInterface(SocketInfo socketInfo) {
        QLog.d("AVNetworkAccelerationAdapterImpl", 1, "bindToNetInterface destIp:=" + socketInfo.destIP + ",chnType:=" + socketInfo.chnType);
        if (socketInfo.familyType == 0 && this.f451222c) {
            if (!e(socketInfo)) {
                QLog.d("AVNetworkAccelerationAdapterImpl", 1, "bindToNetInterface fail, too many socket");
                return;
            } else {
                this.f451223d.bindToNetInterface(socketInfo);
                return;
            }
        }
        QLog.d("AVNetworkAccelerationAdapterImpl", 1, "bindToNetInterface fail, only use sdk for ipv4 or not support socket boost");
    }

    @Override // com.tencent.avcore.jni.net.INetworkAccelerationAdapter
    public boolean isSupport() {
        return f();
    }

    @Override // com.tencent.avcore.jni.net.INetworkAccelerationAdapter
    public void startRoomAccelerate() {
        QLog.d("AVNetworkAccelerationAdapterImpl", 1, "startRoomAccelerate");
        this.f451223d.notifyAPPStateToSys(1);
        this.f451223d.setAppBandwidth(1200, 1500);
    }

    @Override // com.tencent.avcore.jni.net.INetworkAccelerationAdapter
    public void stopRoomAccelerate() {
        QLog.d("AVNetworkAccelerationAdapterImpl", 1, "stopRoomAccelerate");
        synchronized (this.f451220a) {
            for (SocketInfo socketInfo : this.f451220a) {
                this.f451223d.unBindToNetInterface(socketInfo);
                QLog.d("AVNetworkAccelerationAdapterImpl", 1, "stopRoomAccelerate removeSocket " + socketInfo.destIP + "port:=" + socketInfo.destPort);
            }
            this.f451220a.clear();
        }
        this.f451223d.setAppBandwidth(0, 0);
        this.f451223d.notifyAPPStateToSys(2);
    }

    @Override // com.tencent.avcore.jni.net.INetworkAccelerationAdapter
    public void unBindToNetInterface(SocketInfo socketInfo) {
        QLog.d("AVNetworkAccelerationAdapterImpl", 1, "unBindToNetInterface " + socketInfo.destIP);
        if (socketInfo.familyType == 0 && this.f451222c) {
            g(socketInfo);
            this.f451223d.unBindToNetInterface(socketInfo);
        } else {
            QLog.d("AVNetworkAccelerationAdapterImpl", 1, "bindToNetInterface fail, only use sdk for ipv4 or not support socket boost");
        }
    }
}
