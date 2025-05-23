package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusShareInfo$StatusDesc extends MessageMicro<OnlineStatusShareInfo$StatusDesc> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"status", "ex_status"}, new Object[]{0, 0}, OnlineStatusShareInfo$StatusDesc.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field ex_status = PBField.initUInt32(0);
}
