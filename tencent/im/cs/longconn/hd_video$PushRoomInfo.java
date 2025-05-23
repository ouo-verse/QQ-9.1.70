package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class hd_video$PushRoomInfo extends MessageMicro<hd_video$PushRoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_uin", "uint32_business_flag", "uint64_room_id", "msg_account_ext_info"}, new Object[]{0L, 0, 0L, null}, hd_video$PushRoomInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_business_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0);
    public hd_video_comm$AccountExtInfo msg_account_ext_info = new hd_video_comm$AccountExtInfo();
}
