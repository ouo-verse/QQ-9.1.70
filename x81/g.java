package x81;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class g {
    public static final float[] I;
    public float[] F;
    public short[] G;
    public a H;

    /* renamed from: a, reason: collision with root package name */
    public int f447425a;

    /* renamed from: c, reason: collision with root package name */
    public String f447427c;

    /* renamed from: d, reason: collision with root package name */
    public l f447428d;

    /* renamed from: e, reason: collision with root package name */
    public c f447429e;

    /* renamed from: f, reason: collision with root package name */
    public d f447430f;

    /* renamed from: g, reason: collision with root package name */
    public int f447431g;

    /* renamed from: h, reason: collision with root package name */
    public int f447432h;

    /* renamed from: i, reason: collision with root package name */
    public int f447433i;

    /* renamed from: j, reason: collision with root package name */
    public int f447434j;

    /* renamed from: k, reason: collision with root package name */
    public int f447435k;

    /* renamed from: l, reason: collision with root package name */
    public int f447436l;

    /* renamed from: m, reason: collision with root package name */
    public int f447437m;

    /* renamed from: n, reason: collision with root package name */
    public int f447438n;

    /* renamed from: o, reason: collision with root package name */
    public int f447439o;

    /* renamed from: q, reason: collision with root package name */
    public float f447441q;

    /* renamed from: r, reason: collision with root package name */
    public float f447442r;

    /* renamed from: s, reason: collision with root package name */
    public float f447443s;

    /* renamed from: u, reason: collision with root package name */
    public int f447445u;

    /* renamed from: p, reason: collision with root package name */
    public int f447440p = -1;

    /* renamed from: t, reason: collision with root package name */
    private boolean f447444t = false;

    /* renamed from: v, reason: collision with root package name */
    public String f447446v = j.f447462a;

    /* renamed from: w, reason: collision with root package name */
    public String f447447w = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES samplerOES;\nuniform sampler2D sampler2d1;\nuniform sampler2D sampler2d2;\nuniform sampler2D sampler2d3;\nuniform vec4 u_screenColor;\nvarying vec2 vTextureCoord;\n";

    /* renamed from: x, reason: collision with root package name */
    public String f447448x = "//\u62a0\u50cf\u7b97\u6cd5\u76f8\u5173\u5b9a\u4e49\u7247\u6bb5\n";

    /* renamed from: y, reason: collision with root package name */
    public String f447449y = "//\u7528\u6237\u81ea\u5df1\u5b9a\u4e49\u53d8\u91cf\u53ca\u65b9\u6cd5\u76f8\u5173\u7247\u6bb5\n";

    /* renamed from: z, reason: collision with root package name */
    public String f447450z = "void main() {\n    vec2 position = vTextureCoord;\n";
    public String A = "    //\u7528\u6237\u5b9a\u4e49\u7247\u6bb5\uff0c\u7528\u4e8e\u5728\u83b7\u53d6\u989c\u8272\u503c\u524d\u5904\u7406, \u5982\u7eb9\u7406\u5750\u6807\u6539\u53d8\n";
    public String B = "    gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n    #if defined(TEXTURE_TYPE_OES)\n        gl_FragColor = texture2D(samplerOES, position);\n        gl_FragColor.r = max(0.0, min(gl_FragColor.r, 1.0));\n        gl_FragColor.g = max(0.0, min(gl_FragColor.g, 1.0));\n        gl_FragColor.b = max(0.0, min(gl_FragColor.b, 1.0));\n    #endif\n    #if defined(TEXTURE_TYPE_SAMPLER2D)\n        gl_FragColor = texture2D(sampler2d1, position);\n    #endif\n    #if defined(TEXTURE_TYPE_Y_U_V)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        yuv.y = texture2D(sampler2d2, position).r-0.5;\n        yuv.z = texture2D(sampler2d3, position).r-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;\n        gl_FragColor.a = 1.0;\n    #endif\n    #if defined(TEXTURE_TYPE_Y_UV)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        vec2 uv = texture2D(sampler2d2, position).ra;\n        yuv.y = uv.x-0.5;\n        yuv.z = uv.y-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;//yuv->rgb\n        gl_FragColor.a = 1.0;\n    #endif\n";
    public String C = j.f447463b;
    public String D = j.f447464c;
    public String E = j.f447465d;

    /* renamed from: b, reason: collision with root package name */
    public String f447426b = "precision mediump float;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main() {\n   gl_Position = uMVPMatrix * aPosition;\n   vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}";

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void init(int i3);

        void update();
    }

    static {
        float[] fArr = new float[16];
        I = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public g(int i3) {
        this.f447445u = 0;
        this.f447445u = i3;
    }

    private final int d(i iVar, boolean z16) {
        a(iVar);
        a aVar = this.H;
        if (aVar != null) {
            aVar.update();
        }
        if (this.f447440p == 1) {
            this.f447429e.a(this.f447431g, this.f447432h);
        } else {
            this.f447428d.a();
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glBindFramebuffer(36160, 0);
        j.a("keyingHandleAfter");
        if (!z16) {
            return 0;
        }
        return this.f447430f.c();
    }

    private final void e(i iVar, float[] fArr, float[] fArr2, boolean z16, int i3, int i16) {
        if (!this.f447444t) {
            c(-1, 0.0f, 0.0f, 0.0f);
        }
        GLES20.glUseProgram(this.f447425a);
        j.a("glUseProgram");
        if (z16) {
            this.f447430f.a(i3, i16);
            GLES20.glViewport(0, 0, i3, i16);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        if (this.f447440p != 1) {
            this.f447428d.c(this.f447431g, this.f447432h);
        }
        GLES20.glUniformMatrix4fv(this.f447433i, 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(this.f447434j, 1, false, fArr2, 0);
        int i17 = this.f447439o;
        if (i17 != -1) {
            GLES20.glUniform4f(i17, iVar.f447452b, iVar.f447453c, iVar.f447454d, 1.0f);
        }
        j.a("keyingHandleBefore");
    }

    protected abstract void a(i iVar);

    protected String b() {
        this.f447446v = j.c(this.f447445u);
        return this.f447446v + this.f447447w + this.f447448x + this.f447449y + this.f447450z + this.A + this.B + this.C + this.D + this.E;
    }

    public final void c(int i3, float f16, float f17, float f18) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(this.f447426b)) {
            if (this.f447444t) {
                return;
            }
            this.f447444t = true;
            this.f447440p = i3;
            this.f447441q = f16;
            this.f447442r = f17;
            this.f447443s = f18;
            this.f447427c = b();
            if (QLog.isDevelopLevel()) {
                QLog.d("KeyingBase", 4, "init. markerType = " + this.f447440p + ", markerWidth = " + this.f447441q + ", markerHeight = " + this.f447442r + ", mFragmentShader = \n" + this.f447427c);
            }
            if (this.f447440p == 1) {
                this.f447429e = new c(1.0f, this.f447441q, this.f447442r, this.f447443s);
            } else if (this.F != null && this.G != null) {
                this.f447428d = new l(this.F, this.G);
            } else {
                this.f447428d = new l();
            }
            this.f447430f = new d();
            this.f447425a = j.b(this.f447426b, this.f447427c);
            j.a("createProgram");
            int i16 = this.f447425a;
            if (i16 == 0) {
                return;
            }
            this.f447431g = GLES20.glGetAttribLocation(i16, "aPosition");
            j.a("glGetAttribLocation aPosition");
            if (this.f447431g != -1) {
                this.f447432h = GLES20.glGetAttribLocation(this.f447425a, "aTextureCoord");
                j.a("glGetAttribLocation aTextureCoord");
                if (this.f447432h != -1) {
                    this.f447433i = GLES20.glGetUniformLocation(this.f447425a, "uMVPMatrix");
                    j.a("glGetUniformLocation uMVPMatrix");
                    this.f447434j = GLES20.glGetUniformLocation(this.f447425a, "uSTMatrix");
                    j.a("glGetUniformLocation uSTMatrix");
                    this.f447438n = GLES20.glGetUniformLocation(this.f447425a, "samplerOES");
                    j.a("glGetUniformLocation samplerOES");
                    this.f447435k = GLES20.glGetUniformLocation(this.f447425a, "sampler2d1");
                    j.a("glGetUniformLocation sampler2d1");
                    this.f447436l = GLES20.glGetUniformLocation(this.f447425a, "sampler2d2");
                    j.a("glGetUniformLocation sampler2d2");
                    this.f447437m = GLES20.glGetUniformLocation(this.f447425a, "sampler2d3");
                    j.a("glGetUniformLocation sampler2d3");
                    this.f447439o = GLES20.glGetUniformLocation(this.f447425a, "u_screenColor");
                    j.a("glGetUniformLocation u_screenColor");
                    h();
                    a aVar = this.H;
                    if (aVar != null) {
                        aVar.init(this.f447425a);
                    }
                    QLog.i("KeyingBase", 2, " init need " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    return;
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        throw new IllegalArgumentException("mVertexShader can not be empty!");
    }

    public final int f(int[] iArr, i iVar, float[] fArr, float[] fArr2) {
        return g(iArr, iVar, fArr, fArr2, false, 0, 0);
    }

    public final int g(int[] iArr, i iVar, float[] fArr, float[] fArr2, boolean z16, int i3, int i16) {
        if (iArr != null) {
            e(iVar, fArr, fArr2, z16, i3, i16);
            int i17 = this.f447445u;
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 == 3 || i17 == 4) {
                        if (iArr.length >= 2) {
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
                            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                            GLES20.glUniform1i(this.f447435k, 0);
                            GLES20.glActiveTexture(33985);
                            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[1]);
                            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                            GLES20.glUniform1i(this.f447436l, 1);
                            if (this.f447445u == 3) {
                                if (iArr.length >= 3) {
                                    GLES20.glActiveTexture(33986);
                                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[2]);
                                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                                    GLES20.glUniform1i(this.f447437m, 2);
                                } else {
                                    throw new IllegalArgumentException("textureIds.size should >= 3!");
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("textureIds.size should >= 2!");
                        }
                    }
                } else if (iArr.length >= 1) {
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                    GLES20.glUniform1i(this.f447435k, 0);
                } else {
                    throw new IllegalArgumentException("textureIds.size should >= 1!");
                }
            } else if (iArr.length >= 1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, iArr[0]);
                GLES20.glTexParameterf(36197, 10241, 9728.0f);
                GLES20.glTexParameterf(36197, 10240, 9729.0f);
                GLES20.glTexParameteri(36197, 10242, 33071);
                GLES20.glTexParameteri(36197, 10243, 33071);
                GLES20.glUniform1i(this.f447438n, 0);
            } else {
                throw new IllegalArgumentException("textureIds.size should >= 1!");
            }
            j.a("keyingTexture");
            return d(iVar, z16);
        }
        throw new IllegalArgumentException("textureIds can not be null!");
    }

    protected abstract void h();

    public void i() {
        if (!this.f447444t) {
            return;
        }
        GLES20.glDeleteProgram(this.f447425a);
        d dVar = this.f447430f;
        if (dVar != null) {
            dVar.b();
            this.f447430f = null;
        }
    }

    public void j(float[] fArr, short[] sArr) {
        this.F = fArr;
        this.G = sArr;
    }

    public void k(String str, String str2, String str3, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f447449y = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.A = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.D = str3;
        }
        this.H = aVar;
    }
}
