package u30;

import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f438189a = 0;

    private int b(int i3) {
        try {
            String[] split = "2|3|4".split("\\|");
            if (i3 >= split.length) {
                QLog.d("QFSPreloadCountStrategy", 1, "[getPreloadPicCountList] index illegality...");
                return 2;
            }
            return Integer.valueOf(split[i3]).intValue();
        } catch (Throwable th5) {
            QLog.e("QFSPreloadCountStrategy", 1, "[getPreloadPicCountList] error: ", th5);
            return 2;
        }
    }

    public int a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int b16;
        if (feedCloudMeta$StFeed == null) {
            return 2;
        }
        long predictSpeedWithOutDownGrade = RFWVideoUtils.getPredictSpeedWithOutDownGrade(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        long j3 = (feedCloudMeta$StFeed.video.videoRate.get() / 1000) / 8;
        if (predictSpeedWithOutDownGrade >= 4 * j3) {
            b16 = b(2);
        } else if (predictSpeedWithOutDownGrade >= 2 * j3) {
            b16 = b(1);
        } else {
            b16 = b(0);
        }
        if (this.f438189a != b16) {
            QLog.d("QFSPreloadCountStrategy", 1, "[getLoadPictureCount] preloadCount:" + b16 + " |preDictSpeed:" + predictSpeedWithOutDownGrade + "KB/s |videoBitRate:" + j3 + "KB/s");
            this.f438189a = b16;
        }
        return b16;
    }
}
