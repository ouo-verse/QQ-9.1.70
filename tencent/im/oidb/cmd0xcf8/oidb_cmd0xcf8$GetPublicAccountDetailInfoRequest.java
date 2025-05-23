package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_cmd0xcf8$GetPublicAccountDetailInfoRequest extends MessageMicro<oidb_cmd0xcf8$GetPublicAccountDetailInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 32, 42}, new String[]{"seqno", "luin", "version", "versionInfo"}, new Object[]{0, 0L, 0, ""}, oidb_cmd0xcf8$GetPublicAccountDetailInfoRequest.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBStringField versionInfo = PBField.initString("");
}
