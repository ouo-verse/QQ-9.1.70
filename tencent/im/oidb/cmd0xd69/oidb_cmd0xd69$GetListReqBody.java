package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd69$GetListReqBody extends MessageMicro<oidb_cmd0xd69$GetListReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"req_num", "bytes_cookies"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_cmd0xd69$GetListReqBody.class);
    public final PBUInt32Field req_num = PBField.initUInt32(0);
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
}
