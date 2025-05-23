package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe03$TagInfo extends MessageMicro<oidb_0xe03$TagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_tag_id", "bytes_tag", "uint32_hot_flag"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, oidb_0xe03$TagInfo.class);
    public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
    public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
}
