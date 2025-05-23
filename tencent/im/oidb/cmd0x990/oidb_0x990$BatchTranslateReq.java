package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x990$BatchTranslateReq extends MessageMicro<oidb_0x990$BatchTranslateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_src_language", "str_dst_language", "rpt_src_bytes_text_list"}, new Object[]{"", "", ByteStringMicro.EMPTY}, oidb_0x990$BatchTranslateReq.class);
    public final PBStringField str_src_language = PBField.initString("");
    public final PBStringField str_dst_language = PBField.initString("");
    public final PBRepeatField<ByteStringMicro> rpt_src_bytes_text_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
