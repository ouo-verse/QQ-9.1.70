package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoLike$UserAttitudeOption extends MessageMicro<TVideoLike$UserAttitudeOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"user_attitude", "attitude_counts"}, new Object[]{null, 0}, TVideoLike$UserAttitudeOption.class);
    public TVideoLike$UserAttitudeInfo user_attitude = new TVideoLike$UserAttitudeInfo();
    public final PBInt32Field attitude_counts = PBField.initInt32(0);
}
