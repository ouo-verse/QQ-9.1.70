package qq;

import com.tencent.filter.BaseFilter;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f extends BaseFilter {
    public f() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n  vec4 color = texture2D(inputImageTexture, textureCoordinate);\n\n    gl_FragColor = vec4(color.rgb, step(0.5, color.a));\n}");
    }
}
