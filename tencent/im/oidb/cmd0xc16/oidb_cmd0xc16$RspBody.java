package tencent.im.oidb.cmd0xc16;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc16$RspBody extends MessageMicro<oidb_cmd0xc16$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_topic_id", "bytes_topic_url"}, new Object[]{0L, ByteStringMicro.EMPTY}, oidb_cmd0xc16$RspBody.class);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0);
    public final PBBytesField bytes_topic_url = PBField.initBytes(ByteStringMicro.EMPTY);
}
