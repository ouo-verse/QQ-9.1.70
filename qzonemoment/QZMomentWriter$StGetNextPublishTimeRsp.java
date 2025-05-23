package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZMomentWriter$StGetNextPublishTimeRsp extends MessageMicro<QZMomentWriter$StGetNextPublishTimeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"nextPublishTime"}, new Object[]{0L}, QZMomentWriter$StGetNextPublishTimeRsp.class);
    public final PBUInt64Field nextPublishTime = PBField.initUInt64(0);
}
