package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_im_msg_body$CommonElem extends MessageMicro<nt_im_msg_body$CommonElem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_service_type", "bytes_pb_elem", "uint32_business_type"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, nt_im_msg_body$CommonElem.class);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public final PBBytesField bytes_pb_elem = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
}
