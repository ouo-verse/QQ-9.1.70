package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class qqshop$SQQSHPClientRsp extends MessageMicro<qqshop$SQQSHPClientRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"recmdlist", "bindlist", "retcode", "newusrrecmd", "rcpuin"}, new Object[]{null, null, 0, null, 0L}, qqshop$SQQSHPClientRsp.class);
    public final PBRepeatMessageField<qqshop$SQQSHPRecmdAccount> recmdlist = PBField.initRepeatMessage(qqshop$SQQSHPRecmdAccount.class);
    public final PBRepeatMessageField<qqshop$SQQSHPAccoutRelation> bindlist = PBField.initRepeatMessage(qqshop$SQQSHPAccoutRelation.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public qqshop$SQQSHPNewUserRecmd newusrrecmd = new qqshop$SQQSHPNewUserRecmd();
    public final PBUInt64Field rcpuin = PBField.initUInt64(0);
}
