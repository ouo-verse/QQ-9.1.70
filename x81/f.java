package x81;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f extends g {
    public int J;
    public int K;
    public int L;

    public f(int i3) {
        super(i3);
        this.f447448x = "uniform float u_threshold;\nuniform float u_clipBlack;\nuniform float u_clipWhite;\nfloat smoothclip(float low, float high, float x){\n    if (x <= low){\n        return 0.0;\n    }\n    if(x >= high){\n        return 1.0;\n    }\n    return (x-low)/(high-low);\n}\n";
        this.C = "    float screenWeight = u_threshold/2.0;\n    float angle = 0.7854 + 0.7854*(max(0.0, min(0.95, screenWeight))*2.0-1.0);\n    float noise_level = 0.0625;\n    float key_Y = 0.257*u_screenColor.r + 0.504*u_screenColor.g + 0.098*u_screenColor.b;\n    float key_Cb = -0.148*u_screenColor.r - 0.291*u_screenColor.g + 0.439*u_screenColor.b;\n    float key_Cr = 0.439*u_screenColor.r - 0.368*u_screenColor.g - 0.071*u_screenColor.b;\n    float kgl = sqrt(key_Cb*key_Cb + key_Cr*key_Cr);\n    key_Cb = (key_Cb / kgl);\n    key_Cr = (key_Cr / kgl);\n    float accept_angle_tg = min(tan(angle), 16.0);\n    float accept_angle_ctg = min(1.0/tan(angle), 16.0);\n    float one_over_kc = 1.0/kgl;\n    float kfgy_scale = min(key_Y/kgl, 16.0);\n    float kg = min(kgl, 0.5);\n    //r g b = y cb cr\n    float y = 0.257*gl_FragColor.r + 0.504*gl_FragColor.g + 0.098*gl_FragColor.b;\n    float cb = -0.148*gl_FragColor.r - 0.291*gl_FragColor.g + 0.439*gl_FragColor.b;\n    float cr = 0.439*gl_FragColor.r - 0.368*gl_FragColor.g - 0.071*gl_FragColor.b;\n    float x = (cb*key_Cb + cr*key_Cr);\n    x = max(min(x, 0.5), -0.5);\n    float z = (cr*key_Cb - cb*key_Cr);\n    z = max(min(z, 0.5), -0.5);\n    if (abs(z) > min(x*accept_angle_tg, 0.5)) {\n        gl_FragColor.a = 1.0;\n    } else {\n        if ((z*z+(x-kg)*(x-kg)) < noise_level*noise_level) {\n            gl_FragColor.rgb = vec3(0.0);\n            gl_FragColor.a = 0.0;\n        } else {\n            float x1 = abs(max(min(z*accept_angle_ctg, 0.5), -0.5));\n            float z1 = z;\n            float dx = max(x-x1, 0.0);\n            float kbg = dx*one_over_kc;\n            kbg = max(min(kbg, 1.0), 0.0);\n            y = y - min(dx*kfgy_scale, 1.0);\n            y = max(y, 0.0);\n            cb = (x1*key_Cb - z1*key_Cr);\n            cb = max(min(cb, 0.5), -0.5);\n            cr = (x1*key_Cr + z1*key_Cb);\n            cr = max(min(cr, 0.5), -0.5);\n            float alpha = 1.0 - kbg;\n            alpha = smoothclip(0.2, 1.0, alpha);//\n            //y cb cr => r g b\n            float r = 1.164*y + 1.596*cr;\n            float g = 1.164*y - 0.813*cr - 0.392*cb;\n            float b = 1.164*y + 2.017*cb;\n            if(alpha < u_clipBlack){\n                alpha = 0.0;\n                r = g = b = 0.0;\n            }\n            if(alpha > u_clipWhite){\n                alpha = 1.0;\n            }\n            if(u_clipWhite < 1.0){\n                alpha = alpha/max(u_clipWhite, 0.9);\n            }\n            gl_FragColor.r = max(min(r, 1.0), 0.0);\n            gl_FragColor.g = max(min(g, 1.0), 0.0);\n            gl_FragColor.b = max(min(b, 1.0), 0.0);\n            gl_FragColor.a = alpha;\n        }\n    }\n";
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
