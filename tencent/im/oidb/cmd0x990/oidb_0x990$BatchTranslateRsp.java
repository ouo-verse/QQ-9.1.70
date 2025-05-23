package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x990$BatchTranslateRsp extends MessageMicro<oidb_0x990$BatchTranslateRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_dst_bytes_text_list;
    public final PBRepeatField<ByteStringMicro> rpt_src_bytes_text_list;
    public final PBInt32Field int32_error_code = PBField.initInt32(0);
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_src_language = PBField.initString("");
    public final PBStringField str_dst_language = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"int32_error_code", "bytes_error_msg", "str_src_language", "str_dst_language", "rpt_src_bytes_text_list", "rpt_dst_bytes_text_list"}, new Object[]{0, byteStringMicro, "", "", byteStringMicro, byteStringMicro}, oidb_0x990$BatchTranslateRsp.class);
    }

    public oidb_0x990$BatchTranslateRsp() {
        PBBytesField pBBytesField = PBBytesField.__repeatHelper__;
        this.rpt_src_bytes_text_list = PBField.initRepeat(pBBytesField);
        this.rpt_dst_bytes_text_list = PBField.initRepeat(pBBytesField);
    }
}
