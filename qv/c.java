package qv;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends b {
    public c(String str) {
        super(str);
    }

    @Override // qv.b
    public void a(int i3) {
        this.f429680a = GLES20.glGetUniformLocation(i3, this.f429681b);
        tv.c.a();
    }
}
