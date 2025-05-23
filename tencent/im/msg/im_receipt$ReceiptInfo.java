package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_receipt$ReceiptInfo extends MessageMicro<im_receipt$ReceiptInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_read_time"}, new Object[]{0L}, im_receipt$ReceiptInfo.class);
    public final PBUInt64Field uint64_read_time = PBField.initUInt64(0);
}
