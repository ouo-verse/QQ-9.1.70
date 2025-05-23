package qbattle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQBattleInfo$BattleID extends MessageMicro<QQBattleInfo$BattleID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"desk_id", "entity_id", "desk_seq"}, new Object[]{0, 0, 0}, QQBattleInfo$BattleID.class);
    public final PBUInt32Field desk_id = PBField.initUInt32(0);
    public final PBInt32Field entity_id = PBField.initInt32(0);
    public final PBUInt32Field desk_seq = PBField.initUInt32(0);
}
