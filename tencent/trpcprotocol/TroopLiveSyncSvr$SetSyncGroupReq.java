package tencent.trpcprotocol;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopLiveSyncSvr$SetSyncGroupReq extends MessageMicro<TroopLiveSyncSvr$SetSyncGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 40}, new String[]{AudienceReportConst.ROOM_ID, "sync_switch", "groups_code"}, new Object[]{0, Boolean.FALSE, 0L}, TroopLiveSyncSvr$SetSyncGroupReq.class);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBBoolField sync_switch = PBField.initBool(false);
    public final PBRepeatField<Long> groups_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
