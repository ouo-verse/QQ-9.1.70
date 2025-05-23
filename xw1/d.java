package xw1;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private long f448908a;

    /* renamed from: b, reason: collision with root package name */
    private long f448909b;

    /* renamed from: c, reason: collision with root package name */
    private String f448910c;

    /* renamed from: d, reason: collision with root package name */
    private int f448911d;

    /* renamed from: e, reason: collision with root package name */
    private String f448912e;

    /* renamed from: f, reason: collision with root package name */
    private long f448913f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f448914g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f448915h = false;

    public void a(String str) {
        this.f448912e = str;
    }

    public void b(Integer num) {
        this.f448911d = num.intValue();
    }

    public void c(long j3) {
        this.f448913f = j3;
    }

    public void d(String str) {
        this.f448910c = str;
    }

    public void e(long j3) {
        this.f448908a = j3;
    }

    public void f(long j3) {
        this.f448909b = j3;
    }

    public String toString() {
        return "RobotInfo{tinyId=" + this.f448908a + ", uin=" + this.f448909b + ", name='" + this.f448910c + "', inlineSearchStatus=" + this.f448911d + ", appId='" + this.f448912e + "', mark=" + this.f448913f + ", isRecentRecordItem=" + this.f448915h + ", isRecentRecordTitle=" + this.f448914g + '}';
    }
}
