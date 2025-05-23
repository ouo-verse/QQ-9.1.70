package x81;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int[] f447421a = null;

    /* renamed from: b, reason: collision with root package name */
    private int[] f447422b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f447423c;

    /* renamed from: d, reason: collision with root package name */
    private int f447424d;

    private void d(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            this.f447423c = i3;
            this.f447424d = i16;
            int[] iArr = this.f447421a;
            if (iArr != null) {
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                this.f447421a = null;
            }
            int[] iArr2 = this.f447422b;
            if (iArr2 != null) {
                GLES20.glDeleteTextures(1, iArr2, 0);
                this.f447422b = null;
            }
            int[] iArr3 = new int[1];
            this.f447421a = iArr3;
            this.f447422b = new int[1];
            GLES20.glGenFramebuffers(1, iArr3, 0);
            GLES20.glGenTextures(1, this.f447422b, 0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f447422b[0]);
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.f447421a[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.f447422b[0], 0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            GLES20.glBindFramebuffer(36160, 0);
            return;
        }
        throw new IllegalArgumentException("width & height should > 0!");
    }

    public void a(int i3, int i16) {
        if (this.f447421a == null || this.f447422b == null || i3 != this.f447423c || i16 != this.f447424d) {
            long currentTimeMillis = System.currentTimeMillis();
            d(i3, i16);
            QLog.i("Keying_FrameBuffer", 2, " init need " + (System.currentTimeMillis() - currentTimeMillis));
        }
        GLES20.glBindFramebuffer(36160, this.f447421a[0]);
    }

    public void b() {
        int[] iArr = this.f447422b;
        if (iArr != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.f447422b = null;
        }
        int[] iArr2 = this.f447421a;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.f447421a = null;
        }
    }

    public int c() {
        int[] iArr = this.f447422b;
        if (iArr == null) {
            return 0;
        }
        return iArr[0];
    }
}
