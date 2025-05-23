package tencent.im.oidb.cmd0xd9c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd9c$OneFrdInfo extends MessageMicro<oidb_0xd9c$OneFrdInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_source_wording;
    public final PBBytesField bytes_src_desc;
    public final PBBytesField bytes_wording;
    public final PBEnumField enum_source_type;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subsource = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 72}, new String[]{"uint64_uin", "uint32_time", "uint32_type", "uint32_source", "uint32_subsource", "bytes_wording", "bytes_source_wording", "bytes_src_desc", "enum_source_type"}, new Object[]{0L, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 1}, oidb_0xd9c$OneFrdInfo.class);
    }

    public oidb_0xd9c$OneFrdInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.bytes_source_wording = PBField.initBytes(byteStringMicro);
        this.bytes_src_desc = PBField.initBytes(byteStringMicro);
        this.enum_source_type = PBField.initEnum(1);
    }
}
