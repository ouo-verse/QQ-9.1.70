package tencent.im.oidb.cmd0xbd4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbd4$ReqBody extends MessageMicro<oidb_cmd0xbd4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_invite_req"}, new Object[]{null}, oidb_cmd0xbd4$ReqBody.class);
    public oidb_cmd0xbd4$InviteReq msg_invite_req = new MessageMicro<oidb_cmd0xbd4$InviteReq>() { // from class: tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4$InviteReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_rowkey", "rpt_msg_invitee"}, new Object[]{"", null}, oidb_cmd0xbd4$InviteReq.class);
        public final PBStringField str_rowkey = PBField.initString("");
        public final PBRepeatMessageField<oidb_cmd0xbd4$Invitee> rpt_msg_invitee = PBField.initRepeatMessage(oidb_cmd0xbd4$Invitee.class);
    };
}
