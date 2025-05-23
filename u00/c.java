package u00;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.player.i;
import com.tencent.biz.pubaccount.weishi.player.wrapper.WSPlayerDownloadInfo;
import com.tencent.biz.pubaccount.weishi.player.wrapper.l;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c implements com.tencent.biz.pubaccount.weishi.player.wrapper.b, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnSeekCompleteListener {

    /* renamed from: d, reason: collision with root package name */
    private int f438003d;

    /* renamed from: e, reason: collision with root package name */
    private final ISuperPlayer f438004e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.wrapper.h f438005f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.wrapper.e f438006h;

    public c(ISuperPlayer iSuperPlayer) {
        this.f438004e = iSuperPlayer;
    }

    private int i(int i3) {
        int i16 = 112;
        if (i3 != 112) {
            i16 = 113;
            if (i3 != 113) {
                return i3;
            }
        }
        return i16;
    }

    private int j(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                i16 = 3;
                if (i3 != 3) {
                    return 0;
                }
            }
        }
        return i16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void a(com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar) {
        this.f438005f = hVar;
        if (this.f438004e == null || hVar == null) {
            return;
        }
        KeyEvent.Callback a16 = hVar.a();
        if (a16 instanceof ISPlayerVideoView) {
            this.f438004e.updatePlayerVideoView((ISPlayerVideoView) a16);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void c(Context context, long j3, int i3, com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar) {
        if (this.f438004e == null || aVar == null) {
            return;
        }
        if (aVar.f81193b == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_DEMUXER_TYPE, new int[]{1}));
            this.f438004e.setPlayerOptionalParamList(arrayList);
        }
        this.f438004e.openMediaPlayer(context, (SuperPlayerVideoInfo) aVar.c(), j3, h(aVar));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public int d() {
        int i3 = this.f438003d;
        if (i3 == 101) {
            return 1;
        }
        return i3 == 102 ? 2 : -1;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void e(int i3, int i16, int i17) {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.setBusinessDownloadStrategy(i3, i16, i17, i17);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void f(com.tencent.biz.pubaccount.weishi.player.wrapper.e eVar) {
        this.f438006h = eVar;
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnVideoPreparedListener(this);
            this.f438004e.setOnCompletionListener(this);
            this.f438004e.setOnErrorListener(this);
            this.f438004e.setOnInfoListener(this);
            this.f438004e.setOnCaptureImageListener(this);
            this.f438004e.setOnSeekCompleteListener(this);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public l g() {
        MediaInfo mediaInfo = this.f438004e.getMediaInfo();
        l lVar = new l();
        if (mediaInfo != null) {
            lVar.f(mediaInfo.getAudioCodec());
            lVar.g(mediaInfo.getAudioProfile());
            lVar.h(mediaInfo.getVideoCodec());
            lVar.j(mediaInfo.getVideoProfile());
            lVar.i(mediaInfo.getVideoFps());
        }
        return lVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public long getCurrentPosition() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getCurrentPositionMs();
        }
        return 0L;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public long getDuration() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getDurationMs();
        }
        return 0L;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public String getStreamDumpInfo() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getStreamDumpInfo();
        }
        return "";
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public int getVideoHeight() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public int getVideoWidth() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public boolean isPausing() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        return iSuperPlayer != null && iSuperPlayer.isPausing();
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public boolean isPlaying() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        return iSuperPlayer != null && iSuperPlayer.isPlaying();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageFailed(ISuperPlayer iSuperPlayer, int i3, int i16) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.e eVar = this.f438006h;
        if (eVar != null) {
            eVar.d(this, i3, i16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageSucceed(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, Bitmap bitmap) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.e eVar = this.f438006h;
        if (eVar != null) {
            eVar.b(this, i3, i16, i17, bitmap);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.e eVar = this.f438006h;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.e eVar = this.f438006h;
        if (eVar != null) {
            return eVar.f(this, i3, i16, i17, str);
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        x.j("WS_VIDEO_SuperPlayerImpl", "[SuperPlayerImpl.java][onInfo] what:" + i3 + ", arg1:" + j3 + ", arg2:" + j16 + ", extra:" + obj);
        if (i3 == 115) {
            this.f438003d = (int) j3;
        } else if (i3 == 201) {
            x.j("WS_VIDEO_SuperPlayerImpl", "[SuperPlayerImpl.java][onInfo] PLAYER_INFO_ALL_DOWNLOAD_FINISH!");
        } else if (i3 != 204) {
            if (i3 != 207) {
                if (i3 == 251) {
                    x.j("WS_VIDEO_SuperPlayerImpl", "[SuperPlayerImpl.java][onInfo] PLAYER_INFO_PCDN_DOWNLOAD_FAILED!");
                    if ((obj instanceof String) && this.f438006h != null) {
                        WSPlayerDownloadInfo a16 = g.a((String) obj);
                        x.j("WS_VIDEO_SuperPlayerImpl", "[SuperPlayerImpl.java][onInfo] pcdnErrorInfo:" + a16);
                        this.f438006h.i(this, a16);
                    }
                }
            } else if (obj instanceof TPDownloadProgressInfo) {
                TPDownloadProgressInfo tPDownloadProgressInfo = (TPDownloadProgressInfo) obj;
                com.tencent.biz.pubaccount.weishi.player.wrapper.e eVar = this.f438006h;
                if (eVar == null) {
                    return true;
                }
                eVar.e(this, g.c(tPDownloadProgressInfo));
                return true;
            }
        } else if (obj instanceof TPPlayerMsg.TPCDNURLInfo) {
            TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = (TPPlayerMsg.TPCDNURLInfo) obj;
            x.f("WS_VIDEO_SuperPlayerImpl", "[SuperPlayerImpl.java][onInfo] TPCDNURLInfo url:" + tPCDNURLInfo.url + ", uIp:" + tPCDNURLInfo.uIp + ", cdnIp:" + tPCDNURLInfo.cdnIp + ", errorStr:" + tPCDNURLInfo.errorStr);
        }
        com.tencent.biz.pubaccount.weishi.player.wrapper.e eVar2 = this.f438006h;
        if (eVar2 != null) {
            return eVar2.h(this, i(i3), obj);
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.e eVar = this.f438006h;
        if (eVar != null) {
            eVar.g(this);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.e eVar = this.f438006h;
        if (eVar != null) {
            eVar.c(this);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void pause() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void pauseDownload() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.pauseDownload();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void release() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
            this.f438004e.release();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void resumeDownload() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.resumeDownload();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void seekTo(int i3) {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.seekTo(i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void setLoopback(boolean z16) {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(z16);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void setOutputMute(boolean z16) {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(z16);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void setPlaySpeedRatio(float f16) {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.setPlaySpeedRatio(f16);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void setXYAxis(int i3) {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.setXYaxis(j(i3));
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void start() {
        ISuperPlayer iSuperPlayer = this.f438004e;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void stop() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar;
        if (this.f438004e == null || (hVar = this.f438005f) == null) {
            return;
        }
        KeyEvent.Callback a16 = hVar.a();
        if (a16 instanceof ISPlayerVideoView) {
            this.f438004e.reset();
            this.f438004e.updatePlayerVideoView((ISPlayerVideoView) a16);
        }
    }

    private SuperPlayerOption h(com.tencent.biz.pubaccount.weishi.player.wrapper.a aVar) {
        SuperPlayerOption obtain = SuperPlayerOption.obtain(112);
        obtain.enableCodecReuse = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().a();
        obtain.isPrePlay = aVar.f81197f;
        SuperPlayerDownOption superPlayerDownOption = obtain.superPlayerDownOption;
        superPlayerDownOption.enableBandwidthStats = true;
        superPlayerDownOption.bandwidthReportHost = i.F(aVar.f81192a);
        if (aVar.f81198g) {
            SuperPlayerDownOption superPlayerDownOption2 = obtain.superPlayerDownOption;
            boolean z16 = aVar.f81199h;
            superPlayerDownOption2.enableP2P = z16;
            superPlayerDownOption2.enablePcdn = z16;
            superPlayerDownOption2.pcdnChargeId = "pcdn_ad_qqws";
        } else {
            SuperPlayerDownOption superPlayerDownOption3 = obtain.superPlayerDownOption;
            s00.g gVar = s00.g.f433061a;
            superPlayerDownOption3.enableP2P = gVar.a();
            obtain.superPlayerDownOption.enablePcdn = gVar.c();
        }
        SuperPlayerDownOption superPlayerDownOption4 = obtain.superPlayerDownOption;
        s00.g gVar2 = s00.g.f433061a;
        superPlayerDownOption4.pcdnMinBuffTime = gVar2.f();
        obtain.superPlayerDownOption.pcdnProtectBuffTime = gVar2.g();
        return obtain;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.b
    public void b(com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar, ViewGroup viewGroup) {
        if (hVar != null) {
            KeyEvent.Callback a16 = hVar.a();
            if (a16 instanceof ISPlayerVideoView) {
                SPSeamlessHelper.get().attachVideoView(viewGroup, (ISPlayerVideoView) a16, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }
}
