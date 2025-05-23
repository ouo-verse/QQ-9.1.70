package tencent.im.oidb.cmd0x69f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x69f$ChannelInfo extends MessageMicro<oidb_cmd0x69f$ChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ark_config;
    public final PBBytesField bytes_channel_cover_picurl;
    public final PBBytesField bytes_channel_cover_spec;
    public final PBBytesField bytes_channel_cover_wording;
    public final PBBytesField bytes_channel_jump_url;
    public final PBBytesField bytes_channel_name;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_is_external_bg_url;
    public final PBEnumField enum_channel_cover_style;
    public final PBEnumField enum_column_type;
    public oidb_cmd0x69f$RichTips msg_rich_tips;
    public final PBRepeatMessageField<oidb_cmd0x69f$ChildChannelInfo> rpt_child_channel_list;
    public final PBUInt32Field uint32_bold_font;
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type;
    public final PBUInt32Field uint32_fonts_color;
    public final PBUInt32Field uint32_frame_color;
    public final PBUInt32Field uint32_has_recommend;
    public final PBUInt32Field uint32_is_external_expose;
    public final PBUInt32Field uint32_is_first_req;
    public final PBUInt32Field uint32_is_followed;
    public final PBUInt32Field uint32_is_topic;
    public final PBUInt32Field uint32_show_icon;
    public final PBUInt64Field uint64_channel_cover_article_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 56, 66, 72, 80, 90, 96, 106, 114, 120, 130, 136, 144, 154, 162, 168, 176, 186, 192}, new String[]{"uint32_channel_id", "bytes_channel_name", "uint32_channel_type", "uint32_is_first_req", "rpt_child_channel_list", "uint32_frame_color", "uint32_fonts_color", "bytes_channel_jump_url", "uint32_bold_font", "uint32_show_icon", "bytes_ark_config", "enum_channel_cover_style", "bytes_channel_cover_wording", "bytes_channel_cover_picurl", "uint64_channel_cover_article_id", "bytes_channel_cover_spec", "uint32_is_followed", "enum_column_type", "msg_rich_tips", "bytes_icon_url", "uint32_is_topic", "uint32_is_external_expose", "bytes_is_external_bg_url", "uint32_has_recommend"}, new Object[]{0, byteStringMicro, 0, 0, null, 0, 0, byteStringMicro, 0, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0, 0, null, byteStringMicro, 0, 0, byteStringMicro, 0}, oidb_cmd0x69f$ChannelInfo.class);
    }

    /* JADX WARN: Type inference failed for: r2v19, types: [tencent.im.oidb.cmd0x69f.oidb_cmd0x69f$RichTips] */
    public oidb_cmd0x69f$ChannelInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_channel_name = PBField.initBytes(byteStringMicro);
        this.uint32_channel_type = PBField.initUInt32(0);
        this.uint32_is_first_req = PBField.initUInt32(0);
        this.rpt_child_channel_list = PBField.initRepeatMessage(oidb_cmd0x69f$ChildChannelInfo.class);
        this.uint32_frame_color = PBField.initUInt32(0);
        this.uint32_fonts_color = PBField.initUInt32(0);
        this.bytes_channel_jump_url = PBField.initBytes(byteStringMicro);
        this.uint32_bold_font = PBField.initUInt32(0);
        this.uint32_show_icon = PBField.initUInt32(0);
        this.bytes_ark_config = PBField.initBytes(byteStringMicro);
        this.enum_channel_cover_style = PBField.initEnum(0);
        this.bytes_channel_cover_wording = PBField.initBytes(byteStringMicro);
        this.bytes_channel_cover_picurl = PBField.initBytes(byteStringMicro);
        this.uint64_channel_cover_article_id = PBField.initUInt64(0L);
        this.bytes_channel_cover_spec = PBField.initBytes(byteStringMicro);
        this.uint32_is_followed = PBField.initUInt32(0);
        this.enum_column_type = PBField.initEnum(0);
        this.msg_rich_tips = new MessageMicro<oidb_cmd0x69f$RichTips>() { // from class: tencent.im.oidb.cmd0x69f.oidb_cmd0x69f$RichTips
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_tips_type", "bytes_tips_text", "uint32_latest_sticky_time"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, oidb_cmd0x69f$RichTips.class);
            public final PBUInt32Field uint32_tips_type = PBField.initUInt32(0);
            public final PBBytesField bytes_tips_text = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field uint32_latest_sticky_time = PBField.initUInt32(0);
        };
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.uint32_is_topic = PBField.initUInt32(0);
        this.uint32_is_external_expose = PBField.initUInt32(0);
        this.bytes_is_external_bg_url = PBField.initBytes(byteStringMicro);
        this.uint32_has_recommend = PBField.initUInt32(0);
    }
}
