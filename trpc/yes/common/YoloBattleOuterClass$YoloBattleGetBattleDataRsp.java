package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$YoloBattleGetBattleDataRsp extends MessageMicro<YoloBattleOuterClass$YoloBattleGetBattleDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"battle_data"}, new Object[]{null}, YoloBattleOuterClass$YoloBattleGetBattleDataRsp.class);
    public YoloBattleOuterClass$YoloBattleInfo battle_data = new MessageMicro<YoloBattleOuterClass$YoloBattleInfo>() { // from class: trpc.yes.common.YoloBattleOuterClass$YoloBattleInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48}, new String[]{"battle_base_info", "player_info", "max_event_id", "battle_create_time", "extra_data", "battle_type"}, new Object[]{null, null, 0, 0L, "", 0}, YoloBattleOuterClass$YoloBattleInfo.class);
        public YoloBattleOuterClass$YoloBattleBaseInfo battle_base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
        public YoloBattleOuterClass$YoloBattlePlayerInfo player_info = new YoloBattleOuterClass$YoloBattlePlayerInfo();
        public final PBInt32Field max_event_id = PBField.initInt32(0);
        public final PBUInt64Field battle_create_time = PBField.initUInt64(0);
        public final PBStringField extra_data = PBField.initString("");
        public final PBEnumField battle_type = PBField.initEnum(0);
    };
}
