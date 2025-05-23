package vw;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    int f443592b;

    /* renamed from: d, reason: collision with root package name */
    int f443594d;

    /* renamed from: e, reason: collision with root package name */
    byte[] f443595e;

    /* renamed from: f, reason: collision with root package name */
    int f443596f;

    /* renamed from: g, reason: collision with root package name */
    int f443597g;

    /* renamed from: h, reason: collision with root package name */
    int f443598h;

    /* renamed from: i, reason: collision with root package name */
    byte[] f443599i;

    /* renamed from: j, reason: collision with root package name */
    ByteBuffer f443600j;

    /* renamed from: k, reason: collision with root package name */
    QQAVImageFilter f443601k;

    /* renamed from: a, reason: collision with root package name */
    int[] f443591a = new int[1];

    /* renamed from: c, reason: collision with root package name */
    int[] f443593c = new int[1];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: vw.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C11442a {

        /* renamed from: a, reason: collision with root package name */
        int f443602a;

        /* renamed from: b, reason: collision with root package name */
        int f443603b;

        C11442a(int i3, int i16) {
            this.f443602a = i3;
            this.f443603b = i16;
        }
    }

    public a(byte[] bArr, int i3, int i16) {
        this.f443595e = bArr;
        this.f443596f = i3;
        this.f443597g = i16;
        int i17 = i3 * i16 * 3;
        this.f443598h = i17;
        this.f443600j = ByteBuffer.allocate(i17);
        this.f443599i = new byte[this.f443596f * this.f443597g * 4];
        int[] iArr = this.f443591a;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        int[] iArr2 = this.f443593c;
        GLES20.glGenTextures(iArr2.length, iArr2, 0);
        this.f443592b = AVGLUtils.initFrameBuffer(i3, i16, this.f443591a[0]);
        this.f443594d = AVGLUtils.initFrameBuffer(i3, i16, this.f443593c[0]);
        b bVar = new b();
        this.f443601k = bVar;
        bVar.init();
        this.f443601k.setQQAVEffectID("filter-test");
        if (QLog.isColorLevel()) {
            QLog.d("FilterProcess", 2, "mBeforeTextureId:" + this.f443591a[0] + "\nmBeforeTextureFbo:" + this.f443592b + "\nmAfterTextureId:" + this.f443593c[0] + "\nmAfterTextureFbo:" + this.f443594d);
        }
    }

    public void a() {
        ByteBuffer byteBuffer = this.f443600j;
        if (byteBuffer != null) {
            byteBuffer.clear();
            this.f443600j = null;
        }
        this.f443599i = null;
        GLES20.glDeleteFramebuffers(2, new int[]{this.f443592b, this.f443594d}, 0);
        int[] iArr = this.f443591a;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
        int[] iArr2 = this.f443593c;
        GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        QQAVImageFilter qQAVImageFilter = this.f443601k;
        if (qQAVImageFilter != null) {
            qQAVImageFilter.destroy();
            this.f443601k = null;
        }
    }

    void b() {
        ByteBuffer byteBuffer = this.f443600j;
        if (byteBuffer != null && this.f443595e != null) {
            byteBuffer.position(0);
            this.f443600j.put(this.f443595e, 0, this.f443598h);
            this.f443600j.position(0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f443591a[0]);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6407, this.f443596f, this.f443597g, 0, 6407, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.f443600j);
        }
    }

    public long c() {
        byte[] bArr = this.f443595e;
        if (bArr != null && bArr.length != 0) {
            if (this.f443601k == null) {
                return -2L;
            }
            if (this.f443591a[0] != 0 && this.f443593c[0] != 0) {
                long nanoTime = System.nanoTime();
                for (int i3 = 0; i3 < 70; i3++) {
                    b();
                    e(d(this.f443601k, this.f443592b, this.f443591a[0], this.f443594d, this.f443593c[0]).f443602a, this.f443596f, this.f443597g, 6408, this.f443599i);
                }
                return ((System.nanoTime() - nanoTime) / 1000) / 1000;
            }
            return -3L;
        }
        return -1L;
    }

    C11442a d(QQAVImageFilter qQAVImageFilter, int i3, int i16, int i17, int i18) {
        if (qQAVImageFilter != null) {
            qQAVImageFilter.onOutputSizeChanged(this.f443596f, this.f443597g);
            qQAVImageFilter.onDraw2(i16, i17);
            return new C11442a(i17, i18);
        }
        return new C11442a(i3, i16);
    }

    void e(int i3, int i16, int i17, int i18, byte[] bArr) {
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glViewport(0, 0, i16, i17);
        GLES20.glReadPixels(0, 0, i16, i17, i18, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, ByteBuffer.wrap(bArr));
        GLES20.glBindFramebuffer(36160, 0);
    }
}
