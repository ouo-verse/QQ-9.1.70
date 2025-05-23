package vo0;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> f442096a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private HashMap<Long, Integer> f442097b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> f442098c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private Set<Long> f442099d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private boolean f442100e = false;

    /* renamed from: f, reason: collision with root package name */
    private final Set<b> f442101f = new HashSet();

    private void f(List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list) {
        Iterator<b> it = this.f442101f.iterator();
        while (it.hasNext()) {
            it.next().c(list);
        }
    }

    private void g(boolean z16, com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, int i3) {
        Iterator<b> it = this.f442101f.iterator();
        while (it.hasNext()) {
            it.next().e(z16, aVar, this.f442098c, i3);
        }
    }

    private void h() {
        Iterator<b> it = this.f442101f.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    private void i() {
        Iterator<b> it = this.f442101f.iterator();
        while (it.hasNext()) {
            it.next().g(this.f442100e);
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f442101f.add(bVar);
        }
    }

    public boolean b(com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, int i3) {
        if (this.f442099d.contains(Long.valueOf(aVar.c()))) {
            return false;
        }
        aVar.h(true);
        this.f442099d.add(Long.valueOf(aVar.c()));
        this.f442098c.add(aVar);
        g(true, aVar, i3);
        return true;
    }

    public List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> c() {
        return this.f442096a;
    }

    public List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> d() {
        return this.f442098c;
    }

    public boolean e() {
        return this.f442100e;
    }

    public void j() {
        this.f442096a.clear();
        this.f442097b.clear();
        this.f442098c.clear();
        this.f442099d.clear();
        h();
    }

    public void k() {
        this.f442096a.clear();
        this.f442097b.clear();
        this.f442098c.clear();
        this.f442099d.clear();
        this.f442101f.clear();
    }

    public boolean l(com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, int i3) {
        if (!this.f442099d.contains(Long.valueOf(aVar.c()))) {
            return false;
        }
        aVar.h(false);
        this.f442099d.remove(Long.valueOf(aVar.c()));
        Iterator<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> it = this.f442098c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.guild.aio.input.at.quickAt.selectmember.data.a next = it.next();
            if (next.c() == aVar.c()) {
                next.h(false);
                it.remove();
                break;
            }
        }
        g(false, aVar, i3);
        return true;
    }

    public void m(boolean z16) {
        QLog.d("GuildAtSelectModel", 1, "setEnableMultiSelectMode mIsMultiSelectMode = " + this.f442100e + "isEnableMultiMode = " + z16);
        if (this.f442100e == z16) {
            return;
        }
        this.f442100e = z16;
        Iterator<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> it = this.f442096a.iterator();
        while (it.hasNext()) {
            it.next().g(this.f442100e);
        }
        if (!this.f442100e && !this.f442099d.isEmpty()) {
            Iterator<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> it5 = this.f442096a.iterator();
            while (it5.hasNext()) {
                it5.next().h(false);
            }
            ArrayList arrayList = new ArrayList(this.f442098c);
            this.f442099d.clear();
            this.f442098c.clear();
            f(arrayList);
        }
        i();
    }

    public void n(List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list) {
        if (list == null) {
            QLog.d("GuildAtSelectModel", 1, "setMemberDataList newDataList is null");
            return;
        }
        QLog.d("GuildAtSelectModel", 1, "newDataList size = " + list.size() + "selectedSize = " + this.f442098c.size());
        ArrayList arrayList = new ArrayList();
        HashMap<Long, Integer> hashMap = new HashMap<>();
        int i3 = 0;
        for (com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar : list) {
            arrayList.add(aVar);
            hashMap.put(Long.valueOf(aVar.c()), Integer.valueOf(i3));
            aVar.g(e());
            aVar.h(this.f442099d.contains(Long.valueOf(aVar.c())));
            i3++;
        }
        this.f442096a.clear();
        this.f442096a = arrayList;
        this.f442097b.clear();
        this.f442097b = hashMap;
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        for (com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar2 : this.f442098c) {
            if (this.f442097b.containsKey(Long.valueOf(aVar2.c()))) {
                arrayList2.add(this.f442096a.get(this.f442097b.get(Long.valueOf(aVar2.c())).intValue()));
            } else {
                arrayList2.add(aVar2);
            }
            hashSet.add(Long.valueOf(aVar2.c()));
        }
        this.f442098c.clear();
        this.f442098c = arrayList2;
        this.f442099d.clear();
        this.f442099d = hashSet;
        h();
    }

    public void o(long j3, int i3) {
        QLog.d("GuildAtSelectModel", 1, "unSelectItem id = " + j3 + "triggerType = " + i3);
        if (this.f442100e && this.f442099d.contains(Long.valueOf(j3))) {
            this.f442099d.remove(Long.valueOf(j3));
            Iterator<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> it = this.f442098c.iterator();
            com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                aVar = it.next();
                if (aVar.c() == j3) {
                    aVar.h(false);
                    it.remove();
                    break;
                }
            }
            g(false, aVar, i3);
        }
    }
}
