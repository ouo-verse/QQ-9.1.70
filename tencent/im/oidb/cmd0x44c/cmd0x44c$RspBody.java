package tencent.im.oidb.cmd0x44c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x44c$RspBody extends MessageMicro<cmd0x44c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_code", "bytes_err_msg", "msg_modify_conf_info_rsp"}, new Object[]{0, ByteStringMicro.EMPTY, null}, cmd0x44c$RspBody.class);
    public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x44c$ModifyConfInfoRsp msg_modify_conf_info_rsp = new MessageMicro<cmd0x44c$ModifyConfInfoRsp>() { // from class: tencent.im.oidb.cmd0x44c.cmd0x44c$ModifyConfInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x44c$ModifyConfInfoRsp.class);
    };
}
