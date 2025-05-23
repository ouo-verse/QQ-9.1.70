package x81;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f447462a = HardCodeUtil.qqStr(R.string.nk9);

    /* renamed from: b, reason: collision with root package name */
    public static String f447463b = "    //\u62a0\u50cf\u903b\u8f91\u7247\u6bb5\n";

    /* renamed from: c, reason: collision with root package name */
    public static String f447464c = "    //\u7528\u6237\u5b9a\u4e49\uff0c\u62a0\u50cf\u540e\u903b\u8f91\u7247\u6bb5\n";

    /* renamed from: d, reason: collision with root package name */
    public static String f447465d = "}\n";

    /* renamed from: e, reason: collision with root package name */
    public static final float[] f447466e = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};

    public static void a(String str) {
        int glGetError;
        if (QLog.isColorLevel() && (glGetError = GLES20.glGetError()) != 0) {
            Log.e("KeyingUtil", str + ": glError 0x" + Integer.toHexString(glGetError));
        }
    }

    public static int b(String str, String str2) {
        int d16;
        int d17 = d(35633, str);
        if (d17 == 0 || (d16 = d(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("KeyingUtil", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, d17);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, d16);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("KeyingUtil", "Could not link program:" + GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static String c(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (!QLog.isDevelopLevel()) {
                            return "";
                        }
                        throw new IllegalArgumentException("invalid textureType!");
                    }
                    return "#define TEXTURE_TYPE_Y_UV\n";
                }
                return "#define TEXTURE_TYPE_Y_U_V\n";
            }
            return "#define TEXTURE_TYPE_SAMPLER2D\n";
        }
        return "#define TEXTURE_TYPE_OES\n";
    }

    public static int d(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        a("glCreateShader type=" + i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("KeyingUtil", "Could not compile shader " + i3 + ":" + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }
}
