package tencent.im.oidb.oidb_0x1250;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class oidb_0x1250$PartnerLightInteraction extends MessageMicro<oidb_0x1250$PartnerLightInteraction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"default_intro", "clcik_intro"}, new Object[]{"", ""}, oidb_0x1250$PartnerLightInteraction.class);
    public final PBStringField default_intro = PBField.initString("");
    public final PBStringField clcik_intro = PBField.initString("");
}
