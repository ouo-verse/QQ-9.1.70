package qv;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends b {
    public a(String str) {
        super(str);
    }

    @Override // qv.b
    public void a(int i3) {
        this.f429680a = GLES20.glGetAttribLocation(i3, this.f429681b);
        tv.c.a();
    }
}
