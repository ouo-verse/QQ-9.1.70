package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$LoveAchievementItem extends MessageMicro<oidb_0xcf4$LoveAchievementItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_achievement_id", "str_achievement_backurl", "clockState"}, new Object[]{0, "", 0}, oidb_0xcf4$LoveAchievementItem.class);
    public final PBUInt32Field uint32_achievement_id = PBField.initUInt32(0);
    public final PBStringField str_achievement_backurl = PBField.initString("");
    public final PBUInt32Field clockState = PBField.initUInt32(0);
}
