package tencent.trpcprotocol;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopLiveSyncSvr$GetSyncRoomIDRsp extends MessageMicro<TroopLiveSyncSvr$GetSyncRoomIDRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{AudienceReportConst.ROOM_ID, "group_code"}, new Object[]{0, 0L}, TroopLiveSyncSvr$GetSyncRoomIDRsp.class);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
}
