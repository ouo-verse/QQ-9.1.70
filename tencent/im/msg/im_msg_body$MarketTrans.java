package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$MarketTrans extends MessageMicro<im_msg_body$MarketTrans> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid;
    public final PBBytesField bytes_xml;
    public final PBInt32Field int32_flag = PBField.initInt32(0);
    public final PBUInt32Field uint32_ability;
    public final PBUInt32Field uint32_min_ability;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"int32_flag", "bytes_xml", "bytes_msg_resid", "uint32_ability", "uint32_min_ability"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0}, im_msg_body$MarketTrans.class);
    }

    public im_msg_body$MarketTrans() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_xml = PBField.initBytes(byteStringMicro);
        this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
        this.uint32_ability = PBField.initUInt32(0);
        this.uint32_min_ability = PBField.initUInt32(0);
    }
}
