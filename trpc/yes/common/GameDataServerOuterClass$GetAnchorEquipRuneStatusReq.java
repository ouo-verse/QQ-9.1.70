package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GetAnchorEquipRuneStatusReq extends MessageMicro<GameDataServerOuterClass$GetAnchorEquipRuneStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{AudienceReportConst.ANCHOR_ID, "game_id", AudienceReportConst.ROOM_ID}, new Object[]{"", 0, 0L}, GameDataServerOuterClass$GetAnchorEquipRuneStatusReq.class);
    public final PBRepeatField<String> anchor_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
