package yl2;

import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    private static final wl2.a<c, Void> f450633i = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f450634a;

    /* renamed from: b, reason: collision with root package name */
    private int f450635b;

    /* renamed from: c, reason: collision with root package name */
    private int f450636c;

    /* renamed from: d, reason: collision with root package name */
    private int f450637d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f450638e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<Integer, b> f450639f;

    /* renamed from: g, reason: collision with root package name */
    private int f450640g;

    /* renamed from: h, reason: collision with root package name */
    b f450641h;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a extends wl2.a<c, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // wl2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public c a(Void r26) {
            return new c(null);
        }
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public static c e() {
        return f450633i.b(null);
    }

    private int f() {
        return FeedVideoEnv.externalFunc.getWnsConfig("QZVideo", "UrlAdapterMaxDegradeCount", 0);
    }

    private void k() {
        String wnsConfig = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "VideoDownloadSpeedThreshold", "1000,600,150");
        if (TextUtils.isEmpty(wnsConfig)) {
            return;
        }
        String[] split = wnsConfig.split(",");
        if (split.length >= 3) {
            try {
                this.f450634a = Integer.valueOf(split[0]).intValue();
                this.f450635b = Integer.valueOf(split[1]).intValue();
                this.f450636c = Integer.valueOf(split[2]).intValue();
            } catch (NumberFormatException e16) {
                PlayerUtils.log(6, "StreamStrategyManager", "initTcSpeedThreshold error " + e16);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n() {
        boolean z16;
        int i3 = this.f450637d;
        if (i3 == 3) {
            e().b(true);
            e().b(true);
        } else {
            if (i3 != 2) {
                z16 = false;
                if (z16) {
                    return;
                }
                this.f450637d = 1;
                PlayerUtils.log(4, "StreamStrategyManager", "[VideoRate]\u964d\u6863 --- to level:" + this.f450637d);
                return;
            }
            e().b(true);
        }
        z16 = true;
        if (z16) {
        }
    }

    private void o() {
        int i3 = this.f450637d;
        if (i3 == 1) {
            e().b(false);
            this.f450637d = 2;
            PlayerUtils.log(4, "StreamStrategyManager", "[VideoRate]\u5347\u6863 --- to level:" + this.f450637d);
            return;
        }
        if (i3 == 3) {
            e().b(true);
            this.f450637d = 2;
            PlayerUtils.log(4, "StreamStrategyManager", "[VideoRate]\u964d\u6863 --- to level:" + this.f450637d);
        }
    }

    private void p() {
        int i3 = this.f450637d;
        boolean z16 = true;
        if (i3 == 2) {
            e().b(false);
        } else if (i3 == 1) {
            e().b(false);
            e().b(false);
        } else {
            z16 = false;
        }
        if (z16) {
            this.f450637d = 3;
            PlayerUtils.log(4, "StreamStrategyManager", "[VideoRate]\u5347\u6863 --- to level:" + this.f450637d);
        }
    }

    public void b(boolean z16) {
        int networkType = FeedVideoEnv.getNetworkType();
        if (z16) {
            g(networkType).a();
        } else {
            g(networkType).b();
        }
    }

    public void c() {
        if (this.f450638e) {
            return;
        }
        int i3 = this.f450640g;
        int i16 = this.f450634a;
        int i17 = this.f450636c;
        if (i3 > i16 + i17) {
            p();
        } else if (i3 > i16) {
            if (this.f450637d == 1) {
                o();
            }
        } else {
            int i18 = this.f450635b;
            if (i3 > i17 + i18) {
                if (this.f450637d != 2) {
                    o();
                }
            } else if (i3 > i18) {
                if (this.f450637d == 3) {
                    o();
                }
            } else if (i3 < i18 && i3 > 0) {
                n();
            }
        }
        this.f450638e = true;
    }

    public b g(int i3) {
        b bVar = this.f450639f.get(Integer.valueOf(i3));
        if (bVar instanceof yl2.a) {
            ((yl2.a) bVar).i(i3);
        }
        if (bVar != null) {
            return bVar;
        }
        b d16 = d(i3);
        this.f450639f.put(Integer.valueOf(i3), d16);
        return d16;
    }

    public int h() {
        return FeedVideoEnv.externalFunc.getWnsConfig("QZVideo", "VideoDownloadSpeedSamplingNum", 5);
    }

    public int i() {
        return FeedVideoEnv.externalFunc.getWnsConfig("QZVideo", "UrlAdapterMaxBufferCount", 2);
    }

    public int j() {
        return FeedVideoEnv.externalFunc.getWnsConfig("QZVideo", "UrlAdapterMaxBufferVideos", 2);
    }

    public boolean l() {
        return FeedVideoEnv.externalFunc.getWnsConfig("QZVideo", "UrlAdapterEnable", 1) == 1;
    }

    c() {
        this.f450637d = 3;
        this.f450638e = false;
        this.f450639f = new HashMap<>();
        this.f450641h = new d();
        k();
    }

    public void m(int i3) {
        this.f450638e = false;
        this.f450640g = i3;
    }

    public void a(int i3, boolean z16) {
        if (z16) {
            g(i3).a();
        }
    }

    private b d(int i3) {
        b dVar;
        if (i3 == 1) {
            dVar = new d();
        } else if (i3 != 2 && i3 != 3 && i3 != 4) {
            dVar = this.f450641h;
        } else {
            dVar = new yl2.a(i3);
        }
        int f16 = f();
        if (f16 > 0) {
            dVar.f(f16);
        }
        return dVar;
    }
}
