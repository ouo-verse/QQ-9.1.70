package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$YoloBattleBaseInfo extends MessageMicro<YoloBattleOuterClass$YoloBattleBaseInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 162, 800, 808, 818}, new String[]{"from_scene", "battle_game", "life_cycle", "need_battle_ob", "dye_info", "yolo_battle_status", "yolo_battle_id", "game_battle_id"}, new Object[]{1, 0, 0, Boolean.FALSE, null, 0, 0L, ""}, YoloBattleOuterClass$YoloBattleBaseInfo.class);
    public final PBEnumField from_scene = PBField.initEnum(1);
    public final PBEnumField battle_game = PBField.initEnum(0);
    public final PBEnumField life_cycle = PBField.initEnum(0);
    public final PBBoolField need_battle_ob = PBField.initBool(false);
    public YoloBattleOuterClass$YoloBattleDyeInfo dye_info = new MessageMicro<YoloBattleOuterClass$YoloBattleDyeInfo>() { // from class: trpc.yes.common.YoloBattleOuterClass$YoloBattleDyeInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"dye_id"}, new Object[]{ByteStringMicro.EMPTY}, YoloBattleOuterClass$YoloBattleDyeInfo.class);
        public final PBBytesField dye_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public final PBUInt32Field yolo_battle_status = PBField.initUInt32(0);
    public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0);
    public final PBStringField game_battle_id = PBField.initString("");
}
