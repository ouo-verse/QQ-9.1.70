package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$DoYoloRoomCmdRsp extends MessageMicro<YoloRoomOuterClass$DoYoloRoomCmdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"client_seq_id", "yolo_room_cmd_rsp", "safe_check_result"}, new Object[]{0L, null, null}, YoloRoomOuterClass$DoYoloRoomCmdRsp.class);
    public final PBUInt64Field client_seq_id = PBField.initUInt64(0);
    public YoloRoomOuterClass$YoloRoomCmdRsp yolo_room_cmd_rsp = new YoloRoomOuterClass$YoloRoomCmdRsp();
    public SafeOuterClass$SafeCheckResult safe_check_result = new SafeOuterClass$SafeCheckResult();
}
