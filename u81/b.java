package u81;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    public static float[] f438537g;

    /* renamed from: h, reason: collision with root package name */
    public static final float[] f438538h;

    /* renamed from: i, reason: collision with root package name */
    private static final FloatBuffer f438539i;

    /* renamed from: j, reason: collision with root package name */
    private static final FloatBuffer f438540j;

    /* renamed from: a, reason: collision with root package name */
    private final String f438541a;

    /* renamed from: b, reason: collision with root package name */
    private final String f438542b;

    /* renamed from: c, reason: collision with root package name */
    private int f438543c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f438544d;

    /* renamed from: e, reason: collision with root package name */
    public int f438545e;

    /* renamed from: f, reason: collision with root package name */
    protected int f438546f;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f438537g = fArr;
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f438538h = fArr2;
        f438539i = GlUtil.createFloatBuffer(fArr);
        f438540j = GlUtil.createFloatBuffer(fArr2);
    }

    public b() {
        this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", GPUBaseFilter.NO_FILTER_FRAGMENT_SHADER);
    }

    public static void a(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                SLog.e("GPUBaseFilter", new RuntimeException(str + ": glError " + glGetError));
            } else {
                return;
            }
        }
    }

    public static void b(int i3, String str) {
        if (i3 < 0) {
            SLog.e("GPUBaseFilter", new RuntimeException("Unable to locate '" + str + "' in program"));
        }
    }

    public void c() {
        SLog.d("GPUBaseFilter", "destroy");
        this.f438544d = false;
        GLES20.glDeleteProgram(this.f438543c);
        this.f438543c = 0;
        g();
    }

    public void d(int i3, float[] fArr, float[] fArr2) {
        a("onDrawFrame start");
        int e16 = e();
        if (fArr == null) {
            fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
        }
        if (fArr2 == null) {
            fArr2 = new float[16];
            Matrix.setIdentityM(fArr2, 0);
        }
        GLES20.glUseProgram(e16);
        a("glUseProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(e16, "aPosition");
        b(glGetAttribLocation, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(e16, "aTextureCoord");
        b(glGetAttribLocation2, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(e16, "uMVPMatrix");
        b(glGetUniformLocation, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(e16, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        b(glGetUniformLocation2, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) f438539i);
        a("glVertexAttribPointer aPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        a("glEnableVertexAttribArray mPositionHandle");
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) f438540j);
        a("glVertexAttribPointer mTextureHandle");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        a("glEnableVertexAttribArray mTextureHandle");
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f438545e, i3);
        h();
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f438545e, 0);
    }

    public int e() {
        return this.f438543c;
    }

    public void f() {
        if (this.f438544d) {
            return;
        }
        int createProgram = GlUtil.createProgram(this.f438541a, this.f438542b);
        this.f438543c = createProgram;
        if (createProgram == 0) {
            SLog.e("GPUBaseFilter", new RuntimeException("failed creating program " + getClass().getSimpleName()));
        }
        this.f438544d = true;
        i();
    }

    public b(String str, String str2) {
        this.f438541a = str;
        this.f438542b = str2;
        this.f438545e = GLSLRender.GL_TEXTURE_2D;
        this.f438546f = 101;
    }

    protected void g() {
    }

    protected void h() {
    }

    protected void i() {
    }
}
