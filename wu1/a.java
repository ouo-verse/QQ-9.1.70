package wu1;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f446537c = new a();

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, C11509a> f446538a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final List<wu1.b> f446539b = new ArrayList();

    /* compiled from: P */
    /* renamed from: wu1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C11509a {

        /* renamed from: a, reason: collision with root package name */
        public String f446540a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f446541b;

        /* renamed from: c, reason: collision with root package name */
        public HashMap<String, b> f446542c;

        public C11509a(String str, boolean z16, HashMap<String, b> hashMap) {
            this.f446540a = str;
            this.f446541b = z16;
            this.f446542c = hashMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f446543a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f446544b;

        public b(String str, boolean z16) {
            this.f446543a = str;
            this.f446544b = z16;
        }
    }

    a() {
    }

    private void d() {
        Iterator<wu1.b> it = this.f446539b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void a(String str, String[] strArr) {
        HashMap hashMap = new HashMap();
        for (String str2 : strArr) {
            hashMap.put(str2, new b(str2, false));
        }
        this.f446538a.put(str, new C11509a(str, true, hashMap));
        d();
    }

    public boolean b(String str) {
        C11509a c11509a = this.f446538a.get(str);
        if (c11509a == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.mission.GuildManagerMission", 2, str + "'s mission is not exist");
                return false;
            }
            return false;
        }
        return c11509a.f446541b;
    }

    public boolean c(String str, String str2) {
        b bVar;
        C11509a c11509a = this.f446538a.get(str);
        if (c11509a == null || (bVar = c11509a.f446542c.get(str2)) == null) {
            return false;
        }
        return bVar.f446544b;
    }

    public void e(wu1.b bVar) {
        QLog.d("Guild.mission.GuildManagerMission", 4, "registerMissionObserver");
        if (this.f446539b.contains(bVar)) {
            return;
        }
        this.f446539b.add(bVar);
    }

    public void f(wu1.b bVar) {
        QLog.d("Guild.mission.GuildManagerMission", 4, "unregisterMissionObserver");
        this.f446539b.remove(bVar);
    }
}
