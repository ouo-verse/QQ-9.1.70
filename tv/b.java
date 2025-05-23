package tv;

import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private GPUBaseFilter f437516a = new GPUBaseFilter();

    /* renamed from: b, reason: collision with root package name */
    private GPUOESBaseFilter f437517b = new GPUOESBaseFilter("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");

    public b() {
        this.f437516a.init();
        this.f437517b.init();
    }

    public void a(int i3, int i16, float[] fArr, float[] fArr2) {
        if (i3 == 36197) {
            this.f437517b.drawTexture(i16, fArr, fArr2);
        } else {
            if (i3 == 3553) {
                this.f437516a.drawTexture(i16, fArr, fArr2);
                return;
            }
            throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
        }
    }

    public void b() {
        this.f437516a.destroy();
        this.f437517b.destroy();
    }
}
