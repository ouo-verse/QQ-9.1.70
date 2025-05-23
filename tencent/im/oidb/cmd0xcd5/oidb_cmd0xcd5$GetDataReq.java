package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcd5$GetDataReq extends MessageMicro<oidb_cmd0xcd5$GetDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"query_type", "target_uin"}, new Object[]{0, 0L}, oidb_cmd0xcd5$GetDataReq.class);
    public final PBUInt32Field query_type = PBField.initUInt32(0);
    public final PBUInt64Field target_uin = PBField.initUInt64(0);
}
