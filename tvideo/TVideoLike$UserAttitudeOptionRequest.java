package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoLike$UserAttitudeOptionRequest extends MessageMicro<TVideoLike$UserAttitudeOptionRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 82}, new String[]{"cid", "vid", "attitude_option_type", "play_back_time", "extra_params"}, new Object[]{"", "", 0, 0L, ""}, TVideoLike$UserAttitudeOptionRequest.class);
    public final PBStringField cid = PBField.initString("");
    public final PBStringField vid = PBField.initString("");
    public final PBInt32Field attitude_option_type = PBField.initInt32(0);
    public final PBInt64Field play_back_time = PBField.initInt64(0);
    public final PBStringField extra_params = PBField.initString("");
}
