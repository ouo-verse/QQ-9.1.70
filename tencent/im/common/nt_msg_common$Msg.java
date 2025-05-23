package tencent.im.common;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import tencent.im.msg.nt_im_msg_body$MsgBody;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_msg_common$Msg extends MessageMicro<nt_msg_common$Msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"head", "ctrl_head", "body", "ext_info", "msg_core"}, new Object[]{null, null, null, null, null}, nt_msg_common$Msg.class);
    public nt_msg_common$MsgHead head = new nt_msg_common$MsgHead();
    public nt_msg_common$MsgCtrlHead ctrl_head = new MessageMicro<nt_msg_common$MsgCtrlHead>() { // from class: tencent.im.common.nt_msg_common$MsgCtrlHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 74, 80, 88, 96, 104, 112, 128, 138}, new String[]{"include_uin", "exclude_uin", "rpt_featureid", "offline_flag", "visibility", "ctrl_flag", LinkReportConstant$GlobalKey.EVENTS, "level", "personal_levels", "guild_sync_seq", "member_num", "channel_type", "private_type", "feature_action", "channel_visible_type", "s2c_msg_info"}, new Object[]{0L, 0L, 0L, 0, 0, 0L, null, 0L, null, 0L, 0, 0, 0, 0, 0, null}, nt_msg_common$MsgCtrlHead.class);
        public final PBUInt32Field channel_type;
        public final PBUInt32Field channel_visible_type;
        public final PBUInt64Field ctrl_flag;
        public final PBRepeatMessageField<nt_msg_common$Event> events;
        public final PBRepeatField<Long> exclude_uin;
        public final PBUInt32Field feature_action;
        public final PBUInt64Field guild_sync_seq;
        public final PBRepeatField<Long> include_uin;
        public final PBUInt64Field level;
        public final PBUInt32Field member_num;
        public final PBUInt32Field offline_flag;
        public final PBRepeatMessageField<nt_msg_common$PersonalLevel> personal_levels;
        public final PBUInt32Field private_type;
        public final PBRepeatField<Long> rpt_featureid;
        public nt_msg_common$S2CMsgInfo s2c_msg_info;
        public final PBUInt32Field visibility;

        {
            PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
            this.include_uin = PBField.initRepeat(pBUInt64Field);
            this.exclude_uin = PBField.initRepeat(pBUInt64Field);
            this.rpt_featureid = PBField.initRepeat(pBUInt64Field);
            this.offline_flag = PBField.initUInt32(0);
            this.visibility = PBField.initUInt32(0);
            this.ctrl_flag = PBField.initUInt64(0L);
            this.events = PBField.initRepeatMessage(nt_msg_common$Event.class);
            this.level = PBField.initUInt64(0L);
            this.personal_levels = PBField.initRepeatMessage(nt_msg_common$PersonalLevel.class);
            this.guild_sync_seq = PBField.initUInt64(0L);
            this.member_num = PBField.initUInt32(0);
            this.channel_type = PBField.initUInt32(0);
            this.private_type = PBField.initUInt32(0);
            this.feature_action = PBField.initUInt32(0);
            this.channel_visible_type = PBField.initUInt32(0);
            this.s2c_msg_info = new nt_msg_common$S2CMsgInfo();
        }
    };
    public nt_im_msg_body$MsgBody body = new nt_im_msg_body$MsgBody();
    public nt_msg_common$ExtInfo ext_info = new MessageMicro<nt_msg_common$ExtInfo>() { // from class: tencent.im.common.nt_msg_common$ExtInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_member_name;
        public final PBUInt64Field channel_create_time;
        public final PBBytesField channel_name;
        public final PBRepeatMessageField<nt_msg_common$DirectMessageMember> direct_message_member;
        public final PBUInt64Field event_version;
        public final PBRepeatMessageField<nt_msg_common$Event> events;
        public nt_msg_common$FreqLimitInfo freq_limit_info;
        public final PBBytesField from_avatar;
        public nt_msg_common$Role from_channel_role_info;
        public nt_msg_common$Role from_guild_role_info;
        public final PBBytesField from_nick;
        public nt_msg_common$Role from_role_info;
        public final PBBytesField guild_name;
        public final PBUInt32Field name_type;
        public final PBUInt32Field notify_type;
        public final PBUInt32Field offline_flag;
        public final PBUInt32Field role_type;
        public nt_msg_common$S2CMsgInfo s2c_msg_info;
        public final PBUInt32Field uint32_timestamp;
        public final PBUInt32Field visibility;

        static {
            String[] strArr = {"from_nick", "guild_name", "channel_name", "visibility", "notify_type", "offline_flag", "name_type", "bytes_member_name", "uint32_timestamp", "event_version", LinkReportConstant$GlobalKey.EVENTS, "from_role_info", "freq_limit_info", "direct_message_member", "from_avatar", "s2c_msg_info", "channel_create_time", "role_type", "from_channel_role_info", "from_guild_role_info"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 66, 72, 80, 90, 98, 106, 114, 122, 130, 136, 144, 154, 162}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0, 0L, null, null, null, null, byteStringMicro, null, 0L, 0, null, null}, nt_msg_common$ExtInfo.class);
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.common.nt_msg_common$Role] */
        /* JADX WARN: Type inference failed for: r0v6, types: [tencent.im.common.nt_msg_common$Role] */
        /* JADX WARN: Type inference failed for: r4v3, types: [tencent.im.common.nt_msg_common$Role] */
        /* JADX WARN: Type inference failed for: r4v4, types: [tencent.im.common.nt_msg_common$FreqLimitInfo] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.from_nick = PBField.initBytes(byteStringMicro);
            this.guild_name = PBField.initBytes(byteStringMicro);
            this.channel_name = PBField.initBytes(byteStringMicro);
            this.visibility = PBField.initUInt32(0);
            this.notify_type = PBField.initUInt32(0);
            this.offline_flag = PBField.initUInt32(0);
            this.name_type = PBField.initUInt32(0);
            this.bytes_member_name = PBField.initBytes(byteStringMicro);
            this.uint32_timestamp = PBField.initUInt32(0);
            this.event_version = PBField.initUInt64(0L);
            this.events = PBField.initRepeatMessage(nt_msg_common$Event.class);
            this.from_role_info = new MessageMicro<nt_msg_common$Role>() { // from class: tencent.im.common.nt_msg_common$Role
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "info", "flag"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, nt_msg_common$Role.class);

                /* renamed from: id, reason: collision with root package name */
                public final PBUInt64Field f435936id = PBField.initUInt64(0);
                public final PBBytesField info = PBField.initBytes(ByteStringMicro.EMPTY);
                public final PBUInt32Field flag = PBField.initUInt32(0);
            };
            this.freq_limit_info = new MessageMicro<nt_msg_common$FreqLimitInfo>() { // from class: tencent.im.common.nt_msg_common$FreqLimitInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"is_limited", "left_count", "limit_timestamp"}, new Object[]{0, 0, 0L}, nt_msg_common$FreqLimitInfo.class);
                public final PBUInt32Field is_limited = PBField.initUInt32(0);
                public final PBUInt32Field left_count = PBField.initUInt32(0);
                public final PBUInt64Field limit_timestamp = PBField.initUInt64(0);
            };
            this.direct_message_member = PBField.initRepeatMessage(nt_msg_common$DirectMessageMember.class);
            this.from_avatar = PBField.initBytes(byteStringMicro);
            this.s2c_msg_info = new nt_msg_common$S2CMsgInfo();
            this.channel_create_time = PBField.initUInt64(0L);
            this.role_type = PBField.initUInt32(0);
            this.from_channel_role_info = new MessageMicro<nt_msg_common$Role>() { // from class: tencent.im.common.nt_msg_common$Role
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "info", "flag"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, nt_msg_common$Role.class);

                /* renamed from: id, reason: collision with root package name */
                public final PBUInt64Field f435936id = PBField.initUInt64(0);
                public final PBBytesField info = PBField.initBytes(ByteStringMicro.EMPTY);
                public final PBUInt32Field flag = PBField.initUInt32(0);
            };
            this.from_guild_role_info = new MessageMicro<nt_msg_common$Role>() { // from class: tencent.im.common.nt_msg_common$Role
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "info", "flag"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, nt_msg_common$Role.class);

                /* renamed from: id, reason: collision with root package name */
                public final PBUInt64Field f435936id = PBField.initUInt64(0);
                public final PBBytesField info = PBField.initBytes(ByteStringMicro.EMPTY);
                public final PBUInt32Field flag = PBField.initUInt32(0);
            };
        }
    };
    public nt_msg_common$MsgCoreInfo msg_core = new MessageMicro<nt_msg_common$MsgCoreInfo>() { // from class: tencent.im.common.nt_msg_common$MsgCoreInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField msg_meta;
        public final PBBytesField token;
        public final PBUInt64Field guild_id = PBField.initUInt64(0);
        public final PBUInt64Field channel_id = PBField.initUInt64(0);
        public final PBUInt64Field msg_seq = PBField.initUInt64(0);
        public final PBUInt64Field cnt_seq = PBField.initUInt64(0);
        public final PBUInt64Field msg_time = PBField.initUInt64(0);

        static {
            String[] strArr = {"guild_id", "channel_id", "msg_seq", "cnt_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "msg_meta", "token"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 802}, strArr, new Object[]{0L, 0L, 0L, 0L, 0L, byteStringMicro, byteStringMicro}, nt_msg_common$MsgCoreInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.msg_meta = PBField.initBytes(byteStringMicro);
            this.token = PBField.initBytes(byteStringMicro);
        }
    };
}
