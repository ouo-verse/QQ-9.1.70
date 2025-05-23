package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class online_docs$DocId extends MessageMicro<online_docs$DocId> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"domain_id", "pad_id"}, new Object[]{0L, ByteStringMicro.EMPTY}, online_docs$DocId.class);
    public final PBUInt64Field domain_id = PBField.initUInt64(0);
    public final PBBytesField pad_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
