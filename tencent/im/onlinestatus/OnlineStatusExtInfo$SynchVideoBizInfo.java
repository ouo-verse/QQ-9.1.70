package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusExtInfo$SynchVideoBizInfo extends MessageMicro<OnlineStatusExtInfo$SynchVideoBizInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"string_cid", "string_tvURL", "synch_type"}, new Object[]{"", "", 0}, OnlineStatusExtInfo$SynchVideoBizInfo.class);
    public final PBStringField string_cid = PBField.initString("");
    public final PBStringField string_tvURL = PBField.initString("");
    public final PBUInt32Field synch_type = PBField.initUInt32(0);
}
