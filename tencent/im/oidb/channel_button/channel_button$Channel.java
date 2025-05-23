package tencent.im.oidb.channel_button;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class channel_button$Channel extends MessageMicro<channel_button$Channel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 58, 64, 72, 80, 88, 96, 106, 114, 122, 128, 136, 144, 152, 160, 170, 178, 800}, new String[]{"uint64_channel_id", "str_channel_name", "enum_reason", "uint64_start_time", "uint64_end_time", "str_icon_url", "str_cover_url", "uint32_bold_font", "uint32_show_icon", "uint32_show_cover", "uint32_frame_color", "uint32_fonts_color", "str_web_url", "msg_red_point", "str_proxy", "uint32_only_cover", "uint32_channel_type", "uint64_section_id", "uint64_bid", "uint32_dynamic_sort", "str_square_icon_url", "str_channel_version", "uint32_pos"}, new Object[]{0L, "", 1, 0L, 0L, "", "", 0, 0, 0, 0, 0, "", null, "", 0, 0, 0L, 0L, 0, "", "", 0}, channel_button$Channel.class);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
    public final PBStringField str_channel_name = PBField.initString("");
    public final PBEnumField enum_reason = PBField.initEnum(1);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_cover_url = PBField.initString("");
    public final PBUInt32Field uint32_bold_font = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_icon = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_cover = PBField.initUInt32(0);
    public final PBUInt32Field uint32_frame_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fonts_color = PBField.initUInt32(0);
    public final PBStringField str_web_url = PBField.initString("");
    public channel_button$RedPoint msg_red_point = new MessageMicro<channel_button$RedPoint>() { // from class: tencent.im.oidb.channel_button.channel_button$RedPoint
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 800}, new String[]{"bool_red_point", "uint64_start_time", "uint64_end_time", "uint32_type", "str_title_text", "uint32_title_color", "uint32_bg_color", "uint64_seq"}, new Object[]{Boolean.FALSE, 0L, 0L, 0, "", 0, 0, 0L}, channel_button$RedPoint.class);
        public final PBBoolField bool_red_point = PBField.initBool(false);
        public final PBUInt64Field uint64_start_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBStringField str_title_text = PBField.initString("");
        public final PBUInt32Field uint32_title_color = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bg_color = PBField.initUInt32(0);
        public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    };
    public final PBStringField str_proxy = PBField.initString("");
    public final PBUInt32Field uint32_only_cover = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_section_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_bid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_dynamic_sort = PBField.initUInt32(0);
    public final PBStringField str_square_icon_url = PBField.initString("");
    public final PBStringField str_channel_version = PBField.initString("");
    public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
}
