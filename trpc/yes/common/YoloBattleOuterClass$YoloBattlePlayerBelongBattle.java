package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$YoloBattlePlayerBelongBattle extends MessageMicro<YoloBattleOuterClass$YoloBattlePlayerBelongBattle> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"yolo_battle_id", "player"}, new Object[]{0L, null}, YoloBattleOuterClass$YoloBattlePlayerBelongBattle.class);
    public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0);
    public YoloBattleOuterClass$YoloBattleOnePlayer player = new MessageMicro<YoloBattleOuterClass$YoloBattleOnePlayer>() { // from class: trpc.yes.common.YoloBattleOuterClass$YoloBattleOnePlayer
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBInt32Field login_type = PBField.initInt32(0);
        public final PBUInt64Field uid = PBField.initUInt64(0);
        public final PBUInt64Field game_uid = PBField.initUInt64(0);
        public final PBInt32Field phone_system = PBField.initInt32(0);
        public final PBStringField game_openid = PBField.initString("");
        public final PBInt32Field area = PBField.initInt32(0);
        public final PBInt32Field partition = PBField.initInt32(0);
        public final PBInt32Field camp_id = PBField.initInt32(0);
        public final PBBoolField need_update_battle_route = PBField.initBool(false);
        public final PBUInt32Field player_status = PBField.initUInt32(0);
        public final PBEnumField partner_type = PBField.initEnum(0);
        public final PBBoolField is_leader = PBField.initBool(false);
        public final PBStringField game_gopenid = PBField.initString("");
        public final PBInt32Field is_ai = PBField.initInt32(0);

        static {
            String[] strArr = {MsfConstants.ATTRIBUTE_LOGIN_TYPE, "uid", "game_uid", "phone_system", "game_openid", GdtGetUserInfoHandler.KEY_AREA, "partition", "camp_id", "need_update_battle_route", "player_status", "partner_type", "is_leader", "game_gopenid", "is_ai"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72, 80, 88, 96, 106, 160}, strArr, new Object[]{0, 0L, 0L, 0, "", 0, 0, 0, bool, 0, 0, bool, "", 0}, YoloBattleOuterClass$YoloBattleOnePlayer.class);
        }
    };
}
