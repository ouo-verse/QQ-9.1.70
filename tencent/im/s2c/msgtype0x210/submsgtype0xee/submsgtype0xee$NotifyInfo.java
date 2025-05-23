package tencent.im.s2c.msgtype0x210.submsgtype0xee;

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
public final class submsgtype0xee$NotifyInfo extends MessageMicro<submsgtype0xee$NotifyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 90, 98, 106, 114, 170}, new String[]{"msg_style_sheet", "enum_apppush_type", "msg_ordinary_push_info", "msg_social_push_info", "msg_ugc_push_info", "msg_context_info", "msg_account_info", "msg_statistics_info", "msg_control_info", "msg_extra_info"}, new Object[]{null, 0, null, null, null, null, null, null, null, null}, submsgtype0xee$NotifyInfo.class);
    public submsgtype0xee$StyleSheet msg_style_sheet = new MessageMicro<submsgtype0xee$StyleSheet>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee$StyleSheet
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 88, 96}, new String[]{"enum_style_type", "uint32_ark_enable", "uint64_scene", "uint32_duration", "uint64_end_time"}, new Object[]{0, 0, 0L, 0, 0L}, submsgtype0xee$StyleSheet.class);
        public final PBEnumField enum_style_type = PBField.initEnum(0);
        public final PBUInt32Field uint32_ark_enable = PBField.initUInt32(0);
        public final PBUInt64Field uint64_scene = PBField.initUInt64(0);
        public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
        public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
    };
    public final PBEnumField enum_apppush_type = PBField.initEnum(0);
    public submsgtype0xee$OrdinaryPushInfo msg_ordinary_push_info = new MessageMicro<submsgtype0xee$OrdinaryPushInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee$OrdinaryPushInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_label_control_info"}, new Object[]{null}, submsgtype0xee$OrdinaryPushInfo.class);
        public submsgtype0xee$OrangeControlInfo msg_label_control_info = new MessageMicro<submsgtype0xee$OrangeControlInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee$OrangeControlInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_color", "uint32_font_size"}, new Object[]{ByteStringMicro.EMPTY, 0}, submsgtype0xee$OrangeControlInfo.class);
            public final PBBytesField bytes_color = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field uint32_font_size = PBField.initUInt32(0);
        };
    };
    public submsgtype0xee$SocialPushInfo msg_social_push_info = new MessageMicro<submsgtype0xee$SocialPushInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee$SocialPushInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField string_biu_comment;
        public final PBBytesField string_biu_reason;
        public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_feeds_id", "string_biu_reason", "string_biu_comment"}, new Object[]{0L, byteStringMicro, byteStringMicro}, submsgtype0xee$SocialPushInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.string_biu_reason = PBField.initBytes(byteStringMicro);
            this.string_biu_comment = PBField.initBytes(byteStringMicro);
        }
    };
    public submsgtype0xee$UGCPushInfo msg_ugc_push_info = new MessageMicro<submsgtype0xee$UGCPushInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee$UGCPushInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_feeds_id", "string_ugc_reason"}, new Object[]{0L, ByteStringMicro.EMPTY}, submsgtype0xee$UGCPushInfo.class);
        public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
        public final PBBytesField string_ugc_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public submsgtype0xee$ContextInfo msg_context_info = new MessageMicro<submsgtype0xee$ContextInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee$ContextInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_brief;
        public final PBBytesField bytes_jump_url;
        public final PBBytesField bytes_orange_word;
        public final PBBytesField bytes_title;
        public final PBBytesField bytes_video_brief;
        public final PBEnumField enum_context_type;
        public final PBRepeatMessageField<submsgtype0xee$PictureInfo> rpt_msg_pic_list;
        public final PBUInt64Field uint64_id = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 66}, new String[]{"uint64_id", "bytes_title", "rpt_msg_pic_list", "bytes_jump_url", "bytes_orange_word", "bytes_brief", "enum_context_type", "bytes_video_brief"}, new Object[]{0L, byteStringMicro, null, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro}, submsgtype0xee$ContextInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_title = PBField.initBytes(byteStringMicro);
            this.rpt_msg_pic_list = PBField.initRepeatMessage(submsgtype0xee$PictureInfo.class);
            this.bytes_jump_url = PBField.initBytes(byteStringMicro);
            this.bytes_orange_word = PBField.initBytes(byteStringMicro);
            this.bytes_brief = PBField.initBytes(byteStringMicro);
            this.enum_context_type = PBField.initEnum(0);
            this.bytes_video_brief = PBField.initBytes(byteStringMicro);
        }
    };
    public submsgtype0xee$AccountInfo msg_account_info = new MessageMicro<submsgtype0xee$AccountInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee$AccountInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_icon_url;
        public final PBBytesField bytes_name;
        public final PBUInt64Field uint64_id = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_id", "bytes_name", "bytes_icon_url"}, new Object[]{0L, byteStringMicro, byteStringMicro}, submsgtype0xee$AccountInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_name = PBField.initBytes(byteStringMicro);
            this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        }
    };
    public submsgtype0xee$StatisticsInfo msg_statistics_info = new MessageMicro<submsgtype0xee$StatisticsInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee$StatisticsInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_algorithm_id", "uint64_strategy_id", "uint64_folder_status"}, new Object[]{0L, 0L, 0L}, submsgtype0xee$StatisticsInfo.class);
        public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_strategy_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_folder_status = PBField.initUInt64(0);
    };
    public submsgtype0xee$ControlInfo msg_control_info = new MessageMicro<submsgtype0xee$ControlInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee$ControlInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_comment_length", "uint32_show_line", "uint32_font_size"}, new Object[]{0, 0, 0}, submsgtype0xee$ControlInfo.class);
        public final PBUInt32Field uint32_comment_length = PBField.initUInt32(0);
        public final PBUInt32Field uint32_show_line = PBField.initUInt32(0);
        public final PBUInt32Field uint32_font_size = PBField.initUInt32(0);
    };
    public submsgtype0xee$ExtraInfo msg_extra_info = new MessageMicro<submsgtype0xee$ExtraInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee$ExtraInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_cookie;
        public final PBBytesField bytes_ext;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_ext", "bytes_cookie"}, new Object[]{byteStringMicro, byteStringMicro}, submsgtype0xee$ExtraInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_ext = PBField.initBytes(byteStringMicro);
            this.bytes_cookie = PBField.initBytes(byteStringMicro);
        }
    };
}
