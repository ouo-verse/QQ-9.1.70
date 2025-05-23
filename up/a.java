package up;

import com.tencent.adelie.av.session.AdelieAVUserInfo;
import com.tencent.av.gaudio.c;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f439382a;

    /* renamed from: b, reason: collision with root package name */
    public String f439383b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f439385d;

    /* renamed from: i, reason: collision with root package name */
    public String f439390i;

    /* renamed from: c, reason: collision with root package name */
    private int f439384c = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f439386e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f439387f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f439388g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f439389h = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f439391j = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f439392k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f439393l = false;

    /* renamed from: m, reason: collision with root package name */
    public int f439394m = 0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f439395n = false;

    /* renamed from: o, reason: collision with root package name */
    public long f439396o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f439397p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f439398q = 0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f439399r = false;

    /* renamed from: s, reason: collision with root package name */
    private final List<AdelieAVUserInfo> f439400s = new ArrayList(8);

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList<c> f439401t = new ArrayList<>(8);

    /* renamed from: u, reason: collision with root package name */
    public int f439402u = -1;

    /* renamed from: v, reason: collision with root package name */
    public boolean f439403v = false;

    /* renamed from: w, reason: collision with root package name */
    public long f439404w = 0;

    public a(int i3, String str) {
        this.f439382a = 0;
        this.f439383b = null;
        this.f439382a = i3;
        this.f439383b = str;
    }

    public AdelieAVUserInfo c(long j3) {
        AdelieAVUserInfo adelieAVUserInfo;
        synchronized (this.f439400s) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.f439400s.size()) {
                    adelieAVUserInfo = null;
                    break;
                }
                if (this.f439400s.get(i3).mUin == j3) {
                    adelieAVUserInfo = this.f439400s.get(i3);
                    break;
                }
                i3++;
            }
        }
        return adelieAVUserInfo;
    }

    public AdelieAVUserInfo d() {
        return c(this.f439396o);
    }

    public int e() {
        return this.f439384c;
    }

    public boolean f() {
        int i3 = this.f439384c;
        return i3 == 0 || i3 == 4;
    }

    public void g(long j3) {
        AdelieAVUserInfo c16 = c(j3);
        if (c16 != null) {
            synchronized (this.f439400s) {
                this.f439400s.remove(c16);
            }
        }
    }

    public void h(int i3) {
        com.tencent.qav.log.a.d("AdelieAVSession", "setSessionStatus. old status = " + this.f439384c + ", new status = " + i3);
        this.f439384c = i3;
    }

    public void i(int i3) {
        if (this.f439397p != i3) {
            com.tencent.qav.log.a.d("AdelieAVSession", "updateStageStatus, [" + this.f439397p + "->" + i3 + "]");
            this.f439397p = i3;
        }
    }

    public boolean k(long j3, boolean z16, int i3) {
        boolean z17;
        AdelieAVUserInfo c16 = c(j3);
        if (c16 != null) {
            c16.mVideoOn = z16;
            c16.mVideoSrc = i3;
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AdelieAVSession", 4, "updateUserVideoStatus, uin[" + j3 + "], on[" + z16 + "], src[" + i3 + "]");
        }
        return z17;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(200);
        sb5.append("[sessionId: ");
        sb5.append(this.f439383b);
        sb5.append(", relationType: ");
        sb5.append(this.f439386e);
        sb5.append(", peerName: ");
        sb5.append(this.f439390i);
        sb5.append(", mSessionStatus: ");
        sb5.append(this.f439384c);
        sb5.append(", relationId: ");
        sb5.append(this.f439387f);
        sb5.append(", localSpeakerOn: ");
        sb5.append(this.f439391j);
        sb5.append(", localMute: ");
        sb5.append(this.f439392k);
        sb5.append(", localVideoFlag: ");
        sb5.append(this.f439394m);
        sb5.append(", isAutoGoOnStage: ");
        sb5.append(this.f439399r);
        sb5.append(", stageStatus: ");
        sb5.append(this.f439397p);
        sb5.append("]");
        return sb5.toString();
    }

    public static String b(int i3, long j3) {
        return String.format("%s-%s", Integer.valueOf(i3), Long.valueOf(j3));
    }

    public void j(List<Long> list) {
        AdelieAVUserInfo adelieAVUserInfo;
        if (list == null || this.f439400s.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f439400s.size());
        arrayList.addAll(this.f439400s);
        synchronized (this.f439400s) {
            this.f439400s.clear();
            for (Long l3 : list) {
                int i3 = 0;
                while (true) {
                    if (i3 >= arrayList.size()) {
                        adelieAVUserInfo = null;
                        break;
                    } else {
                        if (((AdelieAVUserInfo) arrayList.get(i3)).mUin == l3.longValue()) {
                            adelieAVUserInfo = (AdelieAVUserInfo) arrayList.get(i3);
                            break;
                        }
                        i3++;
                    }
                }
                if (adelieAVUserInfo != null) {
                    this.f439400s.add(adelieAVUserInfo);
                    arrayList.remove(adelieAVUserInfo);
                } else {
                    com.tencent.qav.log.a.d("AdelieAVSession", "updateUserPos cur[" + l3 + "] not exist. ");
                }
            }
            if (arrayList.size() > 0) {
                com.tencent.qav.log.a.d("AdelieAVSession", "updateUserPos, user[" + arrayList.size() + "] not in list.");
                this.f439400s.addAll(arrayList);
            }
        }
    }

    public AdelieAVUserInfo a(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
        AdelieAVUserInfo adelieAVUserInfo;
        if (qavDef$MultiUserInfo == null) {
            return null;
        }
        AdelieAVUserInfo c16 = c(qavDef$MultiUserInfo.mUin);
        if (c16 != null) {
            QavDef$MultiUserInfo.copyTo(qavDef$MultiUserInfo, c16);
            return c16;
        }
        synchronized (this.f439400s) {
            adelieAVUserInfo = new AdelieAVUserInfo(qavDef$MultiUserInfo, this.f439396o);
            this.f439400s.add(adelieAVUserInfo);
        }
        return adelieAVUserInfo;
    }
}
