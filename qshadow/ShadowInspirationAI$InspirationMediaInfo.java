package qshadow;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowInspirationAI$InspirationMediaInfo extends MessageMicro<ShadowInspirationAI$InspirationMediaInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{Global.TRACKING_URL, "RawData", "MediaType", "StringData", "Index"}, new Object[]{"", ByteStringMicro.EMPTY, 0, "", 0}, ShadowInspirationAI$InspirationMediaInfo.class);
    public final PBStringField URL = PBField.initString("");
    public final PBBytesField RawData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField MediaType = PBField.initEnum(0);
    public final PBStringField StringData = PBField.initString("");
    public final PBUInt32Field Index = PBField.initUInt32(0);
}
