package tencent.im.s2c.msgtype0x210.submsgtype0x120;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x120$MsgBody extends MessageMicro<SubMsgType0x120$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reserve1;
    public final PBBytesField bytes_reserve2;
    public final PBBytesField bytes_reserve3;
    public final PBUInt32Field uint32_clear_themeid;
    public final PBUInt32Field uint32_notice_time;
    public final PBUInt64Field uint64_frd_uin;
    public final PBUInt32Field uint32_src_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notice_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56, 64}, new String[]{"uint32_src_app_id", "uint32_notice_type", "bytes_reserve1", "bytes_reserve2", "bytes_reserve3", "uint32_notice_time", "uint64_frd_uin", "uint32_clear_themeid"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0L, 0}, SubMsgType0x120$MsgBody.class);
    }

    public SubMsgType0x120$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_reserve1 = PBField.initBytes(byteStringMicro);
        this.bytes_reserve2 = PBField.initBytes(byteStringMicro);
        this.bytes_reserve3 = PBField.initBytes(byteStringMicro);
        this.uint32_notice_time = PBField.initUInt32(0);
        this.uint64_frd_uin = PBField.initUInt64(0L);
        this.uint32_clear_themeid = PBField.initUInt32(0);
    }
}
