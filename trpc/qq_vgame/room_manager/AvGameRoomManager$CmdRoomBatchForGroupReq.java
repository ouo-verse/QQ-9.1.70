package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomBatchForGroupReq extends MessageMicro<AvGameRoomManager$CmdRoomBatchForGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, "uin", "start", "batch_num", "req_from", "req_platform"}, new Object[]{0L, 0L, 0, 0, 0, 0}, AvGameRoomManager$CmdRoomBatchForGroupReq.class);
    public final PBUInt64Field groupid = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field batch_num = PBField.initUInt32(0);
    public final PBUInt32Field req_from = PBField.initUInt32(0);
    public final PBUInt32Field req_platform = PBField.initUInt32(0);
}
