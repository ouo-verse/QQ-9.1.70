package tx2;

import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends k70.b {

    /* renamed from: d, reason: collision with root package name */
    private final b f437879d;

    public a(com.tencent.rfw.barrage.core.c cVar, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        super(cVar, feedCloudMeta$StFeed);
        this.f437879d = new b(cVar, feedCloudMeta$StFeed);
    }

    @Override // k70.b
    public void k(float f16) {
        super.k(f16);
        b bVar = this.f437879d;
        if (bVar != null) {
            bVar.c(f16);
        }
    }

    public void m(List<FeedCloudMeta$StBarrage> list, k70.a aVar) {
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("QDM-TVideoBarrageDataFactory", 1, "[convertNormalListToRenderNode] current data source is empty, convert normal list fail.");
            return;
        }
        List<com.tencent.rfw.barrage.data.a> b16 = this.f437879d.b(list);
        if (aVar == null) {
            QLog.e("QDM-TVideoBarrageDataFactory", 1, "[convertNormalListToRenderNode] listener should not be null.");
        } else {
            aVar.a(b16);
        }
    }
}
