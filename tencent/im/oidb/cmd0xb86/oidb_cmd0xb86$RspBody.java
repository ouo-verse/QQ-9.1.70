package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb86$RspBody extends MessageMicro<oidb_cmd0xb86$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 82}, new String[]{"msg_user_info", "msg_modify_flag", "str_notify"}, new Object[]{null, null, ""}, oidb_cmd0xb86$RspBody.class);
    public oidb_cmd0xb86$UserInfo msg_user_info = new MessageMicro<oidb_cmd0xb86$UserInfo>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$UserInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_3t_bid;
        public final PBBytesField bytes_desc;
        public final PBBytesField bytes_nick;
        public oidb_cmd0xb86$UserInfoDetail info_detail;
        public oidb_cmd0xb86$ExamineUserInfo msg_examine_userinfo;
        public oidb_cmd0xb86$HeadInfo msg_head;
        public final PBUInt32Field uint32_cc_account_level;
        public final PBUInt32Field uint32_disable_comment_recommed;
        public final PBUInt32Field uint32_home_page_type;
        public final PBUInt32Field uint32_mp_auth;
        public final PBUInt32Field uint32_unowned_user;
        public final PBUInt32Field uint32_upgc_flag;
        public final PBUInt32Field uint32_user_type;
        public final PBUInt64Field uint64_bind_uin;
        public final PBUInt64Field uint64_id_create_time;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 66, 72, 96, 106, 122, 128, 136, 1624}, new String[]{"bytes_nick", "msg_head", "bytes_desc", "uint64_bind_uin", "uint32_user_type", "uint32_mp_auth", "uint64_id_create_time", "bytes_3t_bid", "uint32_home_page_type", "uint32_cc_account_level", "msg_examine_userinfo", "info_detail", "uint32_unowned_user", "uint32_disable_comment_recommed", "uint32_upgc_flag"}, new Object[]{byteStringMicro, null, byteStringMicro, 0L, 0, 0, 0L, byteStringMicro, 0, 0, null, null, 0, 0, 0}, oidb_cmd0xb86$UserInfo.class);
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$ExamineUserInfo] */
        /* JADX WARN: Type inference failed for: r0v7, types: [tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$UserInfoDetail] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_nick = PBField.initBytes(byteStringMicro);
            this.msg_head = new oidb_cmd0xb86$HeadInfo();
            this.bytes_desc = PBField.initBytes(byteStringMicro);
            this.uint64_bind_uin = PBField.initUInt64(0L);
            this.uint32_user_type = PBField.initUInt32(0);
            this.uint32_mp_auth = PBField.initUInt32(0);
            this.uint64_id_create_time = PBField.initUInt64(0L);
            this.bytes_3t_bid = PBField.initBytes(byteStringMicro);
            this.uint32_home_page_type = PBField.initUInt32(0);
            this.uint32_cc_account_level = PBField.initUInt32(0);
            this.uint32_unowned_user = PBField.initUInt32(0);
            this.uint32_disable_comment_recommed = PBField.initUInt32(0);
            this.msg_examine_userinfo = new MessageMicro<oidb_cmd0xb86$ExamineUserInfo>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$ExamineUserInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_nick", "msg_head", "msg_desc"}, new Object[]{null, null, null}, oidb_cmd0xb86$ExamineUserInfo.class);
                public oidb_cmd0xb86$ExamineNick msg_nick = new oidb_cmd0xb86$ExamineNick();
                public oidb_cmd0xb86$ExamineHead msg_head = new oidb_cmd0xb86$ExamineHead();
                public oidb_cmd0xb86$ExamineDesc msg_desc = new oidb_cmd0xb86$ExamineDesc();
            };
            this.info_detail = new MessageMicro<oidb_cmd0xb86$UserInfoDetail>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$UserInfoDetail
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"nick", "head", "desc", "bg_pic"}, new Object[]{null, null, null, null}, oidb_cmd0xb86$UserInfoDetail.class);
                public oidb_cmd0xb86$NickInfo nick = new MessageMicro<oidb_cmd0xb86$NickInfo>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$NickInfo
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 104}, new String[]{"str_nick", "uint64_timestamp"}, new Object[]{"", 0L}, oidb_cmd0xb86$NickInfo.class);
                    public final PBStringField str_nick = PBField.initString("");
                    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
                };
                public oidb_cmd0xb86$HeadInfo head = new oidb_cmd0xb86$HeadInfo();
                public oidb_cmd0xb86$DescInfo desc = new MessageMicro<oidb_cmd0xb86$DescInfo>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$DescInfo
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 104}, new String[]{"str_desc", "uint64_timestamp"}, new Object[]{"", 0L}, oidb_cmd0xb86$DescInfo.class);
                    public final PBStringField str_desc = PBField.initString("");
                    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
                };
                public oidb_cmd0xb86$BgPicInfo bg_pic = new MessageMicro<oidb_cmd0xb86$BgPicInfo>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$BgPicInfo
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 104}, new String[]{"str_bg_pic", "uint64_timestamp"}, new Object[]{"", 0L}, oidb_cmd0xb86$BgPicInfo.class);
                    public final PBStringField str_bg_pic = PBField.initString("");
                    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
                };
            };
            this.uint32_upgc_flag = PBField.initUInt32(0);
        }
    };
    public oidb_cmd0xb86$UserInfoModifyFlag msg_modify_flag = new MessageMicro<oidb_cmd0xb86$UserInfoModifyFlag>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$UserInfoModifyFlag
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"msg_nick_flag", "msg_head_flag", "msg_desc_flag", "msg_bg_pic_flag"}, new Object[]{null, null, null, null}, oidb_cmd0xb86$UserInfoModifyFlag.class);
        public oidb_cmd0xb86$ModifyInfoFlag msg_nick_flag = new MessageMicro<oidb_cmd0xb86$ModifyInfoFlag>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$ModifyInfoFlag
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"int32_flag", "str_msg", "uint32_count", "uint64_remain_second"}, new Object[]{0, "", 0, 0L}, oidb_cmd0xb86$ModifyInfoFlag.class);
            public final PBInt32Field int32_flag = PBField.initInt32(0);
            public final PBStringField str_msg = PBField.initString("");
            public final PBUInt32Field uint32_count = PBField.initUInt32(0);
            public final PBUInt64Field uint64_remain_second = PBField.initUInt64(0);
        };
        public oidb_cmd0xb86$ModifyInfoFlag msg_head_flag = new MessageMicro<oidb_cmd0xb86$ModifyInfoFlag>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$ModifyInfoFlag
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"int32_flag", "str_msg", "uint32_count", "uint64_remain_second"}, new Object[]{0, "", 0, 0L}, oidb_cmd0xb86$ModifyInfoFlag.class);
            public final PBInt32Field int32_flag = PBField.initInt32(0);
            public final PBStringField str_msg = PBField.initString("");
            public final PBUInt32Field uint32_count = PBField.initUInt32(0);
            public final PBUInt64Field uint64_remain_second = PBField.initUInt64(0);
        };
        public oidb_cmd0xb86$ModifyInfoFlag msg_desc_flag = new MessageMicro<oidb_cmd0xb86$ModifyInfoFlag>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$ModifyInfoFlag
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"int32_flag", "str_msg", "uint32_count", "uint64_remain_second"}, new Object[]{0, "", 0, 0L}, oidb_cmd0xb86$ModifyInfoFlag.class);
            public final PBInt32Field int32_flag = PBField.initInt32(0);
            public final PBStringField str_msg = PBField.initString("");
            public final PBUInt32Field uint32_count = PBField.initUInt32(0);
            public final PBUInt64Field uint64_remain_second = PBField.initUInt64(0);
        };
        public oidb_cmd0xb86$ModifyInfoFlag msg_bg_pic_flag = new MessageMicro<oidb_cmd0xb86$ModifyInfoFlag>() { // from class: tencent.im.oidb.cmd0xb86.oidb_cmd0xb86$ModifyInfoFlag
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"int32_flag", "str_msg", "uint32_count", "uint64_remain_second"}, new Object[]{0, "", 0, 0L}, oidb_cmd0xb86$ModifyInfoFlag.class);
            public final PBInt32Field int32_flag = PBField.initInt32(0);
            public final PBStringField str_msg = PBField.initString("");
            public final PBUInt32Field uint32_count = PBField.initUInt32(0);
            public final PBUInt64Field uint64_remain_second = PBField.initUInt64(0);
        };
    };
    public final PBStringField str_notify = PBField.initString("");
}
