package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc7$SpecialInfo extends MessageMicro<submsgtype0xc7$SpecialInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{null}, submsgtype0xc7$SpecialInfo.class);
    public final PBRepeatMessageField<submsgtype0xc7$SpeciesFlag> list = PBField.initRepeatMessage(submsgtype0xc7$SpeciesFlag.class);
}
