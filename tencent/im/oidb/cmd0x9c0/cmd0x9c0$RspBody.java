package tencent.im.oidb.cmd0x9c0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c0$RspBody extends MessageMicro<cmd0x9c0$RspBody> {
    public static final int RPT_NEARBY_USER_LIST_FIELD_NUMBER = 2;
    public static final int UINT32_HEARTBEAT_INTERVAL_FIELD_NUMBER = 4;
    public static final int UINT32_REQ_INTERVAL_FIELD_NUMBER = 3;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint64_uin", "rpt_nearby_user_list", "uint32_req_interval", "uint32_heartbeat_interval"}, new Object[]{0L, null, 0, 0}, cmd0x9c0$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<cmd0x9c0$NearbyUser> rpt_nearby_user_list = PBField.initRepeatMessage(cmd0x9c0$NearbyUser.class);
    public final PBUInt32Field uint32_req_interval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_heartbeat_interval = PBField.initUInt32(0);
}
