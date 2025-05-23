package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomCreateReq extends MessageMicro<YoloRoomOuterClass$YoloRoomCreateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 42, 50, 58, 66, 74, 82, 90, 802}, new String[]{"room_params", "smoba_room_params", "comm_room_params", "game_room_params", "pubg_room_params", "qsm_room_params", "cfm_room_params", "codm_room_params", "tgpa_data_info", "game_route_info"}, new Object[]{null, null, null, null, null, null, null, null, null, null}, YoloRoomOuterClass$YoloRoomCreateReq.class);
    public YoloRoomOuterClass$YoloRoomParams room_params = new YoloRoomOuterClass$YoloRoomParams();
    public YoloRoomOuterClass$YoloSmobaRoomParams smoba_room_params = new YoloRoomOuterClass$YoloSmobaRoomParams();
    public YoloRoomOuterClass$YoloCommunityRoomParams comm_room_params = new YoloRoomOuterClass$YoloCommunityRoomParams();
    public YoloRoomOuterClass$YoloGameRoomParams game_room_params = new YoloRoomOuterClass$YoloGameRoomParams();
    public YoloRoomOuterClass$YoloPubgRoomParams pubg_room_params = new YoloRoomOuterClass$YoloPubgRoomParams();
    public YoloRoomOuterClass$YoloQsmRoomParams qsm_room_params = new YoloRoomOuterClass$YoloQsmRoomParams();
    public YoloRoomOuterClass$YoloCfmRoomParams cfm_room_params = new YoloRoomOuterClass$YoloCfmRoomParams();
    public YoloRoomOuterClass$YoloCodmRoomParams codm_room_params = new YoloRoomOuterClass$YoloCodmRoomParams();
    public YoloRoomOuterClass$YoloRoomTgpaData tgpa_data_info = new YoloRoomOuterClass$YoloRoomTgpaData();
    public YoloRoomOuterClass$YoloGameRouteInfo game_route_info = new YoloRoomOuterClass$YoloGameRouteInfo();
}
