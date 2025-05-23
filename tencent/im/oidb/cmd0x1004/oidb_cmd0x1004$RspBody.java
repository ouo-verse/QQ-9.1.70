package tencent.im.oidb.cmd0x1004;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x1004$RspBody extends MessageMicro<oidb_cmd0x1004$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"person_list"}, new Object[]{null}, oidb_cmd0x1004$RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0x1004$Person> person_list = PBField.initRepeatMessage(oidb_cmd0x1004$Person.class);
}
