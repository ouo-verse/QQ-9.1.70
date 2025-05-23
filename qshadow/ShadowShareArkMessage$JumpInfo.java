package qshadow;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowShareArkMessage$JumpInfo extends MessageMicro<ShadowShareArkMessage$JumpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"jumpType", WadlProxyConsts.KEY_JUMP_URL, "schemaPrefix", "schemaExtra"}, new Object[]{0, "", "", ""}, ShadowShareArkMessage$JumpInfo.class);
    public final PBEnumField jumpType = PBField.initEnum(0);
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField schemaPrefix = PBField.initString("");
    public final PBStringField schemaExtra = PBField.initString("");
}
