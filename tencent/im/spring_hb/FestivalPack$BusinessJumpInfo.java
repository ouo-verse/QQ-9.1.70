package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$BusinessJumpInfo extends MessageMicro<FestivalPack$BusinessJumpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"url", "hint", "type", "report"}, new Object[]{"", "", 0, ""}, FestivalPack$BusinessJumpInfo.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField hint = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField report = PBField.initString("");
}
