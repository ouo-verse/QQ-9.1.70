package tencent.im.s2c.msgtype0x210.submsgtype0x9f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBody extends MessageMicro<MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_authkey;
    public final PBBytesField bytes_receiver_rich_content;
    public final PBBytesField bytes_sender_rich_content;
    public final PBSInt32Field sint32_sessiontype;
    public final PBUInt64Field uint64_group_uin;
    public final PBUInt32Field uint32_show_lastest = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 64}, new String[]{"uint32_show_lastest", "uint64_sender_uin", "uint64_receiver_uin", "bytes_sender_rich_content", "bytes_receiver_rich_content", "bytes_authkey", "sint32_sessiontype", "uint64_group_uin"}, new Object[]{0, 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0L}, MsgBody.class);
    }

    public MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sender_rich_content = PBField.initBytes(byteStringMicro);
        this.bytes_receiver_rich_content = PBField.initBytes(byteStringMicro);
        this.bytes_authkey = PBField.initBytes(byteStringMicro);
        this.sint32_sessiontype = PBField.initSInt32(0);
        this.uint64_group_uin = PBField.initUInt64(0L);
    }
}
