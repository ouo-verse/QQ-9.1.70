package qzone;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$EchoData extends MessageMicro<SuperResolution$EchoData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"uin", "task_id", "bill_no", WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH}, new Object[]{"", "", "", null}, SuperResolution$EchoData.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField task_id = PBField.initString("");
    public final PBStringField bill_no = PBField.initString("");
    public SuperResolution$AuthInfo auth = new MessageMicro<SuperResolution$AuthInfo>() { // from class: qzone.SuperResolution$AuthInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{StartupReportKey.AUTH_TYPE, "auth_key", "ptlogin_id"}, new Object[]{0, "", 0}, SuperResolution$AuthInfo.class);
        public final PBUInt32Field auth_type = PBField.initUInt32(0);
        public final PBStringField auth_key = PBField.initString("");
        public final PBUInt32Field ptlogin_id = PBField.initUInt32(0);
    };
}
