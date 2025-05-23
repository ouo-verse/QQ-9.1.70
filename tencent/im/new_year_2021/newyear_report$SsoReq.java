package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class newyear_report$SsoReq extends MessageMicro<newyear_report$SsoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"data", "option"}, new Object[]{null, null}, newyear_report$SsoReq.class);
    public newyear_report$NYReportReq data = new MessageMicro<newyear_report$NYReportReq>() { // from class: tencent.im.new_year_2021.newyear_report$NYReportReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"commonInfo", "reportItems"}, new Object[]{null, null}, newyear_report$NYReportReq.class);
        public newyear_report$NYCommonInfo commonInfo = new MessageMicro<newyear_report$NYCommonInfo>() { // from class: tencent.im.new_year_2021.newyear_report$NYCommonInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uin", "adcode", "plat", "report_array"}, new Object[]{0L, "", 0, ""}, newyear_report$NYCommonInfo.class);
            public final PBUInt64Field uin = PBField.initUInt64(0);
            public final PBStringField adcode = PBField.initString("");
            public final PBUInt32Field plat = PBField.initUInt32(0);
            public final PBStringField report_array = PBField.initString("");
        };
        public final PBRepeatMessageField<newyear_report$NYReportItems> reportItems = PBField.initRepeatMessage(newyear_report$NYReportItems.class);
    };
    public newyear_report$OptionReq option = new MessageMicro<newyear_report$OptionReq>() { // from class: tencent.im.new_year_2021.newyear_report$OptionReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74, 82}, new String[]{"fingerprint", "model", "manufacturer", "brand", "device", "product", "id", "level", "cpu_abi", "cpu_abi2"}, new Object[]{"", "", "", "", "", "", "", 0, "", ""}, newyear_report$OptionReq.class);
        public final PBStringField fingerprint = PBField.initString("");
        public final PBStringField model = PBField.initString("");
        public final PBStringField manufacturer = PBField.initString("");
        public final PBStringField brand = PBField.initString("");
        public final PBStringField device = PBField.initString("");
        public final PBStringField product = PBField.initString("");

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f435962id = PBField.initString("");
        public final PBInt32Field level = PBField.initInt32(0);
        public final PBStringField cpu_abi = PBField.initString("");
        public final PBStringField cpu_abi2 = PBField.initString("");
    };
}
