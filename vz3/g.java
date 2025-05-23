package vz3;

import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g<T> {

    /* renamed from: b, reason: collision with root package name */
    private final Comparator<T> f443795b;

    /* renamed from: c, reason: collision with root package name */
    private final b f443796c;

    /* renamed from: d, reason: collision with root package name */
    private int f443797d = 0;

    /* renamed from: a, reason: collision with root package name */
    private final a<T> f443794a = new a<>();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface b<T> {
        int a(T t16, long j3);
    }

    public g(Comparator<T> comparator, b<T> bVar) {
        this.f443796c = bVar;
        this.f443795b = comparator;
    }

    public boolean a(T t16) {
        if (t16 == null) {
            return false;
        }
        a<T> aVar = this.f443794a.f443799b;
        while (aVar != this.f443794a && this.f443795b.compare(aVar.f443798a, t16) < 0) {
            aVar = aVar.f443799b;
        }
        if (t16.equals(aVar.f443798a)) {
            return false;
        }
        a<T> aVar2 = new a<>(t16, aVar, aVar.f443800c);
        aVar.f443800c.f443799b = aVar2;
        aVar.f443800c = aVar2;
        this.f443797d++;
        return true;
    }

    public boolean b(T t16) {
        if (t16 == null) {
            return false;
        }
        a<T> aVar = this.f443794a.f443800c;
        while (aVar != this.f443794a && this.f443795b.compare(aVar.f443798a, t16) > 0) {
            aVar = aVar.f443800c;
        }
        if (t16.equals(aVar.f443798a)) {
            return false;
        }
        a<T> aVar2 = new a<>(t16, aVar.f443799b, aVar);
        aVar.f443799b.f443800c = aVar2;
        aVar.f443799b = aVar2;
        this.f443797d++;
        return true;
    }

    public void c() {
        a<T> aVar = this.f443794a;
        aVar.f443799b = aVar;
        aVar.f443800c = aVar;
        this.f443797d = 0;
    }

    public T d() {
        a<T> aVar = this.f443794a;
        a<T> aVar2 = aVar.f443800c;
        if (aVar2 != aVar) {
            return aVar2.f443798a;
        }
        return null;
    }

    public List<T> e(long j3, List<T> list) {
        a<T> aVar = this.f443794a.f443799b;
        while (aVar != this.f443794a && this.f443796c.a(aVar.f443798a, j3) <= 0) {
            if (list != null) {
                list.add(aVar.f443798a);
            }
            this.f443797d--;
            aVar = aVar.f443799b;
        }
        a<T> aVar2 = this.f443794a;
        aVar2.f443799b = aVar;
        aVar.f443800c = aVar2;
        return list;
    }

    public int f() {
        return this.f443797d;
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f443798a;

        /* renamed from: b, reason: collision with root package name */
        public a<T> f443799b;

        /* renamed from: c, reason: collision with root package name */
        public a<T> f443800c;

        public a() {
            this.f443798a = null;
            this.f443799b = this;
            this.f443800c = this;
        }

        public a(T t16, a<T> aVar, a<T> aVar2) {
            this.f443798a = t16;
            this.f443799b = aVar;
            this.f443800c = aVar2;
        }
    }
}
