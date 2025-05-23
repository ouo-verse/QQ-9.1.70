package tq;

import com.tencent.aelight.camera.api.IAELaunchRecorder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f437079a = false;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Long> f437080b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private boolean f437081c = true;

    /* renamed from: d, reason: collision with root package name */
    private int f437082d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f437083e = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f437084f = -1;

    /* renamed from: g, reason: collision with root package name */
    private boolean f437085g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f437086h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f437087i = false;

    /* renamed from: j, reason: collision with root package name */
    private long f437088j;

    /* renamed from: k, reason: collision with root package name */
    private long f437089k;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f437090a = new b();
    }

    b() {
    }

    private long c(String str, String str2) {
        long i3 = i(str);
        long i16 = i(str2);
        if (i16 <= 0 || i3 <= i16) {
            return 0L;
        }
        return i3 - i16;
    }

    private boolean d() {
        return true;
    }

    private long g() {
        return this.f437084f - this.f437083e;
    }

    public static b h() {
        return a.f437090a;
    }

    private long i(String str) {
        if (this.f437080b.containsKey(str)) {
            return this.f437080b.get(str).longValue();
        }
        return 0L;
    }

    public void a() {
        if (d()) {
            return;
        }
        if (!this.f437079a) {
            this.f437079a = true;
            this.f437080b.clear();
        }
        ms.a.f("CameraLaunchPerf", "beginSession----");
    }

    public void b() {
        if (!d() && this.f437089k > 0) {
            ms.a.f("CameraLaunchPerf", "circle camera launch cost=" + (System.currentTimeMillis() - this.f437089k));
            this.f437089k = 0L;
        }
    }

    public void e() {
        if (d()) {
            return;
        }
        if (this.f437079a) {
            this.f437079a = false;
            this.f437080b.clear();
        }
        ms.a.f("CameraLaunchPerf", "endSession----");
    }

    public long f() {
        String str;
        if (d()) {
            return g();
        }
        if (k()) {
            str = "downloadSDKSourceTime";
        } else {
            str = "mainProcessLaunch";
        }
        return c("onDrawFrameReal-end", str);
    }

    public boolean j() {
        if (d()) {
            return this.f437082d < 1;
        }
        return this.f437081c;
    }

    public boolean k() {
        if (d()) {
            return this.f437085g;
        }
        return this.f437080b.containsKey("downloadSDKSourceTime");
    }

    public boolean l() {
        return this.f437087i;
    }

    public boolean m() {
        return this.f437086h;
    }

    public void n(String str, String str2) {
        if (d()) {
            return;
        }
        ms.a.f("CameraLaunchPerf******", str + "--" + str2);
    }

    public void o(String str) {
        if (d()) {
            if ("onDrawFrameReal-end".equals(str)) {
                this.f437084f = System.currentTimeMillis();
            }
        } else {
            if (this.f437079a && !this.f437080b.containsKey(str)) {
                this.f437080b.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            ms.a.f("CameraLaunchPerf", str);
        }
    }

    public void p(String str, long j3) {
        if (d()) {
            return;
        }
        if (this.f437079a && !this.f437080b.containsKey(str)) {
            this.f437080b.put(str, Long.valueOf(j3));
        }
        ms.a.f("CameraLaunchPerf", str + " real happened at " + j3);
    }

    public void q(long j3) {
        this.f437088j = j3;
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f437088j > 0) {
            ms.a.f("CameraLaunchPerf", "old AIO launch total cost=" + (currentTimeMillis - this.f437088j));
        }
    }

    public void s(boolean z16) {
        if (d()) {
            if (z16) {
                this.f437082d++;
                ms.a.f("CameraLaunchPerf", "mLaunchCountForGray:" + this.f437082d);
                return;
            }
            return;
        }
        if (this.f437079a) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("collect data:{");
            if (!z16) {
                sb5.append("userClick-startActivity=");
                sb5.append(c(IAELaunchRecorder.MILESTONE_START_ACTIVITY, IAELaunchRecorder.MILESTONE_CLICK));
                sb5.append(", userClickDispatch=");
                sb5.append(c(IAELaunchRecorder.MILESTONE_LAUNCHER_BEGIN, IAELaunchRecorder.MILESTONE_CLICK));
                sb5.append(", launchAECameraUnit=");
                sb5.append(c(IAELaunchRecorder.MILESTONE_LAUNCHER_END, IAELaunchRecorder.MILESTONE_LAUNCHER_BEGIN));
            } else {
                boolean z17 = this.f437081c;
                this.f437081c = false;
                sb5.append("isColdLaunch=");
                sb5.append(z17);
                sb5.append(", startActivity-firstRealFrame=");
                sb5.append(c("onDrawFrameReal-end", "mainProcessLaunch"));
                sb5.append(", startActivity-firstFakeFrame=");
                sb5.append(c("onDrawFrameFake-end1", "mainProcessLaunch"));
                sb5.append(", ipc_cost=");
                sb5.append(c("activityOnCreateBegin", "mainProcessLaunch"));
                sb5.append(", activityOnCreate=");
                sb5.append(c("activityOnCreateEnd", "activityOnCreateBegin"));
                sb5.append(", buildCaptureUnit=");
                sb5.append(c("buildCaptureUnit-end", "buildCaptureUnit-begin"));
                sb5.append(", unitOnCreateView=");
                sb5.append(c("unitOnCreateView-end", "unitOnCreateView-begin"));
                sb5.append(", unitInflateView=");
                sb5.append(c("unitInflateView-end", "unitInflateView-begin"));
                sb5.append(", glSurfaceViewStaticInit=");
                sb5.append(c("glSurfaceViewStaticInit-end", "glSurfaceViewStaticInit-begin"));
                sb5.append(", activityOnStart=");
                sb5.append(c("activityOnStartEnd", "activityOnStartBegin"));
                sb5.append(", activityOnResume=");
                sb5.append(c("activityOnResumeEnd", "activityOnResumeBegin"));
                sb5.append(", activityOnResume-onSurfaceCreated=");
                sb5.append(c("onSurfaceCreated-begin", "activityOnResumeEnd"));
                sb5.append(", onSurfaceCreated=");
                sb5.append(c("onSurfaceCreated-end", "onSurfaceCreated-begin"));
                sb5.append(", startCamPreview-onFrameAvailable=");
                sb5.append(c("onFrameAvailable", "startCameraPreview-end"));
                sb5.append(", onDrawFrame1=");
                sb5.append(c("onDrawFrameFake-end1", "onDrawFrameFake-begin1"));
                sb5.append(", onDrawFrame2=");
                sb5.append(c("onDrawFrameFake-end2", "onDrawFrameFake-begin2"));
                sb5.append(", onDrawFrame3=");
                sb5.append(c("onDrawFrameFake-end3", "onDrawFrameFake-begin3"));
                sb5.append(", onDrawFrameReal=");
                sb5.append(c("onDrawFrameReal-end", "onDrawFrameReal-begin"));
                sb5.append(", filterProcessInitFilters=");
                sb5.append(c("FilterProcessInitFilters-end", "FilterProcessInitFilters-begin"));
                sb5.append(", filterMgrDraw=");
                sb5.append(c(IAELaunchRecorder.MILESTONE_FILTER_MGR_DRAW_END, IAELaunchRecorder.MILESTONE_FILTER_MGR_DRAW_BEGIN));
                sb5.append(", onDrawFrame1End-onFrameAvailable=");
                sb5.append(c("onFrameAvailable", "onDrawFrameFake-end1"));
            }
            sb5.append("}");
            ms.a.f("CameraLaunchPerf", sb5.toString());
        }
    }

    public void t(boolean z16) {
        this.f437087i = z16;
    }

    public void u(long j3, boolean z16) {
        if (d()) {
            this.f437083e = j3;
            this.f437085g = z16;
        }
    }

    public void v(long j3, boolean z16, boolean z17) {
        this.f437086h = z17;
        u(j3, z16);
    }
}
