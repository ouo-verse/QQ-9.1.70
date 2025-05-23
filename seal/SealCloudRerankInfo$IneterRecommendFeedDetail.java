package seal;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SealCloudRerankInfo$IneterRecommendFeedDetail extends MessageMicro<SealCloudRerankInfo$IneterRecommendFeedDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"feedid", c.G, "recom_trace", TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID}, new Object[]{"", 0L, "", 0L}, SealCloudRerankInfo$IneterRecommendFeedDetail.class);
    public final PBStringField feedid = PBField.initString("");
    public final PBUInt64Field pos = PBField.initUInt64(0);
    public final PBStringField recom_trace = PBField.initString("");
    public final PBUInt64Field contentid = PBField.initUInt64(0);
}
