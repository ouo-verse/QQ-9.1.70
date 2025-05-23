package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneReddotWriter$ClearReddotsReq extends MessageMicro<qzoneReddotWriter$ClearReddotsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"clear_info"}, new Object[]{null}, qzoneReddotWriter$ClearReddotsReq.class);
    public final PBRepeatMessageField<qzoneReddotWriter$ClearInfo> clear_info = PBField.initRepeatMessage(qzoneReddotWriter$ClearInfo.class);
}
