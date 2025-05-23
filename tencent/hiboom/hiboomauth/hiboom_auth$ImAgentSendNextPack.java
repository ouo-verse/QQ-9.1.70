package tencent.hiboom.hiboomauth;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_imagent$ImAgentHead;
import tencent.im.msg.im_msg_body$CommonElem;

/* loaded from: classes29.dex */
public final class hiboom_auth$ImAgentSendNextPack extends MessageMicro<hiboom_auth$ImAgentSendNextPack> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 106, 114}, new String[]{"head", "reqBody", "rspBody"}, new Object[]{null, null, null}, hiboom_auth$ImAgentSendNextPack.class);
    public im_imagent$ImAgentHead head = new im_imagent$ImAgentHead();
    public hiboom_auth$AuthReqBody reqBody = new MessageMicro<hiboom_auth$AuthReqBody>() { // from class: tencent.hiboom.hiboomauth.hiboom_auth$AuthReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"u64_uin", "i32_implat", "str_version", "req_elem", "u32_product_id"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, null, 0}, hiboom_auth$AuthReqBody.class);
        public final PBUInt64Field u64_uin = PBField.initUInt64(0);
        public final PBInt32Field i32_implat = PBField.initInt32(0);
        public final PBBytesField str_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public im_msg_body$CommonElem req_elem = new im_msg_body$CommonElem();
        public final PBUInt32Field u32_product_id = PBField.initUInt32(0);
    };
    public hiboom_auth$AuthRspBody rspBody = new MessageMicro<hiboom_auth$AuthRspBody>() { // from class: tencent.hiboom.hiboomauth.hiboom_auth$AuthRspBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_err_msg;
        public final PBBytesField bytes_trans_info;
        public final PBInt32Field i32_result = PBField.initInt32(0);
        public final PBUInt32Field u32_business_type;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"i32_result", "bytes_err_msg", "bytes_trans_info", "u32_business_type"}, new Object[]{0, byteStringMicro, byteStringMicro, 0}, hiboom_auth$AuthRspBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_err_msg = PBField.initBytes(byteStringMicro);
            this.bytes_trans_info = PBField.initBytes(byteStringMicro);
            this.u32_business_type = PBField.initUInt32(0);
        }
    };
}
