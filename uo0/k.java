package uo0;

import com.tencent.guild.aio.input.at.quickAt.search.SearchException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class k implements ze1.c {

    /* renamed from: a, reason: collision with root package name */
    protected int f439346a = 0;

    /* renamed from: b, reason: collision with root package name */
    protected a f439347b;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a(k kVar, SearchException searchException);
    }

    @Override // ze1.c
    public boolean b() {
        return false;
    }

    public void c() {
        if (this.f439346a != 1) {
            return;
        }
        this.f439346a = 2;
    }

    public void d() {
        int i3 = this.f439346a;
        if (i3 != 1 && i3 != 3) {
            return;
        }
        this.f439346a = 3;
        a aVar = this.f439347b;
        if (aVar != null) {
            aVar.a(this, null);
        }
    }

    public void e(SearchException searchException) {
        if (this.f439346a != 1) {
            return;
        }
        this.f439346a = 4;
        a aVar = this.f439347b;
        if (aVar != null) {
            aVar.a(this, searchException);
        }
    }

    public abstract String f();

    public Object g() {
        return null;
    }

    public abstract String h();

    public abstract List i();

    public boolean j() {
        if (this.f439346a == 2) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f439346a == 3) {
            return true;
        }
        return false;
    }

    public boolean l() {
        return false;
    }

    public abstract void m();

    public void n(a aVar) {
        if (this.f439346a != 0) {
            return;
        }
        this.f439346a = 1;
        this.f439347b = aVar;
        m();
    }

    @Override // ze1.c
    public void a() {
    }
}
