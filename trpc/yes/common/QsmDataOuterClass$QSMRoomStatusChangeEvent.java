package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class QsmDataOuterClass$QSMRoomStatusChangeEvent extends MessageMicro<QsmDataOuterClass$QSMRoomStatusChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"qsm_room_id", "yes_room_id", "room_status", "battle_result"}, new Object[]{0L, 0L, 0, null}, QsmDataOuterClass$QSMRoomStatusChangeEvent.class);
    public final PBUInt64Field qsm_room_id = PBField.initUInt64(0);
    public final PBUInt64Field yes_room_id = PBField.initUInt64(0);
    public final PBInt32Field room_status = PBField.initInt32(0);
    public QsmDataOuterClass$QSMBattleResult battle_result = new QsmDataOuterClass$QSMBattleResult();
}
