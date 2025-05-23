package tencent.im.s2c.msgtype0x210.submsgtype0xb5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xb5$MsgBody extends MessageMicro<SubMsgType0xb5$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_animation_brief;
    public final PBBytesField bytes_animation_package_url_a;
    public final PBBytesField bytes_animation_package_url_i;
    public final PBBytesField bytes_gray_tip_content;
    public final PBBytesField bytes_remind_brief;
    public final PBBytesField bytes_stmessage_comefrom;
    public final PBBytesField bytes_stmessage_message;
    public final PBBytesField bytes_stmessage_subtitle;
    public final PBBytesField bytes_stmessage_title;
    public final PBBytesField bytes_to_all_gift_id;
    public final PBUInt32Field uint32_animation_package_id;
    public final PBUInt32Field uint32_gift_count;
    public final PBUInt32Field uint32_gift_id;
    public final PBUInt32Field uint32_stmessage_exflag;
    public final PBUInt32Field uint32_stmessage_giftpicid;
    public final PBUInt64Field uint64_group_code;
    public final PBUInt64Field uint64_receiver_uin;
    public final PBUInt64Field uint64_sender_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48, 56, 66, 72, 80, 90, 98, 106, 112, 122, 128, 138, 80000}, new String[]{"bytes_gray_tip_content", "uint32_animation_package_id", "bytes_animation_package_url_a", "bytes_animation_package_url_i", "bytes_remind_brief", "uint32_gift_id", "uint32_gift_count", "bytes_animation_brief", "uint64_sender_uin", "uint64_receiver_uin", "bytes_stmessage_title", "bytes_stmessage_subtitle", "bytes_stmessage_message", "uint32_stmessage_giftpicid", "bytes_stmessage_comefrom", "uint32_stmessage_exflag", "bytes_to_all_gift_id", "uint64_group_code"}, new Object[]{byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro, 0L}, SubMsgType0xb5$MsgBody.class);
    }

    public SubMsgType0xb5$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_gray_tip_content = PBField.initBytes(byteStringMicro);
        this.uint32_animation_package_id = PBField.initUInt32(0);
        this.bytes_animation_package_url_a = PBField.initBytes(byteStringMicro);
        this.bytes_animation_package_url_i = PBField.initBytes(byteStringMicro);
        this.bytes_remind_brief = PBField.initBytes(byteStringMicro);
        this.uint32_gift_id = PBField.initUInt32(0);
        this.uint32_gift_count = PBField.initUInt32(0);
        this.bytes_animation_brief = PBField.initBytes(byteStringMicro);
        this.uint64_sender_uin = PBField.initUInt64(0L);
        this.uint64_receiver_uin = PBField.initUInt64(0L);
        this.bytes_stmessage_title = PBField.initBytes(byteStringMicro);
        this.bytes_stmessage_subtitle = PBField.initBytes(byteStringMicro);
        this.bytes_stmessage_message = PBField.initBytes(byteStringMicro);
        this.uint32_stmessage_giftpicid = PBField.initUInt32(0);
        this.bytes_stmessage_comefrom = PBField.initBytes(byteStringMicro);
        this.uint32_stmessage_exflag = PBField.initUInt32(0);
        this.bytes_to_all_gift_id = PBField.initBytes(byteStringMicro);
        this.uint64_group_code = PBField.initUInt64(0L);
    }
}
