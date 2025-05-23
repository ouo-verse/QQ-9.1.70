package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x76$OneMemorialDayInfo extends MessageMicro<SubMsgType0x76$OneMemorialDayInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_greetings;
    public final PBBytesField bytes_main_wording_event;
    public final PBBytesField bytes_main_wording_nick;
    public final PBBytesField bytes_sub_wording;
    public final PBUInt32Field uint32_friend_gender;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint32_type = PBField.initUInt64(0);
    public final PBUInt32Field uint32_memorial_time = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 90, 98, 106, 114, 120}, new String[]{"uint64_uin", "uint32_type", "uint32_memorial_time", "bytes_main_wording_nick", "bytes_main_wording_event", "bytes_sub_wording", "bytes_greetings", "uint32_friend_gender"}, new Object[]{0L, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, SubMsgType0x76$OneMemorialDayInfo.class);
    }

    public SubMsgType0x76$OneMemorialDayInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_main_wording_nick = PBField.initBytes(byteStringMicro);
        this.bytes_main_wording_event = PBField.initBytes(byteStringMicro);
        this.bytes_sub_wording = PBField.initBytes(byteStringMicro);
        this.bytes_greetings = PBField.initBytes(byteStringMicro);
        this.uint32_friend_gender = PBField.initUInt32(0);
    }
}
