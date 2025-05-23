package tencent.im.oidb.cmd0x874;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x874$RspBody extends MessageMicro<cmd0x874$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_code", "bytes_err_msg", "msg_convert_group"}, new Object[]{0, ByteStringMicro.EMPTY, null}, cmd0x874$RspBody.class);
    public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x874$ConvertToGroupRsp msg_convert_group = new MessageMicro<cmd0x874$ConvertToGroupRsp>() { // from class: tencent.im.oidb.cmd0x874.cmd0x874$ConvertToGroupRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_conf_uin", "uint64_group_code"}, new Object[]{0L, 0L}, cmd0x874$ConvertToGroupRsp.class);
        public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    };
}
