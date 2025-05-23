package tv.danmaku.ijk.media.player.misc;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes30.dex */
public class IjkTrackInfo implements ITrackInfo {
    private IjkMediaMeta.IjkStreamMeta mStreamMeta;
    private int mTrackType = 0;

    public IjkTrackInfo(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        return new IjkMediaFormat(this.mStreamMeta);
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getInfoInline() {
        StringBuilder sb5 = new StringBuilder(128);
        int i3 = this.mTrackType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        sb5.append("UNKNOWN");
                    } else {
                        sb5.append("SUBTITLE");
                    }
                } else {
                    sb5.append("TIMEDTEXT");
                    sb5.append(", ");
                    sb5.append(this.mStreamMeta.mLanguage);
                }
            } else {
                sb5.append("AUDIO");
                sb5.append(", ");
                sb5.append(this.mStreamMeta.getCodecShortNameInline());
                sb5.append(", ");
                sb5.append(this.mStreamMeta.getBitrateInline());
                sb5.append(", ");
                sb5.append(this.mStreamMeta.getSampleRateInline());
            }
        } else {
            sb5.append("VIDEO");
            sb5.append(", ");
            sb5.append(this.mStreamMeta.getCodecShortNameInline());
            sb5.append(", ");
            sb5.append(this.mStreamMeta.getBitrateInline());
            sb5.append(", ");
            sb5.append(this.mStreamMeta.getResolutionInline());
            sb5.append(", ");
            sb5.append(this.mStreamMeta.getFpsInline());
        }
        return sb5.toString();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getLanguage() {
        IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mStreamMeta;
        if (ijkStreamMeta != null && !TextUtils.isEmpty(ijkStreamMeta.mLanguage)) {
            return this.mStreamMeta.mLanguage;
        }
        return C.LANGUAGE_UNDETERMINED;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public int getTrackType() {
        return this.mTrackType;
    }

    public void setMediaMeta(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    public void setTrackType(int i3) {
        this.mTrackType = i3;
    }

    public String toString() {
        return getClass().getSimpleName() + '{' + getInfoInline() + "}";
    }
}
