package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StCellBottomRecomm extends MessageMicro<QZoneBaseMeta$StCellBottomRecomm> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"title", "icon_token", "action_url", "recomm_type"}, new Object[]{"", "", "", 0}, QZoneBaseMeta$StCellBottomRecomm.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField icon_token = PBField.initString("");
    public final PBStringField action_url = PBField.initString("");
    public final PBEnumField recomm_type = PBField.initEnum(0);
}
