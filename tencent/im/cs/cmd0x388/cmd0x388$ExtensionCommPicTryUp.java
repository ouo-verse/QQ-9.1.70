package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes29.dex */
public final class cmd0x388$ExtensionCommPicTryUp extends MessageMicro<cmd0x388$ExtensionCommPicTryUp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_bytes_extinfo"}, new Object[]{ByteStringMicro.EMPTY}, cmd0x388$ExtensionCommPicTryUp.class);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_extinfo = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
