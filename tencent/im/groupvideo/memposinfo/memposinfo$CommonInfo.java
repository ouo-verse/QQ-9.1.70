package tencent.im.groupvideo.memposinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class memposinfo$CommonInfo extends MessageMicro<memposinfo$CommonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_account", "bytes_account", "uint32_source"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, memposinfo$CommonInfo.class);
    public final PBUInt64Field uint64_account = PBField.initUInt64(0);
    public final PBBytesField bytes_account = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
}
