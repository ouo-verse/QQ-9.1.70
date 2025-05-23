package tencent.im.oidb.cmd0xcb5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xcb5$ReqBody extends MessageMicro<cmd0xcb5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_uin", "uint32_report_type", "str_report_conent", "uint64_report_time"}, new Object[]{0L, 0, "", 0L}, cmd0xcb5$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_report_type = PBField.initUInt32(0);
    public final PBStringField str_report_conent = PBField.initString("");
    public final PBUInt64Field uint64_report_time = PBField.initUInt64(0);
}
