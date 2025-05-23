package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc7$SpeciesFlag extends MessageMicro<submsgtype0xc7$SpeciesFlag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"flag_id", "special_type"}, new Object[]{0, 0}, submsgtype0xc7$SpeciesFlag.class);
    public final PBInt32Field flag_id = PBField.initInt32(0);
    public final PBInt32Field special_type = PBField.initInt32(0);
}
