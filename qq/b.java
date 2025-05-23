package qq;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends BaseFilter {

    /* renamed from: a, reason: collision with root package name */
    private List<Frame> f429219a;

    /* renamed from: b, reason: collision with root package name */
    private Frame f429220b;

    public b() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.f429219a = new ArrayList();
        this.f429220b = new Frame();
    }

    public Frame a() {
        float size = 2.0f / this.f429219a.size();
        for (int i3 = 0; i3 < this.f429219a.size(); i3++) {
            float f16 = (i3 * size) - 1.0f;
            float f17 = f16 + size;
            setPositions(new float[]{f16, -1.0f, f16, 1.0f, f17, 1.0f, f17, -1.0f});
            Frame frame = this.f429219a.get(i3);
            RenderProcess(frame.getTextureId(), frame.width, frame.height, this.f429219a.size() * 64, 64, -1, 0.0d, this.f429220b);
        }
        return this.f429220b;
    }

    public void b(List<Frame> list) {
        this.f429219a = list;
    }

    @Override // com.tencent.filter.BaseFilter
    public void clearGLSLSelf() {
        super.clearGLSLSelf();
        this.f429220b.clear();
    }
}
