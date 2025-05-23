package s8;

import android.text.TextUtils;
import com.qzone.common.event.EventCenter;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.tencent.mobileqq.app.AppConstants;
import cooperation.qzone.model.CoverCacheData;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {
    public static void a(com.qzone.proxy.feedcomponent.manager.d dVar, QZoneQueueTask qZoneQueueTask) {
        CellCommentInfo commentInfo;
        if (qZoneQueueTask == null) {
            return;
        }
        if (qZoneQueueTask.getExactType() == 14) {
            b(qZoneQueueTask);
            return;
        }
        BusinessFeedData queryWithMem = dVar.queryWithMem("client_key='" + qZoneQueueTask.clientKey + "'", null, null);
        if (queryWithMem != null) {
            if (queryWithMem.getLocalInfo().isFake() && (qZoneQueueTask.getExactType() == 2 || qZoneQueueTask.getExactType() == 16 || qZoneQueueTask.getExactType() == 15 || qZoneQueueTask.getExactType() == 5)) {
                long batchId = qZoneQueueTask.getBatchId();
                if (com.qzone.publish.business.publishqueue.h.c(batchId)) {
                    int i3 = com.qzone.publish.business.publishqueue.h.e(batchId).f51145d;
                    return;
                }
                return;
            }
            if (qZoneQueueTask.getExactType() == 13 && (commentInfo = queryWithMem.getCommentInfo()) != null && commentInfo.hasFakeComments()) {
                com.qzone.adapter.feedcomponent.f.Y(dVar, (String) qZoneQueueTask.getParameter(AppConstants.Key.KEY_QZONE_UGCKEY), (String) qZoneQueueTask.getParameter("uniKey"), 0);
            }
        }
    }

    public static void b(QZoneQueueTask qZoneQueueTask) {
        String str;
        if (qZoneQueueTask == null) {
            return;
        }
        CoverComponentProxy coverComponentProxy = CoverComponentProxy.f50099g;
        CoverCacheData coverFromCache = coverComponentProxy.getServiceInterface().getCoverFromCache(com.qzone.adapter.feedcomponent.i.H().j0());
        if (coverFromCache != null) {
            HashMap<String, String> hashMap = coverFromCache.mapExtInfo;
            if (hashMap != null) {
                str = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_CLIENT_KEY);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str) || !str.equals(qZoneQueueTask.clientKey)) {
                return;
            }
            CoverCacheData rollbackCover = coverComponentProxy.getServiceInterface().getRollbackCover(str);
            EventCenter.getInstance().post("Personalize", 8, rollbackCover);
            coverComponentProxy.getServiceInterface().saveCoverIntoCache(rollbackCover);
        }
    }
}
