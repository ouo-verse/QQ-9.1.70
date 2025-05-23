package xw1;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Integer f448901a = 1;

    /* renamed from: b, reason: collision with root package name */
    private Long f448902b = Long.valueOf(MiniBoxNoticeInfo.MIN_5);

    /* renamed from: c, reason: collision with root package name */
    private Integer f448903c = 5000;

    /* renamed from: d, reason: collision with root package name */
    private Integer f448904d = 1000;

    /* renamed from: e, reason: collision with root package name */
    private Integer f448905e = 1;

    /* renamed from: f, reason: collision with root package name */
    private Integer f448906f = 300000;

    /* renamed from: g, reason: collision with root package name */
    private Integer f448907g = 20;

    public Long a() {
        return this.f448902b;
    }

    public Integer b() {
        return this.f448901a;
    }

    public Integer c() {
        return this.f448903c;
    }

    public Integer d() {
        return this.f448906f;
    }

    public Integer e() {
        return this.f448904d;
    }

    public void f(Long l3) {
        this.f448902b = l3;
    }

    public void g(Integer num) {
        this.f448901a = num;
    }

    public void h(Integer num) {
        this.f448905e = num;
    }

    public void i(Integer num) {
        this.f448903c = num;
    }

    public void j(Integer num) {
        this.f448907g = num;
    }

    public void k(Integer num) {
        this.f448906f = num;
    }

    public void l(Integer num) {
        this.f448904d = num;
    }

    public String toString() {
        return "RobotConfig{isInlineBotOpen=" + this.f448901a + ", cacheDuration=" + this.f448902b + ", requestTimeout=" + this.f448903c + ", typeTimeout=" + this.f448904d + ", isSupportSlash=" + this.f448905e + ", robotSlashCmdCacheDuration=" + this.f448906f + ", robotSlashCmdCacheCapacity=" + this.f448907g + '}';
    }
}
