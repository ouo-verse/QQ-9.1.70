package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58b$RspBody extends MessageMicro<cmd0x58b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"msg_cmd_error_code", "uint32_subcmd", "msg_get_conf_info", "msg_get_conf_name_for_push", "msg_get_multi_conf_info"}, new Object[]{null, 0, null, null, null}, cmd0x58b$RspBody.class);
    public cmd0x58b$CmdErrorCode msg_cmd_error_code = new cmd0x58b$CmdErrorCode();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public cmd0x58b$GetConfInfoRsp msg_get_conf_info = new cmd0x58b$GetConfInfoRsp();
    public cmd0x58b$GetConfNameForPushRsp msg_get_conf_name_for_push = new MessageMicro<cmd0x58b$GetConfNameForPushRsp>() { // from class: tencent.im.oidb.cmd0x58b.cmd0x58b$GetConfNameForPushRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_conf_name"}, new Object[]{ByteStringMicro.EMPTY}, cmd0x58b$GetConfNameForPushRsp.class);
        public final PBBytesField bytes_conf_name = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public cmd0x58b$GetMultiConfInfoRsp msg_get_multi_conf_info = new cmd0x58b$GetMultiConfInfoRsp();
}
