package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xe03$ProfileTagInfo extends MessageMicro<oidb_0xe03$ProfileTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_tag", "uint32_same_flag"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0xe03$ProfileTagInfo.class);
    public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_same_flag = PBField.initUInt32(0);
}
