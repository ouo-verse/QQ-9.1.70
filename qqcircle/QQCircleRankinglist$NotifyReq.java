package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$NotifyReq extends MessageMicro<QQCircleRankinglist$NotifyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 56}, new String[]{"extInfo", "listType", "toUid", "feedid", QCircleWeakNetReporter.KEY_COST, "feedCreateTime", "pushType"}, new Object[]{null, 0, "", "", 0, 0L, 0}, QQCircleRankinglist$NotifyReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field listType = PBField.initInt32(0);
    public final PBStringField toUid = PBField.initString("");
    public final PBStringField feedid = PBField.initString("");
    public final PBInt32Field cost = PBField.initInt32(0);
    public final PBUInt64Field feedCreateTime = PBField.initUInt64(0);
    public final PBInt32Field pushType = PBField.initInt32(0);
}
