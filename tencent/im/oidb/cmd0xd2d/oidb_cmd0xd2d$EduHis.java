package tencent.im.oidb.cmd0xd2d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd2d$EduHis extends MessageMicro<oidb_cmd0xd2d$EduHis> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_school"}, new Object[]{null}, oidb_cmd0xd2d$EduHis.class);
    public final PBRepeatMessageField<oidb_cmd0xd2d$SchoolInfo> rpt_msg_school = PBField.initRepeatMessage(oidb_cmd0xd2d$SchoolInfo.class);
}
