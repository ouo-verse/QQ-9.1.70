package qq;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends BaseFilter {
    public a() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\n  float ty = textureCoordinate.y * 0.5;\n  float ny = ty + 0.5;\n  vec2 newCoord1 = vec2(textureCoordinate.x,ty);\n  vec2 newCoord2 = vec2(textureCoordinate.x,ny);\n\n  vec3 mask = texture2D(inputImageTexture,newCoord2).xyz;\n  vec3 color = texture2D(inputImageTexture,newCoord1).xyz;\n\n  float alpha = step(0.7, texture2D(inputImageTexture,newCoord2).r);\n  float newAlpha = 1.0 - alpha;\n  vec3 resultColor = color*newAlpha + texture2D(inputImageTexture,newCoord2).rgb;\n  \n  gl_FragColor = vec4(resultColor.rgb, newAlpha);\n}");
    }

    public void a(Frame frame, int i3, int i16, Frame frame2) {
        RenderProcess(frame.getTextureId(), i3, i16, -1, 0.0d, frame2);
    }
}
