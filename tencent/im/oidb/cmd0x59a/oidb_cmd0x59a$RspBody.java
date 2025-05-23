package tencent.im.oidb.cmd0x59a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x59a$RspBody extends MessageMicro<oidb_cmd0x59a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_category_id", "msg_expert_info"}, new Object[]{0, null}, oidb_cmd0x59a$RspBody.class);
    public final PBUInt32Field uint32_category_id = PBField.initUInt32(0);
    public oidb_cmd0x59a$ExpertInfo msg_expert_info = new MessageMicro<oidb_cmd0x59a$ExpertInfo>() { // from class: tencent.im.oidb.cmd0x59a.oidb_cmd0x59a$ExpertInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_face_url;
        public final PBBytesField bytes_name;
        public final PBUInt64Field uint64_expert_tinyid = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 170, 178}, new String[]{"uint64_expert_tinyid", "bytes_name", "bytes_face_url"}, new Object[]{0L, byteStringMicro, byteStringMicro}, oidb_cmd0x59a$ExpertInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_name = PBField.initBytes(byteStringMicro);
            this.bytes_face_url = PBField.initBytes(byteStringMicro);
        }
    };
}
