package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6cd$RepointExtraInfo extends MessageMicro<cmd0x6cd$RepointExtraInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_count", "str_icon_url", "str_tips", "bytes_data"}, new Object[]{0, "", "", ByteStringMicro.EMPTY}, cmd0x6cd$RepointExtraInfo.class);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_tips = PBField.initString("");
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
