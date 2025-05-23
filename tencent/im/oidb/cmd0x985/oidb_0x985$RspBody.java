package tencent.im.oidb.cmd0x985;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x985$RspBody extends MessageMicro<oidb_0x985$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_code", "bytes_err_msg", "msg_get_read_list_rsp"}, new Object[]{0, ByteStringMicro.EMPTY, null}, oidb_0x985$RspBody.class);
    public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x985$GetReadListRsp msg_get_read_list_rsp = new MessageMicro<oidb_0x985$GetReadListRsp>() { // from class: tencent.im.oidb.cmd0x985.oidb_0x985$GetReadListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_read_list", "rpt_msg_unread_list"}, new Object[]{null, null}, oidb_0x985$GetReadListRsp.class);
        public final PBRepeatMessageField<oidb_0x985$UinInfo> rpt_msg_read_list = PBField.initRepeatMessage(oidb_0x985$UinInfo.class);
        public final PBRepeatMessageField<oidb_0x985$UinInfo> rpt_msg_unread_list = PBField.initRepeatMessage(oidb_0x985$UinInfo.class);
    };
}
