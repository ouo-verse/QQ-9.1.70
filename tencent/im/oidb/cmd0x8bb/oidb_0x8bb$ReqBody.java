package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8bb$ReqBody extends MessageMicro<oidb_0x8bb$ReqBody> {
    public static final int MSG_READ_REQ_FIELD_NUMBER = 2;
    public static final int MSG_WRITE_REQ_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_write_req", "msg_read_req"}, new Object[]{null, null}, oidb_0x8bb$ReqBody.class);
    public oidb_0x8bb$WriteReq msg_write_req = new oidb_0x8bb$WriteReq();
    public oidb_0x8bb$ReadReq msg_read_req = new MessageMicro<oidb_0x8bb$ReadReq>() { // from class: tencent.im.oidb.cmd0x8bb.oidb_0x8bb$ReadReq
        public static final int RPT_MSG_GROUP_CONCERNED_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_group_concerned"}, new Object[]{null}, oidb_0x8bb$ReadReq.class);
        public final PBRepeatMessageField<oidb_0x8bb$GroupConcernedInfo> rpt_msg_group_concerned = PBField.initRepeatMessage(oidb_0x8bb$GroupConcernedInfo.class);
    };
}
