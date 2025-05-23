package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fc$CardNameElem extends MessageMicro<Oidb_0x8fc$CardNameElem> {
    public static final int CARD_TYPE_TEXT = 1;
    public static final int CARD_TYPE_XC = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"enum_card_type", "bytes_value"}, new Object[]{1, ByteStringMicro.EMPTY}, Oidb_0x8fc$CardNameElem.class);
    public final PBEnumField enum_card_type = PBField.initEnum(1);
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
}
