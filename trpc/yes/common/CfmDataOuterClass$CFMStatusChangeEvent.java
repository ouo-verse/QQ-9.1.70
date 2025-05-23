package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CfmDataOuterClass$CFMStatusChangeEvent extends MessageMicro<CfmDataOuterClass$CFMStatusChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"room_status", "battle_result", "new_leader_id"}, new Object[]{0, null, 0L}, CfmDataOuterClass$CFMStatusChangeEvent.class);
    public final PBInt32Field room_status = PBField.initInt32(0);
    public CfmDataOuterClass$CFMBattleResult battle_result = new CfmDataOuterClass$CFMBattleResult();
    public final PBUInt64Field new_leader_id = PBField.initUInt64(0);
}
