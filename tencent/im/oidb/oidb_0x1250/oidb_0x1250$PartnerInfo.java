package tencent.im.oidb.oidb_0x1250;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0x1250$PartnerInfo extends MessageMicro<oidb_0x1250$PartnerInfo> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f436013id = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public oidb_0x1250$PartnerLightInteraction light_interaction = new oidb_0x1250$PartnerLightInteraction();
    public final PBBoolField is_bind = PBField.initBool(false);
    public final PBStringField status_intro = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
    public final PBBoolField is_new = PBField.initBool(false);
    public final PBUInt64Field new_time = PBField.initUInt64(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 56, 64, 72}, new String[]{"id", "name", "icon_url", "light_interaction", "is_bind", "status_intro", "status", "is_new", "new_time"}, new Object[]{0L, "", "", null, bool, "", 0, bool, 0L}, oidb_0x1250$PartnerInfo.class);
    }
}
