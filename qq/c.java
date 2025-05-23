package qq;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.aebase.k;
import com.tencent.filter.BaseFilter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends BaseFilter {

    /* renamed from: a, reason: collision with root package name */
    private Frame f429221a;

    public c() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.f429221a = new Frame();
    }

    @Override // com.tencent.filter.BaseFilter
    public void clearGLSLSelf() {
        super.clearGLSLSelf();
        this.f429221a.clear();
    }

    public Frame a(int i3, List<PointF> list, int i16, int i17) {
        float[] fArr = new float[8];
        k.b(list, i16, i17, fArr);
        BaseFilter baseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        baseFilter.apply();
        baseFilter.setTexCords(fArr);
        baseFilter.setRotationAndFlip(0, 1, 1);
        baseFilter.RenderProcess(i3, i16, i17, 64, 64, -1, 0.0d, this.f429221a);
        return this.f429221a;
    }
}
