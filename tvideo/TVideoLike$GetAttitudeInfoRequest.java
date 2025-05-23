package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoLike$GetAttitudeInfoRequest extends MessageMicro<TVideoLike$GetAttitudeInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"vid", "get_option_type"}, new Object[]{"", 0}, TVideoLike$GetAttitudeInfoRequest.class);
    public final PBStringField vid = PBField.initString("");
    public final PBInt32Field get_option_type = PBField.initInt32(0);
}
