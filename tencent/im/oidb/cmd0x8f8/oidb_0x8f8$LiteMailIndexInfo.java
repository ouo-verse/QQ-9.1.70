package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f8$LiteMailIndexInfo extends MessageMicro<oidb_0x8f8$LiteMailIndexInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_feeds_id", "msg_source_id"}, new Object[]{ByteStringMicro.EMPTY, null}, oidb_0x8f8$LiteMailIndexInfo.class);
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8f8$SourceID msg_source_id = new oidb_0x8f8$SourceID();
}
