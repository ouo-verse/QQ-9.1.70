package wo0;

import ap0.f;
import com.tencent.guild.aio.input.at.quickAt.selectmember.data.e;
import com.tencent.guild.aio.input.at.utils.RecentAtRobotCache;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    private boolean f445994b;

    public c(d dVar, int i3) {
        super(dVar);
        this.f445994b = false;
        this.f445994b = i3 == 7;
    }

    @Override // wo0.a
    public void a() {
        super.a();
        if (this.f445994b) {
            RecentAtRobotCache.c(this.f445993a.getGuildId());
        }
    }

    @Override // wo0.a
    public void b() {
        if (this.f445994b) {
            RecentAtRobotCache.c(this.f445993a.getGuildId());
        }
    }

    @Override // wo0.a
    public void c() {
        super.c();
    }

    @Override // wo0.a
    public boolean d(com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, boolean z16) {
        zo0.a a16 = f.a();
        if (a16 != null && z16) {
            a16.n();
        }
        if (this.f445994b && ((!z16 || !aVar.e()) && (aVar instanceof e))) {
            RecentAtRobotCache.d(((e) aVar).i().getTinyId());
        }
        return super.d(aVar, z16);
    }
}
