package tencent.im.oidb.cmd0x799;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x799$ReqBody extends MessageMicro<oidb_0x799$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"StrTopicIdList"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x799$ReqBody.class);
    public final PBRepeatField<ByteStringMicro> StrTopicIdList = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
