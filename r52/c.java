package r52;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends a {

    /* renamed from: l, reason: collision with root package name */
    public int f430771l = 0;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<c> f430772m = new ArrayList<>();

    public boolean a(long j3) {
        long j16 = this.f430764k;
        return j3 - j16 > 0 && j3 - j16 < 7200;
    }

    public String toString() {
        return "VidUrl {\n vid: " + this.f430755b + "\n url: " + this.f430754a + "\n errorCode: " + this.f430763j + "\n width: " + this.f430761h + "\n height: " + this.f430762i + "\n isH265: " + this.f430756c + "\n fileBitRate: " + this.f430758e + "\n isHWCodec: " + this.f430757d + "\n videoReportInfo:" + this.f430759f + "\n hwBackupURL:" + this.f430760g + "}";
    }
}
