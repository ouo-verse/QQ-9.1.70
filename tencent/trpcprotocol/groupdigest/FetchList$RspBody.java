package tencent.trpcprotocol.groupdigest;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FetchList$RspBody extends MessageMicro<FetchList$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42}, new String[]{"msg_list", "total_count", "jump_url", "is_end", "next_page_cookie"}, new Object[]{null, 0, "", Boolean.FALSE, ""}, FetchList$RspBody.class);
    public final PBRepeatMessageField<FetchList$MsgInfo> msg_list = PBField.initRepeatMessage(FetchList$MsgInfo.class);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBBoolField is_end = PBField.initBool(false);
    public final PBStringField next_page_cookie = PBField.initString("");
}
