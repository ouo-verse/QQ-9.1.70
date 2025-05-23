package tencent.im.oidb.cmd0x59a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x59a$ReqBody extends MessageMicro<oidb_cmd0x59a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cgi_version;
    public final PBBytesField bytes_client_version;
    public final PBBytesField bytes_web_version;
    public oidb_cmd0x59a$ExpertFields msg_expert_fields;
    public final PBUInt32Field uint32_category_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_expert_tinyid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50}, new String[]{"uint32_category_id", "bytes_client_version", "bytes_web_version", "bytes_cgi_version", "uint64_expert_tinyid", "msg_expert_fields"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, 0L, null}, oidb_cmd0x59a$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [tencent.im.oidb.cmd0x59a.oidb_cmd0x59a$ExpertFields] */
    public oidb_cmd0x59a$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_client_version = PBField.initBytes(byteStringMicro);
        this.bytes_web_version = PBField.initBytes(byteStringMicro);
        this.bytes_cgi_version = PBField.initBytes(byteStringMicro);
        this.uint64_expert_tinyid = PBField.initUInt64(0L);
        this.msg_expert_fields = new MessageMicro<oidb_cmd0x59a$ExpertFields>() { // from class: tencent.im.oidb.cmd0x59a.oidb_cmd0x59a$ExpertFields
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{168, 176}, new String[]{"uint32_req_name", "uint32_req_face_url"}, new Object[]{0, 0}, oidb_cmd0x59a$ExpertFields.class);
            public final PBUInt32Field uint32_req_name = PBField.initUInt32(0);
            public final PBUInt32Field uint32_req_face_url = PBField.initUInt32(0);
        };
    }
}
