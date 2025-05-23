package u5;

import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {
    public static int a() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_POI_CACHE_DISTANCE, 1000);
    }
}
