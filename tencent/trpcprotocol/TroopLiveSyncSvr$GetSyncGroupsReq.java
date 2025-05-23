package tencent.trpcprotocol;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopLiveSyncSvr$GetSyncGroupsReq extends MessageMicro<TroopLiveSyncSvr$GetSyncGroupsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{AudienceReportConst.ROOM_ID}, new Object[]{0}, TroopLiveSyncSvr$GetSyncGroupsReq.class);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
}
