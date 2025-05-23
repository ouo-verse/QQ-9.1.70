package z81;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {
    public static void a(String str, String str2) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                QLog.e(str, 1, str2 + ": glError " + glGetError);
            } else {
                return;
            }
        }
    }
}
