package tencent.im.oidb.cmd0xe5b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe5b$RspBody extends MessageMicro<oidb_0xe5b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_achievement_totalcount", "rpt_life_ach_item", "str_achievement_openid"}, new Object[]{0, null, ""}, oidb_0xe5b$RspBody.class);
    public final PBUInt32Field uint32_achievement_totalcount = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xe5b$LifeAchievementItem> rpt_life_ach_item = PBField.initRepeatMessage(oidb_0xe5b$LifeAchievementItem.class);
    public final PBStringField str_achievement_openid = PBField.initString("");
}
