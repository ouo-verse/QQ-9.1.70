package tencent.im.oidb.cmd0x77d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x77d$ReqBody extends MessageMicro<oidb_cmd0x77d$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_reward_cookie"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0x77d$ReqBody.class);
    public final PBBytesField bytes_reward_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
