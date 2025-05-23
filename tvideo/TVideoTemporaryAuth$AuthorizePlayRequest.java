package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class TVideoTemporaryAuth$AuthorizePlayRequest extends MessageMicro<TVideoTemporaryAuth$AuthorizePlayRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 58}, new String[]{"authorize_source", "authorize_pgid", "qimei36", "vid", "authorize_count", "time_stamp", "sign"}, new Object[]{0, 3, "", "", 0, 0L, ""}, TVideoTemporaryAuth$AuthorizePlayRequest.class);
    public final PBEnumField authorize_source = PBField.initEnum(0);
    public final PBEnumField authorize_pgid = PBField.initEnum(3);
    public final PBStringField qimei36 = PBField.initString("");
    public final PBStringField vid = PBField.initString("");
    public final PBInt32Field authorize_count = PBField.initInt32(0);
    public final PBInt64Field time_stamp = PBField.initInt64(0);
    public final PBStringField sign = PBField.initString("");
}
