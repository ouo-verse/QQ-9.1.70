package u04;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c extends a<Map<Integer, v04.a>> {
    @Override // u04.q
    public String b() {
        return "file";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // u04.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Integer> d(Map<Integer, v04.a> map) {
        v04.a aVar = map.get(5);
        if (aVar != null) {
            return aVar.i();
        }
        return null;
    }
}
