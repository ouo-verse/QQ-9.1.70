package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$YoloCreateBattleReq extends MessageMicro<YoloBattleOuterClass$YoloCreateBattleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 48}, new String[]{"notify_config", "player_info", "notify_config_list", "extra_data", "battle_type"}, new Object[]{null, null, null, "", 0}, YoloBattleOuterClass$YoloCreateBattleReq.class);
    public YoloBattleOuterClass$YoloBattleNotifyConfig notify_config = new MessageMicro<YoloBattleOuterClass$YoloBattleNotifyConfig>() { // from class: trpc.yes.common.YoloBattleOuterClass$YoloBattleNotifyConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"notify_control", "notify_type", "notify_event"}, new Object[]{0, 0, 0}, YoloBattleOuterClass$YoloBattleNotifyConfig.class);
        public final PBEnumField notify_control = PBField.initEnum(0);
        public final PBEnumField notify_type = PBField.initEnum(0);
        public final PBRepeatField<Integer> notify_event = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    };
    public YoloBattleOuterClass$YoloBattlePlayerInfo player_info = new YoloBattleOuterClass$YoloBattlePlayerInfo();
    public final PBRepeatMessageField<YoloBattleOuterClass$YoloBattleNotifyConfig> notify_config_list = PBField.initRepeatMessage(YoloBattleOuterClass$YoloBattleNotifyConfig.class);
    public final PBStringField extra_data = PBField.initString("");
    public final PBEnumField battle_type = PBField.initEnum(0);
}
