package tencent.im.oidb.cmd0x874;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x874$ReqBody extends MessageMicro<cmd0x874$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_subcmd", "msg_convert_group"}, new Object[]{0, null}, cmd0x874$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public cmd0x874$ConvertToGroupReq msg_convert_group = new MessageMicro<cmd0x874$ConvertToGroupReq>() { // from class: tencent.im.oidb.cmd0x874.cmd0x874$ConvertToGroupReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_conf_uin"}, new Object[]{0L}, cmd0x874$ConvertToGroupReq.class);
        public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
    };
}
