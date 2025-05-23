package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$GetAnchorRoomChargeLeaderboardReq extends MessageMicro<LiveActivityServerOuterClass$GetAnchorRoomChargeLeaderboardReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"leaderboard_type", "start", "end", "uid"}, new Object[]{0, 0, 0, 0L}, LiveActivityServerOuterClass$GetAnchorRoomChargeLeaderboardReq.class);
    public final PBInt32Field leaderboard_type = PBField.initInt32(0);
    public final PBInt32Field start = PBField.initInt32(0);
    public final PBInt32Field end = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
