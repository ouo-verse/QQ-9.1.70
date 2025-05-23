package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowWangZheReportTabData$HokTabInfoRsp extends MessageMicro<ShadowWangZheReportTabData$HokTabInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f429490msg = PBField.initString("");
    public final PBBoolField show_hok_tab = PBField.initBool(false);
    public final PBBoolField show_red_point = PBField.initBool(false);
    public final PBStringField hok_report_url = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"code", "msg", "show_hok_tab", "show_red_point", "hok_report_url"}, new Object[]{0, "", bool, bool, ""}, ShadowWangZheReportTabData$HokTabInfoRsp.class);
    }
}
