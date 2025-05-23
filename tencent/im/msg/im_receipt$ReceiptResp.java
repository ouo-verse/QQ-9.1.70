package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_receipt$ReceiptResp extends MessageMicro<im_receipt$ReceiptResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"command", "receipt_info"}, new Object[]{1, null}, im_receipt$ReceiptResp.class);
    public final PBEnumField command = PBField.initEnum(1);
    public im_receipt$ReceiptInfo receipt_info = new im_receipt$ReceiptInfo();
}
