package u04;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import shark.HeapObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class m extends b {
    private Set<Long> g(x04.a aVar, Map<String, Integer> map) {
        HeapObject.HeapClass a16 = aVar.a().a("java.net.Socket");
        HashSet hashSet = new HashSet();
        if (a16 == null) {
            return hashSet;
        }
        for (HeapObject.HeapInstance heapInstance : a16.c()) {
            HeapObject.HeapInstance a17 = a14.d.a(heapInstance, "java.net.Socket", "impl");
            if (a17 != null) {
                int c16 = a14.d.c(a17, "java.net.SocketImpl", "port");
                String i3 = i(a14.d.a(a17, "java.net.SocketImpl", "address"));
                if (!TextUtils.isEmpty(i3)) {
                    c(map, String.format("/%s:%s", i3, Integer.valueOf(c16)));
                    hashSet.add(Long.valueOf(heapInstance.getObjectId()));
                }
            }
        }
        return hashSet;
    }

    private Set<Long> h(x04.a aVar, Map<String, Integer> map) {
        HeapObject.HeapInstance a16;
        HeapObject.HeapClass a17 = aVar.a().a("sun.nio.ch.SocketChannelImpl");
        HashSet hashSet = new HashSet();
        if (a17 == null) {
            return hashSet;
        }
        for (HeapObject.HeapInstance heapInstance : a17.c()) {
            HeapObject.HeapInstance a18 = a14.d.a(heapInstance, "sun.nio.ch.SocketChannelImpl", "remoteAddress");
            if (a18 != null && (a16 = a14.d.a(a18, "java.net.InetSocketAddress", "holder")) != null) {
                int b16 = a14.d.b(a16, "port");
                String i3 = i(a14.d.a(a16, "java.net.InetSocketAddress$InetSocketAddressHolder", "addr"));
                if (!TextUtils.isEmpty(i3)) {
                    c(map, String.format("/%s:%s", i3, Integer.valueOf(b16)));
                    hashSet.add(Long.valueOf(heapInstance.getObjectId()));
                }
            }
        }
        return hashSet;
    }

    private String i(HeapObject.HeapInstance heapInstance) {
        if (heapInstance != null) {
            String d16 = a14.d.d(a14.d.a(heapInstance, "java.net.InetAddress", "holder"), "originalHostName");
            if (TextUtils.isEmpty(d16)) {
                return j(a14.d.b(r3, "address"));
            }
            return d16;
        }
        return null;
    }

    private String j(long j3) {
        StringBuilder sb5 = new StringBuilder(15);
        for (int i3 = 0; i3 < 4; i3++) {
            sb5.insert(0, Long.toString(255 & j3));
            if (i3 < 3) {
                sb5.insert(0, '.');
            }
            j3 >>= 8;
        }
        return sb5.toString();
    }

    @Override // u04.q
    public String b() {
        return com.tencent.mobileqq.msf.core.d.f247918u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // u04.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Integer> d(x04.a aVar) {
        HashMap hashMap = new HashMap();
        Set<Long> g16 = g(aVar, hashMap);
        Set<Long> h16 = h(aVar, hashMap);
        HashSet hashSet = new HashSet();
        hashSet.addAll(g16);
        hashSet.addAll(h16);
        aVar.b(b(), hashSet);
        return hashMap;
    }
}
