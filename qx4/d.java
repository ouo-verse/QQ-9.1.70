package qx4;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.tencwebrtc.VideoFrameDrawer;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0016J \u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001a\u00a8\u0006'"}, d2 = {"Lqx4/d;", "Lqx4/c;", "", "g", "d", h.F, "", "shaderType", "", "shaderCode", "i", "f", "e", "msg", "c", "b", "", "pixels", "width", "height", "a", "release", "", "[F", "vertexCoors", "textureCoors", "I", "programId", "textureId", "Ljava/nio/FloatBuffer;", "Ljava/nio/FloatBuffer;", "vertexBuffer", "textureBuffer", "vertexPosHandler", "texturePosHandler", "textureHandler", "<init>", "()V", "j", "hardware_encode_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes36.dex */
public final class d implements c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FloatBuffer vertexBuffer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FloatBuffer textureBuffer;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float[] vertexCoors = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float[] textureCoors = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int programId = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int textureId = -1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int vertexPosHandler = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int texturePosHandler = -1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int textureHandler = -1;

    public d() {
        g();
    }

    private final void c(String msg2) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            com.tencent.zplan.encode.d.a(VideoFrameDrawer.TAG, 1, msg2 + " error:" + eglGetError);
        }
    }

    private final String e() {
        return "precision mediump float;uniform sampler2D uTexture;varying vec2 vCoordinate;void main() {  vec4 color = texture2D(uTexture, vCoordinate);  gl_FragColor = color;}";
    }

    private final String f() {
        return "attribute vec4 aPosition;attribute vec2 aCoordinate;varying vec2 vCoordinate;void main() {  gl_Position = aPosition;  vCoordinate = aCoordinate;}";
    }

    private final void g() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.vertexCoors.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        Intrinsics.checkExpressionValueIsNotNull(asFloatBuffer, "bb.asFloatBuffer()");
        this.vertexBuffer = asFloatBuffer;
        FloatBuffer floatBuffer = null;
        if (asFloatBuffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vertexBuffer");
            asFloatBuffer = null;
        }
        asFloatBuffer.put(this.vertexCoors);
        FloatBuffer floatBuffer2 = this.vertexBuffer;
        if (floatBuffer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vertexBuffer");
            floatBuffer2 = null;
        }
        floatBuffer2.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.textureCoors.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        Intrinsics.checkExpressionValueIsNotNull(asFloatBuffer2, "cc.asFloatBuffer()");
        this.textureBuffer = asFloatBuffer2;
        if (asFloatBuffer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureBuffer");
            asFloatBuffer2 = null;
        }
        asFloatBuffer2.put(this.textureCoors);
        FloatBuffer floatBuffer3 = this.textureBuffer;
        if (floatBuffer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureBuffer");
        } else {
            floatBuffer = floatBuffer3;
        }
        floatBuffer.position(0);
    }

    private final int i(int shaderType, String shaderCode) {
        int glCreateShader = GLES20.glCreateShader(shaderType);
        c(Intrinsics.stringPlus("glCreateShader type=", Integer.valueOf(shaderType)));
        GLES20.glShaderSource(glCreateShader, shaderCode);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e(VideoFrameDrawer.TAG, "Could not compile shader:" + glCreateShader + " - " + shaderType + MsgSummary.STR_COLON + ((Object) GLES20.glGetShaderInfoLog(glCreateShader)));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    @Override // qx4.c
    public void a(byte[] pixels, int width, int height) {
        FloatBuffer floatBuffer;
        FloatBuffer floatBuffer2;
        Intrinsics.checkParameterIsNotNull(pixels, "pixels");
        c("draw start");
        if (this.textureId != -1) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glClear(16640);
            GLES20.glUseProgram(this.programId);
            c("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.textureId);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(pixels.length);
            allocateDirect.order(ByteOrder.nativeOrder());
            allocateDirect.put(pixels);
            allocateDirect.position(0);
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, width, height, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
            c("texImage2D");
            GLES20.glEnableVertexAttribArray(this.vertexPosHandler);
            GLES20.glEnableVertexAttribArray(this.texturePosHandler);
            int i3 = this.vertexPosHandler;
            FloatBuffer floatBuffer3 = this.vertexBuffer;
            if (floatBuffer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vertexBuffer");
                floatBuffer = null;
            } else {
                floatBuffer = floatBuffer3;
            }
            GLES20.glVertexAttribPointer(i3, 2, 5126, false, 0, (Buffer) floatBuffer);
            int i16 = this.texturePosHandler;
            FloatBuffer floatBuffer4 = this.textureBuffer;
            if (floatBuffer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureBuffer");
                floatBuffer2 = null;
            } else {
                floatBuffer2 = floatBuffer4;
            }
            GLES20.glVertexAttribPointer(i16, 2, 5126, false, 0, (Buffer) floatBuffer2);
            GLES20.glDrawArrays(5, 0, 4);
            c("glDrawArrays");
        }
    }

    @Override // qx4.c
    public void b() {
        d();
        h();
    }

    @Override // qx4.c
    public void release() {
        GLES20.glDisableVertexAttribArray(this.vertexPosHandler);
        GLES20.glDisableVertexAttribArray(this.texturePosHandler);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glDeleteTextures(1, new int[]{this.textureId}, 0);
        GLES20.glDeleteProgram(this.programId);
    }

    private final void h() {
        int first;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        first = ArraysKt___ArraysKt.first(iArr);
        this.textureId = first;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.textureId);
        c("glBindTexture");
        GLES20.glUniform1i(this.textureHandler, 0);
        c("glUniform1i");
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        c("glTexParameter");
    }

    private final void d() {
        int i3 = i(35633, f());
        com.tencent.zplan.encode.d.a(VideoFrameDrawer.TAG, 4, Intrinsics.stringPlus("vertexShader:", Integer.valueOf(i3)));
        int i16 = i(35632, e());
        com.tencent.zplan.encode.d.a(VideoFrameDrawer.TAG, 4, Intrinsics.stringPlus("fragmentShader:", Integer.valueOf(i16)));
        int glCreateProgram = GLES20.glCreateProgram();
        this.programId = glCreateProgram;
        com.tencent.zplan.encode.d.a(VideoFrameDrawer.TAG, 4, Intrinsics.stringPlus("programId:", Integer.valueOf(glCreateProgram)));
        GLES20.glAttachShader(this.programId, i3);
        c("glAttachShader vertex");
        GLES20.glAttachShader(this.programId, i16);
        c("glAttachShader fragment");
        GLES20.glLinkProgram(this.programId);
        c("glLinkProgram");
        this.vertexPosHandler = GLES20.glGetAttribLocation(this.programId, "aPosition");
        this.texturePosHandler = GLES20.glGetAttribLocation(this.programId, "aCoordinate");
        this.textureHandler = GLES20.glGetUniformLocation(this.programId, "uTexture");
    }
}
