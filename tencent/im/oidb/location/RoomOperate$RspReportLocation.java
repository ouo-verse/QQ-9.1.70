package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RoomOperate$RspReportLocation extends MessageMicro<RoomOperate$RspReportLocation> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_result", "req_interval"}, new Object[]{null, 0}, RoomOperate$RspReportLocation.class);
    public qq_lbs_share$ResultInfo msg_result = new qq_lbs_share$ResultInfo();
    public final PBUInt32Field req_interval = PBField.initUInt32(0);
}
