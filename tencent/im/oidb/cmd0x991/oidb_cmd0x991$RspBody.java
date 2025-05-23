package tencent.im.oidb.cmd0x991;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x991$RspBody extends MessageMicro<oidb_cmd0x991$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_stock_rsp"}, new Object[]{null}, oidb_cmd0x991$RspBody.class);
    public oidb_cmd0x991$StockRsp msg_stock_rsp = new MessageMicro<oidb_cmd0x991$StockRsp>() { // from class: tencent.im.oidb.cmd0x991.oidb_cmd0x991$StockRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"int64_user_stock", "int64_give_stock", "int64_midas_balance", "bytes_midas_json"}, new Object[]{0L, 0L, 0L, ByteStringMicro.EMPTY}, oidb_cmd0x991$StockRsp.class);
        public final PBInt64Field int64_user_stock = PBField.initInt64(0);
        public final PBInt64Field int64_give_stock = PBField.initInt64(0);
        public final PBInt64Field int64_midas_balance = PBField.initInt64(0);
        public final PBBytesField bytes_midas_json = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
