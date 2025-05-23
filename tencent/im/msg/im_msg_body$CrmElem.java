package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$CrmElem extends MessageMicro<im_msg_body$CrmElem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid;
    public final PBBytesField crm_buf;
    public final PBUInt32Field uint32_count_flag;
    public final PBUInt32Field uint32_push_flag;
    public final PBUInt32Field uint32_qidian_flag;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"crm_buf", "bytes_msg_resid", "uint32_qidian_flag", "uint32_push_flag", "uint32_count_flag"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0}, im_msg_body$CrmElem.class);
    }

    public im_msg_body$CrmElem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.crm_buf = PBField.initBytes(byteStringMicro);
        this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
        this.uint32_qidian_flag = PBField.initUInt32(0);
        this.uint32_push_flag = PBField.initUInt32(0);
        this.uint32_count_flag = PBField.initUInt32(0);
    }
}
