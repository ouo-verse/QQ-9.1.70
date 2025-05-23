package u30;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private int f438188a = 1;

    public int a() {
        int i3 = this.f438188a;
        if (i3 >= Integer.MAX_VALUE) {
            this.f438188a = 0;
        } else if (i3 <= Integer.MIN_VALUE) {
            this.f438188a = 0;
        }
        int i16 = this.f438188a + 1;
        this.f438188a = i16;
        return i16;
    }

    public void b() {
        this.f438188a = 1;
    }
}
