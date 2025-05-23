package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x990$TranslateRsp extends MessageMicro<oidb_0x990$TranslateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"int32_ret_code", "int32_type", "bytes_trans_result", "int32_text_len"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0}, oidb_0x990$TranslateRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBInt32Field int32_type = PBField.initInt32(0);
    public final PBBytesField bytes_trans_result = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_text_len = PBField.initInt32(0);
}
