package tencent.im.oidb.cmd0xf57;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xf57$OfficialMedalInfoExt extends MessageMicro<cmd0xf57$OfficialMedalInfoExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_offical", "icon_url"}, new Object[]{Boolean.FALSE, ""}, cmd0xf57$OfficialMedalInfoExt.class);
    public final PBBoolField is_offical = PBField.initBool(false);
    public final PBStringField icon_url = PBField.initString("");
}
