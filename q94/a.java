package q94;

import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskChannel;
import com.tencent.sqshow.zootopia.nativeui.ue.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m94.i;
import qu4.j;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lq94/a;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "Lm94/a;", "l", "Lb94/d;", "dressController", "", "i", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", "", "taskName", "Lm94/i;", "callback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Ljava/lang/String;Lm94/i;)V", "g", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a extends com.tencent.sqshow.zootopia.nativeui.data.dress.task.b {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicInteger f428750h = new AtomicInteger(0);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(DressTaskChannel dressTaskChannel, String taskName, i callback) {
        super(dressTaskChannel, taskName + "-" + f428750h.getAndIncrement(), callback, false, false, 24, null);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(b94.d dressController) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        m94.a b16 = cVar.m().b();
        HashSet<Integer> x16 = cVar.x();
        m94.a l3 = l();
        Map<Integer, az> b17 = b16.b();
        Map<Integer, az> b18 = l3.b();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<T> it = b17.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            x16.add(entry.getKey());
            if (r94.b.z((az) entry.getValue())) {
                hashMap.put(entry.getKey(), entry.getValue());
                hashMap2.put(entry.getKey(), r94.b.a((az) entry.getValue()));
            }
        }
        Collection<az> values = b18.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it5 = values.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            az azVar = (az) next;
            if (r94.b.C(azVar) || r94.b.G(azVar)) {
                arrayList.add(next);
            }
        }
        p.f371394a.f(hashMap, r94.b.n(arrayList));
        HashSet hashSet = new HashSet();
        Iterator<T> it6 = b18.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            x16.add(entry2.getKey());
            if (r94.b.C((az) entry2.getValue()) || r94.b.G((az) entry2.getValue())) {
                String str = (String) hashMap2.get(entry2.getKey());
                if (str != null) {
                    hashSet.add(str);
                }
                hashMap.put(entry2.getKey(), entry2.getValue());
                az[] azVarArr = ((az) entry2.getValue()).f440289p;
                Intrinsics.checkNotNullExpressionValue(azVarArr, "entry.value.containStoreItems");
                for (az subItem : azVarArr) {
                    Intrinsics.checkNotNullExpressionValue(subItem, "subItem");
                    x16.add(Integer.valueOf(r94.b.M(subItem)));
                    hashMap.put(Integer.valueOf(r94.b.M(subItem)), subItem);
                }
            }
        }
        Map<Integer, az> b19 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.p().b().b();
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry3 : hashMap.entrySet()) {
            if (hashSet.contains(r94.b.a((az) entry3.getValue()))) {
                az azVar2 = b19.get(entry3.getKey());
                if (azVar2 != null) {
                    hashMap3.put(entry3.getKey(), azVar2);
                }
            } else {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
        }
        HashMap h16 = p.h(p.f371394a, hashMap3, b19, x16, null, 8, null);
        Collection values2 = h16.values();
        Intrinsics.checkNotNullExpressionValue(values2, "finalDressMap.values");
        qu4.a a16 = bj3.a.a(values2);
        a16.f429576e = b16.getAvatarCharacter().f429576e;
        j jVar = a16.f429573b;
        Intrinsics.checkNotNullExpressionValue(jVar, "newAvatar.faceInfo");
        bj3.a.f(jVar, b16.getAvatarCharacter().f429573b);
        com.tencent.sqshow.zootopia.nativeui.data.dress.task.b.d(this, dressController, new m94.a(b16.getGender(), h16, a16), false, null, 12, null);
    }

    public abstract m94.a l();
}
