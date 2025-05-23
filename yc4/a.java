package yc4;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.asset.TVKUrlAsset;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.bridge.TVKMediaPlayerFactory;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.MethodNotSupportedException;
import com.tencent.superplayer.api.SPDeinitManager;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.report.ISPReportProvider;
import com.tencent.superplayer.report.ISPReporter;
import com.tencent.superplayer.report.SPReportHelper;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnNetVideoInfoListener;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnPermissionTimeoutListener;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import zc4.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements ISuperPlayer {
    private zc4.c C;
    private Surface D;
    private String E;
    private long F;
    private String G;
    private String H;
    private ISuperPlayer.OnInfoListener R;

    /* renamed from: e, reason: collision with root package name */
    private int f450127e;

    /* renamed from: f, reason: collision with root package name */
    private ITVKMediaPlayer f450128f;

    /* renamed from: h, reason: collision with root package name */
    private TVKUserInfo f450129h;

    /* renamed from: i, reason: collision with root package name */
    private TVKPlayerVideoInfo f450130i;

    /* renamed from: m, reason: collision with root package name */
    private TVKNetVideoInfo f450131m = null;
    private int I = 0;
    private float J = 1.0f;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private AtomicInteger N = new AtomicInteger(0);
    private ISPReporter Q = new SPReportHelper();

    /* renamed from: d, reason: collision with root package name */
    private String f450126d = CommonUtil.f() + "_TVKPlayerAdapter.java";
    private String P = SystemClock.uptimeMillis() + "-" + hashCode();

    /* compiled from: P */
    /* renamed from: yc4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C11602a implements ITVKMediaPlayer.OnCaptureImageListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnCaptureImageListener f450132a;

        C11602a(ISuperPlayer.OnCaptureImageListener onCaptureImageListener) {
            this.f450132a = onCaptureImageListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
        public void onCaptureImageFailed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
            ISuperPlayer.OnCaptureImageListener onCaptureImageListener = this.f450132a;
            if (onCaptureImageListener != null) {
                onCaptureImageListener.onCaptureImageFailed(a.this, i3, i16);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
        public void onCaptureImageSucceed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, Bitmap bitmap) {
            ISuperPlayer.OnCaptureImageListener onCaptureImageListener = this.f450132a;
            if (onCaptureImageListener != null) {
                onCaptureImageListener.onCaptureImageSucceed(a.this, i3, i16, i17, bitmap);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements ITVKMediaPlayer.OnVideoFrameOutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnVideoFrameOutputListener f450134a;

        b(ISuperPlayer.OnVideoFrameOutputListener onVideoFrameOutputListener) {
            this.f450134a = onVideoFrameOutputListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoFrameOutListener
        public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
            if (this.f450134a != null) {
                TPVideoFrameBuffer tPVideoFrameBuffer = new TPVideoFrameBuffer();
                tPVideoFrameBuffer.setData(tVKVideoFrameBuffer.getData());
                tPVideoFrameBuffer.setLineSize(tVKVideoFrameBuffer.getLineSize());
                tPVideoFrameBuffer.setWidth(tVKVideoFrameBuffer.getWidth());
                tPVideoFrameBuffer.setHeight(tVKVideoFrameBuffer.getHeight());
                tPVideoFrameBuffer.setDisplayWidth(tVKVideoFrameBuffer.getDisplayWidth());
                tPVideoFrameBuffer.setDisplayHeight(tVKVideoFrameBuffer.getDisplayHeight());
                tPVideoFrameBuffer.setFormat(37);
                tPVideoFrameBuffer.setPtsMs(tVKVideoFrameBuffer.getPtsMs());
                this.f450134a.onVideoFrameOutput(tPVideoFrameBuffer);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements ITVKMediaPlayer.OnAudioFrameOutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnAudioFrameOutputListener f450136a;

        c(ISuperPlayer.OnAudioFrameOutputListener onAudioFrameOutputListener) {
            this.f450136a = onAudioFrameOutputListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAudioFrameOutListener
        public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
            if (this.f450136a != null) {
                TPAudioFrameBuffer tPAudioFrameBuffer = new TPAudioFrameBuffer();
                tPAudioFrameBuffer.setData(tVKAudioFrameBuffer.getData());
                tPAudioFrameBuffer.setDataSize(tVKAudioFrameBuffer.getDataSize());
                tPAudioFrameBuffer.setSampleRate(tVKAudioFrameBuffer.getSampleRate());
                tPAudioFrameBuffer.setChannelLayout(tVKAudioFrameBuffer.getChannelLayout());
                this.f450136a.onAudioFrameOutput(tPAudioFrameBuffer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements ITVKMediaPlayer.OnGetUserInfoListener {
        d() {
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnGetUserInfoListener
        public TVKUserInfo onGetUserInfo(ITVKMediaPlayer iTVKMediaPlayer) {
            return a.this.f450129h;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class e implements ITVKMediaPlayer.OnNetVideoInfoListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ITVKOnNetVideoInfoListener f450139a;

        e(ITVKOnNetVideoInfoListener iTVKOnNetVideoInfoListener) {
            this.f450139a = iTVKOnNetVideoInfoListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnNetVideoInfoListener
        public void onNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
            a.this.f450131m = tVKNetVideoInfo;
            ITVKOnNetVideoInfoListener iTVKOnNetVideoInfoListener = this.f450139a;
            if (iTVKOnNetVideoInfoListener != null) {
                iTVKOnNetVideoInfoListener.onNetVideoInfo(a.this, tVKNetVideoInfo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class f implements ITVKMediaPlayer.OnPermissionTimeoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ITVKOnPermissionTimeoutListener f450141a;

        f(ITVKOnPermissionTimeoutListener iTVKOnPermissionTimeoutListener) {
            this.f450141a = iTVKOnPermissionTimeoutListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPermissionTimeoutListener
        public void onPermissionTimeout(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKOnPermissionTimeoutListener iTVKOnPermissionTimeoutListener = this.f450141a;
            if (iTVKOnPermissionTimeoutListener != null) {
                iTVKOnPermissionTimeoutListener.onPermissionTimeout(a.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class g implements ITVKMediaPlayer.OnVideoPreparedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnVideoPreparedListener f450143a;

        g(ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener) {
            this.f450143a = onVideoPreparedListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer) {
            LogUtil.i(a.this.f450126d, "onVideoPrepared");
            a.this.N.set(4);
            a.this.Q.onPrepared();
            if (a.this.M) {
                a.this.M = false;
                a.this.start();
            } else {
                ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener = this.f450143a;
                if (onVideoPreparedListener != null) {
                    onVideoPreparedListener.onVideoPrepared(a.this);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class h implements ITVKMediaPlayer.OnCompletionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnCompletionListener f450145a;

        h(ISuperPlayer.OnCompletionListener onCompletionListener) {
            this.f450145a = onCompletionListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCompletionListener
        public void onCompletion(ITVKMediaPlayer iTVKMediaPlayer) {
            a.this.N.set(7);
            ISuperPlayer.OnCompletionListener onCompletionListener = this.f450145a;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(a.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class i implements ITVKMediaPlayer.OnSeekCompleteListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnSeekCompleteListener f450147a;

        i(ISuperPlayer.OnSeekCompleteListener onSeekCompleteListener) {
            this.f450147a = onSeekCompleteListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(ITVKMediaPlayer iTVKMediaPlayer) {
            a.this.K = false;
            ISuperPlayer.OnSeekCompleteListener onSeekCompleteListener = this.f450147a;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete(a.this);
            }
            a.this.Q.onSeekComplete();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class j implements ITVKMediaPlayer.OnErrorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnErrorListener f450149a;

        j(ISuperPlayer.OnErrorListener onErrorListener) {
            this.f450149a = onErrorListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnErrorListener
        public boolean onError(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError) {
            boolean z16;
            a.this.N.set(9);
            ISuperPlayer.OnErrorListener onErrorListener = this.f450149a;
            if (onErrorListener != null) {
                z16 = onErrorListener.onError(a.this, 3, tVKError.getErrorModule(), tVKError.getMainErrorCode(), tVKError.getFullErrorCode());
            } else {
                z16 = false;
            }
            a.this.Q.onError("3:" + tVKError.getMainErrorCode(), "3:" + tVKError.getMainErrorCode() + ":" + tVKError.getErrorModule() + ":" + tVKError.getFullErrorCode());
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class k implements ITVKMediaPlayer.OnInfoListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnInfoListener f450151a;

        k(ISuperPlayer.OnInfoListener onInfoListener) {
            this.f450151a = onInfoListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnInfoListener
        public boolean onInfo(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj) {
            if (i3 == 21) {
                a.this.L = true;
                if (!a.this.K) {
                    a.this.Q.onVideoBufferStart();
                }
            } else if (i3 == 22) {
                a.this.L = false;
                if (!a.this.K) {
                    a.this.Q.onVideoBufferEnd();
                }
            } else if (i3 != 31) {
                if (i3 == 62) {
                    a.this.Q.onFirstVideoFrameRendered();
                }
            } else if (obj instanceof Integer) {
                a.this.Q.onPlayerTypeChanged(((Integer) obj).intValue());
            }
            if (this.f450151a != null) {
                a.C11673a a16 = zc4.a.a(i3, obj);
                this.f450151a.onInfo(a.this, a16.f452306a, a16.f452307b, a16.f452308c, a16.f452309d);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class l implements ITVKMediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnVideoSizeChangedListener f450153a;

        l(ISuperPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.f450153a = onVideoSizeChangedListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
            ISuperPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.f450153a;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(a.this, i3, i16);
            }
        }
    }

    public a(Context context, int i3, ISPlayerVideoView iSPlayerVideoView) {
        this.f450127e = i3;
        LogUtil.i(this.f450126d, "init TVKPlayerAdapter");
        if (iSPlayerVideoView instanceof zc4.c) {
            this.C = (zc4.c) iSPlayerVideoView;
        }
        this.f450128f = TVKMediaPlayerFactory.getProxyFactoryInstance().createMediaPlayer(context, l());
        n();
        SuperPlayerSDKMgr.getPlayerPool().put(this);
    }

    private ITVKVideoViewBase l() {
        zc4.c cVar = this.C;
        if (cVar != null) {
            return (ITVKVideoViewBase) cVar.getRenderView();
        }
        return null;
    }

    private void n() {
        this.f450128f.setOnGetUserInfoListener(new d());
        this.Q.init(this, this.f450127e);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addExtReportData(String str, String str2) {
        throw new MethodNotSupportedException("addExtReportData is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addSubtitleSource(String str, String str2) {
        LogUtil.i(this.f450126d, "addSubtitleSource, url:" + str + ", name:" + str2);
        this.f450128f.addTrack(3, str2, str);
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public void bindVideoPlayerInfo(Object obj) {
        ITVKMediaPlayer iTVKMediaPlayer = this.f450128f;
        if (iTVKMediaPlayer != null) {
            iTVKMediaPlayer.bindVideoPlayerInfo(obj);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int captureImageInTime(long j3, int i3, int i16) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        LogUtil.i(this.f450126d, "captureImageInTime, positionMs:" + j3 + ", width:" + i3 + ", height:" + i16);
        return this.f450128f.captureImageInTime(i3, i16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void deselectTrack(int i3, long j3) {
        LogUtil.i(this.f450126d, "deselectTrack, trackIndex:" + i3 + ", opaque:" + j3);
        this.f450128f.deselectTrack(i3);
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public TVKNetVideoInfo getCurTVKNetVideoInfo() {
        return this.f450131m;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getCurrentPlayerState() {
        SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.P);
        if (state != null && state.needRecover) {
            return state.state;
        }
        return this.N.get();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getCurrentPositionMs() {
        return this.f450128f.getCurrentPosition();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getDurationMs() {
        return this.f450128f.getDuration();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getFileSizeBytes() {
        throw new MethodNotSupportedException("getFileSizeBytes is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public float getMaxVolumeGain() {
        return AudioTrack.getMaxVolume();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public MediaInfo getMediaInfo() {
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getPlayableDurationMs() {
        return ((this.f450128f.getBufferPercent() / 100) * getDurationMs()) - getCurrentPositionMs();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public TPProgramInfo[] getProgramInfo() {
        return this.f450128f.getProgramInfo();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getProperty(String str) {
        return "-1";
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public ISPReportProvider getReportProvider() {
        return this.Q;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getSceneId() {
        return this.f450127e;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getStreamDumpInfo() {
        return this.f450128f.getStreamDumpInfo();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public SuperPlayerVideoInfo getSuperVideoInfo() {
        throw new MethodNotSupportedException("getSuperVideoInfo is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getToken() {
        return this.P;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public TPTrackInfo[] getTrackInfo() {
        LogUtil.i(this.f450126d, "getTrackInfo");
        TVKTrackInfo[] trackInfo = this.f450128f.getTrackInfo();
        TPTrackInfo[] tPTrackInfoArr = new TPTrackInfo[trackInfo.length];
        for (int i3 = 0; i3 < trackInfo.length; i3++) {
            tPTrackInfoArr[i3] = zc4.b.a(trackInfo[i3]);
        }
        return tPTrackInfoArr;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoHeight() {
        return this.f450128f.getVideoHeight();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoRotation() {
        return this.f450128f.getVideoRotation();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public ISPlayerVideoView getVideoView() {
        return this.C;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoWidth() {
        return this.f450128f.getVideoWidth();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isBuffering() {
        LogUtil.i(this.f450126d, "isBuffering:" + this.L);
        return this.L;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isLoopBack() {
        return this.f450128f.isLoopBack();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isOutputMute() {
        return this.f450128f.getOutputMute();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isPausing() {
        SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.P);
        if (state != null && state.needRecover) {
            LogUtil.i(this.f450126d, "isPausing:" + state.state);
            if (state.state == 6) {
                return true;
            }
            return false;
        }
        boolean isPaused = this.f450128f.isPaused();
        LogUtil.i(this.f450126d, "isPausing:" + isPaused);
        return isPaused;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isPlaying() {
        SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.P);
        if (state != null && state.needRecover) {
            if (state.state != 5) {
                return false;
            }
            return true;
        }
        ITVKMediaPlayer iTVKMediaPlayer = this.f450128f;
        if (iTVKMediaPlayer == null) {
            return false;
        }
        return iTVKMediaPlayer.isPlaying();
    }

    public SPDeinitManager.DeinitPlayerInfo k() {
        SPDeinitManager.DeinitPlayerInfo deinitPlayerInfo = new SPDeinitManager.DeinitPlayerInfo();
        deinitPlayerInfo.token = getToken();
        deinitPlayerInfo.playerTag = this.f450126d;
        deinitPlayerInfo.state = getCurrentPlayerState();
        deinitPlayerInfo.position = getCurrentPositionMs();
        deinitPlayerInfo.outputMuted = isOutputMute();
        deinitPlayerInfo.loopback = isLoopBack();
        deinitPlayerInfo.videoView = new WeakReference<>(getVideoView());
        deinitPlayerInfo.serviceType = SuperPlayerSDKMgr.getPlatform();
        deinitPlayerInfo.xyAxis = this.I;
        deinitPlayerInfo.speedRatio = this.J;
        deinitPlayerInfo.surface = new WeakReference<>(this.D);
        return deinitPlayerInfo;
    }

    public Surface m() {
        return this.D;
    }

    public void o(int i3, int i16, int i17, Object obj) {
        ISuperPlayer.OnInfoListener onInfoListener = this.R;
        if (onInfoListener != null) {
            onInfoListener.onInfo(this, i3, i16, i17, obj);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void onPrePlayViewShow() {
        this.Q.onPrePlayViewShow();
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException {
        this.f450128f.onRealTimeInfoChange(i3, obj);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3) {
        throw new MethodNotSupportedException("openMediaPlayer with superVideoInfo is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void openTVKPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, long j3, long j16) {
        LogUtil.i(this.f450126d, "openTVKPlayer, definition:" + str + ",startPositionMilsec:" + j3 + ", skipEndMilsec:" + j16);
        this.f450129h = tVKUserInfo;
        this.f450130i = tVKPlayerVideoInfo;
        this.E = str;
        this.F = j16;
        this.N.set(3);
        SuperPlayerSDKMgr.getDeinitManager().setPlayerActive(this);
        tVKPlayerVideoInfo.setDefinition(str);
        tVKPlayerVideoInfo.setSkipStartPositionMs(j3);
        tVKPlayerVideoInfo.setSkipStartPositionMs(j16);
        this.f450128f.openMediaPlayer(context, tVKUserInfo, tVKPlayerVideoInfo);
        this.Q.onOpenTVKPlayer(tVKUserInfo, tVKPlayerVideoInfo, str, j3);
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void openTVKPlayerByUrl(Context context, String str, String str2, long j3, long j16) {
        LogUtil.i(this.f450126d, "openTVKPlayerByUrl\uff0curl:" + str + ", fileId:" + str2 + ",startPositionMilsec:" + j3 + ", skipEndMilsec:" + j16);
        this.G = str;
        this.H = str2;
        this.F = j16;
        this.N.set(3);
        SuperPlayerSDKMgr.getDeinitManager().setPlayerActive(this);
        TVKUrlAsset createUrlAsset = TVKAssetFactory.createUrlAsset(str);
        createUrlAsset.setFileId(str2);
        TVKPlayerVideoInfo tVKPlayerVideoInfo = new TVKPlayerVideoInfo(createUrlAsset);
        tVKPlayerVideoInfo.setSkipStartPositionMs(j3);
        tVKPlayerVideoInfo.setSkipEndPositionMs(j16);
        if (this.f450129h == null) {
            this.f450129h = new TVKUserInfo();
        }
        this.f450128f.openMediaPlayer(context, this.f450129h, tVKPlayerVideoInfo);
        this.Q.onOpenTVKPlayerByUrl(str, j3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void pause() {
        LogUtil.i(this.f450126d, "pause");
        this.N.set(6);
        this.f450128f.pause();
        this.M = false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void pauseDownload() {
        LogUtil.i(this.f450126d, "pauseDownload");
        this.f450128f.pauseDownload();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void release() {
        LogUtil.i(this.f450126d, "release");
        this.N.set(10);
        SuperPlayerSDKMgr.getPlayerPool().remove(this);
        this.f450128f.release();
        this.Q.onRelease();
        this.R = null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void reset() {
        LogUtil.i(this.f450126d, "reset");
        this.N.set(0);
        this.f450128f.stop();
        this.Q.reset();
        this.J = 1.0f;
        this.I = 0;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void resumeDownload() {
        LogUtil.i(this.f450126d, "resumeDownload");
        this.f450128f.resumeDownload();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void seekTo(int i3) {
        LogUtil.i(this.f450126d, "seekTo, positionMiles:" + i3);
        this.K = true;
        this.f450128f.seekTo(i3);
        this.Q.onSeek(getCurrentPositionMs(), (long) i3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void selectProgram(int i3, long j3) {
        this.f450128f.selectProgram(i3, j3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void selectTrack(int i3, long j3) {
        LogUtil.i(this.f450126d, "selectTrack, trackIndex:" + i3 + ", opaque:" + j3);
        this.f450128f.selectTrack(i3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setLoopback(boolean z16) {
        this.f450128f.setLoopback(z16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener onAudioFrameOutputListener) {
        this.f450128f.setOnAudioFrameOutListener(new c(onAudioFrameOutputListener));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener onCaptureImageListener) {
        this.f450128f.setOnCaptureImageListener(new C11602a(onCaptureImageListener));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnCompletionListener(ISuperPlayer.OnCompletionListener onCompletionListener) {
        this.f450128f.setOnCompletionListener(new h(onCompletionListener));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener onDefinitionInfoListener) {
        throw new MethodNotSupportedException("setOnDefinitionInfoListener is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnErrorListener(ISuperPlayer.OnErrorListener onErrorListener) {
        this.f450128f.setOnErrorListener(new j(onErrorListener));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnInfoListener(ISuperPlayer.OnInfoListener onInfoListener) {
        this.R = onInfoListener;
        this.f450128f.setOnInfoListener(new k(onInfoListener));
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void setOnPermissionTimeoutListener(ITVKOnPermissionTimeoutListener iTVKOnPermissionTimeoutListener) {
        this.f450128f.setOnPermissionTimeoutListener(new f(iTVKOnPermissionTimeoutListener));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.f450128f.setOnSeekCompleteListener(new i(onSeekCompleteListener));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener onSubtitleDataListener) {
        throw new MethodNotSupportedException("setOnSubtitleDataListener is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void setOnTVKNetVideoInfoListener(ITVKOnNetVideoInfoListener iTVKOnNetVideoInfoListener) {
        this.f450128f.setOnNetVideoInfoListener(new e(iTVKOnNetVideoInfoListener));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener onTVideoNetInfoListener) {
        throw new MethodNotSupportedException("setOnTVideoNetInfoUpdateListener is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoFrameOutputListener(ISuperPlayer.OnVideoFrameOutputListener onVideoFrameOutputListener) {
        this.f450128f.setOnVideoFrameOutListener(new b(onVideoFrameOutputListener));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        this.f450128f.setOnVideoPreparedListener(new g(onVideoPreparedListener));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f450128f.setOnVideoSizeChangedListener(new l(onVideoSizeChangedListener));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOutputMute(boolean z16) {
        this.f450128f.setOutputMute(z16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlaySpeedRatio(float f16) {
        this.J = f16;
        this.f450128f.setPlaySpeedRatio(f16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlayerOptionalParamList(List<TPOptionalParam> list) {
        throw new MethodNotSupportedException("setPlayerOptionalParamList is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setReportContentId(String str) {
        throw new MethodNotSupportedException("setReportContentId is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setSurface(Surface surface) {
        this.D = surface;
        this.f450128f.setSurface(surface);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setVolumeGain(float f16) {
        this.f450128f.setAudioGainRatio(f16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setXYaxis(int i3) {
        this.I = i3;
        this.f450128f.setXYaxis(i3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void start() {
        LogUtil.i(this.f450126d, "start");
        SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.P);
        if (this.N.get() == 0 && state != null && state.needRecover) {
            LogUtil.i(this.f450126d, "start fail, had been stop by deinit, so go to open first");
            this.M = true;
            if (this.f450130i != null) {
                openTVKPlayer(SuperPlayerSDKMgr.getContext(), this.f450129h, this.f450130i, this.E, state.position, this.F);
                return;
            } else {
                openTVKPlayerByUrl(SuperPlayerSDKMgr.getContext(), this.G, this.H, state.position, this.F);
                return;
            }
        }
        this.N.set(5);
        this.f450128f.start();
        this.Q.onStart();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void stop() {
        LogUtil.i(this.f450126d, "stop");
        this.N.set(8);
        this.f450128f.stop();
        this.Q.onStop();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void switchDefinition(String str, int i3) {
        LogUtil.i(this.f450126d, "switchDefinition, definition:" + str);
        this.f450128f.switchDefinition(str);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void switchDefinitionForUrl(String str, int i3) {
        throw new MethodNotSupportedException("switchDefinitionForUrl (String, int) is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void updatePlayerSceneId(int i3) {
        throw new MethodNotSupportedException("updatePlayerSceneId is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void updatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView) {
        LogUtil.i(this.f450126d, "updatePlayerVideoView");
        if (iSPlayerVideoView instanceof zc4.c) {
            this.C = (zc4.c) iSPlayerVideoView;
            this.f450128f.updatePlayerVideoView(l());
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addExtReportData(Map<String, String> map) {
        throw new MethodNotSupportedException("addExtReportData is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption) {
        throw new MethodNotSupportedException("openMediaPlayer with superVideoInfo is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setLoopback(boolean z16, long j3, long j16) {
        this.f450128f.setLoopback(z16, j3, j16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int captureImageInTime(long j3, int i3, int i16, int i17, int i18, int i19) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        LogUtil.i(this.f450126d, "captureImageInTime, width:" + i3 + ", height:" + i16);
        return this.f450128f.captureImageInTime(i3, i16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void seekTo(int i3, int i16) {
        this.K = true;
        this.f450128f.seekToAccuratePos(i3);
        this.Q.onSeek(getCurrentPositionMs(), i3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlayerActive() {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18) {
    }
}
