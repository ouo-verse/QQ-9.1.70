package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class HbPlayRule$HbIdiomCheckRsp extends MessageMicro<HbPlayRule$HbIdiomCheckRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58}, new String[]{"uin", "status", "suggestIdioms", "hbIdiomLastPY", "hbPoemRule", "remainVerse", "paperwork"}, new Object[]{0L, 0, null, "", "", 0, ""}, HbPlayRule$HbIdiomCheckRsp.class);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBRepeatMessageField<HbPlayRule$IdiomInfo> suggestIdioms = PBField.initRepeatMessage(HbPlayRule$IdiomInfo.class);
    public final PBStringField hbIdiomLastPY = PBField.initString("");
    public final PBStringField hbPoemRule = PBField.initString("");
    public final PBInt32Field remainVerse = PBField.initInt32(0);
    public final PBStringField paperwork = PBField.initString("");
}
