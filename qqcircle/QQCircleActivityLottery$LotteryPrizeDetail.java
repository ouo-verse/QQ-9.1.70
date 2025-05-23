package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleActivityLottery$LotteryPrizeDetail extends MessageMicro<QQCircleActivityLottery$LotteryPrizeDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"prize_id", "name", "award_image_url", "award_use_schema"}, new Object[]{0L, "", "", ""}, QQCircleActivityLottery$LotteryPrizeDetail.class);
    public final PBInt64Field prize_id = PBField.initInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField award_image_url = PBField.initString("");
    public final PBStringField award_use_schema = PBField.initString("");
}
