package x81;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends g {
    public int J;
    public int K;

    public a(int i3) {
        super(i3);
        this.f447448x = "uniform float uA;\nuniform float uD;\n";
        this.C = "    if(abs(gl_FragColor[0]-u_screenColor[0]) < uD && abs(gl_FragColor[1]-u_screenColor[1]) < uD  && abs(gl_FragColor[2]-u_screenColor[2]) < uD ){\n        gl_FragColor[3] = uA;\n        if(uA < 0.01){\n            gl_FragColor[0] = 0.0;\n            gl_FragColor[1] = 0.0;\n            gl_FragColor[2] = 0.0;\n        }\n    }\n";
    }

    @Override // x81.g
    protected void a(i iVar) {
        if (iVar == null) {
            return;
        }
        GLES20.glUniform1f(this.J, iVar.f447455e);
        GLES20.glUniform1f(this.K, iVar.f447456f);
    }

    @Override // x81.g
    protected void h() {
        this.J = GLES20.glGetUniformLocation(this.f447425a, "uA");
        j.a("glGetAttribLocation uA");
        this.K = GLES20.glGetUniformLocation(this.f447425a, "uD");
        j.a("glGetAttribLocation uD");
    }
}
