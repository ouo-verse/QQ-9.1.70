package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$SmobaHero extends MessageMicro<GameDataServerOuterClass$SmobaHero> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"id", "name", "type", "lane_type", "icon"}, new Object[]{0, "", 0, 0, ""}, GameDataServerOuterClass$SmobaHero.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f437241id = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field lane_type = PBField.initInt32(0);
    public final PBStringField icon = PBField.initString("");
}
