package tencent.mobileim.structmsg;

import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.luggage.wxa.xd.m0;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$SystemMsg extends MessageMicro<structmsg$SystemMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField action_uin_nick;
    public final PBBytesField action_uin_qq_nick;
    public final PBBytesField action_uin_remark;
    public final PBStringField actor_uin_nick;
    public final PBBytesField bytes_addtion;
    public final PBBytesField bytes_game_msg;
    public final PBBytesField bytes_game_nick;
    public final PBBytesField bytes_group_trans_info;
    public final PBBytesField bytes_name_more;
    public final PBBytesField bytes_source_desc;
    public final PBBytesField bytes_transparent_group_notify;
    public final PBBytesField bytes_warning_tips;
    public final PBUInt32Field card_switch;
    public final PBStringField clone_uin_nick;
    public final PBBytesField eim_group_id_name;
    public final PBUInt32Field group_ext_flag;
    public final PBStringField group_name;
    public final PBStringField msg_detail;
    public final PBStringField msg_qna;
    public final PBBytesField pic_url;
    public final PBUInt32Field req_uin_age;
    public final PBBytesField req_uin_business_card;
    public final PBInt32Field req_uin_faceid;
    public final PBUInt32Field req_uin_gender;
    public final PBStringField req_uin_nick;
    public final PBBytesField req_uin_pre_remark;
    public final PBStringField uid;
    public final PBUInt32Field uint32_c2c_invite_join_group_flag;
    public final PBUInt32Field uint32_doubt_flag;
    public final PBUInt32Field uint32_group_flagext3;
    public final PBUInt64Field uint64_group_owner_uin;
    public final PBUInt32Field sub_type = PBField.initUInt32(0);
    public final PBStringField msg_title = PBField.initString("");
    public final PBStringField msg_describe = PBField.initString("");
    public final PBStringField msg_additional = PBField.initString("");
    public final PBStringField msg_source = PBField.initString("");
    public final PBStringField msg_decided = PBField.initString("");
    public final PBUInt32Field src_id = PBField.initUInt32(0);
    public final PBUInt32Field sub_src_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<structmsg$SystemMsgAction> actions = PBField.initRepeatMessage(structmsg$SystemMsgAction.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field action_uin = PBField.initUInt64(0);
    public final PBUInt32Field group_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field group_inviter_role = PBField.initUInt32(0);
    public structmsg$FriendInfo friend_info = new structmsg$FriendInfo();
    public structmsg$GroupInfo group_info = new MessageMicro<structmsg$GroupInfo>() { // from class: tencent.mobileim.structmsg.structmsg$GroupInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48}, new String[]{"group_auth_type", "display_action", "msg_alert", "msg_detail_alert", "msg_other_admin_done", "uint32_app_privilege_flag"}, new Object[]{0, 0, "", "", "", 0}, structmsg$GroupInfo.class);
        public final PBUInt32Field group_auth_type = PBField.initUInt32(0);
        public final PBUInt32Field display_action = PBField.initUInt32(0);
        public final PBStringField msg_alert = PBField.initString("");
        public final PBStringField msg_detail_alert = PBField.initString("");
        public final PBStringField msg_other_admin_done = PBField.initString("");
        public final PBUInt32Field uint32_app_privilege_flag = PBField.initUInt32(0);
    };
    public final PBUInt64Field actor_uin = PBField.initUInt64(0);
    public final PBStringField msg_actor_describe = PBField.initString("");
    public final PBStringField msg_additional_list = PBField.initString("");
    public final PBUInt32Field relation = PBField.initUInt32(0);
    public final PBUInt32Field reqsubtype = PBField.initUInt32(0);
    public final PBUInt64Field clone_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_eim_group_id = PBField.initUInt64(0);
    public structmsg$MsgInviteExt msg_invite_extinfo = new MessageMicro<structmsg$MsgInviteExt>() { // from class: tencent.mobileim.structmsg.structmsg$MsgInviteExt
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_src_type", "uint64_src_code", "uint32_wait_state"}, new Object[]{0, 0L, 0}, structmsg$MsgInviteExt.class);
        public final PBUInt32Field uint32_src_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_src_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_wait_state = PBField.initUInt32(0);
    };
    public structmsg$MsgPayGroupExt msg_pay_group_extinfo = new MessageMicro<structmsg$MsgPayGroupExt>() { // from class: tencent.mobileim.structmsg.structmsg$MsgPayGroupExt
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_join_grp_time", "uint64_quit_grp_time"}, new Object[]{0L, 0L}, structmsg$MsgPayGroupExt.class);
        public final PBUInt64Field uint64_join_grp_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_quit_grp_time = PBField.initUInt64(0);
    };
    public final PBUInt32Field uint32_source_flag = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 64, 74, 80, 88, 96, 104, 114, 122, 128, 138, 146, 152, 160, 168, 176, 184, 194, 202, 208, 218, 226, 232, 240, 248, 258, 266, 274, FilterEnum.MIC_PTU_BAIXI, 400, 410, 418, PlayUI.UIType.BIG_CARD_SHAPED_PIC, 434, 442, QFSNumberConstants.Int.NUM_456, m0.CTRL_INDEX, 474, 482, P2VGlobalConfig.WATER_MARKER_WIDTH, 506, 514, 522, 530, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE, 552, 808, 866, 882, 898}, new String[]{"sub_type", "msg_title", "msg_describe", "msg_additional", "msg_source", "msg_decided", "src_id", "sub_src_id", "actions", "group_code", "action_uin", "group_msg_type", "group_inviter_role", "friend_info", "group_info", "actor_uin", "msg_actor_describe", "msg_additional_list", "relation", "reqsubtype", "clone_uin", "uint64_discuss_uin", "uint64_eim_group_id", "msg_invite_extinfo", "msg_pay_group_extinfo", "uint32_source_flag", "bytes_game_nick", "bytes_game_msg", "uint32_group_flagext3", "uint64_group_owner_uin", "uint32_doubt_flag", "bytes_warning_tips", "bytes_name_more", "bytes_addtion", "bytes_transparent_group_notify", "req_uin_faceid", "req_uin_nick", "group_name", "action_uin_nick", "msg_qna", "msg_detail", "group_ext_flag", "actor_uin_nick", "pic_url", "clone_uin_nick", "req_uin_business_card", "eim_group_id_name", "req_uin_pre_remark", "action_uin_qq_nick", "action_uin_remark", "req_uin_gender", "req_uin_age", "uint32_c2c_invite_join_group_flag", "card_switch", "bytes_source_desc", "uid", "bytes_group_trans_info"}, new Object[]{0, "", "", "", "", "", 0, 0, null, 0L, 0L, 0, 0, null, null, 0L, "", "", 0, 0, 0L, 0L, 0L, null, null, 0, byteStringMicro, byteStringMicro, 0, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, "", "", "", "", "", 0, "", byteStringMicro, "", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro, "", byteStringMicro}, structmsg$SystemMsg.class);
    }

    /* JADX WARN: Type inference failed for: r4v14, types: [tencent.mobileim.structmsg.structmsg$MsgInviteExt] */
    /* JADX WARN: Type inference failed for: r4v15, types: [tencent.mobileim.structmsg.structmsg$MsgPayGroupExt] */
    /* JADX WARN: Type inference failed for: r4v5, types: [tencent.mobileim.structmsg.structmsg$GroupInfo] */
    public structmsg$SystemMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_game_nick = PBField.initBytes(byteStringMicro);
        this.bytes_game_msg = PBField.initBytes(byteStringMicro);
        this.uint32_group_flagext3 = PBField.initUInt32(0);
        this.uint64_group_owner_uin = PBField.initUInt64(0L);
        this.uint32_doubt_flag = PBField.initUInt32(0);
        this.bytes_warning_tips = PBField.initBytes(byteStringMicro);
        this.bytes_name_more = PBField.initBytes(byteStringMicro);
        this.bytes_addtion = PBField.initBytes(byteStringMicro);
        this.bytes_transparent_group_notify = PBField.initBytes(byteStringMicro);
        this.req_uin_faceid = PBField.initInt32(0);
        this.req_uin_nick = PBField.initString("");
        this.group_name = PBField.initString("");
        this.action_uin_nick = PBField.initString("");
        this.msg_qna = PBField.initString("");
        this.msg_detail = PBField.initString("");
        this.group_ext_flag = PBField.initUInt32(0);
        this.actor_uin_nick = PBField.initString("");
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.clone_uin_nick = PBField.initString("");
        this.req_uin_business_card = PBField.initBytes(byteStringMicro);
        this.eim_group_id_name = PBField.initBytes(byteStringMicro);
        this.req_uin_pre_remark = PBField.initBytes(byteStringMicro);
        this.action_uin_qq_nick = PBField.initBytes(byteStringMicro);
        this.action_uin_remark = PBField.initBytes(byteStringMicro);
        this.req_uin_gender = PBField.initUInt32(0);
        this.req_uin_age = PBField.initUInt32(0);
        this.uint32_c2c_invite_join_group_flag = PBField.initUInt32(0);
        this.card_switch = PBField.initUInt32(0);
        this.bytes_source_desc = PBField.initBytes(byteStringMicro);
        this.uid = PBField.initString("");
        this.bytes_group_trans_info = PBField.initBytes(byteStringMicro);
    }
}
