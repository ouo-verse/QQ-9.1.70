package tencent.im.oidb.cmd0x8dd;

import appoint.define.appoint_define$CommonLabel;
import appoint.define.appoint_define$RptInterestTag;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0x8dd$NearbyPeople extends MessageMicro<oidb_0x8dd$NearbyPeople> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_online;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_picture_face;
    public final PBBytesField bytes_video_face;
    public final PBRepeatMessageField<oidb_0x8dd$FeedInfo> feed_info;
    public final PBUInt32Field index;
    public final PBInt32Field is_authen;
    public final PBUInt32Field logo_level;
    public oidb_0x8dd$Anchor1v1Info msg_anchor_1v1_info;
    public oidb_0x8dd$AnchorInfo msg_anchor_info;
    public oidb_0x8dd$ThirdLineInfo msg_third_line_info;
    public final PBUInt64Field now_id;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_charm;
    public final PBUInt32Field uint32_charm_level;
    public final PBUInt32Field uint32_charm_shown;
    public final PBUInt32Field uint32_constellation;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_god_flag;
    public final PBUInt32Field uint32_marriage;
    public final PBUInt32Field uint32_profession;
    public final PBUInt32Field uint32_real_video_flag;
    public final PBUInt32Field uint32_vip_type;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
    public final PBInt32Field int32_lat = PBField.initInt32(0);
    public final PBInt32Field int32_lon = PBField.initInt32(0);
    public final PBStringField str_description = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 88, 96, 104, 112, 120, 128, 136, 146, 154, 162, 170, 176, 184, 194, 200, 208, 224, 232, 240, 250}, new String[]{"uint64_uin", "uint64_tinyid", "uint32_distance", "uint64_timestamp", "int32_lat", "int32_lon", "str_description", "bytes_nick", "uint32_gender", "uint32_age", "uint32_charm", "uint32_charm_level", "uint32_charm_shown", "uint32_profession", "uint32_constellation", "uint32_god_flag", "uint32_vip_type", "msg_third_line_info", "msg_anchor_info", "bytes_video_face", "bytes_picture_face", "uint32_real_video_flag", "bool_online", "msg_anchor_1v1_info", "is_authen", "index", "now_id", "logo_level", "uint32_marriage", "feed_info"}, new Object[]{0L, 0L, 0, 0L, 0, 0, "", byteStringMicro, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, byteStringMicro, byteStringMicro, 0, Boolean.FALSE, null, 0, 0, 0L, 0, 0, null}, oidb_0x8dd$NearbyPeople.class);
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [tencent.im.oidb.cmd0x8dd.oidb_0x8dd$Anchor1v1Info] */
    /* JADX WARN: Type inference failed for: r4v10, types: [tencent.im.oidb.cmd0x8dd.oidb_0x8dd$ThirdLineInfo] */
    /* JADX WARN: Type inference failed for: r4v11, types: [tencent.im.oidb.cmd0x8dd.oidb_0x8dd$AnchorInfo] */
    public oidb_0x8dd$NearbyPeople() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.uint32_age = PBField.initUInt32(0);
        this.uint32_charm = PBField.initUInt32(0);
        this.uint32_charm_level = PBField.initUInt32(0);
        this.uint32_charm_shown = PBField.initUInt32(0);
        this.uint32_profession = PBField.initUInt32(0);
        this.uint32_constellation = PBField.initUInt32(0);
        this.uint32_god_flag = PBField.initUInt32(0);
        this.uint32_vip_type = PBField.initUInt32(0);
        this.msg_third_line_info = new MessageMicro<oidb_0x8dd$ThirdLineInfo>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$ThirdLineInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_common_label;
            public final PBBytesField bytes_interest_tag;
            public final PBBytesField bytes_rich_state;
            public final PBBytesField bytes_rich_state2;
            public final PBBytesField bytes_third_line_icon;
            public final PBBytesField bytes_third_line_info;
            public appoint_define$CommonLabel common_label;
            public final PBUInt32Field identity_type;
            public final PBBytesField identity_word;
            public appoint_define$RptInterestTag interest_tag;
            public final PBUInt32Field mark_type;
            public final PBBytesField mark_word;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 82, 88, 98}, new String[]{"bytes_third_line_icon", "bytes_third_line_info", "bytes_common_label", "bytes_interest_tag", "bytes_rich_state", "common_label", "interest_tag", "bytes_rich_state2", "identity_type", "identity_word", "mark_type", "mark_word"}, new Object[]{byteStringMicro2, byteStringMicro2, byteStringMicro2, byteStringMicro2, byteStringMicro2, null, null, byteStringMicro2, 0, byteStringMicro2, 0, byteStringMicro2}, oidb_0x8dd$ThirdLineInfo.class);
            }

            /* JADX WARN: Type inference failed for: r1v6, types: [appoint.define.appoint_define$RptInterestTag] */
            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_third_line_icon = PBField.initBytes(byteStringMicro2);
                this.bytes_third_line_info = PBField.initBytes(byteStringMicro2);
                this.bytes_common_label = PBField.initBytes(byteStringMicro2);
                this.bytes_interest_tag = PBField.initBytes(byteStringMicro2);
                this.bytes_rich_state = PBField.initBytes(byteStringMicro2);
                this.common_label = new appoint_define$CommonLabel();
                this.interest_tag = new MessageMicro<appoint_define$RptInterestTag>() { // from class: appoint.define.appoint_define$RptInterestTag
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_interest_tags"}, new Object[]{null}, appoint_define$RptInterestTag.class);
                    public final PBRepeatMessageField<appoint_define$InterestTag> rpt_interest_tags = PBField.initRepeatMessage(appoint_define$InterestTag.class);
                };
                this.bytes_rich_state2 = PBField.initBytes(byteStringMicro2);
                this.identity_type = PBField.initUInt32(0);
                this.identity_word = PBField.initBytes(byteStringMicro2);
                this.mark_type = PBField.initUInt32(0);
                this.mark_word = PBField.initBytes(byteStringMicro2);
            }
        };
        this.msg_anchor_info = new MessageMicro<oidb_0x8dd$AnchorInfo>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$AnchorInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56, 64}, new String[]{"uint32_live_flag", "str_live_jump_url", "str_live_avatar_gif", "str_live_boardcast_gif", "str_live_wording", "uint32_live_avatar_animation", "love_game_id", "type"}, new Object[]{0, "", "", "", "", 0, 0, 0}, oidb_0x8dd$AnchorInfo.class);
            public final PBUInt32Field uint32_live_flag = PBField.initUInt32(0);
            public final PBStringField str_live_jump_url = PBField.initString("");
            public final PBStringField str_live_avatar_gif = PBField.initString("");
            public final PBStringField str_live_boardcast_gif = PBField.initString("");
            public final PBStringField str_live_wording = PBField.initString("");
            public final PBUInt32Field uint32_live_avatar_animation = PBField.initUInt32(0);
            public final PBUInt32Field love_game_id = PBField.initUInt32(0);
            public final PBUInt32Field type = PBField.initUInt32(0);
        };
        this.bytes_video_face = PBField.initBytes(byteStringMicro);
        this.bytes_picture_face = PBField.initBytes(byteStringMicro);
        this.uint32_real_video_flag = PBField.initUInt32(0);
        this.bool_online = PBField.initBool(false);
        this.msg_anchor_1v1_info = new MessageMicro<oidb_0x8dd$Anchor1v1Info>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$Anchor1v1Info
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 42, 50}, new String[]{"str_jump_url", "str_wording", "str_tags"}, new Object[]{"", "", ""}, oidb_0x8dd$Anchor1v1Info.class);
            public final PBStringField str_jump_url = PBField.initString("");
            public final PBStringField str_wording = PBField.initString("");
            public final PBRepeatField<String> str_tags = PBField.initRepeat(PBStringField.__repeatHelper__);
        };
        this.is_authen = PBField.initInt32(0);
        this.index = PBField.initUInt32(0);
        this.now_id = PBField.initUInt64(0L);
        this.logo_level = PBField.initUInt32(0);
        this.uint32_marriage = PBField.initUInt32(0);
        this.feed_info = PBField.initRepeatMessage(oidb_0x8dd$FeedInfo.class);
    }
}
