package u00;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.weishi.player.i;
import com.tencent.biz.pubaccount.weishi.player.wrapper.WSPlayerDownloadInfo;
import com.tencent.biz.pubaccount.weishi.player.wrapper.f;
import com.tencent.biz.pubaccount.weishi.player.wrapper.j;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import t00.WSPlayerPreloaderReportData;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e implements ISPlayerPreDownloader.Listener, com.tencent.biz.pubaccount.weishi.player.wrapper.f {

    /* renamed from: a, reason: collision with root package name */
    private f.a f438007a;

    /* renamed from: b, reason: collision with root package name */
    private final ISPlayerPreDownloader f438008b;

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray<com.tencent.biz.pubaccount.weishi.player.wrapper.a> f438009c = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private int f438010d = -1;

    public e(ISPlayerPreDownloader iSPlayerPreDownloader) {
        this.f438008b = iSPlayerPreDownloader;
        if (iSPlayerPreDownloader != null) {
            iSPlayerPreDownloader.setOnPreDownloadListener(this);
        }
    }

    private WSPlayerPreloaderReportData e(com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar) {
        WSPlayerPreloaderReportData wSPlayerPreloaderReportData = new WSPlayerPreloaderReportData();
        String h16 = h(aVar);
        long g16 = g(aVar);
        wSPlayerPreloaderReportData.h(h16);
        wSPlayerPreloaderReportData.e(f(aVar));
        wSPlayerPreloaderReportData.f(g16);
        wSPlayerPreloaderReportData.g(j.f81226a.b(i.q(h16, g16)));
        return wSPlayerPreloaderReportData;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f
    public boolean a(com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar) {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f
    public void b(com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar) {
        ISPlayerPreDownloader iSPlayerPreDownloader = this.f438008b;
        if (iSPlayerPreDownloader == null || aVar == null) {
            return;
        }
        SuperPlayerDownOption obtain = SuperPlayerDownOption.obtain();
        if (aVar.f81198g) {
            boolean z16 = aVar.f81199h;
            obtain.enablePcdn = z16;
            obtain.enableP2P = z16;
            obtain.pcdnChargeId = "pcdn_ad_qqws";
        } else {
            s00.g gVar = s00.g.f433061a;
            obtain.enablePcdn = gVar.d();
            obtain.enableP2P = gVar.b();
        }
        s00.g gVar2 = s00.g.f433061a;
        obtain.pcdnMinBuffTime = gVar2.n();
        obtain.pcdnProtectBuffTime = gVar2.o();
        int startPreDownload = iSPlayerPreDownloader.startPreDownload((SuperPlayerVideoInfo) aVar.d(), aVar.f81195d, gVar2.m(), obtain);
        this.f438010d = startPreDownload;
        this.f438009c.put(startPreDownload, aVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f
    public void c() {
        ISPlayerPreDownloader iSPlayerPreDownloader = this.f438008b;
        if (iSPlayerPreDownloader == null) {
            return;
        }
        iSPlayerPreDownloader.stopAllPreDownload();
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f
    public void d(f.a aVar) {
        this.f438007a = aVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f
    public void destroy() {
        ISPlayerPreDownloader iSPlayerPreDownloader = this.f438008b;
        if (iSPlayerPreDownloader == null) {
            return;
        }
        iSPlayerPreDownloader.destory();
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
    public void onInfo(int i3, long j3, long j16, Object obj) {
        x.j("SuperPlayerPreDownloader", "[onInfo] what:" + i3 + ", arg1:" + j3 + ", arg2:" + j16 + ", downloadingTaskId:" + this.f438010d + ", extInfo:" + obj);
        if (i3 == 251 && (obj instanceof String)) {
            com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar = this.f438009c.get(this.f438010d);
            String h16 = h(aVar);
            String q16 = i.q(h16, g(aVar));
            WSPlayerDownloadInfo a16 = g.a((String) obj);
            x.j("SuperPlayerPreDownloader", "[onInfo][PCDN_FAILED] taskId:" + this.f438010d + ", videoUrl:" + h16 + ", videoFileId:" + q16 + ", pcdnErrorInfo:" + a16);
            j jVar = j.f81226a;
            jVar.d(jVar.a(q16), a16);
        }
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
    public void onPrepareDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar = this.f438009c.get(i3);
        String h16 = h(aVar);
        String q16 = i.q(h16, g(aVar));
        x.j("SuperPlayerPreDownloader", "[onPrepareDownloadProgressUpdate] taskId:" + i3 + ", videoUrl:" + h16 + ", videoFileId:" + q16 + ", playableDurationMS:" + i16 + ", downloadSpeedKBs:" + i17 + ", currentDownloadSizeByte:" + j3 + ", totalFileSizeByte:" + j16 + ", extraInfo:" + str);
        j jVar = j.f81226a;
        jVar.c(jVar.a(q16), g.b(i17, j16, str));
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
    public void onPrepareError(int i3, int i16, int i17, String str) {
        x.b("SuperPlayerPreDownloader", "[SuperPlayerPreDownloader.java][onPrepareError] taskId:" + i3);
        f.a aVar = this.f438007a;
        if (aVar == null) {
            return;
        }
        aVar.b("", 0, "");
        t00.g.d(e(this.f438009c.get(i3)));
        this.f438010d = -1;
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
    public void onPrepareSuccess(int i3) {
        String str;
        x.b("SuperPlayerPreDownloader", "[SuperPlayerPreDownloader.java][onPrepareSuccess] taskId:" + i3);
        f.a aVar = this.f438007a;
        if (aVar == null) {
            return;
        }
        this.f438010d = -1;
        com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar2 = this.f438009c.get(i3);
        if (aVar2 == null) {
            str = "";
        } else {
            str = aVar2.f81192a;
        }
        aVar.a(str, "");
        t00.g.d(e(aVar2));
    }

    private long f(com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar) {
        if (aVar != null) {
            return aVar.f81195d;
        }
        return 0L;
    }

    private long g(com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar) {
        if (aVar != null) {
            return aVar.f81196e;
        }
        return 0L;
    }

    private String h(com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar) {
        if (aVar != null) {
            return aVar.f81192a;
        }
        return "";
    }
}
