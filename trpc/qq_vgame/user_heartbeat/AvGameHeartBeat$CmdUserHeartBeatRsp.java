package trpc.qq_vgame.user_heartbeat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameHeartBeat$CmdUserHeartBeatRsp extends MessageMicro<AvGameHeartBeat$CmdUserHeartBeatRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"res", "seq", "report_interval"}, new Object[]{null, 0L, 0}, AvGameHeartBeat$CmdUserHeartBeatRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBUInt32Field report_interval = PBField.initUInt32(0);
}
