package x81;

import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends g {
    public int J;

    public b(int i3, String str) {
        super(i3);
        if (!TextUtils.isEmpty(str)) {
            this.f447427c = str;
            return;
        }
        throw new IllegalArgumentException("mFragmentShader can not be empty!");
    }

    public static String l(String str, String str2, String str3, String str4) {
        float f16;
        float f17;
        String[] split;
        String[] split2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("    float bgR = max(min(u_screenColor.r, 1.0), 0.0);\n    float bgG = max(min(u_screenColor.g, 1.0), 0.0);\n    float bgB = max(min(u_screenColor.b, 1.0), 0.0);\n    float R = max(min(gl_FragColor.r, 1.0), 0.0);\n    float G = max(min(gl_FragColor.g, 1.0), 0.0);\n    float B = max(min(gl_FragColor.b, 1.0), 0.0);\n    float x = position.x;\n    float y = position.y;\n    float alpha = 1.0;\n");
        try {
            ArrayList arrayList = new ArrayList();
            int i3 = 2;
            if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null) {
                String[] strArr = {BdhLogUtil.LogTag.Tag_Req, "G", "B", "R2", Constants.MMCCID, "B2", "RG", "RB", "GB", "RGB", "R_2", "G_2", "B_2", "dCbCr", "b"};
                HashMap hashMap = new HashMap(15);
                int i16 = 0;
                for (int i17 = 15; i16 < i17; i17 = 15) {
                    hashMap.put(strArr[i16], Integer.valueOf(i16));
                    i16++;
                }
                int length = split.length;
                f16 = 1.0f;
                int i18 = 0;
                f17 = 0.0f;
                while (i18 < length) {
                    String str5 = split[i18];
                    if (!TextUtils.isEmpty(str5) && (split2 = str5.split(":")) != null && split2.length == i3) {
                        String str6 = split2[0];
                        Float valueOf = Float.valueOf(split2[1]);
                        if (hashMap.get(str6) != null) {
                            arrayList.add(new Pair(str6, valueOf));
                        } else if ("u_clipBlack".equals(str6)) {
                            f17 = valueOf.floatValue();
                        } else if ("u_clipWhite".equals(str6)) {
                            f16 = valueOf.floatValue();
                        }
                    }
                    i18++;
                    i3 = 2;
                }
            } else {
                f16 = 1.0f;
                f17 = 0.0f;
            }
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("alpha = ");
            Iterator it = arrayList.iterator();
            boolean z16 = true;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (z16) {
                    sb7.append(pair.second);
                    z16 = false;
                } else if (((Float) pair.second).floatValue() >= 0.0f) {
                    sb7.append(Marker.ANY_NON_NULL_MARKER);
                    sb7.append(pair.second);
                } else {
                    sb7.append(pair.second);
                }
                if (!"b".equals(pair.first)) {
                    sb7.append("*");
                    sb7.append((String) pair.first);
                }
                if ("R2".equals(pair.first)) {
                    sb6.append("float R2=R*R;\n");
                } else if (Constants.MMCCID.equals(pair.first)) {
                    sb6.append("float G2=G*G;\n");
                } else if ("B2".equals(pair.first)) {
                    sb6.append("float B2=B*B;\n");
                } else if ("RG".equals(pair.first)) {
                    sb6.append("float RG=R*G;\n");
                } else if ("RB".equals(pair.first)) {
                    sb6.append("float RB=R*B;\n");
                } else if ("GB".equals(pair.first)) {
                    sb6.append("float GB=G*B;\n");
                } else if ("RGB".equals(pair.first)) {
                    sb6.append("float RGB=R*G*B;\n");
                } else if ("R_2".equals(pair.first)) {
                    sb6.append("float R_2=sqrt(R);\n");
                } else if ("G_2".equals(pair.first)) {
                    sb6.append("float G_2=sqrt(G);\n");
                } else if ("B_2".equals(pair.first)) {
                    sb6.append("float B_2=sqrt(B);\n");
                } else if ("dCbCr".equals(pair.first)) {
                    sb6.append("float dCbCr=distance(vec2(-0.168736*R-0.331264*G+0.5*B, 0.5*R-0.418688*B-0.081312*B), vec2(-0.168736*bgR-0.331264*bgG+0.5*bgB, 0.5*bgR-0.418688*bgB-0.081312*bgB));\n");
                }
            }
            sb7.append(";\n");
            sb6.append((CharSequence) sb7);
            if (f17 > 0.0d) {
                sb6.append("u_clipBlack = ");
                sb6.append(f17);
                sb6.append(";\n");
            }
            if (f16 < 1.0d) {
                sb6.append("u_clipWhite = ");
                sb6.append(f16);
                sb6.append(";\n");
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb8 = new StringBuilder();
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    Pair pair2 = (Pair) it5.next();
                    sb8.append((String) pair2.first);
                    sb8.append(":");
                    sb8.append(pair2.second);
                    sb8.append(";");
                }
                sb8.append("\n          old string = \n");
                sb8.append(str);
                sb8.append("\n          mainKeyingMiddle = \n");
                sb8.append(sb6.toString());
                QLog.i("CustomizeKey", 2, "buildMachineLearningFragmentShader params: \n" + sb8.toString());
            }
            sb5.append((CharSequence) sb6);
        } catch (Exception e16) {
            QLog.e("CustomizeKey", 1, e16.getMessage());
        }
        sb5.append("    alpha = max(min(alpha, 1.0), 0.0);\n    if(alpha > 0.01 && alpha < 1.0){\n        R = R - (1.0-alpha)*bgR;\n        G = G - (1.0-alpha)*bgG;\n        B = B - (1.0-alpha)*bgB;\n    }\n    alpha = smoothclip(u_clipBlack, u_clipWhite, alpha);\n    if(alpha <= 0.01){\n        R = G = B = 0.0;\n    }\n    gl_FragColor.a = alpha;\n    gl_FragColor.r = max(min(R, 1.0), 0.0);\n    gl_FragColor.g = max(min(G, 1.0), 0.0);\n    gl_FragColor.b = max(min(B, 1.0), 0.0);\n");
        StringBuilder sb9 = new StringBuilder();
        sb9.append("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES samplerOES;\nuniform sampler2D sampler2d1;\nuniform sampler2D sampler2d2;\nuniform sampler2D sampler2d3;\nuniform vec4 u_screenColor;\nvarying vec2 vTextureCoord;\n");
        sb9.append("uniform float u_currentTime;\nfloat u_clipBlack = 0.0;\nfloat u_clipWhite = 1.0;\nfloat smoothclip(float low, float high, float x){\n    if (x <= low){\n        return 0.0;\n    }\n    if(x >= high){\n        return 1.0;\n    }\n    return (x-low)/(high-low);\n}\n");
        if (!TextUtils.isEmpty(str2)) {
            sb9.append(str2);
        } else {
            sb9.append("//\u7528\u6237\u81ea\u5df1\u5b9a\u4e49\u53d8\u91cf\u53ca\u65b9\u6cd5\u76f8\u5173\u7247\u6bb5\n");
        }
        sb9.append("void main() {\n    vec2 position = vTextureCoord;\n");
        if (!TextUtils.isEmpty(str3)) {
            sb9.append(str3);
        } else {
            sb9.append("    //\u7528\u6237\u5b9a\u4e49\u7247\u6bb5\uff0c\u7528\u4e8e\u5728\u83b7\u53d6\u989c\u8272\u503c\u524d\u5904\u7406, \u5982\u7eb9\u7406\u5750\u6807\u6539\u53d8\n");
        }
        sb9.append("    gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n    #if defined(TEXTURE_TYPE_OES)\n        gl_FragColor = texture2D(samplerOES, position);\n        gl_FragColor.r = max(0.0, min(gl_FragColor.r, 1.0));\n        gl_FragColor.g = max(0.0, min(gl_FragColor.g, 1.0));\n        gl_FragColor.b = max(0.0, min(gl_FragColor.b, 1.0));\n    #endif\n    #if defined(TEXTURE_TYPE_SAMPLER2D)\n        gl_FragColor = texture2D(sampler2d1, position);\n    #endif\n    #if defined(TEXTURE_TYPE_Y_U_V)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        yuv.y = texture2D(sampler2d2, position).r-0.5;\n        yuv.z = texture2D(sampler2d3, position).r-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;\n        gl_FragColor.a = 1.0;\n    #endif\n    #if defined(TEXTURE_TYPE_Y_UV)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        vec2 uv = texture2D(sampler2d2, position).ra;\n        yuv.y = uv.x-0.5;\n        yuv.z = uv.y-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;//yuv->rgb\n        gl_FragColor.a = 1.0;\n    #endif\n");
        sb9.append(sb5.toString());
        if (!TextUtils.isEmpty(str4)) {
            sb9.append(str4);
        } else {
            sb9.append(j.f447464c);
        }
        sb9.append(j.f447465d);
        return sb9.toString();
    }

    @Override // x81.g
    protected void a(i iVar) {
        int i3;
        if (iVar != null && (i3 = this.J) != -1) {
            GLES20.glUniform1f(i3, iVar.f447460j);
        }
    }

    @Override // x81.g
    protected String b() {
        return j.c(this.f447445u) + this.f447427c;
    }

    @Override // x81.g
    protected void h() {
        this.J = GLES20.glGetUniformLocation(this.f447425a, "u_currentTime");
    }
}
