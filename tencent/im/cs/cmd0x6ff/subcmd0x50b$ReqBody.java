package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x50b$ReqBody extends MessageMicro<subcmd0x50b$ReqBody> {
    public static final int MSG_SUBCMD_0X50C_REQ_BODY_FIELD_NUMBER = 1291;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10330}, new String[]{"msg_subcmd_0x50c_req_body"}, new Object[]{null}, subcmd0x50b$ReqBody.class);
    public subcmd0x50b$SubCmd0x50bReqBody msg_subcmd_0x50c_req_body = new MessageMicro<subcmd0x50b$SubCmd0x50bReqBody>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x50b$SubCmd0x50bReqBody
        public static final int BYTES_MSG_RESID_FIELD_NUMBER = 1;
        public static final int BYTES_MSG_UKEY_FIELD_NUMBER = 2;
        public static final int BYTES_OBJ_MSG_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_msg_resid;
        public final PBBytesField bytes_msg_ukey;
        public final PBBytesField bytes_obj_msg;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_msg_resid", "bytes_msg_ukey", "bytes_obj_msg"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, subcmd0x50b$SubCmd0x50bReqBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
            this.bytes_msg_ukey = PBField.initBytes(byteStringMicro);
            this.bytes_obj_msg = PBField.initBytes(byteStringMicro);
        }
    };
}
