package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleYuhengActivity$PrizeInfo extends MessageMicro<QQCircleYuhengActivity$PrizeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98, 106, 114}, new String[]{"prize_icon", "prize_text", "prize_tips", "lottery_jump_url", "prize_jump_url"}, new Object[]{"", "", "", "", ""}, QQCircleYuhengActivity$PrizeInfo.class);
    public final PBStringField prize_icon = PBField.initString("");
    public final PBStringField prize_text = PBField.initString("");
    public final PBStringField prize_tips = PBField.initString("");
    public final PBStringField lottery_jump_url = PBField.initString("");
    public final PBStringField prize_jump_url = PBField.initString("");
}
