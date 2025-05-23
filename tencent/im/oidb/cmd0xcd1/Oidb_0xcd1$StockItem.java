package tencent.im.oidb.cmd0xcd1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xcd1$StockItem extends MessageMicro<Oidb_0xcd1$StockItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_productid", "int32_amount"}, new Object[]{0, 0}, Oidb_0xcd1$StockItem.class);
    public final PBInt32Field int32_productid = PBField.initInt32(0);
    public final PBInt32Field int32_amount = PBField.initInt32(0);
}
