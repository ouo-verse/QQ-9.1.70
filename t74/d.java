package t74;

import android.opengl.EGL14;
import android.opengl.GLES10;
import android.os.Looper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lt74/d;", "", "", "c", "d", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setGpuName", "(Ljava/lang/String;)V", "gpuName", "a", "setGlVersion", "glVersion", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f435534a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String gpuName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String glVersion;

    static {
        d dVar = new d();
        f435534a = dVar;
        gpuName = "";
        glVersion = "";
        dVar.c();
        if (!(gpuName.length() == 0)) {
            if (!(glVersion.length() == 0)) {
                return;
            }
        }
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (!Intrinsics.areEqual(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT)) {
                String glGetString = GLES10.glGetString(7937);
                Intrinsics.checkNotNullExpressionValue(glGetString, "glGetString(GLES10.GL_RENDERER)");
                gpuName = glGetString;
                String glGetString2 = GLES10.glGetString(7938);
                Intrinsics.checkNotNullExpressionValue(glGetString2, "glGetString(GLES10.GL_VERSION)");
                glVersion = glGetString2;
                return;
            }
            QLog.e("GpuInfoProviderV2", 1, "eglContext is EGL_NO_CONTEXT, can not get gpu info, use default");
            return;
        }
        dVar.d();
    }

    d() {
    }

    private final void c() {
        gpuName = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("device_gpu_name", "");
        glVersion = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("device_gl_version", "");
    }

    private final void d() {
        try {
            g gVar = new g();
            gVar.j();
            String glGetString = GLES10.glGetString(7937);
            Intrinsics.checkNotNullExpressionValue(glGetString, "glGetString(GLES10.GL_RENDERER)");
            gpuName = glGetString;
            String glGetString2 = GLES10.glGetString(7938);
            Intrinsics.checkNotNullExpressionValue(glGetString2, "glGetString(GLES10.GL_VERSION)");
            glVersion = glGetString2;
            gVar.k();
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("device_gpu_name", gpuName);
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("device_gl_version", glVersion);
        } catch (Exception unused) {
            gpuName = "invalidGpuName";
            glVersion = "invalidGLVersion";
        }
    }

    public final String a() {
        return glVersion;
    }

    public final String b() {
        return gpuName;
    }
}
