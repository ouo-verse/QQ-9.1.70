package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$ReportNetConnectInfoRequest extends MessageMicro<ArticleComment$ReportNetConnectInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 56, 64}, new String[]{"versionInfo", "website_address", "errorcode", "url", "DNSCost", "connectCost", "receiveCost", "netType"}, new Object[]{"", "", 0, ByteStringMicro.EMPTY, 0, 0, 0, 0}, ArticleComment$ReportNetConnectInfoRequest.class);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBStringField website_address = PBField.initString("");
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field DNSCost = PBField.initUInt32(0);
    public final PBUInt32Field connectCost = PBField.initUInt32(0);
    public final PBUInt32Field receiveCost = PBField.initUInt32(0);
    public final PBInt32Field netType = PBField.initInt32(0);
}
