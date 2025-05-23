package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.api.AegisLogger;
import trpc.qq_vgame.common.AvGameCommon$GameInfo;
import trpc.qq_vgame.common.AvGameCommon$GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon$Result;
import trpc.qq_vgame.common.AvGameCommon$RoomInfo;
import trpc.qq_vgame.common.AvGameCommon$RoomUserInfo;

/* loaded from: classes29.dex */
public final class AvGamePlay$StartGameRsp extends MessageMicro<AvGamePlay$StartGameRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"seq", "play_game_id", "res", "actor_info", "game_info", "question_info", AegisLogger.ROOM_INFO, "low_version_users"}, new Object[]{0L, "", null, null, null, null, null, null}, AvGamePlay$StartGameRsp.class);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBStringField play_game_id = PBField.initString("");
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public AvGameCommon$RoomUserInfo actor_info = new AvGameCommon$RoomUserInfo();
    public AvGameCommon$GameInfo game_info = new AvGameCommon$GameInfo();
    public AvGameCommon$GameQuestionInfo question_info = new AvGameCommon$GameQuestionInfo();
    public AvGameCommon$RoomInfo room_info = new AvGameCommon$RoomInfo();
    public final PBRepeatMessageField<AvGameCommon$RoomUserInfo> low_version_users = PBField.initRepeatMessage(AvGameCommon$RoomUserInfo.class);
}
