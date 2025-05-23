package s8;

import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import java.util.Collection;
import java.util.List;
import n7.a;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements com.qzone.adapter.feedcomponent.m {

    /* renamed from: a, reason: collision with root package name */
    private DbCacheManager f433422a = null;

    a() {
    }

    public static com.qzone.adapter.feedcomponent.m q(Class cls, long j3, String str) {
        a aVar = new a();
        aVar.f433422a = com.qzone.component.cache.database.c.g().e(cls, j3, str);
        return aVar;
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public int a(Collection<String> collection) {
        return this.f433422a.c0(collection);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public void appendData(Object obj) {
        this.f433422a.o0((IDBCacheDataWrapper) obj, 1);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public int b(Object obj, String str) {
        return this.f433422a.u0((IDBCacheDataWrapper) obj, str);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public void c(String str) {
        this.f433422a.s0(str);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public void clearData() {
        this.f433422a.W();
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public void close() {
        this.f433422a.close();
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public void d(a.InterfaceC10828a interfaceC10828a) {
        this.f433422a.U(interfaceC10828a);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public int deleteData(String str, String[] strArr) {
        return this.f433422a.b0(str, strArr);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public List<? extends Object> e(String str, String str2) {
        return this.f433422a.i0(str, null, str2, 0, 0);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public List<? extends Object> f(String str, String[] strArr, String str2, int i3, int i16) {
        return this.f433422a.i0(str, strArr, str2, i3, i16);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public List<? extends Object> g(String str, String str2, int i3, int i16) {
        return this.f433422a.i0(str, null, str2, i3, i16);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public int getCount() {
        return this.f433422a.e0();
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public void h(Collection<? extends Object> collection) {
        this.f433422a.p0(collection, 2);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public void i(String[] strArr) {
        this.f433422a.t0(strArr);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public boolean isClosed() {
        return this.f433422a.isClosed();
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public void j(int i3, String str) {
        this.f433422a.V(i3, str);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public Object k(String str, String[] strArr) {
        return this.f433422a.k0(str, strArr);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public void l(String str) {
        this.f433422a.r0(str);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public void m(Collection<? extends Object> collection) {
        this.f433422a.p0(collection, 1);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public int n(Object obj, String str, String[] strArr) {
        return this.f433422a.v0((IDBCacheDataWrapper) obj, str, strArr);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    @Deprecated
    public int o(String str) {
        return this.f433422a.b0(str, null);
    }

    @Override // com.qzone.adapter.feedcomponent.m
    public Object p(String str, String str2, String[] strArr, String str3) {
        return this.f433422a.m0(str, str2, strArr, str3);
    }
}
