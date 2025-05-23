package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_cmd0xcf8$GetPublicInfoRequest extends MessageMicro<oidb_cmd0xcf8$GetPublicInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 32}, new String[]{"seqno", "luin", "version"}, new Object[]{0, 0L, 0}, oidb_cmd0xcf8$GetPublicInfoRequest.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
}
