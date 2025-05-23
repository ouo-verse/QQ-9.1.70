package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomCmdRsp extends MessageMicro<YoloRoomOuterClass$YoloRoomCmdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{162, 170, 402, 410}, new String[]{"yolo_room_start_game_cmd_rsp", "yolo_room_join_game_cmd_rsp", "yolo_start_battle_ob_cmd_rsp", "yolo_close_battle_ob_cmd_rsp"}, new Object[]{null, null, null, null}, YoloRoomOuterClass$YoloRoomCmdRsp.class);
    public YoloRoomOuterClass$YoloRoomStartGameCmdRsp yolo_room_start_game_cmd_rsp = new MessageMicro<YoloRoomOuterClass$YoloRoomStartGameCmdRsp>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomStartGameCmdRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{AegisLogger.ROOM_INFO}, new Object[]{null}, YoloRoomOuterClass$YoloRoomStartGameCmdRsp.class);
        public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
    };
    public YoloRoomOuterClass$YoloRoomJoinGameCmdRsp yolo_room_join_game_cmd_rsp = new YoloRoomOuterClass$YoloRoomJoinGameCmdRsp();
    public YoloRoomOuterClass$YoloStartBattleOBCmdRsp yolo_start_battle_ob_cmd_rsp = new MessageMicro<YoloRoomOuterClass$YoloStartBattleOBCmdRsp>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloStartBattleOBCmdRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ob_id", "url", "game_matrix_ret"}, new Object[]{0L, "", 0}, YoloRoomOuterClass$YoloStartBattleOBCmdRsp.class);
        public final PBInt64Field ob_id = PBField.initInt64(0);
        public final PBStringField url = PBField.initString("");
        public final PBInt32Field game_matrix_ret = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloCloseBattleOBCmdRsp yolo_close_battle_ob_cmd_rsp = new MessageMicro<YoloRoomOuterClass$YoloCloseBattleOBCmdRsp>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloCloseBattleOBCmdRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"game_matrix_ret"}, new Object[]{0}, YoloRoomOuterClass$YoloCloseBattleOBCmdRsp.class);
        public final PBInt32Field game_matrix_ret = PBField.initInt32(0);
    };
}
