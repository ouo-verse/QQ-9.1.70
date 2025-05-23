package trpc.yes.common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloTeamOuterClass$YoloLiveTeamInfo extends MessageMicro<YoloTeamOuterClass$YoloLiveTeamInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 74, 82, 90, 98, 800}, new String[]{"team_id", "game_id", "owner_user_id", "create_user_id", "status", AlbumCacheData.CREATE_TIME, "game_route_info", "game_data_info", "team_data_info", "team_player_info_list", "server_index"}, new Object[]{0L, 0, null, null, 0, 0, null, null, null, null, 0}, YoloTeamOuterClass$YoloLiveTeamInfo.class);
    public final PBUInt64Field team_id = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public CommonOuterClass$QQUserId owner_user_id = new CommonOuterClass$QQUserId();
    public CommonOuterClass$QQUserId create_user_id = new CommonOuterClass$QQUserId();
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public YoloRoomOuterClass$YoloGameRouteInfo game_route_info = new YoloRoomOuterClass$YoloGameRouteInfo();
    public YoloRoomOuterClass$YoloGameDataInfo game_data_info = new YoloRoomOuterClass$YoloGameDataInfo();
    public YoloTeamOuterClass$YoloTeamDataInfo team_data_info = new MessageMicro<YoloTeamOuterClass$YoloTeamDataInfo>() { // from class: trpc.yes.common.YoloTeamOuterClass$YoloTeamDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"min_player_num", "max_player_num", "max_user_num", "create_from", "game_id"}, new Object[]{0, 0, 0, 0, 0}, YoloTeamOuterClass$YoloTeamDataInfo.class);
        public final PBInt32Field min_player_num = PBField.initInt32(0);
        public final PBInt32Field max_player_num = PBField.initInt32(0);
        public final PBInt32Field max_user_num = PBField.initInt32(0);
        public final PBInt32Field create_from = PBField.initInt32(0);
        public final PBInt32Field game_id = PBField.initInt32(0);
    };
    public YoloTeamOuterClass$YoloTeamPlayerInfoList team_player_info_list = new YoloTeamOuterClass$YoloTeamPlayerInfoList();
    public final PBInt32Field server_index = PBField.initInt32(0);
}
