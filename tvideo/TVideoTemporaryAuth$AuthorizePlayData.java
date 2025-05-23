package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class TVideoTemporaryAuth$AuthorizePlayData extends MessageMicro<TVideoTemporaryAuth$AuthorizePlayData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"authorize_ret", "authorize_time_stamp", "vid", "authorize_count"}, new Object[]{0, 0L, "", 0}, TVideoTemporaryAuth$AuthorizePlayData.class);
    public final PBInt32Field authorize_ret = PBField.initInt32(0);
    public final PBInt64Field authorize_time_stamp = PBField.initInt64(0);
    public final PBStringField vid = PBField.initString("");
    public final PBInt32Field authorize_count = PBField.initInt32(0);
}
