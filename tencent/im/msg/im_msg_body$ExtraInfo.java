package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$ExtraInfo extends MessageMicro<im_msg_body$ExtraInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_apns_tips;
    public final PBBytesField bytes_group_card;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_sender_title;
    public final PBUInt32Field uint32_apns_sound_type;
    public final PBUInt32Field uint32_flags;
    public final PBUInt32Field uint32_group_mask;
    public final PBUInt32Field uint32_level;
    public final PBUInt32Field uint32_msg_state_flag;
    public final PBUInt32Field uint32_msg_tail_id;
    public final PBUInt32Field uint32_new_group_flag;
    public final PBUInt64Field uint64_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58, 66, 72, 80, 88, 96}, new String[]{"bytes_nick", "bytes_group_card", "uint32_level", "uint32_flags", "uint32_group_mask", "uint32_msg_tail_id", "bytes_sender_title", "bytes_apns_tips", "uint64_uin", "uint32_msg_state_flag", "uint32_apns_sound_type", "uint32_new_group_flag"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0L, 0, 0, 0}, im_msg_body$ExtraInfo.class);
    }

    public im_msg_body$ExtraInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.bytes_group_card = PBField.initBytes(byteStringMicro);
        this.uint32_level = PBField.initUInt32(0);
        this.uint32_flags = PBField.initUInt32(0);
        this.uint32_group_mask = PBField.initUInt32(0);
        this.uint32_msg_tail_id = PBField.initUInt32(0);
        this.bytes_sender_title = PBField.initBytes(byteStringMicro);
        this.bytes_apns_tips = PBField.initBytes(byteStringMicro);
        this.uint64_uin = PBField.initUInt64(0L);
        this.uint32_msg_state_flag = PBField.initUInt32(0);
        this.uint32_apns_sound_type = PBField.initUInt32(0);
        this.uint32_new_group_flag = PBField.initUInt32(0);
    }
}
