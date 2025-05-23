package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x111$GroupInfo extends MessageMicro<subcmd0x111$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "bytes_name"}, new Object[]{0, ByteStringMicro.EMPTY}, subcmd0x111$GroupInfo.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
}
