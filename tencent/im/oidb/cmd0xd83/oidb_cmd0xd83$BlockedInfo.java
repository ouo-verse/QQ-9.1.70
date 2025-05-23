package tencent.im.oidb.cmd0xd83;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd83$BlockedInfo extends MessageMicro<oidb_cmd0xd83$BlockedInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_source;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_comm_frd;
    public final PBUInt32Field uint32_has_read;
    public final PBUInt32Field uint32_sex;
    public final PBUInt32Field uint32_time;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 56, 64}, new String[]{"uint64_uin", "bytes_nick", "uint32_age", "uint32_sex", "bytes_source", "uint32_time", "uint32_has_read", "uint32_comm_frd"}, new Object[]{0L, byteStringMicro, 0, 0, byteStringMicro, 0, 0, 0}, oidb_cmd0xd83$BlockedInfo.class);
    }

    public oidb_cmd0xd83$BlockedInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_age = PBField.initUInt32(0);
        this.uint32_sex = PBField.initUInt32(0);
        this.bytes_source = PBField.initBytes(byteStringMicro);
        this.uint32_time = PBField.initUInt32(0);
        this.uint32_has_read = PBField.initUInt32(0);
        this.uint32_comm_frd = PBField.initUInt32(0);
    }
}
