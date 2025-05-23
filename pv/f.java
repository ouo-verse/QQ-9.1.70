package pv;

import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.YUVTextureAliasingProgram;
import com.tencent.av.opengl.program.YUVTextureProgram;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    static Map<String, TextureProgram> f427558a = new HashMap();

    public static synchronized void a() {
        synchronized (f.class) {
            f427558a.clear();
        }
    }

    public static synchronized TextureProgram b(int i3) {
        TextureProgram textureProgram;
        boolean z16;
        TextureProgram yUVTextureProgram;
        synchronized (f.class) {
            String str = i3 + "_" + Thread.currentThread().getId();
            textureProgram = f427558a.get(str);
            boolean z17 = false;
            if (textureProgram == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                GLES20.glUseProgram(textureProgram.b());
                if (tv.c.a() != 0) {
                    z17 = true;
                }
                z16 = z17;
            }
            if (z16) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 5) {
                                if (i3 != 6) {
                                    if (i3 != 8) {
                                        if (i3 != 9) {
                                            yUVTextureProgram = new TextureProgram();
                                        } else {
                                            yUVTextureProgram = new c();
                                        }
                                    } else {
                                        yUVTextureProgram = new d();
                                    }
                                } else {
                                    yUVTextureProgram = new a();
                                }
                            } else {
                                yUVTextureProgram = new b();
                            }
                        } else {
                            yUVTextureProgram = new e();
                        }
                    } else {
                        yUVTextureProgram = new YUVTextureAliasingProgram();
                    }
                } else {
                    yUVTextureProgram = new YUVTextureProgram();
                }
                textureProgram = yUVTextureProgram;
                f427558a.put(str, textureProgram);
            }
        }
        return textureProgram;
    }
}
