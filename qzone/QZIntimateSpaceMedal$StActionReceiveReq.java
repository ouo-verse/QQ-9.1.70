package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceMedal$StActionReceiveReq extends MessageMicro<QZIntimateSpaceMedal$StActionReceiveReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"message"}, new Object[]{ByteStringMicro.EMPTY}, QZIntimateSpaceMedal$StActionReceiveReq.class);
    public final PBBytesField message = PBField.initBytes(ByteStringMicro.EMPTY);
}
