package sr;

import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import hd0.c;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends f {
    public a(DoodleView doodleView) {
        super(doodleView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f
    public void H(MotionEvent motionEvent) {
        DynamicTextItem dynamicTextItem;
        if (this.K instanceof g.c) {
            if (this.P == null) {
                return;
            }
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (this.L.s(this.K, x16, y16, true) && (dynamicTextItem = ((g.c) this.K).f68001z) != null) {
                if (dynamicTextItem.F() && dynamicTextItem.A()) {
                    int u16 = dynamicTextItem.u(motionEvent, j(), f(), (g.c) this.K, this.L);
                    dynamicTextItem.c(u16);
                    this.P.d(this.K, u16, 3, x16, y16);
                    return;
                }
                this.P.d(this.K, dynamicTextItem.h(), 0, x16, y16);
                return;
            }
            return;
        }
        c.a(f.Q, "call super method, click the item:" + this.K);
        super.H(motionEvent);
    }
}
