package qzone;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class qzoneUnifiedStore$MemberPrice extends MessageMicro<qzoneUnifiedStore$MemberPrice> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "months", "cost_cent", "original_cost_cent", "price_tag"}, new Object[]{"", 0, 0L, 0L, ""}, qzoneUnifiedStore$MemberPrice.class);
    public final PBStringField product_id = PBField.initString("");
    public final PBInt32Field months = PBField.initInt32(0);
    public final PBInt64Field cost_cent = PBField.initInt64(0);
    public final PBInt64Field original_cost_cent = PBField.initInt64(0);
    public final PBStringField price_tag = PBField.initString("");
}
