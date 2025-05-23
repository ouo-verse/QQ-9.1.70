package tencent.im.oidb.cmd0x89a;

import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.luggage.wxa.fe.a;
import com.tencent.luggage.wxa.rf.f;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x89a$ReqBody extends MessageMicro<oidb_0x89a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint64_group_code", "st_group_info", "uint64_original_operator_uin", "uint32_req_group_open_appid"}, new Object[]{0L, null, 0L, 0}, oidb_0x89a$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public oidb_0x89a$groupinfo st_group_info = new MessageMicro<oidb_0x89a$groupinfo>() { // from class: tencent.im.oidb.cmd0x89a.oidb_0x89a$groupinfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_group_school_info;
        public oidb_0x89a$GroupGeoInfo msg_group_geo_info;
        public final PBRepeatField<ByteStringMicro> rpt_string_group_tag;
        public oidb_0x89a$GroupCardPrefix st_group_card_prefix;
        public oidb_0x89a$GroupExInfoOnly st_group_ex_info;
        public oidb_0x89a$GroupNewGuidelinesInfo st_group_newguidelines;
        public final PBBytesField string_certification_text;
        public final PBBytesField string_group_aio_skin_url;
        public final PBBytesField string_group_answer;
        public final PBBytesField string_group_board_skin_url;
        public final PBBytesField string_group_class_text;
        public final PBBytesField string_group_cover_skin_url;
        public final PBBytesField string_group_finger_memo;
        public final PBBytesField string_group_memo;
        public final PBBytesField string_group_name;
        public final PBBytesField string_group_question;
        public final PBBytesField string_group_rich_finger_memo;
        public final PBUInt32Field uint32_active_member_num;
        public final PBUInt32Field uint32_add_option;
        public final PBUInt32Field uint32_allow_member_invite;
        public final PBUInt32Field uint32_app_privilege_flag;
        public final PBUInt32Field uint32_app_privilege_mask;
        public final PBUInt32Field uint32_certification_type;
        public final PBUInt32Field uint32_group_class_ext;
        public final PBUInt32Field uint32_group_face;
        public final PBUInt32Field uint32_group_flag_pro_1;
        public final PBUInt32Field uint32_group_flag_pro_1_mask;
        public final PBUInt32Field uint32_group_flagext3;
        public final PBUInt32Field uint32_group_flagext3_mask;
        public final PBUInt32Field uint32_group_flagext4;
        public final PBUInt32Field uint32_group_flagext4_mask;
        public final PBUInt32Field uint32_group_grade;
        public final PBUInt32Field uint32_group_open_appid;
        public final PBUInt32Field uint32_group_sec_level;
        public final PBUInt32Field uint32_group_sec_level_info;
        public final PBUInt32Field uint32_group_type_flag;
        public final PBUInt32Field uint32_hl_guild_appid;
        public final PBUInt32Field uint32_hl_guild_orgid;
        public final PBUInt32Field uint32_hl_guild_sub_type;
        public final PBUInt32Field uint32_msg_limit_frequency;
        public final PBUInt32Field uint32_no_code_finger_open_flag;
        public final PBUInt32Field uint32_no_finger_open_flag;
        public final PBUInt32Field uint32_shutup_time;
        public final PBUInt64Field uint64_allience_id;
        public final PBUInt64Field uint64_root_id;
        public final PBUInt64Field uint64_subscription_uin;
        public final PBUInt32Field uint32_group_ext_adm_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 72, 80, 88, 98, 106, 114, 120, 128, 136, 144, 154, 162, 168, 178, 184, 192, 202, 208, 216, 224, 232, 242, 250, 256, 264, 272, FilterEnum.MIC_PTU_TRANS_XINXIAN, 288, 296, 304, 312, 320, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 336, a.CTRL_INDEX, f.CTRL_INDEX, 362, 368, 376, MsgConstant.KRMFILETHUMBSIZE384}, new String[]{"uint32_group_ext_adm_num", "uint32_flag", "string_group_name", "string_group_memo", "string_group_finger_memo", "string_group_aio_skin_url", "string_group_board_skin_url", "string_group_cover_skin_url", "uint32_group_grade", "uint32_active_member_num", "uint32_certification_type", "string_certification_text", "string_group_rich_finger_memo", "st_group_newguidelines", "uint32_group_face", "uint32_add_option", "uint32_shutup_time", "uint32_group_type_flag", "rpt_string_group_tag", "msg_group_geo_info", "uint32_group_class_ext", "string_group_class_text", "uint32_app_privilege_flag", "uint32_app_privilege_mask", "st_group_ex_info", "uint32_group_sec_level", "uint32_group_sec_level_info", "uint64_subscription_uin", "uint32_allow_member_invite", "string_group_question", "string_group_answer", "uint32_group_flagext3", "uint32_group_flagext3_mask", "uint32_group_open_appid", "uint32_no_finger_open_flag", "uint32_no_code_finger_open_flag", "uint64_root_id", "uint32_msg_limit_frequency", "uint32_hl_guild_appid", "uint32_hl_guild_sub_type", "uint32_hl_guild_orgid", "uint32_group_flagext4", "uint32_group_flagext4_mask", "bytes_group_school_info", "st_group_card_prefix", "uint64_allience_id", "uint32_group_flag_pro_1", "uint32_group_flag_pro_1_mask"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, null, 0, 0, 0, 0, byteStringMicro, null, 0, byteStringMicro, 0, 0, null, 0, 0, 0L, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, 0L, 0, 0, 0, 0, 0, 0, byteStringMicro, null, 0L, 0, 0}, oidb_0x89a$groupinfo.class);
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [tencent.im.oidb.cmd0x89a.oidb_0x89a$GroupCardPrefix] */
        /* JADX WARN: Type inference failed for: r2v11, types: [tencent.im.oidb.cmd0x89a.oidb_0x89a$GroupNewGuidelinesInfo] */
        /* JADX WARN: Type inference failed for: r2v18, types: [tencent.im.oidb.cmd0x89a.oidb_0x89a$GroupGeoInfo] */
        /* JADX WARN: Type inference failed for: r2v23, types: [tencent.im.oidb.cmd0x89a.oidb_0x89a$GroupExInfoOnly] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.string_group_name = PBField.initBytes(byteStringMicro);
            this.string_group_memo = PBField.initBytes(byteStringMicro);
            this.string_group_finger_memo = PBField.initBytes(byteStringMicro);
            this.string_group_aio_skin_url = PBField.initBytes(byteStringMicro);
            this.string_group_board_skin_url = PBField.initBytes(byteStringMicro);
            this.string_group_cover_skin_url = PBField.initBytes(byteStringMicro);
            this.uint32_group_grade = PBField.initUInt32(0);
            this.uint32_active_member_num = PBField.initUInt32(0);
            this.uint32_certification_type = PBField.initUInt32(0);
            this.string_certification_text = PBField.initBytes(byteStringMicro);
            this.string_group_rich_finger_memo = PBField.initBytes(byteStringMicro);
            this.st_group_newguidelines = new MessageMicro<oidb_0x89a$GroupNewGuidelinesInfo>() { // from class: tencent.im.oidb.cmd0x89a.oidb_0x89a$GroupNewGuidelinesInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"bool_enabled", "string_content"}, new Object[]{Boolean.FALSE, ByteStringMicro.EMPTY}, oidb_0x89a$GroupNewGuidelinesInfo.class);
                public final PBBoolField bool_enabled = PBField.initBool(false);
                public final PBBytesField string_content = PBField.initBytes(ByteStringMicro.EMPTY);
            };
            this.uint32_group_face = PBField.initUInt32(0);
            this.uint32_add_option = PBField.initUInt32(0);
            this.uint32_shutup_time = PBField.initUInt32(0);
            this.uint32_group_type_flag = PBField.initUInt32(0);
            this.rpt_string_group_tag = PBField.initRepeat(PBBytesField.__repeatHelper__);
            this.msg_group_geo_info = new MessageMicro<oidb_0x89a$GroupGeoInfo>() { // from class: tencent.im.oidb.cmd0x89a.oidb_0x89a$GroupGeoInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uint32_city_id", "uint64_longtitude", "uint64_latitude", "string_geo_content", "uint64_poi_id"}, new Object[]{0, 0L, 0L, ByteStringMicro.EMPTY, 0L}, oidb_0x89a$GroupGeoInfo.class);
                public final PBUInt32Field uint32_city_id = PBField.initUInt32(0);
                public final PBUInt64Field uint64_longtitude = PBField.initUInt64(0);
                public final PBUInt64Field uint64_latitude = PBField.initUInt64(0);
                public final PBBytesField string_geo_content = PBField.initBytes(ByteStringMicro.EMPTY);
                public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0);
            };
            this.uint32_group_class_ext = PBField.initUInt32(0);
            this.string_group_class_text = PBField.initBytes(byteStringMicro);
            this.uint32_app_privilege_flag = PBField.initUInt32(0);
            this.uint32_app_privilege_mask = PBField.initUInt32(0);
            this.st_group_ex_info = new MessageMicro<oidb_0x89a$GroupExInfoOnly>() { // from class: tencent.im.oidb.cmd0x89a.oidb_0x89a$GroupExInfoOnly
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_tribe_id", "uint32_money_for_add_group"}, new Object[]{0, 0}, oidb_0x89a$GroupExInfoOnly.class);
                public final PBUInt32Field uint32_tribe_id = PBField.initUInt32(0);
                public final PBUInt32Field uint32_money_for_add_group = PBField.initUInt32(0);
            };
            this.uint32_group_sec_level = PBField.initUInt32(0);
            this.uint32_group_sec_level_info = PBField.initUInt32(0);
            this.uint64_subscription_uin = PBField.initUInt64(0L);
            this.uint32_allow_member_invite = PBField.initUInt32(0);
            this.string_group_question = PBField.initBytes(byteStringMicro);
            this.string_group_answer = PBField.initBytes(byteStringMicro);
            this.uint32_group_flagext3 = PBField.initUInt32(0);
            this.uint32_group_flagext3_mask = PBField.initUInt32(0);
            this.uint32_group_open_appid = PBField.initUInt32(0);
            this.uint32_no_finger_open_flag = PBField.initUInt32(0);
            this.uint32_no_code_finger_open_flag = PBField.initUInt32(0);
            this.uint64_root_id = PBField.initUInt64(0L);
            this.uint32_msg_limit_frequency = PBField.initUInt32(0);
            this.uint32_hl_guild_appid = PBField.initUInt32(0);
            this.uint32_hl_guild_sub_type = PBField.initUInt32(0);
            this.uint32_hl_guild_orgid = PBField.initUInt32(0);
            this.uint32_group_flagext4 = PBField.initUInt32(0);
            this.uint32_group_flagext4_mask = PBField.initUInt32(0);
            this.bytes_group_school_info = PBField.initBytes(byteStringMicro);
            this.st_group_card_prefix = new MessageMicro<oidb_0x89a$GroupCardPrefix>() { // from class: tencent.im.oidb.cmd0x89a.oidb_0x89a$GroupCardPrefix
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField bytes_introduction = PBField.initBytes(ByteStringMicro.EMPTY);
                public final PBRepeatField<ByteStringMicro> rpt_bytes_prefix = PBField.initRepeat(PBBytesField.__repeatHelper__);

                static {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_introduction", "rpt_bytes_prefix"}, new Object[]{byteStringMicro2, byteStringMicro2}, oidb_0x89a$GroupCardPrefix.class);
                }
            };
            this.uint64_allience_id = PBField.initUInt64(0L);
            this.uint32_group_flag_pro_1 = PBField.initUInt32(0);
            this.uint32_group_flag_pro_1_mask = PBField.initUInt32(0);
        }
    };
    public final PBUInt64Field uint64_original_operator_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_req_group_open_appid = PBField.initUInt32(0);
}
