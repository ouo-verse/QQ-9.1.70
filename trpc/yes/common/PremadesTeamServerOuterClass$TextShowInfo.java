package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$TextShowInfo extends MessageMicro<PremadesTeamServerOuterClass$TextShowInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "text", "show_type"}, new Object[]{0, "", 0}, PremadesTeamServerOuterClass$TextShowInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f437249id = PBField.initInt32(0);
    public final PBStringField text = PBField.initString("");
    public final PBInt32Field show_type = PBField.initInt32(0);
}
