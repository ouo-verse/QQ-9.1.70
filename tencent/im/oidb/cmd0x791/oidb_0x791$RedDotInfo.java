package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x791$RedDotInfo extends MessageMicro<oidb_0x791$RedDotInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_0x791$DTNearbyEntranceExtendConfig msg_nearby_entrance_extend_config;
    public oidb_0x791$DTNearbyEntranceWordCornerRedDot msg_word_corner_red_dot;
    public final PBBytesField str_custom_buffer;
    public final PBBytesField str_face_url;
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
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 88, 98, 106}, new String[]{"uint32_appid", "bool_display_reddot", "uint32_number", "uint32_reason", "uint32_last_time", "uint64_cmd_uin", "str_face_url", "str_custom_buffer", "uint32_expire_time", "uint32_cmd_uin_type", "uint32_report_type", "msg_word_corner_red_dot", "msg_nearby_entrance_extend_config"}, new Object[]{0, Boolean.FALSE, 0, 0, 0, 0L, byteStringMicro, byteStringMicro, 0, 0, 0, null, null}, oidb_0x791$RedDotInfo.class);
    }

    public oidb_0x791$RedDotInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_face_url = PBField.initBytes(byteStringMicro);
        this.str_custom_buffer = PBField.initBytes(byteStringMicro);
        this.uint32_expire_time = PBField.initUInt32(0);
        this.uint32_cmd_uin_type = PBField.initUInt32(0);
        this.uint32_report_type = PBField.initUInt32(0);
        this.msg_word_corner_red_dot = new oidb_0x791$DTNearbyEntranceWordCornerRedDot();
        this.msg_nearby_entrance_extend_config = new oidb_0x791$DTNearbyEntranceExtendConfig();
    }
}
