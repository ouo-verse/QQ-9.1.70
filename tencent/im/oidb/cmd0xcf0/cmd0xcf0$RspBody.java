package tencent.im.oidb.cmd0xcf0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xcf0$RspBody extends MessageMicro<cmd0xcf0$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_total_bind_contacts_frd_num", "rpt_msg_bind_contacts_frds"}, new Object[]{0, null}, cmd0xcf0$RspBody.class);
    public final PBUInt32Field uint32_total_bind_contacts_frd_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0xcf0$BindContactsFriendInfo> rpt_msg_bind_contacts_frds = PBField.initRepeatMessage(cmd0xcf0$BindContactsFriendInfo.class);
}
