package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0xc26$UndecidePerson extends MessageMicro<oidb_0xc26$UndecidePerson> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_reason;
    public final PBBytesField bytes_remark;
    public final PBRepeatMessageField<oidb_0xc26$Label> rpt_msg_labels;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_reqtype;
    public final PBUInt32Field uint32_time;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public oidb_0xc26$AddFriendSource msg_source = new oidb_0xc26$AddFriendSource();

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56, 66, 72, 80}, new String[]{"uint64_uin", "msg_source", "bytes_reason", "bytes_nick", "bytes_remark", "uint32_age", "uint32_gender", "rpt_msg_labels", "uint32_reqtype", "uint32_time"}, new Object[]{0L, null, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, null, 0, 0}, oidb_0xc26$UndecidePerson.class);
    }

    public oidb_0xc26$UndecidePerson() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_reason = PBField.initBytes(byteStringMicro);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.bytes_remark = PBField.initBytes(byteStringMicro);
        this.uint32_age = PBField.initUInt32(0);
        this.uint32_gender = PBField.initUInt32(0);
        this.rpt_msg_labels = PBField.initRepeatMessage(oidb_0xc26$Label.class);
        this.uint32_reqtype = PBField.initUInt32(0);
        this.uint32_time = PBField.initUInt32(0);
    }
}
