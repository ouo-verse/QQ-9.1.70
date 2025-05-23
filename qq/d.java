package qq;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* renamed from: g, reason: collision with root package name */
    private String f429228g;

    /* renamed from: m, reason: collision with root package name */
    private LightNode f429234m;

    /* renamed from: o, reason: collision with root package name */
    private a f429236o;

    /* renamed from: a, reason: collision with root package name */
    private int f429222a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f429223b = 0;

    /* renamed from: c, reason: collision with root package name */
    private qq.a f429224c = new qq.a();

    /* renamed from: d, reason: collision with root package name */
    private f f429225d = new f();

    /* renamed from: e, reason: collision with root package name */
    private Frame f429226e = new Frame();

    /* renamed from: f, reason: collision with root package name */
    private boolean f429227f = true;

    /* renamed from: h, reason: collision with root package name */
    private BaseFilter f429229h = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");

    /* renamed from: i, reason: collision with root package name */
    private BaseFilter f429230i = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");

    /* renamed from: j, reason: collision with root package name */
    private BaseFilter f429231j = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");

    /* renamed from: k, reason: collision with root package name */
    private Frame f429232k = new Frame();

    /* renamed from: l, reason: collision with root package name */
    private Frame f429233l = new Frame();

    /* renamed from: n, reason: collision with root package name */
    private boolean f429235n = false;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        public int f429237a;

        /* renamed from: b, reason: collision with root package name */
        public float f429238b;

        /* renamed from: c, reason: collision with root package name */
        public float f429239c;

        /* renamed from: d, reason: collision with root package name */
        public float f429240d;

        /* renamed from: e, reason: collision with root package name */
        public float f429241e;

        a() {
        }
    }

    private Frame f(Frame frame, PTFaceAttr pTFaceAttr) {
        if (this.f429234m == null) {
            LightNode lightNode = new LightNode();
            this.f429234m = lightNode;
            lightNode.initPreviewSize(this.f429222a, this.f429223b);
            this.f429234m.apply();
            this.f429234m.setSyncMode(true);
            HashMap hashMap = new HashMap();
            hashMap.put("ai.segmentation.bg.enable", "false");
            hashMap.put("ai.face.enable", "false");
            hashMap.put("basicFaceBeauty.enable", "false");
            hashMap.put("transparentMode", "1");
            this.f429234m.updateCameraConfigData(hashMap);
        }
        if (!TextUtils.isEmpty(this.f429228g)) {
            this.f429234m.updateAsset(this.f429228g);
            this.f429228g = "";
            HashMap hashMap2 = new HashMap();
            hashMap2.put("ai.segmentation.bg.enable", "false");
            hashMap2.put("ai.face.enable", "false");
            hashMap2.put("basicFaceBeauty.enable", "false");
            hashMap2.put("transparentMode", "1");
            this.f429234m.updateCameraConfigData(hashMap2);
        }
        this.f429234m.setPtFaceAttr(pTFaceAttr);
        return this.f429234m.render(frame);
    }

    public void a(String str) {
        if (this.f429234m != null) {
            if (TextUtils.isEmpty(str)) {
                this.f429228g = AEResUtil.w();
                return;
            }
            this.f429228g = str + File.separator + TemplateBean.TEMPLATE_JSON;
        }
    }

    public void b() {
        this.f429224c.clearGLSL();
        this.f429225d.clearGLSL();
        this.f429226e.clear();
        this.f429229h.clearGLSL();
        this.f429230i.clearGLSL();
        this.f429231j.clearGLSL();
        this.f429232k.clear();
        this.f429233l.clear();
        LightNode lightNode = this.f429234m;
        if (lightNode != null) {
            lightNode.clear();
        }
        a aVar = this.f429236o;
        if (aVar != null) {
            GLES20.glDeleteTextures(1, new int[]{aVar.f429237a}, 0);
        }
    }

    public void c() {
        this.f429224c.apply();
        this.f429225d.apply();
        this.f429229h.apply();
        this.f429230i.apply();
        this.f429231j.apply();
    }

    public void d(int i3, int i16) {
        this.f429222a = i3;
        this.f429223b = i16;
    }

    public void g(boolean z16) {
        this.f429235n = z16;
    }

    public void h(String str, int i3, String str2, String str3, int i16, String str4, float f16, float f17, float f18, float f19) {
        this.f429236o = new a();
        rq.d dVar = new rq.d((int) (f18 * 320.0f), (int) (320.0f * f19));
        dVar.j(str);
        dVar.l(i3);
        dVar.k(str2);
        dVar.h(str3);
        dVar.i(i16);
        dVar.f(str4);
        dVar.b();
        this.f429236o.f429237a = RendererUtils.createTexture(dVar.d());
        dVar.e();
        a aVar = this.f429236o;
        aVar.f429238b = f16;
        aVar.f429239c = f17;
        aVar.f429240d = f18;
        aVar.f429241e = f19;
    }

    public Frame e(Frame frame, int i3, int i16, PTFaceAttr pTFaceAttr) {
        Frame frame2;
        if (this.f429227f) {
            this.f429224c.a(frame, i3, i16, this.f429226e);
            frame2 = this.f429226e;
        } else {
            frame2 = frame;
        }
        if (this.f429235n && this.f429236o != null) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            a aVar = this.f429236o;
            float f16 = (aVar.f429238b * 2.0f) - 1.0f;
            float f17 = (aVar.f429239c * 2.0f) - 1.0f;
            float f18 = (aVar.f429240d * 2.0f) + f16;
            float f19 = (aVar.f429241e * 2.0f) + f17;
            this.f429229h.setPositions(new float[]{f16, f17, f16, f19, f18, f19, f18, f17});
            this.f429229h.RenderProcess(this.f429236o.f429237a, frame2.width, frame2.height, -1, 0.0d, frame2);
            GLES20.glDisable(3042);
        }
        this.f429231j.setRotationAndFlip(0, 0, 1);
        this.f429231j.RenderProcess(frame2.getTextureId(), frame2.width, frame2.height, -1, 0.0d, this.f429233l);
        this.f429230i.RenderProcess(this.f429233l.getTextureId(), 320, 320, -1, 0.0d, this.f429232k);
        Frame RenderProcess = this.f429225d.RenderProcess(this.f429232k.getTextureId(), 320, 320);
        Frame f26 = f(RenderProcess, pTFaceAttr);
        RenderProcess.unlock();
        return f26;
    }
}
