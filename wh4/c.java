package wh4;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private b f445680a = new b();

    /* renamed from: b, reason: collision with root package name */
    private float f445681b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    private float f445682c = 0.25f;

    public void a(b bVar, a aVar) {
        float f16 = this.f445681b;
        float f17 = bVar.f445679c;
        aVar.f445676c = f16 / (f16 + f17);
        b bVar2 = this.f445680a;
        float f18 = bVar2.f445679c;
        float f19 = bVar2.f445677a;
        aVar.f445674a = f19 - (((f18 - f17) * (f19 - bVar.f445677a)) / f18);
        float f26 = bVar2.f445678b;
        aVar.f445675b = f26 - (((f18 - f17) * (f26 - bVar.f445678b)) / f18);
    }

    public void b(b bVar, float f16) {
        this.f445680a = bVar;
        this.f445681b = (bVar.f445679c * f16) / (1.0f - f16);
    }
}
