package tencent.im.cs.cmd0x3bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3bb$AnonyMsg extends MessageMicro<cmd0x3bb$AnonyMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82, 90}, new String[]{"uint32_cmd", "msg_anony_req", "msg_anony_rsp"}, new Object[]{0, null, null}, cmd0x3bb$AnonyMsg.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public cmd0x3bb$ReqBody msg_anony_req = new MessageMicro<cmd0x3bb$ReqBody>() { // from class: tencent.im.cs.cmd0x3bb.cmd0x3bb$ReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "uint64_group_code"}, new Object[]{0L, 0L}, cmd0x3bb$ReqBody.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    };
    public cmd0x3bb$RspBody msg_anony_rsp = new cmd0x3bb$RspBody();
}
