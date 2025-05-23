package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class qzoneUnifiedStore$PayOrderRsp extends MessageMicro<qzoneUnifiedStore$PayOrderRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"pay_result"}, new Object[]{0}, qzoneUnifiedStore$PayOrderRsp.class);
    public final PBEnumField pay_result = PBField.initEnum(0);
}
