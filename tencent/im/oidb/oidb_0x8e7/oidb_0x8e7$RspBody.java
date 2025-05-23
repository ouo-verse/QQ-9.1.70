package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e7$RspBody extends MessageMicro<oidb_0x8e7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_recharge_url;
    public final PBBytesField bytes_update_url;
    public oidb_0x8e7$WarnMsg msg_warn;
    public oidb_0x8e7$StockRsp msg_stock_rsp = new oidb_0x8e7$StockRsp();
    public oidb_0x8e7$ZanLimitInfo msg_zan_limit = new oidb_0x8e7$ZanLimitInfo();

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"msg_stock_rsp", "msg_zan_limit", "bytes_recharge_url", "msg_warn", "bytes_update_url"}, new Object[]{null, null, byteStringMicro, null, byteStringMicro}, oidb_0x8e7$RspBody.class);
    }

    public oidb_0x8e7$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_recharge_url = PBField.initBytes(byteStringMicro);
        this.msg_warn = new oidb_0x8e7$WarnMsg();
        this.bytes_update_url = PBField.initBytes(byteStringMicro);
    }
}
