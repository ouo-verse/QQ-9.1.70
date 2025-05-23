package tencent.im.oidb.qqshop;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* loaded from: classes29.dex */
public final class qqshop_richmsg$SQQSHPFolderAdMsg extends MessageMicro<qqshop_richmsg$SQQSHPFolderAdMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 72, 82}, new String[]{"ad_id", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time", IPublicAccountBrowser.KEY_PUB_UIN, "ad_url", "title", "pic_url", "name", "verify_flag", "ad_content_url"}, new Object[]{0L, 0, 0, 0L, "", "", "", "", 0, ""}, qqshop_richmsg$SQQSHPFolderAdMsg.class);
    public final PBUInt64Field ad_id = PBField.initUInt64(0);
    public final PBUInt32Field begin_time = PBField.initUInt32(0);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBStringField ad_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBRepeatField<String> pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field verify_flag = PBField.initUInt32(0);
    public final PBStringField ad_content_url = PBField.initString("");
}
