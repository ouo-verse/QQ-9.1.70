package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleYuhengActivity$CheckPrizeRsp extends MessageMicro<QQCircleYuhengActivity$CheckPrizeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"draw_result", "prize_details", "jump_url"}, new Object[]{0, null, ""}, QQCircleYuhengActivity$CheckPrizeRsp.class);
    public final PBInt32Field draw_result = PBField.initInt32(0);
    public final PBRepeatMessageField<QQCircleYuhengActivity$PrizeDetail> prize_details = PBField.initRepeatMessage(QQCircleYuhengActivity$PrizeDetail.class);
    public final PBStringField jump_url = PBField.initString("");
}
