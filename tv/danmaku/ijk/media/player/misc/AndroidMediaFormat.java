package tv.danmaku.ijk.media.player.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;

/* compiled from: P */
/* loaded from: classes30.dex */
public class AndroidMediaFormat implements IMediaFormat {
    private final MediaFormat mMediaFormat;

    public AndroidMediaFormat(MediaFormat mediaFormat) {
        this.mMediaFormat = mediaFormat;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    @TargetApi(16)
    public int getInteger(String str) {
        MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        return mediaFormat.getInteger(str);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    @TargetApi(16)
    public String getString(String str) {
        MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return null;
        }
        return mediaFormat.getString(str);
    }

    @TargetApi(16)
    public String toString() {
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(getClass().getName());
        sb5.append('{');
        MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat != null) {
            sb5.append(mediaFormat.toString());
        } else {
            sb5.append("null");
        }
        sb5.append('}');
        return sb5.toString();
    }
}
