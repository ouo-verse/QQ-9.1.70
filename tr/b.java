package tr;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b implements c {
    @Override // tr.c
    public void a(List<a> list, DoodleView doodleView) {
        FaceLayer faceLayer = new FaceLayer(doodleView);
        DynamicFaceLayer dynamicFaceLayer = new DynamicFaceLayer(doodleView);
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar = new com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c(doodleView);
        g gVar = new g(doodleView);
        list.add(faceLayer);
        list.add(dynamicFaceLayer);
        list.add(cVar);
        list.add(gVar);
    }
}
