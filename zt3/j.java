package zt3;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.qqlive.superplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKVideoInfo;
import wt3.b;
import zt3.h;

/* compiled from: P */
/* loaded from: classes22.dex */
public class j implements wt3.b {

    /* renamed from: a, reason: collision with root package name */
    private Context f453405a;

    /* renamed from: b, reason: collision with root package name */
    private b.a f453406b;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements xt3.c {
        a() {
        }

        @Override // xt3.c
        public void a(int i3, TVKVideoInfo tVKVideoInfo) {
            j.this.f453406b.a(i3, tVKVideoInfo);
        }

        @Override // xt3.c
        public void b(int i3, int i16, String str, int i17, String str2) {
            j.this.f453406b.b(i3, i16, str, i17, str2);
        }
    }

    public j(Context context) {
        this.f453405a = context;
    }

    @Override // wt3.b
    public void a(b.a aVar) {
        this.f453406b = aVar;
    }

    @Override // wt3.b
    public int b(@NonNull TVKUserInfo tVKUserInfo, @NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo, @NonNull String str, int i3, int i16) {
        return new i().h(new h.b(tVKPlayerVideoInfo.getVid()).M(tVKUserInfo.getUin()).E(0).z(i3).F(tVKPlayerVideoInfo.isNeedCharge() ? 1 : 0).y(tVKPlayerVideoInfo.getProxyExtraMap()).B(tVKPlayerVideoInfo.getExtraRequestParamsMap()).C(str).G(tVKUserInfo.getLoginCookie()).L(tt3.a.h(tVKPlayerVideoInfo.getPlatform())).I(tVKPlayerVideoInfo.getPlatform()).K(i16).N(tt3.a.f437461b).J(com.tencent.qqlive.superplayer.tools.utils.h.o()).w(tt3.a.d()).A(vt3.d.G.a().intValue()).H(com.tencent.qqlive.superplayer.tools.utils.h.k(this.f453405a)).O(tVKUserInfo.getWxOpenID()).D(tt3.a.e()).x(), new a());
    }
}
