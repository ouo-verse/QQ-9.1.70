package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZMomentWriter$StGetNextPublishLeftRsp extends MessageMicro<QZMomentWriter$StGetNextPublishLeftRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"nextPublishLeft"}, new Object[]{0L}, QZMomentWriter$StGetNextPublishLeftRsp.class);
    public final PBUInt64Field nextPublishLeft = PBField.initUInt64(0);
}
