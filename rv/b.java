package rv;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.filter.GLSLRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import pv.f;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: i, reason: collision with root package name */
    private static int f432526i = -1;

    /* renamed from: j, reason: collision with root package name */
    private static b f432527j;

    /* renamed from: a, reason: collision with root package name */
    private int f432528a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f432529b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f432530c;

    /* renamed from: d, reason: collision with root package name */
    private int f432531d;

    /* renamed from: e, reason: collision with root package name */
    private int f432532e;

    /* renamed from: f, reason: collision with root package name */
    private int f432533f;

    /* renamed from: g, reason: collision with root package name */
    private FloatBuffer f432534g;

    /* renamed from: h, reason: collision with root package name */
    boolean f432535h;

    b() {
        int i3 = f432526i;
        this.f432530c = i3;
        this.f432531d = i3;
        this.f432532e = i3;
        this.f432533f = i3;
        this.f432534g = null;
        this.f432535h = true;
    }

    public static b c() {
        if (f432527j == null) {
            f432527j = new b();
        }
        return f432527j;
    }

    private void d() {
        if (this.f432531d == f432526i) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            this.f432531d = iArr[0];
        }
        this.f432530c = f(this.f432528a, this.f432529b, this.f432531d);
    }

    private void e() {
        if (this.f432533f == f432526i) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            this.f432533f = iArr[0];
        }
        this.f432532e = g(this.f432528a, this.f432529b, this.f432533f);
    }

    private int f(int i3, int i16, int i17) {
        int i18 = this.f432530c;
        if (i18 == f432526i) {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            i18 = iArr[0];
        }
        GLES20.glBindFramebuffer(36160, i18);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i17);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i17, 0);
        GLES20.glBindFramebuffer(36160, 0);
        return i18;
    }

    private int g(int i3, int i16, int i17) {
        int i18 = this.f432532e;
        if (i18 == f432526i) {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            i18 = iArr[0];
        }
        GLES20.glBindFramebuffer(36160, i18);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i17);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i17, 0);
        GLES20.glBindFramebuffer(36160, 0);
        return i18;
    }

    private void h() {
        if (this.f432534g != null) {
            return;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.f432534g = asFloatBuffer;
        asFloatBuffer.put(new float[]{-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f});
        this.f432534g.position(0);
    }

    public void a(ov.a aVar, int i3, int i16, int i17, int i18, int i19, int i26, int i27, float[] fArr, int i28, int i29) {
        int i36 = i3 * 2;
        if (this.f432528a != i36 || this.f432530c == f432526i) {
            this.f432528a = i36;
            this.f432529b = i16 * 2;
            d();
            e();
            h();
        }
        GLES20.glBindFramebuffer(36160, this.f432530c);
        GLES20.glViewport(0, 0, this.f432528a, this.f432529b);
        GLES20.glClearColor(0.4f, 0.4f, 0.4f, 1.0f);
        GLES20.glClear(16640);
        TextureProgram b16 = f.b(2);
        qv.b[] c16 = b16.c();
        GLES20.glUseProgram(b16.b());
        float f16 = i3;
        GLES20.glUniform1f(b16.c()[7].f429680a, f16);
        float f17 = i16;
        GLES20.glUniform1f(b16.c()[8].f429680a, f17);
        GLES20.glUniformMatrix4fv(b16.c()[9].f429680a, 1, false, fArr, 0);
        GLES20.glUniform1i(b16.c()[10].f429680a, i28);
        GLES20.glUniform1i(b16.c()[11].f429680a, i29);
        ov.b.x(false);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i19);
        GLES20.glUniform1i(c16[4].f429680a, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i26);
        GLES20.glUniform1i(c16[5].f429680a, 1);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i27);
        GLES20.glUniform1i(c16[6].f429680a, 2);
        GLES20.glUniform1f(c16[2].f429680a, 1.0f);
        GLES20.glUniformMatrix4fv(c16[1].f429680a, 1, false, AVGLUtils.matrixV, 0);
        int i37 = c16[3].f429680a;
        float[] fArr2 = AVGLUtils.matrix;
        GLES20.glUniformMatrix4fv(i37, 1, false, fArr2, 0);
        GLES20.glVertexAttribPointer(c16[0].f429680a, 2, 5126, false, 8, (Buffer) this.f432534g);
        GLES20.glEnableVertexAttribArray(c16[0].f429680a);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(c16[0].f429680a);
        GLES20.glBindFramebuffer(36160, this.f432532e);
        GLES20.glViewport(0, 0, this.f432528a, this.f432529b);
        GLES20.glClearColor(0.4f, 0.4f, 0.4f, 1.0f);
        GLES20.glClear(16640);
        TextureProgram b17 = f.b(3);
        qv.b[] c17 = b17.c();
        GLES20.glUseProgram(b17.b());
        GLES20.glUniform1f(b17.c()[7].f429680a, f16);
        GLES20.glUniform1f(b17.c()[8].f429680a, f17);
        GLES20.glUniformMatrix4fv(b17.c()[9].f429680a, 1, false, fArr, 0);
        GLES20.glUniform1i(b17.c()[10].f429680a, i28);
        GLES20.glUniform1i(b17.c()[11].f429680a, i29);
        ov.b.x(false);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f432531d);
        GLES20.glUniform1i(c17[4].f429680a, 0);
        GLES20.glUniform1f(c17[2].f429680a, 1.0f);
        GLES20.glUniformMatrix4fv(c17[1].f429680a, 1, false, AVGLUtils.matrixV, 0);
        GLES20.glUniformMatrix4fv(c17[3].f429680a, 1, false, fArr2, 0);
        GLES20.glVertexAttribPointer(c17[0].f429680a, 2, 5126, false, 8, (Buffer) this.f432534g);
        GLES20.glEnableVertexAttribArray(c17[0].f429680a);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(c17[0].f429680a);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, i17, i18);
        b(aVar, i3, i16, i19, i26, i27);
    }

    public void b(ov.a aVar, int i3, int i16, int i17, int i18, int i19) {
        if (this.f432535h) {
            TextureProgram b16 = f.b(0);
            GLES20.glUseProgram(b16.b());
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f432533f);
            GLES20.glUniform1i(b16.c()[4].f429680a, 0);
            GLES20.glUniform1f(b16.c()[2].f429680a, 1.0f);
        }
    }

    public void i() {
        int i3 = this.f432530c;
        if (i3 != f432526i) {
            GLES20.glDeleteFramebuffers(2, new int[]{i3, this.f432532e}, 0);
            GLES20.glDeleteTextures(2, new int[]{this.f432531d, this.f432533f}, 0);
        }
        int i16 = f432526i;
        this.f432530c = i16;
        this.f432531d = i16;
        this.f432532e = i16;
        this.f432533f = i16;
    }
}
