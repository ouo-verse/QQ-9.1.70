package tencent.im.new_year_2020;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class newyear_report$NYReportRsp extends MessageMicro<newyear_report$NYReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"ret", "errMsg", "batchSize", "reportLevel", "reportLevelTime"}, new Object[]{0, "", 0, 0, 0}, newyear_report$NYReportRsp.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBStringField errMsg = PBField.initString("");
    public final PBUInt32Field batchSize = PBField.initUInt32(0);
    public final PBUInt32Field reportLevel = PBField.initUInt32(0);
    public final PBUInt32Field reportLevelTime = PBField.initUInt32(0);

    public String toString() {
        return "NYReportRsp{ret=" + this.ret.get() + ", errMsg=" + this.errMsg.get() + ", batchSize=" + this.batchSize.get() + ", reportLevel=" + this.reportLevel.get() + ", reportLevelTime=" + this.reportLevelTime.get() + '}';
    }
}
