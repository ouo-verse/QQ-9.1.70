package tencent.im.oidb.cmd0x6f6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x6f6$RspInfo extends MessageMicro<oidb_cmd0x6f6$RspInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_group_code", "uint32_result", "stgbarinfo"}, new Object[]{0L, 0, null}, oidb_cmd0x6f6$RspInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public oidb_cmd0x6f6$GbarInfo stgbarinfo = new MessageMicro<oidb_cmd0x6f6$GbarInfo>() { // from class: tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6$GbarInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_bid", "str_name"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_cmd0x6f6$GbarInfo.class);
        public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
        public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
