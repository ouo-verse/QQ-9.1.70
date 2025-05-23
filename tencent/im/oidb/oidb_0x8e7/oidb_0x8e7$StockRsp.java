package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e7$StockRsp extends MessageMicro<oidb_0x8e7$StockRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int32_total", "int32_stock", "int32_give_count"}, new Object[]{0, 0, 0}, oidb_0x8e7$StockRsp.class);
    public final PBInt32Field int32_total = PBField.initInt32(0);
    public final PBInt32Field int32_stock = PBField.initInt32(0);
    public final PBInt32Field int32_give_count = PBField.initInt32(0);
}
