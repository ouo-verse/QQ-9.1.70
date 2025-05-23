package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcdd$QueryStateReq extends MessageMicro<oidb_cmd0xcdd$QueryStateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"qr_sig"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0xcdd$QueryStateReq.class);
    public final PBBytesField qr_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
