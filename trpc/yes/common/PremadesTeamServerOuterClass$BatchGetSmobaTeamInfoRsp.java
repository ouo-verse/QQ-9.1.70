package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$BatchGetSmobaTeamInfoRsp extends MessageMicro<PremadesTeamServerOuterClass$BatchGetSmobaTeamInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 32}, new String[]{"team_list", "share_yolo_room_msg", "refresh_interval"}, new Object[]{null, null, 0}, PremadesTeamServerOuterClass$BatchGetSmobaTeamInfoRsp.class);
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$SmobaPremadesTeamInfo> team_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$SmobaPremadesTeamInfo.class);
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$ShareYoloRoomMsg> share_yolo_room_msg = PBField.initRepeatMessage(PremadesTeamServerOuterClass$ShareYoloRoomMsg.class);
    public final PBInt32Field refresh_interval = PBField.initInt32(0);
}
