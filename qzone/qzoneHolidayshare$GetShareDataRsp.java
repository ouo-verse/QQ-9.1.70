package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneHolidayshare$GetShareDataRsp extends MessageMicro<qzoneHolidayshare$GetShareDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"url", "display_data"}, new Object[]{"", null}, qzoneHolidayshare$GetShareDataRsp.class);
    public final PBStringField url = PBField.initString("");
    public qzoneHolidayshare$DisplayData display_data = new qzoneHolidayshare$DisplayData();
}
