package zx2;

import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerFeedConverter;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements IRFWPlayerFeedConverter<e30.b> {
    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerFeedConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RFWPlayerReportInfo<e30.b> convertToReportInfo(e30.b bVar) {
        return new RFWPlayerReportInfo<>(bVar);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerFeedConverter
    public RFWStVideo convertFeedToStVideo(Object obj) {
        if (obj instanceof FeedCloudMeta$StFeed) {
            return new RFWStVideo().setFileId(((FeedCloudMeta$StFeed) obj).video.fileId.get());
        }
        if (obj instanceof e30.b) {
            return new RFWStVideo().setFileId(((e30.b) obj).g().video.fileId.get());
        }
        return new RFWStVideo();
    }
}
