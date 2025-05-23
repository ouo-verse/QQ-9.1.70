package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetTreasureWeekRankingRsp extends MessageMicro<QQCircleRankinglist$GetTreasureWeekRankingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"items", "hostRank"}, new Object[]{null, null}, QQCircleRankinglist$GetTreasureWeekRankingRsp.class);
    public final PBRepeatMessageField<QQCircleRankinglist$TreasureRankItem> items = PBField.initRepeatMessage(QQCircleRankinglist$TreasureRankItem.class);
    public QQCircleRankinglist$TreasureRankItem hostRank = new QQCircleRankinglist$TreasureRankItem();
}
