package tencent.kandian.im.apn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class PushComponentExtPB$MsgBody extends MessageMicro<PushComponentExtPB$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"articleIds", "foldStatus", "algoId", "strategyId", "subscripts", "pushExtData"}, new Object[]{"", "", "", "", "", ByteStringMicro.EMPTY}, PushComponentExtPB$MsgBody.class);
    public final PBStringField articleIds = PBField.initString("");
    public final PBStringField foldStatus = PBField.initString("");
    public final PBStringField algoId = PBField.initString("");
    public final PBStringField strategyId = PBField.initString("");
    public final PBStringField subscripts = PBField.initString("");
    public final PBBytesField pushExtData = PBField.initBytes(ByteStringMicro.EMPTY);
}
