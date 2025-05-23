package tencent.im.oidb.cmd0xe3b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0xe3b$RecommendPerson extends MessageMicro<oidb_0xe3b$RecommendPerson> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reason;
    public final PBBytesField bytes_title;
    public final PBRepeatMessageField<oidb_0xe3b$Label> rpt_msg_label;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_gender;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, new String[]{"uint64_uin", "bytes_reason", "rpt_msg_label", "bytes_title", "uint32_age", "uint32_gender"}, new Object[]{0L, byteStringMicro, null, byteStringMicro, 0, 0}, oidb_0xe3b$RecommendPerson.class);
    }

    public oidb_0xe3b$RecommendPerson() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_reason = PBField.initBytes(byteStringMicro);
        this.rpt_msg_label = PBField.initRepeatMessage(oidb_0xe3b$Label.class);
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.uint32_age = PBField.initUInt32(0);
        this.uint32_gender = PBField.initUInt32(0);
    }
}
