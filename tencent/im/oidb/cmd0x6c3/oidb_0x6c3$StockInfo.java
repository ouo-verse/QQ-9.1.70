package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6c3$StockInfo extends MessageMicro<oidb_0x6c3$StockInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_stock"}, new Object[]{null}, oidb_0x6c3$StockInfo.class);
    public final PBRepeatMessageField<oidb_0x6c3$StockItem> msg_stock = PBField.initRepeatMessage(oidb_0x6c3$StockItem.class);
}
