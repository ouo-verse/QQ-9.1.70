package pv;

import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends TextureProgram {
    public b() {
        super("uniform  mat4   uMatrix;\nuniform  mat4 uTextureMatrix;\nattribute vec2  aPosition ;\nvarying vec2 vTextureCoord;\nvoid main(void)\n{\nvec4 pos = vec4(aPosition, 0.0, 1.0);\n gl_Position = uMatrix * pos;\n vTextureCoord = (uTextureMatrix * (pos+vec4(0.5,0.5,0.0,0.0))).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D uTextureSampler0;\nconst mat3 m = mat3(0.2990, 0.5870, 0.1140,-0.1687,-0.3313, 0.5,0.5,-0.4187,-0.0813);\nconst vec3 adduv = vec3(0.0,0.5,0.5);\nvoid main(void)\n{\nvec4 color = texture2D(uTextureSampler0, vTextureCoord);\nvec3 rgb =  color.rgb * m + adduv;\ngl_FragColor =vec4(rgb,1.0);\n}\n", new qv.b[]{new qv.a("aPosition"), new qv.c("uMatrix"), new qv.c("uAlpha"), new qv.c(CameraFilterEngine.TEXTURE_MATRIX_UNIFORM), new qv.c("uTextureSampler0")}, false);
    }
}
