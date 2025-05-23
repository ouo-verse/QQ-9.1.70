package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qqwalletaio_resv$qqwalletaio_body_resv extends MessageMicro<qqwalletaio_resv$qqwalletaio_body_resv> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_extend;
    public final PBBytesField bytes_feeds_id;
    public final PBBytesField bytes_poem_rule;
    public final PBBytesField bytes_rareword_rule;
    public final PBBytesField bytes_zplan_uin;
    public final PBUInt32Field uint32_avatar_id;
    public final PBUInt32Field uint32_cover_id;
    public final PBUInt32Field uint32_hb_flag;
    public final PBUInt32Field uint32_pay_flag;
    public final PBUInt32Field uint32_pfa_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subchannel;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 56, 64, 72, 80, 90}, new String[]{"uint32_pfa_type", "bytes_feeds_id", "uint32_subchannel", "bytes_poem_rule", "bytes_client_extend", "bytes_rareword_rule", "uint32_pay_flag", "uint32_hb_flag", "uint32_avatar_id", "uint32_cover_id", "bytes_zplan_uin"}, new Object[]{0, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro}, qqwalletaio_resv$qqwalletaio_body_resv.class);
    }

    public qqwalletaio_resv$qqwalletaio_body_resv() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_feeds_id = PBField.initBytes(byteStringMicro);
        this.uint32_subchannel = PBField.initUInt32(0);
        this.bytes_poem_rule = PBField.initBytes(byteStringMicro);
        this.bytes_client_extend = PBField.initBytes(byteStringMicro);
        this.bytes_rareword_rule = PBField.initBytes(byteStringMicro);
        this.uint32_pay_flag = PBField.initUInt32(0);
        this.uint32_hb_flag = PBField.initUInt32(0);
        this.uint32_avatar_id = PBField.initUInt32(0);
        this.uint32_cover_id = PBField.initUInt32(0);
        this.bytes_zplan_uin = PBField.initBytes(byteStringMicro);
    }
}
