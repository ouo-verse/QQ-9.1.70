package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetStarRedDot$WelfareItem extends MessageMicro<GetStarRedDot$WelfareItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"id", "name", "wish", "cover_url", "jump_url"}, new Object[]{0, "", "", "", ""}, GetStarRedDot$WelfareItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f436053id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField wish = PBField.initString("");
    public final PBStringField cover_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
