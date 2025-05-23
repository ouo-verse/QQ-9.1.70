package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6c3$RspBody extends MessageMicro<oidb_0x6c3$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"int32_ret", "bytes_msg", "msg_get_stock", "msg_extra_data", "exclusive_gift_list"}, new Object[]{0, ByteStringMicro.EMPTY, null, null, null}, oidb_0x6c3$RspBody.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6c3$GetStockRsp msg_get_stock = new oidb_0x6c3$GetStockRsp();
    public oidb_0x6c3$GetExtraDataRsp msg_extra_data = new oidb_0x6c3$GetExtraDataRsp();
    public final PBRepeatMessageField<oidb_0x6c3$ExclusiveGiftItem> exclusive_gift_list = PBField.initRepeatMessage(oidb_0x6c3$ExclusiveGiftItem.class);
}
