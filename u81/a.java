package u81;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private b f438535a = new b();

    /* renamed from: b, reason: collision with root package name */
    private c f438536b = new c();

    public a() {
        this.f438535a.f();
        this.f438536b.f();
    }

    public void a(int i3, int i16, float[] fArr, float[] fArr2) {
        if (i3 == 36197) {
            this.f438536b.d(i16, fArr, fArr2);
        } else {
            if (i3 == 3553) {
                this.f438535a.d(i16, fArr, fArr2);
                return;
            }
            throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
        }
    }

    public void b() {
        this.f438535a.c();
        this.f438536b.c();
    }
}
