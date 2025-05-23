package rv1;

import com.tencent.mobileqq.qqguildsdk.data.de;
import com.tencent.mobileqq.qqguildsdk.data.di;
import com.tencent.xaction.log.b;
import xh2.c;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private c f432555a;

    /* renamed from: b, reason: collision with root package name */
    private di f432556b;

    /* renamed from: c, reason: collision with root package name */
    private String f432557c;

    /* renamed from: d, reason: collision with root package name */
    private int f432558d;

    /* renamed from: e, reason: collision with root package name */
    private String f432559e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f432560f;

    /* renamed from: g, reason: collision with root package name */
    private de f432561g;

    public a(c cVar) {
        this.f432555a = cVar;
        this.f432557c = cVar.getName();
        this.f432558d = cVar.getClientId();
        this.f432559e = cVar.getIcon();
        this.f432560f = true;
        this.f432561g = cVar.a();
    }

    public de a() {
        return this.f432561g;
    }

    public int b() {
        return this.f432558d;
    }

    public String c() {
        return this.f432559e;
    }

    public String d() {
        return this.f432557c;
    }

    public boolean e() {
        return this.f432560f;
    }

    public a(di diVar) {
        this.f432556b = diVar;
        this.f432557c = diVar.getClientName();
        try {
            this.f432558d = Integer.parseInt(diVar.getClientId());
        } catch (NumberFormatException e16) {
            b.c("Guild.profile.GuildProfileArchiveData", 1, "parse clientId", e16);
        }
        this.f432559e = diVar.getIcon();
        this.f432560f = false;
    }
}
