package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp extends MessageMicro<QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_living", "living_detail_url"}, new Object[]{0, ""}, QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp.class);
    public final PBUInt32Field is_living = PBField.initUInt32(0);
    public final PBStringField living_detail_url = PBField.initString("");
}
