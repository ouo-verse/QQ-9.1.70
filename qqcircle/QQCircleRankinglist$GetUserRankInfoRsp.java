package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetUserRankInfoRsp extends MessageMicro<QQCircleRankinglist$GetUserRankInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", "uid", "inTopicListCount", "items"}, new Object[]{null, "", 0, null}, QQCircleRankinglist$GetUserRankInfoRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField uid = PBField.initString("");
    public final PBInt32Field inTopicListCount = PBField.initInt32(0);
    public final PBRepeatMessageField<QQCircleRankinglist$SimpleRankItem> items = PBField.initRepeatMessage(QQCircleRankinglist$SimpleRankItem.class);
}
