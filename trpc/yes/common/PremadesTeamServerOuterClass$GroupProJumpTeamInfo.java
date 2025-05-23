package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.api.AegisLogger;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$GroupProJumpTeamInfo extends MessageMicro<PremadesTeamServerOuterClass$GroupProJumpTeamInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{AegisLogger.ROOM_INFO, "team_id", "type"}, new Object[]{null, 0L, 0}, PremadesTeamServerOuterClass$GroupProJumpTeamInfo.class);
    public PremadesTeamServerOuterClass$GroupProJumpRoomInfo room_info = new MessageMicro<PremadesTeamServerOuterClass$GroupProJumpRoomInfo>() { // from class: trpc.yes.common.PremadesTeamServerOuterClass$GroupProJumpRoomInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"guild_id", "channel_id", AudienceReportConst.ROOM_ID}, new Object[]{0L, 0L, 0L}, PremadesTeamServerOuterClass$GroupProJumpRoomInfo.class);
        public final PBUInt64Field guild_id = PBField.initUInt64(0);
        public final PBUInt64Field channel_id = PBField.initUInt64(0);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
    };
    public final PBUInt64Field team_id = PBField.initUInt64(0);
    public final PBInt32Field type = PBField.initInt32(0);
}
