package v40;

import com.tencent.biz.qqcircle.immersive.layer.base.b;
import com.tencent.biz.qqcircle.immersive.part.cg;
import com.tencent.biz.qqcircle.immersive.part.fg;
import com.tencent.biz.richframework.part.Part;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\t"}, d2 = {"Lv40/a;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/b;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/a;", "builder", "", "Lcom/tencent/biz/richframework/part/Part;", "g", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class a extends b {
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    @NotNull
    protected List<Part> g(@NotNull com.tencent.biz.qqcircle.immersive.layer.base.a builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ArrayList arrayList = new ArrayList();
        if (!(builder instanceof com.tencent.biz.qqcircle.immersive.layer.biz.a)) {
            return arrayList;
        }
        com.tencent.biz.qqcircle.immersive.layer.biz.a aVar = (com.tencent.biz.qqcircle.immersive.layer.biz.a) builder;
        arrayList.add(new z40.b(aVar.b()));
        arrayList.add(new fg());
        if (aVar.b() != null) {
            cg cgVar = new cg(aVar.b());
            FeedCloudMeta$StTagInfo tagInfo = aVar.b().getTagInfo();
            if (tagInfo != null) {
                cgVar.Ja(tagInfo);
            }
            cgVar.Ha(aVar.b());
            cgVar.Ga(8);
            arrayList.add(cgVar);
        }
        return arrayList;
    }
}
