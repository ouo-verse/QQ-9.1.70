package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58b$ConfMemberInfo extends MessageMicro<cmd0x58b$ConfMemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_name_card;
    public final PBBytesField bytes_member_interemark;
    public final PBUInt32Field uint32_interemark_source;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_msg_seq = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58}, new String[]{"uint64_uin", "uint32_join_time", "uint32_flag", "uint32_read_msg_seq", "bytes_member_interemark", "uint32_interemark_source", "bytes_conf_name_card"}, new Object[]{0L, 0, 0, 0, byteStringMicro, 0, byteStringMicro}, cmd0x58b$ConfMemberInfo.class);
    }

    public cmd0x58b$ConfMemberInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_member_interemark = PBField.initBytes(byteStringMicro);
        this.uint32_interemark_source = PBField.initUInt32(0);
        this.bytes_conf_name_card = PBField.initBytes(byteStringMicro);
    }
}
