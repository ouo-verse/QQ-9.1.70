package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$GetSpaceCountReq extends MessageMicro<QZIntimateSpaceAlbum$GetSpaceCountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"space_id"}, new Object[]{""}, QZIntimateSpaceAlbum$GetSpaceCountReq.class);
    public final PBRepeatField<String> space_id = PBField.initRepeat(PBStringField.__repeatHelper__);
}
