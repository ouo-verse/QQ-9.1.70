package tencent.im.oidb;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbcb$CheckUrlReqItem extends MessageMicro<oidb_0xbcb$CheckUrlReqItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64, 72, 82}, new String[]{"url", "refer", "plateform", "qq_pf_to", QQHealthReportApiImpl.MSG_TYPE_KEY, "msg_from", "msg_chatid", "service_type", "send_uin", AppConstants.Key.SHARE_REQ_TYPE}, new Object[]{"", "", "", "", 0, 0, 0L, 0L, 0L, ""}, oidb_0xbcb$CheckUrlReqItem.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField refer = PBField.initString("");
    public final PBStringField plateform = PBField.initString("");
    public final PBStringField qq_pf_to = PBField.initString("");
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt32Field msg_from = PBField.initUInt32(0);
    public final PBUInt64Field msg_chatid = PBField.initUInt64(0);
    public final PBUInt64Field service_type = PBField.initUInt64(0);
    public final PBUInt64Field send_uin = PBField.initUInt64(0);
    public final PBStringField req_type = PBField.initString("");
}
