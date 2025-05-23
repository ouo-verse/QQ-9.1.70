package qx4;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.tencwebrtc.EglBase;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lqx4/b;", "", "", "b", "", "msg", "a", "d", "c", "", "f", "", "pst", "e", "Landroid/view/Surface;", "Landroid/view/Surface;", "surface", "Landroid/opengl/EGLContext;", "Landroid/opengl/EGLContext;", "eglContext", "Landroid/opengl/EGLDisplay;", "Landroid/opengl/EGLDisplay;", "eglDisplay", "Landroid/opengl/EGLSurface;", "Landroid/opengl/EGLSurface;", "eglSurface", "<init>", "(Landroid/view/Surface;)V", "hardware_encode_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Surface surface;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private EGLContext eglContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private EGLDisplay eglDisplay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private EGLSurface eglSurface;

    public b(Surface surface) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        this.surface = surface;
        EGLContext EGL_NO_CONTEXT = EGL14.EGL_NO_CONTEXT;
        Intrinsics.checkExpressionValueIsNotNull(EGL_NO_CONTEXT, "EGL_NO_CONTEXT");
        this.eglContext = EGL_NO_CONTEXT;
        EGLDisplay EGL_NO_DISPLAY = EGL14.EGL_NO_DISPLAY;
        Intrinsics.checkExpressionValueIsNotNull(EGL_NO_DISPLAY, "EGL_NO_DISPLAY");
        this.eglDisplay = EGL_NO_DISPLAY;
        EGLSurface EGL_NO_SURFACE = EGL14.EGL_NO_SURFACE;
        Intrinsics.checkExpressionValueIsNotNull(EGL_NO_SURFACE, "EGL_NO_SURFACE");
        this.eglSurface = EGL_NO_SURFACE;
        b();
    }

    private final void a(String msg2) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(msg2 + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public final void c() {
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = this.eglSurface;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext);
        a("eglMakeCurrent");
    }

    public final void d() {
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
            EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.eglDisplay);
        }
        this.surface.release();
        EGLDisplay EGL_NO_DISPLAY = EGL14.EGL_NO_DISPLAY;
        Intrinsics.checkExpressionValueIsNotNull(EGL_NO_DISPLAY, "EGL_NO_DISPLAY");
        this.eglDisplay = EGL_NO_DISPLAY;
        EGLContext EGL_NO_CONTEXT = EGL14.EGL_NO_CONTEXT;
        Intrinsics.checkExpressionValueIsNotNull(EGL_NO_CONTEXT, "EGL_NO_CONTEXT");
        this.eglContext = EGL_NO_CONTEXT;
        EGLSurface EGL_NO_SURFACE = EGL14.EGL_NO_SURFACE;
        Intrinsics.checkExpressionValueIsNotNull(EGL_NO_SURFACE, "EGL_NO_SURFACE");
        this.eglSurface = EGL_NO_SURFACE;
    }

    public final void e(long pst) {
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, pst);
        a("eglPresentationTimeANDROID");
    }

    public final boolean f() {
        boolean eglSwapBuffers = EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        a("eglSwapBuffers");
        return eglSwapBuffers;
    }

    private final void b() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        Intrinsics.checkExpressionValueIsNotNull(eglGetDisplay, "eglGetDisplay(EGL14.EGL_DEFAULT_DISPLAY)");
        this.eglDisplay = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                EGL14.eglChooseConfig(this.eglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
                a("eglCreateContext RGB888+recordable ES2");
                EGLContext eglCreateContext = EGL14.eglCreateContext(this.eglDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                Intrinsics.checkExpressionValueIsNotNull(eglCreateContext, "eglCreateContext(\n      \u2026xtAttribList, 0\n        )");
                this.eglContext = eglCreateContext;
                a("eglCreateContext");
                EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, eGLConfigArr[0], this.surface, new int[]{12344}, 0);
                Intrinsics.checkExpressionValueIsNotNull(eglCreateWindowSurface, "eglCreateWindowSurface(\n\u2026rfaceAttribs, 0\n        )");
                this.eglSurface = eglCreateWindowSurface;
                a("eglCreateWindowSurface");
                return;
            }
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }
}
