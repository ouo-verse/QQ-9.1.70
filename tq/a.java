package tq;

import android.text.TextUtils;
import com.tencent.aekit.openrender.util.AEProfilerBase;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.report.atta.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.light.device.OfflineConfig;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends AEProfilerBase implements c {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f437071h = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f437072a = false;

    /* renamed from: b, reason: collision with root package name */
    private List<Float> f437073b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private long f437074c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f437075d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f437076e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f437077f = false;

    /* renamed from: g, reason: collision with root package name */
    private String f437078g = "none";

    public a() {
        f437071h = false;
        this.mEnableBase = true;
    }

    private float i() {
        j("getAverageFps: fps list size=" + this.f437073b.size());
        float f16 = 0.0f;
        for (int i3 = 0; i3 < this.f437073b.size(); i3++) {
            f16 += this.f437073b.get(i3).floatValue();
        }
        return f16 / this.f437073b.size();
    }

    private void j(String str) {
        if (f437071h) {
            ms.a.f("AEFpsManager", "report fps: " + str);
        }
    }

    private void k() {
        if (!this.f437072a || this.f437077f || System.currentTimeMillis() - this.f437074c < 5000) {
            return;
        }
        int i3 = this.f437076e;
        if (i3 >= 30) {
            long j3 = this.f437075d;
            if (j3 > 0) {
                float f16 = (i3 * 1000.0f) / ((float) j3);
                if (this.f437073b.size() >= 500) {
                    this.f437073b.remove(0);
                }
                this.f437073b.add(Float.valueOf(f16));
                int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.context);
                if ((phonePerfLevel >= 5 && f16 < 30.0f) || ((phonePerfLevel <= 5 && f16 < 20.0f) || (phonePerfLevel < 5 && phonePerfLevel > 1 && f16 < 25.0f))) {
                    com.tencent.aelight.camera.report.atta.d.d("fps_exception", Arrays.asList(String.valueOf(f16)), Arrays.asList(Long.valueOf(e.a(BaseApplication.getContext())), Long.valueOf(e.b())));
                }
            }
            this.f437076e = 0;
            this.f437075d = 0L;
            return;
        }
        long j16 = this.mOneFrameCost;
        if (j16 != 0) {
            this.f437075d += j16;
            this.f437076e = i3 + 1;
        }
    }

    private void l(float f16) {
        if (!this.f437072a || this.f437077f || System.currentTimeMillis() - this.f437074c < 5000) {
            return;
        }
        this.f437073b.add(Float.valueOf(f16));
        if (this.f437073b.size() > 5) {
            m();
            this.f437073b.clear();
        }
    }

    private void m() {
        if (this.f437073b.size() == 0) {
            return;
        }
        float i3 = i();
        com.tencent.aelight.camera.ae.report.b.b().Q0(this.f437078g, AECameraConstants.sCurrentCamera == 1, i3, 0.0d, 0.0d, "");
        j("fps=" + i3);
    }

    private void n() {
        j("startMonitor");
        this.f437072a = true;
    }

    @Override // tq.c
    public void a() {
        j("onCameraOpened");
    }

    @Override // tq.c
    public void b(boolean z16) {
        j("onModeChangedToGif");
        this.f437077f = z16;
        if (z16) {
            o();
        }
    }

    @Override // tq.c
    public void c() {
        j("onEnterActivity");
    }

    @Override // tq.c
    public void d() {
        j("onExitActivity");
        o();
    }

    @Override // tq.c
    public void e(float f16) {
        l(f16);
    }

    @Override // tq.c
    public void f() {
        j("onCaptureVideo");
        m();
        o();
    }

    @Override // tq.c
    public void g(VideoMaterial videoMaterial) {
        j("onMaterialSelected, useMaterial=" + videoMaterial);
        if (videoMaterial != null && !TextUtils.isEmpty(videoMaterial.getId())) {
            this.f437078g = videoMaterial.getId();
        } else {
            this.f437078g = "none";
        }
        o();
        n();
    }

    @Override // tq.c
    public void h(boolean z16) {
        j("onCameraSwitch");
        m();
        o();
        n();
    }

    public void o() {
        j("stopMonitor");
        this.f437072a = false;
        this.f437074c = 0L;
        this.f437075d = 0L;
        this.f437076e = 0;
        this.f437073b.clear();
    }

    @Override // tq.c
    public void onDrawFrame() {
        k();
    }

    @Override // tq.c
    public void onFirstFrame() {
        j("onFirstFrame");
        this.f437074c = System.currentTimeMillis();
        n();
    }
}
