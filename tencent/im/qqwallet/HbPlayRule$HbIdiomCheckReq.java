package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class HbPlayRule$HbIdiomCheckReq extends MessageMicro<HbPlayRule$HbIdiomCheckReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uin", "inputIdiom", "subchannel"}, new Object[]{0L, "", 0}, HbPlayRule$HbIdiomCheckReq.class);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBStringField inputIdiom = PBField.initString("");
    public final PBEnumField subchannel = PBField.initEnum(0);
}
