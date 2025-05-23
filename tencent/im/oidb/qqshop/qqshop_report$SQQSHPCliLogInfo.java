package tencent.im.oidb.qqshop;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class qqshop_report$SQQSHPCliLogInfo extends MessageMicro<qqshop_report$SQQSHPCliLogInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 72, 80, 88, 96, 106, 114}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "tvalue", "cnt", "network", "strp1", "strp2", "strp3", "strp4", "uintp1", "uintp2", "uintp3", "uintp4", "wifimac", "ifda"}, new Object[]{0L, 0, 0, 0, "", "", "", "", 0L, 0L, 0L, 0L, "", ""}, qqshop_report$SQQSHPCliLogInfo.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt32Field tvalue = PBField.initUInt32(0);
    public final PBUInt32Field cnt = PBField.initUInt32(0);
    public final PBUInt32Field network = PBField.initUInt32(0);
    public final PBStringField strp1 = PBField.initString("");
    public final PBStringField strp2 = PBField.initString("");
    public final PBStringField strp3 = PBField.initString("");
    public final PBStringField strp4 = PBField.initString("");
    public final PBUInt64Field uintp1 = PBField.initUInt64(0);
    public final PBUInt64Field uintp2 = PBField.initUInt64(0);
    public final PBUInt64Field uintp3 = PBField.initUInt64(0);
    public final PBUInt64Field uintp4 = PBField.initUInt64(0);
    public final PBStringField wifimac = PBField.initString("");
    public final PBStringField ifda = PBField.initString("");
}
