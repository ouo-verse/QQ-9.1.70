package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6c3$StockItem extends MessageMicro<oidb_0x6c3$StockItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int32_productid", "int32_amount", "int32_free_limit_chance"}, new Object[]{0, 0, 0}, oidb_0x6c3$StockItem.class);
    public final PBInt32Field int32_productid = PBField.initInt32(0);
    public final PBInt32Field int32_amount = PBField.initInt32(0);
    public final PBInt32Field int32_free_limit_chance = PBField.initInt32(0);
}
