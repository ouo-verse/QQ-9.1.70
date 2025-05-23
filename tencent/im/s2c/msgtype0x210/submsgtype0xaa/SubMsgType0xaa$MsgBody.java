package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xaa$MsgBody extends MessageMicro<SubMsgType0xaa$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"cmd", "msg_gameTeamMsg", "msg_onlineDocMsg"}, new Object[]{0, null, null}, SubMsgType0xaa$MsgBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public SubMsgType0xaa$GameTeam_MsgBody msg_gameTeamMsg = new MessageMicro<SubMsgType0xaa$GameTeam_MsgBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa$GameTeam_MsgBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_GameTeamCmd", "msg_turnOverMessage", "msg_startGameMessage", "msg_updateTeamMessage"}, new Object[]{0, null, null, null}, SubMsgType0xaa$GameTeam_MsgBody.class);
        public final PBUInt32Field uint32_GameTeamCmd = PBField.initUInt32(0);
        public SubMsgType0xaa$GameTeam_TurnOverMessage msg_turnOverMessage = new MessageMicro<SubMsgType0xaa$GameTeam_TurnOverMessage>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa$GameTeam_TurnOverMessage
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 56, 64, 72, 80, 88, 98, 104, 114}, new String[]{"str_teamId", "uint32_sessionType", "str_sourceUin", "str_actionUin", "actionType", "uint32_currentCount", "uint32_totalCount", "uint64_createMsgTime", "uint32_status", "uint32_expire", "uint64_buildTeamTime", "str_leaderUin", "uin32_leaderStatus", "InviteSourceList"}, new Object[]{"", 0, "", "", 0, 0, 0, 0L, 0, 0, 0L, "", 0, null}, SubMsgType0xaa$GameTeam_TurnOverMessage.class);
            public final PBStringField str_teamId = PBField.initString("");
            public final PBUInt32Field uint32_sessionType = PBField.initUInt32(0);
            public final PBStringField str_sourceUin = PBField.initString("");
            public final PBStringField str_actionUin = PBField.initString("");
            public final PBUInt32Field actionType = PBField.initUInt32(0);
            public final PBUInt32Field uint32_currentCount = PBField.initUInt32(0);
            public final PBUInt32Field uint32_totalCount = PBField.initUInt32(0);
            public final PBUInt64Field uint64_createMsgTime = PBField.initUInt64(0);
            public final PBUInt32Field uint32_status = PBField.initUInt32(0);
            public final PBUInt32Field uint32_expire = PBField.initUInt32(0);
            public final PBUInt64Field uint64_buildTeamTime = PBField.initUInt64(0);
            public final PBStringField str_leaderUin = PBField.initString("");
            public final PBUInt32Field uin32_leaderStatus = PBField.initUInt32(0);
            public final PBRepeatMessageField<SubMsgType0xaa$InviteSource> InviteSourceList = PBField.initRepeatMessage(SubMsgType0xaa$InviteSource.class);
        };
        public SubMsgType0xaa$GameTeam_StartGameMessage msg_startGameMessage = new MessageMicro<SubMsgType0xaa$GameTeam_StartGameMessage>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa$GameTeam_StartGameMessage
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66, 72, 80, 88}, new String[]{"str_gamedata", "uint32_platformType", "str_title", "str_summary", "str_picUrl", "str_appid", "str_appStoreId", "str_packageName", "uint64_createMsgTime", "uint32_expire", "uint64_buildTeamTime"}, new Object[]{"", 0, "", "", "", "", "", "", 0L, 0, 0L}, SubMsgType0xaa$GameTeam_StartGameMessage.class);
            public final PBStringField str_gamedata = PBField.initString("");
            public final PBUInt32Field uint32_platformType = PBField.initUInt32(0);
            public final PBStringField str_title = PBField.initString("");
            public final PBStringField str_summary = PBField.initString("");
            public final PBStringField str_picUrl = PBField.initString("");
            public final PBStringField str_appid = PBField.initString("");
            public final PBStringField str_appStoreId = PBField.initString("");
            public final PBStringField str_packageName = PBField.initString("");
            public final PBUInt64Field uint64_createMsgTime = PBField.initUInt64(0);
            public final PBUInt32Field uint32_expire = PBField.initUInt32(0);
            public final PBUInt64Field uint64_buildTeamTime = PBField.initUInt64(0);
        };
        public SubMsgType0xaa$GameTeam_UpdateTeamMessage msg_updateTeamMessage = new MessageMicro<SubMsgType0xaa$GameTeam_UpdateTeamMessage>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa$GameTeam_UpdateTeamMessage
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 56, 64, 74, 80}, new String[]{"str_teamId", "str_gameId", "uint32_status", "str_modeImg", "uint32_current_count", "uint64_createMsgTime", "uint32_expire", "uint64_buildTeamTime", "str_leaderUin", "uin32_leaderStatus"}, new Object[]{"", "", 0, "", 0, 0L, 0, 0L, "", 0}, SubMsgType0xaa$GameTeam_UpdateTeamMessage.class);
            public final PBStringField str_teamId = PBField.initString("");
            public final PBStringField str_gameId = PBField.initString("");
            public final PBUInt32Field uint32_status = PBField.initUInt32(0);
            public final PBStringField str_modeImg = PBField.initString("");
            public final PBUInt32Field uint32_current_count = PBField.initUInt32(0);
            public final PBUInt64Field uint64_createMsgTime = PBField.initUInt64(0);
            public final PBUInt32Field uint32_expire = PBField.initUInt32(0);
            public final PBUInt64Field uint64_buildTeamTime = PBField.initUInt64(0);
            public final PBStringField str_leaderUin = PBField.initString("");
            public final PBUInt32Field uin32_leaderStatus = PBField.initUInt32(0);
        };
    };
    public SubMsgType0xaa$OnlineDoc_MsgBody msg_onlineDocMsg = new MessageMicro<SubMsgType0xaa$OnlineDoc_MsgBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa$OnlineDoc_MsgBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_OnlineDocCmd", "msg_pushChangeTitleMessage", "msg_pushNewPadMessage", "msg_pushPreviewToEdit"}, new Object[]{0, null, null, null}, SubMsgType0xaa$OnlineDoc_MsgBody.class);
        public final PBUInt32Field uint32_OnlineDocCmd = PBField.initUInt32(0);
        public SubMsgType0xaa$OnlineDoc_PushChangeTitleMessage msg_pushChangeTitleMessage = new MessageMicro<SubMsgType0xaa$OnlineDoc_PushChangeTitleMessage>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa$OnlineDoc_PushChangeTitleMessage
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_last_editor_nick;
            public final PBBytesField bytes_localpadid;
            public final PBBytesField bytes_title;
            public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
            public final PBUInt64Field uint64_last_edit_time;
            public final PBUInt64Field uint64_last_editor_uin;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48}, new String[]{"uint32_domainid", "bytes_localpadid", "bytes_title", "uint64_last_editor_uin", "bytes_last_editor_nick", "uint64_last_edit_time"}, new Object[]{0, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0L}, SubMsgType0xaa$OnlineDoc_PushChangeTitleMessage.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_localpadid = PBField.initBytes(byteStringMicro);
                this.bytes_title = PBField.initBytes(byteStringMicro);
                this.uint64_last_editor_uin = PBField.initUInt64(0L);
                this.bytes_last_editor_nick = PBField.initBytes(byteStringMicro);
                this.uint64_last_edit_time = PBField.initUInt64(0L);
            }
        };
        public SubMsgType0xaa$OnlineDoc_PushNewPadMessage msg_pushNewPadMessage = new MessageMicro<SubMsgType0xaa$OnlineDoc_PushNewPadMessage>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa$OnlineDoc_PushNewPadMessage
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBoolField bool_delete_flag;
            public final PBBoolField bool_pinned_flag;
            public final PBBytesField bytes_creator_nick;
            public final PBBytesField bytes_hostuser_nick;
            public final PBBytesField bytes_last_editor_nick;
            public final PBBytesField bytes_last_viewer_nick;
            public final PBBytesField bytes_localpadid;
            public final PBBytesField bytes_pad_url;
            public final PBBytesField bytes_pdid;
            public final PBBytesField bytes_thumb_url;
            public final PBBytesField bytes_title;
            public final PBUInt32Field uint32_domainid;
            public final PBUInt32Field uint32_policy;
            public final PBUInt32Field uint32_right_flag;
            public final PBUInt32Field uint32_type;
            public final PBUInt64Field uint64_create_time;
            public final PBUInt64Field uint64_creator_uin;
            public final PBUInt64Field uint64_current_user_browse_time;
            public final PBUInt64Field uint64_hostuser_uin;
            public final PBUInt64Field uint64_last_auth_time;
            public final PBUInt64Field uint64_last_delete_time;
            public final PBUInt64Field uint64_last_edit_time;
            public final PBUInt64Field uint64_last_editor_uin;
            public final PBUInt64Field uint64_last_pinned_time;
            public final PBUInt64Field uint64_last_unpinned_time;
            public final PBUInt64Field uint64_last_view_time;
            public final PBUInt64Field uint64_last_viewer_uin;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50, 56, 66, 72, 80, 88, 98, 104, 112, 120, 128, 138, 144, 152, 160, 168, 178, 184, 192, 200, 210, 218}, new String[]{"bytes_pad_url", "uint32_type", "bytes_title", "uint64_create_time", "uint64_creator_uin", "bytes_creator_nick", "uint64_last_editor_uin", "bytes_last_editor_nick", "uint64_last_edit_time", "bool_pinned_flag", "uint64_last_viewer_uin", "bytes_last_viewer_nick", "uint64_last_view_time", "uint64_last_pinned_time", "uint64_current_user_browse_time", "uint64_hostuser_uin", "bytes_hostuser_nick", "uint64_last_auth_time", "uint32_policy", "uint32_right_flag", "uint32_domainid", "bytes_localpadid", "uint64_last_unpinned_time", "bool_delete_flag", "uint64_last_delete_time", "bytes_thumb_url", "bytes_pdid"}, new Object[]{byteStringMicro, 0, byteStringMicro, 0L, 0L, byteStringMicro, 0L, byteStringMicro, 0L, bool, 0L, byteStringMicro, 0L, 0L, 0L, 0L, byteStringMicro, 0L, 0, 0, 0, byteStringMicro, 0L, bool, 0L, byteStringMicro, byteStringMicro}, SubMsgType0xaa$OnlineDoc_PushNewPadMessage.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_pad_url = PBField.initBytes(byteStringMicro);
                this.uint32_type = PBField.initUInt32(0);
                this.bytes_title = PBField.initBytes(byteStringMicro);
                this.uint64_create_time = PBField.initUInt64(0L);
                this.uint64_creator_uin = PBField.initUInt64(0L);
                this.bytes_creator_nick = PBField.initBytes(byteStringMicro);
                this.uint64_last_editor_uin = PBField.initUInt64(0L);
                this.bytes_last_editor_nick = PBField.initBytes(byteStringMicro);
                this.uint64_last_edit_time = PBField.initUInt64(0L);
                this.bool_pinned_flag = PBField.initBool(false);
                this.uint64_last_viewer_uin = PBField.initUInt64(0L);
                this.bytes_last_viewer_nick = PBField.initBytes(byteStringMicro);
                this.uint64_last_view_time = PBField.initUInt64(0L);
                this.uint64_last_pinned_time = PBField.initUInt64(0L);
                this.uint64_current_user_browse_time = PBField.initUInt64(0L);
                this.uint64_hostuser_uin = PBField.initUInt64(0L);
                this.bytes_hostuser_nick = PBField.initBytes(byteStringMicro);
                this.uint64_last_auth_time = PBField.initUInt64(0L);
                this.uint32_policy = PBField.initUInt32(0);
                this.uint32_right_flag = PBField.initUInt32(0);
                this.uint32_domainid = PBField.initUInt32(0);
                this.bytes_localpadid = PBField.initBytes(byteStringMicro);
                this.uint64_last_unpinned_time = PBField.initUInt64(0L);
                this.bool_delete_flag = PBField.initBool(false);
                this.uint64_last_delete_time = PBField.initUInt64(0L);
                this.bytes_thumb_url = PBField.initBytes(byteStringMicro);
                this.bytes_pdid = PBField.initBytes(byteStringMicro);
            }
        };
        public SubMsgType0xaa$OnlineDoc_PushPreviewToEditMessage msg_pushPreviewToEdit = new MessageMicro<SubMsgType0xaa$OnlineDoc_PushPreviewToEditMessage>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa$OnlineDoc_PushPreviewToEditMessage
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_aio_session;
            public final PBBytesField bytes_pad_url;
            public final PBBytesField bytes_title;
            public final PBUInt32Field uint32_version = PBField.initUInt32(0);

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_version", "bytes_title", "bytes_pad_url", "bytes_aio_session"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro}, SubMsgType0xaa$OnlineDoc_PushPreviewToEditMessage.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_title = PBField.initBytes(byteStringMicro);
                this.bytes_pad_url = PBField.initBytes(byteStringMicro);
                this.bytes_aio_session = PBField.initBytes(byteStringMicro);
            }
        };
    };
}
