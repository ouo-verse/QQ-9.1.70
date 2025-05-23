package tencent.im.oidb;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbcb$CheckUrlReq extends MessageMicro<oidb_0xbcb$CheckUrlReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField ark_name;
    public final PBBoolField is_ark;
    public final PBBoolField is_finish;
    public final PBUInt64Field msg_chatid;
    public final PBUInt32Field msg_from;
    public final PBUInt32Field msg_type;
    public final PBStringField original_url;
    public final PBStringField plateform;
    public final PBStringField qq_pf_to;
    public final PBStringField qua;
    public final PBStringField refer;
    public final PBStringField req_type;
    public final PBUInt64Field send_uin;
    public final PBUInt64Field service_type;
    public final PBUInt32Field src_platform;
    public final PBRepeatField<String> src_urls;
    public final PBRepeatField<String> url;

    static {
        String[] strArr = {"url", "refer", "plateform", "qq_pf_to", QQHealthReportApiImpl.MSG_TYPE_KEY, "msg_from", "msg_chatid", "service_type", "send_uin", AppConstants.Key.SHARE_REQ_TYPE, "original_url", "is_ark", "ark_name", "is_finish", "src_urls", "src_platform", "qua"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64, 72, 82, 90, 96, 106, 112, 122, 128, 138}, strArr, new Object[]{"", "", "", "", 0, 0, 0L, 0L, 0L, "", "", bool, "", bool, "", 0, ""}, oidb_0xbcb$CheckUrlReq.class);
    }

    public oidb_0xbcb$CheckUrlReq() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.url = PBField.initRepeat(pBStringField);
        this.refer = PBField.initString("");
        this.plateform = PBField.initString("");
        this.qq_pf_to = PBField.initString("");
        this.msg_type = PBField.initUInt32(0);
        this.msg_from = PBField.initUInt32(0);
        this.msg_chatid = PBField.initUInt64(0L);
        this.service_type = PBField.initUInt64(0L);
        this.send_uin = PBField.initUInt64(0L);
        this.req_type = PBField.initString("");
        this.original_url = PBField.initString("");
        this.is_ark = PBField.initBool(false);
        this.ark_name = PBField.initString("");
        this.is_finish = PBField.initBool(false);
        this.src_urls = PBField.initRepeat(pBStringField);
        this.src_platform = PBField.initUInt32(0);
        this.qua = PBField.initString("");
    }
}
