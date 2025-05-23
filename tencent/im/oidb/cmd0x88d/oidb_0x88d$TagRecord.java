package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x88d$TagRecord extends MessageMicro<oidb_0x88d$TagRecord> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tag_id;
    public final PBBytesField bytes_tag_value;
    public final PBUInt32Field uint32_bad_num;
    public final PBUInt32Field uint32_good_num;
    public final PBUInt32Field uint32_tag_len;
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_set_time;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 66}, new String[]{"uint64_from_uin", "uint64_group_code", "bytes_tag_id", "uint64_set_time", "uint32_good_num", "uint32_bad_num", "uint32_tag_len", "bytes_tag_value"}, new Object[]{0L, 0L, byteStringMicro, 0L, 0, 0, 0, byteStringMicro}, oidb_0x88d$TagRecord.class);
    }

    public oidb_0x88d$TagRecord() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_tag_id = PBField.initBytes(byteStringMicro);
        this.uint64_set_time = PBField.initUInt64(0L);
        this.uint32_good_num = PBField.initUInt32(0);
        this.uint32_bad_num = PBField.initUInt32(0);
        this.uint32_tag_len = PBField.initUInt32(0);
        this.bytes_tag_value = PBField.initBytes(byteStringMicro);
    }
}
