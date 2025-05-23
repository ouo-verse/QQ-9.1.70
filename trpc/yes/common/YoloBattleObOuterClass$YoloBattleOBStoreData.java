package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleObOuterClass$YoloBattleOBStoreData extends MessageMicro<YoloBattleObOuterClass$YoloBattleOBStoreData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58}, new String[]{"notify_config", "route_info", "ob_id", "status", "ob_start_time", "battle_base_info", "ob_url"}, new Object[]{null, null, 0L, 0, 0L, null, ""}, YoloBattleObOuterClass$YoloBattleOBStoreData.class);
    public YoloBattleObOuterClass$YoloBattleOBNotifyConfig notify_config = new YoloBattleObOuterClass$YoloBattleOBNotifyConfig();
    public YoloBattleObOuterClass$YoloBattleOBNotifyEventRouteInfo route_info = new YoloBattleObOuterClass$YoloBattleOBNotifyEventRouteInfo();
    public final PBInt64Field ob_id = PBField.initInt64(0);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBUInt64Field ob_start_time = PBField.initUInt64(0);
    public YoloBattleOuterClass$YoloBattleBaseInfo battle_base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
    public final PBStringField ob_url = PBField.initString("");
}
