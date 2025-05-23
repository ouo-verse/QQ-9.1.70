package x81;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e extends g {
    public int J;
    public int K;
    public int L;

    public e(int i3) {
        super(i3);
        this.f447448x = "uniform float u_threshold;\nuniform float u_clipBlack;\nuniform float u_clipWhite;\nfloat rgb2cb(float r, float g, float b){\n    return 0.5 + -0.168736*r - 0.331264*g + 0.5*b;\n}\nfloat rgb2cr(float r, float g, float b){\n    return 0.5 + 0.5*r - 0.418688*g - 0.081312*b;\n}\nfloat smoothclip(float low, float high, float x){\n    if (x <= low){\n        return 0.0;\n    }\n    if(x >= high){\n        return 1.0;\n    }\n    return (x-low)/(high-low);\n}\nvec4 greenscreen(vec4 color, float Cb_key,float Cr_key, float tola,float tolb, float clipBlack, float clipWhite){\n    float cb = rgb2cb(color.r,color.g,color.b);\n    float cr = rgb2cr(color.r,color.g,color.b);\n    float alpha = distance(vec2(cb, cr), vec2(Cb_key, Cr_key));\n    alpha = smoothclip(tola, tolb, alpha);\n    float r = max(gl_FragColor.r - (1.0-alpha)*u_screenColor.r, 0.0);\n    float g = max(gl_FragColor.g - (1.0-alpha)*u_screenColor.g, 0.0);\n    float b = max(gl_FragColor.b - (1.0-alpha)*u_screenColor.b, 0.0);\n    if(alpha < clipBlack){\n        alpha = r = g = b = 0.0;\n    }\n    if(alpha > clipWhite){\n        alpha = 1.0;\n    }\n    if(clipWhite < 1.0){\n        alpha = alpha/max(clipWhite, 0.9);\n    }\n    return vec4(r,g,b, alpha);\n}\n";
        this.C = "    float tola = 0.0;\n    float tolb = u_threshold/2.0;\n    float cb_key = rgb2cb(u_screenColor.r, u_screenColor.g, u_screenColor.b);\n    float cr_key = rgb2cr(u_screenColor.r, u_screenColor.g, u_screenColor.b);\n    gl_FragColor = greenscreen(gl_FragColor, cb_key, cr_key, tola, tolb, u_clipBlack, u_clipWhite);\n";
    }

    @Override // x81.g
    protected void a(i iVar) {
        if (iVar == null) {
            return;
        }
        GLES20.glUniform1f(this.J, iVar.f447457g);
        GLES20.glUniform1f(this.K, iVar.f447458h);
        GLES20.glUniform1f(this.L, iVar.f447459i);
    }

    @Override // x81.g
    protected void h() {
        this.J = GLES20.glGetUniformLocation(this.f447425a, "u_threshold");
        j.a("glGetAttribLocation u_threshold");
        this.K = GLES20.glGetUniformLocation(this.f447425a, "u_clipBlack");
        j.a("glGetAttribLocation u_clipBlack");
        this.L = GLES20.glGetUniformLocation(this.f447425a, "u_clipWhite");
        j.a("glGetAttribLocation u_clipWhite");
    }
}
