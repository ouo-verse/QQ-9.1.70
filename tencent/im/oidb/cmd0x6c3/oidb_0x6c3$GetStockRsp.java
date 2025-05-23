package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6c3$GetStockRsp extends MessageMicro<oidb_0x6c3$GetStockRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_give_info;
    public final PBBytesField bytes_midas_error;
    public final PBBytesField bytes_recharge_activity;
    public final PBInt32Field int32_count = PBField.initInt32(0);
    public final PBInt32Field int32_give_count = PBField.initInt32(0);
    public final PBInt64Field int64_balance;
    public final PBInt64Field int64_midas_gen_balance;
    public oidb_0x6c3$ImgShowConfig msg_imgshow_config;
    public oidb_0x6c3$StockInfo msg_stock;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 56, 64, 74}, new String[]{"int32_count", "int32_give_count", "bytes_give_info", "msg_stock", "bytes_recharge_activity", "msg_imgshow_config", "int64_balance", "int64_midas_gen_balance", "bytes_midas_error"}, new Object[]{0, 0, byteStringMicro, null, byteStringMicro, null, 0L, 0L, byteStringMicro}, oidb_0x6c3$GetStockRsp.class);
    }

    public oidb_0x6c3$GetStockRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_give_info = PBField.initBytes(byteStringMicro);
        this.msg_stock = new oidb_0x6c3$StockInfo();
        this.bytes_recharge_activity = PBField.initBytes(byteStringMicro);
        this.msg_imgshow_config = new oidb_0x6c3$ImgShowConfig();
        this.int64_balance = PBField.initInt64(0L);
        this.int64_midas_gen_balance = PBField.initInt64(0L);
        this.bytes_midas_error = PBField.initBytes(byteStringMicro);
    }
}
