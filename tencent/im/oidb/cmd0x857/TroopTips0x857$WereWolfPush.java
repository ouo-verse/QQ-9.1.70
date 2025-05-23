package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class TroopTips0x857$WereWolfPush extends MessageMicro<TroopTips0x857$WereWolfPush> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_judge_nickname;
    public final PBBytesField bytes_judge_words;
    public final PBBytesField bytes_voted_words;
    public final PBUInt32Field enum_operation;
    public GameBonus msg_game_bonus;
    public final PBRepeatField<Long> rpt_dead_users;
    public final PBRepeatField<Long> rpt_voted_tie_users;
    public final PBUInt32Field uint32_game_result;
    public final PBUInt32Field uint32_has_last_words;
    public final PBUInt32Field uint32_kill_confirmed;
    public final PBUInt32Field uint32_timeout_sec;
    public final PBUInt32Field uint32_user_state;
    public final PBUInt32Field uint32_voted_result;
    public final PBUInt64Field uint64_dst_user;
    public final PBUInt64Field uint64_src_user;
    public final PBUInt32Field uint32_push_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_game_room = PBField.initUInt64(0);
    public final PBUInt32Field enum_game_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_game_round = PBField.initUInt32(0);
    public final PBRepeatMessageField<Role> rpt_roles = PBField.initRepeatMessage(Role.class);
    public final PBUInt64Field uint64_speaker = PBField.initUInt64(0);
    public final PBUInt64Field uint64_judge_uin = PBField.initUInt64(0);

    /* loaded from: classes29.dex */
    public static final class GameBonus extends MessageMicro<GameBonus> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int64_game_bonus", "uint32_game_needed"}, new Object[]{0L, 0}, GameBonus.class);
        public final PBInt64Field int64_game_bonus = PBField.initInt64(0);
        public final PBUInt32Field uint32_game_needed = PBField.initUInt32(0);
    }

    /* loaded from: classes29.dex */
    public static final class GameRecord extends MessageMicro<GameRecord> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_total", "uint32_win", "uint32_lose", "uint32_draw"}, new Object[]{0, 0, 0, 0}, GameRecord.class);
        public final PBUInt32Field uint32_total = PBField.initUInt32(0);
        public final PBUInt32Field uint32_win = PBField.initUInt32(0);
        public final PBUInt32Field uint32_lose = PBField.initUInt32(0);
        public final PBUInt32Field uint32_draw = PBField.initUInt32(0);
    }

    /* loaded from: classes29.dex */
    public static final class Role extends MessageMicro<Role> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 138, 144, 152, 160, 168, 176, 184}, new String[]{"uint64_uin", "enum_type", "enum_state", "uint32_can_speak", "uint32_can_listen", "uint32_position", "uint32_can_vote", "uint32_can_voted", "uint32_already_checked", "uint32_already_saved", "uint32_already_poisoned", "uint32_player_state", "enum_dead_op", "enum_operation", "uint64_dst_user", "uint32_operation_round", "msg_game_record", "uint32_is_werewolf", "uint64_defended_user", "uint32_is_sheriff", "uint32_sheriff_competing", "uint32_dead_round", "uint32_operation_state"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0, null, 0, 0L, 0, 0, 0, 0}, Role.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field enum_type = PBField.initUInt32(0);
        public final PBUInt32Field enum_state = PBField.initUInt32(0);
        public final PBUInt32Field uint32_can_speak = PBField.initUInt32(0);
        public final PBUInt32Field uint32_can_listen = PBField.initUInt32(0);
        public final PBUInt32Field uint32_position = PBField.initUInt32(0);
        public final PBUInt32Field uint32_can_vote = PBField.initUInt32(0);
        public final PBUInt32Field uint32_can_voted = PBField.initUInt32(0);
        public final PBUInt32Field uint32_already_checked = PBField.initUInt32(0);
        public final PBUInt32Field uint32_already_saved = PBField.initUInt32(0);
        public final PBUInt32Field uint32_already_poisoned = PBField.initUInt32(0);
        public final PBUInt32Field uint32_player_state = PBField.initUInt32(0);
        public final PBUInt32Field enum_dead_op = PBField.initUInt32(0);
        public final PBUInt32Field enum_operation = PBField.initUInt32(0);
        public final PBUInt64Field uint64_dst_user = PBField.initUInt64(0);
        public final PBUInt32Field uint32_operation_round = PBField.initUInt32(0);
        public GameRecord msg_game_record = new GameRecord();
        public final PBUInt32Field uint32_is_werewolf = PBField.initUInt32(0);
        public final PBUInt64Field uint64_defended_user = PBField.initUInt64(0);
        public final PBUInt32Field uint32_is_sheriff = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sheriff_competing = PBField.initUInt32(0);
        public final PBUInt32Field uint32_dead_round = PBField.initUInt32(0);
        public final PBUInt32Field uint32_operation_state = PBField.initUInt32(0);
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 66, 72, 80, 88, 96, 104, 112, 120, 130, 136, 146, 152, 160, 168, 178}, new String[]{"uint32_push_type", "uint64_game_room", "enum_game_state", "uint32_game_round", "rpt_roles", "uint64_speaker", "uint64_judge_uin", "bytes_judge_words", "enum_operation", "uint64_src_user", "uint64_dst_user", "rpt_dead_users", "uint32_game_result", "uint32_timeout_sec", "uint32_kill_confirmed", "bytes_judge_nickname", "rpt_voted_tie_users", "bytes_voted_words", "uint32_voted_result", "uint32_has_last_words", "uint32_user_state", "msg_game_bonus"}, new Object[]{0, 0L, 0, 0, null, 0L, 0L, byteStringMicro, 0, 0L, 0L, 0L, 0, 0, 0, byteStringMicro, 0L, byteStringMicro, 0, 0, 0, null}, TroopTips0x857$WereWolfPush.class);
    }

    public TroopTips0x857$WereWolfPush() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_judge_words = PBField.initBytes(byteStringMicro);
        this.enum_operation = PBField.initUInt32(0);
        this.uint64_src_user = PBField.initUInt64(0L);
        this.uint64_dst_user = PBField.initUInt64(0L);
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_dead_users = PBField.initRepeat(pBUInt64Field);
        this.uint32_game_result = PBField.initUInt32(0);
        this.uint32_timeout_sec = PBField.initUInt32(0);
        this.uint32_kill_confirmed = PBField.initUInt32(0);
        this.bytes_judge_nickname = PBField.initBytes(byteStringMicro);
        this.rpt_voted_tie_users = PBField.initRepeat(pBUInt64Field);
        this.bytes_voted_words = PBField.initBytes(byteStringMicro);
        this.uint32_voted_result = PBField.initUInt32(0);
        this.uint32_has_last_words = PBField.initUInt32(0);
        this.uint32_user_state = PBField.initUInt32(0);
        this.msg_game_bonus = new GameBonus();
    }
}
