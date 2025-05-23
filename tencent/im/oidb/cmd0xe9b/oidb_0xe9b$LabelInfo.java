package tencent.im.oidb.cmd0xe9b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe9b$LabelInfo extends MessageMicro<oidb_0xe9b$LabelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_name"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xe9b$LabelInfo.class);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
}
