package tencent.im.oidb.cmd0xaf6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xaf6$RspBody extends MessageMicro<cmd0xaf6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{"group_member"}, new Object[]{null}, cmd0xaf6$RspBody.class);
    public final PBRepeatMessageField<cmd0xaf6$GroupMember> group_member = PBField.initRepeatMessage(cmd0xaf6$GroupMember.class);
}
