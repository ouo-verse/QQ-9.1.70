package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomDestroyReq extends MessageMicro<AvGameRoomManager$CmdRoomDestroyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uin", "type", "roomid", FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, "from"}, new Object[]{0L, 0, 0L, 0L, 0}, AvGameRoomManager$CmdRoomDestroyReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt64Field groupid = PBField.initUInt64(0);
    public final PBUInt32Field from = PBField.initUInt32(0);
}
