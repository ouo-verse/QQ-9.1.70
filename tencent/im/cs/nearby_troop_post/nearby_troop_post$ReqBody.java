package tencent.im.cs.nearby_troop_post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearby_troop_post$ReqBody extends MessageMicro<nearby_troop_post$ReqBody> {
    public static final int MSG_SUBCMD0X1_REQ_NEARBYINFO_FIELD_NUMBER = 2;
    public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_sub_cmd", "msg_subcmd0x1_req_nearbyinfo"}, new Object[]{0, null}, nearby_troop_post$ReqBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public nearby_troop_post$ReqNearbyPostInfo msg_subcmd0x1_req_nearbyinfo = new MessageMicro<nearby_troop_post$ReqNearbyPostInfo>() { // from class: tencent.im.cs.nearby_troop_post.nearby_troop_post$ReqNearbyPostInfo
        public static final int UINT64_LATITUDE_FIELD_NUMBER = 2;
        public static final int UINT64_LONGTITUDE_FIELD_NUMBER = 1;
        public static final int UINT64_RANGE_FIELD_NUMBER = 3;
        public static final int UINT64_UIN_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_longtitude", "uint64_latitude", "uint64_range", "uint64_uin"}, new Object[]{0, 0, 0, 0}, nearby_troop_post$ReqNearbyPostInfo.class);
        public final PBUInt32Field uint64_longtitude = PBField.initUInt32(0);
        public final PBUInt32Field uint64_latitude = PBField.initUInt32(0);
        public final PBUInt32Field uint64_range = PBField.initUInt32(0);
        public final PBUInt32Field uint64_uin = PBField.initUInt32(0);
    };
}
