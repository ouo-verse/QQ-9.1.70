package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetOpenBoxShareDataReq extends MessageMicro<QQCircleRankinglist$GetOpenBoxShareDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", "rankingType", "uid"}, new Object[]{null, 1, ""}, QQCircleRankinglist$GetOpenBoxShareDataReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBEnumField rankingType = PBField.initEnum(1);
    public final PBStringField uid = PBField.initString("");
}
