package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$RefreshGameRoomInfoRsp extends MessageMicro<PremadesTeamServerOuterClass$RefreshGameRoomInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"team_list", "share_yolo_room_msg", "user_route_list", "refresh_interval"}, new Object[]{null, null, null, 0}, PremadesTeamServerOuterClass$RefreshGameRoomInfoRsp.class);
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> team_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$YesGamePremadesTeamInfo.class);
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$ShareYoloRoomMsg> share_yolo_room_msg = PBField.initRepeatMessage(PremadesTeamServerOuterClass$ShareYoloRoomMsg.class);
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$UserOnlineRouteInfoList> user_route_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$UserOnlineRouteInfoList.class);
    public final PBInt32Field refresh_interval = PBField.initInt32(0);
}
