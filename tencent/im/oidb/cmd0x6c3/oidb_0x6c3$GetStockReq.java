package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6c3$GetStockReq extends MessageMicro<oidb_0x6c3$GetStockReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"bool_not_need_gift_stock", "uint32_imgshow_config", "uint32_not_give_stock", "uint32_not_midas_stock"}, new Object[]{Boolean.FALSE, 0, 0, 0}, oidb_0x6c3$GetStockReq.class);
    public final PBBoolField bool_not_need_gift_stock = PBField.initBool(false);
    public final PBUInt32Field uint32_imgshow_config = PBField.initUInt32(0);
    public final PBUInt32Field uint32_not_give_stock = PBField.initUInt32(0);
    public final PBUInt32Field uint32_not_midas_stock = PBField.initUInt32(0);
}
