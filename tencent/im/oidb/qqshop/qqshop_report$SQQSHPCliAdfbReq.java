package tencent.im.oidb.qqshop;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* loaded from: classes29.dex */
public final class qqshop_report$SQQSHPCliAdfbReq extends MessageMicro<qqshop_report$SQQSHPCliAdfbReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "msgid", "uin", QQHealthReportApiImpl.MSG_TYPE_KEY, WinkDaTongReportConstant.ElementParamKey.ADID, "viewid"}, new Object[]{0L, 0L, 0L, 0, "", ""}, qqshop_report$SQQSHPCliAdfbReq.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt64Field msgid = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt32Field msg_type = PBField.initInt32(0);
    public final PBStringField adid = PBField.initString("");
    public final PBStringField viewid = PBField.initString("");
}
