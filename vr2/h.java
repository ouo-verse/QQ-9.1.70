package vr2;

import android.media.MediaPlayer;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J>\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0002R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lvr2/h;", "", "", "c", "", "url", "Lkotlin/Function0;", "onStartCallback", "onStopCallback", "Landroid/media/MediaPlayer$OnCompletionListener;", "onCompletionListener", tl.h.F, "f", "", "d", "e", "Landroid/media/MediaPlayer;", "a", "Landroid/media/MediaPlayer;", "player", "b", "Lkotlin/jvm/functions/Function0;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MediaPlayer player;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onStartCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onStopCallback;

    private final void c() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.player = mediaPlayer;
        mediaPlayer.setLooping(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 function0, MediaPlayer mediaPlayer) {
        if (mediaPlayer.isPlaying()) {
            return;
        }
        mediaPlayer.start();
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final boolean d() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    public final void e() {
        f();
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.player = null;
    }

    public final void f() {
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer != null) {
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: vr2.f
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer2) {
                        h.g(mediaPlayer2);
                    }
                });
                if (mediaPlayer.isPlaying() || mediaPlayer.isLooping()) {
                    mediaPlayer.stop();
                    Function0<Unit> function0 = this.onStopCallback;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            }
        } catch (Exception e16) {
            QLog.i("TroopAIVoiceChatSamplePlayer", 1, "[safeStop] player = " + this.player + " exception = " + e16);
        }
    }

    public final void h(String url, final Function0<Unit> onStartCallback, Function0<Unit> onStopCallback, MediaPlayer.OnCompletionListener onCompletionListener) {
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.i("TroopAIVoiceChatSamplePlayer", 1, "[start] player = " + this.player + " url = " + url);
        try {
            if (this.player == null) {
                c();
            } else {
                f();
                MediaPlayer mediaPlayer = this.player;
                if (mediaPlayer != null) {
                    mediaPlayer.reset();
                }
            }
            if (NetworkUtil.isNetworkAvailable()) {
                this.onStartCallback = onStartCallback;
                this.onStopCallback = onStopCallback;
                MediaPlayer mediaPlayer2 = this.player;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: vr2.g
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public final void onPrepared(MediaPlayer mediaPlayer3) {
                            h.i(Function0.this, mediaPlayer3);
                        }
                    });
                }
                MediaPlayer mediaPlayer3 = this.player;
                if (mediaPlayer3 != null) {
                    mediaPlayer3.setOnCompletionListener(onCompletionListener);
                }
                MediaPlayer mediaPlayer4 = this.player;
                if (mediaPlayer4 != null) {
                    mediaPlayer4.setDataSource(url);
                }
                MediaPlayer mediaPlayer5 = this.player;
                if (mediaPlayer5 != null) {
                    mediaPlayer5.prepareAsync();
                }
            }
        } catch (Exception e16) {
            QLog.i("TroopAIVoiceChatSamplePlayer", 1, "[start] stop exception = " + e16 + " player = " + this.player + " url = " + url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MediaPlayer mediaPlayer) {
    }
}
