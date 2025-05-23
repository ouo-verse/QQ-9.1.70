package tencent.im.oidb.location;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RoomOperate$RspRoomQuery extends MessageMicro<RoomOperate$RspRoomQuery> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 56}, new String[]{"msg_result", "user_list", "create_uin", AlbumCacheData.CREATE_TIME, "room_state", "assembly_Point", "req_interval"}, new Object[]{null, null, 0L, 0L, 1, null, 0}, RoomOperate$RspRoomQuery.class);
    public qq_lbs_share$ResultInfo msg_result = new qq_lbs_share$ResultInfo();
    public final PBRepeatMessageField<RoomOperate$UserData> user_list = PBField.initRepeatMessage(RoomOperate$UserData.class);
    public final PBUInt64Field create_uin = PBField.initUInt64(0);
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBEnumField room_state = PBField.initEnum(1);
    public qq_lbs_share$AssemblyPointData assembly_Point = new qq_lbs_share$AssemblyPointData();
    public final PBUInt32Field req_interval = PBField.initUInt32(0);
}
