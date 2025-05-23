package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetCreatorRankingReq extends MessageMicro<QQCircleRankinglist$GetCreatorRankingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", "RankingType", "listTime"}, new Object[]{null, 1, ""}, QQCircleRankinglist$GetCreatorRankingReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBEnumField RankingType = PBField.initEnum(1);
    public final PBStringField listTime = PBField.initString("");
}
