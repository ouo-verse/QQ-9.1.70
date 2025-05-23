package tencent.trpcprotocol.groupdigest;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FetchList$ReqBody extends MessageMicro<FetchList$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50}, new String[]{"group_code", "source", "sign", "sign_ts", QQHealthReportApiImpl.MSG_TYPE_KEY, "page_cookie"}, new Object[]{0L, 0, "", 0L, 0, ""}, FetchList$ReqBody.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBStringField sign = PBField.initString("");
    public final PBInt64Field sign_ts = PBField.initInt64(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBStringField page_cookie = PBField.initString("");
}
