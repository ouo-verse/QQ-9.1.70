package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb86$ReqBody extends MessageMicro<oidb_cmd0xb86$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_client_type", "msg_modify_info", "msg_examine_callback_req", "msg_security_callback_req"}, new Object[]{0, null, null, null}, oidb_cmd0xb86$ReqBody.class);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public oidb_cmd0xb86$ModifyInfo msg_modify_info = new MessageMicro<oidb_cmd0xb86$ModifyInfo>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$ModifyInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_desc;
        public final PBBytesField bytes_nick;
        public final PBStringField modify_token;
        public oidb_cmd0xb86$HeadInfo msg_head;
        public oidb_cmd0xb86$UserSetting msg_setting;
        public oidb_cmd0xb86$SystemUserInfo msg_sys_info;
        public final PBStringField str_bg_pic;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 106, 114, 122}, new String[]{"bytes_nick", "msg_head", "bytes_desc", "str_bg_pic", "msg_sys_info", "msg_setting", "modify_token"}, new Object[]{byteStringMicro, null, byteStringMicro, "", null, null, ""}, oidb_cmd0xb86$ModifyInfo.class);
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$SystemUserInfo] */
        /* JADX WARN: Type inference failed for: r1v4, types: [tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$UserSetting] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_nick = PBField.initBytes(byteStringMicro);
            this.msg_head = new oidb_cmd0xb86$HeadInfo();
            this.bytes_desc = PBField.initBytes(byteStringMicro);
            this.str_bg_pic = PBField.initString("");
            this.msg_sys_info = new MessageMicro<oidb_cmd0xb86$SystemUserInfo>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$SystemUserInfo
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField bytes_3t_bid;
                public final PBBytesField bytes_platfrom_ext;
                public oidb_cmd0xb86$BindUser msg_bind_user;
                public oidb_cmd0xb86$AppUserOpenID msg_openid;
                public final PBUInt32Field uint32_account_sysid;
                public final PBUInt32Field uint32_cc_account_level;
                public final PBUInt32Field uint32_home_page_type;
                public final PBUInt32Field uint32_unowned_user;
                public final PBUInt32Field uint32_upgc_flag;
                public final PBUInt64Field uint64_registered_type;
                public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
                public final PBUInt32Field uint32_mp_auth = PBField.initUInt32(0);
                public final PBUInt64Field uint64_id_create_time = PBField.initUInt64(0);

                static {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 56, 66, 74, 80, 88, 96, 104, 1624}, new String[]{"uint32_user_type", "uint32_mp_auth", "uint64_id_create_time", "bytes_3t_bid", "msg_bind_user", "uint64_registered_type", "bytes_platfrom_ext", "msg_openid", "uint32_home_page_type", "uint32_account_sysid", "uint32_cc_account_level", "uint32_unowned_user", "uint32_upgc_flag"}, new Object[]{0, 0, 0L, byteStringMicro2, null, 0L, byteStringMicro2, null, 0, 0, 0, 0, 0}, oidb_cmd0xb86$SystemUserInfo.class);
                }

                /* JADX WARN: Type inference failed for: r1v5, types: [tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$AppUserOpenID] */
                /* JADX WARN: Type inference failed for: r4v1, types: [tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$BindUser] */
                {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    this.bytes_3t_bid = PBField.initBytes(byteStringMicro2);
                    this.msg_bind_user = new MessageMicro<oidb_cmd0xb86$BindUser>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$BindUser
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_to_uin", "uint64_info_uin"}, new Object[]{0L, 0L}, oidb_cmd0xb86$BindUser.class);
                        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
                        public final PBUInt64Field uint64_info_uin = PBField.initUInt64(0);
                    };
                    this.uint64_registered_type = PBField.initUInt64(0L);
                    this.bytes_platfrom_ext = PBField.initBytes(byteStringMicro2);
                    this.msg_openid = new MessageMicro<oidb_cmd0xb86$AppUserOpenID>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$AppUserOpenID
                        static final MessageMicro.FieldMap __fieldMap__;
                        public final PBBytesField bytes_appid;
                        public final PBBytesField bytes_openid;
                        public final PBUInt64Field uint64_from = PBField.initUInt64(0);

                        static {
                            ByteStringMicro byteStringMicro3 = ByteStringMicro.EMPTY;
                            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_from", "bytes_appid", "bytes_openid"}, new Object[]{0L, byteStringMicro3, byteStringMicro3}, oidb_cmd0xb86$AppUserOpenID.class);
                        }

                        {
                            ByteStringMicro byteStringMicro3 = ByteStringMicro.EMPTY;
                            this.bytes_appid = PBField.initBytes(byteStringMicro3);
                            this.bytes_openid = PBField.initBytes(byteStringMicro3);
                        }
                    };
                    this.uint32_home_page_type = PBField.initUInt32(0);
                    this.uint32_account_sysid = PBField.initUInt32(0);
                    this.uint32_cc_account_level = PBField.initUInt32(0);
                    this.uint32_unowned_user = PBField.initUInt32(0);
                    this.uint32_upgc_flag = PBField.initUInt32(0);
                }
            };
            this.msg_setting = new MessageMicro<oidb_cmd0xb86$UserSetting>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$UserSetting
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{56}, new String[]{"uint32_disable_comment_recommed"}, new Object[]{0}, oidb_cmd0xb86$UserSetting.class);
                public final PBUInt32Field uint32_disable_comment_recommed = PBField.initUInt32(0);
            };
            this.modify_token = PBField.initString("");
        }
    };
    public oidb_cmd0xb86$ExamineCallBackReq msg_examine_callback_req = new MessageMicro<oidb_cmd0xb86$ExamineCallBackReq>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$ExamineCallBackReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"msg_nick", "msg_head", "msg_desc", "uint64_ret", "bytes_examine_reason"}, new Object[]{null, null, null, 0L, ByteStringMicro.EMPTY}, oidb_cmd0xb86$ExamineCallBackReq.class);
        public oidb_cmd0xb86$ExamineNick msg_nick = new oidb_cmd0xb86$ExamineNick();
        public oidb_cmd0xb86$ExamineHead msg_head = new oidb_cmd0xb86$ExamineHead();
        public oidb_cmd0xb86$ExamineDesc msg_desc = new oidb_cmd0xb86$ExamineDesc();
        public final PBUInt64Field uint64_ret = PBField.initUInt64(0);
        public final PBBytesField bytes_examine_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_cmd0xb86$SecurityCallBackReq msg_security_callback_req = new MessageMicro<oidb_cmd0xb86$SecurityCallBackReq>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$SecurityCallBackReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 66}, new String[]{"uint64_appid", "uint64_src", "uint64_sub_src", "uint64_beat_reason", "uint64_beat_common", "str_message_id", "uint64_post_time", "str_beat_desc"}, new Object[]{0L, 0L, 0L, 0L, 0L, "", 0L, ""}, oidb_cmd0xb86$SecurityCallBackReq.class);
        public final PBUInt64Field uint64_appid = PBField.initUInt64(0);
        public final PBUInt64Field uint64_src = PBField.initUInt64(0);
        public final PBUInt64Field uint64_sub_src = PBField.initUInt64(0);
        public final PBUInt64Field uint64_beat_reason = PBField.initUInt64(0);
        public final PBUInt64Field uint64_beat_common = PBField.initUInt64(0);
        public final PBStringField str_message_id = PBField.initString("");
        public final PBUInt64Field uint64_post_time = PBField.initUInt64(0);
        public final PBStringField str_beat_desc = PBField.initString("");
    };
}
