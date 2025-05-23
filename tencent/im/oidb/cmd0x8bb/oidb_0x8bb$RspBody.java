package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8bb$RspBody extends MessageMicro<oidb_0x8bb$RspBody> {
    public static final int MSG_READ_RSP_FIELD_NUMBER = 2;
    public static final int MSG_WRITE_RSP_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_write_rsp", "msg_read_rsp"}, new Object[]{null, null}, oidb_0x8bb$RspBody.class);
    public oidb_0x8bb$WriteRsp msg_write_rsp = new MessageMicro<oidb_0x8bb$WriteRsp>() { // from class: tencent.im.oidb.cmd0x8bb.oidb_0x8bb$WriteRsp
        public static final int RPT_MSG_GROUP_CONCERNED_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_group_concerned"}, new Object[]{null}, oidb_0x8bb$WriteRsp.class);
        public final PBRepeatMessageField<oidb_0x8bb$GroupConcernedInfo> rpt_msg_group_concerned = PBField.initRepeatMessage(oidb_0x8bb$GroupConcernedInfo.class);
    };
    public oidb_0x8bb$ReadRsp msg_read_rsp = new MessageMicro<oidb_0x8bb$ReadRsp>() { // from class: tencent.im.oidb.cmd0x8bb.oidb_0x8bb$ReadRsp
        public static final int RPT_MSG_GROUP_CONCERNED_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_group_concerned"}, new Object[]{null}, oidb_0x8bb$ReadRsp.class);
        public final PBRepeatMessageField<oidb_0x8bb$GroupConcernedInfo> rpt_msg_group_concerned = PBField.initRepeatMessage(oidb_0x8bb$GroupConcernedInfo.class);
    };
}
