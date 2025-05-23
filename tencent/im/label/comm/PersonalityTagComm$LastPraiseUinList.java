package tencent.im.label.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class PersonalityTagComm$LastPraiseUinList extends MessageMicro<PersonalityTagComm$LastPraiseUinList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_uin2time"}, new Object[]{null}, PersonalityTagComm$LastPraiseUinList.class);
    public final PBRepeatMessageField<PersonalityTagComm$Uin2Time> rpt_uin2time = PBField.initRepeatMessage(PersonalityTagComm$Uin2Time.class);
}
