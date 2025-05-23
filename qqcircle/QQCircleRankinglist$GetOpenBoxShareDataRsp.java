package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetOpenBoxShareDataRsp extends MessageMicro<QQCircleRankinglist$GetOpenBoxShareDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58}, new String[]{"extInfo", "userRank", "bigText", "subText", "received", "pushNum", "imgURL"}, new Object[]{null, null, "", "", 0, 0, ""}, QQCircleRankinglist$GetOpenBoxShareDataRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public QQCircleRankinglist$TreasureRankItem userRank = new QQCircleRankinglist$TreasureRankItem();
    public final PBStringField bigText = PBField.initString("");
    public final PBStringField subText = PBField.initString("");
    public final PBInt32Field received = PBField.initInt32(0);
    public final PBInt32Field pushNum = PBField.initInt32(0);
    public final PBStringField imgURL = PBField.initString("");
}
