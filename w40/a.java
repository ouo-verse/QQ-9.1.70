package w40;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.part.Part;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.immersive.layer.biz.b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.b, com.tencent.biz.qqcircle.immersive.layer.base.b
    public List<Part> g(@NonNull com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        List<Part> g16 = super.g(aVar);
        g16.add(new b(((com.tencent.biz.qqcircle.immersive.layer.biz.a) aVar).b()));
        return g16;
    }
}
