package tencent.im.oidb.cmd0x75e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x75e$ReqBody extends MessageMicro<oidb_cmd0x75e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 90}, new String[]{"uint64_uin", "uint32_network_type", "msg_req_para"}, new Object[]{0L, 0, null}, oidb_cmd0x75e$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
    public oidb_cmd0x75e$ReqPara msg_req_para = new MessageMicro<oidb_cmd0x75e$ReqPara>() { // from class: tencent.im.oidb.cmd0x75e.oidb_cmd0x75e$ReqPara
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"enum_op_type"}, new Object[]{1}, oidb_cmd0x75e$ReqPara.class);
        public final PBEnumField enum_op_type = PBField.initEnum(1);
    };
}
