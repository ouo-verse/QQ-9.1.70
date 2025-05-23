package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x791$SetRedDotOpt extends MessageMicro<oidb_0x791$SetRedDotOpt> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_keep_unchanged;
    public final PBBytesField str_custom_buffer;
    public final PBBytesField str_face_url;
    public final PBUInt32Field uint32_cmd_uin_type;
    public final PBUInt32Field uint32_expire_time;
    public final PBUInt32Field uint32_last_time;
    public final PBUInt32Field uint32_report_type;
    public final PBUInt32Field uint32_total_number;
    public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBoolField bool_clear = PBField.initBool(false);
    public final PBBoolField bool_display_reddot = PBField.initBool(false);
    public final PBInt32Field int32_number = PBField.initInt32(0);
    public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
    public final PBBoolField bool_push_to_client = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 74, 80, 88, 96, 104, 112, 120}, new String[]{"uint64_cmd_uin", "rpt_uint64_uin", "bool_clear", "bool_display_reddot", "int32_number", "uint32_reason", "bool_push_to_client", "str_face_url", "str_custom_buffer", "uint32_expire_time", "uint32_last_time", "uint32_total_number", "uint32_cmd_uin_type", "uint32_report_type", "bool_keep_unchanged"}, new Object[]{0L, 0L, bool, bool, 0, 0, bool, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, bool}, oidb_0x791$SetRedDotOpt.class);
    }

    public oidb_0x791$SetRedDotOpt() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_face_url = PBField.initBytes(byteStringMicro);
        this.str_custom_buffer = PBField.initBytes(byteStringMicro);
        this.uint32_expire_time = PBField.initUInt32(0);
        this.uint32_last_time = PBField.initUInt32(0);
        this.uint32_total_number = PBField.initUInt32(0);
        this.uint32_cmd_uin_type = PBField.initUInt32(0);
        this.uint32_report_type = PBField.initUInt32(0);
        this.bool_keep_unchanged = PBField.initBool(false);
    }
}
