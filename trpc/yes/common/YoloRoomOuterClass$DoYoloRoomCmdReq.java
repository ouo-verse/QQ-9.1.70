package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$DoYoloRoomCmdReq extends MessageMicro<YoloRoomOuterClass$DoYoloRoomCmdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{AudienceReportConst.ROOM_ID, "cmd_type", "client_seq_id", "yolo_room_cmd_req"}, new Object[]{0L, 0, 0L, null}, YoloRoomOuterClass$DoYoloRoomCmdReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field cmd_type = PBField.initInt32(0);
    public final PBUInt64Field client_seq_id = PBField.initUInt64(0);
    public YoloRoomOuterClass$YoloRoomCmdReq yolo_room_cmd_req = new YoloRoomOuterClass$YoloRoomCmdReq();
}
