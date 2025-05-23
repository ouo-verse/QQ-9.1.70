package u04;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class h extends a<List<x04.b>> {
    @Override // u04.q
    public String b() {
        return MosaicConstants$JsProperty.PROP_THREAD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // u04.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Integer> d(List<x04.b> list) {
        HashMap hashMap = new HashMap();
        for (x04.b bVar : list) {
            c(hashMap, String.format("/%s/%s", bVar.b(), bVar.a()));
        }
        return hashMap;
    }
}
