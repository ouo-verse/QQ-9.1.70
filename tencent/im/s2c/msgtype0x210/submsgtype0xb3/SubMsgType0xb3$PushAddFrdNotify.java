package tencent.im.s2c.msgtype0x210.submsgtype0xb3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SubMsgType0xb3$PushAddFrdNotify extends MessageMicro<SubMsgType0xb3$PushAddFrdNotify> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fuin_nick;
    public final PBBytesField bytes_mobile;
    public final PBBytesField bytes_wording;
    public final PBUInt32Field uint32_source_id;
    public final PBUInt32Field uint32_subsource_id;
    public final PBUInt64Field uint64_req_uin;
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_fuin_bubble_id = PBField.initUInt64(0);
    public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29, 34, 42, 48, 56, 66, 72}, new String[]{"uint64_fuin", "uint64_fuin_bubble_id", "fixed32_timestamp", "bytes_wording", "bytes_fuin_nick", "uint32_source_id", "uint32_subsource_id", "bytes_mobile", "uint64_req_uin"}, new Object[]{0L, 0L, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0L}, SubMsgType0xb3$PushAddFrdNotify.class);
    }

    public SubMsgType0xb3$PushAddFrdNotify() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.bytes_fuin_nick = PBField.initBytes(byteStringMicro);
        this.uint32_source_id = PBField.initUInt32(0);
        this.uint32_subsource_id = PBField.initUInt32(0);
        this.bytes_mobile = PBField.initBytes(byteStringMicro);
        this.uint64_req_uin = PBField.initUInt64(0L);
    }
}
