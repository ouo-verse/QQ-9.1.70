package tv.danmaku.ijk.media.player.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import com.google.android.exoplayer2.C;

/* compiled from: P */
/* loaded from: classes30.dex */
public class AndroidTrackInfo implements ITrackInfo {
    private final MediaPlayer.TrackInfo mTrackInfo;

    AndroidTrackInfo(MediaPlayer.TrackInfo trackInfo) {
        this.mTrackInfo = trackInfo;
    }

    public static AndroidTrackInfo[] fromMediaPlayer(MediaPlayer mediaPlayer) {
        return fromTrackInfo(mediaPlayer.getTrackInfo());
    }

    private static AndroidTrackInfo[] fromTrackInfo(MediaPlayer.TrackInfo[] trackInfoArr) {
        if (trackInfoArr == null) {
            return null;
        }
        AndroidTrackInfo[] androidTrackInfoArr = new AndroidTrackInfo[trackInfoArr.length];
        for (int i3 = 0; i3 < trackInfoArr.length; i3++) {
            androidTrackInfoArr[i3] = new AndroidTrackInfo(trackInfoArr[i3]);
        }
        return androidTrackInfoArr;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    @TargetApi(19)
    public IMediaFormat getFormat() {
        MediaFormat format;
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null || (format = trackInfo.getFormat()) == null) {
            return null;
        }
        return new AndroidMediaFormat(format);
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    @TargetApi(16)
    public String getInfoInline() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo != null) {
            return trackInfo.toString();
        }
        return "null";
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    @TargetApi(16)
    public String getLanguage() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null) {
            return C.LANGUAGE_UNDETERMINED;
        }
        return trackInfo.getLanguage();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    @TargetApi(16)
    public int getTrackType() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null) {
            return 0;
        }
        return trackInfo.getTrackType();
    }

    @TargetApi(16)
    public String toString() {
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(getClass().getSimpleName());
        sb5.append('{');
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo != null) {
            sb5.append(trackInfo.toString());
        } else {
            sb5.append("null");
        }
        sb5.append('}');
        return sb5.toString();
    }
}
