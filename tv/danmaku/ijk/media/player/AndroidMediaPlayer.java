package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.AndroidTrackInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

/* loaded from: classes30.dex */
public class AndroidMediaPlayer extends AbstractMediaPlayer {
    private static MediaInfo sMediaInfo;
    private String mDataSource;
    private final Object mInitLock;
    private final AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
    private final MediaPlayer mInternalMediaPlayer;
    private volatile boolean mIsReleased;
    private MediaDataSource mMediaDataSource;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes30.dex */
    public static class AndroidMediaPlayerListenerHolder implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnTimedTextListener {
        public final WeakReference<AndroidMediaPlayer> mWeakMediaPlayer;

        public AndroidMediaPlayerListenerHolder(AndroidMediaPlayer androidMediaPlayer) {
            this.mWeakMediaPlayer = new WeakReference<>(androidMediaPlayer);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
            AndroidMediaPlayer androidMediaPlayer = this.mWeakMediaPlayer.get();
            if (androidMediaPlayer != null && !androidMediaPlayer.mIsReleased) {
                androidMediaPlayer.notifyOnBufferingUpdate(i3);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            AndroidMediaPlayer androidMediaPlayer = this.mWeakMediaPlayer.get();
            if (androidMediaPlayer != null && !androidMediaPlayer.mIsReleased) {
                androidMediaPlayer.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            AndroidMediaPlayer androidMediaPlayer = this.mWeakMediaPlayer.get();
            if (androidMediaPlayer != null && !androidMediaPlayer.mIsReleased) {
                return androidMediaPlayer.notifyOnError(i3, i16);
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
            AndroidMediaPlayer androidMediaPlayer = this.mWeakMediaPlayer.get();
            if (androidMediaPlayer != null && !androidMediaPlayer.mIsReleased) {
                return androidMediaPlayer.notifyOnInfo(i3, i16);
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            AndroidMediaPlayer androidMediaPlayer = this.mWeakMediaPlayer.get();
            if (androidMediaPlayer != null && !androidMediaPlayer.mIsReleased) {
                androidMediaPlayer.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            AndroidMediaPlayer androidMediaPlayer = this.mWeakMediaPlayer.get();
            if (androidMediaPlayer != null && !androidMediaPlayer.mIsReleased) {
                androidMediaPlayer.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            IjkTimedText ijkTimedText;
            AndroidMediaPlayer androidMediaPlayer = this.mWeakMediaPlayer.get();
            if (androidMediaPlayer != null && !androidMediaPlayer.mIsReleased) {
                if (timedText != null) {
                    ijkTimedText = new IjkTimedText(timedText.getBounds(), timedText.getText());
                } else {
                    ijkTimedText = null;
                }
                androidMediaPlayer.notifyOnTimedText(ijkTimedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
            AndroidMediaPlayer androidMediaPlayer = this.mWeakMediaPlayer.get();
            if (androidMediaPlayer != null && !androidMediaPlayer.mIsReleased) {
                androidMediaPlayer.notifyOnVideoSizeChanged(i3, i16, 1, 1);
            }
        }
    }

    @TargetApi(23)
    /* loaded from: classes30.dex */
    private static class MediaDataSourceProxy extends MediaDataSource {
        private final IMediaDataSource mMediaDataSource;

        public MediaDataSourceProxy(IMediaDataSource iMediaDataSource) {
            this.mMediaDataSource = iMediaDataSource;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mMediaDataSource.close();
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            return this.mMediaDataSource.getSize();
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
            return this.mMediaDataSource.readAt(j3, bArr, i3, i16);
        }
    }

    public AndroidMediaPlayer() {
        ReportMediaPlayer reportMediaPlayer;
        Object obj = new Object();
        this.mInitLock = obj;
        synchronized (obj) {
            reportMediaPlayer = new ReportMediaPlayer();
            this.mInternalMediaPlayer = reportMediaPlayer;
        }
        reportMediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new AndroidMediaPlayerListenerHolder(this);
        attachInternalListeners();
    }

    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnTimedTextListener(this.mInternalListenerAdapter);
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource = this.mMediaDataSource;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            this.mMediaDataSource = null;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        try {
            return this.mInternalMediaPlayer.getCurrentPosition();
        } catch (IllegalStateException e16) {
            DebugLog.printStackTrace(e16);
            return 0L;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return this.mDataSource;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        try {
            return this.mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException e16) {
            DebugLog.printStackTrace(e16);
            return 0L;
        }
    }

    public MediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        if (sMediaInfo == null) {
            MediaInfo mediaInfo = new MediaInfo();
            mediaInfo.mVideoDecoder = "android";
            mediaInfo.mVideoDecoderImpl = "HW";
            mediaInfo.mAudioDecoder = "android";
            mediaInfo.mAudioDecoderImpl = "HW";
            sMediaInfo = mediaInfo;
        }
        return sMediaInfo;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        try {
            return this.mInternalMediaPlayer.isPlaying();
        } catch (IllegalStateException e16) {
            DebugLog.printStackTrace(e16);
            return false;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        this.mInternalMediaPlayer.pause();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.mInternalMediaPlayer.prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.mIsReleased = true;
        this.mInternalMediaPlayer.release();
        releaseMediaDataSource();
        resetListeners();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        try {
            this.mInternalMediaPlayer.reset();
        } catch (IllegalStateException e16) {
            DebugLog.printStackTrace(e16);
        }
        releaseMediaDataSource();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j3) throws IllegalStateException {
        this.mInternalMediaPlayer.seekTo((int) j3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i3) {
        this.mInternalMediaPlayer.setAudioStreamType(i3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.mInitLock) {
            if (!this.mIsReleased) {
                this.mInternalMediaPlayer.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z16) {
        this.mInternalMediaPlayer.setLooping(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setNextMediaPlayer(IMediaPlayer iMediaPlayer) throws UnsupportedOperationException {
        if (IMediaPlayer.SUPPORT_NEXT_MEDIA) {
            if (iMediaPlayer instanceof AndroidMediaPlayer) {
                this.mInternalMediaPlayer.setNextMediaPlayer(((AndroidMediaPlayer) iMediaPlayer).getInternalMediaPlayer());
                return;
            }
            throw new UnsupportedOperationException("setNextMediaPlayer is not supported for type " + iMediaPlayer);
        }
        throw new UnsupportedOperationException("setNextMediaPlayer is not supported");
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSeekParameters(SeekParameters seekParameters) {
        DebugLog.w("AndroidMediaPlayer", "setSeekParameters is not supported");
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @TargetApi(14)
    public void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f16, float f17) {
        this.mInternalMediaPlayer.setVolume(f16, f17);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i3) {
        this.mInternalMediaPlayer.setWakeMode(context, i3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        this.mInternalMediaPlayer.start();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        this.mInternalMediaPlayer.stop();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @TargetApi(14)
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.mInternalMediaPlayer.setDataSource(parse.getPath());
        } else {
            this.mInternalMediaPlayer.setDataSource(str);
        }
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    @TargetApi(23)
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        releaseMediaDataSource();
        MediaDataSourceProxy mediaDataSourceProxy = new MediaDataSourceProxy(iMediaDataSource);
        this.mMediaDataSource = mediaDataSourceProxy;
        this.mInternalMediaPlayer.setDataSource(mediaDataSourceProxy);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z16) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z16) {
    }
}
