package q4;

import android.content.Context;
import android.graphics.Bitmap;
import com.qzone.album.protocol.AbsCompatRequest;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.o;
import com.tencent.mobileqq.ar.p;
import com.tencent.mobileqq.ar.s;
import com.tencent.mobileqq.ar.t;
import com.tencent.mobileqq.ar.w;
import com.tencent.ytcommon.util.YTCommonInterface;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f428322e = false;

    /* renamed from: f, reason: collision with root package name */
    public static volatile a f428323f;

    /* renamed from: a, reason: collision with root package name */
    private w f428324a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f428325b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f428326c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f428327d = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements t {

        /* renamed from: d, reason: collision with root package name */
        private int f428330d;

        /* renamed from: e, reason: collision with root package name */
        private int f428331e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f428332f;

        b(Context context) {
            this.f428332f = context;
        }

        @Override // com.tencent.mobileqq.ar.t
        public void a(int i3) {
            QZLog.d("FaceScanner", 2, "[init][onFaceDownloadSuccess] type=" + i3);
            if (i3 == 0) {
                a.this.f428325b = true;
                this.f428330d = 100;
            } else if (i3 == 1) {
                a.this.f428326c = true;
                this.f428331e = 100;
            }
            if (a.this.f428326c && a.this.f428325b) {
                a.this.n(this.f428332f);
            }
        }

        @Override // com.tencent.mobileqq.ar.t
        public void c(int i3, int i16) {
            QZLog.d("FaceScanner", 2, "onFaceDownloadError type :", Integer.valueOf(i3), " error :", Integer.valueOf(i16));
            a.d(a.this);
        }

        @Override // com.tencent.mobileqq.ar.t
        public void b(int i3, int i16) {
            if (i3 == 0) {
                this.f428330d = i16;
            } else if (i3 == 1) {
                this.f428331e = i16;
            }
            int i17 = (this.f428331e + this.f428330d) / 2;
            a.d(a.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface d {
    }

    static /* bridge */ /* synthetic */ c c(a aVar) {
        aVar.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ d d(a aVar) {
        aVar.getClass();
        return null;
    }

    private synchronized w j() {
        if (this.f428324a == null) {
            this.f428324a = new w();
        }
        return this.f428324a;
    }

    public static float[] k(Object obj, int i3, float[] fArr) {
        if (!FaceCluster.getInstance().isLoadSoSuccess() || obj == null || fArr == null) {
            return null;
        }
        if (i3 == 1 || i3 == 2) {
            return FaceCluster.getInstance().getFaceFeature2(obj, i3, fArr);
        }
        return null;
    }

    public static a l() {
        if (f428323f == null) {
            synchronized (a.class) {
                if (f428323f == null) {
                    f428323f = new a();
                }
            }
        }
        return f428323f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(Context context) {
        if (context == null) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("FaceScanner", 2, "[initModels] bInit=" + f428322e + ", thread=" + Thread.currentThread().getId());
        }
        if (f428322e) {
            return;
        }
        FaceCluster.getInstance();
        try {
            YTCommonInterface.initAuthForQQ(context);
            if (FaceCluster.getInstance().isLoadSoSuccess()) {
                int o16 = o(context);
                if (o16 != 0) {
                    QZLog.e("FaceScanner", 1, "[initModels]:load model file failed with result code = " + o16 + ", thread=" + Thread.currentThread().getId());
                    return;
                }
                if (QZLog.isColorLevel()) {
                    QZLog.d("FaceScanner", 2, "[initModels] success, thread=" + Thread.currentThread().getId() + ", mInitListener=" + ((Object) null));
                }
                f428322e = true;
                return;
            }
            QZLog.e("FaceScanner", 1, "[initModels]:loadSo failed");
        } catch (Throwable th5) {
            QZLog.e("FaceScanner", 1, "[initModels]:YTCommonInterface.initAuth failed:" + th5.toString());
        }
    }

    private static synchronized int o(Context context) {
        int init;
        synchronized (a.class) {
            String c16 = o.c();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(c16);
            String str = File.separator;
            sb5.append(str);
            sb5.append("ufdmtcc.bin");
            init = FaceCluster.getInstance().init(sb5.toString(), c16 + str + "ufat.bin", c16 + str);
        }
        return init;
    }

    public FaceTarget i(Bitmap bitmap) {
        if (!f428322e || bitmap == null) {
            return null;
        }
        return new FaceTarget();
    }

    public synchronized void m(Context context) {
        w j3 = j();
        j3.e(context, true, new C11055a(j3), new b(context), null);
        if (f428322e) {
            return;
        }
        if (FaceScanDownloadManager.i()) {
            long currentTimeMillis = System.currentTimeMillis();
            n(context);
            QZLog.d("FacePer", 2, "sdk init take time :" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void p() {
        w wVar = this.f428324a;
        if (wVar != null) {
            wVar.f();
        }
        f428323f = null;
    }

    public void q() {
        if (!o.e()) {
            w wVar = this.f428324a;
            if (wVar != null) {
                wVar.h(0);
            }
        } else {
            this.f428325b = true;
        }
        if (!p.h()) {
            w wVar2 = this.f428324a;
            if (wVar2 != null) {
                wVar2.h(1);
                return;
            }
            return;
        }
        this.f428326c = true;
    }

    public static AbsCompatRequest h(long j3, ArrayList<float[]> arrayList, AbsCompatRequest.a aVar, boolean z16) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return com.qzone.album.base.Service.a.W().q(j3, arrayList, aVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: q4.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11055a implements s {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ w f428328d;

        C11055a(w wVar) {
            this.f428328d = wVar;
        }

        @Override // com.tencent.mobileqq.ar.s
        public void k() {
            boolean m3 = this.f428328d.m();
            if (QZLog.isColorLevel()) {
                QZLog.d("FaceScanner", 2, "face early download config on ready:" + m3);
            }
            a.c(a.this);
        }

        @Override // com.tencent.mobileqq.ar.s
        public void e(int i3) {
        }

        @Override // com.tencent.mobileqq.ar.s
        public void j(ArEffectConfig arEffectConfig) {
        }

        @Override // com.tencent.mobileqq.ar.s
        public void l(ArConfigInfo arConfigInfo) {
        }

        @Override // com.tencent.mobileqq.ar.s
        public void m(ARCommonConfigInfo aRCommonConfigInfo) {
        }

        @Override // com.tencent.mobileqq.ar.s
        public void onDownloadSuccess() {
        }

        @Override // com.tencent.mobileqq.ar.s
        public void i(long j3, long j16) {
        }
    }
}
