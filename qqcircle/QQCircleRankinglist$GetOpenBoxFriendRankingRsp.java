package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetOpenBoxFriendRankingRsp extends MessageMicro<QQCircleRankinglist$GetOpenBoxFriendRankingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"extInfo", "items", "hostRank", "hasMore", "attachInfo"}, new Object[]{null, null, null, Boolean.FALSE, ""}, QQCircleRankinglist$GetOpenBoxFriendRankingRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleRankinglist$TreasureRankItem> items = PBField.initRepeatMessage(QQCircleRankinglist$TreasureRankItem.class);
    public QQCircleRankinglist$TreasureRankItem hostRank = new QQCircleRankinglist$TreasureRankItem();
    public final PBBoolField hasMore = PBField.initBool(false);
    public final PBStringField attachInfo = PBField.initString("");
}
