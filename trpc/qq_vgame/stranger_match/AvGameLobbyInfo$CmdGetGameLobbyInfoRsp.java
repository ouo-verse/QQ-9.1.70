package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameLobbyInfo$CmdGetGameLobbyInfoRsp extends MessageMicro<AvGameLobbyInfo$CmdGetGameLobbyInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"res", "banner_list", "random_match_info", "pk_list", "operate_activity_info", "random_match_info_by_type"}, new Object[]{null, null, null, null, null, null}, AvGameLobbyInfo$CmdGetGameLobbyInfoRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBRepeatMessageField<AvGameLobbyInfo$BannerInfo> banner_list = PBField.initRepeatMessage(AvGameLobbyInfo$BannerInfo.class);
    public AvGameLobbyInfo$RandomMatchInfo random_match_info = new MessageMicro<AvGameLobbyInfo$RandomMatchInfo>() { // from class: trpc.qq_vgame.stranger_match.AvGameLobbyInfo$RandomMatchInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"players_num", "player_list", "game_type", "title_url", "backgroud_url", "wording"}, new Object[]{0, null, 0, "", "", ""}, AvGameLobbyInfo$RandomMatchInfo.class);
        public final PBUInt32Field players_num = PBField.initUInt32(0);
        public final PBRepeatMessageField<AvGameLobbyInfo$PlayerInfo> player_list = PBField.initRepeatMessage(AvGameLobbyInfo$PlayerInfo.class);
        public final PBEnumField game_type = PBField.initEnum(0);
        public final PBStringField title_url = PBField.initString("");
        public final PBStringField backgroud_url = PBField.initString("");
        public final PBStringField wording = PBField.initString("");
    };
    public final PBRepeatMessageField<AvGameLobbyInfo$PKCardInfo> pk_list = PBField.initRepeatMessage(AvGameLobbyInfo$PKCardInfo.class);
    public final PBRepeatMessageField<AvGameLobbyInfo$PKCardInfo> operate_activity_info = PBField.initRepeatMessage(AvGameLobbyInfo$PKCardInfo.class);
    public final PBRepeatMessageField<AvGameLobbyInfo$RandomMatchInfo> random_match_info_by_type = PBField.initRepeatMessage(AvGameLobbyInfo$RandomMatchInfo.class);
}
