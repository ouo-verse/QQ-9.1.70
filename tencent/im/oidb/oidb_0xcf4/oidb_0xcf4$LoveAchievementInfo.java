package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$LoveAchievementInfo extends MessageMicro<oidb_0xcf4$LoveAchievementInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_total_count", "uint32_completed_count", "rpt_life_ach_item"}, new Object[]{0, 0, null}, oidb_0xcf4$LoveAchievementInfo.class);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_completed_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xcf4$LoveAchievementItem> rpt_life_ach_item = PBField.initRepeatMessage(oidb_0xcf4$LoveAchievementItem.class);
}
