package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.common.api.AegisLogger;
import trpc.qq_vgame.common.AvGameCommon$GameStatusInfo;
import trpc.qq_vgame.common.AvGameCommon$Result;
import trpc.qq_vgame.common.AvGameCommon$RoomInfo;
import trpc.qq_vgame.game_list.AvGameList$CmdGameListRsp;
import trpc.qq_vgame.game_ranking.AvGameRanking$GetRankingListRsp;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomInfoRsp extends MessageMicro<AvGameRoomManager$CmdRoomInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"res", AegisLogger.ROOM_INFO, "game_status_info", "game_cfg_info", "game_ranking_info"}, new Object[]{null, null, null, null, null}, AvGameRoomManager$CmdRoomInfoRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public AvGameCommon$RoomInfo room_info = new AvGameCommon$RoomInfo();
    public AvGameCommon$GameStatusInfo game_status_info = new AvGameCommon$GameStatusInfo();
    public AvGameList$CmdGameListRsp game_cfg_info = new MessageMicro<AvGameList$CmdGameListRsp>() { // from class: trpc.qq_vgame.game_list.AvGameList$CmdGameListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"game_list", "curr_game_index", "resource_url", "resource_md5", "res"}, new Object[]{null, 0, "", "", null}, AvGameList$CmdGameListRsp.class);
        public final PBRepeatMessageField<AvGameList$GameListItemInfo> game_list = PBField.initRepeatMessage(AvGameList$GameListItemInfo.class);
        public final PBUInt32Field curr_game_index = PBField.initUInt32(0);
        public final PBStringField resource_url = PBField.initString("");
        public final PBStringField resource_md5 = PBField.initString("");
        public AvGameCommon$Result res = new AvGameCommon$Result();
    };
    public AvGameRanking$GetRankingListRsp game_ranking_info = new MessageMicro<AvGameRanking$GetRankingListRsp>() { // from class: trpc.qq_vgame.game_ranking.AvGameRanking$GetRankingListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"res", "ranking_list"}, new Object[]{null, null}, AvGameRanking$GetRankingListRsp.class);
        public AvGameCommon$Result res = new AvGameCommon$Result();
        public final PBRepeatMessageField<AvGameRanking$UserScoreInfo> ranking_list = PBField.initRepeatMessage(AvGameRanking$UserScoreInfo.class);
    };
}
