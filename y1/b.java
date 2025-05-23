package y1;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {
    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
            if (QLog.isColorLevel()) {
                QLog.e("GlUtil", 2, str2);
            }
            throw new RuntimeException(str2);
        }
    }

    public static FloatBuffer b(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int c(String str, String str2) {
        int d16;
        int d17 = d(35633, str);
        if (d17 == 0 || (d16 = d(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0 && QLog.isColorLevel()) {
            QLog.e("GlUtil", 2, "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, d17);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, d16);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            if (QLog.isColorLevel()) {
                QLog.e("GlUtil", 2, "Could not link program:" + GLES20.glGetProgramInfoLog(glCreateProgram));
            }
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static int d(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        a("glCreateShader type=" + i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            if (QLog.isColorLevel()) {
                QLog.e("GlUtil", 2, "Could not compile shader " + i3 + ":" + GLES20.glGetShaderInfoLog(glCreateShader));
            }
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }
}
