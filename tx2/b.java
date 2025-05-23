package tx2;

import com.tencent.mobileqq.tvideo.danmaku.manager.l;
import com.tencent.oskplayer.contrib.ImageHashError;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import l70.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends l70.b<FeedCloudMeta$StBarrage> {

    /* renamed from: c, reason: collision with root package name */
    private FeedCloudMeta$StFeed f437880c;

    public b(com.tencent.rfw.barrage.core.c cVar, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        super(cVar);
        this.f437880c = feedCloudMeta$StFeed;
    }

    private String e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StUser = null;
        } else {
            feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
        }
        if (feedCloudMeta$StUser == null) {
            return null;
        }
        return feedCloudMeta$StUser.f398463id.get();
    }

    @Override // l70.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.tencent.rfw.barrage.data.a a(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, int i3) {
        com.tencent.rfw.barrage.data.a aVar;
        if (feedCloudMeta$StBarrage != null && feedCloudMeta$StBarrage.feedPlayTime != null) {
            if (this.f413904a == null) {
                QLog.d("QDM-TVideoNormalBarrageRenderDataConvert", 1, "[buildSingleBarrageRenderNone] barrage factory should not be null.");
                return null;
            }
            String e16 = e(this.f437880c);
            m70.a aVar2 = new m70.a();
            aVar2.d(feedCloudMeta$StBarrage);
            aVar2.c(e16);
            try {
                aVar = this.f413904a.a(ImageHashError.ERROR_DECODE_FLOW, aVar2);
            } catch (Throwable th5) {
                QLog.e("QDM-TVideoNormalBarrageRenderDataConvert", 1, "error: ", th5.getMessage());
                aVar = null;
            }
            if (aVar == null) {
                QLog.d("QDM-TVideoNormalBarrageRenderDataConvert", 1, "[buildSingleBarrageRenderNone] barrage factory should not be null.");
                return null;
            }
            if (l.i(feedCloudMeta$StBarrage)) {
                aVar.x0(true);
            }
            l.j(new a.C10708a().c(aVar).d(i3).e(this.f413905b), false);
            return aVar;
        }
        QLog.d("QDM-TVideoNormalBarrageRenderDataConvert", 1, "[buildSingleBarrageRenderNone] barrage is null or barrage play time is null.");
        return null;
    }
}
