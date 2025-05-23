package tencent.im.oidb.cmd0xa8d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0xa8d$Cmd0xa8dExitPublicGroupReqBody extends MessageMicro<oidb_0xa8d$Cmd0xa8dExitPublicGroupReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_visitor_uin"}, new Object[]{0L}, oidb_0xa8d$Cmd0xa8dExitPublicGroupReqBody.class);
    public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0);
}
