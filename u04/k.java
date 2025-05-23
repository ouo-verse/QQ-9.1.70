package u04;

import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class k extends a<Map<Integer, v04.a>> {
    @Override // u04.q
    public String b() {
        return SemanticAttributes.NetTransportValues.PIPE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // u04.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Integer> d(Map<Integer, v04.a> map) {
        v04.a aVar = map.get(6);
        if (aVar == null) {
            return null;
        }
        Map<String, Integer> i3 = aVar.i();
        if (i3.size() <= 0) {
            return null;
        }
        Iterator<Integer> it = i3.values().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            i16 += it.next().intValue();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SemanticAttributes.NetTransportValues.PIPE, Integer.valueOf(i16));
        return hashMap;
    }
}
