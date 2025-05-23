package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb54$RelatedSearchWord extends MessageMicro<oidb_cmd0xb54$RelatedSearchWord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 29, 34, 40}, new String[]{"bytes_word", "str_jmp_url", "float_score", "str_modle_name", "uint32_modle_id"}, new Object[]{ByteStringMicro.EMPTY, "", Float.valueOf(0.0f), "", 0}, oidb_cmd0xb54$RelatedSearchWord.class);
    public final PBBytesField bytes_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_jmp_url = PBField.initString("");
    public final PBFloatField float_score = PBField.initFloat(0.0f);
    public final PBStringField str_modle_name = PBField.initString("");
    public final PBUInt32Field uint32_modle_id = PBField.initUInt32(0);
}
