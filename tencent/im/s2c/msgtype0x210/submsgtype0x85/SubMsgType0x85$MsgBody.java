package tencent.im.s2c.msgtype0x210.submsgtype0x85;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x85$MsgBody extends MessageMicro<SubMsgType0x85$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_authkey;
    public final PBBytesField bytes_jumpurl;
    public final PBBytesField bytes_pc_body;
    public final PBBytesField bytes_receiver_rich_content;
    public final PBBytesField bytes_sender_rich_content;
    public final PBUInt32Field uint32_icon;
    public final PBUInt32Field uint32_random;
    public final PBUInt32Field uint32_sub_type;
    public final PBUInt32Field uint32_type;
    public final PBUInt64Field uint64_red_sender_uin;
    public final PBUInt32Field uint32_show_lastest = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 72, 80, 88, 96, 106}, new String[]{"uint32_show_lastest", "uint64_sender_uin", "uint64_receiver_uin", "bytes_sender_rich_content", "bytes_receiver_rich_content", "bytes_authkey", "bytes_pc_body", "uint32_icon", "uint32_random", "uint64_red_sender_uin", "uint32_type", "uint32_sub_type", "bytes_jumpurl"}, new Object[]{0, 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0L, 0, 0, byteStringMicro}, SubMsgType0x85$MsgBody.class);
    }

    public SubMsgType0x85$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sender_rich_content = PBField.initBytes(byteStringMicro);
        this.bytes_receiver_rich_content = PBField.initBytes(byteStringMicro);
        this.bytes_authkey = PBField.initBytes(byteStringMicro);
        this.bytes_pc_body = PBField.initBytes(byteStringMicro);
        this.uint32_icon = PBField.initUInt32(0);
        this.uint32_random = PBField.initUInt32(0);
        this.uint64_red_sender_uin = PBField.initUInt64(0L);
        this.uint32_type = PBField.initUInt32(0);
        this.uint32_sub_type = PBField.initUInt32(0);
        this.bytes_jumpurl = PBField.initBytes(byteStringMicro);
    }
}
