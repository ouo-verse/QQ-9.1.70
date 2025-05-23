package qbattle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQBattleInfo$GetShareBattleVideoInfoReq extends MessageMicro<QQBattleInfo$GetShareBattleVideoInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"battle_id", "open_id", "zonearea_id", "authen_id"}, new Object[]{null, "", "", ""}, QQBattleInfo$GetShareBattleVideoInfoReq.class);
    public QQBattleInfo$BattleID battle_id = new QQBattleInfo$BattleID();
    public final PBStringField open_id = PBField.initString("");
    public final PBStringField zonearea_id = PBField.initString("");
    public final PBStringField authen_id = PBField.initString("");
}
