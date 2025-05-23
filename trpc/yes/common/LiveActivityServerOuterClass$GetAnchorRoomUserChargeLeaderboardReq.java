package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$GetAnchorRoomUserChargeLeaderboardReq extends MessageMicro<LiveActivityServerOuterClass$GetAnchorRoomUserChargeLeaderboardReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{AudienceReportConst.ROOM_ID, "leaderboard_type", "start", "end"}, new Object[]{0L, 0, 0, 0}, LiveActivityServerOuterClass$GetAnchorRoomUserChargeLeaderboardReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field leaderboard_type = PBField.initInt32(0);
    public final PBInt32Field start = PBField.initInt32(0);
    public final PBInt32Field end = PBField.initInt32(0);
}
