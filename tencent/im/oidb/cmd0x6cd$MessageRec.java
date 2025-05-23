package tencent.im.oidb;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6cd$MessageRec extends MessageMicro<cmd0x6cd$MessageRec> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_seq", "uint32_time", MessageForUniteGrayTip.KEY_BYTES_CONTENT}, new Object[]{0L, 0, ByteStringMicro.EMPTY}, cmd0x6cd$MessageRec.class);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
}
