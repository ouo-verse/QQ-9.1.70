package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class qzoneUnifiedStore$PayOrderReq extends MessageMicro<qzoneUnifiedStore$PayOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"space_id", "day_indexs", "pay_channel"}, new Object[]{"", "", 0}, qzoneUnifiedStore$PayOrderReq.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBRepeatField<String> day_indexs = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField pay_channel = PBField.initEnum(0);
}
