package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$NearbyConfig extends MessageMicro<oidb_0x8dd$NearbyConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 56, 74, 82}, new String[]{"str_security_tips", "str_security_detail_url", "uint32_use_interest_tag", "msg_alumnus_conf", "msg_recomm_people_conf", "uint32_can_add_sub_interest", "uint32_heart_increment", "msg_video_chat_conf", "msg_login_conf"}, new Object[]{"", "", 0, null, null, 0, 0, null, null}, oidb_0x8dd$NearbyConfig.class);
    public final PBStringField str_security_tips = PBField.initString("");
    public final PBStringField str_security_detail_url = PBField.initString("");
    public final PBUInt32Field uint32_use_interest_tag = PBField.initUInt32(0);
    public oidb_0x8dd$AlumnusConf msg_alumnus_conf = new MessageMicro<oidb_0x8dd$AlumnusConf>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$AlumnusConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_alumnus_entrance_open", "str_alumnus_pic_url", "str_alumnus_pic_md5"}, new Object[]{0, "", ""}, oidb_0x8dd$AlumnusConf.class);
        public final PBUInt32Field uint32_alumnus_entrance_open = PBField.initUInt32(0);
        public final PBStringField str_alumnus_pic_url = PBField.initString("");
        public final PBStringField str_alumnus_pic_md5 = PBField.initString("");
    };
    public oidb_0x8dd$RecommPeopleConf msg_recomm_people_conf = new MessageMicro<oidb_0x8dd$RecommPeopleConf>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$RecommPeopleConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"str_icon_url", "str_title", "uint32_postion", "uint32_show_num", "recommend_cookie"}, new Object[]{"", "", 0, 0, ""}, oidb_0x8dd$RecommPeopleConf.class);
        public final PBStringField str_icon_url = PBField.initString("");
        public final PBStringField str_title = PBField.initString("");
        public final PBUInt32Field uint32_postion = PBField.initUInt32(0);
        public final PBUInt32Field uint32_show_num = PBField.initUInt32(0);
        public final PBStringField recommend_cookie = PBField.initString("");
    };
    public final PBUInt32Field uint32_can_add_sub_interest = PBField.initUInt32(0);
    public final PBUInt32Field uint32_heart_increment = PBField.initUInt32(0);
    public oidb_0x8dd$VideoChatConf msg_video_chat_conf = new MessageMicro<oidb_0x8dd$VideoChatConf>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$VideoChatConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{24}, new String[]{"uint32_video_chat_num"}, new Object[]{0}, oidb_0x8dd$VideoChatConf.class);
        public final PBUInt32Field uint32_video_chat_num = PBField.initUInt32(0);
    };
    public oidb_0x8dd$LoginConf msg_login_conf = new MessageMicro<oidb_0x8dd$LoginConf>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$LoginConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_login_score"}, new Object[]{null}, oidb_0x8dd$LoginConf.class);
        public final PBRepeatMessageField<oidb_0x8dd$LoginScore> rpt_msg_login_score = PBField.initRepeatMessage(oidb_0x8dd$LoginScore.class);
    };
}
