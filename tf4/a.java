package tf4;

import com.tencent.timi.game.api.strategy.impl.a;
import tf4.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends com.tencent.timi.game.api.strategy.impl.a {

    /* renamed from: d, reason: collision with root package name */
    private sf4.a f436091d = new sf4.a();

    /* renamed from: e, reason: collision with root package name */
    private boolean f436092e = false;

    /* renamed from: f, reason: collision with root package name */
    private long f436093f = 0;

    /* renamed from: g, reason: collision with root package name */
    private c f436094g = null;

    /* renamed from: h, reason: collision with root package name */
    private long f436095h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f436096i = -1;

    /* renamed from: j, reason: collision with root package name */
    private final c.b f436097j = new C11288a();

    /* compiled from: P */
    /* renamed from: tf4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C11288a implements c.b {
        C11288a() {
        }

        @Override // tf4.c.b
        public void a(int i3, long j3) {
            a.this.e("\u5b8c\u6210\u7f51\u7edc\u6d4b\u901f retCode:" + i3 + " speedKB:" + j3 + "KB/s");
            if (i3 < 0) {
                a.this.e("networkSpeedListener.onFinish retCode:" + i3);
                return;
            }
            if (!a.this.f436092e) {
                a.this.d("isInit is false");
                return;
            }
            a.this.f436096i = j3;
            a aVar = a.this;
            aVar.s(aVar.f436096i);
        }

        @Override // tf4.c.b
        public void onStart() {
            a.this.e("\u5f00\u59cb\u7f51\u7edc\u6d4b\u901f");
        }
    }

    public a() {
        this.f376311a = "PlayerStrategy|SlowDownload";
    }

    private boolean r(long j3) {
        sf4.a aVar = this.f436091d;
        if (j3 <= aVar.slowDownloadBitrateSD) {
            return aVar.slowDownloadPreloadSD;
        }
        if (j3 <= aVar.slowDownloadBitrateHD) {
            return aVar.slowDownloadPreloadHD;
        }
        if (j3 <= aVar.slowDownloadBitrateSHD) {
            return aVar.slowDownloadPreloadSHD;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j3) {
        boolean t16 = t(j3);
        boolean r16 = r(j3);
        e("\u7f51\u7edc\u8bc4\u4f30\u7ed3\u679c \u7f51\u901f:" + j3 + "KB/s \u662f\u5426\u5f31\u7f51:" + t16 + " \u662f\u5426\u9884\u52a0\u8f7d:" + r16);
        if (!this.f436091d.slowDownloadEnable) {
            e("\u7b56\u7565\u4e0d\u542f\u7528\uff0c\u4e0d\u505a\u81ea\u52a8\u5207\u6362\uff01");
            a.InterfaceC9921a interfaceC9921a = this.f376313c;
            if (interfaceC9921a != null) {
                interfaceC9921a.slowDownloadNetworkChange(false, true);
                return;
            }
            return;
        }
        a.InterfaceC9921a interfaceC9921a2 = this.f376313c;
        if (interfaceC9921a2 != null) {
            interfaceC9921a2.slowDownloadNetworkChange(t16, r16);
        }
    }

    private boolean t(long j3) {
        if (j3 < this.f436091d.slowDownloadBitrateHD) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.timi.game.api.strategy.impl.a
    public void a() {
        this.f436092e = false;
        this.f376313c = null;
    }

    @Override // com.tencent.timi.game.api.strategy.impl.a
    public void c(a.InterfaceC9921a interfaceC9921a) {
        this.f376313c = interfaceC9921a;
        this.f436091d = b();
        this.f436092e = true;
    }

    @Override // com.tencent.timi.game.api.strategy.impl.a
    public void f() {
        e("\u79bb\u5f00\u5927\u5385\u9875");
        c cVar = this.f436094g;
        if (cVar != null) {
            cVar.o();
            this.f436094g = null;
        }
    }

    @Override // com.tencent.timi.game.api.strategy.impl.a
    public void g() {
        e("\u8fdb\u5165\u5927\u5385\u9875 \u4e4b\u524d\u6d4b\u7684\u7f51\u901f:" + this.f436096i + "KB/s");
        sf4.a b16 = b();
        this.f436091d = b16;
        if (b16.slowDownloadEnable && b16.testSpeedEnable) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f436095h > this.f436091d.testSpeedDuration && this.f436094g == null) {
                e("\u542f\u52a8\u7f51\u7edc\u6d4b\u901f");
                this.f436095h = currentTimeMillis;
                c cVar = new c();
                this.f436094g = cVar;
                cVar.n(this.f436091d.testSpeedUrl, this.f436097j);
                return;
            }
            return;
        }
        d("\u4e0d\u542f\u52a8\u81ea\u52a8\u6d4b\u901f! \u56de\u8c03\u4e00\u4e2a\u9ed8\u8ba4\u503c");
        a.InterfaceC9921a interfaceC9921a = this.f376313c;
        if (interfaceC9921a != null) {
            interfaceC9921a.slowDownloadNetworkChange(false, true);
        }
    }

    @Override // com.tencent.timi.game.api.strategy.impl.a
    public void h(long j3) {
        e("onPageIn:" + j3);
        this.f436093f = j3;
    }

    @Override // com.tencent.timi.game.api.strategy.impl.a
    public void i(long j3) {
        e("onPageOut:" + j3);
        if (this.f436093f == j3) {
            this.f436093f = 0L;
        }
    }
}
