package tencent.im.s2c.msgtype0x210.submsgtype0x87;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x87$CloneInfo extends MessageMicro<SubMsgType0x87$CloneInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_origin_nick;
    public final PBBytesField bytes_remark;
    public final PBBytesField bytes_to_nick;
    public final PBUInt32Field uint32_show_in_aio;
    public final PBUInt32Field uint32_src_gender;
    public final PBUInt64Field uint64_to_uin;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 56}, new String[]{"uint64_uin", "bytes_remark", "bytes_origin_nick", "uint32_show_in_aio", "uint64_to_uin", "bytes_to_nick", "uint32_src_gender"}, new Object[]{0L, byteStringMicro, byteStringMicro, 0, 0L, byteStringMicro, 0}, SubMsgType0x87$CloneInfo.class);
    }

    public SubMsgType0x87$CloneInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_remark = PBField.initBytes(byteStringMicro);
        this.bytes_origin_nick = PBField.initBytes(byteStringMicro);
        this.uint32_show_in_aio = PBField.initUInt32(0);
        this.uint64_to_uin = PBField.initUInt64(0L);
        this.bytes_to_nick = PBField.initBytes(byteStringMicro);
        this.uint32_src_gender = PBField.initUInt32(0);
    }
}
