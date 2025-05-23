package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleCfmOuterClass$YoloCFMBattleInfo extends MessageMicro<YoloBattleCfmOuterClass$YoloCFMBattleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 82, 88, 98, 800, 810}, new String[]{"status", "cfm_config", "cfm_schema", "game_leader_uid", "game_svr_id", "last_event_type", "last_event"}, new Object[]{1, null, null, 0L, "", 0, null}, YoloBattleCfmOuterClass$YoloCFMBattleInfo.class);
    public final PBEnumField status = PBField.initEnum(1);
    public YoloBattleCfmOuterClass$YoloCFMBattleConfig cfm_config = new YoloBattleCfmOuterClass$YoloCFMBattleConfig();
    public YoloBattleCfmOuterClass$YoloCFMSchema cfm_schema = new YoloBattleCfmOuterClass$YoloCFMSchema();
    public final PBUInt64Field game_leader_uid = PBField.initUInt64(0);
    public final PBStringField game_svr_id = PBField.initString("");
    public final PBEnumField last_event_type = PBField.initEnum(0);
    public YoloBattleCfmOuterClass$YoloOneCFMBattleEvent last_event = new YoloBattleCfmOuterClass$YoloOneCFMBattleEvent();
}
