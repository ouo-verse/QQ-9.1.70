package trpc.qq_vgame.nofity;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.view.FilterEnum;
import trpc.qq_vgame.common.AvGameCommon$GameInfo;
import trpc.qq_vgame.common.AvGameCommon$GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon$GameStatusInfo;
import trpc.qq_vgame.common.AvGameCommon$PKUserRankInfo;
import trpc.qq_vgame.common.AvGameCommon$RoomInfo;
import trpc.qq_vgame.common.AvGameCommon$RoomUserInfo;
import trpc.qq_vgame.common.AvGameCommon$UinWrap;
import trpc.qq_vgame.common.AvGameCommon$UserAnswerInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameNotify$NotifyMsg extends MessageMicro<AvGameNotify$NotifyMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 136, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218, 226, 234, 242, 248, 256, 266, 274, FilterEnum.MIC_PTU_BAIXI, 288, 298}, new String[]{"seq", "type", "room_user_enter_req", "room_user_exit_req", "room_destory_req", "room_user_change_status_req", "status_info", "change_game_req", "start_game_req", "answer_right_req", "question_timeout_req", "change_question_req", "next_actor_tips_req", "change_actor_req", "actor_giveout_answer_req", "game_over_req", "roomid", "play_game_id", "translate_info_req", "match_user_enter_room", "match_user_create_room", "room_match_status", "pk_user_create_room", "pk_user_enter_room", "pk_user_succ", "pk_user_final_succ", "pk_user_fail", "pk_user_pass", "pk_callin_user_too_few", "pk_user_draw", "pkID", "poolID", "pk_pool_user_change", "match_v2_user_enter_room", "match_v2_user_create_room", "realPoolID", "answer_finish_req"}, new Object[]{0L, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, "", null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, null, 0, null}, AvGameNotify$NotifyMsg.class);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBEnumField type = PBField.initEnum(0);
    public AvGameNotify$RoomUserEnterS2CReq room_user_enter_req = new MessageMicro<AvGameNotify$RoomUserEnterS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$RoomUserEnterS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{AegisLogger.ROOM_INFO, "type", "enter_uin", "inviter_uin"}, new Object[]{null, 0, 0L, 0L}, AvGameNotify$RoomUserEnterS2CReq.class);
        public AvGameCommon$RoomInfo room_info = new AvGameCommon$RoomInfo();
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBUInt64Field enter_uin = PBField.initUInt64(0);
        public final PBUInt64Field inviter_uin = PBField.initUInt64(0);
    };
    public AvGameNotify$RoomUserExitS2CReq room_user_exit_req = new MessageMicro<AvGameNotify$RoomUserExitS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$RoomUserExitS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 32, 40, 48, 56, 66, 74}, new String[]{"exit_reason", AegisLogger.ROOM_INFO, "exit_uin", "new_owner_uin", "heartbeat_timeout", "sub_reason", "onwer_tip", "exiter_tip"}, new Object[]{0, null, 0L, 0L, 0, 0, "", ""}, AvGameNotify$RoomUserExitS2CReq.class);
        public final PBUInt32Field exit_reason = PBField.initUInt32(0);
        public AvGameCommon$RoomInfo room_info = new AvGameCommon$RoomInfo();
        public final PBUInt64Field exit_uin = PBField.initUInt64(0);
        public final PBUInt64Field new_owner_uin = PBField.initUInt64(0);
        public final PBUInt32Field heartbeat_timeout = PBField.initUInt32(0);
        public final PBUInt32Field sub_reason = PBField.initUInt32(0);
        public final PBStringField onwer_tip = PBField.initString("");
        public final PBStringField exiter_tip = PBField.initString("");
    };
    public AvGameNotify$RoomDestoryS2CReq room_destory_req = new MessageMicro<AvGameNotify$RoomDestoryS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$RoomDestoryS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AvGameNotify$RoomDestoryS2CReq.class);
    };
    public AvGameNotify$RoomUserChangeStatusS2CReq room_user_change_status_req = new MessageMicro<AvGameNotify$RoomUserChangeStatusS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$RoomUserChangeStatusS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uin", "user_status", AegisLogger.ROOM_INFO}, new Object[]{0L, 0, null}, AvGameNotify$RoomUserChangeStatusS2CReq.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBEnumField user_status = PBField.initEnum(0);
        public AvGameCommon$RoomInfo room_info = new AvGameCommon$RoomInfo();
    };
    public AvGameCommon$GameStatusInfo status_info = new AvGameCommon$GameStatusInfo();
    public AvGameNotify$RoomOwnerChangeGameS2CReq change_game_req = new MessageMicro<AvGameNotify$RoomOwnerChangeGameS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$RoomOwnerChangeGameS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"game_type"}, new Object[]{0}, AvGameNotify$RoomOwnerChangeGameS2CReq.class);
        public final PBEnumField game_type = PBField.initEnum(0);
    };
    public AvGameNotify$RoomOwnerStartGameS2CReq start_game_req = new MessageMicro<AvGameNotify$RoomOwnerStartGameS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$RoomOwnerStartGameS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"actor_info", "question_info", "game_info", "question_class"}, new Object[]{null, null, null, ""}, AvGameNotify$RoomOwnerStartGameS2CReq.class);
        public AvGameCommon$RoomUserInfo actor_info = new AvGameCommon$RoomUserInfo();
        public AvGameCommon$GameQuestionInfo question_info = new AvGameCommon$GameQuestionInfo();
        public AvGameCommon$GameInfo game_info = new AvGameCommon$GameInfo();
        public final PBStringField question_class = PBField.initString("");
    };
    public AvGameNotify$NotifyAnswerRightS2CReq answer_right_req = new MessageMicro<AvGameNotify$NotifyAnswerRightS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyAnswerRightS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58}, new String[]{"actor_info", "question_info", LocalPhotoFaceInfo.SCORE, "actor_score", "actor_uin", "continue_correct_num", "user_answer_info"}, new Object[]{null, null, 0, 0, 0L, 0L, null}, AvGameNotify$NotifyAnswerRightS2CReq.class);
        public AvGameCommon$RoomUserInfo actor_info = new AvGameCommon$RoomUserInfo();
        public AvGameCommon$GameQuestionInfo question_info = new AvGameCommon$GameQuestionInfo();
        public final PBUInt32Field score = PBField.initUInt32(0);
        public final PBUInt32Field actor_score = PBField.initUInt32(0);
        public final PBUInt64Field actor_uin = PBField.initUInt64(0);
        public final PBUInt64Field continue_correct_num = PBField.initUInt64(0);
        public AvGameCommon$UserAnswerInfo user_answer_info = new MessageMicro<AvGameCommon$UserAnswerInfo>() { // from class: trpc.qq_vgame.common.AvGameCommon$UserAnswerInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "answer_result", "answer_index"}, new Object[]{0L, 0, 0}, AvGameCommon$UserAnswerInfo.class);
            public final PBUInt64Field uin = PBField.initUInt64(0);
            public final PBUInt32Field answer_result = PBField.initUInt32(0);
            public final PBUInt32Field answer_index = PBField.initUInt32(0);
        };
    };
    public AvGameNotify$NotifyQuestionTimeoutS2CReq question_timeout_req = new MessageMicro<AvGameNotify$NotifyQuestionTimeoutS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyQuestionTimeoutS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"question_info"}, new Object[]{null}, AvGameNotify$NotifyQuestionTimeoutS2CReq.class);
        public AvGameCommon$GameQuestionInfo question_info = new AvGameCommon$GameQuestionInfo();
    };
    public AvGameNotify$NotifyChangeQuestionS2CReq change_question_req = new MessageMicro<AvGameNotify$NotifyChangeQuestionS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyChangeQuestionS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"question_info", "switcher_uin"}, new Object[]{null, 0L}, AvGameNotify$NotifyChangeQuestionS2CReq.class);
        public AvGameCommon$GameQuestionInfo question_info = new AvGameCommon$GameQuestionInfo();
        public final PBUInt64Field switcher_uin = PBField.initUInt64(0);
    };
    public AvGameNotify$NotifyNextActorTipsS2CReq next_actor_tips_req = new MessageMicro<AvGameNotify$NotifyNextActorTipsS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyNextActorTipsS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"tips", "actor_info"}, new Object[]{"", null}, AvGameNotify$NotifyNextActorTipsS2CReq.class);
        public final PBStringField tips = PBField.initString("");
        public AvGameCommon$RoomUserInfo actor_info = new AvGameCommon$RoomUserInfo();
    };
    public AvGameNotify$NotifyChangeActorS2CReq change_actor_req = new MessageMicro<AvGameNotify$NotifyChangeActorS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyChangeActorS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"actor_info", "question_info"}, new Object[]{null, null}, AvGameNotify$NotifyChangeActorS2CReq.class);
        public AvGameCommon$RoomUserInfo actor_info = new AvGameCommon$RoomUserInfo();
        public AvGameCommon$GameQuestionInfo question_info = new AvGameCommon$GameQuestionInfo();
    };
    public AvGameNotify$NotifyActorGiveOutAnswerS2CReq actor_giveout_answer_req = new MessageMicro<AvGameNotify$NotifyActorGiveOutAnswerS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyActorGiveOutAnswerS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"tips", "question_info"}, new Object[]{"", null}, AvGameNotify$NotifyActorGiveOutAnswerS2CReq.class);
        public final PBStringField tips = PBField.initString("");
        public AvGameCommon$GameQuestionInfo question_info = new AvGameCommon$GameQuestionInfo();
    };
    public AvGameNotify$NotifyGameOverS2CReq game_over_req = new MessageMicro<AvGameNotify$NotifyGameOverS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyGameOverS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AvGameNotify$NotifyGameOverS2CReq.class);
    };
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBStringField play_game_id = PBField.initString("");
    public AvGameNotify$NotifyTranslateInfoS2CReq translate_info_req = new MessageMicro<AvGameNotify$NotifyTranslateInfoS2CReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyTranslateInfoS2CReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uin", "trans_cost_time", "play_game_id", "answer"}, new Object[]{0L, 0, "", ""}, AvGameNotify$NotifyTranslateInfoS2CReq.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBUInt32Field trans_cost_time = PBField.initUInt32(0);
        public final PBStringField play_game_id = PBField.initString("");
        public final PBStringField answer = PBField.initString("");
    };
    public AvGameNotify$NotifyMatchUserEnterRoom match_user_enter_room = new MessageMicro<AvGameNotify$NotifyMatchUserEnterRoom>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyMatchUserEnterRoom
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"roomid"}, new Object[]{0L}, AvGameNotify$NotifyMatchUserEnterRoom.class);
        public final PBUInt64Field roomid = PBField.initUInt64(0);
    };
    public AvGameNotify$NotifyMatchUserCreateRoom match_user_create_room = new MessageMicro<AvGameNotify$NotifyMatchUserCreateRoom>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyMatchUserCreateRoom
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"seq"}, new Object[]{0}, AvGameNotify$NotifyMatchUserCreateRoom.class);
        public final PBUInt32Field seq = PBField.initUInt32(0);
    };
    public AvGameNotify$NotifyRoomMatchStatus room_match_status = new MessageMicro<AvGameNotify$NotifyRoomMatchStatus>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyRoomMatchStatus
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"roomid", "status"}, new Object[]{0L, 0}, AvGameNotify$NotifyRoomMatchStatus.class);
        public final PBUInt64Field roomid = PBField.initUInt64(0);
        public final PBUInt32Field status = PBField.initUInt32(0);
    };
    public AvGameNotify$NotifyPKUserCreateRoom pk_user_create_room = new MessageMicro<AvGameNotify$NotifyPKUserCreateRoom>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyPKUserCreateRoom
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AvGameNotify$NotifyPKUserCreateRoom.class);
    };
    public AvGameNotify$NotifyPKUserEnterRoom pk_user_enter_room = new MessageMicro<AvGameNotify$NotifyPKUserEnterRoom>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyPKUserEnterRoom
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"roomid", ProtocolDownloaderConstants.HEADER_FRIEND_UIN}, new Object[]{0L, 0L}, AvGameNotify$NotifyPKUserEnterRoom.class);
        public final PBUInt64Field roomid = PBField.initUInt64(0);
        public final PBUInt64Field peer_uin = PBField.initUInt64(0);
    };
    public AvGameNotify$NotifyPKUserSucc pk_user_succ = new MessageMicro<AvGameNotify$NotifyPKUserSucc>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyPKUserSucc
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"reason", "cur_round", "draw_res", "win_tip", LocalPhotoFaceInfo.SCORE}, new Object[]{0, 0, null, "", 0}, AvGameNotify$NotifyPKUserSucc.class);
        public final PBUInt32Field reason = PBField.initUInt32(0);
        public final PBUInt32Field cur_round = PBField.initUInt32(0);
        public AvGameNotify$PKDrawRes draw_res = new AvGameNotify$PKDrawRes();
        public final PBStringField win_tip = PBField.initString("");
        public final PBUInt32Field score = PBField.initUInt32(0);
    };
    public AvGameNotify$NotifyPKUserFinalSucc pk_user_final_succ = new MessageMicro<AvGameNotify$NotifyPKUserFinalSucc>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyPKUserFinalSucc
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField award_str;
        public final PBBytesField award_url;
        public final PBBytesField award_url_str;
        public final PBBoolField delay_award;
        public final PBBytesField delay_award_tip;
        public AvGameNotify$PKDrawRes draw_res;
        public final PBRepeatMessageField<AvGameCommon$PKUserRankInfo> ranking;
        public final PBUInt32Field score;
        public final PBStringField win_tip;
        public final PBUInt32Field reason = PBField.initUInt32(0);
        public final PBUInt32Field total = PBField.initUInt32(0);
        public final PBRepeatMessageField<AvGameCommon$UinWrap> final_ranking = PBField.initRepeatMessage(AvGameCommon$UinWrap.class);

        static {
            String[] strArr = {"reason", "total", "final_ranking", "award_str", "award_url", "ranking", "award_url_str", "delay_award", "delay_award_tip", "draw_res", "win_tip", LocalPhotoFaceInfo.SCORE};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 58, 66, 72, 82, 90, 98, 104}, strArr, new Object[]{0, 0, null, byteStringMicro, byteStringMicro, null, byteStringMicro, Boolean.FALSE, byteStringMicro, null, "", 0}, AvGameNotify$NotifyPKUserFinalSucc.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.award_str = PBField.initBytes(byteStringMicro);
            this.award_url = PBField.initBytes(byteStringMicro);
            this.ranking = PBField.initRepeatMessage(AvGameCommon$PKUserRankInfo.class);
            this.award_url_str = PBField.initBytes(byteStringMicro);
            this.delay_award = PBField.initBool(false);
            this.delay_award_tip = PBField.initBytes(byteStringMicro);
            this.draw_res = new AvGameNotify$PKDrawRes();
            this.win_tip = PBField.initString("");
            this.score = PBField.initUInt32(0);
        }
    };
    public AvGameNotify$NotifyPKUserFail pk_user_fail = new MessageMicro<AvGameNotify$NotifyPKUserFail>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyPKUserFail
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField award_delay;
        public final PBBytesField award_str;
        public final PBBytesField award_url;
        public final PBBytesField award_url_str;
        public final PBBoolField both_lose;
        public final PBBoolField delay_award;
        public final PBBytesField delay_award_tip;
        public AvGameNotify$PKDrawRes draw_res;
        public final PBUInt32Field score;
        public final PBUInt32Field rank = PBField.initUInt32(0);
        public final PBUInt32Field total = PBField.initUInt32(0);
        public final PBBoolField has_consolation_award = PBField.initBool(false);

        static {
            String[] strArr = {"rank", "total", "has_consolation_award", "award_str", "award_url", "award_delay", "award_url_str", "delay_award", "delay_award_tip", "draw_res", "both_lose", LocalPhotoFaceInfo.SCORE};
            Boolean bool = Boolean.FALSE;
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 64, 74, 82, 88, 96}, strArr, new Object[]{0, 0, bool, byteStringMicro, byteStringMicro, bool, byteStringMicro, bool, byteStringMicro, null, bool, 0}, AvGameNotify$NotifyPKUserFail.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.award_str = PBField.initBytes(byteStringMicro);
            this.award_url = PBField.initBytes(byteStringMicro);
            this.award_delay = PBField.initBool(false);
            this.award_url_str = PBField.initBytes(byteStringMicro);
            this.delay_award = PBField.initBool(false);
            this.delay_award_tip = PBField.initBytes(byteStringMicro);
            this.draw_res = new AvGameNotify$PKDrawRes();
            this.both_lose = PBField.initBool(false);
            this.score = PBField.initUInt32(0);
        }
    };
    public AvGameNotify$NotifyPKUserPass pk_user_pass = new MessageMicro<AvGameNotify$NotifyPKUserPass>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyPKUserPass
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"cur_round"}, new Object[]{0}, AvGameNotify$NotifyPKUserPass.class);
        public final PBUInt32Field cur_round = PBField.initUInt32(0);
    };
    public AvGameNotify$NotifyPKCallinUserTooFew pk_callin_user_too_few = new MessageMicro<AvGameNotify$NotifyPKCallinUserTooFew>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyPKCallinUserTooFew
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AvGameNotify$NotifyPKCallinUserTooFew.class);
    };
    public AvGameNotify$NotifyPKUserDraw pk_user_draw = new MessageMicro<AvGameNotify$NotifyPKUserDraw>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyPKUserDraw
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"exit_room", "cur_round"}, new Object[]{Boolean.FALSE, 0}, AvGameNotify$NotifyPKUserDraw.class);
        public final PBBoolField exit_room = PBField.initBool(false);
        public final PBUInt32Field cur_round = PBField.initUInt32(0);
    };
    public final PBUInt32Field pkID = PBField.initUInt32(0);
    public final PBUInt32Field poolID = PBField.initUInt32(0);
    public AvGameNotify$NotifyPKPoolUserChange pk_pool_user_change = new MessageMicro<AvGameNotify$NotifyPKPoolUserChange>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyPKPoolUserChange
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"opt", "total", "uins"}, new Object[]{0, 0, null}, AvGameNotify$NotifyPKPoolUserChange.class);
        public final PBUInt32Field opt = PBField.initUInt32(0);
        public final PBUInt32Field total = PBField.initUInt32(0);
        public final PBRepeatMessageField<AvGameCommon$UinWrap> uins = PBField.initRepeatMessage(AvGameCommon$UinWrap.class);
    };
    public AvGameNotify$NotifyMatchV2UserEnterRoom match_v2_user_enter_room = new MessageMicro<AvGameNotify$NotifyMatchV2UserEnterRoom>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyMatchV2UserEnterRoom
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"roomid"}, new Object[]{0L}, AvGameNotify$NotifyMatchV2UserEnterRoom.class);
        public final PBUInt64Field roomid = PBField.initUInt64(0);
    };
    public AvGameNotify$NotifyMatchV2UserCreateRoom match_v2_user_create_room = new MessageMicro<AvGameNotify$NotifyMatchV2UserCreateRoom>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyMatchV2UserCreateRoom
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"seq", "game_type"}, new Object[]{0, 0}, AvGameNotify$NotifyMatchV2UserCreateRoom.class);
        public final PBUInt32Field seq = PBField.initUInt32(0);
        public final PBUInt32Field game_type = PBField.initUInt32(0);
    };
    public final PBUInt32Field realPoolID = PBField.initUInt32(0);
    public AvGameNotify$NotifyAnswerFinishS2cReq answer_finish_req = new MessageMicro<AvGameNotify$NotifyAnswerFinishS2cReq>() { // from class: trpc.qq_vgame.nofity.AvGameNotify$NotifyAnswerFinishS2cReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"user_answer_info", "next_question_info", LocalPhotoFaceInfo.SCORE}, new Object[]{null, null, 0}, AvGameNotify$NotifyAnswerFinishS2cReq.class);
        public final PBRepeatMessageField<AvGameCommon$UserAnswerInfo> user_answer_info = PBField.initRepeatMessage(AvGameCommon$UserAnswerInfo.class);
        public AvGameCommon$GameQuestionInfo next_question_info = new AvGameCommon$GameQuestionInfo();
        public final PBUInt32Field score = PBField.initUInt32(0);
    };
}
