package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiSmobaOuterClass$WujiSmobaEquipConf extends MessageMicro<WujiSmobaOuterClass$WujiSmobaEquipConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "icon"}, new Object[]{0, ""}, WujiSmobaOuterClass$WujiSmobaEquipConf.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f437268id = PBField.initInt32(0);
    public final PBStringField icon = PBField.initString("");
}
