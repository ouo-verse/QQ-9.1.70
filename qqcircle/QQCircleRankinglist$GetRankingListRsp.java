package qqcircle;

import com.tencent.luggage.wxa.uf.n;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$CovenantLiteDialog;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetRankingListRsp extends MessageMicro<QQCircleRankinglist$GetRankingListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 56, 66, 74, n.CTRL_INDEX}, new String[]{"extInfo", "items", "startTime", "endTime", "title", "hostUinRank", "isActiveRank", "liteDialog", "hostNick", "busiRptInfo"}, new Object[]{null, null, 0, 0, "", null, 0, null, "", ByteStringMicro.EMPTY}, QQCircleRankinglist$GetRankingListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleRankinglist$RankingItem> items = PBField.initRepeatMessage(QQCircleRankinglist$RankingItem.class);
    public final PBUInt32Field startTime = PBField.initUInt32(0);
    public final PBUInt32Field endTime = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
    public QQCircleRankinglist$RankingItem hostUinRank = new QQCircleRankinglist$RankingItem();
    public final PBInt32Field isActiveRank = PBField.initInt32(0);
    public FeedCloudMeta$CovenantLiteDialog liteDialog = new FeedCloudMeta$CovenantLiteDialog();
    public final PBStringField hostNick = PBField.initString("");
    public final PBBytesField busiRptInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
