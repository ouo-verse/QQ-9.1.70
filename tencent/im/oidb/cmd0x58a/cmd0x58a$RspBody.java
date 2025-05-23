package tencent.im.oidb.cmd0x58a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58a$RspBody extends MessageMicro<cmd0x58a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"msg_cmd_error_code", "uint32_subcmd", "msg_get_conf_list"}, new Object[]{null, 0, null}, cmd0x58a$RspBody.class);
    public cmd0x58a$CmdErrorCode msg_cmd_error_code = new MessageMicro<cmd0x58a$CmdErrorCode>() { // from class: tencent.im.oidb.cmd0x58a.cmd0x58a$CmdErrorCode
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_code", "bytes_err_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, cmd0x58a$CmdErrorCode.class);
        public final PBUInt32Field uint32_code = PBField.initUInt32(0);
        public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public cmd0x58a$GetConfListRsp msg_get_conf_list = new cmd0x58a$GetConfListRsp();
}
