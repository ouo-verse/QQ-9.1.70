package v70;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static void a(Map<String, Object> map, e30.b bVar) {
        map.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_IS_ECOMMERCE, 0);
        map.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_IS_EXPLAIN, 0);
        try {
            if (bVar.g().live.get().liveBytesExtInfo.get() != null) {
                for (FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry : bVar.g().live.get().liveBytesExtInfo.get()) {
                    if ("qqlive_ecom_ext".equals(feedCloudCommon$BytesEntry.key.get())) {
                        JSONObject jSONObject = new JSONObject(feedCloudCommon$BytesEntry.value.get().toStringUtf8());
                        if (jSONObject.optInt("buf_type") == 1) {
                            map.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_IS_EXPLAIN, 1);
                            if (!com.tencent.biz.qqcircle.immersive.feed.live.ecommerce.a.INSTANCE.a(jSONObject).getRichText().isEmpty()) {
                                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXPLAIN_MODE, 1);
                            } else {
                                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXPLAIN_MODE, 2);
                            }
                        }
                    }
                }
            }
            if (bVar.g().live.get().liveExtInfo.get() != null) {
                for (FeedCloudCommon$Entry feedCloudCommon$Entry : bVar.g().live.get().liveExtInfo.get()) {
                    if ("qqlive_ecom_has_goods_ext".equals(feedCloudCommon$Entry.key.get()) && "true".equals(feedCloudCommon$Entry.value.get())) {
                        map.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_IS_ECOMMERCE, 1);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("QFSFeedLiveReportHelper", 1, "dtReportBindItemView  parse ecommerce error:" + e16.getMessage());
        }
    }

    public static void b(Map<String, Object> map, e30.b bVar) {
        List<FeedCloudCommon$Entry> list = bVar.g().live.get().liveExtInfo.get();
        if (list != null && !list.isEmpty()) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                if (QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_PROGRAM_ID.equals(feedCloudCommon$Entry.key.get())) {
                    map.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQLIVE_PROGRAM_ID, feedCloudCommon$Entry.value.get());
                }
            }
        }
    }
}
