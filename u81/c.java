package u81;

import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c extends b {
    public c() {
        this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", GPUOESBaseFilter.OES_FRAGMENT_SHADER);
    }

    public c(String str, String str2) {
        super(str, str2);
        this.f438545e = 36197;
        this.f438546f = 102;
    }
}
