package u52;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t52.PlayerVideoInfo;
import t52.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u001f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0011\u0012\b\u0010J\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\bl\u0010mJ\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J*\u0010\u0017\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\nH\u0016J\u0018\u0010#\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020$H\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010+\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010,\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J4\u00102\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00182\b\u00101\u001a\u0004\u0018\u00010'H\u0016J4\u00108\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u000106H\u0016J4\u0010>\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u00182\b\u0010=\u001a\u0004\u0018\u00010<H\u0016J\"\u0010?\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u00109\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0018H\u0016J\u0012\u0010@\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\n\u0010A\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010D\u001a\u00020\n2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0BH\u0016J\u0012\u0010F\u001a\u00020\n2\b\u0010E\u001a\u0004\u0018\u00010'H\u0016J\b\u0010G\u001a\u00020\nH\u0016R\u0016\u0010J\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010MR*\u0010V\u001a\u00020O2\u0006\u0010P\u001a\u00020O8\u0016@VX\u0096\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bH\u0010UR$\u0010[\u001a\u00020$2\u0006\u0010P\u001a\u00020$8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\\\u0010XR\u0014\u0010]\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010XR\u0014\u0010^\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010XR\u0014\u0010_\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b_\u0010XR\u0014\u0010a\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b`\u0010XR\u0014\u0010d\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bb\u0010cR\u0014\u0010f\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\be\u0010cR\u0014\u0010i\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bg\u0010hR\u0014\u0010k\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bj\u0010h\u00a8\u0006n"}, d2 = {"Lu52/a;", "Lo52/b;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCompletionListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCaptureImageListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnSeekCompleteListener;", "Lo52/a;", "listener", "", "c", "Lo52/d;", "videoView", "b", "Landroid/content/Context;", "context", "Lt52/f;", QCircleScheme.AttrDetail.VIDEO_INFO, "", ITVKPlayerEventListener.KEY_START_POSITION_MILSEC, "Lcom/tencent/superplayer/api/SuperPlayerOption;", "playerOption", "f", "", "type", QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, "start", "pause", "stop", "release", "pauseDownload", "resumeDownload", "positionMilsec", "mode", "seekTo", "", "isLoopback", "setLoopback", "", "getStreamDumpInfo", "Lcom/tencent/superplayer/api/ISuperPlayer;", "p0", "onVideoPrepared", "onCompletion", "tvkPlayer", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "extraInfo", "onError", "what", "arg1", "arg2", "", "extra", "onInfo", "id", "width", "height", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onCaptureImageSucceed", "onCaptureImageFailed", "onSeekComplete", "getVideoView", "", "data", "addExtReportData", "rowkey", "setReportContentId", "setPlayerActive", "d", "Lcom/tencent/superplayer/api/ISuperPlayer;", "videoPlayer", "e", "Lo52/a;", "Lo52/d;", "currentVideoView", "", "value", h.F, UserInfo.SEX_FEMALE, "getSpeedRatio", "()F", "(F)V", "speedRatio", "getOutputMute", "()Z", "setOutputMute", "(Z)V", "outputMute", "isPlaying", "isBuffering", "isPrepareing", "isPrepared", "a", "isPauseing", "getDurationMs", "()J", "durationMs", "getCurrentPositionMs", "currentPositionMs", "getVideoWidth", "()I", "videoWidth", "getVideoHeight", "videoHeight", "<init>", "(Lcom/tencent/superplayer/api/ISuperPlayer;)V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements o52.b, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnSeekCompleteListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ISuperPlayer videoPlayer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private o52.a listener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private o52.d currentVideoView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float speedRatio = 1.0f;

    public a(ISuperPlayer iSuperPlayer) {
        this.videoPlayer = iSuperPlayer;
    }

    @Override // o52.b
    public boolean a() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        return iSuperPlayer != null && iSuperPlayer.isPausing();
    }

    @Override // o52.b
    public void addExtReportData(Map<String, String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.addExtReportData(data);
        }
    }

    @Override // o52.b
    public void b(o52.d videoView) {
        this.currentVideoView = videoView;
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            View a16 = videoView != null ? videoView.a() : null;
            iSuperPlayer.updatePlayerVideoView(a16 instanceof ISPlayerVideoView ? (ISPlayerVideoView) a16 : null);
        }
    }

    @Override // o52.b
    public void c(o52.a listener) {
        this.listener = listener;
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnVideoPreparedListener(this);
        }
        ISuperPlayer iSuperPlayer2 = this.videoPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.setOnCompletionListener(this);
        }
        ISuperPlayer iSuperPlayer3 = this.videoPlayer;
        if (iSuperPlayer3 != null) {
            iSuperPlayer3.setOnErrorListener(this);
        }
        ISuperPlayer iSuperPlayer4 = this.videoPlayer;
        if (iSuperPlayer4 != null) {
            iSuperPlayer4.setOnInfoListener(this);
        }
        ISuperPlayer iSuperPlayer5 = this.videoPlayer;
        if (iSuperPlayer5 != null) {
            iSuperPlayer5.setOnCaptureImageListener(this);
        }
        ISuperPlayer iSuperPlayer6 = this.videoPlayer;
        if (iSuperPlayer6 != null) {
            iSuperPlayer6.setOnSeekCompleteListener(this);
        }
    }

    @Override // o52.b
    public void d(float f16) {
        this.speedRatio = f16;
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setPlaySpeedRatio(f16);
        }
    }

    @Override // o52.b
    public boolean e() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        Integer valueOf = iSuperPlayer != null ? Integer.valueOf(iSuperPlayer.getCurrentPlayerState()) : null;
        if (valueOf != null && valueOf.intValue() == 3) {
            return true;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            return true;
        }
        return valueOf != null && valueOf.intValue() == 2;
    }

    @Override // o52.b
    public void f(Context context, PlayerVideoInfo videoInfo, long startPositionMilsec, SuperPlayerOption playerOption) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        Intrinsics.checkNotNullParameter(playerOption, "playerOption");
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.openMediaPlayer(context != null ? context.getApplicationContext() : null, g.a(videoInfo), startPositionMilsec, playerOption);
        }
    }

    @Override // o52.b
    public long getCurrentPositionMs() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getCurrentPositionMs();
        }
        return 0L;
    }

    @Override // o52.b
    public long getDurationMs() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getDurationMs();
        }
        return 0L;
    }

    @Override // o52.b
    public boolean getOutputMute() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        return iSuperPlayer != null && iSuperPlayer.isOutputMute();
    }

    @Override // o52.b
    public String getStreamDumpInfo() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getStreamDumpInfo();
        }
        return null;
    }

    @Override // o52.b
    public int getVideoHeight() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // o52.b
    public o52.d getVideoView() {
        ISPlayerVideoView videoView;
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer == null || (videoView = iSuperPlayer.getVideoView()) == null) {
            return null;
        }
        return new d(videoView);
    }

    @Override // o52.b
    public int getVideoWidth() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // o52.b
    public boolean isBuffering() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        return iSuperPlayer != null && iSuperPlayer.isBuffering();
    }

    @Override // o52.b
    public boolean isPlaying() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        return iSuperPlayer != null && iSuperPlayer.isPlaying();
    }

    @Override // o52.b
    public boolean isPrepared() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        return iSuperPlayer != null && iSuperPlayer.getCurrentPlayerState() == 4;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageFailed(ISuperPlayer p06, int id5, int errorCode) {
        o52.a aVar = this.listener;
        if (aVar != null) {
            aVar.h(this, id5, errorCode);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageSucceed(ISuperPlayer p06, int id5, int width, int height, Bitmap bitmap) {
        o52.a aVar = this.listener;
        if (aVar != null) {
            aVar.b(this, id5, width, height, bitmap);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer p06) {
        o52.a aVar = this.listener;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer tvkPlayer, int module, int errorType, int errorCode, String extraInfo) {
        o52.a aVar = this.listener;
        return aVar != null && aVar.g(this, module, errorType, errorCode, extraInfo);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer p06) {
        o52.a aVar = this.listener;
        if (aVar != null) {
            aVar.f(this);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer p06) {
        o52.a aVar = this.listener;
        if (aVar != null) {
            aVar.c(this);
        }
    }

    @Override // o52.b
    public void pause() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
        }
    }

    @Override // o52.b
    public void pauseDownload() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.pauseDownload();
        }
    }

    @Override // o52.b
    public void release() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
        ISuperPlayer iSuperPlayer2 = this.videoPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.release();
        }
    }

    @Override // o52.b
    public void resumeDownload() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.resumeDownload();
        }
    }

    @Override // o52.b
    public void setLoopback(boolean isLoopback) {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(isLoopback);
        }
    }

    @Override // o52.b
    public void setOutputMute(boolean z16) {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer == null) {
            return;
        }
        iSuperPlayer.setOutputMute(z16);
    }

    @Override // o52.b
    public void setPlayerActive() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setPlayerActive();
        }
    }

    @Override // o52.b
    public void setReportContentId(String rowkey) {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setReportContentId(rowkey);
        }
    }

    @Override // o52.b
    public void start() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
    }

    @Override // o52.b
    public void stop() {
        ISuperPlayer iSuperPlayer;
        ISuperPlayer iSuperPlayer2 = this.videoPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.reset();
        }
        o52.d dVar = this.currentVideoView;
        if (dVar == null || (iSuperPlayer = this.videoPlayer) == null) {
            return;
        }
        KeyEvent.Callback a16 = dVar.a();
        iSuperPlayer.updatePlayerVideoView(a16 instanceof ISPlayerVideoView ? (ISPlayerVideoView) a16 : null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0007, code lost:
    
        if (r4 != 3) goto L10;
     */
    @Override // o52.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void seekTo(int positionMilsec, int mode) {
        int i3 = 1;
        if (mode != 1) {
            int i16 = mode != 2 ? 3 : 2;
            i3 = i16;
        }
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.seekTo(positionMilsec, i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000a, code lost:
    
        if (r3 != 3) goto L12;
     */
    @Override // o52.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setXYaxis(int type) {
        int i3 = 0;
        if (type != 0) {
            int i16 = 1;
            if (type != 1) {
                i16 = 2;
                if (type != 2) {
                    i16 = 3;
                }
            }
            i3 = i16;
        }
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setXYaxis(i3);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer p06, int what, long arg1, long arg2, Object extra) {
        int i3 = 105;
        if (what != 105) {
            i3 = 108;
            if (what != 108) {
                i3 = 112;
                if (what != 112) {
                    i3 = 113;
                    if (what != 113) {
                        i3 = what;
                    }
                }
            }
        }
        Object valueOf = i3 == 209 ? Long.valueOf(arg1) : extra;
        if (what == 207) {
            Intrinsics.checkNotNull(extra, "null cannot be cast to non-null type com.tencent.thumbplayer.api.common.TPDownloadProgressInfo");
            TPDownloadProgressInfo tPDownloadProgressInfo = (TPDownloadProgressInfo) extra;
            o52.a aVar = this.listener;
            if (aVar != null) {
                aVar.d(tPDownloadProgressInfo.getDownloadBytes(), tPDownloadProgressInfo.getFileTotalBytes(), tPDownloadProgressInfo.getExtraInfo());
            }
            return true;
        }
        o52.a aVar2 = this.listener;
        return aVar2 != null && aVar2.e(this, i3, valueOf);
    }
}
