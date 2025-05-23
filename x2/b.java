package x2;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f447068a;

    /* renamed from: b, reason: collision with root package name */
    public int f447069b;

    /* renamed from: c, reason: collision with root package name */
    public int f447070c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f447071d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f447072e;

    public b(String str, int i3) {
        this.f447071d = TTL.MAX_VALUE;
        this.f447068a = str;
        this.f447069b = i3;
        if ("Long".equals(str)) {
            this.f447071d = Long.MAX_VALUE;
        }
    }
}
