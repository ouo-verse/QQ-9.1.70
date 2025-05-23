package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleSpringPrizePopup$StPrizeInfo extends MessageMicro<QQCircleSpringPrizePopup$StPrizeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"prize_id", "prize_icon", "prize_text"}, new Object[]{0L, "", ""}, QQCircleSpringPrizePopup$StPrizeInfo.class);
    public final PBUInt64Field prize_id = PBField.initUInt64(0);
    public final PBStringField prize_icon = PBField.initString("");
    public final PBStringField prize_text = PBField.initString("");
}
