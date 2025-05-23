package tencent.im.s2c.msgtype0x210.submsgtype0x69;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x69 extends MessageMicro<Submsgtype0x69> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_test_env;
    public final PBBytesField bytes_custom_buffer;
    public final PBBytesField bytes_face_url;
    public final PBUInt32Field uint32_cmd_uin_type;
    public final PBUInt32Field uint32_expire_time;
    public final PBUInt32Field uint32_report_type;
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBBoolField bool_display_reddot = PBField.initBool(false);
    public final PBUInt32Field uint32_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0);

    static {
        Boolean bool = Boolean.FALSE;
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 88, 96}, new String[]{"uint32_appid", "bool_display_reddot", "uint32_number", "uint32_reason", "uint32_last_time", "uint64_cmd_uin", "bytes_face_url", "bytes_custom_buffer", "uint32_expire_time", "uint32_cmd_uin_type", "uint32_report_type", "bool_test_env"}, new Object[]{0, bool, 0, 0, 0, 0L, byteStringMicro, byteStringMicro, 0, 0, 0, bool}, Submsgtype0x69.class);
    }

    public Submsgtype0x69() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_face_url = PBField.initBytes(byteStringMicro);
        this.bytes_custom_buffer = PBField.initBytes(byteStringMicro);
        this.uint32_expire_time = PBField.initUInt32(0);
        this.uint32_cmd_uin_type = PBField.initUInt32(0);
        this.uint32_report_type = PBField.initUInt32(0);
        this.bool_test_env = PBField.initBool(false);
    }
}
