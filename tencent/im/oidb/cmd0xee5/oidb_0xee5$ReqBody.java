package tencent.im.oidb.cmd0xee5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xee5$ReqBody extends MessageMicro<oidb_0xee5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_quest"}, new Object[]{null}, oidb_0xee5$ReqBody.class);
    public final PBRepeatMessageField<oidb_0xee5$QuestTimes> rpt_quest = PBField.initRepeatMessage(oidb_0xee5$QuestTimes.class);
}
