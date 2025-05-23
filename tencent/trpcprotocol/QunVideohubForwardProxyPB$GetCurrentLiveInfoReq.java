package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QunVideohubForwardProxyPB$GetCurrentLiveInfoReq extends MessageMicro<QunVideohubForwardProxyPB$GetCurrentLiveInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"guin", "fromid"}, new Object[]{0L, 0}, QunVideohubForwardProxyPB$GetCurrentLiveInfoReq.class);
    public final PBUInt64Field guin = PBField.initUInt64(0);
    public final PBUInt32Field fromid = PBField.initUInt32(0);
}
