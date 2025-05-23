package u04;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import shark.HeapObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class o extends b {
    private void g(x04.a aVar, Map<Long, String> map) {
        HeapObject.HeapClass a16 = aVar.a().a("android.view.SurfaceView");
        if (a16 == null) {
            return;
        }
        for (HeapObject.HeapInstance heapInstance : a16.c()) {
            map.put(Long.valueOf(heapInstance.getObjectId()), "/" + heapInstance.e());
        }
    }

    private Set<Long> h(x04.a aVar, Map<Long, String> map, String str) {
        HeapObject.HeapClass a16 = aVar.a().a(str);
        HashSet hashSet = new HashSet();
        if (a16 == null) {
            return hashSet;
        }
        for (HeapObject.HeapInstance heapInstance : a16.c()) {
            String d16 = a14.d.d(heapInstance, "mTitle");
            map.put(Long.valueOf(heapInstance.getObjectId()), "/title(" + d16 + ")");
            hashSet.add(Long.valueOf(heapInstance.getObjectId()));
        }
        return hashSet;
    }

    private void i(shark.b bVar, Set<Long> set, String str, String str2, Map<Long, String> map) {
        HeapObject.HeapClass a16 = bVar.a(str);
        if (a16 == null) {
            return;
        }
        for (HeapObject.HeapInstance heapInstance : a16.c()) {
            HeapObject.HeapInstance a17 = a14.d.a(heapInstance, str, str2);
            if (a17 != null && set.contains(Long.valueOf(a17.getObjectId()))) {
                String str3 = map.get(Long.valueOf(a17.getObjectId()));
                if (!TextUtils.isEmpty(str3)) {
                    map.put(Long.valueOf(a17.getObjectId()), "/" + heapInstance.e() + str3);
                }
            }
        }
    }

    @Override // u04.q
    public String b() {
        return "window";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // u04.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Integer> d(x04.a aVar) {
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        hashSet.addAll(h(aVar, hashMap, "com.android.internal.policy.PhoneWindow"));
        hashSet.addAll(h(aVar, hashMap, "com.android.internal.policy.impl.PhoneWindow"));
        hashSet.addAll(h(aVar, hashMap, "com.android.internal.policy.HwPhoneWindow"));
        i(aVar.a(), hashSet, "android.app.Activity", "mWindow", hashMap);
        i(aVar.a(), hashSet, "android.app.Dialog", "mWindow", hashMap);
        g(aVar, hashMap);
        HashMap hashMap2 = new HashMap();
        Iterator<String> it = hashMap.values().iterator();
        while (it.hasNext()) {
            c(hashMap2, it.next());
        }
        return hashMap2;
    }
}
