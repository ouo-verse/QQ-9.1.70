package tv;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    public static final boolean A;
    public static final boolean B;
    public static final boolean C;
    public static final boolean D;
    public static final boolean E;
    public static final boolean F;
    public static final boolean G;
    public static final boolean H;
    public static final boolean I;
    public static final boolean J;
    public static final boolean K;
    public static final boolean L;
    public static final boolean M;
    public static final boolean N;
    public static final boolean O;
    public static final boolean P;
    public static final boolean Q;
    public static final boolean R;
    public static final boolean S;
    public static final boolean T;

    /* renamed from: a, reason: collision with root package name */
    static int f437518a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f437519b = true;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f437520c = true;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f437521d = true;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f437522e = d(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE");

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f437523f = d(View.class, "SYSTEM_UI_FLAG_HIDE_NAVIGATION");

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f437524g = d(MediaStore.MediaColumns.class, "WIDTH");

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f437525h = true;

    /* renamed from: i, reason: collision with root package name */
    public static final boolean f437526i = true;

    /* renamed from: j, reason: collision with root package name */
    public static final boolean f437527j = true;

    /* renamed from: k, reason: collision with root package name */
    public static final boolean f437528k;

    /* renamed from: l, reason: collision with root package name */
    public static final boolean f437529l;

    /* renamed from: m, reason: collision with root package name */
    public static final boolean f437530m;

    /* renamed from: n, reason: collision with root package name */
    public static final boolean f437531n;

    /* renamed from: o, reason: collision with root package name */
    public static final boolean f437532o;

    /* renamed from: p, reason: collision with root package name */
    public static final boolean f437533p;

    /* renamed from: q, reason: collision with root package name */
    public static final boolean f437534q;

    /* renamed from: r, reason: collision with root package name */
    public static final boolean f437535r;

    /* renamed from: s, reason: collision with root package name */
    public static final boolean f437536s;

    /* renamed from: t, reason: collision with root package name */
    public static final boolean f437537t;

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f437538u;

    /* renamed from: v, reason: collision with root package name */
    public static final boolean f437539v;

    /* renamed from: w, reason: collision with root package name */
    public static final boolean f437540w;

    /* renamed from: x, reason: collision with root package name */
    public static final boolean f437541x;

    /* renamed from: y, reason: collision with root package name */
    public static final boolean f437542y;

    /* renamed from: z, reason: collision with root package name */
    public static final boolean f437543z;

    static {
        boolean z16;
        Class cls = Integer.TYPE;
        f437528k = f("android.graphics.SurfaceTexture", "setDefaultBufferSize", cls, cls);
        f437529l = f("android.graphics.SurfaceTexture", "release", new Class[0]);
        f437530m = true;
        f437531n = true;
        f437532o = true;
        f437533p = true;
        f437534q = true;
        f437535r = e(View.class, "setSystemUiVisibility", cls);
        if (e(Camera.class, "setFaceDetectionListener", Camera.FaceDetectionListener.class) && e(Camera.class, "startFaceDetection", new Class[0]) && e(Camera.class, "stopFaceDetection", new Class[0])) {
            if (e(Camera.Parameters.class, "getMaxNumDetectedFaces", new Class[0])) {
                z16 = true;
                f437536s = z16;
                f437537t = e(DevicePolicyManager.class, "getCameraDisabled", ComponentName.class);
                f437538u = true;
                f437539v = true;
                f437540w = true;
                f437541x = true;
                f437542y = true;
                f437543z = true;
                A = true;
                B = true;
                C = true;
                D = true;
                E = true;
                F = true;
                G = true;
                H = true;
                I = true;
                J = true;
                K = true;
                L = true;
                M = true;
                N = true;
                O = true;
                P = d(WindowManager.LayoutParams.class, "rotationAnimation");
                Q = true;
                R = true;
                S = true;
                T = true;
            }
        }
        z16 = false;
        f437536s = z16;
        f437537t = e(DevicePolicyManager.class, "getCameraDisabled", ComponentName.class);
        f437538u = true;
        f437539v = true;
        f437540w = true;
        f437541x = true;
        f437542y = true;
        f437543z = true;
        A = true;
        B = true;
        C = true;
        D = true;
        E = true;
        F = true;
        G = true;
        H = true;
        I = true;
        J = true;
        K = true;
        L = true;
        M = true;
        N = true;
        O = true;
        P = d(WindowManager.LayoutParams.class, "rotationAnimation");
        Q = true;
        R = true;
        S = true;
        T = true;
    }

    public static int a() {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Utils", 2, "checkError error = " + glGetError);
            }
            SmallScreenUtils.m();
        }
        return glGetError;
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static int c(Context context) {
        int i3;
        if (f437518a == 0) {
            try {
                ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo();
                if (deviceConfigurationInfo == null) {
                    f437518a = 1;
                } else {
                    if (deviceConfigurationInfo.reqGlEsVersion >= 131072) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    f437518a = i3;
                }
            } catch (Exception unused) {
                f437518a = 1;
            }
        }
        return f437518a;
    }

    private static boolean d(Class<?> cls, String str) {
        try {
            cls.getDeclaredField(str);
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    private static boolean e(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            cls.getDeclaredMethod(str, clsArr);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    private static boolean f(String str, String str2, Class<?>... clsArr) {
        try {
            Class.forName(str).getDeclaredMethod(str2, clsArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
