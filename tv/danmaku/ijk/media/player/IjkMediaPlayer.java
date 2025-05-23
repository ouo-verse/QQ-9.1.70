package tv.danmaku.ijk.media.player;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Rect;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.tencent.oskplayer.miscellaneous.MediaFormatProxy;
import com.tencent.oskplayer.support.loader.DefaultNativeLibLoader;
import com.tencent.oskplayer.support.loader.NativeLibLoader;
import com.tencent.oskplayer.support.log.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.annotations.AccessedByNative;
import tv.danmaku.ijk.media.player.annotations.CalledByNative;
import tv.danmaku.ijk.media.player.misc.IAndroidIO;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

/* loaded from: classes30.dex */
public final class IjkMediaPlayer extends AbstractMediaPlayer {
    public static final int FFP_PROPV_DECODER_AVCODEC = 1;
    public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
    public static final int FFP_PROPV_DECODER_UNKNOWN = 0;
    public static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
    public static final int FFP_PROP_FLOAT_DROP_FRAME_RATE = 10007;
    public static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS = 20201;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY = 20203;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS = 20202;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
    public static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
    public static final int FFP_PROP_INT64_BIT_RATE = 20100;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES = 20208;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS = 20206;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS = 20207;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS = 20205;
    public static final int FFP_PROP_INT64_IMMEDIATE_RECONNECT = 20211;
    public static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
    public static final int FFP_PROP_INT64_LOGICAL_FILE_SIZE = 20209;
    public static final int FFP_PROP_INT64_PRE_READING_BUFFER = 20016;
    public static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
    public static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20011;
    public static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
    public static final int FFP_PROP_INT64_SHARE_CACHE_DATA = 20210;
    public static final int FFP_PROP_INT64_TCP_SPEED = 20200;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
    public static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_SILENT = 8;
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_WARN = 5;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_INFO = 200;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    protected static final int MEDIA_SET_VIDEO_SAR = 10001;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
    public static final int PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    private static final String TAG = "tv.danmaku.ijk.media.player.IjkMediaPlayer";
    private String mDataSource;
    private EventHandler mEventHandler;
    private volatile boolean mIsReleased;

    @AccessedByNative
    private int mListenerContext;

    @AccessedByNative
    private long mNativeAndroidIO;

    @AccessedByNative
    private long mNativeMediaDataSource;

    @AccessedByNative
    private long mNativeMediaPlayer;

    @AccessedByNative
    private int mNativeSurfaceTexture;
    private OnControlMessageListener mOnControlMessageListener;
    private OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private OnNativeInvokeListener mOnNativeInvokeListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private PowerManager.WakeLock mWakeLock;
    private static final NativeLibLoader sLocalLibLoader = new DefaultNativeLibLoader();
    public static volatile boolean sIsLibLoadSuccess = false;
    private static Object sIsNativeLibReady = null;
    private static volatile boolean mIsNativeInitialized = false;

    /* loaded from: classes30.dex */
    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener
        @TargetApi(16)
        public String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i3, int i16) {
            String[] supportedTypes;
            IjkMediaCodecInfo ijkMediaCodecInfo;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Log.i(IjkMediaPlayer.TAG, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str, Integer.valueOf(i3), Integer.valueOf(i16)));
            ArrayList arrayList = new ArrayList();
            int codecCount = MediaCodecList.getCodecCount();
            for (int i17 = 0; i17 < codecCount; i17++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i17);
                Log.d(IjkMediaPlayer.TAG, String.format(Locale.US, "  found codec: %s", codecInfoAt.getName()));
                if (!codecInfoAt.isEncoder() && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                    for (String str2 : supportedTypes) {
                        if (!TextUtils.isEmpty(str2)) {
                            String str3 = IjkMediaPlayer.TAG;
                            Locale locale = Locale.US;
                            Log.d(str3, String.format(locale, "    mime: %s", str2));
                            if (str2.equalsIgnoreCase(str) && (ijkMediaCodecInfo = IjkMediaCodecInfo.setupCandidate(codecInfoAt, str)) != null) {
                                arrayList.add(ijkMediaCodecInfo);
                                Log.i(IjkMediaPlayer.TAG, String.format(locale, "candidate codec: %s rank=%d", codecInfoAt.getName(), Integer.valueOf(ijkMediaCodecInfo.mRank)));
                                ijkMediaCodecInfo.dumpProfileLevels(str);
                            }
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            IjkMediaCodecInfo ijkMediaCodecInfo2 = (IjkMediaCodecInfo) arrayList.get(0);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                IjkMediaCodecInfo ijkMediaCodecInfo3 = (IjkMediaCodecInfo) it.next();
                if (ijkMediaCodecInfo3.mRank > ijkMediaCodecInfo2.mRank) {
                    ijkMediaCodecInfo2 = ijkMediaCodecInfo3;
                }
            }
            if (ijkMediaCodecInfo2.mRank < 600) {
                Log.w(IjkMediaPlayer.TAG, String.format(Locale.US, "unaccetable codec: %s", ijkMediaCodecInfo2.mCodecInfo.getName()));
                return null;
            }
            Log.i(IjkMediaPlayer.TAG, String.format(Locale.US, "selected codec: %s rank=%d", ijkMediaCodecInfo2.mCodecInfo.getName(), Integer.valueOf(ijkMediaCodecInfo2.mRank)));
            return ijkMediaCodecInfo2.mCodecInfo.getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes30.dex */
    public static class EventHandler extends Handler {
        private final WeakReference<IjkMediaPlayer> mWeakPlayer;

        public EventHandler(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(ijkMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IjkMediaPlayer ijkMediaPlayer = this.mWeakPlayer.get();
            if (ijkMediaPlayer != null) {
                long j3 = 0;
                if (ijkMediaPlayer.mNativeMediaPlayer != 0) {
                    int i3 = message.what;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                ijkMediaPlayer.stayAwake(false);
                                ijkMediaPlayer.notifyOnCompletion();
                                return;
                            }
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 == 5) {
                                        ijkMediaPlayer.mVideoWidth = message.arg1;
                                        ijkMediaPlayer.mVideoHeight = message.arg2;
                                        ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.mVideoWidth, ijkMediaPlayer.mVideoHeight, ijkMediaPlayer.mVideoSarNum, ijkMediaPlayer.mVideoSarDen);
                                        return;
                                    }
                                    if (i3 != 99) {
                                        if (i3 == 100) {
                                            DebugLog.e(IjkMediaPlayer.TAG, "Error (" + message.arg1 + "," + message.arg2 + ")");
                                            if (!ijkMediaPlayer.notifyOnError(message.arg1, message.arg2)) {
                                                ijkMediaPlayer.notifyOnCompletion();
                                            }
                                            ijkMediaPlayer.stayAwake(false);
                                            return;
                                        }
                                        if (i3 != 200) {
                                            if (i3 != 10001) {
                                                DebugLog.e(IjkMediaPlayer.TAG, "Unknown message type " + message.what);
                                                return;
                                            }
                                            ijkMediaPlayer.mVideoSarNum = message.arg1;
                                            ijkMediaPlayer.mVideoSarDen = message.arg2;
                                            ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.mVideoWidth, ijkMediaPlayer.mVideoHeight, ijkMediaPlayer.mVideoSarNum, ijkMediaPlayer.mVideoSarDen);
                                            return;
                                        }
                                        int i16 = message.arg1;
                                        if (i16 != 3) {
                                            if (i16 != 10001) {
                                                DebugLog.i(IjkMediaPlayer.TAG, "Info: MEDIA_INFO_UNKNOWN arg1=" + message.arg1 + ", arg2=" + message.arg2);
                                            } else {
                                                DebugLog.i(IjkMediaPlayer.TAG, "Info: MEDIA_INFO_VIDEO_ROTATION_CHANGED");
                                            }
                                        } else {
                                            DebugLog.i(IjkMediaPlayer.TAG, "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                                        }
                                        ijkMediaPlayer.notifyOnInfo(message.arg1, message.arg2);
                                        return;
                                    }
                                    if (message.obj == null) {
                                        ijkMediaPlayer.notifyOnTimedText(null);
                                        return;
                                    } else {
                                        ijkMediaPlayer.notifyOnTimedText(new IjkTimedText(new Rect(0, 0, 1, 1), (String) message.obj));
                                        return;
                                    }
                                }
                                ijkMediaPlayer.notifyOnSeekComplete();
                                return;
                            }
                            long j16 = message.arg1;
                            if (j16 < 0) {
                                j16 = 0;
                            }
                            long duration = ijkMediaPlayer.getDuration();
                            long j17 = 100;
                            if (duration > 0) {
                                j3 = (j16 * 100) / duration;
                            }
                            if (j3 < 100) {
                                j17 = j3;
                            }
                            ijkMediaPlayer.notifyOnBufferingUpdate((int) j17);
                            return;
                        }
                        ijkMediaPlayer.notifyOnPrepared();
                        return;
                    }
                    return;
                }
            }
            DebugLog.w(IjkMediaPlayer.TAG, "IjkMediaPlayer went away with unhandled events");
        }
    }

    /* loaded from: classes30.dex */
    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i3);
    }

    /* loaded from: classes30.dex */
    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i3, int i16);
    }

    /* loaded from: classes30.dex */
    public interface OnNativeInvokeListener {
        public static final String ARG_ERROR = "error";
        public static final String ARG_FAMILIY = "family";
        public static final String ARG_FD = "fd";
        public static final String ARG_HTTP_CODE = "http_code";
        public static final String ARG_IP = "ip";
        public static final String ARG_OFFSET = "offset";
        public static final String ARG_PORT = "port";
        public static final String ARG_RETRY_COUNTER = "retry_counter";
        public static final String ARG_SEGMENT_INDEX = "segment_index";
        public static final String ARG_URL = "url";
        public static final int CTRL_DID_TCP_OPEN = 131074;
        public static final int CTRL_WILL_CONCAT_RESOLVE_SEGMENT = 131079;
        public static final int CTRL_WILL_HTTP_OPEN = 131075;
        public static final int CTRL_WILL_LIVE_OPEN = 131077;
        public static final int CTRL_WILL_TCP_OPEN = 131073;
        public static final int EVENT_DID_HTTP_OPEN = 2;
        public static final int EVENT_DID_HTTP_SEEK = 4;
        public static final int EVENT_WILL_HTTP_OPEN = 1;
        public static final int EVENT_WILL_HTTP_SEEK = 3;

        boolean onNativeInvoke(int i3, Bundle bundle);
    }

    public IjkMediaPlayer() {
        this(sLocalLibLoader);
    }

    private native String _getAudioCodecInfo();

    private static native String _getColorFormatName(int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native double _getFPCalculation(int i3);

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native float _getPropertyFloat(int i3, float f16);

    private native long _getPropertyLong(int i3, long j3);

    private native String _getVideoCodecInfo();

    private native void _pause() throws IllegalStateException;

    private native void _release();

    private native void _reset();

    private native void _setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSourceFd(int i3) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setFrameAtTime(String str, long j3, long j16, int i3, int i16) throws IllegalArgumentException, IllegalStateException;

    private native void _setLoopCount(int i3);

    private native void _setOption(int i3, String str, long j3);

    private native void _setOption(int i3, String str, String str2);

    private native void _setPropertyFloat(int i3, float f16);

    private native void _setPropertyLong(int i3, long j3);

    private native void _setStreamSelected(int i3, boolean z16);

    private native void _setVideoSurface(Surface surface);

    private native void _start() throws IllegalStateException;

    private native void _stop() throws IllegalStateException;

    public static String getColorFormatName(int i3) {
        return _getColorFormatName(i3);
    }

    public static native MediaFormatProxy getHEVCVideoFormat(String str);

    private static void initNativeOnce() {
        synchronized (IjkMediaPlayer.class) {
            if (!mIsNativeInitialized) {
                native_init();
                mIsNativeInitialized = true;
            }
        }
    }

    private void initPlayer(NativeLibLoader nativeLibLoader) {
        loadLibrariesOnce(nativeLibLoader);
        if (!sIsLibLoadSuccess) {
            return;
        }
        initNativeOnce();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        native_setup(new WeakReference(this));
    }

    public static boolean isNativeLibReady(NativeLibLoader nativeLibLoader) {
        synchronized (IjkMediaPlayer.class) {
            if (nativeLibLoader == null) {
                nativeLibLoader = sLocalLibLoader;
            }
            Object obj = sIsNativeLibReady;
            if (obj != null) {
                return ((Boolean) obj).booleanValue();
            }
            boolean z16 = false;
            if (nativeLibLoader == null) {
                return false;
            }
            NativeLibLoader.State isLibReadyToLoad = nativeLibLoader.isLibReadyToLoad("ijkffmpeg");
            NativeLibLoader.State state = NativeLibLoader.State.WAIT;
            if (isLibReadyToLoad != state && nativeLibLoader.isLibReadyToLoad("ijksdl") != state && nativeLibLoader.isLibReadyToLoad("ijkplayer") != state) {
                NativeLibLoader.State isLibReadyToLoad2 = nativeLibLoader.isLibReadyToLoad("ijkffmpeg");
                NativeLibLoader.State state2 = NativeLibLoader.State.TRUE;
                if (isLibReadyToLoad2 == state2 && nativeLibLoader.isLibReadyToLoad("ijksdl") == state2 && nativeLibLoader.isLibReadyToLoad("ijkplayer") == state2) {
                    z16 = true;
                }
                Boolean valueOf = Boolean.valueOf(z16);
                sIsNativeLibReady = valueOf;
                return valueOf.booleanValue();
            }
            return false;
        }
    }

    public static void loadLibrariesOnce(NativeLibLoader nativeLibLoader) {
        synchronized (IjkMediaPlayer.class) {
            if (!sIsLibLoadSuccess) {
                if (nativeLibLoader == null) {
                    nativeLibLoader = sLocalLibLoader;
                }
                try {
                    nativeLibLoader.loadLibrary("ijkffmpeg");
                    nativeLibLoader.loadLibrary("ijksdl");
                    nativeLibLoader.loadLibrary("ijkplayer");
                    sIsLibLoadSuccess = true;
                } catch (Throwable th5) {
                    Logger.g().w(TAG, "failed to load library mIsLibLoaded=" + sIsLibLoadSuccess);
                    th5.printStackTrace();
                }
                Logger.g().i(TAG, "library loaded result " + sIsLibLoadSuccess);
            }
        }
    }

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i3);

    private native void native_setup(Object obj);

    @CalledByNative
    private static boolean onNativeInvoke(Object obj, int i3, Bundle bundle) {
        OnControlMessageListener onControlMessageListener;
        DebugLog.ifmt(TAG, "onNativeInvoke %d", Integer.valueOf(i3));
        if (obj != null && (obj instanceof WeakReference)) {
            IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
            if (ijkMediaPlayer != null) {
                OnNativeInvokeListener onNativeInvokeListener = ijkMediaPlayer.mOnNativeInvokeListener;
                if (onNativeInvokeListener != null && onNativeInvokeListener.onNativeInvoke(i3, bundle)) {
                    return true;
                }
                if (i3 != 131079 || (onControlMessageListener = ijkMediaPlayer.mOnControlMessageListener) == null) {
                    return false;
                }
                int i16 = bundle.getInt(OnNativeInvokeListener.ARG_SEGMENT_INDEX, -1);
                if (i16 >= 0) {
                    String onControlResolveSegmentUrl = onControlMessageListener.onControlResolveSegmentUrl(i16);
                    if (onControlResolveSegmentUrl != null) {
                        bundle.putString("url", onControlResolveSegmentUrl);
                        return true;
                    }
                    throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
                }
                throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
            }
            throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
        }
        throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
    }

    @CalledByNative
    private static String onSelectCodec(Object obj, String str, int i3, int i16) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || !(obj instanceof WeakReference) || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return null;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = ijkMediaPlayer.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(ijkMediaPlayer, str, i3, i16);
    }

    @CalledByNative
    private static void postEventFromNative(Object obj, int i3, int i16, int i17, Object obj2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return;
        }
        if (i3 == 200 && i16 == 2) {
            ijkMediaPlayer.start();
        }
        EventHandler eventHandler = ijkMediaPlayer.mEventHandler;
        if (eventHandler != null) {
            ijkMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i3, i16, i17, obj2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Wakelock"})
    public void stayAwake(boolean z16) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z16 && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z16 && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z16;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        boolean z16;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            if (this.mScreenOnWhilePlaying && this.mStayAwake) {
                z16 = true;
            } else {
                z16 = false;
            }
            surfaceHolder.setKeepScreenOn(z16);
        }
    }

    public native void _prepareAsync() throws IllegalStateException;

    public void deselectTrack(int i3) {
        _setStreamSelected(i3, false);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
    }

    public long getAsyncStatisticBufBackwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS, 0L);
    }

    public long getAsyncStatisticBufCapacity() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY, 0L);
    }

    public long getAsyncStatisticBufForwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS, 0L);
    }

    public long getAudioCachedBytes() {
        return _getPropertyLong(20008, 0L);
    }

    public long getAudioCachedDuration() {
        return _getPropertyLong(20006, 0L);
    }

    public long getAudioCachedPackets() {
        return _getPropertyLong(20010, 0L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native int getAudioSessionId();

    public long getBitRate() {
        return _getPropertyLong(FFP_PROP_INT64_BIT_RATE, 0L);
    }

    public long getCacheStatisticCountBytes() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES, 0L);
    }

    public long getCacheStatisticFileForwards() {
        return _getPropertyLong(20206, 0L);
    }

    public long getCacheStatisticFilePos() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS, 0L);
    }

    public long getCacheStatisticPhysicalPos() {
        return _getPropertyLong(20205, 0L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native long getCurrentPosition();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return this.mDataSource;
    }

    public float getDropFrameRate() {
        return _getPropertyFloat(10007, 0.0f);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native long getDuration();

    public long getFileSize() {
        return _getPropertyLong(FFP_PROP_INT64_LOGICAL_FILE_SIZE, 0L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = "ijkplayer";
        String _getVideoCodecInfo = _getVideoCodecInfo();
        if (!TextUtils.isEmpty(_getVideoCodecInfo)) {
            String[] split = _getVideoCodecInfo.split(",");
            if (split.length >= 2) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = split[1];
            } else if (split.length >= 1) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = "";
            }
        }
        String _getAudioCodecInfo = _getAudioCodecInfo();
        if (!TextUtils.isEmpty(_getAudioCodecInfo)) {
            String[] split2 = _getAudioCodecInfo.split(",");
            if (split2.length >= 2) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = split2[1];
            } else if (split2.length >= 1) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = "";
            }
        }
        try {
            mediaInfo.mMeta = IjkMediaMeta.parse(_getMediaMeta());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return mediaInfo;
    }

    public Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    public int getScore() {
        int score = super.getScore();
        if (score > 5 && score < 26) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            ArrayList arrayList = new ArrayList(availableProcessors);
            long currentTimeMillis = System.currentTimeMillis();
            for (int i3 = 0; i3 < availableProcessors; i3++) {
                BaseThread baseThread = new BaseThread(new BaseThread() { // from class: tv.danmaku.ijk.media.player.IjkMediaPlayer.1
                    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        IjkMediaPlayer.this._getFPCalculation(200000);
                    }
                });
                arrayList.add(baseThread);
                baseThread.start();
            }
            for (int i16 = 0; i16 < availableProcessors; i16++) {
                try {
                    ((Thread) arrayList.get(i16)).join();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (score == 11) {
                if (currentTimeMillis2 < 250) {
                    score = 15;
                } else if (currentTimeMillis2 >= 250 && currentTimeMillis2 < 400) {
                    score = 14;
                } else if (currentTimeMillis2 >= 400 && currentTimeMillis2 < 600) {
                    score = 13;
                } else if (currentTimeMillis2 >= 600 && currentTimeMillis2 < 800) {
                    score = 12;
                }
            } else if (score == 16) {
                if (currentTimeMillis2 < 250) {
                    score = 20;
                } else if (currentTimeMillis2 >= 250 && currentTimeMillis2 < 350) {
                    score = 19;
                } else if (currentTimeMillis2 >= 350 && currentTimeMillis2 < 500) {
                    score = 18;
                } else if (currentTimeMillis2 >= 500 && currentTimeMillis2 < 650) {
                    score = 17;
                }
            } else if (score == 21) {
                if (currentTimeMillis2 < 200) {
                    score = 25;
                } else if (currentTimeMillis2 >= 200 && currentTimeMillis2 < 300) {
                    score = 24;
                } else if (currentTimeMillis2 >= 300 && currentTimeMillis2 < 450) {
                    score = 23;
                } else if (currentTimeMillis2 >= 450 && currentTimeMillis2 < 600) {
                    score = 22;
                }
            }
            DebugLog.w("IjkMediaPlayer", "getFPCalculation score total " + Long.toString(currentTimeMillis2));
        }
        return score;
    }

    public long getSeekLoadDuration() {
        return _getPropertyLong(FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION, 0L);
    }

    public int getSelectedTrack(int i3) {
        long _getPropertyLong;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return -1;
                }
                _getPropertyLong = _getPropertyLong(20011, -1L);
            } else {
                _getPropertyLong = _getPropertyLong(20002, -1L);
            }
        } else {
            _getPropertyLong = _getPropertyLong(20001, -1L);
        }
        return (int) _getPropertyLong;
    }

    public float getSpeed(float f16) {
        return _getPropertyFloat(10003, 0.0f);
    }

    public long getTcpSpeed() {
        return _getPropertyLong(FFP_PROP_INT64_TCP_SPEED, 0L);
    }

    public long getTrafficStatisticByteCount() {
        return _getPropertyLong(FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT, 0L);
    }

    public long getVideoCachedBytes() {
        return _getPropertyLong(20007, 0L);
    }

    public long getVideoCachedDuration() {
        return _getPropertyLong(20005, 0L);
    }

    public long getVideoCachedPackets() {
        return _getPropertyLong(20009, 0L);
    }

    public float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    public int getVideoDecoder() {
        return (int) _getPropertyLong(20003, 0L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public void httphookReconnect() {
        _setPropertyLong(FFP_PROP_INT64_IMMEDIATE_RECONNECT, 1L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        if (_getLoopCount() != 1) {
            return true;
        }
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native boolean isPlaying();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        _prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.mIsReleased = true;
        stayAwake(false);
        updateSurfaceScreenOn();
        resetListeners();
        _release();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        stayAwake(false);
        _reset();
        this.mEventHandler.removeCallbacksAndMessages(null);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer
    public void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native void seekTo(long j3) throws IllegalStateException;

    public void selectTrack(int i3) {
        _setStreamSelected(i3, true);
    }

    public void setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setAndroidIOCallback(iAndroidIO);
    }

    public void setCacheShare(int i3) {
        _setPropertyLong(FFP_PROP_INT64_SHARE_CACHE_DATA, i3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, (Map<String, String>) null);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Surface surface;
        this.mSurfaceHolder = surfaceHolder;
        if (surfaceHolder != null) {
            surface = surfaceHolder.getSurface();
        } else {
            surface = null;
        }
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z16) {
        int i3 = !z16 ? 1 : 0;
        setOption(4, "loop", i3);
        _setLoopCount(i3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setNextMediaPlayer(IMediaPlayer iMediaPlayer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setNextMediaPlayer is not supported");
    }

    public void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    public void setOnMediaCodecSelectListener(OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    public void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    public void setOption(int i3, String str, String str2) {
        _setOption(i3, str, str2);
    }

    public void setPreReadingBuffer(long j3) {
        _setPropertyLong(20016, j3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
        if (this.mScreenOnWhilePlaying != z16) {
            if (z16 && this.mSurfaceHolder == null) {
                DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z16;
            updateSurfaceScreenOn();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSeekParameters(SeekParameters seekParameters) {
        if (seekParameters == null) {
            DebugLog.w("IjkMediaPlayer", "no SeekParameter set");
            return;
        }
        SeekParameters seekParameters2 = SeekParameters.EXACT;
        if (!seekParameters.equals(seekParameters2) && !seekParameters.equals(SeekParameters.DEFAULT)) {
            DebugLog.w("IjkMediaPlayer", "unsupported seekParameter ignored!");
        } else {
            setOption(4, "enable-accurate-seek", seekParameters.equals(seekParameters2) ? 1L : 0L);
        }
    }

    public void setSpeed(float f16) {
        _setPropertyFloat(10003, f16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native void setVolume(float f16, float f17);

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @SuppressLint({"Wakelock"})
    public void setWakeMode(Context context, int i3) {
        boolean z16;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                this.mWakeLock.release();
                z16 = true;
            } else {
                z16 = false;
            }
            this.mWakeLock = null;
        } else {
            z16 = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i3 | 536870912, IjkMediaPlayer.class.getName());
        this.mWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z16) {
            this.mWakeLock.acquire();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        stayAwake(true);
        _start();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        stayAwake(false);
        _stop();
    }

    public IjkMediaPlayer(NativeLibLoader nativeLibLoader) {
        this.mWakeLock = null;
        initPlayer(nativeLibLoader);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public IjkTrackInfo[] getTrackInfo() {
        Bundle mediaMeta;
        IjkMediaMeta parse;
        if (this.mIsReleased || (mediaMeta = getMediaMeta()) == null || (parse = IjkMediaMeta.parse(mediaMeta)) == null || parse.mStreams == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<IjkMediaMeta.IjkStreamMeta> it = parse.mStreams.iterator();
        while (it.hasNext()) {
            IjkMediaMeta.IjkStreamMeta next = it.next();
            IjkTrackInfo ijkTrackInfo = new IjkTrackInfo(next);
            if (next.mType.equalsIgnoreCase("video")) {
                ijkTrackInfo.setTrackType(1);
            } else if (next.mType.equalsIgnoreCase("audio")) {
                ijkTrackInfo.setTrackType(2);
            } else if (next.mType.equalsIgnoreCase("timedtext")) {
                ijkTrackInfo.setTrackType(3);
            }
            arrayList.add(ijkTrackInfo);
        }
        return (IjkTrackInfo[]) arrayList.toArray(new IjkTrackInfo[arrayList.size()]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
    
        if (0 != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0088, code lost:
    
        android.util.Log.d(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "Couldn't open file on client side, trying server side");
        setDataSource(r9.toString(), r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        if (0 != 0) goto L34;
     */
    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @TargetApi(14)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            setDataSource(uri.getPath());
            return;
        }
        if ("content".equals(scheme) && QCircleDaTongConstant.ElementParamValue.SETTINGS.equals(uri.getAuthority()) && (uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri))) == null) {
            throw new FileNotFoundException("Failed to resolve default ringtone");
        }
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
            if (openAssetFileDescriptor == null) {
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
            } else {
                if (openAssetFileDescriptor.getDeclaredLength() < 0) {
                    setDataSource(openAssetFileDescriptor.getFileDescriptor());
                } else {
                    setDataSource(openAssetFileDescriptor.getFileDescriptor(), openAssetFileDescriptor.getStartOffset(), openAssetFileDescriptor.getDeclaredLength());
                }
                openAssetFileDescriptor.close();
            }
        } catch (IOException unused) {
        } catch (SecurityException unused2) {
        } catch (Throwable th5) {
            if (0 != 0) {
                assetFileDescriptor.close();
            }
            throw th5;
        }
    }

    public void setOption(int i3, String str, long j3) {
        _setOption(i3, str, j3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = str;
        _setDataSource(str, null, null);
    }

    public void setDataSource(String str, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(":");
                if (!TextUtils.isEmpty(entry.getValue())) {
                    sb5.append(entry.getValue());
                }
                sb5.append("\r\n");
                setOption(1, "headers", sb5.toString());
                setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,rtp,tcp,tls,udp,ijkurlhook,data");
            }
        }
        setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @TargetApi(13)
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
        try {
            _setDataSourceFd(dup.getFd());
        } finally {
            dup.close();
        }
    }

    private void setDataSource(FileDescriptor fileDescriptor, long j3, long j16) throws IOException, IllegalArgumentException, IllegalStateException {
        setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setDataSource(iMediaDataSource);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i3) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z16) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z16) {
    }
}
