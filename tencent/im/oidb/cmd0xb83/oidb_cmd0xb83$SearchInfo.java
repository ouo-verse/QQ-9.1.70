package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb83$SearchInfo extends MessageMicro<oidb_cmd0xb83$SearchInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_key"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0xb83$SearchInfo.class);
    public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
}
