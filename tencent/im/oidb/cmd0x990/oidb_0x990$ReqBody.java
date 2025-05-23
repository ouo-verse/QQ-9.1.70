package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x990$ReqBody extends MessageMicro<oidb_0x990$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_translate_req", "msg_batch_translate_req"}, new Object[]{null, null}, oidb_0x990$ReqBody.class);
    public oidb_0x990$TranslateReq msg_translate_req = new MessageMicro<oidb_0x990$TranslateReq>() { // from class: tencent.im.oidb.cmd0x990.oidb_0x990$TranslateReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"bytes_text", "int32_type", "str_src_language", "str_dst_language"}, new Object[]{ByteStringMicro.EMPTY, 0, "", ""}, oidb_0x990$TranslateReq.class);
        public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field int32_type = PBField.initInt32(0);
        public final PBStringField str_src_language = PBField.initString("");
        public final PBStringField str_dst_language = PBField.initString("");
    };
    public oidb_0x990$BatchTranslateReq msg_batch_translate_req = new oidb_0x990$BatchTranslateReq();
}
