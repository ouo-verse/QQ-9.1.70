package v61;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    Class f441179a;

    /* renamed from: b, reason: collision with root package name */
    String f441180b;

    /* renamed from: c, reason: collision with root package name */
    int f441181c;

    /* renamed from: d, reason: collision with root package name */
    boolean f441182d;

    public static a a(Class cls, String str, int i3, boolean z16) {
        a aVar = new a();
        aVar.f441179a = cls;
        aVar.f441180b = str;
        aVar.f441181c = i3;
        aVar.f441182d = z16;
        return aVar;
    }

    public a b() {
        return a(this.f441179a, this.f441180b, this.f441181c, this.f441182d);
    }

    public Class c() {
        return this.f441179a;
    }

    public boolean d() {
        return this.f441182d;
    }

    public String toString() {
        return "AIOTask{mClassName='" + this.f441179a.getSimpleName() + "', mUin='" + this.f441180b + "', mChatType=" + this.f441181c + ", mIsScaleAIO=" + this.f441182d + '}';
    }
}
