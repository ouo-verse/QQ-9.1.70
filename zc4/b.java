package zc4;

import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.thumbplayer.api.common.TPTrackInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    public static TPTrackInfo a(TVKTrackInfo tVKTrackInfo) {
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.setName(tVKTrackInfo.getTrackName());
        tPTrackInfo.setSelected(tVKTrackInfo.isSelected());
        tPTrackInfo.setMediaType(-1);
        int trackType = tVKTrackInfo.getTrackType();
        if (trackType != 0) {
            if (trackType != 1) {
                if (trackType != 2) {
                    if (trackType == 3) {
                        tPTrackInfo.setMediaType(3);
                    }
                } else {
                    tPTrackInfo.setMediaType(1);
                }
            } else {
                tPTrackInfo.setMediaType(0);
            }
        } else {
            tPTrackInfo.setMediaType(-1);
        }
        return tPTrackInfo;
    }
}
