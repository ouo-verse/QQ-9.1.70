package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleObOuterClass$YoloBattleStartOBReq extends MessageMicro<YoloBattleObOuterClass$YoloBattleStartOBReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"device_id", "notify_config", "route_info", "yolo_battle_id"}, new Object[]{"", null, null, 0L}, YoloBattleObOuterClass$YoloBattleStartOBReq.class);
    public final PBStringField device_id = PBField.initString("");
    public YoloBattleObOuterClass$YoloBattleOBNotifyConfig notify_config = new YoloBattleObOuterClass$YoloBattleOBNotifyConfig();
    public YoloBattleObOuterClass$YoloBattleOBNotifyEventRouteInfo route_info = new YoloBattleObOuterClass$YoloBattleOBNotifyEventRouteInfo();
    public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0);
}
