package qq;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends BaseFilter {
    public e() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform int isAlpha;\nvoid main()\n{\n    highp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    color.rgb = color.rgb / color.a;\n    float alpha = step(0.5, color.a);\n    if (isAlpha == 1)\n    {\n        gl_FragColor = vec4(1.0 - alpha, 1.0 - alpha, 1.0 - alpha, 1.0);\n    }\n    else\n    {\n        gl_FragColor = vec4(color.rgb, alpha);\n    }\n}");
        addParam(new UniformParam.IntParam("isAlpha", 0));
    }

    private void b(float f16, float f17, float f18, float f19) {
        setPositions(new float[]{f16, f19, f16, f17, f18, f17, f18, f19});
    }

    public void a(Frame frame, Frame frame2) {
        b(-1.0f, 0.0f, 1.0f, -1.0f);
        addParam(new UniformParam.IntParam("isAlpha", 1));
        int textureId = frame.getTextureId();
        int i3 = frame.width;
        int i16 = frame.height;
        RenderProcess(textureId, i3, i16, i3, i16, -1, 0.0d, frame2);
        b(-1.0f, 1.0f, 1.0f, 0.0f);
        addParam(new UniformParam.IntParam("isAlpha", 0));
        int textureId2 = frame.getTextureId();
        int i17 = frame.width;
        int i18 = frame.height;
        RenderProcess(textureId2, i17, i18, i17, i18, -1, 0.0d, frame2);
    }
}
