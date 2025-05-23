package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$Info extends MessageMicro<mutualmark$Info> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 58, 74, 82, 88}, new String[]{"id", "intro", "category", "display_order", "rarity", "new_time", "icon_format", "action", "graded", "flag"}, new Object[]{0L, "", 0, 0, 0, 0L, "", null, null, 0L}, mutualmark$Info.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435957id = PBField.initUInt64(0);
    public final PBStringField intro = PBField.initString("");
    public final PBUInt32Field category = PBField.initUInt32(0);
    public final PBUInt32Field display_order = PBField.initUInt32(0);
    public final PBUInt32Field rarity = PBField.initUInt32(0);
    public final PBUInt64Field new_time = PBField.initUInt64(0);
    public final PBStringField icon_format = PBField.initString("");
    public final PBRepeatMessageField<mutualmark$Button> action = PBField.initRepeatMessage(mutualmark$Button.class);
    public final PBRepeatMessageField<mutualmark$Graded> graded = PBField.initRepeatMessage(mutualmark$Graded.class);
    public final PBUInt64Field flag = PBField.initUInt64(0);
}
