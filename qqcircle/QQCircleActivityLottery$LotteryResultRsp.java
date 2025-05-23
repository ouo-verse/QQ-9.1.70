package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleActivityLottery$LotteryResultRsp extends MessageMicro<QQCircleActivityLottery$LotteryResultRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"lottery_result", "lottery_detail", "award_list_schema", "more_activity_schema"}, new Object[]{0, null, "", ""}, QQCircleActivityLottery$LotteryResultRsp.class);
    public final PBEnumField lottery_result = PBField.initEnum(0);
    public QQCircleActivityLottery$LotteryPrizeDetail lottery_detail = new QQCircleActivityLottery$LotteryPrizeDetail();
    public final PBStringField award_list_schema = PBField.initString("");
    public final PBStringField more_activity_schema = PBField.initString("");
}
