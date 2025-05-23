package rm2;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f431684a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f431685b = new AtomicInteger(10);

    /* renamed from: c, reason: collision with root package name */
    private final Object f431686c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final Object f431687d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private CopyOnWriteArrayList<Integer> f431688e = new CopyOnWriteArrayList<>();

    public void a(int i3) {
        this.f431688e.add(0, Integer.valueOf(i3));
    }

    public void b(int i3) {
        synchronized (this.f431687d) {
            this.f431684a.set(i3);
        }
    }

    public void c(int i3) {
        synchronized (this.f431687d) {
            this.f431685b.set(i3);
        }
    }

    public int d() {
        int intValue;
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = this.f431688e;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            synchronized (this.f431687d) {
                intValue = this.f431688e.get(0).intValue();
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    Iterator<Integer> it = this.f431688e.iterator();
                    while (it.hasNext()) {
                        sb5.append(it.next().intValue() + ",");
                    }
                    QLog.d("PeakAudioTransHandler ChannelStateManager", 2, "getRecentTopEvent lastevent = " + intValue + "\uff0c eventlist = " + sb5.toString());
                }
                this.f431688e.clear();
            }
            return intValue;
        }
        return -1;
    }

    public int e() {
        return this.f431684a.get();
    }

    public int f() {
        return this.f431685b.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g() {
        int i3 = this.f431684a.get();
        int i16 = this.f431685b.get();
        boolean z16 = true;
        if (i3 == 0) {
            switch (i16) {
            }
        } else if (i3 == 1) {
            switch (i16) {
            }
        } else if (i3 != 2) {
            if (i3 == 3) {
                switch (i16) {
                }
            }
            z16 = false;
        } else {
            switch (i16) {
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    z16 = false;
                    break;
            }
        }
        if (!z16 && QLog.isColorLevel()) {
            QLog.e("PeakAudioTransHandler ChannelStateManager", 2, "isLegalState , currentSessionState = " + i3 + " currentTCPState = " + i16);
        }
        return z16;
    }

    public boolean h() {
        if (this.f431684a.get() == 0) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f431684a.get() == 2) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f431684a.get() == 1) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f431685b.get() == 10) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f431685b.get() == 12) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (this.f431685b.get() == 11) {
            return true;
        }
        return false;
    }

    public void n() {
        synchronized (this.f431687d) {
            CopyOnWriteArrayList<Integer> copyOnWriteArrayList = this.f431688e;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.clear();
            }
            this.f431684a.set(0);
            this.f431685b.set(10);
        }
    }
}
