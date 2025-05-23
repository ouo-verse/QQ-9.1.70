package u04;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import shark.HeapObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e extends b {
    private Set<Long> g(shark.b bVar, Map<String, Integer> map) {
        HeapObject.HeapClass a16 = bVar.a("android.database.sqlite.SQLiteCursor");
        HashSet hashSet = new HashSet();
        if (a16 == null) {
            return hashSet;
        }
        for (HeapObject.HeapInstance heapInstance : a16.c()) {
            String e16 = a14.d.e(heapInstance, "android.database.sqlite.SQLiteCursor", "mEditTable");
            if (TextUtils.isEmpty(e16)) {
                e16 = "default_table";
            }
            HeapObject.HeapInstance a17 = a14.d.a(heapInstance, "android.database.AbstractWindowedCursor", "mWindow");
            if (a17 != null) {
                c(map, String.format("%s/table:%s", a14.d.e(a17, "android.database.CursorWindow", "mName"), e16));
                hashSet.add(Long.valueOf(a17.getObjectId()));
            }
        }
        return hashSet;
    }

    @Override // u04.q
    public String b() {
        return "cursor";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // u04.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Integer> d(x04.a aVar) {
        HashMap hashMap = new HashMap();
        aVar.b(b(), g(aVar.a(), hashMap));
        return hashMap;
    }
}
