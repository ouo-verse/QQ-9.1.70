package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6b6$RspBody extends MessageMicro<oidb_0x6b6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_notify;
    public final PBBytesField bytes_msg;
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public oidb_0x6b6$SendFlowerRsp msg_send_flower;
    public oidb_0x6b6$ThrowFlowerRsp msg_throw_flower;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 34, 42, 50}, new String[]{"int32_ret", "bytes_msg", "msg_send_flower", "msg_throw_flower", "bytes_error_notify"}, new Object[]{0, byteStringMicro, null, null, byteStringMicro}, oidb_0x6b6$RspBody.class);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [tencent.im.oidb.cmd0x6b6.oidb_0x6b6$SendFlowerRsp] */
    /* JADX WARN: Type inference failed for: r1v2, types: [tencent.im.oidb.cmd0x6b6.oidb_0x6b6$ThrowFlowerRsp] */
    public oidb_0x6b6$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg = PBField.initBytes(byteStringMicro);
        this.msg_send_flower = new MessageMicro<oidb_0x6b6$SendFlowerRsp>() { // from class: tencent.im.oidb.cmd0x6b6.oidb_0x6b6$SendFlowerRsp
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_imagent_package;
            public final PBBytesField bytes_midas_json;
            public final PBBytesField bytes_product_name;
            public final PBInt64Field int64_give_stock;
            public final PBUInt32Field uint32_balance;
            public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"uint32_product_id", "bytes_midas_json", "int64_give_stock", "uint32_balance", "bytes_product_name", "bytes_imagent_package"}, new Object[]{0, byteStringMicro2, 0L, 0, byteStringMicro2, byteStringMicro2}, oidb_0x6b6$SendFlowerRsp.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_midas_json = PBField.initBytes(byteStringMicro2);
                this.int64_give_stock = PBField.initInt64(0L);
                this.uint32_balance = PBField.initUInt32(0);
                this.bytes_product_name = PBField.initBytes(byteStringMicro2);
                this.bytes_imagent_package = PBField.initBytes(byteStringMicro2);
            }
        };
        this.msg_throw_flower = new MessageMicro<oidb_0x6b6$ThrowFlowerRsp>() { // from class: tencent.im.oidb.cmd0x6b6.oidb_0x6b6$ThrowFlowerRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_product_id"}, new Object[]{0}, oidb_0x6b6$ThrowFlowerRsp.class);
            public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
        };
        this.bytes_error_notify = PBField.initBytes(byteStringMicro);
    }
}
