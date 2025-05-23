package trpc.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CsCommon$RecomAvatarIcon extends MessageMicro<CsCommon$RecomAvatarIcon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"portrait_id", "is_dynamic", "icon_url", "cover_index"}, new Object[]{0, Boolean.FALSE, "", 0}, CsCommon$RecomAvatarIcon.class);
    public final PBUInt32Field portrait_id = PBField.initUInt32(0);
    public final PBBoolField is_dynamic = PBField.initBool(false);
    public final PBStringField icon_url = PBField.initString("");
    public final PBUInt32Field cover_index = PBField.initUInt32(0);
}
