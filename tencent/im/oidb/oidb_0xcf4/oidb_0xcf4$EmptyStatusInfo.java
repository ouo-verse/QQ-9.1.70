package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$EmptyStatusInfo extends MessageMicro<oidb_0xcf4$EmptyStatusInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_jump_url"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xcf4$EmptyStatusInfo.class);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
}
